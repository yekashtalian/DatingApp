package com.mycompany.datingapp.datamodel;

public class Invitation {
    private Integer id;
    private UserData fromUser;
    private UserData toUser;

    public Invitation(Integer id, UserData fromUser, UserData toUser) {
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserData getFromUser() {
        return fromUser;
    }

    public void setFromUser(UserData fromUser) {
        this.fromUser = fromUser;
    }

    public UserData getToUser() {
        return toUser;
    }

    public void setToUser(UserData toUser) {
        this.toUser = toUser;
    }
    
    
}
