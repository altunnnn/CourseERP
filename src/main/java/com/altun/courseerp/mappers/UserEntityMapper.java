package com.altun.courseerp.mappers;

import com.altun.courseerp.models.mybatis.user.User;
import com.altun.courseerp.payload.auth.SignUpPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE) //bu o demekdir ki user icerisinde map ola bilmeyen field olsa ignore elesin
public interface UserEntityMapper {

    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class); //bu default configdi

    @Mapping(target = "password", source = "encryptedPassword") // gelen passwordu encrypt elemek ucun
    @Mapping(target = "status", constant = "ACTIVE") // status fieldi signupda olmadigi ucun default active qebul edirik
    @Mapping(target = "roleId", source = "roleId") // target - tabledeki column adidi, source ise metodun parametridir
    User fromSignUpPayloadToUser(SignUpPayload payload, String encryptedPassword, Long roleId); //bele bir metod yaradirsan hansiki signupdan gelen datani Usere map eleyir
}
