package com.luv2code.demo;

import com.luv2code.entities.Instructor;
import com.luv2code.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEntitiesDemo
{
    public static void main(String[] args) {
        // create sessionfactory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            // create a Instructor-objects
            Instructor instructor1 = new Instructor("Pierrot", "Mongonnam", "pierrot@web.de");
            Instructor instructor2 = new Instructor("Emmanuel", "Mfam", "manu@yahoo.fr");

            // start a transaction
            session.beginTransaction();

            // save the intructor
            System.out.println("Saving the Instructors...");
            session.save(instructor1);
            session.save(instructor2);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Instructors saved....");

        } finally {
            // close the session
            System.out.println("Closing the session factory...");

        }
    }
}
