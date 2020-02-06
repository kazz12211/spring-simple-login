package tsubakicraftjp.springsimplelogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tsubakicraftjp.springsimplelogin.form.RegistrationFormData;
import tsubakicraftjp.springsimplelogin.service.UserRegistrationService;


@Controller
public class RegisterController {
    
    @Autowired
    UserRegistrationService registrationService;
    
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registration", new RegistrationFormData());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute RegistrationFormData reg, Model model) {
        try {
            registrationService.register(reg);
            return "login";
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            model.addAttribute("error", e.getLocalizedMessage());
            return "register";
        }
    }
    
}

