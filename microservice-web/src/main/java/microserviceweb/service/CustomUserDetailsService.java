package microserviceweb.service;

import microserviceweb.model.MedicalAccount;
import microserviceweb.proxies.MedicalAccountProxy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MedicalAccountProxy medicalAccountProxy;

    public CustomUserDetailsService(MedicalAccountProxy medicalAccountProxy) {
        this.medicalAccountProxy = medicalAccountProxy;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        MedicalAccount medicalAccount = medicalAccountProxy.getMedicalAccountFindByEmail(userName);
        if (medicalAccount == null) {
            throw new UsernameNotFoundException("User not found: " + userName);
        }
        return org.springframework.security.core.userdetails.User.withUsername(medicalAccount.getEmail())
                .password(medicalAccount.getPassword())
                .build();
    }
}
