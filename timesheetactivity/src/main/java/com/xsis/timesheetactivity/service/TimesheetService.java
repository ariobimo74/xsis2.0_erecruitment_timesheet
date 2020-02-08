package com.xsis.timesheetactivity.service;

import com.xsis.timesheetactivity.model.dto.TimesheetDto;
import com.xsis.timesheetactivity.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TimesheetService
{
    @Autowired
    private TimesheetRepository timesheetRepository;

    public List<TimesheetDto> getViewtimesheet()
    {
        return timesheetRepository.viewTimesheet();
    }

    public List<TimesheetDto> getSearchTimesheetByDateAsc(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("rpg") Integer rpg, @Param("page") Integer page)
    {
        return timesheetRepository.searchTimesheetByDateAsc(startDate, endDate, rpg, page);
    }

    public List<TimesheetDto> getSearchTimesheetByDateDesc(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("rpg") Integer rpg, @Param("page") Integer page)
    {
        return timesheetRepository.searchTimesheetByDateDesc(startDate, endDate, rpg, page);
    }
}
