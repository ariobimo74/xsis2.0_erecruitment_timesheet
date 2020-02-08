package com.xsis.timesheetactivity.repository;

import com.xsis.timesheetactivity.model.entity.BiodataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiodataRepository extends JpaRepository<BiodataEntity, Integer>
{
}
