package edu.mum.cs.cs425.fsap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("edu.mum.cs.cs425.fsap")
public class FsapApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsapApplication.class, args);
	}

}
