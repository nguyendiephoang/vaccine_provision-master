/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.ScheduleDAO;
import DAO.VaccineDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AppointmentByIdHospital;
import model.VaccineProvision;

/**
 *
 * @author DELL VOSTRO 5510
 */
public class HospitalMangerController extends HttpServlet {

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
        try {
            ScheduleDAO scheduleDAO = new ScheduleDAO();
            String hospitalId = "1";
            List<AppointmentByIdHospital> appointments = scheduleDAO.getAppointmentsByHospitalId(hospitalId);

            request.setAttribute("appointments", appointments);
        } catch (SQLException ex) {
            Logger.getLogger(HospitalMangerController.class.getName()).log(Level.SEVERE, null, ex);
        }

        VaccineDAO dao = new VaccineDAO();
        String idHVP = "1";
        List<VaccineProvision> vaccineProvisions = dao.getAllVaccineProvision(idHVP);

        int totalVaccine = dao.getTotalVaccine();

        request.setAttribute("totalVaccine", totalVaccine);
        request.setAttribute("Provisions", vaccineProvisions);
        request.getRequestDispatcher("HospitalManager.jsp").forward(request, response);
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
