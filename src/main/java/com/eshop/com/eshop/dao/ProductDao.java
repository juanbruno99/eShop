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
    private List<Product> productList = new ArrayList<Product>();;

    //Function to retrieve the list of products
    public List<Product> getProductList() {
        Product aProduct = new Product();
        aProduct.setProductName("Guitar");
        aProduct.setProductCategory("Music Instruments");
        aProduct.setProductCondition("New");
        aProduct.setProductDescription("Clasical Guitar");
        aProduct.setProductManufacturer("Fender");
        aProduct.setProductPrice(1200.0);
        aProduct.setProductStatus("Available");
        aProduct.setUnitsInStock(10);

        productList.add(aProduct);

        return productList;
    }
}
