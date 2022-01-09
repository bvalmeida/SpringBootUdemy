package com.br.springforms.mycontroller;

import com.br.springforms.myuser.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String getUser(Model model) {

        model.addAttribute("user", new User());

        return "user";
    }

    @PostMapping("/user")
    public String userSubmit(@ModelAttribute User user) {
        return "result";
    }

}
