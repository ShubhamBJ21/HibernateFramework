package com.person.controller;

import com.person.dao.PersonDao;
import com.person.dto.Person;

public class Main {

	public static void main(String[] args) {
		Person person = new Person("shubham", "satara", "sj@gmail.com");
		
		PersonDao dao = new PersonDao();
		//dao.savePerson(person);
		System.out.println(dao.findPersonById());	
		
		
	}

}
