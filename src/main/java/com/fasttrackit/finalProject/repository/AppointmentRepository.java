package com.fasttrackit.finalProject.repository;

import com.fasttrackit.finalProject.model.Appointment;
import com.fasttrackit.finalProject.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("select c from Appointment c" +
            " join c.patient as p where p.lastName = :patientName")
    List<Appointment> findByQuery(@Param("patientName") String patientName);
}
