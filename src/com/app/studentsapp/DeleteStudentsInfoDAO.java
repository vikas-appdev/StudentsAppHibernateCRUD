package com.app.studentsapp;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class DeleteStudentsInfoDAO {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(StudentsInfoDTO.class);

		Session sess = config.buildSessionFactory().openSession();
		StudentsInfoDTO stu = sess.load(StudentsInfoDTO.class, 589);
		sess.delete(stu);
		sess.beginTransaction().commit();
	}

}
