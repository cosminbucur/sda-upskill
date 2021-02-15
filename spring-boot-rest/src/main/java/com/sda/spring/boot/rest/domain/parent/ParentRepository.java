package com.sda.spring.boot.rest.domain.parent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ParentRepository extends JpaRepository<Parent, Long> {

    // TIP: derived query
    List<Parent> findByName(String name);

    // TIP: custom JPA query
    @Query("select p from Parent p " +
            "left join fetch p.children c " +
            "left join fetch c.childInfo " +
            "where p.id = ?1 " +
            "order by c.code, c.childType")
    Optional<Parent> findById(Long id);

    // TODO: native query
    // TIP: custom native query
    // TIP: native queries are not validated at startup
    @Query(
            value = "select * from app_parent p where p.name = :name",
            nativeQuery = true)
    void stuff();

}
