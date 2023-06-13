/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author DELL VOSTRO 5510
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Appointment;
import model.AppointmentByIdHospital;
import model.Hospital;

public class ScheduleDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    //Get Appointment by idUsers
    public List<Appointment> getAppointments(String userId) throws SQLException {
        List<Appointment> appointments = new ArrayList<>();

        String query = "SELECT a.idUserVaccineA, u.username, v.name AS vaccine_name, h.name AS hospital_name, "
                + "a.price, u.gender, ap.appointmentDateAt AS date, tr.startAt, tr.endAt "
                + "FROM appointment a "
                + "JOIN [user] u ON a.idUserVaccineA = u.idUser "
                + "JOIN appointment_provision ap ON a.idAppoinmentProvisionA = ap.idAppointmentProvision "
                + "JOIN vaccine v ON ap.idVaccineAP = v.idVaccine "
                + "JOIN hospital h ON ap.idHAP = h.idH "
                + "JOIN time_range tr ON ap.idTimeRangeAP = tr.idTimeRange "
                + "WHERE a.idUserVaccineA = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                appointments.add(new Appointment(rs.getInt("idUserVaccineA"), rs.getString("username"),
                        rs.getString("vaccine_name"), rs.getString("hospital_name"), rs.getDouble("price"),
                        rs.getString("gender"), rs.getString("date"), rs.getString("startAt"), rs.getString("endAt")));
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ tại đây (ví dụ: ghi log, ném ngoại lệ hoặc thông báo lỗi)
        } finally {
            // Đảm bảo đóng các tài nguyên
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return appointments;
    }

    //Get Appointment by idHospital
    public List<AppointmentByIdHospital> getAppointmentsByHospitalId(String hospitalId) throws SQLException {
        List<AppointmentByIdHospital> appointmentsH = new ArrayList<>();

        String query = "SELECT a.idUserVaccineA, u.username, v.name AS vaccine_name, h.name AS hospital_name, "
                + "a.price, u.gender, ap.appointmentDateAt AS date, tr.startAt, tr.endAt "
                + "FROM appointment a "
                + "JOIN [user] u ON a.idUserVaccineA = u.idUser "
                + "INNER JOIN appointment_provision ap ON a.idAppoinmentProvisionA = ap.idAppointmentProvision "
                + "INNER JOIN vaccine v ON ap.idVaccineAP = v.idVaccine "
                + "INNER JOIN hospital h ON ap.idHAP = h.idH "
                + "INNER JOIN time_range tr ON ap.idTimeRangeAP = tr.idTimeRange "
                + "WHERE h.idH = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, hospitalId);
            rs = ps.executeQuery();
            while (rs.next()) {
                appointmentsH.add(new AppointmentByIdHospital(rs.getInt("idUserVaccineA"), rs.getString("username"),
                        rs.getString("vaccine_name"), rs.getString("hospital_name"), rs.getDouble("price"),
                        rs.getString("gender"), rs.getString("date"), rs.getString("startAt"), rs.getString("endAt")));
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ tại đây (ví dụ: ghi log, ném ngoại lệ hoặc thông báo lỗi)
        } finally {
            // Đảm bảo đóng các tài nguyên
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return appointmentsH;
    }

    public static void main(String[] args) {
//        String userId = "999";
        ScheduleDAO scheduleDAO = new ScheduleDAO();
//        try {
//            List<Appointment> appointments = scheduleDAO.getAppointments(userId);
//            for (Appointment appointment : appointments) {
//                System.out.println("User ID: " + appointment.getUserId());
//                System.out.println("Username: " + appointment.getUsername());
//                System.out.println("Vaccine Name: " + appointment.getVaccineName());
//                System.out.println("Hospital Name: " + appointment.getHospitalName());
//                System.out.println("Price: " + appointment.getPrice());
//                System.out.println("Gender: " + appointment.getGender());
//                System.out.println("Date: " + appointment.getDate());
//                System.out.println("Start At: " + appointment.getStartAt());
//                System.out.println("End At: " + appointment.getEndAt());
//                System.out.println("------------------------");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        String hospitalId = "1";
        try {
            List<AppointmentByIdHospital> appointments = scheduleDAO.getAppointmentsByHospitalId(hospitalId);
            for (AppointmentByIdHospital appointment : appointments) {
                System.out.println("Appointment ID: " + appointment.getIdUserVaccineA());
                System.out.println("Username: " + appointment.getUsername());
                System.out.println("Vaccine Name: " + appointment.getVaccineName());
                System.out.println("Hospital Name: " + appointment.getHospitalName());
                System.out.println("Price: " + appointment.getPrice());
                System.out.println("Gender: " + appointment.getGender());
                System.out.println("Date: " + appointment.getDate());
                System.out.println("Start Time: " + appointment.getStartAt());
                System.out.println("End Time: " + appointment.getEndAt());
                System.out.println("-----------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
