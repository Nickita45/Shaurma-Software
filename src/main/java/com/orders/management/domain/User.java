package com.orders.management.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
  //  @OneToOne(mappedBy="userId")
    private Integer userId;

    @Column(name = "first_name",length = 40)
    private String firstName;

    @Column(name = "last_name",length = 40)
    private String lastName;

    @Column(name = "login",length = 40, unique = true, nullable = false)
    private String login;

    @Column(name = "password",length = 40, nullable = false)
    @Pattern(regexp="^[a-zA-Z0-9]{4,}",message="length must be at least 4")
    private String password;

    @Column(name = "active")
    private boolean active;

    @Column(name = "email",length = 40,unique = true)
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[a-zA-Z0-9.-]+$" ,message = "wrong email")
    private String email;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "userid", fetch = FetchType.EAGER)
    //@ManyToOne
    //@JoinColumn(name = "id_role")

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_ids",
            joinColumns = @JoinColumn(name = "users_ids"),
            inverseJoinColumns = @JoinColumn(name = "role_ids"))
    private Set<Role> roleList;
    @JsonBackReference
    @OneToOne(mappedBy = "user_cash", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
    private Document document;
    @JsonBackReference
    @OneToOne(mappedBy = "user_id", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
    private Line line;

    public Set<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<Role> roleList) {
        this.roleList = roleList;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public void setId(int id){ this.userId = id;}
    public int getId(){ return userId; }

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



}