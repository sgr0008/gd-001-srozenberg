package com.backend.service;

import com.backend.business.service.user.UserService;
import com.backend.domain.model.User;
import com.backend.infrastructure.controller.UserController;
import com.backend.infrastructure.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserTest {
    @WebMvcTest(UserController.class)
    static
    class UserControllerTest {

        @ExtendWith(MockitoExtension.class)
        public class UserServiceTest {
            @Mock
            private UserRepository userRepository;

            @InjectMocks
            private UserService userService;

            @Test
            public void testGetAllUsers() {
                // Arrange
                List<User> expectedUsers = Arrays.asList(new User(1l,"Usuario1_test",20241110), new User(2l,"Usuario2_test",20241110));

                // Mock the UserRepository to return the expected users
                when(userRepository.findAll()).thenReturn(expectedUsers);

                // Act
                List<User> actualUsers = userService.findAll();

                // Assert
                assertEquals(expectedUsers, actualUsers);
            }
        }
    }
}
