package com.toby.hello_spring_boot.mapper;

import com.toby.hello_spring_boot.dto.request.UserCreationRequest;
import com.toby.hello_spring_boot.dto.request.UserUpdaeRequest;
import com.toby.hello_spring_boot.dto.response.UserResponse;
import com.toby.hello_spring_boot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    @Mapping(target = "lastName", ignore = true)
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdaeRequest request);
}
