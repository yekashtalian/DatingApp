package com.mycompany.datingapp.businesslogicimplemention;

import com.mycompany.datingapp.businesslogicabstract.UserServiceInterface;
import com.mycompany.datingapp.dataaccessabstract.DaoFactoryInterface;
import com.mycompany.datingapp.datamodel.User;

public class UserService implements UserServiceInterface{
    DaoFactoryInterface daoFactory;
    
    public UserService(DaoFactoryInterface factory) {
        this.daoFactory = factory;
    }
    
    @Override
    public User getByLogin(String login) {
        return daoFactory.getUserDao().getByLogin(login);
    }

    @Override
    public boolean checkPassword(User user, String password) {
        return user.getPassword().equals(password);
    }
}
