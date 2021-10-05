/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanager;

import Interface.Patient;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javax.swing.JOptionPane;

/**
 *
 * @author Mian Hamza Saqib
 */
public class ScreenController {
    String stageTitle;
    String fxmlFileName;
    Stage stage;

    public ScreenController() {
        stage = null;
    }
    
    public Stage getStage(){
        return stage;
    }
    
    public ScreenController(String fxmlFileName, String stageTitle) {
        this.fxmlFileName = fxmlFileName;
        this.stageTitle = stageTitle;
    }

    public void start() {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource(fxmlFileName));
        } catch (IOException ex) {
            System.out.println("GUI.ScreenController.start() " + ex.getMessage());
        }
        Scene scene = new Scene(parent);
        //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        stage = new Stage();
        stage.setTitle(stageTitle);
        //stage.hide(); //optional
        stage.setScene(scene);
        stage.show();

//        } else if (stage.isShowing()) {
//            stage.toFront();
//        } else {
//            stage.show();
//        }
    }
    
    public void startAndPassInfromationForAddPatientForm(ArrayList<Patient> patientArrayList, ObservableList patientTableObservavleList, String user) {
        FXMLLoader fXMLLoader = new FXMLLoader();
        Parent parent = null;
        
        try {
            fXMLLoader.setLocation(getClass().getResource(fxmlFileName));
            parent = fXMLLoader.load();
        } catch (IOException ex) {
            System.out.println("GUI.ScreenController.start() " + ex.getMessage());
        }
        Scene scene = new Scene(parent);
        //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //accsses the controller info
        AddPatientController addPatientController = fXMLLoader.getController();
        addPatientController.infoReciever(patientArrayList, patientTableObservavleList, user);
        
        stage = new Stage();
        stage.setTitle(stageTitle);
        //stage.hide(); //optional
        stage.setScene(scene);
        stage.show();

    }
    
    
    
    public void startAndPassInfromationForUpdatePatientForm(ArrayList<Patient> patientArrayList, ObservableList patientTableObservavleList, TableView patientTableView, String user) {
        FXMLLoader fXMLLoader = new FXMLLoader();
        Parent parent = null;
        
        try {
            fXMLLoader.setLocation(getClass().getResource(fxmlFileName));
            parent = fXMLLoader.load();
        } catch (IOException ex) {
            System.out.println("GUI.ScreenController.start() " + ex.getMessage());
        }
        Scene scene = new Scene(parent);
        //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //accsses the controller info
        NewUpdateController newUpdatePatientController = fXMLLoader.getController();
        //JOptionPane.showMessageDialog(null, user);
        newUpdatePatientController.infoReciever(patientArrayList, patientTableObservavleList, patientTableView, user);
        
        stage = new Stage();
        stage.setTitle(stageTitle);
        //stage.hide(); //optional
        stage.setScene(scene);
        stage.show();

    }
    
    public void startAndPassInfromationForUpdatePatientForm(ArrayList<Patient> patientArrayList, ObservableList patientTableObservavleList, int id, TableView patientTableView, String user) {
        FXMLLoader fXMLLoader = new FXMLLoader();
        Parent parent = null;
        
        try {
            fXMLLoader.setLocation(getClass().getResource(fxmlFileName));
            parent = fXMLLoader.load();
        } catch (IOException ex) {
            System.out.println("GUI.ScreenController.start() " + ex.getMessage());
        }
        Scene scene = new Scene(parent);
        //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //accsses the controller info
        NewUpdateController newUpdatePatientController = fXMLLoader.getController();
        newUpdatePatientController.infoReciever(patientArrayList, patientTableObservavleList, id, patientTableView, user);
        
        stage = new Stage();
        stage.setTitle(stageTitle);
        //stage.hide(); //optional
        stage.setScene(scene);
        stage.show();

    }
    
    

    public void setFxmlFileName(String fxmlFileName) {
        this.fxmlFileName = fxmlFileName;
    }

    public String getFxmlFileName() {
        return fxmlFileName;
    }

    public void setStageTitle(String stageTitle) {
        this.stageTitle = stageTitle;
    }

    public String getStageTitle() {
        return stageTitle;
    }
}
