package org.mg.blog.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutController {
    @RequestMapping(value = "about", method = RequestMethod.GET)
    public String toAbout(){
        return "about";
    }
}
