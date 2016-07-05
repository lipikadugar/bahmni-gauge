package org.bahmni.endtb.page.program.domain;

import org.bahmni.test.page.program.domain.Program;

public class EndTBProgram extends Program {

	private String registrationNumber;

	private String registrationFacility;

	public EndTBProgram(String name, String dateOfRegistration, String registrationNumber, String registrationFacility) {
		super(name, dateOfRegistration);
		this.registrationNumber = registrationNumber;
		this.registrationFacility = registrationFacility;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getRegistrationFacility() {
		return registrationFacility;
	}
}
