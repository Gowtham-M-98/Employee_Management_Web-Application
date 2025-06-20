package com.project.EmployeeManagement_CRUD.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String name;
    private String email;
    private String userName;
    private String password;
    private String confirmPassword;
    
    //Constructor
    public Users() {
    	super();
    }
    
    public Users(int id, String name, String email, String userName, String password, String confirmPassword) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
    
	//Getters and Setters
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
