package com.mediscreen.report.proxies;

import com.mediscreen.report.config.FeignConfig;
import com.mediscreen.report.model.PatientInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * The interface Web proxy.
 */
@FeignClient(name = "web-proxy-web-api", url = "${webAPI.service.url}", configuration = FeignConfig.class)
public interface WebProxy {

    /**
     * Gets patient info.
     *
     * @param id the id
     * @return the patient info
     */
    @GetMapping("/patientInfo/{id}")
    PatientInfo getPatientInfo(@PathVariable("id") Integer id);

}
