package com.employee.repo;


import com.employee.repo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query("SELECT e FROM EmployeeEntity e WHERE e.city=:city")
    public List<EmployeeEntity> findAllEmployeeByCity(@Param("city") String city);

}
