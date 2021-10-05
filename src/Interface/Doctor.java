/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import DataBaseConnectivity.DataBaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mianh
 */
public class Doctor {
    int id;
    String name;
    String phone;

    public Doctor() {
    }

    public Doctor(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
    
    public void addDoctor(Doctor doctor){
       
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "INSERT INTO `doctors`(`name`, `phone`) VALUES ('"+doctor.getName()+"', "+ "'"+doctor.getPhone()+"')";
        dataBaseConnection.runExecuteUpdate(query);
    }
    
    public void updateDoctor(Doctor doctor){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "UPDATE `doctors` SET `name`= '"+doctor.getName()+"',`phone`= '"+doctor.getPhone()+"' WHERE `id` = "+doctor.getId()+"";
        dataBaseConnection.runExecuteUpdate(query);
    }
    
    public void deleteDoctor(Doctor doctor){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "DELETE FROM `doctors` WHERE `id` = "+doctor.getId()+"";
        dataBaseConnection.runExecuteUpdate(query);
    }
    
    public ArrayList<Doctor> getAllDoctor(){
        ArrayList<Doctor> doctorArrayList = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT * FROM `doctors`";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            while (rs.next()) {
                doctorArrayList.add(new Doctor(rs.getInt("id"), rs.getString("name"), rs.getString("phone")));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while getting OTPs data !");
        }
        /**/
        return doctorArrayList;
    }
    
    public Boolean isPhoneNumberExist(String phone){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT phone FROM `doctors` where phone = '"+phone+"'";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            if (rs.next()) {
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while getting OTPs data !");
        }
        return false;
    } 
    
    public Boolean isNameExist(String name){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT name FROM `doctors` where name = '"+name+"'";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            if (rs.next()) {
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while searching name !");
        }
        return false;
    } 
}
