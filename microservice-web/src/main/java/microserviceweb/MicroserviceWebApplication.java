package microserviceweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("microserviceweb")
@EnableDiscoveryClient
public class MicroserviceWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceWebApplication.class, args);
    }

}
