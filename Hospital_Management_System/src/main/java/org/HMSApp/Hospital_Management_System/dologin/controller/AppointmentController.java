package org.HMSApp.Hospital_Management_System.dologin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.HMSApp.Hospital_Management_System.dologin.entity.Appointment;
import org.HMSApp.Hospital_Management_System.dologin.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
//Connect to Angular
@CrossOrigin(origins ="http://localhost:4200/")
public class AppointmentController {
	
	private static final CrudRepository<Appointment, Long> AppappointmentRepository = null;
	@Autowired
	AppointmentRepository appointmentRepository;
	
//	@PostMapping("/insert")
	@PostMapping()
	public Appointment createAppointment(@RequestBody Appointment appointment) {
		
		return appointmentRepository.save(appointment);
	}
	
	 @GetMapping()
//	 @GetMapping("/showlist")
	  public List<Appointment> getAllAppointments(){
		  return appointmentRepository.findAll();
	  }
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Map<String,Boolean>>deleteAppoinment(@PathVariable long id) throws AttributeNotFoundException{
		 Appointment appointment=appointmentRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Appointment not found with id " + id));
		 appointmentRepository.delete(appointment);
		 
		 Map<String ,Boolean> responnse= new HashMap<String,Boolean>();
		 responnse.put("Delete", Boolean.TRUE);
		 
		 return  ResponseEntity.ok(responnse);
	 }

}
