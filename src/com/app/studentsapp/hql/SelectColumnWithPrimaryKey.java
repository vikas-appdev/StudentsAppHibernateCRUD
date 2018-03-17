package com.app.studentsapp.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.app.studentsapp.StudentsInfoDTO;

public class SelectColumnWithPrimaryKey {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure().addAnnotatedClass(StudentsInfoDTO.class);
		
		Session session = config.buildSessionFactory().openSession();
		
		String hql = "select firstName from StudentsInfoDTO where regno=1";
		
		Query query = session.createQuery(hql);
		String name = (String)query.uniqueResult();
		
		System.out.println(name);
	}

}
