package com.xsis.timesheetactivity.model.entity;

import com.xsis.timesheetactivity.model.CommonEntity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeEntity extends CommonEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_pk")
    @SequenceGenerator(name = "employee_id_pk", sequenceName = "employee_employee_id_pk", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "biodata_id", nullable = false)
    private Integer biodataId;

    @Column(name = "is_idle")
    private boolean isIdle;

    @Column(name = "is_ero")
    private boolean isEro;

    @Column(name = "is_user_client")
    private boolean isUserClient;

    @Column(name = "ero_email")
    private String eroEmail;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Integer biodataId, boolean isIdle, boolean isEro, boolean isUserClient, String eroEmail) {
        this.biodataId = biodataId;
        this.isIdle = isIdle;
        this.isEro = isEro;
        this.isUserClient = isUserClient;
        this.eroEmail = eroEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBiodataId() {
        return biodataId;
    }

    public void setBiodataId(Integer biodataId) {
        this.biodataId = biodataId;
    }

    public boolean isIdle() {
        return isIdle;
    }

    public void setIdle(boolean idle) {
        isIdle = idle;
    }

    public boolean isEro() {
        return isEro;
    }

    public void setEro(boolean ero) {
        isEro = ero;
    }

    public boolean isUserClient() {
        return isUserClient;
    }

    public void setUserClient(boolean userClient) {
        isUserClient = userClient;
    }

    public String getEroEmail() {
        return eroEmail;
    }

    public void setEroEmail(String eroEmail) {
        this.eroEmail = eroEmail;
    }
}
