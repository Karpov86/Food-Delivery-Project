package by.delivery.service;

import by.delivery.dao.UserDao;
import by.delivery.dao.UserDaoImpl;
import by.delivery.entity.User;

public class UserServiceImpl implements UserService<User> {

    public boolean save(User user){
        return UserDaoImpl.getInstance().save(user);
    }
}
