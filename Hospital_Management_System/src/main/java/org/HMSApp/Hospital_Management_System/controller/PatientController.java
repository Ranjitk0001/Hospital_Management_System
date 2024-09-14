package org.HMSApp.Hospital_Management_System.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;
import org.HMSApp.Hospital_Management_System.entity.Patient;
import org.HMSApp.Hospital_Management_System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
//    @PostMapping()
    @PostMapping("/insert")
    public Patient createPatient(@RequestBody Patient patient) {
    	return patientRepository.save(patient);
    }
    
    @GetMapping()
//    @GetMapping("/showlist")
	  public List<Patient> getAllPatients(){
		  return patientRepository.findAll();
	  }
    
    @DeleteMapping("/{id}")
	 public ResponseEntity<Map<String,Boolean>>deleteAdmin(@PathVariable long id) throws AttributeNotFoundException{
		 Patient patient=patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Admin not found with id " + id));
		 patientRepository.delete(patient);
		 
		 Map<String ,Boolean> responnse= new HashMap<String,Boolean>();
		 responnse.put("Deleted", Boolean.TRUE);
		 
		 return  ResponseEntity.ok(responnse);
	 }
    
     @PutMapping("/{id}")
	 public ResponseEntity<Patient>updatePatient(@PathVariable long id,@RequestBody Patient patientDetails) throws AttributeNotFoundException{
		 Patient patient=patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with id " + id));
		
		 patient.setAge(patientDetails.getAge());
		 patient.setName(patientDetails.getName());
		 patient.setBlood(patientDetails.getBlood());
		 patient.setDose(patientDetails.getDose());
		 patient.setFees(patientDetails.getFees());
		 patient.setPrescription(patientDetails.getPrescription());
		 patient.setUrgency(patientDetails.getUrgency());
//		 patient.setId(patientDetails.getId());
		 
		 Patient savedPatient= patientRepository.save(patient);
		 
		 return ResponseEntity.ok(savedPatient);
		 
		
	 }
     
     @GetMapping("/{id}")
     public ResponseEntity<Patient>getPatientById(@PathVariable long id) throws AttributeNotFoundException {
    	Patient patient=patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with id"+id));
    	
    	return ResponseEntity.ok(patient);
     }
     
} 
