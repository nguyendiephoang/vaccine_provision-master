/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL VOSTRO 5510
 */
public class Appointment {
    private int userId;
    private String username;
    private String vaccineName;
    private String hospitalName;
    private double price;
    private String gender;
    private String date;
    private String startAt;
    private String endAt;

    public Appointment(int userId, String username, String vaccineName, String hospitalName, double price,
                       String gender, String date, String startAt, String endAt) {
        this.userId = userId;
        this.username = username;
        this.vaccineName = vaccineName;
        this.hospitalName = hospitalName;
        this.price = price;
        this.gender = gender;
        this.date = date;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public double getPrice() {
        return price;
    }

    public String getGender() {
        return gender;
    }

    public String getDate() {
        return date;
    }

    public String getStartAt() {
        return startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    @Override
    public String toString() {
        return "Appointment{" + "userId=" + userId + ", username=" + username + ", vaccineName=" + vaccineName + ", hospitalName=" + hospitalName + ", price=" + price + ", gender=" + gender + ", date=" + date + ", startAt=" + startAt + ", endAt=" + endAt + '}';
    }
    
    
}

