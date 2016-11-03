package com.eshop.dao.tests;

import com.eshop.com.eshop.dao.ProductDao;
import com.eshop.model.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Class represents the DB unit test for the Product DAO
 *
 * Created by juanmarcosbruno on 10/27/16.
 */
public class ProductDaoDBUnitTest {

    ProductDao productDao;

    @Before
    public void setUp() {
        this.productDao = new ProductDao();
    }

    //Method tests the get product list method on the server that bring the list of products.
    @Test
    public void testGetProductList() {
        List<Product> productList = productDao.getProductsList();
        assertNotNull(productList);
        assertEquals("Two products for the test should be in the Mock DB", 2, productList.size());
    }

    @After
    public void tearDown() {
        this.productDao = null;
    }
}
