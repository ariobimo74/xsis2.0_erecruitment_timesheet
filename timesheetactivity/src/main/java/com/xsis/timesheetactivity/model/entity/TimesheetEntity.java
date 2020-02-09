package com.xsis.timesheetactivity.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xsis.timesheetactivity.model.CommonEntity;
import com.xsis.timesheetactivity.model.dto.TimesheetDto;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@SqlResultSetMapping(name = "timesheetMapping", classes = {@ConstructorResult(targetClass = TimesheetDto.class, columns = {
        @ColumnResult(name = "id", type = Integer.class),
        @ColumnResult(name = "status", type = String.class),
        @ColumnResult(name = "tanggal", type = Date.class),
        @ColumnResult(name = "clientName", type = String.class),
        @ColumnResult(name = "userApproval", type = String.class),
        @ColumnResult(name = "eroStat", type = String.class)
})})

@NamedNativeQuery(name = "TimesheetEntity.viewTimesheet", resultSetMapping = "timesheetMapping",
query = "SELECT timesheet.id, timesheet.status, timesheet.timesheet_date AS tanggal, client.name AS clientName, timesheet.user_approval AS userApproval, timesheet.ero_status AS eroStat \n" +
        "FROM timesheet AS timesheet\n" +
        "LEFT JOIN placement AS placement\n" +
        "ON timesheet.placement_id = placement.id\n" +
        "LEFT JOIN client AS client\n" +
        "ON placement.client_id = client.id\n" +
        "WHERE timesheet.is_delete = false")

@NamedNativeQuery(name = "TimesheetEntity.searchTimesheetByDateAsc", resultSetMapping = "timesheetMapping",
query = "SELECT timesheet.id, timesheet.status, timesheet.timesheet_date AS tanggal, client.name AS clientName, timesheet.user_approval AS userApproval, timesheet.ero_status AS eroStat \n" +
        "FROM timesheet AS timesheet\n" +
        "LEFT JOIN placement AS placement\n" +
        "ON timesheet.placement_id = placement.id\n" +
        "LEFT JOIN client AS client\n" +
        "ON placement.client_id = client.id\n" +
        "WHERE timesheet.is_delete = false\n" +
        "AND (CAST(timesheet.timesheet_date AS varchar)\n" +
        "BETWEEN :startDate AND :endDate)\n" +
        "ORDER BY timesheet.timesheet_date ASC\n" +
        "LIMIT :rpg OFFSET :page")

@NamedNativeQuery(name = "TimesheetEntity.searchTimesheetByDateDesc", resultSetMapping = "timesheetMapping",
query = "SELECT timesheet.id, timesheet.status, timesheet.timesheet_date AS tanggal, client.name AS clientName, timesheet.user_approval AS userApproval, timesheet.ero_status AS eroStat \n" +
        "FROM timesheet AS timesheet\n" +
        "LEFT JOIN placement AS placement\n" +
        "ON timesheet.placement_id = placement.id\n" +
        "LEFT JOIN client AS client\n" +
        "ON placement.client_id = client.id\n" +
        "WHERE timesheet.is_delete = false\n" +
        "AND (CAST(timesheet.timesheet_date AS varchar)\n" +
        "BETWEEN :startDate AND :endDate)\n" +
        "ORDER BY timesheet.timesheet_date DESC\n" +
        "LIMIT :rpg OFFSET :page")

@Entity
@Table(name = "timesheet")
public class TimesheetEntity extends CommonEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timesheet_id_pk")
    @SequenceGenerator(name = "timesheet_id_pk", sequenceName = "timesheet_timesheet_id_pk", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "status")
    private String status;

    @Column(name = "placement_id", nullable = false)
    private Integer placementId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    @Temporal(TemporalType.DATE)
    @Column(name = "timesheet_date", nullable = false)
    private Date timesheetDate;

    @Column(name = "start_time", nullable = false)
    @Size(max = 5)
    private String startTime;

    @Column(name = "end_time", nullable = false)
    @Size(max = 5)
    private String endTime;

    @Column(name = "overtime")
    private boolean overtime;

    @Column(name = "start_ot")
    @Size(max = 5)
    private String startOt;

    @Column(name = "end_ot")
    @Size(max = 5)
    private String endOt;

    @Column(name = "activity", nullable = false)
    private String activity;

    @Column(name = "user_approval")
    @Size(max = 10)
    private String userApproval;

    @Column(name = "submitted_on", nullable = false)
    private Date submittedOn;

    @Column(name = "approved_on")
    private Date approvedOn;

    @Column(name = "ero_status")
    private String eroStatus;

    @Column(name = "sent_on")
    private Date sentOn;

    @Column(name = "collected_on")
    private Date collectedOn;

    public TimesheetEntity() {
    }

    public TimesheetEntity(String status, Integer placementId, Date timesheetDate, @Size(max = 5) String startTime, @Size(max = 5) String endTime, boolean overtime, @Size(max = 5) String startOt, @Size(max = 5) String endOt, String activity, @Size(max = 10) String userApproval, Date submittedOn, Date approvedOn, String eroStatus, Date sentOn, Date collectedOn)
    {
        this.status = status;
        this.placementId = placementId;
        this.timesheetDate = timesheetDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.overtime = overtime;
        this.startOt = startOt;
        this.endOt = endOt;
        this.activity = activity;
        this.userApproval = userApproval;
        this.submittedOn = submittedOn;
        this.approvedOn = approvedOn;
        this.eroStatus = eroStatus;
        this.sentOn = sentOn;
        this.collectedOn = collectedOn;
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

    public Integer getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Integer placementId) {
        this.placementId = placementId;
    }

    public Date getTimesheetDate() {
        return timesheetDate;
    }

    public void setTimesheetDate(Date timesheetDate) {
        this.timesheetDate = timesheetDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isOvertime() {
        return overtime;
    }

    public void setOvertime(boolean overtime) {
        this.overtime = overtime;
    }

    public String getStartOt() {
        return startOt;
    }

    public void setStartOt(String startOt) {
        this.startOt = startOt;
    }

    public String getEndOt() {
        return endOt;
    }

    public void setEndOt(String endOt) {
        this.endOt = endOt;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getUserApproval() {
        return userApproval;
    }

    public void setUserApproval(String userApproval) {
        this.userApproval = userApproval;
    }

    public Date getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(Date submittedOn) {
        this.submittedOn = submittedOn;
    }

    public Date getApprovedOn() {
        return approvedOn;
    }

    public void setApprovedOn(Date approvedOn) {
        this.approvedOn = approvedOn;
    }

    public String getEroStatus() {
        return eroStatus;
    }

    public void setEroStatus(String eroStatus) {
        this.eroStatus = eroStatus;
    }

    public Date getSentOn() {
        return sentOn;
    }

    public void setSentOn(Date sentOn) {
        this.sentOn = sentOn;
    }

    public Date getCollectedOn() {
        return collectedOn;
    }

    public void setCollectedOn(Date collectedOn) {
        this.collectedOn = collectedOn;
    }
}
