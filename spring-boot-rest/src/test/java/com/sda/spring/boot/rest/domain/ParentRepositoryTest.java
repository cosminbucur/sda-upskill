package com.sda.spring.boot.rest.domain;

import com.sda.spring.boot.rest.sample.domain.child.Child;
import com.sda.spring.boot.rest.sample.domain.child.ChildType;
import com.sda.spring.boot.rest.sample.domain.parent.Parent;
import com.sda.spring.boot.rest.sample.domain.parent.ParentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// https://reflectoring.io/spring-boot-data-jpa-test/
// TIP: enable spring support, no longer needed in spring boot 2 (included in @DataJpaTest)
@DataJpaTest
class ParentRepositoryTest {

    @Autowired
    private ParentRepository parentRepository;

    @Test
    void findByName() {
        // given
        Parent parent1 = new Parent("alex");
        Parent parent2 = new Parent("ana");
        parentRepository.save(parent1);
        parentRepository.save(parent2);

        // when
        List<Parent> actual = parentRepository.findByName("ana");

        // then
        assertThat(actual).containsExactly(parent2);
    }

    @Test
    void findById() {
        Child child1 = new Child("C200", ChildType.FIGHTER);
        Child child2 = new Child("B400", ChildType.ASSASSIN);
        Child child3 = new Child("A400", ChildType.ASSASSIN);

        Parent parent = new Parent("alex");
        parent.addChild(child1);
        parent.addChild(child2);
        parent.addChild(child3);
        parentRepository.save(parent);

        Parent actual = parentRepository.findById(1L).get();

        assertThat(actual).isNot(null);
    }

    @Test
    void deleteAllWhereChildIdIn() {
    }
}