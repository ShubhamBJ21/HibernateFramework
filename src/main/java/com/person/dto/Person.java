package com.person.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity                        //used to map class with database it is a class level annotation
@Table(name = "Person_vs")     //used to modify a table name in database it is also a class level annotation
public class Person {
                               //inside a class all annotations are field level annotation
	@Id                        //This is used to declare a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)      //this is used to auto-generated
	private int id;
	
	@Column(name = "name", nullable = false)   //
	private String name;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	public Person() {
		//no argument constructor
	}

	public Person(String name, String address, String email) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + "]";
	}
}
