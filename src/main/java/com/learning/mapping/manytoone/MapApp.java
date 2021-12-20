package com.learning.mapping.manytoone;

import java.util.ArrayList;
import java.util.List;

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
        
        
        
        
        
        Question q1 = new Question();
        q1.setQuestionId(121);
        q1.setQuestion("What is java");
        
        Answer ans1 = new Answer();
        ans1.setAnswerId(777);
        ans1.setAnswer("Java is a programming language");
        ans1.setQuestion(q1);
        
        Answer ans2 = new Answer();
        ans2.setAnswerId(888);
        ans2.setAnswer("Java is an object oriented programming language");
        ans2.setQuestion(q1);
        
        Answer ans3 = new Answer();
        ans3.setAnswerId(999);
        ans3.setAnswer("java is used for making software");
        ans3.setQuestion(q1);
        
        List<Answer> list = new ArrayList<Answer>();
        list.add(ans1);
        list.add(ans2);
        list.add(ans3);
        
        q1.setAnswers(list);
        
        
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        
        s.save(q1);
        s.save(ans1);
        s.save(ans2);
        s.save(ans3);
        tx.commit();
        
        //fetching..
        Question newQ = (Question)s.get(Question.class, 121);
        System.out.println(newQ.getQuestion());
         
      for(Answer a: newQ.getAnswers()) {
    	  System.out.println(a.getAnswer());
      }
        
        
        s.close();
        
        
        
        
        factory.close();

	}

}

//<mapping class = "com.learning.mapping.onetoone.Answer" />
//<mapping class = "com.learning.mapping.onetoone.Question" />

