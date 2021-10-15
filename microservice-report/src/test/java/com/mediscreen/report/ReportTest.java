package com.mediscreen.report;

import com.mediscreen.report.model.PatientInfo;
import com.mediscreen.report.proxies.WebProxy;
import com.mediscreen.report.service.ReportService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReportTest {


    private ReportService reportService;

    @MockBean
    private WebProxy webProxy;

    @BeforeEach
    public void Setup() {
        reportService = new ReportService(webProxy);
    }

    @Test
    public void numberOfTriggerTermsTest(){
        //given
        PatientInfo patientInfo = new PatientInfo("M", 30, Arrays.asList("Hémoglobine A1C", "Microalbumine", "Taille", "Poids", "Fumeur", "Anormal"));

        //when
        when(webProxy.getPatientInfo(anyInt())).thenReturn(patientInfo);
        int numberOfTrigger = reportService.numberOfTriggerTerms(0);

        //then
        Assertions.assertEquals(6, numberOfTrigger);
    }


}
