package com.app.studentsapp.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.app.studentsapp.StudentsInfoDTO;

public class SelectMultipleColumnWithPrimaryKey {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure().addAnnotatedClass(StudentsInfoDTO.class);
		
		Session session = configuration.buildSessionFactory().openSession();
		
		String hql = "select regNo,lastName from StudentsInfoDTO where regNo = 1";
		Query query = session.createQuery(hql);
		Object[] objects = (Object[])query.uniqueResult();
		
		System.out.println(objects[0]);
		System.out.println(objects[1]);
		
	}

}
