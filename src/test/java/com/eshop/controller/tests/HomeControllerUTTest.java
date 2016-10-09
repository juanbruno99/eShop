package com.eshop.controller.tests;

import com.eshop.controller.HomeController;
import com.eshop.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Properties;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by juanmarcosbruno on 9/19/16.
 *
 * Class unit tests the home controller. We use a standalone context since for 'Normal' Controllers loading the full MVC context of
 * the app would be overkill in this testing scenarios (UnitTests)
 *
 * Normal controllers we define as those just rendering views or handling form submissions.
 *
 * Every unit test which we write to test the behavior of a controller method consists of these steps:
 *
 *  - We send a request to the tested controller method.
 *  - We verify that we received the expected response.
 *
 *
 */
@RunWith(MockitoJUnitRunner.class) //add for mock handling capabilities
public class HomeControllerUTTest {

    //Mock for the controller to be tested
    private MockMvc mockMvc;
    private String LIST_URL_PATH = "/productList";

    @Before
    public void setUp() {
        // MockMvc class is the main entry point of our tests. We can execute requests by calling its perform(RequestBuilder requestBuilder) method.
        // This method also 'Configures' the mock for the view resolver used in tests, exception resolvers and validator
        // as it would be done programatically or through xml in an web app context file.
        mockMvc = MockMvcBuilders.standaloneSetup(new HomeController())
                .setHandlerExceptionResolvers(exceptionResolver())
                .setValidator(validator())
                .setViewResolvers(viewResolver())
                .build();
    }

    //Test methods

    //Method test the correct resolution of the view object
    @Test
    public void testResolveViewOk_noModel() throws Exception {
        //Test throught the mock call of the request generated
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name(HomeController.HOME_VIEW))
                .andExpect(forwardedUrl("WEB-INF/views/home.jsp"))
                ;

    }

    //Method test that when the URL resource is requested for all the products it brings results into the model
    @Test
    public void testListAllProducts() throws Exception {
        //Test by calling the correct resource URL path
        mockMvc.perform(get(LIST_URL_PATH))
                .andExpect(status().isOk())
                .andExpect(view().name(HomeController.PRODUCTS_LIST_VIEW))
                .andExpect(forwardedUrl("WEB-INF/views/listProducts.jsp"))
                //// TODO: 10/9/16 : When test context is added and configured, assert to mocked product in service 
                .andExpect(model().attribute("aProduct", hasProperty("productName")))
                ;
    }

    //Set up of the needed resolvers and validators - TODO: Could go into separate class util, or extend from base class

    //Set the exception view resolver through a private method
    private HandlerExceptionResolver exceptionResolver() {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();

        Properties exceptionMappings = new Properties();

        //exceptionMappings.put("com.eshop.controller.Exceptions.TodoNotFoundException", "error/404");
        exceptionMappings.put("java.lang.Exception", "error/error");
        exceptionMappings.put("java.lang.RuntimeException", "error/error");

        exceptionResolver.setExceptionMappings(exceptionMappings);

        Properties statusCodes = new Properties();

        statusCodes.put("error/404", "404");
        statusCodes.put("error/error", "500");

        exceptionResolver.setStatusCodes(statusCodes);

        return exceptionResolver;
    }

    private LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    //The Spring ViewResolver bean class returned for this UT - TODO: Could also go into separate test utils class or base class
    private ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
}
