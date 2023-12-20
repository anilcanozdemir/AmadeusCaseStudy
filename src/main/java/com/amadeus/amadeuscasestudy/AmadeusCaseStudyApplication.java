package com.amadeus.amadeuscasestudy;

import com.amadeus.amadeuscasestudy.Controller.FlightController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AmadeusCaseStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmadeusCaseStudyApplication.class, args);
    }

}
