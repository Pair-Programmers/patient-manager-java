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
public class Editor {
    int id;
    String userName;
    String paassword;

    public Editor() {
    }

    public Editor(int id, String userName, String paassword) {
        this.id = id;
        this.userName = userName;
        this.paassword = paassword;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPaassword(String paassword) {
        this.paassword = paassword;
    }

    public String getPaassword() {
        return paassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
    
    public void addEditor(Editor editor){
       
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "INSERT INTO `editors`(`userName`, `password`) VALUES ('"+editor.getUserName()+"', "+ "'"+editor.getPaassword()+"')";
        dataBaseConnection.runExecuteUpdate(query);
    }
    
  
    
    public void deleteEditor(Editor editor){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "DELETE FROM `editors` WHERE `id` = "+editor.getId()+"";
        dataBaseConnection.runExecuteUpdate(query);
    }
    
    public ArrayList<Editor> getAllEditor(){
        ArrayList<Editor> editorArrayList = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT * FROM `editors`";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            while (rs.next()) {
                editorArrayList.add(new Editor(rs.getInt("id"), rs.getString("userName"), rs.getString("password")));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while getting editors data !");
        }
        /**/
        return editorArrayList;
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
    
    public Boolean isUserNameExist(String userName){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT userName FROM `editors` where userName = '"+userName+"'";
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
