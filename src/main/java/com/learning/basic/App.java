package com.learning.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project started..." );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        //creating student
        Student st = new Student();
        st.setId(101);
        st.setName("Adarsh");
        st.setCity("New Delhi");
        System.out.println(st);
        
        //creating object of address class
        Address ad = new Address();
        ad.setStreet("street1");
        ad.setCity("Delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date() );
        ad.setX(123.45);
        
        //reading image
        FileInputStream fis = new FileInputStream("src/main/java/pic.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        fis.close();
        
        
       Session session =factory.openSession();
       Transaction tx = session.beginTransaction();
       session.save(st);
       session.save(ad);
       tx.commit();
       session.close();
       System.out.println("Done...");
    }
}






