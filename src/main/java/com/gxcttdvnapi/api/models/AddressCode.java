package com.gxcttdvnapi.api.models;

import javax.persistence.*;


@Entity
@Table(name = "Address_Code")
public class AddressCode {
    private Integer addressID;
    private String houseAddress;
    private String city; //MUST MATCH THESE
    private String stateCode;
    private Integer zipCode;

    public AddressCode() {
    }

    public AddressCode(String houseaddress, String city, String statecode, Integer zipcode) {
        this.houseAddress = houseaddress;
        this.city = city;
        this.stateCode = statecode;
        this.zipCode = zipcode;
    }

    @Id
    @Column(name = "addressID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getAddressID() { return addressID; }
    public void setAddressID(Integer addressid) { this.addressID = addressid; }

    @Column(name = "houseAddress")
    public String getHouseAddress() { return houseAddress; }
    public void setHouseAddress(String houseaddress) { this.houseAddress = houseaddress; }

    @Column(name = "city")
    public String getCity() { return city;}
    public void setCity(String city) { this.city = city;}

    @Column(name = "stateCode")
    public String getStateCode() { return stateCode; }
    public void setStateCode(String statecode) { this.stateCode = statecode; }

    @Column(name = "zipcode")
    public Integer getZipCode() { return zipCode; }
    public void setZipCode(Integer zipcode) { this.zipCode = zipcode; }
}
