package com.xsis.timesheetactivity.model.entity;

import com.xsis.timesheetactivity.model.CommonEntity;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class ClientEntity extends CommonEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_pk")
    @SequenceGenerator(name = "client_id_pk", sequenceName = "client_client_id_pk")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "user_client_name", nullable = false)
    private String userClientName;

    @Column(name = "ero", nullable = false)
    private Integer ero;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    public ClientEntity() {
    }

    public ClientEntity(String name, String userClientName, Integer ero, String userEmail) {
        this.name = name;
        this.userClientName = userClientName;
        this.ero = ero;
        this.userEmail = userEmail;
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

    public String getUserClientName() {
        return userClientName;
    }

    public void setUserClientName(String userClientName) {
        this.userClientName = userClientName;
    }

    public Integer getEro() {
        return ero;
    }

    public void setEro(Integer ero) {
        this.ero = ero;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
