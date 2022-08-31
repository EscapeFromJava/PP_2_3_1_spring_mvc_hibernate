package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("newUser") User user){
        return "users/new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("newUser") User newUser) {
        userService.saveUser(newUser);
        return "redirect:/users";
    }
}
