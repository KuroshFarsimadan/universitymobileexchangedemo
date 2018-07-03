package com.mobileserviceapi.model;

public interface User {
	
	public abstract int getId();

	public abstract void setId(int id);
	
	public abstract String getUsername();
	
	public abstract void setUsername(String username);
	
	public abstract String getPassword();
	
	public abstract void setPassword(String password);
	
	public abstract int getEnabled();
	
	public abstract void setEnabled(int enabled);
	
	public abstract String getEmail();
	
	public abstract void setEmail(String email);
	
	public abstract int getAge();
	
	public abstract void setAge(int age);
	
	public abstract String getFirstname();
	
	public abstract void setFirstname(String firstname);

	public abstract String getLastname();
	
	public abstract void setLastname(String lastname);

}
