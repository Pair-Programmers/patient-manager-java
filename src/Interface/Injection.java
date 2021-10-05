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
public class Injection {
    int id;
    String name;
    float price;

    public Injection() {
    }

    public Injection(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
    
    public void addInjection(Injection injection){
       
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "INSERT INTO `injection`(`name`, `price`) VALUES ('"+injection.getName()+"', "+ "'"+injection.getPrice()+"')";
        dataBaseConnection.runExecuteUpdate(query);
    }
    
    public ArrayList<Injection> getAllInjection(){
        ArrayList<Injection> injectionArrayList = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT * FROM `injection`";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            while (rs.next()) {
                injectionArrayList.add(new Injection(rs.getInt("id"), rs.getString("name").toUpperCase(), rs.getFloat("price")));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while getting OTPs data !");
        }
        /**/
        return injectionArrayList;
    }

    public static Injection getInjectionName(int id) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT * FROM `injection` where id = '"+id+"'";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "gett !");
                return new Injection(id, rs.getString("name"), rs.getFloat("price"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while searching name !");
        }
        return null;
    }
    
    public boolean isInjectionNameExist(String name){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT  `id` FROM `injection` where `name` = '"+name+"' ";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            rs.next();
            rs.getInt("id");
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public void updateInjection(Injection injection){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "UPDATE `injection` SET `price`="+injection.getPrice()+" WHERE `name` = '"+injection.getName()+"'";
        dataBaseConnection.runExecuteUpdate(query);
        
    }
   
}
