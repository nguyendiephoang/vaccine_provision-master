/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Hospital;
import model.User;

/**
 *
 * @author DELL
 */
public class hospitalDao_1 extends DBContext{
    Encrypt en = new Encrypt();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Hospital> getAllHospital() throws SQLException, Exception {
        List<Hospital> list = new ArrayList<>();
        String sql = "select * from [hospital]";
        conn = new DBContext().getConnection();
        PreparedStatement stm = conn.prepareCall(sql);
        ResultSet rs = stm.executeQuery();
        try {
            while (rs.next()) {
                list.add(new Hospital(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7)));
                
            }
        } catch (Exception e) {
        }
        return list;}
    
    public Hospital findHospital(String email, String password) throws Exception {
        try {
            String sql = "select * from [hospital] where [email] = ? and [password] = ?";
            conn = new DBContext().getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, en.encryptCCCDTo(password));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Hospital s = new Hospital();
                s.setIdBV(rs.getInt("idH"));
                s.setName(rs.getString("name"));
                s.setAddress(rs.getString("address"));
                s.setEmail(rs.getString("email"));
                s.setHotline(rs.getString("hotline"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        hospitalDao_1 h = new hospitalDao_1();
        
            Hospital l;
        try {
            l = h.findHospital("nguyendiephoang111@gmail.com", "123");
            System.out.println(l);
        } catch (Exception ex) {
            Logger.getLogger(hospitalDao_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
        
            
}
}

