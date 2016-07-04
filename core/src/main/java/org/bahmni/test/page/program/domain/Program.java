package org.bahmni.test.page.program.domain;

public class Program {

	private String name;

	private String dateOfRegistration;

	private String treatmentStatus;

	private String doctor;

	private String facilityName;

	private String facilityID;

	private String enrollmentID;

	public Program(String name, String dateOfRegistration, String doctor, String facilityName,
				   String facilityID, String enrollmentID) {
		this.name = name;
		this.dateOfRegistration = dateOfRegistration;
		this.doctor = doctor;
		this.facilityName = facilityName;
		this.facilityID = facilityID;
		this.enrollmentID = enrollmentID;

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

	public String getTreatmentStatus() { return treatmentStatus; }

	public String getDoctor() { return this.doctor; }

	public String getFacilityName() { return this.facilityName; }

	public String getFacilityID() { return this.facilityID; }

	public String getEnrollmentID() { return this.enrollmentID; }

}
