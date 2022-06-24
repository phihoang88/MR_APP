package MR.RES.MRAPI;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.IOException;

@SpringBootApplication
@ComponentScan(basePackages= {"MR.RES.MRAPI"})
@ComponentScan(basePackages = {"MR.RES.MRAPI.api"})
@ComponentScan(basePackages = {"MR.RES.MRAPI.service"})
@EnableAutoConfiguration
@EnableJpaRepositories("MR.RES.MRAPI.service")
@EnableJpaAuditing
public class MrapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MrapiApplication.class, args);
	}

}
