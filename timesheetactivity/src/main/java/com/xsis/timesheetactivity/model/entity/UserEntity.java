package com.xsis.timesheetactivity.model.entity;

import com.xsis.timesheetactivity.model.CommonEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class UserEntity extends CommonEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_pk")
    @SequenceGenerator(name = "user_id_pk", sequenceName = "users_user_id_pk", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @NotEmpty
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @NotEmpty
    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @NotEmpty
    @Column(name = "user_roles")
    private String userRoles;

    public UserEntity() {
    }

    public UserEntity(Integer id, String userName, String userPassword, String userRoles)
    {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRoles =userRoles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }
}
