package com.eshop.com.eshop.service;

import com.eshop.dao.ProductDAO;
import com.eshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by juanmarcosbruno on 9/23/16.
 *
 * Class represent the business class for the Product domain object
 *
 * @since v04
 *
 */
@Component
public class ProductService {

    @Autowired
    ProductDAO productDao;

    /**
     * Method retrieves all the products from the datasource through the corresponding DAO layer object
     *
     * @return List of Products
     * @since v04
     *
     */
    public List<Product> getProductsList() {
        return productDao.getAllProducts();
    }


    public Product getProductById(Long id) {
        return productDao.getProductById(id);
    }
}
