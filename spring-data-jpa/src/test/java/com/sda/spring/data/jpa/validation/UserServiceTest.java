package com.sda.spring.data.jpa.validation;

import com.sda.spring.data.jpa.validation.dto.UserReadDto;
import com.sda.spring.data.jpa.validation.dto.UserWriteDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void whenValidInput_thenReturnOk() {
        UserWriteDto dto = new UserWriteDto();
        dto.setName("jon snow");
        dto.setEmail("jonsnow@gmail.com");
        dto.setAge(30);
        dto.setConsented(true);
        dto.setAboutMe("I'm a watcher on the wall");

        UserReadDto actual = userService.save(dto);

        assertThat(actual).isNotNull();
    }

    @Test
    void whenInvalidInput_thenThrowException() {
        UserWriteDto dto = new UserWriteDto();
        dto.setName("");
        dto.setEmail("jonsnowgmail.com");
        dto.setAge(5);
        dto.setConsented(false);
        dto.setAboutMe("...");

        assertThrows(ConstraintViolationException.class,
                () -> userService.save(dto));
    }
}