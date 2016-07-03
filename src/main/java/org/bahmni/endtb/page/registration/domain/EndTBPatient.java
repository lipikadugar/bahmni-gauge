package org.bahmni.endtb.page.registration.domain;

import org.bahmni.test.page.registration.domain.Patient;

import java.util.Date;

public class EndTBPatient extends Patient {

	private String nationalIdentificationNumber;

	public EndTBPatient(String idNumber, String firstName, String lastName, String gender, Date dateOfBirth, int age, String nationalIdentificationNumber) {
		super(idNumber, firstName, lastName, gender, dateOfBirth, age);
		this.nationalIdentificationNumber = nationalIdentificationNumber;
	}


	public String getNationalIdentificationNumber() {
		return nationalIdentificationNumber;
	}

}
