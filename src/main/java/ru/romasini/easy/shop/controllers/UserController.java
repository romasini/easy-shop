package ru.romasini.easy.shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.romasini.easy.shop.models.Role;
import ru.romasini.easy.shop.models.User;
import ru.romasini.easy.shop.sevices.RoleService;
import ru.romasini.easy.shop.sevices.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/registration")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private RoleService roleService;

    @GetMapping
    public String registrationPage(){
        return "registration";
    }

    @PostMapping
    public String saveUser(@ModelAttribute User user){
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findByName("ROLE_CUSTOMER"));
        user.setRoles(roles);
        userService.save(user);
        return "redirect:/products";
    }
}
