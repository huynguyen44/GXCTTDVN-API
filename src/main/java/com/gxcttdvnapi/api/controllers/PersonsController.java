package com.gxcttdvnapi.api.controllers;

import com.gxcttdvnapi.api.exceptions.ResourceNotFoundException;
import com.gxcttdvnapi.api.models.AddressCode;
import com.gxcttdvnapi.api.models.Persons;
import com.gxcttdvnapi.api.models.Role;
import com.gxcttdvnapi.api.repositories.AddressCodeRepository;
import com.gxcttdvnapi.api.repositories.PersonsRepository;
//import org.apache.tomcat.util.http.parser.MediaType;
import com.gxcttdvnapi.api.repositories.RoleRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.awt.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonsController {
    @Autowired
    private PersonsRepository personsRepository;

    @Autowired
    private AddressCodeRepository addressCodeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/all")
    public List<Persons> getAllPersons() {

        return personsRepository.findAll(); // passing parameter in url
    }

    @GetMapping("/getPersonsByID") //searches specific id
    public ResponseEntity<Persons> getPersonsByID(@RequestParam(value = "id") Integer id) throws ResourceNotFoundException {
        Persons pPersons = personsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Persons not found for id: " + id));

        return ResponseEntity.ok(pPersons);
    }

    @GetMapping("/getPersonsByLastName")
    public List<Persons> getPersonsByLastName(@RequestParam(value = "lastname") String lastname) throws ResourceNotFoundException {
        return personsRepository.getPersonsByLastName(lastname);
    }

    @GetMapping("/getPersonsByFirstName")
    public List<Persons> getPersonsByFirstName(@RequestParam(value = "firstname") String firstname) throws ResourceNotFoundException {
        return personsRepository.getPersonsByFirstName(firstname);
    }

    @GetMapping("/getPersonsByEmail")
    public List<Persons> getPersonsByEmail(@RequestParam(value = "email") String email) throws ResourceNotFoundException {
        return personsRepository.getPersonsByEmail(email);
    }

    @GetMapping("/getPersonsByPhoneNumber")
    public List<Persons> getPersonsByPhone(@RequestParam(value = "phone") BigInteger phone) throws ResourceNotFoundException {
        return personsRepository.getPersonsByPhone(phone);
    }

    @PostMapping(value = "/newpersons", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Persons newPersons(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date, Persons pPersons, AddressCode addressCode, Role role) {

        System.out.println("\n\n\n----- " + date + " ---------\n\n\n");

        pPersons.setDOB(date);

        String houseAddress = addressCode.getHouseAddress();
        String city = addressCode.getCity();
        String stateCode = addressCode.getStateCode();
        Integer zipcode = addressCode.getZipCode();

        List<AddressCode> addressCodeList= addressCodeRepository.getAddressID(houseAddress, city, stateCode, zipcode);

        if (addressCodeList.isEmpty()){
            AddressCode savedAddress = addressCodeRepository.save(addressCode);
            pPersons.setAddressID(savedAddress.getAddressID());
        } else {
            AddressCode firstAddress = addressCodeList.get(0);
            pPersons.setAddressID(firstAddress.getAddressID());
        }

        String roleType = role.getRoleType();

        List<Role> roleList = roleRepository.getRoleID(roleType);

        if (roleList.isEmpty()){
            Role savedRole = roleRepository.save(role);
            pPersons.setRoleID1(savedRole.getRoleID());
        }
        else {
            Integer roleCount = roleList.size();
            if (roleCount >= 1){
                Role newRole1 = roleList.get(0);
                pPersons.setRoleID1(newRole1.getRoleID());
            }

            if (roleCount >= 2){
                Role newRole2 = roleList.get(1);
                pPersons.setRoleID2(newRole2.getRoleID());
            }

            if (roleCount >= 3){
                Role newRole3 = roleList.get(2);
                pPersons.setRoleID3(newRole3.getRoleID());
            }

            if (roleCount == 4){
                Role newRole4 = roleList.get(3);
                pPersons.setRoleID4(newRole4.getRoleID());
            }

            Role newRole = roleList.get(0);
            pPersons.setRoleID1(newRole.getRoleID());
        }



        return personsRepository.save(pPersons);
    }

    @PostMapping(value = "/saveAddress", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public AddressCode saveAddress (AddressCode testing){
        return addressCodeRepository.save(testing);
    }

    @PostMapping(value = "/updatePersons", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Persons> updatePersons(@RequestParam(value = "id") Integer id, Persons personDetails) throws ResourceNotFoundException {
        Persons persons = personsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Persons not found for id: " + id));

        if (personDetails.getSaintName() != null) {
            persons.setSaintName(personDetails.getSaintName());
        }

        if (personDetails.getLastName() != null) {
            persons.setLastName(personDetails.getLastName());
        }

        if (personDetails.getMiddleName() != null) {
            persons.setMiddleName(personDetails.getMiddleName());
        }

        if (personDetails.getFirstName() != null) {
            persons.setFirstName(personDetails.getFirstName());
        }

        if (personDetails.getDOB() != null) {
            persons.setDOB(personDetails.getDOB());
        }

        if (personDetails.getPhoneNumber() != null) {
            persons.setPhoneNumber(personDetails.getPhoneNumber());
        }

        if (personDetails.getEmailAddress() != null) {
            persons.setEmailAddress(personDetails.getEmailAddress());
        }

        if (personDetails.getAddressID() != null) {
            persons.setAddressID(personDetails.getAddressID());
        }

        if (personDetails.getRoleID1() != null) {
            persons.setRoleID1(personDetails.getRoleID1());
        }

        Persons updatedPersons = personsRepository.save(persons);

        return ResponseEntity.ok(updatedPersons);
    }
}
