package com.mediscreen.web.proxies;

import com.mediscreen.web.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "report-proxy-report-api", url = "${reportAPI.service.url}", configuration = FeignConfig.class)
public interface ReportProxy {

    @GetMapping("/assess/{id}")
    String getReport(@PathVariable int id);

    @GetMapping("/numberOfTriggerTermsByPatientId/{id}")
    int getNumberOfTriggerTerms(@PathVariable int id);
}
