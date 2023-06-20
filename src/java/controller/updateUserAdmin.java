/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.SendEmail;
import DAO.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "updateUserAdmin", urlPatterns = {"/updateUserAdmin"})
public class updateUserAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateUserAdmin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateUserAdmin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        try {
            int idUser = Integer.parseInt(request.getParameter("idUser"));
            String name = request.getParameter("name");
            boolean gender = request.getParameter("gender").equals("true") ? true : false;
            Date dob = Date.valueOf(request.getParameter("dob"));
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String identification = request.getParameter("identification");
            String healthInsurance = request.getParameter("healthInsurance");
            // System.out.println(idUser + name + gender + dob + phone + email + identification + healthInsurance);
            UserDao ud = new UserDao();
            ud.updateUser(idUser, name, identification, dob, gender, phone, email, healthInsurance);
            String table = "<table>\n"
                    + "  <tr>\n"
                    + "    <td>Name: </td>\n"
                    + "    <td> "+name +" </td>\n"
                    + "  </tr>\n"
                    + "  <tr>\n"
                    + "    <td>Gender: </td>\n"
                    + "    <td> "+gender +" </td>\n"
                    + "  </tr>\n"
                    + "  <tr>\n"
                    + "    <td>Date of birth: </td>\n"
                    + "    <td> "+dob +" </td>\n"
                    + "  </tr>\n"
                    + "  <tr>\n"
                    + "    <td>Phone: </td>\n"
                    + "    <td> "+phone +" </td>\n"
                    + "  </tr>\n"
                    + "  <tr>\n"
                    + "    <td>Email: </td>\n"
                    + "    <td> "+email +" </td>\n"
                    + "  </tr>\n"
                    + "  <tr>\n"
                    + "    <td>Identification: </td>\n"
                    + "    <td> "+identification +" </td>\n"
                    + "  </tr>\n"
                    + "  <tr>\n"
                    + "    <td>HealthInsurance: </td>\n"
                    + "    <td> "+healthInsurance +" </td>\n"
                    + "  </tr>\n"
                    + "</table>";
            new SendEmail("Update information ", email, "Your information have change" + table).send();

            request.getSession().setAttribute("updateinforsucess", "The information has been changed successfully");
            response.sendRedirect("user_manager.jsp");
        } catch (Exception ex) {
            Logger.getLogger(updateUserAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
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
