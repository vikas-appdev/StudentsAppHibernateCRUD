package com.app.studentsapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoadStudentsInfoDAO {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(StudentsInfoDTO.class);

		SessionFactory sfx = config.buildSessionFactory();
		Session session = sfx.openSession();
		StudentsInfoDTO student = session.load(StudentsInfoDTO.class, 28);

		System.out.println(student.getFirstName());

	}

}
