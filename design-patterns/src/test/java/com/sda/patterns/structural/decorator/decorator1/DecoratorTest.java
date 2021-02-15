package com.sda.patterns.structural.decorator.decorator1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DecoratorTest {

    /*
        repair bot = 100
        fighter bot = 300
        scanner = 10
        thrusters = 20
        laser = 50
     */

    @Test
    void givenRepairBotWithScanner_shouldComputeCorrectCost() {
        Robot decoratedRobot = new RepairBot();

        decoratedRobot = new Scanner(decoratedRobot);

        assertThat(decoratedRobot.cost()).isEqualTo(110);
    }

    @Test
    void givenRepairBotWithScanner_shouldGetCorrectInfo() {
        Robot decoratedRobot = new RepairBot();

        decoratedRobot = new Scanner(decoratedRobot);

        assertThat(decoratedRobot.getInfo()).isEqualTo("repair bot, scanner");
    }

    @Test
    void givenFighterBotWithFullOption_shouldComputeCorrectCost() {
        Robot decoratedRobot = new FightingBot();

        decoratedRobot = new Scanner(decoratedRobot);
        decoratedRobot = new Thrusters(decoratedRobot);
        decoratedRobot = new Laser(decoratedRobot);

        assertThat(decoratedRobot.getInfo()).isEqualTo("fighting bot, scanner, thrusters, laser");
        assertThat(decoratedRobot.cost()).isEqualTo(380);
    }

    @Test
    void givenFighterBotWithFullOption_shouldGetCorrectInfo() {
        Robot decoratedRobot = new FightingBot();

        decoratedRobot = new Scanner(decoratedRobot);
        decoratedRobot = new Thrusters(decoratedRobot);
        decoratedRobot = new Laser(decoratedRobot);

        assertThat(decoratedRobot.getInfo()).isEqualTo("fighting bot, scanner, thrusters, laser");
    }

}