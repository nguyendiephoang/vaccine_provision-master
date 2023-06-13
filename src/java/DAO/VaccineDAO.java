/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Appointment;
import model.Vaccine;
import model.VaccineProvision;

/**
 *
 * @author DELL VOSTRO 5510
 */
public class VaccineDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Vaccine> getAllVaccine() {
        List<Vaccine> list = new ArrayList<>();
        String query = "select * from vaccine";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Vaccine(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<VaccineProvision> getVaccineListwithHospital() throws SQLException, Exception {
        List<VaccineProvision> vaccines = new ArrayList<>();

        String query = "SELECT vp.idVaccineVP AS id, v.name AS name, v.detail AS detail, vp.pricePerService AS price, h.name AS hospital "
                + "FROM vaccine_provision vp "
                + "JOIN vaccine v ON vp.idVaccineVP = v.idVaccine "
                + "JOIN hospital h ON vp.idHVP = h.idH";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String detail = rs.getString("detail");
                double price = rs.getDouble("price");
                String hospital = rs.getString("hospital");

                VaccineProvision vaccine = new VaccineProvision(id, name, detail, price, name);
                vaccines.add(vaccine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

        return vaccines;
    }

    public List<VaccineProvision> getVaccinePerHospital(String userId) throws SQLException {
        List<VaccineProvision> provision = new ArrayList<>();

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
                provision.add(new VaccineProvision(rs.getInt("idVaccine"), rs.getString("name"),
                        rs.getString("detail"), rs.getDouble("pricePerService"), rs.getString("nameH")));
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
        return provision;
    }

//    public List<VaccineProvision> getAllVaccine_provision() {
//        List<VaccineProvision> list = new ArrayList<>();
//        String query = "select * from vaccine_provision";
//        try {
//            conn = new DBContext().getConnection();//mo ket noi voi sql
//            ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(new VaccineProvision(rs.getDouble(1), rs.getInt(2), rs.getInt(3)));
//            }
//        } catch (Exception e) {
//        }
//        return list;
//    }
    public List<VaccineProvision> getAllVaccineProvision(String idHVP) {
        List<VaccineProvision> list = new ArrayList<>();
        String query = "SELECT v.idVaccine, v.name, v.detail, vp.pricePerService "
                + "FROM vaccine_provision vp "
                + "JOIN vaccine v ON vp.idVaccineVP = v.idVaccine "
                + "WHERE vp.idHVP = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idHVP);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idVaccine = rs.getInt(1);
                String name = rs.getString(2);
                String detail = rs.getString(3);
                double pricePerService = rs.getDouble(4);

                VaccineProvision vaccineProvision = new VaccineProvision(idVaccine, name, detail, pricePerService, name);
                list.add(vaccineProvision);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return list;
    }

    private void closeResources() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getTotalVaccine() {
        String query = "select count(*) from vaccine";
        try {
            conn = new DBContext().getConnection();             //Mo ket noi voi SQL sever
            ps = conn.prepareStatement(query);                  //Chuyen cau lenh o Query vao
            rs = ps.executeQuery();                             //Chay cau lenh Query
            //Lay du lieu o "rs" dua vao "list"
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void insertVaccine(String name, String detail) {
        String query = "INSERT INTO vaccine (name, detail)\n"
                + "VALUES (?,?);";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, detail);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateVaccine(int idVaccine, String name, String detail) {
        String query = "UPDATE vaccine "
                + "SET name = ?, detail = ? "
                + "WHERE idVaccine = ?";
        try {
            conn = new DBContext().getConnection(); // mở kết nối với SQL server
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, detail);
            ps.setInt(3, idVaccine);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteVaccine(String dvid) {
        String query = "DELETE FROM vaccine WHERE idVaccine = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, dvid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Vaccine> searchByName(String txtSearch) {
        List<Vaccine> list = new ArrayList<>();
        String query = "select * from vaccine\n"
                + "where [name] like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Vaccine(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Vaccine> getPage(int numPage) {
        List<Vaccine> list = new ArrayList<>();
        String query = "select * from vaccine order by idVaccine offset ? ROWS FETCH next 5 ROWS only;";
        try {
            conn = new DBContext().getConnection();             //Mo ket noi voi SQL sever
            ps = conn.prepareStatement(query);                  //Chuyen cau lenh o Query vao
            ps.setInt(1, (numPage - 1) * 5);
            rs = ps.executeQuery();                             //Chay cau lenh Query
            while (rs.next()) {
                list.add(new Vaccine(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        VaccineDAO dao = new VaccineDAO();

//        dao.insertVaccine("Vaccine 19", "19 Detail");
//        String dvid = "10";
//        dao.deleteVaccine(dvid);
//
//        List<Vaccine> searchResult = dao.searchByName("a");
//        for (Vaccine vaccine : searchResult) {
//            System.out.println(vaccine.toString());
//        }
//        dao.updateVaccine(11, "n-Covy", "vaccine C");
//
//        List<Vaccine> page = dao.getPage(2);
//        for (Vaccine o : page) {
//            System.out.println(o);
//        }
//        List<Vaccine> list = dao.getAllVaccine();
//        for (Vaccine l : list) {
//            System.out.println(l);
//        }
//
//        List<VaccineProvision> listP = dao.getAllVaccine_provision();
//        for (VaccineProvision o : listP) {
//            System.out.println("\n" + o);
//        }
//
//        int totalVaccine = dao.getTotalVaccine();
//        System.out.println("\n"
//                + "Total Vaccine: " + totalVaccine);
//        String idHVP = "1"; // Replace with your desired idHVP
//        
//        List<VaccineProvision> vaccineProvisions = dao.getAllVaccineProvision(idHVP);
//        
//        if (vaccineProvisions.isEmpty()) {
//            System.out.println("No vaccine provisions found.");
//        } else {
//            System.out.println("Vaccine provisions:");
//            for (VaccineProvision vaccineProvision : vaccineProvisions) {
//                System.out.println(vaccineProvision.getIdVaccine() + " - " +
//                        vaccineProvision.getName() + " - " +
//                        vaccineProvision.getDetail() + " - " +
//                        vaccineProvision.getPricePerService());
//            }
//        }
        try {
            List<VaccineProvision> vaccineList = dao.getVaccineListwithHospital();

            // In danh sách sản phẩm
            for (VaccineProvision vaccine : vaccineList) {
                System.out.println("ID: " + vaccine.getIdVaccine());
                System.out.println("Tên: " + vaccine.getName());
                System.out.println("Chi tiết: " + vaccine.getDetail());
                System.out.println("Giá: " + vaccine.getPricePerService());
                System.out.println("Tên bệnh viện: " + vaccine.getNameH());
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
