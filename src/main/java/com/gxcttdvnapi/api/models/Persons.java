package com.gxcttdvnapi.api.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "Persons")
public class Persons {
    private Integer personsID;
    private String saintName;
    private String lastName;
    private String middleName;
    private String firstName;
    private Date DOB;
    private BigInteger phoneNumber;
    private String emailAddress;
    private Integer addressID;
    private Integer roleID1;
    private Integer roleID2;
    private Integer roleID3;
    private Integer roleID4;

    public Persons() {}

    public Persons(String saintname, String lastname,
    String middlename, String firstname, java.util.Date dob, BigInteger phonenumber, String emailaddress,
    Integer addressID, Integer roleID1){
        this.saintName = saintname;
        this.lastName = lastname;
        this.middleName = middlename;
        this.firstName = firstname;
        this.DOB = dob;
        this.phoneNumber = phonenumber;
        this.emailAddress = emailaddress;
        this.addressID = addressID;
        this.roleID1 = roleID1;
        this.roleID2 = roleID2;
        this.roleID3 = roleID3;
        this.roleID4 = roleID4;

    }

    @Id
    @Column(name = "personsID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //getter
    public Integer getPersonsID() {
        return personsID;
    }
    //setter
    public void setPersonsID(Integer personsid) { personsID = personsid; }

    @Column(name = "saintName", nullable = false)
    public String getSaintName() {
        return saintName;
    }
    public void setSaintName(String saintname) {
        saintName = saintname;
    }

    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastname) {
        lastName = lastname;
    }

    @Column(name = "middleName")
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middlename) {
        middleName = middlename;
    }

    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstname) {
        firstName = firstname;
    }

    @Column(name = "DOB")
    public java.util.Date getDOB() {
        return DOB;
    }
    public void setDOB(java.util.Date dob) {
        DOB = dob;
    }

    @Column(name = "phoneNumber")
    public BigInteger getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(BigInteger phonenumber) { phoneNumber = phonenumber;
    }

    @Column(name = "emailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailaddress) {
        emailAddress = emailaddress;
    }

    @Column(name = "addressID")
    public Integer getAddressID() { return addressID; }
    public void setAddressID(Integer addressid) { addressID = addressid; }

    @Column(name = "roleID1")
    public Integer getRoleID1() { return roleID1; }
    public void setRoleID1(Integer roleid1) { roleID1 = roleid1; }

    @Column(name = "roleID2")
    public Integer getRoleID2() { return roleID2; }
    public void setRoleID2(Integer roleID2) { this.roleID2 = roleID2; }

    @Column(name = "roleID3")
    public Integer getRoleID3() { return roleID3; }
    public void setRoleID3(Integer roleID3) { this.roleID3 = roleID3; }

    @Column(name = "roleID4")
    public Integer getRoleID4() { return roleID4; }
    public void setRoleID4(Integer roleID4) { this.roleID4 = roleID4; }
}
