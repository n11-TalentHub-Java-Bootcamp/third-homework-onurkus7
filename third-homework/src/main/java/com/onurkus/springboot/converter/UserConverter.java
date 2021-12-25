package com.onurkus.springboot.converter;

import com.onurkus.springboot.dto.UserDto;
import com.onurkus.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    @Mapping(source = "id",target = "id")
    @Mapping(source = "firstName",target = "firstName")
    @Mapping(source = "lastName",target = "lastName")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "phoneNumber",target = "phoneNumber")
    @Mapping(source = "userName",target = "userName")
    List<UserDto> convertAllUserListToUserDtoList(List<User> userList);

    @Mapping(source = "id",target = "id")
    @Mapping(source = "firstName",target = "firstName")
    @Mapping(source = "lastName",target = "lastName")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "phoneNumber",target = "phoneNumber")
    @Mapping(source = "userName",target = "userName")
    UserDto convertFromUserToUserDto(User user);

    @Mapping(source = "id",target = "id")
    @Mapping(source = "firstName",target = "firstName")
    @Mapping(source = "lastName",target = "lastName")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "phoneNumber",target = "phoneNumber")
    @Mapping(source = "userName",target = "userName")
    User convertFromUserDtoToUser(UserDto userDto);


}
