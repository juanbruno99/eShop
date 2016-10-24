package com.eshop.controller;

import com.eshop.com.eshop.service.ProductService;
import com.eshop.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * This class represents the Home Controller for the web application
 *
 * Created by juanmarcosbruno on 8/22/16.
 */
@Controller
public class HomeController {

    //TODO: refactor in util or enum for the views, google good practices and follow

    public static final String HOME_VIEW = "home";
    public static final String PRODUCTS_LIST_VIEW = "listProducts";
    public static final String PRODUCTS_VIEW = "viewProduct";

    //Dependencies - TODO: inject through Spring
    ProductService productService = new ProductService();

    @RequestMapping("/")
    public String home() {
        return HOME_VIEW;
    }

    /**
     * Method handles the display of all the shop products.
     *
     * @param model : The model that Spring framework handles for this mapping or controller action. A Model object, with the view name implicitly determined through a RequestToViewNameTranslator
     * and the model implicitly enriched with command objects
     * @return  The String corresponding to the view to be resolved
     */

    //This should definitely go to a new controller for products with a Products URI mapping, but for simplicity now here
    @RequestMapping("/productList")
    public String getProducts(Model model) {
        //Get the product
        List<Product> productList = productService.getProductsList();
        //Add to model
        model.addAttribute("products", productList);
        //Return the view
        return PRODUCTS_LIST_VIEW;
    }

    //Method just returns the product detail view name to be resolved
    @RequestMapping("/productList/viewProduct")
    public String viewProduct() {
        return PRODUCTS_VIEW;
    }

}
