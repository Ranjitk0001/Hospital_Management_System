package org.HMSApp.Hospital_Management_System.dologin.repository;

import org.HMSApp.Hospital_Management_System.dologin.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository  extends JpaRepository<Medicine, Long>{

}
