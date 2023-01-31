package com.fasttrackit.finalProject.controller;

import com.fasttrackit.finalProject.model.Appointment;
import com.fasttrackit.finalProject.model.Patient;
import com.fasttrackit.finalProject.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public List<Patient> getAll(@RequestParam(required = false) String query) {
        if (query != null && query != "") {
            return patientService.findBySearchString(query);

        } else {
            System.out.println("Requested all patients");
            return patientService.getAll();
        }
    }


    @PostMapping("add")
    public Patient add(@RequestBody Patient patient){
        if (patient.getLastName() == null){
             this.patientService.add(patient);

        }
        System.out.println(patient);
        return this.patientService.add(patient);
    }

    @PutMapping("{id}")
    public Patient update(@PathVariable int id, @RequestBody Patient patient) {
        return patientService.update(id, patient);
    }


    }

