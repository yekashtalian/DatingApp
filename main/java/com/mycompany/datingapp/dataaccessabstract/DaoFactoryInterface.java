package com.mycompany.datingapp.dataaccessabstract;

public interface DaoFactoryInterface {
    UserDaoInteface getUserDao();
    
    InvitationDaoInteface getInvitationDao(); 
    
    UserDataDaoInteface getUserDataDao();
}
