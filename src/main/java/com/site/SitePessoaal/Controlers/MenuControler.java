package com.site.SitePessoaal.Controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Menu")
public class MenuControler {
    
    @RequestMapping
    public String Menu(){
        return "Menu";
    } 
}
