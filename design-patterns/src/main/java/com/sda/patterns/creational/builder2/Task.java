package com.sda.patterns.creational.builder2;

import java.time.LocalDate;
import java.util.Objects;

public class Task {

    private Long id;
    private String summary;
    private String description;
    private boolean done;
    private LocalDate dueDate;

    public Task() {
    }

    public Task(Long id, String summary, String description, boolean done, LocalDate dueDate) {
        this.id = id;
        this.summary = summary;
        this.description = description;
        this.done = done;
        this.dueDate = dueDate;
    }

    // no setters for immutability

    public long getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return done == task.done && Objects.equals(id, task.id) && Objects.equals(summary, task.summary) && Objects.equals(description, task.description) && Objects.equals(dueDate, task.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, summary, description, done, dueDate);
    }
}
