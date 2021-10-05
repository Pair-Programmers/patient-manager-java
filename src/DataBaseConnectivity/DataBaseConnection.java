/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseConnectivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

/**
 *
 * @author Mian Hamza Saqib
 */
public class DataBaseConnection {

    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public DataBaseConnection() {
        connection = null;
        preparedStatement = null;
        resultSet = null;
    }

    public Connection connectDataBase() {
        String url1 = "jdbc:mysql://localhost:3306/patient_manager?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String url = "jdbc:mysql://localhost:3306/patient_manager?zeroDateTimeBehavior=convertToNull";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url1, username, password);
            System.out.println("Database connected!");
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "MySQL is not running please open the requested Software : " + e.getMessage());
        }
        return null;
    }

    public void runExecuteUpdate(String query) {
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public ResultSet runSelectQuery(String query) {
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }
    
    public boolean runBackupQuery(String query) {
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            return true;
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Message");
            a.setHeaderText(null);
            a.setContentText(String.format("Backup Already Exist"));
            a.showAndWait();
        }
        return false;
    }
}
