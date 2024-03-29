package com.mediscreen.web.proxies;

import com.mediscreen.web.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * The interface Report proxy.
 */
@FeignClient(name = "report-proxy-report-api", url = "${reportAPI.service.url}", configuration = FeignConfig.class)
public interface ReportProxy {

    /**
     * Gets report.
     *
     * @param id the id
     * @return the report
     */
    @GetMapping("/assess/{id}")
    String getReport(@PathVariable int id);

    /**
     * Gets number of trigger terms.
     *
     * @param id the id
     * @return the number of trigger terms
     */
    @GetMapping("/numberOfTriggerTermsByPatientId/{id}")
    int getNumberOfTriggerTerms(@PathVariable int id);
}
