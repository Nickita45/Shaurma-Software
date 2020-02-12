package com.orders.management.domain;

import javax.persistence.*;

@Entity
@Table(name = "role_table")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "role_name",length = 30)
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "id_role", nullable=false)
    private User user_id;

    public void setRoleName(String roleName) { this.roleName = roleName; }
    public String getRoleName() { return roleName;}

    public void setId(int id){ this.id = id;}
    public int getId(){ return id; }

    public void setEmployeeIdId(int id){ this.employeeId = id;}
    public int getEmployeeIdId(){ return employeeId; }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
}