package com.app.studentsapp.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.studentsapp.StudentsInfoDTO;

public class ReadOneRecordStudentsInfoDAO {
	public static void main(String[] args) {

		Configuration config = new Configuration();

		/**
		 * We can pass file name and location of hibernate.cfg.xml as argument to
		 * configure() method By default it takes hibernate.cfg.xml but if we have more
		 * that one cfg.xml file then we can make use of overloaded configure() method
		 * to instruct them to load particular file from particular location.
		 */

		// config.configure("hibernate.cfg.xml");
		config.configure();
		/**
		 * We can addAnnotatedClass in two ways by using method addAnnotatedClass() or
		 * By using mapping in xml like
		 * <mapping class="com.app.hibernate.PoliceStationDTO"/>
		 */
		config.addAnnotatedClass(StudentsInfoDTO.class);

		/**
		 * We can chain the openSession without storing into SessionFactory to optimized
		 * our code for example we can use config.buildSessionFactory().openSession();
		 * and directly store it as Session.
		 */
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();

		/**
		 * In sql we use select * from tablename where tablecolumn="some_condition" But
		 * Hibernate does not support select * so we have to omit that then hibernate
		 * query will be like <b>from DTO where datamember="condition"</b> We will pass
		 * this query to createQuery() method using session and it will return Query
		 * interface
		 */
		// Create Hibernate Query to load data from database
		String hql = "from StudentsInfoDTO where regno=1";
		Query query = session.createQuery(hql);

		/**
		 * Process the result return by query using uniqueResult() method it will return
		 * Object type Object Downcast this object to get data from DTO class
		 * 
		 */

		StudentsInfoDTO student = (StudentsInfoDTO) query.uniqueResult();
		System.out.println(student.getRegNo());
		System.out.println(student.getFirstName());
		System.out.println(student.getMiddleName());
		System.out.println(student.getLastName());

	}

}
