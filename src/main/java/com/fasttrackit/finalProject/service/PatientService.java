package com.fasttrackit.finalProject.service;

import com.fasttrackit.finalProject.exception.ResourceNotFoundException;
import com.fasttrackit.finalProject.model.Appointment;
import com.fasttrackit.finalProject.model.Patient;
import com.fasttrackit.finalProject.repository.AppointmentRepository;
import com.fasttrackit.finalProject.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }
    public Patient getById(int id) {
        return patientRepository.findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient missing", id));
    }


    public Patient add(Patient newPatient) {
        return this.patientRepository.save(newPatient);
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }
}
