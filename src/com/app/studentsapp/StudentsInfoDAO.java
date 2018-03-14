package com.app.studentsapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentsInfoDAO {
	public static void main(String[] args) {
		StudentsInfoDTO sinfo = new StudentsInfoDTO();
		sinfo.setRegNo(28);
		sinfo.setFirstName("Test");
		sinfo.setMiddleName("MidlleNamwe");
		sinfo.setLastName("OtherLast");

		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(StudentsInfoDTO.class);

		SessionFactory sf = config.buildSessionFactory();
		Session sess = sf.openSession();

		sess.save(sinfo);

		Transaction tx = sess.beginTransaction();
		tx.commit();
	}

}
