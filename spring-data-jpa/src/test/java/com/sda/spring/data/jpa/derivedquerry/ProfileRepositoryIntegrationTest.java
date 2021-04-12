package com.sda.spring.data.jpa.derivedquerry;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = DerivedQueryApplication.class)
class ProfileRepositoryIntegrationTest {

    private static final String PROFILE_NAME_PAUL = "paul";
    private static final String PROFILE_NAME_ANA = "anna";
    private static final ZonedDateTime BIRTHDATE = ZonedDateTime.now();

    @Autowired
    private ProfileRepository profileRepository;

    @BeforeEach
    void setUp() {
        Profile profile1 = new Profile(PROFILE_NAME_PAUL, 25, BIRTHDATE, true);
        Profile profile2 = new Profile(PROFILE_NAME_PAUL, 20, BIRTHDATE, false);
        Profile profile3 = new Profile(PROFILE_NAME_ANA, 20, BIRTHDATE, true);
        Profile profile4 = new Profile(null, 30, BIRTHDATE, false);

        profileRepository.saveAll(Arrays.asList(profile1, profile2, profile3, profile4));
    }

    @AfterEach
    void tearDown() {
        profileRepository.deleteAll();
    }

    @Test
    void whenFindByName_thenReturnsCorrectResult() {
        assertThat(profileRepository.findByName(PROFILE_NAME_PAUL).size()).isEqualTo(2);
    }

    @Test
    void whenFindByNameIsNull_thenReturnsCorrectResult() {
        assertThat(profileRepository.findByNameIsNull().size()).isEqualTo(1);
    }

    @Test
    void whenFindByNameNot_thenReturnsCorrectResult() {
        assertThat(profileRepository.findByNameNot(PROFILE_NAME_PAUL).get(0).getName()).isEqualTo(PROFILE_NAME_ANA);
    }

    @Test
    void whenFindByNameStartingWith_thenReturnsCorrectResult() {
        assertThat(profileRepository.findByNameStartingWith("p").size()).isEqualTo(2);
    }

    @Test
    void whenFindByNameEndingWith_thenReturnsCorrectResult() {
        assertThat(profileRepository.findByNameEndingWith("a").size()).isEqualTo(1);
    }

    @Test
    void whenByNameContaining_thenReturnsCorrectResult() {
        assertThat(profileRepository.findByNameContaining("n").size()).isEqualTo(1);
    }

    @Test
    void whenByNameLike_thenReturnsCorrectResult() {
        assertThat(profileRepository.findByNameLike("%ul%").size()).isEqualTo(2);
    }

    @Test
    void whenByAgeLessThan_thenReturnsCorrectResult() {
        assertThat(profileRepository.findByAgeLessThan(25).size()).isEqualTo(2);
    }

    @Test
    void whenByAgeLessThanEqual_thenReturnsCorrectResult() {
        assertThat(profileRepository.findByAgeLessThanEqual(25).size()).isEqualTo(3);
    }

    @Test
    void whenByAgeGreaterThan_thenReturnsCorrectResult() {
        assertThat(profileRepository.findByAgeGreaterThan(25).size()).isEqualTo(1);
    }

    @Test
    void whenByAgeGreaterThanEqual_thenReturnsCorrectResult() {
        assertThat(profileRepository.findByAgeGreaterThanEqual(25).size()).isEqualTo(2);
    }

    @Test
    void whenByAgeBetween_thenReturnsCorrectResult() {
        assertThat(profileRepository.findByAgeBetween(20, 30).size()).isEqualTo(4);
    }

    @Test
    void whenByBirthDateAfter_thenReturnsCorrectResult() {
        final ZonedDateTime yesterday = BIRTHDATE.minusDays(1);
        assertThat(profileRepository.findByBirthDateAfter(yesterday).size()).isEqualTo(4);
    }

    @Test
    void whenByBirthDateBefore_thenReturnsCorrectResult() {
        final ZonedDateTime yesterday = BIRTHDATE.minusDays(1);
        assertThat(profileRepository.findByBirthDateBefore(yesterday).size()).isZero();
    }

    @Test
    void whenByActiveTrue_thenReturnsCorrectResult() {
        assertThat(profileRepository.findByActiveTrue().size()).isEqualTo(2);
    }

    @Test
    void whenByActiveFalse_thenReturnsCorrectResult() {
        assertThat(profileRepository.findByActiveFalse().size()).isEqualTo(2);
    }

    @Test
    void whenByAgeIn_thenReturnsCorrectResult() {
        final List<Integer> ages = Arrays.asList(20, 25);
        assertThat(profileRepository.findByAgeIn(ages).size()).isEqualTo(3);
    }

    @Test
    void whenByNameOrBirthDate() {
        assertThat(profileRepository.findByNameOrBirthDate(PROFILE_NAME_PAUL, BIRTHDATE).size())
                .isEqualTo(4);
    }

    @Test
    void whenByNameOrBirthDateAndActive() {
        assertThat(profileRepository.findByNameOrBirthDateAndActive(PROFILE_NAME_PAUL, BIRTHDATE, false).size())
                .isEqualTo(3);
    }

    @Test
    void whenByNameOrderByName() {
        assertThat(profileRepository.findByNameOrderByName(PROFILE_NAME_PAUL).size()).isEqualTo(2);
    }

    @Test
    void whenByNameOrderByNameDesc() {
        assertThat(profileRepository.findByNameOrderByNameDesc(PROFILE_NAME_PAUL).size()).isEqualTo(2);
    }

    @Test
    void whenDeleteByName() {
        assertThat(profileRepository.deleteByName(PROFILE_NAME_PAUL)).isEqualTo(2);
    }

    @Test
    void whenDeleteByActive() {
        List<Profile> profiles = profileRepository.deleteByActive(true);

        assertThat(profiles.size()).isEqualTo(2);
    }

}