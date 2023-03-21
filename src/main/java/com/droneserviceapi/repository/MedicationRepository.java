package com.droneserviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.droneserviceapi.modal.Medication;

/**
 * 
 * @author chaturanand Yadav
 * @since 2023-03-21
 *
 */
public interface MedicationRepository extends JpaRepository<Medication, String> {
	
	@Query(value = "SELECT * from medication e where e.code =:id ", nativeQuery = true) // using @query with
	Medication findByCode(@Param("id") String id);

}
