package com.rks.clinicalsapi.controller;

import com.rks.clinicalsapi.dto.ClinicalDataRequest;
import com.rks.clinicalsapi.model.ClinicalData;
import com.rks.clinicalsapi.model.Patient;
import com.rks.clinicalsapi.repos.ClinicalDataRepository;
import com.rks.clinicalsapi.repos.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClinicalDataController {

    private ClinicalDataRepository clinicalDataRepository;
    private PatientRepository patientRepository;

    @Autowired
    public ClinicalDataController(ClinicalDataRepository c, PatientRepository p) {
        this.clinicalDataRepository = c;
        this.patientRepository = p;
    }

    @PostMapping(value = "/clinicals")
    public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request) {
        Patient patient = patientRepository.findById(request.getPatientId()).get();
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(request.getComponentName());
        clinicalData.setComponentValue(request.getComponentValue());
        clinicalData.setPatient(patient);
        return clinicalDataRepository.save(clinicalData);
    }
}
