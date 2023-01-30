package com.fasttrackit.finalProject.repository;

import com.fasttrackit.finalProject.model.Appointment;
import com.fasttrackit.finalProject.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long>{

    @Query("select p from Patient p where concat(trim(p.lastName), trim(p.firstName)) like %:searchString%")
    List<Patient> findBySearchString(@Param("searchString") String searchString);

}


