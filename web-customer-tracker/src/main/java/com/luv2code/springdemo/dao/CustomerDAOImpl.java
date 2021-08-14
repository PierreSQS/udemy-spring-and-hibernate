package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        // get the current Session
        final Session currentSession = sessionFactory.getCurrentSession();

        // create  a Query
        Query<Customer> theCustomersQuery = currentSession.createQuery("from Customer", Customer.class);

        // execute the query and get the result list of the query
        List<Customer> resultList = theCustomersQuery.getResultList();

        // return the list of customers
        return resultList;

    }
}
