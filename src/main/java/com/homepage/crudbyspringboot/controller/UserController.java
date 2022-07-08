package com.homepage.crudbyspringboot.controller;

import com.homepage.crudbyspringboot.model.User;
import com.homepage.crudbyspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/viewUser")
    public String newUser(@ModelAttribute("newUser") User user) {
        return "viewUser";
    }
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Long id) {
        User user = userService.findById(id);
        model.addAttribute("userToUpdate", user);
        return "updateUser";
    }
    @PostMapping("/updateUser")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
}
