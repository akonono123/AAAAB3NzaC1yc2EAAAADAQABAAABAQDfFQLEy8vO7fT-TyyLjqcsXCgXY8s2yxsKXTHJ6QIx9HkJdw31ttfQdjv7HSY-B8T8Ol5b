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
    private String username;
    private String password;

    private boolean active;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",

            joinColumns = @JoinColumn(name = "user_Id"),
            inverseJoinColumns = @JoinColumn(name = "role_Id")
    )
    private Set<Role> roles = new HashSet<>();


    public Users(){};



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
