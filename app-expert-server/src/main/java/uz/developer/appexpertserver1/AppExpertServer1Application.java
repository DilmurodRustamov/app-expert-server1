package uz.developer.appexpertserver1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@SpringBootApplication
//@Configuration
//@EnableJpaRepositories
//@Import(RepositoryRestMvcConfiguration.class)
//@EnableAutoConfiguration
public class AppExpertServer1Application {

    public static void main(String[] args) {
        SpringApplication.run(AppExpertServer1Application.class, args);
    }

}
