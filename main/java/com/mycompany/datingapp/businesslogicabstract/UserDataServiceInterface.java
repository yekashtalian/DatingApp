package com.mycompany.datingapp.businesslogicabstract;

import com.mycompany.datingapp.datamodel.User;
import com.mycompany.datingapp.datamodel.UserData;
import java.util.Collection;

public interface UserDataServiceInterface {
    
    UserData getByUser(User user);
    
    void UpdateUSerData(User user, String name, String sname, String oData, String cData);
    
    Collection<UserData> getAllExceptOne(User user);
    
    UserData get(Integer id);
    
    Collection<UserData> search(String text);
    
    boolean isFriend(UserData data, User user);
    
    boolean isInvited(UserData Data, User user);
}
