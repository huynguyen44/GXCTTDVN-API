package com.gxcttdvnapi.api.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gxcttdvnapi.api.models.Role;
import java.util.List;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    @Query(value = "SELECT roleID FROM Role WHERE roleType = :roleType", nativeQuery = true)
    List<Role> getRoleID(@Param("roleType") String roletype);
}
