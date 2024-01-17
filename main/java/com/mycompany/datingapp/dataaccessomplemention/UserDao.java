package com.mycompany.datingapp.dataaccessomplemention;

import com.mycompany.datingapp.dataaccessabstract.UserDaoInteface;
import com.mycompany.datingapp.datamodel.User;
import java.util.List;

public class UserDao implements UserDaoInteface{

    protected Database database;

    public UserDao(Database database) {
        this.database = database;
    }
    
    @Override
    public User getByLogin(String login) {
        return database.users.values()
                .stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void insert(User user) {
        int maxId = database.users.keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        user.setId(maxId + 1);
        database.users.put(maxId+1, user);
    }

    @Override
    public void remove(int Id) {
        database.users.remove(Id);
    }

    @Override
    public User get(int Id) {
        return database.users.get(Id);
    }


    @Override
    public List<User> getAll() {
        return (List<User>) database.users.values();
    }
    
}
