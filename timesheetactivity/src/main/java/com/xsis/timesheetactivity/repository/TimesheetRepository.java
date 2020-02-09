package com.xsis.timesheetactivity.repository;

import com.xsis.timesheetactivity.model.dto.TimesheetDto;
import com.xsis.timesheetactivity.model.entity.TimesheetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TimesheetRepository extends JpaRepository<TimesheetEntity, Integer>
{
    @Query(nativeQuery = true)
    List<TimesheetDto> viewTimesheet();

    @Query(nativeQuery = true)
    List<TimesheetDto> searchTimesheetByDateAsc(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("rpg") Integer rpg, @Param("page") Integer page);

    @Query(nativeQuery = true)
    List<TimesheetDto> searchTimesheetByDateDesc(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("rpg") Integer rpg, @Param("page") Integer page);
}
