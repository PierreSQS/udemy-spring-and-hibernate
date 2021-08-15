package com.luv2code.demo;

import com.luv2code.entities.Instructor;
import com.luv2code.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class DeleteEntityDemo {
    public static void main(String[] args) {
        // create sessionfactory
        var sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session to save the student object

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();

            // start a transaction
            session.beginTransaction();

            Integer id = 3;

            System.out.printf("%nFinding Instructor with ID=%d...%n",id);

            Instructor foundInstructor = session.find(Instructor.class, id);

            if (foundInstructor != null) {
                System.out.println("Deleting found Instructor: "+foundInstructor);
                session.delete(foundInstructor);
            } else {
                System.out.println("Instructor not found!!!!");
            }

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Delete Transaction endet!!!");

        } finally {
            // close the session
            System.out.println("Closing the session factory...");

        }
    }
}
