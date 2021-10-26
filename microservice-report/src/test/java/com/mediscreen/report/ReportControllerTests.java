package com.mediscreen.report;

import com.mediscreen.report.controller.ReportController;
import com.mediscreen.report.model.PatientInfo;
import com.mediscreen.report.proxies.WebProxy;
import com.mediscreen.report.service.ReportService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ReportControllerTests {


    private MockMvc mockMvc;

    private ReportService reportService;

    @MockBean
    private WebProxy webProxy;

    /**
     * Setup.
     */
    @BeforeEach
    public void Setup() {
        reportService = new ReportService(webProxy);
    }

    @InjectMocks
    private ReportController reportController;

    /**
     * Setup.
     */
    @BeforeEach
    public void setup() {
        reportController = new ReportController(reportService);
        mockMvc = MockMvcBuilders.standaloneSetup(reportController).build();
    }

    @Test
    public void numberOfTriggerTermsControllerTest() throws Exception {
        //given
        PatientInfo patientInfo = new PatientInfo("M", 30, Arrays.asList("Hémoglobine A1C", "Microalbumine", "Taille", "Poids", "Fumeur", "Anormal"));

        //when
        when(webProxy.getPatientInfo(anyInt())).thenReturn(patientInfo);


        //then
        mockMvc.perform(MockMvcRequestBuilders.
                        get("/numberOfTriggerTermsByPatientId/{id}", 1))
                .andExpect(status().isOk());
    }
    @Test
    public void getReportController() throws Exception {
        //given
        PatientInfo patientInfo = new PatientInfo("M", 30, Arrays.asList("Hémoglobine A1C", "Microalbumine", "Taille", "Poids", "Fumeur", "Anormal"));

        //when
        when(webProxy.getPatientInfo(anyInt())).thenReturn(patientInfo);


        //then
        mockMvc.perform(MockMvcRequestBuilders.
                        get("/assess/{id}", 1))
                .andExpect(status().isOk());
    }



}
