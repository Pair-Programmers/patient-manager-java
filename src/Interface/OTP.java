/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import DataBaseConnectivity.DataBaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mianh
 */
public class OTP {
    int id;
    String name;
    String phone;

    public OTP() {
    }

    public OTP(int id, String name, String phone) {
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
    
    public void addOTP(OTP otp){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "INSERT INTO `otp`(`name`, `phone`) VALUES ('"+otp.getName()+"', "+ "'"+otp.getPhone()+"')";
        dataBaseConnection.runExecuteUpdate(query);
    }
    
    public void updateOTP(OTP otp){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "UPDATE `otp` SET `name`= '"+otp.getName()+"',`phone`= '"+otp.getPhone()+"'  WHERE `id` = "+otp.getId()+"";
        dataBaseConnection.runExecuteUpdate(query);
        
    }
    
    public void deleteOTP(OTP otp){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "DELETE FROM `otp` WHERE `id` = "+this.id+"";
        dataBaseConnection.runExecuteUpdate(query);
    }
    
    public ArrayList<OTP> getAllOTPs(){
        ArrayList<OTP> otpArrayList = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT * FROM `otp`";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            while (rs.next()) {
                otpArrayList.add(new OTP(rs.getInt("id"), rs.getString("name"), rs.getString("phone")));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while getting OTPs data !");
        }
        return otpArrayList;
    }
    
    public Boolean isPhoneNumberExist(String phone){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT phone FROM `otp` where phone = '"+phone+"'";
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
        String query = "SELECT name FROM `otp` where name = '"+name+"'";
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
