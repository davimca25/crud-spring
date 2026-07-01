package com.example.demo.mapper;

import com.example.demo.dto.request.RegisterUserRequestDTO;
import com.example.demo.dto.response.RegisterUserResponseDTO;
import com.example.demo.entity.User;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    //@Mapping(source = "email", target = "email") é redundante
    User toEntity(@Valid RegisterUserRequestDTO requestDTO);

    RegisterUserResponseDTO toResponseDTO(User user);

    void updateUserFromDTO (RegisterUserRequestDTO requestDTO, @MappingTarget User user);
}
