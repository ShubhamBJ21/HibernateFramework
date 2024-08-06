package com.person.dao;

import java.util.List;
import java.util.Scanner;

import com.person.dto.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class PersonDao {
	Scanner sc = new Scanner(System.in);

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shubham");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		try {
			entityTransaction.begin();
			entityManager.persist(person);
			entityTransaction.commit();

		} catch (Exception e) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		System.out.println("New Person Details Entered Successfully");
	}
	
	public Person findPersonById() {
		EntityManager entityManager = getEntityManager();
		
		Query query = entityManager.createQuery("Select p from Person p where p.id = :id");
		
		System.out.println("Enter person id");
		query.setParameter("id", sc.nextInt());
		
		return (Person) query.getSingleResult();
	}
}
