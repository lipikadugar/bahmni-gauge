package org.bahmni.test.page.program.domain;

public class Program {

	private String name;

	private String dateOfRegistration;

	private String treatmentStatus;

	public Program(String name, String dateOfRegistration) {
		this.name = name;
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getName() {
		return name;
	}

	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setTreatmentStatus(String treatmentStatus) {
		this.treatmentStatus = treatmentStatus;
	}

	public String getTreatmentStatus() {
		return treatmentStatus;
	}
}
