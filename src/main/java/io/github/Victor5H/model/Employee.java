package io.github.Victor5H.model;

public class Employee {
	private int id;
	private String nameString;
	private String emailString;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public Employee(int id, String nameString, String emailString) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.emailString = emailString;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", nameString=" + nameString + ", emailString=" + emailString + "]";
	}

}
