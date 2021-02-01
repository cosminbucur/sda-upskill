package com.sda.patterns.creational.builder.builder2;

import com.sda.patterns.creational.builder2.Task;
import com.sda.patterns.creational.builder2.TaskBuilder;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class Builder2Test {

    @Test
    void givenBuilders_whenBuild_thenReturnOk() {
        // given
        Task task = new Task(1L, "summary", "description", true, LocalDate.of(2020, 1, 20));

        // when
        Task actual = new TaskBuilder()
                .setId(1L)
                .setDescription("description")
                .setSummary("summary")
                .setDueDate(LocalDate.of(2020, 1, 20))
                .setDone(true)
                .build();

        // then
        assertThat(actual).isEqualTo(task);
    }
}