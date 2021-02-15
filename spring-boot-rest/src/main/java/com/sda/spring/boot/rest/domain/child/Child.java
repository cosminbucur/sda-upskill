package com.sda.spring.boot.rest.domain.child;

import com.sda.spring.boot.rest.domain.childinfo.ChildInfo;
import com.sda.spring.boot.rest.domain.parent.Parent;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "app_child")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    // TIP: save enums as strings or number
    @Enumerated(EnumType.STRING)
    private ChildType childType;

    private boolean active;

    // TIP: use fetch type lazy
    // TIP: use join column to avoid an extra table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @OneToOne(mappedBy = "child", cascade = CascadeType.ALL)
    private ChildInfo childInfo;

    public Child() {
    }

    public Child(String code, ChildType childType) {
        this.code = code;
        this.childType = childType;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Parent getParent() {
        return parent;
    }

    // TIP: use setter for parent for bidirectional sync
    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Objects.equals(id, child.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: change these at the end
    // TIP: print parent
    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", parent=" + parent +
                ", code='" + code + '\'' +
                '}';
    }
}
