package com.springBoot.journalApp.service;

import com.springBoot.journalApp.entity.User;
import com.springBoot.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Disabled
    @Test
    public void testFindByUserName()
    {

        User user = userRepository.findByUserName("Ram");
        assertEquals(4, 2+2);
        assertNotNull(userRepository.findByUserName("Ram"));
        assertTrue(!user.getJournalEntries().isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings={
            "Ram",
            "Shyam",
            "Rahul"
    })
    public void testFindByUserName(String name)
    {
        assertNotNull(userRepository.findByUserName(name), "failed for "+name);
    }


    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,3,5",
            "3,3,9"
    })
    public void add(int a, int b, int expected)
    {
        assertEquals(expected, a+b);
    }
}
