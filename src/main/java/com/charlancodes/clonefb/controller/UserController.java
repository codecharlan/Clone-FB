package com.charlancodes.clonefb.controller;

import com.charlancodes.clonefb.model.User;
import com.charlancodes.clonefb.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("api/users")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/all-users")
    public String getAllUsers (Model model){
        model.addAttribute("users", userService.getAllUser());
        return "allusers";
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }
    @PostMapping("/signup")
    public String saveSignup(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/api/users/all-users";
    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        User foundUser = userService.getUserByEmail(user.getEmailAddress());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return "dashboard";
        } else {
            return "login-error";
        }
    }
    @GetMapping("/edit/{id}")
    public String userUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "updateuser";
    }
    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable Long id,
                                @ModelAttribute("student") User user,
                                Model model) {

        // get student from database by id
        User userById = userService.getUserById(id);
        userById.setId(id);
        userById.setFirstName(user.getFirstName());
        userById.setSurname(user.getSurname());
        userById.setEmailAddress(user.getEmailAddress());
        userById.setPassword(user.getPassword());
        userById.setDateOfBirth(user.getDateOfBirth());
        userById.setGender(user.getGender());
        userById.setPhoneNo(user.getPhoneNo());

        // save updated student object
        userService.updateUser(userById);
        return "redirect:/api/users/all-users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
       userService.deleteUser(id);
        return "redirect:/api/users/all-users";
    }
}
