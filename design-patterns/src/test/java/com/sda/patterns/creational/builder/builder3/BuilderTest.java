package com.sda.patterns.creational.builder.builder3;

import com.sda.patterns.creational.builder3.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BuilderTest {

    @Test
    void givenBuilders_whenBuild_thenReturnOk() {
        // given
        HouseBuilder strawHouseBuilder = new StrawHouseBuilder();
        HouseBuilder woodHouseBuilder = new WoodHouseBuilder();
        HouseBuilder brickHouseBuilder = new BrickHouseBuilder();

        Pig lazyPig = new Pig(strawHouseBuilder);
        Pig dumbPig = new Pig(woodHouseBuilder);
        Pig smartPig = new Pig(brickHouseBuilder);

        // when
        House strawHouse = lazyPig.build();
        House woodHouse = dumbPig.build();
        House brickHouse = smartPig.build();

        // then
        assertThat(strawHouse.getFoundation()).isEqualTo("straw");
        assertThat(woodHouse.getFoundation()).isEqualTo("wood");
        assertThat(brickHouse.getFoundation()).isEqualTo("brick");
    }
}