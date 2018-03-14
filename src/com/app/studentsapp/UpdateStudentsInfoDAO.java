package com.app.studentsapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentsInfoDAO {
	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(StudentsInfoDTO.class);

		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		StudentsInfoDTO student = session.load(StudentsInfoDTO.class, 28);
		student.setFirstName("Vikas");
		student.setMiddleName("Kumar");
		student.setLastName("Roy");

		session.update(student);

		session.beginTransaction().commit();

	}

}
