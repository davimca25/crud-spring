package com.example.demo.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginUserRequestDTO(
        @NotEmpty(message = "Email é obrigatório.") String email,
        @NotEmpty(message = "Senha é obrigatória.") String password
) {
}
