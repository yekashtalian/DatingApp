package com.mycompany.datingapp.userinterfaceserver;

import com.mycompany.datingapp.businesslogicabstract.UserDataServiceInterface;
import com.mycompany.datingapp.datamodel.User;
import com.mycompany.datingapp.datamodel.UserData;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpenUserPageServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ServletContext context = getServletContext();
        UserDataServiceInterface userDataService = (UserDataServiceInterface) context.getAttribute("udService");
        UserData userOpened = userDataService.get(Integer.parseInt(request.getParameter("id")));
        User user = (User) request.getSession().getAttribute("user");
        
        boolean isFriend = userDataService.isFriend(userOpened, user);
        boolean isInvited = userDataService.isInvited(userOpened, user);
        request.setAttribute("userOpened", userOpened);
        request.setAttribute("isFriend", isFriend);
        request.setAttribute("isInvited", isInvited);
        request.getRequestDispatcher("userpage.jsp").forward(request, response);
  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
