package org.bahmni.test.page.registration.domain;

import java.util.Date;

public class Patient {
	private String idNumber;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private Date dateOfBirth;

	public Patient(String idNumber, String firstName, String lastName, String gender, Date dateOfBirth, int age) {
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getAge() {
		return age + "";
	}
}
