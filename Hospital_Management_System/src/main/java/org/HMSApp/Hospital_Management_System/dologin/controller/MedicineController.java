package org.HMSApp.Hospital_Management_System.dologin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;
import org.HMSApp.Hospital_Management_System.dologin.entity.Medicine;
import org.HMSApp.Hospital_Management_System.dologin.repository.MedicineRepository;
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
@RequestMapping("/api/v3")
//Connect to Angular
@CrossOrigin("*")
public class MedicineController {
  @Autowired
  MedicineRepository medicineRepository;
  
  @GetMapping()
  public List<Medicine> getAllMedicine(){
		return medicineRepository.findAll();
  }
  
  @PostMapping("/insert")
  public Medicine createMedicine(@RequestBody Medicine medicine) {
	return medicineRepository.save(medicine);  
  }
  
//  @PutMapping("{id}")
//  public ResponseEntity<Medicine>updateMedicine(@PathVariable long id,@RequestBody Medicine  medicineDetails) throws AttributeNotFoundException
//  {
//	  Medicine medicine=medicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine not found with id " + id));	
//	  medicine.setDrugName(medicineDetails.getDrugName());
//	  medicine.setStock(medicineDetails.getStock());		 
//	  Medicine savedMedicine= medicineRepository.save(medicine);	 
//		 return ResponseEntity.ok(savedMedicine);	
//	 }
  
   @PutMapping("{id}")
   public ResponseEntity<Medicine>updateMedicine(@PathVariable long id,@RequestBody Medicine medicineDetails)throws AttributeNotFoundException
   {
	  Medicine medicine =medicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine not found with id"+id));
	  medicine.setDrugName(medicineDetails.getDrugName());
	  medicine.setStock(medicineDetails.getStock());
	  
	  Medicine saveMedicine =medicineRepository.save(medicine);
	  
	  return ResponseEntity.ok(saveMedicine);
	   
   }

  
  @GetMapping("/{id}")
  public ResponseEntity<Medicine>getMedicineById(@PathVariable long id) throws AttributeNotFoundException 
  {
	  Medicine medicine=medicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine not found with id"+id));
 	
 	return ResponseEntity.ok(medicine);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Boolean>>delete(@PathVariable long id) throws AttributeNotFoundException
  {
	  Medicine medicine=medicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine not found with id"+id));
	  medicineRepository.delete(medicine);
	  
	  Map<String, Boolean> response=new HashMap<String,Boolean>();
	  response.put("Deleted",Boolean.TRUE);
	  
	  return ResponseEntity.ok(response);
	  
  }
 
  
}
