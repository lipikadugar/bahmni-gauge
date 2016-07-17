package org.bahmni.test.page.registration.domain;

import java.util.Date;

public class Patient {
	private String prefix;
	private String idNumber;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private Date dateOfBirth;
	private String village;

	public Patient(String prefix,String idNumber, String firstName, String lastName, String gender, Date dateOfBirth, int age, String village) {
		this.prefix = prefix;
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.village = village;
	}

	public Patient(String firstName, String lastName, String gender, Date dateOfBirth, int age, String village) {
		this("","",firstName,lastName,gender,dateOfBirth,age,village);
	}

	public Patient(String idNumber,String firstName, String lastName, String gender, Date dateOfBirth, int age, String village) {
		this("",idNumber,firstName,lastName,gender,dateOfBirth,age,village);
	}

	public String getPrefix() {
		return prefix;
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

	public String getVillage(){ return village; }
}
