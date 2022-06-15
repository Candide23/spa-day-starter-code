package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {

        return "user/add";

    }


    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here



        model.addAttribute("title","Add User");
        if(user.getPassword().equals(verify)) {
            return "user/index";
        }else {
            model.addAttribute("error","Make sure those passwords match!");
            model.addAttribute("email",user.getEmail());
            model.addAttribute("username",user.getUsername());
            return "user/add";
        }
    }
}
