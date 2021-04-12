package com.sda.spring.boot.rest.sample.domain.parent;

import com.sda.spring.boot.rest.sample.domain.child.Child;

import javax.persistence.*;
import java.time.Instant;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// TIP: prefix tables with app name
@Entity
@Table(name = "app_parent")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    // TIP: use set to avoid multiple queries
    // https://stackoverflow.com/questions/6562673/onetomany-list-vs-set-difference
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<Child> children = new HashSet<>();

    // TIP: use a last modified date for audit
    @Column(name = "last_modified_date")
    private Instant lastModifiedDate;

    // TIP: needed by hibernate
    public Parent() {
    }

    // TIP: use constructor to set fields
    public Parent(String name) {
        this.name = name;
    }

    // TIP: do not use setters
    public Long getId() {
        return id;
    }

    // TIP: use getn to generate getter
    public String getName() {
        return name;
    }

    // TIP: use immutable collection
    public Set<Child> getChildren() {
        return Collections.unmodifiableSet(children);
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    @PrePersist
    private void prePersist() {
        this.lastModifiedDate = Instant.now();
    }

    // TIP: compare entities by id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return Objects.equals(id, parent.id);
    }

    // TIP: use helper methods for bidirectional sync
    public void addChild(Child child) {
        this.children.add(child);
        child.setParent(this);
    }

    public void removeChild(Child child) {
        this.children.remove(child);
        child.setParent(null);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TIP: do not print
    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
