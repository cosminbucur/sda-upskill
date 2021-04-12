package com.sda.spring.boot.rest.sample.domain.childinfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;

public interface ChildInfoRepository extends JpaRepository<ChildInfo, Long> {

    @Query("select c.id from ChildInfo c where c.startDate < ?1")
    Page<Long> findAllByStartDateBefore(Instant startDate, Pageable pageable);

    // TODO delete what?
    // https://www.baeldung.com/spring-data-jpa-modifying-annotation
    // TIP: use modifying to execute write operations (even DDL)
    @Modifying
    @Query("delete from Parent p where p.id in(?1)")
    int deleteAllWhereChildIdIn(List<Long> childrenIds);
}
