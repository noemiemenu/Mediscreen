package com.mediscreen.report.proxies;

import com.mediscreen.report.config.FeignConfig;
import com.mediscreen.report.model.PatientInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "web-proxy-web-api", url = "${webAPI.service.url}", configuration = FeignConfig.class)
public interface WebProxy {

    @GetMapping("/patientInfo/{id}")
    PatientInfo getPatientInfo(@PathVariable("id") Integer id);

}
