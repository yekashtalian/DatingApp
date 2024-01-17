package com.mycompany.datingapp.dataaccessomplemention;

import com.mycompany.datingapp.dataaccessabstract.DaoFactoryInterface;
import com.mycompany.datingapp.dataaccessabstract.InvitationDaoInteface;
import com.mycompany.datingapp.dataaccessabstract.UserDaoInteface;
import com.mycompany.datingapp.dataaccessabstract.UserDataDaoInteface;

public class DaoFactory implements DaoFactoryInterface{

    private final UserDaoInteface userDao;
    private final UserDataDaoInteface userDataDao;
    private final InvitationDaoInteface inviteDao;

    public DaoFactory(UserDaoInteface userDao, UserDataDaoInteface userDataDao, InvitationDaoInteface inviteDao) {
        this.userDao = userDao;
        this.userDataDao = userDataDao;
        this.inviteDao = inviteDao;
    }
    
    @Override
    public UserDaoInteface getUserDao() {
        return userDao;
    }

    @Override
    public InvitationDaoInteface getInvitationDao() {
        return inviteDao;
    }

    @Override
    public UserDataDaoInteface getUserDataDao() {
        return userDataDao;
    }
    
}
