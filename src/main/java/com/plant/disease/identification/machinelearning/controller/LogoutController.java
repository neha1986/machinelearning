package com.plant.disease.identification.machinelearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout"; // Redirect to the login page with a logout parameter
    }
}
