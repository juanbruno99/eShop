package com.eshop.service.tests;

import com.eshop.com.eshop.service.ProductService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class represents the Unit Test for the Product Service.
 *
 * Created by juanmarcosbruno on 10/27/16.
 */

public class ProductServiceUnitTest {

    ProductService productService;

    @Before
    public void setUp() {
        this.productService = new ProductService();
    }

    //Method tests the get product list method on the server that bring the list of products.
    @Test
    public void testGetProductList() {
        assertNotNull(productService.getProductsList());
    }

    @After
    public void tearDown() {
        this.productService = null;
    }

}
