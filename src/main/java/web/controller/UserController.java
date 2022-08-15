package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    private final UserServiceImpl userService = new UserServiceImpl();

    @GetMapping(value = "/users")
    public String showAllUsers(@RequestParam(defaultValue = "5", required = false) Integer count,
                               ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users.stream().limit(count).collect(Collectors.toList()));
        return "users";
    }
}
