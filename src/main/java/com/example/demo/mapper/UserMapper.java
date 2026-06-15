package com.example.demo.mapper;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    //@Mapping(source = "email", target = "email") é redundante
    User toEntity(UserRequestDTO requestDTO);

    UserResponseDTO toResponseDTO(User user);

    void updateUserFromDTO (UserRequestDTO requestDTO, @MappingTarget User user);
}
