package com.demo.car_parking_management;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.parking.entities.Admin;
import com.demo.parking.entities.Car;
import com.demo.parking.entities.ParkingFees;
import com.demo.parking.entities.User;


public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		try {
			return new
					Configuration().configure("Hibernate.cfg.xml").addAnnotatedClass(User.class)
					.addAnnotatedClass(Admin.class)
					.addAnnotatedClass(Car.class)
					.addAnnotatedClass(ParkingFees.class)
					.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}

