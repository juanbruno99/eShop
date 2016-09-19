package com.eshop.controller.tests;

import com.eshop.controller.HomeController;
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

    @Before
    public void setUp() {
        // MockMvc class is the main entry point of our tests. We can execute requests by calling its perform(RequestBuilder requestBuilder) method.
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
                .andExpect(view().name("home"))
                .andExpect(forwardedUrl("WEB-INF/views/home.jsp"))
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

    private ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
}
