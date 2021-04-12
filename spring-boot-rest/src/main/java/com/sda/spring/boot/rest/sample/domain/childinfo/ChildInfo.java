package com.sda.spring.boot.rest.sample.domain.childinfo;

import com.sda.spring.boot.rest.sample.domain.child.Child;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "app_child_info")
public class ChildInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String registrationNumber;

    @OneToOne
    @JoinColumn(name = "child_id")
    private Child child;

    private Instant startDate;

    public ChildInfo() {
    }

    public Long getId() {
        return id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Child getChild() {
        return child;
    }

    // TIP: use setter for child for bidirectional sync
    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildInfo childInfo = (ChildInfo) o;
        return Objects.equals(id, childInfo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ChildInfo{" +
                "id=" + id +
                ", child=" + child +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
