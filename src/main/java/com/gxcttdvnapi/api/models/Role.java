package com.gxcttdvnapi.api.models;
import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
    private Integer roleID;
    private String roleType;

    public Role() {
    }

    public Role(String roletype){
        this.roleType = roletype;
    }

    @Id
    @Column(name = "roleID")
    public Integer getRoleID() { return roleID; }
    public void setRoleID(Integer roleID) { this.roleID = roleID; }

    @Column(name = "roleType")
    public String getRoleType() { return roleType; }
    public void setRoleType(String roleType) { this.roleType = roleType; }
}
