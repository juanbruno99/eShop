package com.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class represents the Home Controller for the web application
 *
 * Created by juanmarcosbruno on 8/22/16.
 */
@Controller
public class HomeController {

    private static final String HOME = "home";

    @RequestMapping("/")
    public String home() {
        return HOME;
    }
}
