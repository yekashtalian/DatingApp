package com.mycompany.datingapp.dataaccessabstract;

import com.mycompany.datingapp.datamodel.Invitation;
import com.mycompany.datingapp.datamodel.UserData;
import java.util.Collection;
import java.util.List;

public interface InvitationDaoInteface {
    
    Collection<Invitation> getByUser(UserData userdata);
    
    List<Invitation> getAll();
    
    void insert(Invitation invite);

    void remove(int Id);
    
    Invitation get(int Id);
    
}
