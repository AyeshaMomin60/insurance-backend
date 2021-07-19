package com.cg.policy.Insurance.Policy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class InsurancePolicyApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(InsurancePolicyApplication.class, args);
	}

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	       return application.sources(InsurancePolicyApplication.class);
	    }

}
