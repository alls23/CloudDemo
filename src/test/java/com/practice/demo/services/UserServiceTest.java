package com.practice.demo.services;

import com.practice.demo.models.User;
import com.practice.demo.repositories.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    IUserRepository userRepository;

    @Test
    public void testCreateUser() {
        User user = new User(1L, "lol");
        when(userRepository.save(user)).thenReturn(user);

        Assertions.assertEquals(user, this.userService.createUser(user));
    }

}
