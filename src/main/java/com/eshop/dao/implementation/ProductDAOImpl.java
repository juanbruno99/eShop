package com.eshop.dao.implementation;

import com.eshop.dao.ProductDAO;
import com.eshop.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * In Spring 2.0 and later, the @Repository annotation is a marker for any class that fulfills the role or stereotype (also known as Data Access Object or DAO) of a repository.
 * Among the uses of this marker is the automatic translation of exceptions.
 *
 * Created by juanmarcosbruno on 8/13/17.
 */
@Repository
@Transactional //With these annotation Spring Hibernate will deal safety with these transactions on each method
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory; //Thread safe for Hibernate

    public void addProduct(Product product) {
        //Get the session from the factory
        Session session = sessionFactory.getCurrentSession(); //Non Thread Safe, should lived as the transaction does
        //Save or update the object (product entity annotated) to the DB
        session.saveOrUpdate(product);
        //Flush the session to sync with DB and execute the save operation
        session.flush();

    }

    public Product getProductById(Long id) {
        //Get the session from the factory
        Session session = sessionFactory.getCurrentSession();
        //Get the object from the data source by its id
        Product retrievedProduct = (Product) session.get(Product.class, id);
        return retrievedProduct;
    }

    public List<Product> getAllProducts() {
        //Get the session from the factory
        Session session = sessionFactory.getCurrentSession();
        //Create a Query - Retrieve all the Product entity objects in HDQL
        Query query = session.createQuery("from Product");
        //Retrieve all the products
        List<Product> retrievedProducts = query.list();

        return retrievedProducts;
    }

    public void deleteProduct(Long id) {
        //Get the session from the factory
        Session session = sessionFactory.getCurrentSession();
        //Delete the entity
        session.delete(getProductById(id));
        //Flush and close the session
        session.flush();

    }
}
