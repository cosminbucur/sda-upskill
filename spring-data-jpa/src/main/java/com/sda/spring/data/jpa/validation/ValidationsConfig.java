package com.sda.spring.data.jpa.validation;

import com.sda.spring.data.jpa.validation.dto.UserReadDto;
import com.sda.spring.data.jpa.validation.dto.UserWriteDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Configuration
public class ValidationsConfig {

    private static final Logger log = LoggerFactory.getLogger(ValidationsConfig.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Bean
    public CommandLineRunner validationsData() {
        return args -> {
            testValidations();
            testService();
        };
    }

    private void testValidations() {
        User user = createUser();
        validateBeforeSave(user);

        User badUser = createBadUser();
        validateBeforeSave(badUser);
    }

    private User createUser() {
        User user = new User();
        user.setName("jon snow");
        user.setEmail("jonsnow@gmail.com");
        user.setAge(30);
        user.setConsented(true);
        user.setAboutMe("I'm a watcher on the wall");
        return user;
    }

    private User createBadUser() {
        User user = new User();
        user.setName("");
        user.setEmail("jonsnowgmail.com");
        user.setAge(5);
        user.setConsented(false);
        user.setAboutMe("...");
        return user;
    }

    private void validateBeforeSave(User user) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
        long violations = constraintViolations.size();

        if (violations > 0) {
            log.error("user not saved {}", user);
            constraintViolations
                    .forEach(violation -> log.error("violation: {}", violation.getMessage()));
        } else {
            userRepository.save(user);
        }
    }

    private void testService() {
        UserWriteDto saveDto = new UserWriteDto();
        saveDto.setName("paul");
        saveDto.setEmail("paul@gmail.com");
        saveDto.setConsented(true);
        saveDto.setAge(20);
        saveDto.setAboutMe("learn to code every day");

        UserReadDto savedDto = userService.save(saveDto);

        List<UserReadDto> allUserReadDto = userService.findAll();

        User foundUserDto = userService.findById(savedDto.getId())
                .orElseThrow(() -> new RuntimeException("user not found"));

        UserWriteDto updateDto = new UserWriteDto();
        updateDto.setName("anna");
        updateDto.setEmail("anna@gmail.com");
        updateDto.setConsented(true);
        updateDto.setAge(30);
        updateDto.setAboutMe("retired and happy");
        UserReadDto updatedDto = userService.update(savedDto.getId(), updateDto);

        userService.delete(savedDto.getId());
    }

}
