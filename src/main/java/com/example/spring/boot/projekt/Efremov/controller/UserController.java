package com.example.spring.boot.projekt.Efremov.controller;


import com.example.spring.boot.projekt.Efremov.service.RoleService;
import com.example.spring.boot.projekt.Efremov.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class UserController {
    //@Autowired lombok constructor
    private final UserService userService;
    private final RoleService roleService;


    @GetMapping("/index")
    public String getIndexPage(Model model, Principal principal) {
        model.addAttribute("autUser", userService.getUserByLogin(principal.getName()));
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "index";
    }

    @GetMapping
    public String redirectToIndexPage() {
        return "redirect:/index";
    }
}
