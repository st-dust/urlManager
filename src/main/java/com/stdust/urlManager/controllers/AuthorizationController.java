package com.stdust.urlManager.controllers;

import com.stdust.urlManager.service.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AuthorizationController {
    private final PersonDetailsService personDetailsService;

    @Autowired
    public AuthorizationController(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @GetMapping()
    public String adminPage(Model model) {
        model.addAttribute("people", personDetailsService.findAll());
        return "admin/index";
    }
}
