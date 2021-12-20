package com.learning.mapping.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapApp {

	public static void main(String[] args) {
		System.out.println( "Project started..." );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Answer ans1 = new Answer();
        ans1.setAnswerId(777);
        ans1.setAnswer("Java is a programming language");
        Question q1 = new Question();
        q1.setQuestionId(121);
        q1.setQuestion("What is java");
        q1.setAnswer(ans1);
        
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.save(ans1);
        s.save(q1);
        tx.commit();
        
        //fetching..
        Question newQ = (Question)s.get(Question.class, 121);
        System.out.println(newQ.getQuestion());
         //first getAnswer() method is of Question.java class 
        //and second getAnswer() method is of Answer.java class
        System.out.println(newQ.getAnswer().getAnswer());
        
        
        s.close();
        
        
        
        
        factory.close();

	}

}
