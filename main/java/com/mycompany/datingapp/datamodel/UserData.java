package com.mycompany.datingapp.datamodel;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    
    private Integer id;
    private User user;
    private String name;
    private String surname;
    private String openDescription;
    private String closedDescription;
    private List<UserData> friends;

    public UserData(Integer id, User user, String name, String surname, String openDescription, String closedDescription) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.openDescription = openDescription;
        this.closedDescription = closedDescription;
        this.friends = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOpenDescription() {
        return openDescription;
    }

    public void setOpenDescription(String openDescription) {
        this.openDescription = openDescription;
    }

    public String getClosedDescription() {
        return closedDescription;
    }

    public void setClosedDescription(String closedDescription) {
        this.closedDescription = closedDescription;
    }

    public List<UserData> getFriends() {
        return friends;
    }

    public void setFriends(List<UserData> friends) {
        this.friends = friends;
    }

    
    
    
}
