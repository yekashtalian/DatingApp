package com.mycompany.datingapp.businesslogicimplemention;

import com.mycompany.datingapp.businesslogicabstract.InvitationServiceInterface;
import com.mycompany.datingapp.dataaccessabstract.DaoFactoryInterface;
import com.mycompany.datingapp.datamodel.Invitation;
import com.mycompany.datingapp.datamodel.User;
import com.mycompany.datingapp.datamodel.UserData;
import java.util.Collection;

public class InvitationService implements InvitationServiceInterface{
    DaoFactoryInterface daoFactory;
    
    public InvitationService(DaoFactoryInterface factory) {
        this.daoFactory = factory;
    }

    @Override
    public Collection<Invitation> getAllInvitesToUser(User user) {
        UserData data = daoFactory.getUserDataDao().getByUser(user);
        return daoFactory.getInvitationDao().getByUser(data);
    }

    @Override
    public Invitation get(Integer id) {
        return daoFactory.getInvitationDao().get(id);
    }

    @Override
    public void delete(Invitation invite) {
        daoFactory.getInvitationDao().remove(invite.getId()); 
    }

    @Override
    public void acceptInvite(Invitation invite) {
        invite.getToUser().getFriends().add(invite.getFromUser());
        invite.getFromUser().getFriends().add(invite.getToUser());
        delete(invite);
    }

    @Override
    public void add(User from, Integer to) {
        Invitation invite = new Invitation(-1,
                daoFactory.getUserDataDao().getByUser(from),
                daoFactory.getUserDataDao().get(to));
        daoFactory.getInvitationDao().insert(invite);
    }
}
