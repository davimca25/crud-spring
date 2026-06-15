package com.example.demo.repository;

import com.example.demo.dto.UserResponseDTO;
import com.example.demo.entity.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should get User sucessfully from DB")
    void findUserByIdSucess(){
        long id = 1L;
        UserResponseDTO data = new UserResponseDTO(id, "Davi", "davi@icloud.com");
        this.createUser(data);

        Optional<User> result = this.userRepository.findById(id);

        assertThat(result.isPresent()).isTrue();

    }

    @Test
    @DisplayName("Should not get User from DB when user not exists")
    void findUserByIdFailure(){
        long id = 12L;

        Optional<User> result = this.userRepository.findById(id);

        assertThat(result.isEmpty()).isTrue();

    }

    private User createUser(UserResponseDTO data){
        User newUser = new User(data);
        this.entityManager.persist(newUser);
        return newUser;

    }
}