package com.mediscreen.users;

import com.mediscreen.users.interfaces.PatientService;
import com.mediscreen.users.models.Patient;
import com.mediscreen.users.repositories.PatientRepository;
import com.mediscreen.users.services.PatientServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class PatientTests {

    @MockBean
    private PatientRepository patientRepository;

    private PatientService patientService;

    @BeforeEach
    public void Setup() {
        patientService = new PatientServiceImpl(patientRepository);
    }

    @Test
    public void testCreatePatient() {
        // given
        Patient patient = new Patient();
        patient.setFamily("Test");
        patient.setGiven("Test");
        patient.setSex("F");

        // when
        when(patientRepository.save(Mockito.any(Patient.class))).thenReturn(patient);
        Patient savedPatient = patientService.addPatient(patient);


        // then
        Assertions.assertNotNull(savedPatient);
        Assertions.assertEquals(savedPatient.getFamily(), "Test");
        verify(patientRepository).save(Mockito.any(Patient.class));
    }

    @Test
    public void testUpdatePatient() {
        // given
        Patient patient = new Patient();
        patient.setFamily("Test");
        patient.setId(1);
        patient.setGiven("Test");
        patient.setSex("F");

        // when
        when(patientRepository.save(Mockito.any(Patient.class))).thenReturn(patient);
        when(patientRepository.findById(Mockito.anyInt())).thenReturn(patient);
        Patient savedPatient = patientService.updatePatient(1, patient);


        // then
        Assertions.assertNotNull(savedPatient);
        Assertions.assertEquals(savedPatient.getFamily(), "Test");
        Assertions.assertEquals(savedPatient.getId(), 1);
        verify(patientRepository).findById(anyInt());
        verify(patientRepository).save(Mockito.any(Patient.class));
    }

    @Test
    public void testGetPatient() {
        // given
        Patient patient = new Patient();
        patient.setFamily("Test");
        patient.setId(1);
        patient.setGiven("Test");
        patient.setSex("F");

        // when
        when(patientRepository.findById(Mockito.anyInt())).thenReturn(patient);
        Patient savedPatient = patientService.getPatient(1);


        // then
        Assertions.assertNotNull(savedPatient);
        Assertions.assertEquals(savedPatient.getFamily(), "Test");
        Assertions.assertEquals(savedPatient.getId(), 1);
        verify(patientRepository).findById(anyInt());
    }

    @Test
    public void testDeletePatient() {
        // when
        patientService.deletePatient(1);


        // then
        verify(patientRepository).deleteById(anyInt());
    }

    @Test
    public void testGetAllPatients() {
        // given
        Patient patient = new Patient();
        patient.setFamily("Test");
        patient.setId(1);
        patient.setGiven("Test");
        patient.setSex("F");
        List<Patient> patients = new ArrayList<>();
        patients.add(patient);
        when(patientRepository.findAll()).thenReturn(patients);

        // when
        Collection<Patient> patientList = patientService.patientsList();

        // then
        Assertions.assertEquals(patientList.size(), 1);
        Assertions.assertEquals(patientList.iterator().next().getId(), 1);
    }

}
