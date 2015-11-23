package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan({"br.ufrn.pronatal.controllers"})
public class Application  extends WebMvcAutoConfiguration{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
