package com.rks.clinicalsapi.repos;

import com.rks.clinicalsapi.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
