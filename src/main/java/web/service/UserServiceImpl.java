package web.service;

import web.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public int getCount(List<User> users) {
        return users.size();
    }
}
