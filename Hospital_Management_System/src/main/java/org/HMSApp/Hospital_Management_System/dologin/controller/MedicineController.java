package org.HMSApp.Hospital_Management_System.dologin.controller;

import java.util.List;

import org.HMSApp.Hospital_Management_System.dologin.entity.Appointment;
import org.HMSApp.Hospital_Management_System.dologin.entity.Medicine;
import org.HMSApp.Hospital_Management_System.dologin.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3")
public class MedicineController {
  @Autowired
  MedicineRepository medicineRepository;
  
  @PostMapping("/insert")
  public Medicine createMedicine(@RequestBody Medicine medicine) {
	return medicineRepository.save(medicine);  
  }
  
 
  
}
