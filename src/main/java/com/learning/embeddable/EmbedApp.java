package com.learning.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedApp {

	public static void main(String[] args) {
		
		System.out.println( "Project started..." );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        StudentCourseDetails student1 = new StudentCourseDetails();
        student1.setId(121);
        student1.setName("Adarsh kumar");
        student1.setCity("Delhi");
        
        Certificate certi = new Certificate();
        certi.setCourse("Blockchain Developer");
        certi.setDuration("2 Months");
        student1.setCerti(certi);
        
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.save(student1);
        tx.commit();
        
        s.close();
        factory.close();
	}

}


//<mapping class = "com.learning.embeddable.StudentCourseDetails"/>
