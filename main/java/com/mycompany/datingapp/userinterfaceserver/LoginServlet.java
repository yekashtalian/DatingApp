package com.mycompany.datingapp.userinterfaceserver;

import com.mycompany.datingapp.businesslogicabstract.UserDataServiceInterface;
import com.mycompany.datingapp.businesslogicabstract.UserServiceInterface;
import com.mycompany.datingapp.datamodel.User;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ServletContext context = getServletContext();
        UserServiceInterface userService = (UserServiceInterface) context.getAttribute("uService");
        UserDataServiceInterface udService = (UserDataServiceInterface) context.getAttribute("udService");

        String log = request.getParameter("log");
        User user = userService.getByLogin(log);

        if (user == null) {
            request.setAttribute("error", "Неправильно введні дані для входу");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
        
        String pas = request.getParameter("pas");

        if (!userService.checkPassword(user, pas)) {
            request.setAttribute("error", "Неправильно введні дані для входу");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
        request.getSession().setAttribute("user", user);
        
        request.getSession().setAttribute("allUsers", udService.getAllExceptOne(user));
        
        request.getRequestDispatcher("mainpage.jsp").forward(request, response);
        
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
