package com.mycompany.datingapp.businesslogicabstract;

import com.mycompany.datingapp.datamodel.User;

public interface UserServiceInterface {
    
    User getByLogin(String login);
    
    boolean checkPassword(User user, String password);
    
}
