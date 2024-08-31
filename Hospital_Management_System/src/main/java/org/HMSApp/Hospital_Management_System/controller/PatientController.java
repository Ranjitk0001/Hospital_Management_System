package org.HMSApp.Hospital_Management_System.controller;

import org.HMSApp.Hospital_Management_System.entity.Patient;
import org.HMSApp.Hospital_Management_System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PatientController {
    @Autowired
	private PatientRepository patientRepository;
    @PostMapping("/insert")
    public Patient createPatient(@RequestBody Patient patient) {
    	return patientRepository.save(patient);
    }
}
