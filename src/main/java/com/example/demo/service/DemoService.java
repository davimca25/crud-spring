package com.example.demo.service;

 
import com.example.demo.dto.request.LoginUserRequestDTO;
import com.example.demo.dto.request.RegisterUserRequestDTO;
import com.example.demo.dto.response.RegisterUserResponseDTO;
import com.example.demo.exceptions.custom.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public DemoService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public RegisterUserResponseDTO create(@Valid RegisterUserRequestDTO dto) {
        User user = userMapper.toEntity(dto);
        User savedUser = userRepository.save(user);
        return userMapper.toResponseDTO(savedUser);
    }

    public List<RegisterUserResponseDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponseDTO)
                .toList();
    }

    public RegisterUserResponseDTO getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

        return userMapper.toResponseDTO(user);
    }

    public RegisterUserResponseDTO update(Long id, RegisterUserRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

        userMapper.updateUserFromDTO(dto, user);

        User updated = userRepository.save(user);

        return userMapper.toResponseDTO(updated);
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("Usuário não encontrado");
        }
        userRepository.deleteById(id);
    }

    public User save(RegisterUserRequestDTO dto) {
        User user = userMapper.toEntity(dto);

        return userRepository.save(user);
    }


}
