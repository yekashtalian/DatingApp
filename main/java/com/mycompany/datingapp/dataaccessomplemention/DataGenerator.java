package com.mycompany.datingapp.dataaccessomplemention;

import com.mycompany.datingapp.datamodel.Invitation;
import com.mycompany.datingapp.datamodel.User;
import com.mycompany.datingapp.datamodel.UserData;

public class DataGenerator {
    
    public static void generate(Database db){
        User user1 = new User(1, "login1", "pass");
        User user2 = new User(2, "login2", "pass");
        User user3 = new User(3, "login3", "pass");
        User user4 = new User(4, "login4", "pass");
        User user5 = new User(5, "login5", "pass");
        
        db.users.put(1, user1);
        db.users.put(2, user2);
        db.users.put(3, user3);
        db.users.put(4, user4);
        db.users.put(5, user5);
        
        UserData udata1 = new UserData(1, user1, "Julia", "Ponomareva", "Programmer, like cats", "Very bad programmer...");
        UserData udata2 = new UserData(2, user2, "Vitalina", "Antipova", "Professional model", "32 y.o. 8 cats");
        UserData udata3 = new UserData(3, user3, "Lera", "Senkina", "19 y.o. KPI student", "KFC worker");
        UserData udata4 = new UserData(4, user4, "Anatoliy", "Pasichnik", "World chess champion", "My house is mortgaged");
        UserData udata5 = new UserData(5, user5, "Mukolay", "Fedrov", "Investor, notarius, layer", "Former");
    
        db.userData.put(1, udata1);
        db.userData.put(2, udata2);
        db.userData.put(3, udata3);
        db.userData.put(4, udata4);
        db.userData.put(5, udata5);
        
        Invitation i1 = new Invitation(1, udata2, udata1); 
        Invitation i2 = new Invitation(2, udata3, udata1); 
        Invitation i3 = new Invitation(3, udata4, udata1);
        
        db.invites.put(1, i1);
        db.invites.put(2, i2);
        db.invites.put(3, i3);
    }
}
