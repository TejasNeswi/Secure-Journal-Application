package com.springBoot.journalApp.service;

import com.springBoot.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.springframework.security.core.userdetails.User.*;

@SpringBootTest
public class UserDetailsServiceImplTests  {

    @Autowired
    private UsersDetailsServiceImplementation usersDetailsServiceImplementation;

    @MockBean
    private UserRepository userRepository;

    @Disabled
    @Test
    void loadUserByUserNameTests()
    {
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn((com.springBoot.journalApp.entity.User) builder().username("Ram").password("hello123").build());
        UserDetails user = usersDetailsServiceImplementation.loadUserByUsername("Ram");
        Assertions.assertNotNull(user);
    }
}
