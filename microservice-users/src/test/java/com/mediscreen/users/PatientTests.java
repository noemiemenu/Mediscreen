package com.mediscreen.users;

import com.mediscreen.users.interfaces.PatientService;
import com.mediscreen.users.models.Patient;
import com.mediscreen.users.repositories.PatientRepository;
import com.mediscreen.users.services.PatientServiceImpl;
import org.hibernate.type.descriptor.java.LocaleTypeDescriptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDate;
import java.util.*;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Patient tests.
 */
@SpringBootTest(classes = {PatientRepository.class})
public class PatientTests {

    @MockBean
    private PatientRepository patientRepository;

    private PatientService patientService;

    /**
     * Setup.
     */
    @BeforeEach
    public void Setup() {
        patientService = new PatientServiceImpl(patientRepository);
    }

    private MockMvc mockMvc;

    /**
     * Test create patient.
     */
    @Test
    public void testCreatePatient() throws Exception {
        // given
        Patient patient = new Patient();
        patient.setSex("F");
        patient.setFirstName("Noémie");
        patient.setLastName("menu");

        // when
        when(patientRepository.save(Mockito.any(Patient.class))).thenReturn(patient);
        Patient savedPatient = patientService.addPatient(patient);


        // then
        Assertions.assertNotNull(savedPatient);
        Assertions.assertEquals(savedPatient.getFirstName(), "Noémie");
        Assertions.assertEquals(savedPatient.getLastName(), "menu");
        verify(patientRepository).save(Mockito.any(Patient.class));
    }

    /**
     * Test update patient.
     */
    @Test
    public void testUpdatePatient() {
        // given
        Patient patient = new Patient();
        patient.setId(1);
        patient.setSex("F");
        patient.setFirstName("Noémie");
        patient.setLastName("menu");

        // when
        when(patientRepository.save(Mockito.any(Patient.class))).thenReturn(patient);
        when(patientRepository.findById(Mockito.anyInt())).thenReturn(patient);
        Patient savedPatient = patientService.updatePatient(1, patient);


        // then
        Assertions.assertNotNull(savedPatient);
        Assertions.assertEquals(savedPatient.getId(), 1);
        Assertions.assertEquals(savedPatient.getFirstName(), "Noémie");
        Assertions.assertEquals(savedPatient.getLastName(), "menu");
        verify(patientRepository).findById(anyInt());
        verify(patientRepository).save(Mockito.any(Patient.class));
    }

    /**
     * Test get patient.
     */
    @Test
    public void testGetPatient() {
        // given
        Patient patient = new Patient();
        patient.setId(1);
        patient.setSex("F");
        patient.setFirstName("Noémie");
        patient.setLastName("menu");


        // when
        when(patientRepository.findById(Mockito.anyInt())).thenReturn(patient);
        Patient savedPatient = patientService.getPatient(1);


        // then
        Assertions.assertNotNull(savedPatient);
        Assertions.assertEquals(savedPatient.getId(), 1);
        Assertions.assertEquals(savedPatient.getFirstName(), "Noémie");
        Assertions.assertEquals(savedPatient.getLastName(), "menu");
        verify(patientRepository).findById(anyInt());
    }

    /**
     * Test delete patient.
     */
    @Test
    public void testDeletePatient() {
        // when
        patientService.deletePatient(1);

        // then
        verify(patientRepository).deleteById(anyInt());
    }

    /**
     * Test get all patients.
     */
    @Test
    public void testGetAllPatients() {
        // given
        Patient patient = new Patient();
        patient.setId(1);
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
