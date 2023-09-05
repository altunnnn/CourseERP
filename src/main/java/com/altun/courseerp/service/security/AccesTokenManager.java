package com.altun.courseerp.service.security;

import com.altun.courseerp.models.mybatis.user.User;
import com.altun.courseerp.models.properties.security.SecurityProperties;
import com.altun.courseerp.service.base.TokenGenerator;
import com.altun.courseerp.service.base.TokenReader;
import com.altun.courseerp.utils.PublicPrivateKeyUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor
public class AccesTokenManager implements TokenGenerator<User>, TokenReader<Claims> {


    private final SecurityProperties securityProperties;


    @Override
    public String generate(User obj) {
        Claims claims = Jwts.claims();
        claims.put("email",obj.getEmail());

        Date now = new Date();
        Date exp = new Date(now.getTime()+securityProperties.getJwt().getAccessTokenValidityTime());


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
    /*    User user = User.builder().email("altun@email.com").build();
        user.setId(1L);*/


        return Jwts.parserBuilder()
                .setSigningKey(PublicPrivateKeyUtils.getPrivateKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
