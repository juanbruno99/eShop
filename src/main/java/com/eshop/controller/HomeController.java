package com.eshop.controller;

import com.eshop.com.eshop.service.ProductService;
import com.eshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

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

    @Autowired
    ProductService productService;

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

    //Method now maps the path parameter from the request into the model
    @RequestMapping("/productList/viewProduct/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        //Retrieve the product from the service by the id when the request is made
        Product product = productService.getProductById(id);
        //Add it to the model that the view will receive and work on
        model.addAttribute("product", product);
        //Return the view, Spring will handle the model data renderd to the page
        return PRODUCTS_VIEW;
    }

}
