package com.udacity.ExtraConsumeSoap;

import com.daehosting.webservices.isbn.IsValidISBN10Response;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@SpringBootApplication
public class ExtraConsumeSoapApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExtraConsumeSoapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ISBNClient isbnClient = new ISBNClient();

		//create and setup marshaller
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

		//provide location to the ObjectFacory
		marshaller.setContextPath("com.daehosting.webservices.isbn");

		//add marshaller to the client
		isbnClient.setMarshaller(marshaller);
		isbnClient.setUnmarshaller(marshaller);

		IsValidISBN10Response response = isbnClient.validate("007462542X");

		System.out.println("Response is: " + response.isIsValidISBN10Result());
	}
}
