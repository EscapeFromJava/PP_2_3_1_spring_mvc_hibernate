package web.service;

import web.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        users.add(new User(1L, "Ivan", "Petrov", "ivan@gmail.com"));
        users.add(new User(2L, "Elena", "Smirnova", "elena@gmail.com"));
        users.add(new User(3L, "Sergey", "Ivanov", "sergey@gmail.com"));
        users.add(new User(4L, "Petr", "Sinitcin", "petr@gmail.com"));
        users.add(new User(5L, "Irina", "Tulkina", "irina@gmail.com"));
        return users;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }
}
