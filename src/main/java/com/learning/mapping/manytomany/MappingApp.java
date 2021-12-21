package com.learning.mapping.manytomany;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;





public class MappingApp {

	public static void main(String[] args) {
		System.out.println( "Project started..." );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Emp e1 = new Emp();
        e1.seteId(12);
        e1.setName("Ram");
        
        Emp e2 = new Emp();
        e2.seteId(23);
        e2.setName("Shyam");
        
        Project p1 = new Project();
        p1.setPid(23);
        p1.setProjectName("Library Management System");
        Project p2 = new Project();
        p2.setPid(234);
        p2.setProjectName("Chatbot");
        
        ArrayList<Emp> list1 = new ArrayList<Emp>();
        ArrayList<Project> list2 = new ArrayList<Project>();
        
        list1.add(e1);
        list1.add(e2);
        list2.add(p1);
        list2.add(p2);
        
        e1.setProjects(list2);
        p2.setEmps(list1);
        
        org.hibernate.Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.save(e1);
        s.save(e2);
        s.save(p1);
        s.save(p2);
        tx.commit();
        s.close();
        
        factory.close();

	}

}
