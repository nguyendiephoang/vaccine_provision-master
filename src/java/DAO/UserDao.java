/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import model.User;

/**
 *
 * @author Admin
 */
public class UserDao extends DBContext {

    Encrypt en = new Encrypt();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        String sql = "select * from [user]";
//        PreparedStatement stm = conn.prepareCall(sql);
//        ResultSet rs = stm.executeQuery();s
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDate(5), rs.getBoolean(6),
                        rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10)));

            }
        } catch (Exception e) {
        }
        return list;
    }

    public User findUserByEmail(String email) throws Exception {
        try {
            String sql = "select * from [user] where [email] = ? ";
            conn = new DBContext().getConnection();//mo ket noi voi sql
//            ps = conn.prepareStatement(sql);
//            rs = ps.executeQuery();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                User s = new User();
                s.setIdUser(rs.getInt("idUser"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setIdentification(rs.getString("identification"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setHealthInsurance("healthInsurance");
                s.setRole(rs.getInt("role"));
                return s;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User findUser(String email, String password) throws Exception {
        try {
            String sql = "select * from [user] where [email] = ? and [password] = ?";
            conn = new DBContext().getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, en.encryptCCCDTo(password));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User s = new User();
                s.setIdUser(rs.getInt("idUser"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setIdentification(rs.getString("identification"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setHealthInsurance("healthInsurance");
                s.setRole(rs.getInt("role"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User findUser(int userId, String password) throws Exception {
        try {
            String sql = "select * from [user] where [idUser] = ? and [password] = ?";
            conn = new DBContext().getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setString(2, en.encryptCCCDTo(password));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User s = new User();
                s.setIdUser(rs.getInt("idUser"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setIdentification(rs.getString("identification"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setHealthInsurance("healthInsurance");
                s.setRole(rs.getInt("role"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User findUser(int userId) throws Exception {
        try {
            String sql = "select * from [user] where [idUser] = ?";
            conn = new DBContext().getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, userId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User s = new User();
                s.setIdUser(rs.getInt("idUser"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setIdentification(rs.getString("identification"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setHealthInsurance("healthInsurance");
                s.setRole(rs.getInt("role"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User findIdentification(String identification) throws Exception {
        try {
            String sql = "select * from [user] where [identification] = ?";
            conn = new DBContext().getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, en.encryptCCCDTo(identification));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User s = new User();
                s.setIdUser(rs.getInt("idUser"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setIdentification(rs.getString("identification"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setHealthInsurance("healthInsurance");
                s.setRole(rs.getInt("role"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User findPhone(String phone) throws Exception {
        try {
            String sql = "select * from [user] where [phone] = ?";
            conn = new DBContext().getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, phone);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User s = new User();
                s.setIdUser(rs.getInt("idUser"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setIdentification(rs.getString("identification"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setHealthInsurance("healthInsurance");
                s.setRole(rs.getInt("role"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User findHealthInsurance(String healthInsurance) throws Exception {
        try {
            String sql = "select * from [user] where [healthInsurance] = ?";
            conn = new DBContext().getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, en.encryptCCCDTo(healthInsurance));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User s = new User();
                s.setIdUser(rs.getInt("idUser"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setIdentification(rs.getString("identification"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setHealthInsurance("healthInsurance");
                s.setRole(rs.getInt("role"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User findUserByID(int id) throws Exception {
        try {
            String sql = "select * from [user] where [idUser] = ?";
            conn = new DBContext().getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User s = new User();
                s.setIdUser(rs.getInt("idUser"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setIdentification(rs.getString("identification"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setHealthInsurance(rs.getString("healthInsurance"));
                s.setRole(rs.getInt("role"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int register(String name, String password,
            String identification, Date dob, boolean gender, String phone,
            String email, String healthInsurance, int role) throws Exception{
        try {
            String pass = en.encryptCCCDTo(password);
            String identificationmd5 = en.encryptCCCDTo(identification);
            String healthInsurancemd5 = en.encryptCCCDTo(healthInsurance);
            try {
                String sql = "INSERT INTO [dbo].[user]\n"
                        + "           ([username]\n"
                        + "           ,[password]\n"
                        + "           ,[identification]\n"
                        + "           ,[dob]\n"
                        + "           ,[gender]\n"
                        + "           ,[phone]\n"
                        + "           ,[email]\n"
                        + "           ,[healthInsurance]\n"
                        + "           ,[role])\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?)";
                conn = new DBContext().getConnection();
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, pass);
                stm.setString(3, identificationmd5);
                stm.setDate(4, dob);
                stm.setBoolean(5, gender);
                stm.setString(6, phone);
                stm.setString(7, email);
                stm.setString(8, healthInsurancemd5);
                stm.setInt(9, 1);
                stm.executeUpdate();
            } catch (Exception ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }
            return 1;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return 0;
    }

    public int updateUser(String password, String email) throws Exception {
        String pass = en.encryptCCCDTo(password);
        try {
            String sql = "UPDATE [dbo].[user]\n"
                    + "   SET [password] = ?\n"
                    + "WHERE [user].email =?";
            conn = new DBContext().getConnection();
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, pass);
            stm.setString(2, email);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

    public int updateUser(int idUser, String name, String identification, Date dob, boolean gender, String phone, String email, String healthInsurance) throws Exception {
        String identificationmd5 = en.encryptCCCDTo(identification);
        String healthInsurancemd5 = en.encryptCCCDTo(healthInsurance);
        try {
            String sql = "UPDATE [dbo].[user]\n"
                    + "   SET [username] = ?\n"
                    + "      ,[identification] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[gender] = ?\n"
                    + "      ,[phone] = ?\n"
                    + "      ,[email] = ?\n"
                    + "      ,[healthInsurance] = ?\n"
                    + "WHERE [user].idUser =?";
            conn = new DBContext().getConnection();
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, name);
            stm.setString(2, identificationmd5);
            stm.setDate(3, dob);
            stm.setBoolean(4, gender);
            stm.setString(5, phone);
            stm.setString(6, email);
            stm.setString(7, healthInsurancemd5);
            stm.setInt(8, idUser);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

//    public int totalUser() {
//        try {
//            String sql = "select count([idUser]) as count from [user] ";
//            PreparedStatement stm = conn.prepareCall(sql);
//            ResultSet rs = stm.executeQuery();
//            if (rs.next()) {
//                int count = rs.getInt("count");
//                return count;
//            }
//            return 0;
//        } catch (SQLException ex) {
//            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
//            return 0;
//        }
//    }
    public static void main(String[] args) {
        UserDao us = new UserDao();
//        List<User> t = us.getAllUser();
//        for (User user : t) {
//            System.out.println(user);
//        }
//        String email = "nguyendiephoang111@gmail.com";
//        try {
//            User t = us.findUserByEmail(email);
//            System.out.println(t);
//        } catch (Exception ex) {
//            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
//        }

        int id = 1;
        try {
            User t = us.findUserByID(id);
            System.out.println(t);
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        

    }
}
