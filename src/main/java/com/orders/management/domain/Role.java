package com.orders.management.domain;

import javax.persistence.*;

@Entity
@Table(name = "role_table")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "employee_id")
    private long employeeId;

    @Column(name = "role_name",length = 30)
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setRoleName(String roleName) { this.roleName = roleName; }
    public String getRoleName() { return roleName;}

    public void setId(long id){ this.id = id;}
    public long getId(){ return id; }

    public void setEmployeeIdId(long id){ this.employeeId = id;}
    public long getEmployeeIdId(){ return employeeId; }

    public void setUser(User user){ this.user=user; }
    public User getUser(){ return user;}

}