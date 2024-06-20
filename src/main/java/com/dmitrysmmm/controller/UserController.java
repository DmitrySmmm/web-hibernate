package com.dmitrysmmm.controller;

import com.dmitrysmmm.model.User;
import com.dmitrysmmm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class UserController {

    private final UserService userService;
    //для теста
    List<String> list = new ArrayList<>();
    {
        list.add("rfythjfyj");
        list.add("ue4rujmng");
        list.add("rfytilk10");
        list.add("r767534ds");
        list.add("rf3566tyj");
        list.add("rfy5y5ryu");
        list.add("rfythhthj");
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        List<User> list = userService.getAll();
        model.addAttribute("message", list);
        return "index";
    }
}