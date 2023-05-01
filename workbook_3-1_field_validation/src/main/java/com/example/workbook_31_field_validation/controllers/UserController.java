package com.example.workbook_31_field_validation.controllers;

import com.example.workbook_31_field_validation.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    private List Users = new ArrayList();

    @GetMapping("/")
    public String getForm(Model model) {
        User user = new User();
        user.setFirstName("Sebastian");
        user.setLastName("Schweder");
        user.setUserName("sschweder1998");
        user.setEmail("s.schweder1998@gmail.com");
        user.setDateOfBirth(new Date(98, 7, 27));
        model.addAttribute("user", user);
        return "sign-up";
    }

    @GetMapping("/result")
    public String getResult() {
        return "result";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid User user, BindingResult result){
        if (result.hasErrors()) {
            return "sign-up";
        }
        else{
            Users.add(user);
            return "redirect:/result";
        }
    }
}
