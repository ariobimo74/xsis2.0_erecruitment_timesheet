package com.xsis.timesheetactivity.controller.rest;

import com.xsis.timesheetactivity.model.dto.TimesheetDto;
import com.xsis.timesheetactivity.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "rest/timesheet")
public class TimesheetRest
{
    @Autowired
    private TimesheetService timesheetService;

    @GetMapping
    public List<TimesheetDto> findViewTimesheet()
    {
        return timesheetService.getViewtimesheet();
    }

    @GetMapping(path = "/asc/search")
    public List<TimesheetDto> findSearchTimesheetByDateAsc(@RequestParam(name = "startDate") Date startDate, @RequestParam(name = "endDate") Date endDate, @RequestParam(name = "rpg") Integer rpg, @RequestParam("page") Integer page)
    {
        Integer x = (rpg*page) - rpg;

        return timesheetService.getSearchTimesheetByDateAsc(startDate, endDate, rpg, x);
    }

    @GetMapping(path = "/desc/search")
    public List<TimesheetDto> findSearchTimesheetByDateDesc(@RequestParam(name = "startDate") Date startDate, @RequestParam(name = "endDate") Date endDate, @RequestParam(name = "rpg") Integer rpg, @RequestParam(name = "page") Integer page)
    {
        Integer x = (rpg*page) - rpg;

        return timesheetService.getSearchTimesheetByDateDesc(startDate, endDate, rpg, x);
    }
}
