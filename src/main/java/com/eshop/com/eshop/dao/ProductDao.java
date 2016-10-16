package com.eshop.com.eshop.dao;

import com.eshop.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juanmarcosbruno on 9/20/16.
 *
 * Data access object class for the model entity Product
 *
 * @since v04
 */
public class ProductDao {

    //For now and basic layer testing purposes add dummy date, later DataSource will be added
    private static List<Product> productList = new ArrayList<Product>();

    static {
        Product aProduct = new Product();
        aProduct.setProductName("Guitar");
        aProduct.setProductCategory("Music Instruments");
        aProduct.setProductCondition("New");
        aProduct.setProductDescription("Clasical Guitar");
        aProduct.setProductManufacturer("Fender");
        aProduct.setProductPrice(1200.0);
        aProduct.setProductStatus("Available");
        aProduct.setUnitsInStock(10);

        Product anotherProduct = new Product();
        anotherProduct.setProductName("Pink Floyd - Dark Side of the moon");
        anotherProduct.setProductCategory("Music Record");
        anotherProduct.setProductCondition("New");
        anotherProduct.setProductDescription("Classical Progressive Rock");
        anotherProduct.setProductManufacturer("Sony Records");
        anotherProduct.setProductPrice(25.0);
        anotherProduct.setProductStatus("Available");
        anotherProduct.setUnitsInStock(5);

        productList.add(aProduct);
        productList.add(anotherProduct);
    }

    //Function to retrieve the list of products
    public List<Product> getProductList() {
        return productList;
    }
}
