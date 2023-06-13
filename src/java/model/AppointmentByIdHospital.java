/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL VOSTRO 5510
 */
public class AppointmentByIdHospital {

    private int idUserVaccineA;
    private String username;
    private String vaccineName;
    private String hospitalName;
    private double price;
    private String gender;
    private String date;
    private String startAt;
    private String endAt;

    // Constructor
    public AppointmentByIdHospital(int idUserVaccineA, String username, String vaccineName, String hospitalName,
            double price, String gender, String date, String startAt, String endAt) {
        this.idUserVaccineA = idUserVaccineA;
        this.username = username;
        this.vaccineName = vaccineName;
        this.hospitalName = hospitalName;
        this.price = price;
        this.gender = gender;
        this.date = date;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    // Getters and Setters
    public int getIdUserVaccineA() {
        return idUserVaccineA;
    }

    public void setIdUserVaccineA(int idUserVaccineA) {
        this.idUserVaccineA = idUserVaccineA;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    @Override
    public String toString() {
        return "AppointmentByIdHospital{" + "idUserVaccineA=" + idUserVaccineA + ", username=" + username + ", vaccineName=" + vaccineName + ", hospitalName=" + hospitalName + ", price=" + price + ", gender=" + gender + ", date=" + date + ", startAt=" + startAt + ", endAt=" + endAt + '}';
    }
}
