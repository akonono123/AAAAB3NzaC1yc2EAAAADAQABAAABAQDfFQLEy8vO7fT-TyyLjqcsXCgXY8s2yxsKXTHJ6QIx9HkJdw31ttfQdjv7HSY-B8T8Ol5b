package com.bootcamp.springboot.model;

import javax.persistence.*;

@Entity
@Table(name="Roles_tbl")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String roleName;
    private String description;


 public Role(){}


    public Role(long id, String roleName, String description) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
