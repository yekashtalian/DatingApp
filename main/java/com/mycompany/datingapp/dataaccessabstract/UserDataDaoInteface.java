package com.mycompany.datingapp.dataaccessabstract;

import com.mycompany.datingapp.datamodel.User;
import com.mycompany.datingapp.datamodel.UserData;
import java.util.Collection;

public interface UserDataDaoInteface {
    
    UserData getByUser(User user);
    
    Collection<UserData> getAllExceptOne(UserData ud);
    
    Collection<UserData> getAll();
    
    void insert(UserData userData);

    void remove(int Id);
    
    UserData get(int Id);
  
}
