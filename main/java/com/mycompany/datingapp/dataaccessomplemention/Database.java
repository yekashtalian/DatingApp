package com.mycompany.datingapp.dataaccessomplemention;

import com.mycompany.datingapp.datamodel.*;
import java.util.Map;
import java.util.TreeMap;

public class Database {
    Map<Integer, UserData> userData;
    Map<Integer, User> users;
    Map<Integer, Invitation> invites;

    public Database() {
        userData = new TreeMap<>();
        users = new TreeMap<>();
        invites = new TreeMap<>();   
    }
}
