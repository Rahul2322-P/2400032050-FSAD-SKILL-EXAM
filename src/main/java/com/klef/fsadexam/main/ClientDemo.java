package com.klef.fsadexam.main;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.klef.fsadexam.entity.*;

public class ClientDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Department.class);

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Department d = new Department();
		d.setName("AJAY");
		d.setDescription("Computer Science Department");
		d.setDate("13-04-2026");
		d.setStatus("Active");

		session.save(d);

		tx.commit();

		Session session2 = sf.openSession();
		Transaction tx2 = session2.beginTransaction();

		int id = 1;

		Department dept = session2.get(Department.class, id);

		if (dept != null) {
			session2.delete(dept);
		}

		tx2.commit();

		session2.close();
		sf.close();

	}
}