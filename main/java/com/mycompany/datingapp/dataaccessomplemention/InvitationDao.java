package com.mycompany.datingapp.dataaccessomplemention;

import com.mycompany.datingapp.dataaccessabstract.InvitationDaoInteface;
import com.mycompany.datingapp.datamodel.Invitation;
import com.mycompany.datingapp.datamodel.UserData;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InvitationDao implements InvitationDaoInteface{
    
    protected Database database;

    public InvitationDao(Database database) {
        this.database = database;
    }

    @Override
    public Collection<Invitation> getByUser(UserData userdata) {
        return database.invites.values().stream()
                .filter(i->i.getToUser() == userdata)
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public void insert(Invitation invite) {
        int maxId = database.invites.keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        invite.setId(maxId + 1);
        database.invites.put(maxId+1, invite);
    }

    @Override
    public void remove(int Id) {
        database.invites.remove(Id);
    }

    @Override
    public Invitation get(int Id) {
        return database.invites.get(Id);
    }


    @Override
    public List<Invitation> getAll() {
        return (List<Invitation>) database.invites.values();
    }
}
