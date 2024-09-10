package org.HMSApp.Hospital_Management_System.controller;

import java.util.List;

import org.HMSApp.Hospital_Management_System.dologin.entity.Appointment;
import org.HMSApp.Hospital_Management_System.entity.Patient;
import org.HMSApp.Hospital_Management_System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
////Connect to Angular
@CrossOrigin(origins ="http://localhost:4200/")

//Connect to Angular
//@CrossOrigin("*")
public class PatientController {
    @Autowired
	private PatientRepository patientRepository;
    @PostMapping("/insert")
    public Patient createPatient(@RequestBody Patient patient) {
    	return patientRepository.save(patient);
    }
    
    @GetMapping()
//    @GetMapping("/showlist")
	  public List<Patient> getAllPatients(){
		  return patientRepository.findAll();
	  }
}
