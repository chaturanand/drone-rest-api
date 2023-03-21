package com.droneserviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.droneserviceapi.modal.Medication;

/**
 * 
 * @author chaturanand Yadav
 * @since 2023-03-21
 *
 */
public interface MedicationPreloadDataRepository extends JpaRepository<Medication, String> {

	
	
}
