package com.mycompany.datingapp.userinterfaceserver;

import com.mycompany.datingapp.businesslogicabstract.InvitationServiceInterface;
import com.mycompany.datingapp.businesslogicabstract.UserDataServiceInterface;
import com.mycompany.datingapp.businesslogicabstract.UserServiceInterface;
import com.mycompany.datingapp.businesslogicimplemention.InvitationService;
import com.mycompany.datingapp.businesslogicimplemention.UserDataService;
import com.mycompany.datingapp.businesslogicimplemention.UserService;
import com.mycompany.datingapp.dataaccessabstract.DaoFactoryInterface;
import com.mycompany.datingapp.dataaccessabstract.InvitationDaoInteface;
import com.mycompany.datingapp.dataaccessabstract.UserDaoInteface;
import com.mycompany.datingapp.dataaccessabstract.UserDataDaoInteface;
import com.mycompany.datingapp.dataaccessomplemention.DaoFactory;
import com.mycompany.datingapp.dataaccessomplemention.DataGenerator;
import com.mycompany.datingapp.dataaccessomplemention.Database;
import com.mycompany.datingapp.dataaccessomplemention.InvitationDao;
import com.mycompany.datingapp.dataaccessomplemention.UserDao;
import com.mycompany.datingapp.dataaccessomplemention.UserDataDao;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class NewServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        Database database = new Database();
        DataGenerator.generate(database);

        UserDaoInteface userDao = new UserDao(database);
        InvitationDaoInteface inviteDao = new InvitationDao(database);
        UserDataDaoInteface userdataDao = new UserDataDao(database);
        
        DaoFactoryInterface daoFactory = new DaoFactory(userDao, userdataDao, inviteDao);
        
        UserServiceInterface userService = new UserService(daoFactory);
        arg0.getServletContext().setAttribute("uService", userService);

        InvitationServiceInterface inviteService = new InvitationService(daoFactory);
        arg0.getServletContext().setAttribute("iService", inviteService);
        
        UserDataServiceInterface userDataService = new UserDataService(daoFactory);
        arg0.getServletContext().setAttribute("udService", userDataService);
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
  
    }
}
