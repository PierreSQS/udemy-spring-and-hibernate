package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    private final SessionFactory sessionFactory;

    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers() {

        // get the current Session
        final Session currentSession = sessionFactory.getCurrentSession();

        // create  a Query
        Query<Customer> theCustomersQuery = currentSession
                .createQuery("from Customer order by lastName", Customer.class);

        // execute the query and return the result list of the query
        return theCustomersQuery.getResultList();

    }

    @Override
    public void saveCustomer(Customer customer) {
        // get the current Session
        final Session currentSession = sessionFactory.getCurrentSession();

        // save the Customer and return it
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer findByID(Long customerID) {
        // get the current Session
        final Session currentSession = sessionFactory.getCurrentSession();

        // find the customer by ID and return it if exists
        return currentSession.find(Customer.class, customerID);
    }
}
