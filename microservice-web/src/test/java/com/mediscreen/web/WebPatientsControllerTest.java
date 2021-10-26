package com.mediscreen.web;

import com.mediscreen.web.controller.WebPatientsController;
import com.mediscreen.web.model.Patient;
import com.mediscreen.web.proxies.PatientProxy;
import com.mediscreen.web.proxies.ReportProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class WebPatientsControllerTest {

    @InjectMocks
    private WebPatientsController webPatientsController;

    @MockBean
    private PatientProxy patientProxy;

    @MockBean
    private ReportProxy reportProxy;


    private MockMvc mockMvc;

    /**
     * Setup.
     */
    @BeforeEach
    public void setup() {
        webPatientsController = new WebPatientsController(patientProxy, reportProxy);
        mockMvc = MockMvcBuilders.standaloneSetup(webPatientsController).build();
    }

    @Test
    public void testDeletePatient() throws Exception {
        // given
        Patient patient = new Patient();
        patient.setId(1);
        patient.setSex("F");
        patient.setFirstName("Noémie");
        patient.setLastName("menu");


        doNothing().when(patientProxy).deletePatient(anyInt());

        mockMvc.perform(MockMvcRequestBuilders.
                        get("/patient/delete/{id}", patient.getId()))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void testUpdatePatient() throws Exception {
        // given
        Patient patient = new Patient();
        patient.setId(1);
        patient.setFirstName("Noémie");
        patient.setLastName("menu");
        patient.setSex("F");
        patient.setAddress("address");
        patient.setPhone("111-111-111");
        patient.setDob(LocalDate.now());


        when(patientProxy.updatePatient(patient.getId(),
                patient.getSex(),
                patient.getAddress(),
                patient.getLastName(),
                patient.getFirstName(),
                patient.getPhone(),
                String.valueOf(patient.getDob()))).thenReturn(patient);


        mockMvc.perform(MockMvcRequestBuilders.
                        post(String.format(
                                "/patient/update/{id}?firstName=%s&lastName=%s&address=%s&phone=%s&sex=%s&dob=%s",
                                patient.getFirstName(),
                                patient.getLastName(),
                                patient.getAddress(),
                                patient.getPhone(),
                                patient.getSex(),
                                patient.getDob()
                        ), patient.getId()))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void testAddPatient() throws Exception {
        // given
        Patient patient = new Patient();
        patient.setId(1);
        patient.setFirstName("Noémie");
        patient.setLastName("menu");
        patient.setSex("F");
        patient.setAddress("address");
        patient.setPhone("111-111-111");
        patient.setDob(LocalDate.now());


        doNothing().when(patientProxy).addPatient(
                patient.getSex(),
                patient.getAddress(),
                patient.getLastName(),
                patient.getFirstName(),
                patient.getPhone(),
                String.valueOf(patient.getDob()));


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
                .andExpect(status().is3xxRedirection());
    }



}
