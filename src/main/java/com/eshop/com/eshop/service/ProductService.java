package com.eshop.com.eshop.service;

import com.eshop.com.eshop.dao.ProductDao;
import com.eshop.model.Product;

import java.util.List;

/**
 * Created by juanmarcosbruno on 9/23/16.
 *
 * Class represent the business class for the Product domain object
 *
 * @since v04
 *
 */
public class ProductService {

    //DAO object - TODO: Replace with DI from Spring
    ProductDao productDao = new ProductDao();

    /**
     * Method retrieves all the products from the datasource through the corresponding DAO layer object
     *
     * @return List of Products
     * @since v04
     *
     */
    public List<Product> getProductsList() {
        return productDao.getProductsList();
    }


    public Product getProductById(Long id) {
        return productDao.getProductById(id);
    }
}
