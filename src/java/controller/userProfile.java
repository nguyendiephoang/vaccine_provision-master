/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.Encrypt;
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
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author DELL
 */
@WebServlet(name = "userProfile", urlPatterns = {"/userProfile"})
public class userProfile extends HttpServlet {

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
            out.println("<title>Servlet userProfile</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet userProfile at " + request.getContextPath() + "</h1>");
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
        UserDao db = new UserDao();
        try {
            HttpSession session = request.getSession();
            int id = (int) session.getAttribute("id");
            Encrypt en = new Encrypt();
            User u = db.findUserByID(id);
            System.out.println("user: " + u);
            User un = new User(u.getIdUser(), u.getUsername(), u.getPassword(), en.decryptCCCDTo(u.getIdentification()), u.getDob(), u.isGender(), u.getPhone(), u.getEmail(), en.decryptCCCDTo(u.getHealthInsurance()), 1);
            session.setAttribute("u", un);
//            String r = en.decryptCCCDTo(u.getHealthInsurance());
//            System.out.println(r);

            response.sendRedirect("user_profile.jsp#profileForm");

        } catch (Exception ex) {
            Logger.getLogger(userProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            String name = request.getParameter("name");
            boolean gender = request.getParameter("gender").equals("true") ? true : false;
            Date dob = Date.valueOf(request.getParameter("dob"));
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String identification = request.getParameter("identification");
            String healthInsurance = request.getParameter("healthInsurance");
            UserDao db = new UserDao();
            User findIdentification = db.findIdentification(identification);
            // tìm xem BHYT đã tồn tại chưa
            User findHealthInsurance = db.findHealthInsurance(healthInsurance);
            // CCCD của người đang đăng nhập tại hệ thống
            HttpSession session = request.getSession();
            int id = (int) session.getAttribute("id");
            User currentUser = db.findUserByID(id);
            if ((findIdentification != null && findIdentification.getIdUser() != id)
                    || (findHealthInsurance != null && findHealthInsurance.getIdUser() != id)) {

                if (findIdentification != null && findIdentification.getIdUser() != id) {
                    request.getSession().setAttribute("ExistIdentification", "Exist Identification");
                }
                if (findHealthInsurance != null && findHealthInsurance.getIdUser() != id) {
                    request.getSession().setAttribute("ExistHealthInsurance", "Exist HealthInsurance");
                }
            } else {
                db.updateUser(id, name, identification, dob, gender, phone, email, healthInsurance);
//                System.out.println("sdfbsjdgfshfd: " + id + name + identification + dob + gender + phone + email + healthInsurance);
                request.getSession().setAttribute("updateinforsucess", "Password was change succesfully");
            }
            response.sendRedirect("userProfile");
            response.sendRedirect("user_profile.jsp#infor");
        } catch (Exception ex) {
            Logger.getLogger(userProfile.class.getName()).log(Level.SEVERE, null, ex);
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
