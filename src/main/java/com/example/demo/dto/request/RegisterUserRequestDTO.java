package com.example.demo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 3, max = 50, message = "Nome deve ter entre 3-50 caracteres") String name,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")String email,

        @NotBlank(message = "Senha é obrigatória.")
        @Size(min = 6) String password) {
}