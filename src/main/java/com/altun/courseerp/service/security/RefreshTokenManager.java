package com.altun.courseerp.service.security;

import com.altun.courseerp.models.dto.RefreshTokenDto;
import com.altun.courseerp.models.mybatis.user.User;
import com.altun.courseerp.models.properties.security.SecurityProperties;
import com.altun.courseerp.service.base.TokenGenerator;
import com.altun.courseerp.service.base.TokenReader;
import com.altun.courseerp.service.getters.EmailGetter;
import com.altun.courseerp.utils.PublicPrivateKeyUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.altun.courseerp.constrants.TokenConstrants.EMAIL;

@Component
@Slf4j
@RequiredArgsConstructor
public class RefreshTokenManager implements TokenGenerator<RefreshTokenDto>, TokenReader<Claims>, EmailGetter {


    private final SecurityProperties securityProperties;
    @Override
    public String generate(RefreshTokenDto obj) {
        User user = obj.getUser();
        Claims claims = Jwts.claims();
        claims.put("email",user.getEmail());
        claims.put("type","REFRESH_TOKEN");

        Date now = new Date();
        Date exp = new Date(now.getTime()+securityProperties.getJwt().getRefreshTokenValidityTime(obj.isRememberMe()));


        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(exp)
                .setIssuedAt(now)
                .addClaims(claims)
                .signWith(PublicPrivateKeyUtils.getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }


    @Override
    public Claims read(String token) {


        Claims tokenData = Jwts.parserBuilder()
                .setSigningKey(PublicPrivateKeyUtils.getPrivateKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        String typeOfToken = tokenData.get("type", String.class);
        if (!typeOfToken.equals("REFRESH_TOKEN")){
            throw new RuntimeException("Invalid type of token");
        }
        return tokenData;
    }

    @Override
    public String getEmail(String token) {
        return read(token).get(EMAIL,String.class);
    }
}