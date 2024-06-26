package com.dmitrysmmm.controller;

import com.dmitrysmmm.model.User;
import com.dmitrysmmm.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "index";
    }

    @GetMapping(value = "/id")
    public String getUser(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "index";
    }

    @GetMapping("/newuser")
    public String newUserPage(@ModelAttribute("u") User user) {
        return "newuser";
    }

    @PostMapping()
    public String newUser(@ModelAttribute("u") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/id/edit")
    public String edit(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PutMapping("/id")
    public String update(@ModelAttribute("user") User user, @RequestParam("id") long id) {
        userService.updateUser(user, id);
        return "redirect:/";
    }

    @DeleteMapping("/id")
    public String delete(@RequestParam("id") long id) {
        userService.dropUser(id);
        return "redirect:/";
    }
}