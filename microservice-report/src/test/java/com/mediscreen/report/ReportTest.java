package com.mediscreen.report;

import com.mediscreen.report.model.PatientInfo;
import com.mediscreen.report.proxies.WebProxy;
import com.mediscreen.report.service.ReportService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * The type Report test.
 */
@SpringBootTest
public class ReportTest {


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

    /**
     * Number of trigger terms test.
     */
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

    /**
     * Get type of risk has no risk levels.
     */
    @Test
    public void getTypeOfRisk_HasNoRiskLevels(){
        PatientInfo patientInfo = new PatientInfo("M", 69, Arrays.asList("Hémoglobine A1C"));

        //when
        when(webProxy.getPatientInfo(anyInt())).thenReturn(patientInfo);
        String None = reportService.getTypeOfRisk(0);

        //then
        Assertions.assertEquals("NONE", None);
    }

    /**
     * Get type of risk borderline.
     */
    @Test
    public void getTypeOfRisk_Borderline(){
        PatientInfo patientInfo = new PatientInfo("M", 69, Arrays.asList("Hémoglobine A1C", "Microalbumine"));

        //when
        when(webProxy.getPatientInfo(anyInt())).thenReturn(patientInfo);
        String borderline = reportService.getTypeOfRisk(0);

        //then
        Assertions.assertEquals("Borderline", borderline);
    }

    /**
     * Get type of risk early onset is men and below thirty.
     */
    @Test
    public void getTypeOfRisk_EarlyOnsetIsMenAndBelowThirty(){
        PatientInfo patientInfo = new PatientInfo("M", 29, Arrays.asList("Hémoglobine A1C", "Microalbumine", "Taille", "Poids", "Fumeur"));

        //when
        when(webProxy.getPatientInfo(anyInt())).thenReturn(patientInfo);
        String earlyOnset = reportService.getTypeOfRisk(0);

        //then
        Assertions.assertEquals("Early onset", earlyOnset);
    }

    /**
     * Get type of risk early onset is women and below thirty.
     */
    @Test
    public void getTypeOfRisk_EarlyOnsetIsWomenAndBelowThirty(){
        PatientInfo patientInfo = new PatientInfo("F", 29, Arrays.asList("Hémoglobine A1C",
                "Microalbumine",
                "Taille",
                "Poids",
                "Fumeur",
                "Anormal",
                "Cholestérol"));

        //when
        when(webProxy.getPatientInfo(anyInt())).thenReturn(patientInfo);
        String earlyOnset = reportService.getTypeOfRisk(0);

        //then
        Assertions.assertEquals("Early onset", earlyOnset);
    }

    /**
     * Get type of risk early onset above thirty.
     */
    @Test
    public void getTypeOfRisk_EarlyOnsetAboveThirty(){
        PatientInfo patientInfo = new PatientInfo("F", 59, Arrays.asList("Hémoglobine A1C",
                "Microalbumine",
                "Taille",
                "Poids",
                "Fumeur",
                "Anormal",
                "Cholestérol",
                "Vertige"));

        //when
        when(webProxy.getPatientInfo(anyInt())).thenReturn(patientInfo);
        String earlyOnset = reportService.getTypeOfRisk(0);

        //then
        Assertions.assertEquals("Early onset", earlyOnset);
    }

    /**
     * Get type of risk in danger above thirty.
     */
    @Test
    public void getTypeOfRisk_InDangerAboveThirty(){
        PatientInfo patientInfo = new PatientInfo("F", 59, Arrays.asList("Hémoglobine A1C",
                "Microalbumine",
                "Taille",
                "Poids",
                "Fumeur",
                "Anormal"));

        //when
        when(webProxy.getPatientInfo(anyInt())).thenReturn(patientInfo);
        String inDanger = reportService.getTypeOfRisk(0);

        //then
        Assertions.assertEquals("In Danger", inDanger);
    }

    /**
     * Get type of risk in danger is women and below thirty.
     */
    @Test
    public void getTypeOfRisk_InDanger_IsWomenAndBelowThirty(){
        PatientInfo patientInfo = new PatientInfo("F", 29, Arrays.asList("Hémoglobine A1C",
                "Microalbumine",
                "Taille",
                "Poids"));

        //when
        when(webProxy.getPatientInfo(anyInt())).thenReturn(patientInfo);
        String inDanger = reportService.getTypeOfRisk(0);

        //then
        Assertions.assertEquals("In Danger", inDanger);
    }

    /**
     * Get type of risk in danger is men and below thirty.
     */
    @Test
    public void getTypeOfRisk_InDanger_IsMenAndBelowThirty(){
        PatientInfo patientInfo = new PatientInfo("M", 29, Arrays.asList("Hémoglobine A1C",
                "Microalbumine",
                "Taille"));

        //when
        when(webProxy.getPatientInfo(anyInt())).thenReturn(patientInfo);
        String inDanger = reportService.getTypeOfRisk(0);

        //then
        Assertions.assertEquals("In Danger", inDanger);
    }

    /**
     * Get type of risk none.
     */
    @Test
    public void getTypeOfRisk_None(){
        PatientInfo patientInfo = new PatientInfo("M", 29, Arrays.asList(" ", " "));

        //when
        when(webProxy.getPatientInfo(anyInt())).thenReturn(patientInfo);
        String none = reportService.getTypeOfRisk(0);

        //then
        Assertions.assertEquals("NONE", none );
    }
}
