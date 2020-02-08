package com.xsis.timesheetactivity.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRoleEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_id_pk")
    @SequenceGenerator(name = "user_role_id_pk", sequenceName = "user_role_user_role_id_pk", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "user_role")
    private String userRole;

    public UserRoleEntity() {
    }

    public UserRoleEntity(Integer id, String userName, String userRole)
    {
        this.id = id;
        this.userName = userName;
        this.userRole = userRole;
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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
