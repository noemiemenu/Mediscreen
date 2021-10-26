package com.mediscreen.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediscreen.users.controllers.PatientsController;
import com.mediscreen.users.interfaces.PatientService;
import com.mediscreen.users.models.Patient;
import com.mediscreen.users.repositories.PatientRepository;
import com.mediscreen.users.services.PatientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
public class PatientControllerTests {

    @MockBean
    private PatientRepository patientRepository;


    private PatientService patientService;



    @BeforeEach
    public void Setup() {
        patientService = new PatientServiceImpl(patientRepository);
    }

    private MockMvc mockMvc;

    @InjectMocks
    private PatientsController patientsController;

    /**
     * Setup.
     */
    @BeforeEach
    public void setup() {
        patientsController = new PatientsController(patientService);
        mockMvc = MockMvcBuilders.standaloneSetup(patientsController).build();
    }

    @Test
    public void findByIdTest() throws Exception {
        Patient patient = new Patient();
        patient.setId(1);
        patient.setFirstName("Noémie");
        patient.setLastName("menu");
        patient.setSex("F");
        patient.setAddress("address");
        patient.setPhone("111-111-111");


        when(patientRepository.findById(1)).thenReturn(patient);

        mockMvc.perform(MockMvcRequestBuilders.
                        get("/patient/{id}", patient.getId()))
                .andExpect(status().isOk());

    }
    @Test
    public void addPatientTest() throws Exception {
        Patient patient = new Patient();
        patient.setId(1);
        patient.setFirstName("Noémie");
        patient.setLastName("menu");
        patient.setSex("F");
        patient.setAddress("address");
        patient.setPhone("111-111-111");
        patient.setDob(LocalDate.now());

        when(patientRepository.save(any(Patient.class))).thenReturn(patient);


        mockMvc.perform(MockMvcRequestBuilders.
                        post(String.format(
                                "/patient/add?firstName=%s&lastName=%s&address=%s&phone=%s&sex=%s&dob=%s",
                                patient.getFirstName(),
                                patient.getLastName(),
                                patient.getAddress(),
                                patient.getPhone(),
                                patient.getSex(),
                                patient.getDob()
                        )))
                .andExpect(status().isOk());
    }

    @Test
    public void deletePatientTest() throws Exception {
        Patient patient = new Patient();
        patient.setId(1);

        mockMvc.perform(MockMvcRequestBuilders.
                        get("/patient/delete/{id}", patient.getId()))
                .andExpect(status().isOk());

    }

    @Test
    public void updatePatientTest() throws Exception{
        Patient patient = new Patient();
        patient.setId(1);
        patient.setFirstName("Noémie");
        patient.setLastName("menu");
        patient.setSex("F");
        patient.setAddress("address");
        patient.setPhone("111-111-111");
        patient.setDob(LocalDate.now());

        when(patientRepository.findById(anyInt())).thenReturn(patient);


        mockMvc.perform(MockMvcRequestBuilders.
                        patch(String.format(
                                "/patient/update/{id}?firstName=%s&lastName=%s&address=%s&phone=%s&sex=%s&dob=%s",
                                patient.getFirstName(),
                                patient.getLastName(),
                                patient.getAddress(),
                                patient.getPhone(),
                                patient.getSex(),
                                patient.getDob()
                        ), patient.getId()))
                .andExpect(status().isOk());
    }
}

