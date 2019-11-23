package tech.lideo.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompanyApplication {

	public static void main(String[] args) {
		//@fixme integration test .. 100 employee .. update .. delete .. etc
		SpringApplication.run(CompanyApplication.class, args);
	}

}
