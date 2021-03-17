package com.sda.spring.data.jpa.customquery;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CustomQueryApplication.class)
class PlayerRepositoryIntegrationTest {

    private static final String PLAYER_NAME_PAUL = "paul";
    private static final String PLAYER_NAME_ANA = "anna";
    private static final ZonedDateTime BIRTHDATE = ZonedDateTime.now();

    @Autowired
    private PlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
        Player player1 = new Player(PLAYER_NAME_PAUL, 25, BIRTHDATE, true);
        Player player2 = new Player(PLAYER_NAME_PAUL, 20, BIRTHDATE, false);
        Player player3 = new Player(PLAYER_NAME_ANA, 20, BIRTHDATE, true);
        Player player4 = new Player(null, 30, BIRTHDATE, false);

        playerRepository.saveAll(Arrays.asList(player1, player2, player3, player4));
    }

    @AfterEach
    void tearDown() {
        playerRepository.deleteAll();
    }

    @Transactional
    @Test
    void whenSave_thenReturnsCorrectResult() {
        assertThat(playerRepository.save(5L, PLAYER_NAME_PAUL, true)).isEqualTo(1);
    }

    @Test
    void whenFindByName_thenReturnsCorrectResult() {
        assertThat(playerRepository.findByName(PLAYER_NAME_PAUL).size()).isEqualTo(2);
    }

    @Test
    void whenFindByNameIsNull_thenReturnsCorrectResult() {
        assertThat(playerRepository.findByNameIsNull().size()).isEqualTo(1);
    }

    @Test
    void whenFindByNameNot_thenReturnsCorrectResult() {
        assertThat(playerRepository.findByNameNot(PLAYER_NAME_PAUL).get(0).getName()).isEqualTo(PLAYER_NAME_ANA);
    }

    @Test
    void whenFindByNameStartingWith_thenReturnsCorrectResult() {
        assertThat(playerRepository.findByNameStartingWith("p").size()).isEqualTo(2);
    }

    @Test
    void whenFindByNameEndingWith_thenReturnsCorrectResult() {
        assertThat(playerRepository.findByNameEndingWith("a").size()).isEqualTo(1);
    }

    @Test
    void whenByNameContaining_thenReturnsCorrectResult() {
        assertThat(playerRepository.findByNameContaining("n").size()).isEqualTo(1);
    }

    @Test
    void whenByNameLike_thenReturnsCorrectResult() {
        assertThat(playerRepository.findByNameLike("%ul%").size()).isEqualTo(2);
    }

    @Test
    void whenByAgeLessThan_thenReturnsCorrectResult() {
        assertThat(playerRepository.findByAgeLessThan(25).size()).isEqualTo(2);
    }

    @Test
    void whenByAgeLessThanEqual_thenReturnsCorrectResult() {
        assertThat(playerRepository.findByAgeLessThanEqual(25).size()).isEqualTo(3);
    }

    @Test
    void whenByAgeGreaterThan_thenReturnsCorrectResult() {
        assertThat(playerRepository.findByAgeGreaterThan(25).size()).isEqualTo(1);
    }

    @Test
    void whenByAgeGreaterThanEqual_thenReturnsCorrectResult() {
        assertThat(playerRepository.findByAgeGreaterThanEqual(25).size()).isEqualTo(2);
    }

    @Test
    void whenByAgeBetween_thenReturnsCorrectResult() {
        assertThat(playerRepository.findByAgeBetween(20, 30).size()).isEqualTo(4);
    }

    @Test
    void whenByBirthDateAfter_thenReturnsCorrectResult() {
        final ZonedDateTime yesterday = BIRTHDATE.minusDays(1);
        assertThat(playerRepository.findByBirthDateAfter(yesterday).size()).isEqualTo(4);
    }

    @Test
    void whenByBirthDateBefore_thenReturnsCorrectResult() {
        final ZonedDateTime yesterday = BIRTHDATE.minusDays(1);
        assertThat(playerRepository.findByBirthDateBefore(yesterday).size()).isZero();
    }

    @Test
    void whenByActiveTrue_thenReturnsCorrectResult() {
        assertThat(playerRepository.findByActiveTrue().size()).isEqualTo(2);
    }

    @Test
    void whenByActiveFalse_thenReturnsCorrectResult() {
        assertThat(playerRepository.findByActiveFalse().size()).isEqualTo(2);
    }

    @Test
    void whenByAgeIn_thenReturnsCorrectResult() {
        final List<Integer> ages = Arrays.asList(20, 25);
        assertThat(playerRepository.findByAgeIn(ages).size()).isEqualTo(3);
    }

    @Test
    void whenByNameOrBirthDate() {
        assertThat(playerRepository.findByNameOrBirthDate(PLAYER_NAME_PAUL, BIRTHDATE).size())
                .isEqualTo(4);
    }

    @Test
    void whenByNameOrBirthDateAndActive() {
        assertThat(playerRepository.findByNameOrBirthDateAndActive(PLAYER_NAME_PAUL, BIRTHDATE, false).size())
                .isEqualTo(3);
    }

    @Test
    void whenByNameOrderByName() {
        assertThat(playerRepository.findByNameOrderByName(PLAYER_NAME_PAUL).size()).isEqualTo(2);
    }

    @Test
    void whenByNameOrderByNameDesc() {
        assertThat(playerRepository.findByNameOrderByNameDesc(PLAYER_NAME_PAUL).size()).isEqualTo(2);
    }

    @Transactional
    @Test
    void whenUpdateName() {
        assertThat(playerRepository.updateName("update when false", false)).isEqualTo(2);
    }

    @Transactional
    @Test
    void whenDeleteByName() {
        assertThat(playerRepository.deleteByName(PLAYER_NAME_PAUL)).isEqualTo(2);
    }

    @Transactional
    @Test
    void whenDeleteByActive() {
        assertThat(playerRepository.deleteByActive(true)).isEqualTo(2);
    }
}