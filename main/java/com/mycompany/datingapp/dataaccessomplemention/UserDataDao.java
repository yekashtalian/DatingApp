package com.mycompany.datingapp.dataaccessomplemention;

import com.mycompany.datingapp.dataaccessabstract.UserDataDaoInteface;
import com.mycompany.datingapp.datamodel.User;
import com.mycompany.datingapp.datamodel.UserData;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class UserDataDao implements UserDataDaoInteface{
    
    protected Database database;

    public UserDataDao(Database database) {
        this.database = database;
    }

    @Override
    public UserData getByUser(User user) {
        return database.userData.values().stream()
                .filter(data -> data.getUser() == user)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void insert(UserData userData) {
        int maxId = database.userData.keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        userData.setId(maxId + 1);
        database.userData.put(maxId+1, userData);
    }

    @Override
    public void remove(int Id) {
        database.userData.remove(Id);
    }

    @Override
    public UserData get(int Id) {
        return database.userData.get(Id);
    }

    @Override
    public Collection<UserData> getAll() {
        return database.userData.values();
    }

    @Override
    public Collection<UserData> getAllExceptOne(UserData ud) {
        return database.userData.values().stream()
                .filter(data -> data != ud)
                .collect(Collectors.toCollection(HashSet::new));
    }
}
