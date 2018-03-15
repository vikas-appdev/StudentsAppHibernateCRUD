package com.app.studentsapp.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.app.studentsapp.StudentsInfoDTO;

public class ReadMultipleStudentsInfoDAO {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(StudentsInfoDTO.class);

		Session session = config.buildSessionFactory().openSession();

		// Create query
		String hql = "from StudentsInfoDTO";
		Query query = session.createQuery(hql);

		// Process results using list() method it will return List
		
		List<StudentsInfoDTO> studentsInfoDTOs = query.list();

		for (StudentsInfoDTO studentsInfoDTO : studentsInfoDTOs) {
			System.out.println(studentsInfoDTO.getRegNo());
			System.out.println(studentsInfoDTO.getFirstName());
			System.out.println(studentsInfoDTO.getMiddleName());
			System.out.println(studentsInfoDTO.getLastName());
			System.out.println("---------------------------");
		}
	}

}
