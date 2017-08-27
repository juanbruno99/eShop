package com.eshop.dao;

import com.eshop.model.Product;

import java.util.List;

/**
 * Interface for the Product DAO operations as managed and required by Spring JPA
 *
 * Created by juanmarcosbruno on 8/13/17.
 */
public interface ProductDAO {

    //Method adds a product from the data source
    void addProduct(Product product);

    //Method retrieves a product from the data source
    Product getProductById(Long id);

    //Method retrieves all products from the data source
    List<Product> getAllProducts();

    //Method deletes a product from the data source
    void deleteProduct(Long id);
}
