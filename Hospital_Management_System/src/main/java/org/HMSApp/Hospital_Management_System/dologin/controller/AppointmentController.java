package org.HMSApp.Hospital_Management_System.dologin.controller;

import java.util.List;

import org.HMSApp.Hospital_Management_System.dologin.entity.Appointment;
import org.HMSApp.Hospital_Management_System.dologin.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class AppointmentController {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@PostMapping("/insert")
	public Appointment createAppointment(@RequestBody Appointment appointment) {
		
		return appointmentRepository.save(appointment);
	}
	
	 @GetMapping("/showlist")
	  public List<Appointment> getAllAppointments(){
		  return appointmentRepository.findAll();
	  }

}
