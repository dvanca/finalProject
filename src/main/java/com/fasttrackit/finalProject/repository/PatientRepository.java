package com.fasttrackit.finalProject.repository;

import com.fasttrackit.finalProject.model.Appointment;
import com.fasttrackit.finalProject.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long>{}
