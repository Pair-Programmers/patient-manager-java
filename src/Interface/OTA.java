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
public class OTA {
    int id;
    String name;
    String phone;

    public OTA() {
    }

    public OTA(int id, String name, String phone) {
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
    
    public void addOTA(OTA ota){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "INSERT INTO `ota`(`name`, `phone`) VALUES ('"+ota.getName()+"', "+ "'"+ota.getPhone()+"')";
        dataBaseConnection.runExecuteUpdate(query);
    }
    
    public void updateOTA(OTA ota){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "UPDATE `ota` SET `name`= '"+ota.getName()+"',`phone`= '"+ota.getPhone()+"' WHERE `id` = "+ota.getId()+"";
        dataBaseConnection.runExecuteUpdate(query);
    }
    
    public void deleteOTA(OTA ota){
         DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "DELETE FROM `ota` WHERE `id` = "+this.id+"";
    }
    
    public ArrayList<OTA> getAllOTAs(){
        ArrayList<OTA> otaArrayList = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT * FROM `ota`";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            while (rs.next()) {
                otaArrayList.add(new OTA(rs.getInt("id"), rs.getString("name"), rs.getString("phone")));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while getting OTAs data !");
        }
        return otaArrayList;
    }
    
    public Boolean isPhoneNumberExist(String phone){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT phone FROM `ota` where phone = '"+phone+"'";
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
        String query = "SELECT name FROM `ota` where name = '"+name+"'";
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
