package org.comstudy.saramproj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping ("/")
    public String home() {

        return "hello2"; // be same as the template file name (without suffix)
    }
}