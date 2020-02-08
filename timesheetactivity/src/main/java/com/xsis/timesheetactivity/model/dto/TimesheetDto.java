package com.xsis.timesheetactivity.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TimesheetDto
{
    private Integer id;
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    private Date tanggal;
    private String clientName;
    private String userApproval;
    private String eroStat;

    public TimesheetDto() {
    }

    public TimesheetDto(Integer id, String status, Date tanggal, String clientName, String userApproval, String eroStat) {
        this.id = id;
        this.status = status;
        this.tanggal = tanggal;
        this.clientName = clientName;
        this.userApproval = userApproval;
        this.eroStat = eroStat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getUserApproval() {
        return userApproval;
    }

    public void setUserApproval(String userApproval) {
        this.userApproval = userApproval;
    }

    public String getEroStat() {
        return eroStat;
    }

    public void setEroStat(String eroStat) {
        this.eroStat = eroStat;
    }
}
