package com.bootcamp.springboot.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users_tbl")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="username")
    private String user;
    @Column(name="password")
    private String pass;
    @Column(name="active")
    private boolean active;



    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(
            name="USER_ROLES",
            joinColumns = @JoinColumn(name="USER_ID"),
            inverseJoinColumns = @JoinColumn(name="ROLE_ID")
    )
    private Set<Role> roles=new HashSet<>();
    public Users(){}

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Users(long id, String user, String pass, boolean active) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
