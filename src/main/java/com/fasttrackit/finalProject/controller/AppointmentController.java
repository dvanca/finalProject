package com.fasttrackit.finalProject.controller;

import com.fasttrackit.finalProject.model.Appointment;
import com.fasttrackit.finalProject.model.AppointmentType;
import com.fasttrackit.finalProject.model.Patient;
import com.fasttrackit.finalProject.service.AppointmentService;
import com.fasttrackit.finalProject.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final PatientService patientService;

    @GetMapping
    public List<Appointment> getAll(@RequestParam(required = false) String patientName ) {
        System.out.println("Requested all appointments");
        if (patientName != null) {
            return appointmentService.getAllByQuery(patientName);
        } else {
            return appointmentService.getAllAppointments();
        }
    }
    @GetMapping("types")
    public List<AppointmentType> getTypes() {
        System.out.println("Requested all appointment types");
        return appointmentService.getAllAppointmentTypes();
    }

    @PostMapping("add")
    public Appointment add(@RequestBody Appointment appointment){
        if (appointment.getPatient().getId() == 0){
            Patient newPatient = this.patientService.add(appointment.getPatient());
            appointment.setPatient(newPatient);
        }
        System.out.println(appointment);
        return this.appointmentService.add(appointment);
    }

    @PutMapping("{id}")
    public Appointment update(@PathVariable int id, @RequestBody Appointment appointment) {
        return appointmentService.update(id, appointment);
    }
}
