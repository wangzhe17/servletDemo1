package service;

import dao.UserDao;
import entity.User;

public class Service {
    UserDao dao=new UserDao();
    public User login(String username,String password){
        User user=dao.login(username,password);
        return user;
    }
}
