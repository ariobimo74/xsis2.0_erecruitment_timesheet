package com.xsis.timesheetactivity.model.entity;

import com.xsis.timesheetactivity.model.CommonEntity;

import javax.persistence.*;

@Entity
@Table(name = "placement")
public class PlacementEntity extends CommonEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "placement_id_pk")
    @SequenceGenerator(name = "placement_id_pk", sequenceName = "placement_placement_id_pk", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "client_id", nullable = false)
    private Integer clientId;

    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    @Column(name = "is_placement_active", nullable = false)
    private boolean isPlacementActive;

    public PlacementEntity() {
    }

    public PlacementEntity(Integer clientId, Integer employeeId, boolean isPlacementActive) {
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.isPlacementActive = isPlacementActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isPlacementActive() {
        return isPlacementActive;
    }

    public void setPlacementActive(boolean placementActive) {
        isPlacementActive = placementActive;
    }
}
