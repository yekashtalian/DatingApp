package com.mycompany.datingapp.businesslogicimplemention;

import com.mycompany.datingapp.businesslogicabstract.UserDataServiceInterface;
import com.mycompany.datingapp.dataaccessabstract.DaoFactoryInterface;
import com.mycompany.datingapp.datamodel.User;
import com.mycompany.datingapp.datamodel.UserData;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class UserDataService implements UserDataServiceInterface{
    DaoFactoryInterface daoFactory;
    
    public UserDataService(DaoFactoryInterface factory) {
        this.daoFactory = factory;
    }

    @Override
    public UserData getByUser(User user) {
        return daoFactory.getUserDataDao().getByUser(user);
    }

    @Override
    public void UpdateUSerData(User user, String name, String sname, String oData, String cData) {
        UserData udata = daoFactory.getUserDataDao().getByUser(user);
        udata.setName(name);
        udata.setSurname(sname);
        udata.setClosedDescription(cData);
        udata.setOpenDescription(oData);
    }

    @Override
    public Collection<UserData> getAllExceptOne(User user) {
        UserData ud = daoFactory.getUserDataDao().getByUser(user);
        return daoFactory.getUserDataDao().getAllExceptOne(ud);
    }

    @Override
    public UserData get(Integer id) {
        return daoFactory.getUserDataDao().get(id);
    }

    @Override
    public Collection<UserData> search(String text) {
        return daoFactory.getUserDataDao().getAll().stream()
                .filter(i->check(i, text))
                .collect(Collectors.toCollection(HashSet::new));
    }
    
    public boolean check(UserData data, String text){
        String[] splitted = text.toLowerCase().split(" ");
        String keys = data.getName().toLowerCase() + " " + 
                data.getSurname().toLowerCase() + " " + 
                data.getOpenDescription().toLowerCase();
        for(String t : splitted){
            if(keys.contains(t)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isFriend(UserData data, User user) {
        return data.getFriends().contains(getByUser(user));
    }

    @Override
    public boolean isInvited(UserData Data, User user) {
        UserData ud = getByUser(user);
        long c1 = daoFactory.getInvitationDao().getByUser(Data).stream().filter(i->i.getFromUser() == ud).count();
        long c2 = daoFactory.getInvitationDao().getByUser(getByUser(user)).stream().filter(i->i.getFromUser() == Data).count();
        return c1 > 0 || c2 > 0;
    }
}
