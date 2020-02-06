package com.orders.management.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long userId;
    @Column(name = "first_name",length = 40)
    private String firstName;
    @Column(name = "last_name",length = 40)
    private String lastName;
    @Column(name = "login",length = 40)
    private String login;
    @Column(name = "password",length = 40)
    private String password;
    @Column(name = "active")
    private boolean active;
    @Column(name = "email",length = 40)
    private String email;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.EAGER)
    private Set<Role> roleList;

    public void setId(long id){this.userId = id;}
    public long getId(){return userId; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return firstName; }

    public void setLastName(String lastName) {this.lastName = lastName; }
    public String getLastName() { return lastName; }

    public void setLogin(String login){ this.login = login; }
    public  String getLogin(){ return login; }

    public void setPassword(String password){ this.password = password; }
    public String getPassword(){ return password; }

    public void setActive(boolean active){ this.active = active; }
    public boolean getActive(){ return active; }

    public void setEmail(String email){ this.email = email; }
    public String getEmail(){ return email;}

    public void setRoleList(Set<Role> roleList){ this.roleList=roleList; }
    public Set<Role> getRoleList(){ return roleList; }

}