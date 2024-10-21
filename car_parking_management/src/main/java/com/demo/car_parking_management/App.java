package com.demo.car_parking_management;
import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.parking.entities.User;



public class App {
	public static void main(String[] args) {
		// Obtain a Hibernate SessionFactory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		// Create a new Student
		LocalDate date1 = LocalDate.of(1988, 1, 13);
		User User1 = new User("S111", "Oliver", "Henry", date1, "M","oliver@gmail.com", "6742906745");
		// Open a new session
		Session session = factory.openSession();
		// Begin a transaction
		Transaction transaction = session.beginTransaction();
		// Save the student to the database
		session.save(User1);
		// Commit the transaction
		transaction.commit();
		// Close the Session
		session.close();
		//Close the Session Factory
		factory.close();
	}
}

