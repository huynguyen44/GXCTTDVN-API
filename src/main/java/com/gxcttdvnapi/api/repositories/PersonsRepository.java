package com.gxcttdvnapi.api.repositories;

import com.gxcttdvnapi.api.models.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface PersonsRepository extends JpaRepository<Persons, Integer> {
    @Query(value = "SELECT * FROM PERSONS WHERE lastName= :lastname", nativeQuery = true)
    List<Persons> getPersonsByLastName(@Param("lastname") String lastname);

    @Query(value = "SELECT * FROM PERSONS WHERE firstName= :firstname", nativeQuery = true)
    List<Persons> getPersonsByFirstName(@Param("firstname") String firstname);

    @Query(value = "SELECT * FROM PERSONS WHERE emailAddress= :email", nativeQuery = true)
    List<Persons> getPersonsByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM PERSONS WHERE phoneNumber= :phone", nativeQuery = true)
    List<Persons> getPersonsByPhone(@Param("phone") BigInteger phone);


}
