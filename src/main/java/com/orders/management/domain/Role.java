package com.orders.management.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role_table")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    //@ManyToOne
    //@JoinColumn(name = "id_role", nullable=false)
   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleList", fetch = FetchType.EAGER)

    @ManyToMany(mappedBy = "roleList")
    private Set<User> userid;

    public Set<User> getUserid() {
        return userid;
    }

    public void setUserid(Set<User> userid) {
        this.userid = userid;
    }

    @Column(name = "role_name",length = 30)
    private String roleName;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setRoleName(String roleName) { this.roleName = roleName; }
    public String getRoleName() { return roleName;}



}