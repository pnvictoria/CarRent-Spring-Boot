package com.project.controller.initialization;

import com.project.entity.User;
import com.project.service.interfaces.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class InitializationController {
    @Autowired
    private MainService<User> service;

    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "pages/registration";
    }

    @PostMapping("/registration")
    public ModelAndView registrationPost(@ModelAttribute("account") User user){
        if (service.addObject(user)) {
            return new ModelAndView("pages/login", "message", "Hi!");
        } else {
            return new ModelAndView("pages/registration", "message", "Wrong!");
        }
    }

}
