package com.mycompany.datingapp.businesslogicabstract;

import com.mycompany.datingapp.datamodel.Invitation;
import com.mycompany.datingapp.datamodel.User;
import java.util.Collection;

public interface InvitationServiceInterface {
    
    Collection<Invitation> getAllInvitesToUser(User user);
    
    Invitation get(Integer id);
    
    void delete(Invitation invite);
    
    void acceptInvite(Invitation invite);
    
    void add(User from, Integer to);
}
