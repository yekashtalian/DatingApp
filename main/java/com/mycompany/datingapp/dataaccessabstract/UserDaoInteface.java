package com.mycompany.datingapp.dataaccessabstract;

import com.mycompany.datingapp.datamodel.User;
import java.util.List;

public interface UserDaoInteface {
    
    User getByLogin(String login);
    
    List<User> getAll();
    
    void insert(User user);

    void remove(int Id);
    
    User get(int Id);
    
}
