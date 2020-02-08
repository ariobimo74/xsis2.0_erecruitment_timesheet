package com.xsis.timesheetactivity.model.entity;

import com.xsis.timesheetactivity.model.CommonEntity;

import javax.persistence.*;

@Entity
@Table(name = "biodata")
public class BiodataEntity extends CommonEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "biodata_id_pk")
    @SequenceGenerator(name = "biodata_id_pk", sequenceName = "biodata_biodata_id_pk", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    public BiodataEntity() {
    }

    public BiodataEntity(String name)
    {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
