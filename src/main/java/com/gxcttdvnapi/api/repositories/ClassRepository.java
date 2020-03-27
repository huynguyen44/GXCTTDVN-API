package com.gxcttdvnapi.api.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gxcttdvnapi.api.models.Class;
import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Integer>{
    @Query(value = "SELECT * FROM Class WHERE className = :classname", nativeQuery = true)
    List<Class> getClassByName(@Param("classname") String classname);
}
