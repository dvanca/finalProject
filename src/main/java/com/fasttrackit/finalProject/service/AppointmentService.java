package com.fasttrackit.finalProject.service;

import com.fasttrackit.finalProject.exception.ResourceNotFoundException;
import com.fasttrackit.finalProject.model.Appointment;
import com.fasttrackit.finalProject.model.Patient;
import com.fasttrackit.finalProject.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }
    public Appointment getById(int id) {
        return appointmentRepository.findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment missing", id));
    }

    public List<Appointment> getAllByQuery(String name) {
        return appointmentRepository.findByQuery(name);
    }

    public Appointment add(Appointment newAppointment) {
        return this.appointmentRepository.save(newAppointment);
    }

    public List<Appointment> getAllAppointments() {
        return this.appointmentRepository.findAll();
    }

    public Appointment update(int id, Appointment appointment) {
        Appointment appointmentToBeUpdated = getById(id);
        appointmentToBeUpdated.setPatient(appointment.getPatient());
        appointmentToBeUpdated.setDescription(appointment.getDescription());
        appointmentToBeUpdated.setAppointmentType(appointment.getAppointmentType());
        return appointmentToBeUpdated;
    }
}
