package com.rks.clinicalsapi.repos;

import com.rks.clinicalsapi.model.ClinicalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> {
}
