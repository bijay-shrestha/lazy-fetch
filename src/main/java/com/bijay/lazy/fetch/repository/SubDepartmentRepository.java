package com.bijay.lazy.fetch.repository;

import com.bijay.lazy.fetch.entity.SubDepartment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Repository
public interface SubDepartmentRepository extends JpaRepository<SubDepartment, Long> {

    @Transactional(readOnly = true)
    @Query("Select s from SubDepartment s where id=:id")
    Optional<SubDepartment> findById(@Param("id") Long id);

    @EntityGraph(attributePaths = {"department"})
    Optional<SubDepartment> findWithDepartmentById(Long id);
}
