package com.gxcttdvnapi.api.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gxcttdvnapi.api.models.AddressCode;

import java.util.List;


@Repository
public interface AddressCodeRepository extends JpaRepository<AddressCode, Integer>{

    @Query(value = "SELECT addressID FROM Address_Code WHERE houseAddress = :houseAddress AND city = :city AND stateCode = :stateCode AND zipcode = :zipcode", nativeQuery = true)
    List<AddressCode> getAddressID(@Param("houseAddress") String houseaddress,
                                   @Param("city") String city,
                                   @Param("stateCode") String statecode,
                                   @Param("zipcode") Integer zipcode);
}
