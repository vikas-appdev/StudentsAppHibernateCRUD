package com.app.studentsapp.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.app.studentsapp.StudentsInfoDTO;

public class ReadByColumnsStudentsInfoDAO {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure().addAnnotatedClass(StudentsInfoDTO.class);
		
		Session session = config.buildSessionFactory().openSession();
		
		String hql = "select regNo, firstName from StudentsInfoDTO";
		Query query =  session.createQuery(hql);
		
		List<Object[]> students =  query.list();
		
		for (Object[] objects : students) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
			System.out.println("============");
		}
	}

}
