package com.mobileserviceapi.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class UserImpl implements Person {
	
	public int id;
	
	@NotNull
	@Size(min=4, max=30, message = "Username should be between 4-30 characters long")
	public String username;
	
	@NotNull
	@Size(min=4, max=30, message = "Password should be between 4-30 characters long")
	public String password;
	
	public int enabled;
	
	@Email(message="Wrong email format")
	@NotNull
	public String email;
	
	@NotNull
	@Min(value=16, message = "Age should be at least 16")
	public int age;

	@NotNull
	@Size(min=2, max=30, message = "Firstname should be between 2-30 characters long")
	public String firstname;

	@NotNull
	@Size(min=2, max=30, message = "Lastname should be between 2-30 characters long")
	public String lastname;
	
	/**
	 * 
	 */
	public UserImpl() {
		super();
	}
	/**
	 * @param id
	 * @param username
	 * @param enabled
	 * @param email
	 * @param age
	 * @param firstname
	 * @param lastname
	 */
	public UserImpl(int id, String username, int enabled, String email,
			int age, String firstname, String lastname) {
		super();
		this.id = id;
		this.username = username;
		this.enabled = enabled;
		this.email = email;
		this.age = age;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param enabled
	 * @param email
	 * @param age
	 * @param firstname
	 * @param lastname
	 */
	public UserImpl(int id, String username, String password, int enabled,
			String email, int age, String firstname, String lastname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.email = email;
		this.age = age;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the enabled
	 */
	public int getEnabled() {
		return enabled;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}	
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 *  Note that the abstract class has the same variablename as in this class
	 * 	public abstract String getLastName();
	 * 	public abstract void setLastName(String lastName);
	 */
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "PersonImpl [id=" + id + ", username=" + username
				+ ", password=" + password + ", enabled=" + enabled
				+ ", email=" + email + ", age=" + age + ", firstname="
				+ firstname + ", lastname=" + lastname + "]";
	}


	
	
}
