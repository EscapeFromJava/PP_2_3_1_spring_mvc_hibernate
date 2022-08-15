package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @GetMapping(value = "/users")
    public String showAllUsers(@RequestParam(defaultValue = "5", required = false) Integer count,
                               ModelMap model) {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Ivan", "Petrov", "ivan@gmail.com"));
        users.add(new User(2L, "Elena", "Smirnova", "elena@gmail.com"));
        users.add(new User(3L, "Sergey", "Ivanov", "sergey@gmail.com"));
        users.add(new User(4L, "Petr", "Sinitcin", "petr@gmail.com"));
        users.add(new User(5L, "Irina", "Tulkina", "irina@gmail.com"));
        model.addAttribute("users", users.stream().limit(count).collect(Collectors.toList()));
        return "users";
    }
}
