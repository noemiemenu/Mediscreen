package microserviceweb.controller;

import microserviceweb.model.MedicalAccount;
import microserviceweb.proxies.MedicalAccountProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MedicalAccountController {

    @Autowired
    private MedicalAccountProxy medicalAccountProxy;




}
