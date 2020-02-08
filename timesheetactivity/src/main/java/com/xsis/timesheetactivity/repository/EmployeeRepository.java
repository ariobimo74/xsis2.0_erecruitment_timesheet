package com.xsis.timesheetactivity.repository;

import com.xsis.timesheetactivity.model.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>
{
}
