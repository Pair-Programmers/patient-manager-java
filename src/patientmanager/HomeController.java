/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanager;

import DataBaseConnectivity.DataBaseConnection;
import Interface.CreateWordFile;
import Interface.Doctor;
import Interface.ExcelConverter;
import Interface.OTA;
import Interface.OTP;
import Interface.Patient;
import SMSGateway.SMSGatewayEZEE;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author 15009065376
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
       
    @FXML
    private Label noOfPatientLabel;
    
    
    @FXML
    private Label dateLabel;
    @FXML
    private Label totalPatientMessageLabel;
    @FXML
    private Label doctorNameLabel2;
    @FXML
    private Label totalPatientMessageLabel2;
    @FXML
    private Label nameInMessageLabel3;
    @FXML
    private Label totalPatientMessageLabel3;
    @FXML
    private Label idInMessageLabel;
    @FXML
    private Label nameInMessageLabel;
    @FXML
    private Label phoneInMessageLabel;
    @FXML
    private Label doctorNameLabel1;
    
    @FXML
    private Label navigationalLabel;
    
    @FXML
    private ToggleGroup AMPMToggleGroup;
    @FXML
    private TextField searchTextField;
    
    @FXML
    private TextField timeTextField;
    
    @FXML
    private TextField usernameTextField;
    
    @FXML
    private Pane welcomePane;
    
    @FXML
    private Pane welcomePane2;

    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField passwordField2;

    @FXML
    private Button enterPasswordButton;

    
    @FXML
    private Pane homePane;

    @FXML
    private SplitPane messageConfirmVSplitPane;
    @FXML
    private Button addPatientButton;
    @FXML
    private ImageView printinIconimageView;
    @FXML
    private Button updatePatientButton;
    
    @FXML
    private Button messageButton;
    @FXML
    private Button moveToPatientListButton;
    @FXML
    private Button moveToOnSurgeryButton;
    @FXML
    private Button moveToCompletedButton;
    @FXML
    private Button moveToOnPosponeButton;

    @FXML
    private MenuItem exportDataToExcelMenuItem;
     
    @FXML
    private MenuItem injectionsMenuItem;

    @FXML
    private MenuItem addEditorMenuItem;
    
    @FXML
    private MenuItem backupMenuItem;
    
    @FXML
    private Button logOutButton;

    @FXML
    private Button searchButton;
    @FXML
    private Label sortByLabel;
    
    @FXML
    private Label userLoginLabel;
    
    @FXML
    private ComboBox<String> doctorsComboBox;
    @FXML
    private ComboBox<String> OTAComboBox;
    @FXML
    private ComboBox<String> OTPComboBox;
    
    @FXML
    private ComboBox<String> timeComboBox;
    
    @FXML
    private ComboBox<String> timeComboBox2;
    
   
    @FXML
    private Button printButton;
    
    @FXML
    private TableView<Patient> patientTableView;
    
    private ObservableList<Patient> patientTableObservavleList;
    
    private ObservableList<Patient> tempPatientTableObservavleList;

    @FXML
    private TableColumn<Patient,Integer> noTableColumn;

    @FXML
    private TableColumn<Patient, String> nameTableColumn;

    @FXML
    private TableColumn<Patient, Integer> fileNumberTableColumn;

    @FXML
    private TableColumn<Patient, String> phoneNumberTableColumn;

    @FXML
    private TableColumn<Patient, String> cnicTableColumn;

    @FXML
    private TableColumn<Patient, String> adressTableColumn;

    @FXML
    private TableColumn<Patient, String> raseed1TableColumn;

    @FXML
    private TableColumn<Patient, Integer> recieptTableColumn;

    @FXML
    private TableColumn<Patient, String> surgreyTableColumn;
    
    @FXML
    private TableColumn<Patient, String> dateTableColumn;
    
    @FXML
    private TableColumn<Patient, String> procedureTableColumn;
    
    @FXML
    private TableColumn<Patient, String> surgenTableColumn;

    @FXML
    private TableColumn<Patient, String> userTableColumn;
    
    @FXML
    private HBox completedDateHBox;
    
    @FXML
    private DatePicker fromDatePicker;
    
    @FXML
    private DatePicker surgeryConfirmationDatePicker;

    @FXML
    private DatePicker toDatePicker;
    
    private ArrayList<Patient> patientArrayList;
    private ArrayList<Patient> tempPatientArrayList;
    
    private Patient patient;
    
    private String user;
    private String status;
    String[] weekDaysInUrdu = {"پیر", "منگل", "بدھ", "جمعرات", "جمعه", "ہفتہ", "اتوار"};
    String[] weekDaysInEnglish = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    
    
    ObservableList doctorsComboBoxObservavleList;
    ObservableList otaComboBoxObservavleList;
    ObservableList otpComboBoxObservavleList;
    ObservableList timeComboBoxObservavleList;
    
    Doctor doctor;
    OTA ota;
    OTP otp;
    
    
    
    ArrayList<Doctor> doctorArrayList;
    ArrayList<OTA> otaArrayList;
    ArrayList<OTP> otpArrayList;
    
    PropertyValueFactory propertyValueFactoryDate1;
    PropertyValueFactory propertyValueFactoryDate2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        status = "none";
        Patient.setCurrentID();
        patientTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        // TODO
        //initializing table  metaData
        patientTableObservavleList = FXCollections.observableArrayList();
        
        propertyValueFactoryDate1 = new PropertyValueFactory<>("date");
        propertyValueFactoryDate2 = new PropertyValueFactory<>("surgeryCompletionDate");
        
        noTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        fileNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("fileNumber"));
        phoneNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("phone1"));
        cnicTableColumn.setCellValueFactory(new PropertyValueFactory<>("cnic"));
        adressTableColumn.setCellValueFactory(new PropertyValueFactory<>("area"));
        raseed1TableColumn.setCellValueFactory(new PropertyValueFactory<>("raseed1"));
        recieptTableColumn.setCellValueFactory(new PropertyValueFactory<>("actualPrice"));
        surgreyTableColumn.setCellValueFactory(new PropertyValueFactory<>("surgrey"));
        procedureTableColumn.setCellValueFactory(new PropertyValueFactory<>("foldPCIOL"));
        
        
        dateTableColumn.setCellValueFactory(propertyValueFactoryDate1);
        surgenTableColumn.setCellValueFactory(new PropertyValueFactory<>("surgen"));
        userTableColumn.setCellValueFactory(new PropertyValueFactory<>("user"));
        // setting metadata on table 
        patientTableView.setItems(patientTableObservavleList);
        //end */
        patient = new Patient();
        patientArrayList = new ArrayList<>();
        tempPatientArrayList = new ArrayList<>();
        loadPatientData();
        
        LocalDateTime currentTime = LocalDateTime.now();
        
        StringBuilder date =  new StringBuilder();
        date.append(String.valueOf(currentTime.toLocalDate()).substring(8,10));date.append("-");
        date.append(String.valueOf(currentTime.toLocalDate()).substring(5,7));date.append("-");
        date.append(String.valueOf(currentTime.toLocalDate()).substring(0,4));
        dateLabel.setText(date.toString() + "");
        
        
        doctor = new Doctor();
        ota = new OTA();
        otp = new OTP();
        
        doctorArrayList = new ArrayList<>();
        otaArrayList = new ArrayList<>();
        otpArrayList = new ArrayList<>();
        
        doctorArrayList = doctor.getAllDoctor();
        otaArrayList = ota.getAllOTAs();
        otpArrayList = otp.getAllOTPs();
        
        doctorsComboBoxObservavleList = FXCollections.observableArrayList();
        otaComboBoxObservavleList = FXCollections.observableArrayList();
        otpComboBoxObservavleList = FXCollections.observableArrayList();
        timeComboBoxObservavleList = FXCollections.observableArrayList();
        
        doctorsComboBoxObservavleList.add("None");
        for (int i = 0; i < doctorArrayList.size(); i++) {
            doctorsComboBoxObservavleList.add(doctorArrayList.get(i).getName());
        }
        for (int i = 0; i < otaArrayList.size(); i++) {
            otaComboBoxObservavleList.add(otaArrayList.get(i).getName());
        }
        for (int i = 0; i < otpArrayList.size(); i++) {
            otpComboBoxObservavleList.add(otpArrayList.get(i).getName());
        }
        
        for (int i = 1; i < 13; i++) {
            timeComboBoxObservavleList.add(String.valueOf(i));
        }
        
        
        
        doctorsComboBox.setItems(doctorsComboBoxObservavleList);
        OTAComboBox.setItems(otaComboBoxObservavleList);
        OTPComboBox.setItems(otpComboBoxObservavleList);
        timeComboBox.setItems(timeComboBoxObservavleList);
        timeComboBox2.setItems(timeComboBoxObservavleList);
        
        //setVisibleOnSergeryComponents(false);
        completedDateHBox.setVisible(false);
        //user = new String();
        userLoginLabel.setText(user);
    } 
    
    @FXML
    void addPatientButtonActionListner(ActionEvent event) {
        
        ScreenController screenController = new ScreenController("AddPatient.fxml", "Add Patient");
        screenController.startAndPassInfromationForAddPatientForm(patientArrayList, patientTableObservavleList, user);
        
    }
    
    @FXML
    void rereshTableButtonActionListner(ActionEvent event) {
        doctorsComboBoxObservavleList.clear();
        otaComboBoxObservavleList.clear();
        otpComboBoxObservavleList.clear();
                
        doctorArrayList = doctor.getAllDoctor();
        otaArrayList = ota.getAllOTAs();
        otpArrayList = otp.getAllOTPs();
        
        doctorsComboBoxObservavleList.add("None");
        for (int i = 0; i < doctorArrayList.size(); i++) {
            doctorsComboBoxObservavleList.add(doctorArrayList.get(i).getName());
        }
        for (int i = 0; i < otaArrayList.size(); i++) {
            otaComboBoxObservavleList.add(otaArrayList.get(i).getName());
        }
        for (int i = 0; i < otpArrayList.size(); i++) {
            otpComboBoxObservavleList.add(otpArrayList.get(i).getName());
        }
        
        doctorsComboBox.setItems(doctorsComboBoxObservavleList);
        OTAComboBox.setItems(otaComboBoxObservavleList);
        OTPComboBox.setItems(otpComboBoxObservavleList);
        
        loadTableData(status);
        
    }
    
    @FXML
    void cancelMessageScreenActionListner(ActionEvent event) {
        messageConfirmVSplitPane.setVisible(false);
        homePane.setVisible(true);
        
    } 
    
    @FXML
    void doctorsComboBoxActionListner2(ActionEvent event) {
        String option = doctorsComboBox.getSelectionModel().getSelectedItem();
        if(option.equals("None"))
        {
            loadTableData(status);
        }
        else{
            
            loadTableData(status, option);
        }
    }
    
    
    
    @FXML
    void updatePatientButtonActionListner(ActionEvent event) {
        //
        ScreenController screenController = new ScreenController("NewUpdate.fxml", "Update Patient");
        //screenController.start();
        
        screenController.startAndPassInfromationForUpdatePatientForm(patientArrayList, patientTableObservavleList, patientTableView, user);
    }
    
    @FXML
    void openSlectedPatientButtonActionListner(ActionEvent event) {
        
//JOptionPane.showMessageDialog(null, "open slected!");
        ScreenController screenController = new ScreenController("NewUpdate.fxml", "Update Patient");
        int id;
        try {
             id = patientTableView.getSelectionModel().getSelectedItem().getId();
             //JOptionPane.showMessageDialog(null, id);
             screenController.startAndPassInfromationForUpdatePatientForm(patientArrayList, patientTableObservavleList, id, patientTableView, user);
    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no item is selected !");
        }
    }

    @FXML
    void logOutButtonActionListner(ActionEvent event) {
        //JOptionPane.showMessageDialog(null, "Patient Updated!");
        
       homePane.setVisible(false);
       welcomePane.setVisible(true);
       passwordField.setText("");
       passwordField2.setText("");
       usernameTextField.setText("");
    }

    
    
    //@FXML
    public void searchTextFieldOnKeyReleased() {
        String id;
        int count = 0;
        if(!searchTextField.getText().equals("")){
            try{
                //Integer.parseInt(searchTextField.getText());
                patientTableObservavleList.clear();
                for (int i = 0; i < patientArrayList.size(); i++) {
                    
                    id = String.valueOf(patientArrayList.get(i).getPhone1());
                    if(id.startsWith(searchTextField.getText()) && patientArrayList.get(i).getStatus().equals(this.status)){
                        count++;
                        patientTableObservavleList.add(patientArrayList.get(i));
                        noOfPatientLabel.setText(String.valueOf(count));
                        patientTableView.refresh();
                        //break;
                    } /*else if (patientArrayList.size()-1 == i){
                        
                        patientTableObservavleList.clear();
                        patientTableView.refresh();
                    }*/
                }
                
            } catch (NumberFormatException e) {
                
            }
        } else {
            loadTableData(status);
            //JOptionPane.showMessageDialog(null, " !");
        }
        
    }
    
    @FXML
    void searchButtonActionListner(ActionEvent event) {
        if(!searchTextField.getText().equals("")){
            
                
                for (int i = 0; i < patientArrayList.size(); i++) {
                    
                    if(patientArrayList.get(i).getPhone1().equals(searchTextField.getText())){
                        patientTableObservavleList.clear();
                        patientTableObservavleList.add(patientArrayList.get(i));
                        noOfPatientLabel.setText(String.valueOf(i+1));
                        patientTableView.refresh();
                        break;
                    } else if (patientArrayList.size()-1 == i){
                        
                        patientTableObservavleList.clear();
                        patientTableView.refresh();
                    }
                }
                
            
        } else {
            loadTableData(status);
            
            //JOptionPane.showMessageDialog(null, "Enter Id !");
        }
        
    }
    @FXML
    void searchByIDButtonActionListner(ActionEvent event) {
        if(!searchTextField.getText().equals("")){
            int id;
            try{
                id = Integer.parseInt(searchTextField.getText());
                
                for (int i = 0; i < patientArrayList.size(); i++) {
                    
                    if(patientArrayList.get(i).getId()== id){
                        patientTableObservavleList.clear();
                        patientTableObservavleList.add(patientArrayList.get(i));
                        noOfPatientLabel.setText(String.valueOf(i+1));
                        patientTableView.refresh();
                        break;
                    } else if (patientArrayList.size()-1 == i){
                        
                        patientTableObservavleList.clear();
                        patientTableView.refresh();
                    }
                }
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid ID");
            }
        } else {
            loadTableData(status);
            
            //JOptionPane.showMessageDialog(null, "Enter Id !");
        }
    }
    @FXML
    void searchByFileNumberButtonActionListner(ActionEvent event) {
        if(!searchTextField.getText().equals("")){
            String fileNumber;
            try{
                fileNumber = searchTextField.getText();
                
                for (int i = 0; i < patientArrayList.size(); i++) {
                    
                    if(patientArrayList.get(i).getFileNumber().equals(fileNumber)){
                        patientTableObservavleList.clear();
                        patientTableObservavleList.add(patientArrayList.get(i));
                        noOfPatientLabel.setText(String.valueOf(i+1));
                        patientTableView.refresh();
                        break;
                    } else if (patientArrayList.size()-1 == i){
                        
                        patientTableObservavleList.clear();
                        patientTableView.refresh();
                    }
                }
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid or Not Found");
            }
        } else {
            loadTableData(status);
            
            //JOptionPane.showMessageDialog(null, "Enter Id !");
        }
        
    }
    
    void loadTableData(String status){
        int counter = 0;
        noOfPatientLabel.setText("0");
        patientTableObservavleList.clear();
        
        tempPatientArrayList.clear();
        if(status.equals("surgery")) {
            for (int i = 0; i < patientArrayList.size(); i++) {
                if(patientArrayList.get(i).getStatus().equals(status)){
                    patientTableObservavleList.add(patientArrayList.get(i));
                    noOfPatientLabel.setText(String.valueOf(++counter));
                    tempPatientArrayList.add(patientArrayList.get(i));
                }

            }
        } else if(status.equals("postponed")) {
            for (int i = 0; i < patientArrayList.size(); i++) {
                if(patientArrayList.get(i).getStatus().equals(status)){
                    patientTableObservavleList.add(patientArrayList.get(i));
                    noOfPatientLabel.setText(String.valueOf(++counter));
                }

            }
        } else {
            for (int i = 0; i < patientArrayList.size(); i++) {
                if(patientArrayList.get(i).getStatus().equals(status)){
                    patientTableObservavleList.add(patientArrayList.get(i));
                    noOfPatientLabel.setText(String.valueOf(++counter));
                }

            }
        }
        
        patientTableView.refresh();
        doctorsComboBox.getSelectionModel().select(0);
    }
    
    void loadTableData(String status, String doctor){
        int counter = 0;
        noOfPatientLabel.setText("0");
        patientTableObservavleList.clear();
        
        tempPatientArrayList.clear();
        if(status.equals("surgery")) {
            for (int i = 0; i < patientArrayList.size(); i++) {
                if(patientArrayList.get(i).getStatus().equals(status) && patientArrayList.get(i).getSurgen().equals(doctor)){
                    patientTableObservavleList.add(patientArrayList.get(i));
                    noOfPatientLabel.setText(String.valueOf(++counter));
                    tempPatientArrayList.add(patientArrayList.get(i));
                }

            }
        } else if(status.equals("postponed")) {
            for (int i = 0; i < patientArrayList.size(); i++) {
                if(patientArrayList.get(i).getStatus().equals(status) && patientArrayList.get(i).getSurgen().equals(doctor)){
                    patientTableObservavleList.add(patientArrayList.get(i));
                    noOfPatientLabel.setText(String.valueOf(++counter));
                }

            }
        } else {
            for (int i = 0; i < patientArrayList.size(); i++) {
                if(patientArrayList.get(i).getStatus().equals(status) && patientArrayList.get(i).getSurgen().equals(doctor)){
                    patientTableObservavleList.add(patientArrayList.get(i));
                    noOfPatientLabel.setText(String.valueOf(++counter));
                }

            }
        }
        patientTableView.refresh();
    }
    
    void loadPatientData(){
        //patients
        patientArrayList = patient.getAllPatients();
        
        
        //puting patients in table
        loadTableData(status);
     
    }
    
    @FXML
    void logInButtonActionListner(ActionEvent event) {
        
        /*welcomePane.setVisible(false);
          homePane.setVisible(true);*/
        if(!passwordField.getText().equals("")){
            if(passwordField.getText().equals(getPassword())){
                welcomePane.setVisible(false);
                homePane.setVisible(true);
                user = "1";
                userLoginLabel.setText("Admin");
                setAdminFeature(false);
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Password!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter Password!");
        }
            
    }
    
    @FXML
    void logIn2ButtonActionListner(ActionEvent event) {
        
        /*welcomePane.setVisible(false);
          homePane.setVisible(true);*/
        if(!usernameTextField.getText().equals("")){
            if(!passwordField2.getText().equals("")){
                if(passwordField2.getText().equals(getPassword(usernameTextField.getText()))){
                    welcomePane2.setVisible(false);
                    homePane.setVisible(true);
                    user = usernameTextField.getText();
                    userLoginLabel.setText(user);
                    setAdminFeature(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong user Password!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Enter Password!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter username!");
        }
        
            
    }
    
    void setAdminFeature(boolean flag){
        exportDataToExcelMenuItem.setDisable(flag);
        addEditorMenuItem.setDisable(flag);
    }
    
    @FXML
    void adminLoginPane1ButtonActionListner(ActionEvent event) {
        welcomePane.setVisible(true);
        welcomePane2.setVisible(false);
    }
    
    @FXML
    void editorLoginPane1ButtonActionListner(ActionEvent event) {
        welcomePane2.setVisible(true);
        welcomePane.setVisible(false);
    }
    
    @FXML
    void adminLoginPane2ButtonActionListner(ActionEvent event) {
        welcomePane.setVisible(true);
        welcomePane2.setVisible(false);
    }
    
    
    
    @FXML
    void editorLoginPane2ButtonActionListner(ActionEvent event) {
         welcomePane2.setVisible(true);
        welcomePane.setVisible(false);
    }
    
    @FXML
    void passwordFieldActionListner(ActionEvent event) {
        if(!passwordField.getText().equals("")){
            if(passwordField.getText().equals(getPassword())){
                welcomePane.setVisible(false);
                homePane.setVisible(true);
                setAdminFeature(false);
                user = "1";
                userLoginLabel.setText("Admin");
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Password!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter Password!");
        }  
    }
    
    @FXML
    void passwordField2ActionListner(ActionEvent event) {
        if(!usernameTextField.getText().equals("")){
            if(!passwordField2.getText().equals("")){
                if(passwordField2.getText().equals(getPassword(usernameTextField.getText()))){
                    welcomePane2.setVisible(false);
                    homePane.setVisible(true);
                    user = usernameTextField.getText();
                    userLoginLabel.setText(user);
                    setAdminFeature(true);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong user Password!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Enter Password!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter username!");
        }  
    }
    
    String getPassword(){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT * FROM `admin` LIMIT 1";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            rs.next();
            return rs.getString("password");
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error while getting Password !");
        }
        return null;
    }
    
    String getPassword(String username){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT * FROM `editors` where `userName` = '"+username+"'";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            rs.next();
            return rs.getString("password");
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error while getting Password !");
        }
        return null;
    }
    
    @FXML
    void doctorAndOTAButtonActionListner(ActionEvent event) {
        
        ScreenController screenController = new ScreenController("DoctorOTAOTP.fxml", "Add Doctors");
        //ScreenController screenController = new ScreenController("AddPatient.fxml", "Add Patient");
        screenController.start();
    }
    
    @FXML
    void searchForDateButtonActionListner(ActionEvent event) {
        LocalDate localDatePatient = null;
        LocalDate localDateFrom = fromDatePicker.getValue();
        LocalDate localDateTo = toDatePicker.getValue();
        int counter = 0;
        //noOfPatientLabel.setText("0");
        
        
        if(fromDatePicker.getValue() == null && toDatePicker.getValue() == null){
            //JOptionPane.showMessageDialog(null, "1");
        } else if(fromDatePicker.getValue() == null){
            patientTableObservavleList.clear();
            tempPatientArrayList.clear();
            
            //JOptionPane.showMessageDialog(null, "2");
            for (int i = 0; i < patientArrayList.size(); i++) {
                if(patientArrayList.get(i).getStatus().equals("completed")){
                    try {
                        localDatePatient = LocalDate.parse(patientArrayList.get(i).getSurgeryCompletionDate());
                        //JOptionPane.showMessageDialog(null, localDateFrom + "+" + localDatePatient +"+"+fromDatePicker.getValue());
                        if(localDateTo.isAfter(localDatePatient)||localDateTo.equals(localDatePatient)){
                            patientTableObservavleList.add(patientArrayList.get(i));
                            noOfPatientLabel.setText(String.valueOf(++counter));
                            tempPatientArrayList.add(patientArrayList.get(i));
                            //JOptionPane.showMessageDialog(null, "y");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "cannot convert patient date to local date");
                    }
                }
            }
        } else if(toDatePicker.getValue() == null){
            patientTableObservavleList.clear();
            tempPatientArrayList.clear();
            
            //JOptionPane.showMessageDialog(null, "3");
            for (int i = 0; i < patientArrayList.size(); i++) {
                if(patientArrayList.get(i).getStatus().equals("completed")){
                    try {
                        localDatePatient = LocalDate.parse(patientArrayList.get(i).getSurgeryCompletionDate());
                        //JOptionPane.showMessageDialog(null, localDateFrom + "+" + localDatePatient +"+"+fromDatePicker.getValue());
                        if(localDatePatient.isAfter(localDateFrom)||localDatePatient.equals(localDateFrom)){
                            patientTableObservavleList.add(patientArrayList.get(i));
                            noOfPatientLabel.setText(String.valueOf(++counter));
                            tempPatientArrayList.add(patientArrayList.get(i));
                            //JOptionPane.showMessageDialog(null, "y");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "cannot convert patient date to local date");
                    }
                }
            }
        } else{
            patientTableObservavleList.clear();
            tempPatientArrayList.clear();
            //JOptionPane.showMessageDialog(null, "4");
            for (int i = 0; i < patientArrayList.size(); i++) {
                if(patientArrayList.get(i).getStatus().equals("completed")){
                    try {
                        localDatePatient = LocalDate.parse(patientArrayList.get(i).getSurgeryCompletionDate());
                        //JOptionPane.showMessageDialog(null, localDateFrom + "+" + localDatePatient +"+"+fromDatePicker.getValue());
                        if(localDatePatient.isAfter(localDateFrom)||localDatePatient.equals(localDateFrom) && localDateTo.isAfter(localDatePatient)||localDateTo.equals(localDatePatient)){
                            patientTableObservavleList.add(patientArrayList.get(i));
                            noOfPatientLabel.setText(String.valueOf(++counter));
                            tempPatientArrayList.add(patientArrayList.get(i));
                            //JOptionPane.showMessageDialog(null, "y");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "cannot convert patient date to local date");
                    }
                }
            } 
        }
        
        
        
        patientTableView.refresh();
        
        
    }
    
    @FXML
    void exportDataToExcelMenuItemActionListner(ActionEvent event) {
        ExcelConverter excelConverter = new ExcelConverter();
        excelConverter.createExcelFile(patientArrayList);
        
    }
    
    @FXML
    void addEditorMenuItemActionListner(ActionEvent event) {
        ScreenController screenController = new ScreenController("Editors.fxml", "Editor");
        screenController.start();
    }
    
    @FXML
    void injectionMenuItemActionListner(ActionEvent event) {
        ScreenController screenController = new ScreenController("Injections.fxml", "Injections");
        screenController.start();
    }
    
    @FXML
    void backupMenuItemActionListner(ActionEvent event) {
        String filesLoaction = "D:/Patient Manager Backup/";
        String date = LocalDate.now().toString();
        String query1 =  "SELECT * INTO OUTFILE '"+filesLoaction+"("+date+") admin.sql' FROM admin";
        String query2 =   "SELECT * INTO OUTFILE '"+filesLoaction+"("+date+") currentid.sql' FROM currentid";
        String query3 =   "SELECT * INTO OUTFILE '"+filesLoaction+"("+date+") doctors.sql' FROM doctors";
        String query4 =    "SELECT * INTO OUTFILE '"+filesLoaction+"("+date+") editors.sql' FROM editors";
        String query5 =    "SELECT * INTO OUTFILE '"+filesLoaction+"("+date+") injections.sql' FROM injection";
        String query6 =    "SELECT * INTO OUTFILE '"+filesLoaction+"("+date+") ota.sql' FROM ota";
        String query7 =    "SELECT * INTO OUTFILE '"+filesLoaction+"("+date+") otp.sql' FROM otp;";
        String query8 =    "SELECT * INTO OUTFILE '"+filesLoaction+"("+date+") patients.sql' FROM patients";
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        
            dataBaseConnection.connectDataBase();
            
            if(dataBaseConnection.runBackupQuery(query1)){
                dataBaseConnection.runBackupQuery(query2);
                dataBaseConnection.runBackupQuery(query3);
                dataBaseConnection.runBackupQuery(query4);
                dataBaseConnection.runBackupQuery(query5);
                dataBaseConnection.runBackupQuery(query6);
                dataBaseConnection.runBackupQuery(query7);
                dataBaseConnection.runBackupQuery(query8);
                Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Message");
        a.setHeaderText(null);
        a.setContentText(String.format("Backup Saved"));
        a.showAndWait();
            }
            
            
            
        
        
        
        dataBaseConnection.connectDataBase();
        
        
        
        /*ArrayList<Patient>  tempArrayList = new ArrayList<>();
        tempArrayList = patient.getPatientsForBackup();
        Patient patient;
        ScreenController screenController = new ScreenController();
        FileChooser fc = new FileChooser();
                fc.setInitialFileName("Patients Backup ("+LocalDate.now()+").csv");
                fc.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                        "csv files (*.csv)", "*.csv"));

                // launch the dialog box
                File f = fc.showSaveDialog(screenController.getStage());

                if (f != null) {
                    try
                    ( // this should be a familar pattern!
                            PrintWriter pw = new PrintWriter(f)) {

                        // just print what's in the Text Area...
                        
                        for (int i = 0; i < tempArrayList.size(); i++) {
                            
                            patient = tempArrayList.get(i);
                            pw.printf(patient.toString() + "\n");
                        }
                    }
                    catch (Exception ex)
                    {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Error");
                        a.setHeaderText(null);
                        a.setContentText(String.format("File Cannot be created"));
                        a.showAndWait();
                    }
                }*/
    }
    
    
    
    @FXML
    void patientListButtonActionListner(ActionEvent event) {
        status = "none";
        
        moveToPatientListButton.setDisable(true);
        moveToOnSurgeryButton.setDisable(false);
        moveToCompletedButton.setDisable(false);
        moveToOnPosponeButton.setDisable(false);
        navigationalLabel.setText("Patient Report");
        printButton.setDisable(true);
        //setVisibleOnSergeryComponents(false);
        
        dateTableColumn.setCellValueFactory(propertyValueFactoryDate1);
        
        loadTableData(status);
        completedDateHBox.setVisible(false);
        messageButton.setDisable(true);
    }
    
    @FXML
    void onSurgeryButtonActionListner(ActionEvent event) {
        status = "surgery";
        navigationalLabel.setText("On Surgery Report");
        moveToPatientListButton.setDisable(false);
        moveToOnSurgeryButton.setDisable(true);
        moveToCompletedButton.setDisable(false);
        moveToOnPosponeButton.setDisable(false);
        printButton.setDisable(false);
        //setVisibleOnSergeryComponents(true);
        dateTableColumn.setCellValueFactory(propertyValueFactoryDate1);
        
        loadTableData(status);
        completedDateHBox.setVisible(false);
        messageButton.setDisable(false);
    }
    
    @FXML
    void postButtonActionListner(ActionEvent event) {
        status = "postponed";
        navigationalLabel.setText("Postponed");
        moveToPatientListButton.setDisable(false);
        moveToOnSurgeryButton.setDisable(false);
        moveToCompletedButton.setDisable(false);
        moveToOnPosponeButton.setDisable(true);
        printButton.setDisable(true);
        //setVisibleOnSergeryComponents(false);
        
        dateTableColumn.setCellValueFactory(propertyValueFactoryDate1);
        
        loadTableData(status);
        completedDateHBox.setVisible(false);
        messageButton.setDisable(true);
    }
    
    @FXML
    void completedButtonActionListner(ActionEvent event) {
        status = "completed";
        navigationalLabel.setText("Completed Patient Report");
        moveToPatientListButton.setDisable(false);
        moveToOnSurgeryButton.setDisable(false);
        moveToCompletedButton.setDisable(true);
        moveToOnPosponeButton.setDisable(false);
        printButton.setDisable(true);
        //setVisibleOnSergeryComponents(false);
        
        dateTableColumn.setCellValueFactory(propertyValueFactoryDate2);
        
        loadTableData(status);
        completedDateHBox.setVisible(true);
        messageButton.setDisable(true);
    }
    
    private void movePatient(String status){
        
        
        int id;
        try {
            tempPatientTableObservavleList = patientTableView.getSelectionModel().getSelectedItems();
            for (int i = 0; i < tempPatientTableObservavleList.size(); i++) {
                
                id = tempPatientTableObservavleList.get(i).getId();
                
                patient.updatePatientStatus(id, status);
                
                for (int j = 0; j < patientArrayList.size(); j++) {
                    
                    if(patientArrayList.get(j).getId()==id){
                        patientArrayList.get(j).setStatus(status);
                        if(status.equals("surgery"))
                        {
                            LocalDate localDate = LocalDate.now();
                            patientArrayList.get(j).setSurgeryCompletionDate(String.valueOf(localDate));
                            patient.updatePatientCompletionDate(patientArrayList.get(i).getId(), String.valueOf(localDate));
                            
                        }
                        
                        break;
                    }

                }
                
                
            }
             
            loadTableData(this.status);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no item is selected !");
        }
    }
    
    @FXML
    void moveToCompletedButtonActionListner(ActionEvent event) {
        
        movePatient("completed");
        JOptionPane.showMessageDialog(null, "Patients Moved to Completed List !");
    }

    @FXML
    void moveToOnSurgeryButtonActionListner(ActionEvent event) {
        
        movePatient("surgery");
        JOptionPane.showMessageDialog(null, "Patients Moved to Surgery List !");
    }
    
    @FXML
    void moveToPosponeButtonActionListner(ActionEvent event) {
        
        movePatient("postponed");
        if(status.endsWith("surgery")){
            JOptionPane.showMessageDialog(null, "Patients Moved to postponed List !");
        }else{
            JOptionPane.showMessageDialog(null, "Patients Moved to Queue List !");
        }
        
    }

    @FXML
    void moveToPatientListButtonActionListner(ActionEvent event) {
        movePatient("none");
        JOptionPane.showMessageDialog(null, "Patients Moved to Patient List !");
    }
    
    @FXML
    void printButtonActionListner(ActionEvent event) {
        //JOptionPane.showMessageDialog(null, tempPatientArrayList.size());
        CreateWordFile wordFile = new CreateWordFile(tempPatientArrayList);
    }
    
    /*void setVisibleOnSergeryComponents(boolean flag){
        messageButton.setVisible(flag);
        doctorsComboBox.setVisible(flag);
        sortByLabel.setVisible(flag);
    }*/
    
    
    
    @FXML
    void messageButtonActionListner(ActionEvent event) {
        messageConfirmVSplitPane.setVisible(true);
        homePane.setVisible(false);
        
        String doctor = doctorsComboBox.getSelectionModel().getSelectedItem();
        doctorNameLabel1.setText(doctor);
        doctorNameLabel2.setText(doctor);
        nameInMessageLabel3.setText(doctor);
        //
        totalPatientMessageLabel.setText(noOfPatientLabel.getText());
        totalPatientMessageLabel2.setText(noOfPatientLabel.getText());
        totalPatientMessageLabel3.setText(noOfPatientLabel.getText());
        try{
            tempPatientTableObservavleList = patientTableView.getSelectionModel().getSelectedItems();
        
            idInMessageLabel.setText(String.valueOf(tempPatientTableObservavleList.get(0).getId()));
            nameInMessageLabel.setText(tempPatientTableObservavleList.get(0).getName());
            phoneInMessageLabel.setText(tempPatientTableObservavleList.get(0).getPhone1());
        } catch (Exception e){
            
        }
        
        
    }
    
    ///////////////////////////////////////////////////Deliver Messages Screen
    
    
    
    @FXML
    void confirmGroupSurgeryButtonActionListner(ActionEvent event) {
        boolean flag = false;
        boolean flag2 = false;
        if(!surgeryConfirmationDatePicker.getValue().equals(null)){
            if(!timeComboBox.getSelectionModel().isEmpty()){
                if(!OTAComboBox.getSelectionModel().isEmpty()){
                    if(!OTPComboBox.getSelectionModel().isEmpty()){
                        flag = true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "OTP not selected");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "OTA not selected");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Time not selected");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "date not selected");
        }
        if(flag){
            RadioButton ampmRadioBtton = (RadioButton) AMPMToggleGroup.getSelectedToggle();
            String AMorPM = String.valueOf(ampmRadioBtton.getText());
            String time = timeComboBox.getSelectionModel().getSelectedItem();
            
            LocalDate tempDate = surgeryConfirmationDatePicker.getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String date = tempDate.format(formatter);
            
            String doctorName = doctorNameLabel1.getText();
            String otaName = OTAComboBox.getSelectionModel().getSelectedItem();
            String otpName = OTPComboBox.getSelectionModel().getSelectedItem();
            String otaPhone="";
            String otpPhone="";
            String doctorPhone="";

            for (int i = 0; i < otaArrayList.size(); i++) {
                if(otaArrayList.get(i).getName().equals(otaName))
                {
                    otaPhone = otaArrayList.get(i).getPhone();
                    break;
                }
            }

            for (int i = 0; i < otpArrayList.size(); i++) {
                if(otpArrayList.get(i).getName().equals(otpName))
                {
                    otpPhone = otpArrayList.get(i).getPhone();
                    break;
                }
            }

            for (int i = 0; i < doctorArrayList.size(); i++) {
                if(doctorArrayList.get(i).getName().equals(doctorName)){
                    doctorPhone = doctorArrayList.get(i).getPhone();
                    break;
                }

            }


            if(status.equals("surgery")) {
                //sending message to Doctor, OTA, OTP
                String message = "Next Surgery Details...\nDate: " + date + "\nDay: " + weekDaysInEnglish[tempDate.getDayOfWeek().getValue() - 1] + "\nTime: " + time + AMorPM + "\nDoctor: " + doctorName + "\nOTA: " + otaName + "\nOTP:  " + otpName + "\nTotal Patients: " + totalPatientMessageLabel.getText() + " ";
                try {
                    
                    JOptionPane.showMessageDialog(null, otpPhone.replace("-", ""));
                    SMSGatewayEZEE.sendSMS(message, doctorPhone.replace("-", ""));
                    SMSGatewayEZEE.sendSMS(message, otaPhone.replace("-", ""));
                    SMSGatewayEZEE.sendSMS(message, otpPhone.replace("-", ""));
                    SMSGatewayEZEE.sendSMS(message, "03334217818");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Check Your Internet Or Contact Message Provider !");
                    Logger.getLogger(SMSGatewayEZEE.class.getName()).log(Level.SEVERE, null, ex);
                }

                /*LocalTime timeObj = LocalTime.of(Integer.parseInt(time), 0);
                timeObj = timeObj.minusHours(1);*/
                if(time.equals("1")){
                    time="12";
                }
                else{
                    time = String.valueOf(Integer.parseInt(time)-1);
                }
                //sending message to patients
                for (int i = 0; i < patientArrayList.size(); i++) {
                    if(patientArrayList.get(i).getStatus().equals(status) && patientArrayList.get(i).getSurgen().equals(doctorNameLabel2.getText())){
                        try {
                            
                            //SMSGatewayEZEE.sendSMS("آپ مورخہ"+date+"  بروز"+weekDaysInUrdu[tempDate.getDayOfWeek().getValue()-1]+"  دوپہر"+time+"  بجے آپریشن کے لیے دی گئی ہدایات اور مقررہ وقت پر پرانی بلڈنگ تشریف لائیں", patientArrayList.get(i).getPhone1().replace("-", ""));
                            SMSGatewayEZEE.sendSMS("Ap " + date + " " + weekDaysInEnglish[tempDate.getDayOfWeek().getValue()-1]+ " " + time + " bjay operation k liye de gai hidayat aur mukarara waqt par tashreef layein.", patientArrayList.get(i).getPhone1().replace("-", ""));
                            
                            flag2 = true;
                        } catch (
                                Exception ex) {
                            JOptionPane.showMessageDialog(null, "Check Your Internet Or Contact Message Provider !");
                            Logger.getLogger(SMSGatewayEZEE.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
                try {
                    SMSGatewayEZEE.sendSMS(message+"List message", "03334217818");
                } catch (IOException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(flag2){
                JOptionPane.showMessageDialog(null, "Message Sent to Doctor, OTA, OTP & Patients !");
            }
        }
         
    }
    
    @FXML
    void posponeGroupSurgeryButtonActionListner(ActionEvent event) {
        //String message  = "آپ کا آپریشن ناگزیر وجہ سے فی الحال ملتوی کردیا گیا ہے آئندہ تاریخ آپ کو مطلع کردی جائے گی";
        String message  = "Aap ka operation naguzeer waja se filhal mulatvi kar dia gaya ha, Ainda ki tareekh se apko mutlah kar dia jae ga.";
        for (int i = 0; i < patientArrayList.size(); i++) {
            if(patientArrayList.get(i).getStatus().equals(status) && patientArrayList.get(i).getSurgen().equals(doctorNameLabel2.getText())){
                try {
                    SMSGatewayEZEE.sendSMS(message, patientArrayList.get(i).getPhone1().replace("-", ""));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Check Your Internet Or Contact Message Provider !");
                    Logger.getLogger(SMSGatewayEZEE.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        try {
            SMSGatewayEZEE.sendSMS(message, "03334217818");
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //move data to postpone list
        for (int i = 0; i < patientArrayList.size(); i++) {
            if(patientArrayList.get(i).getStatus().equals(status) && patientArrayList.get(i).getSurgen().equals(doctorNameLabel2.getText())){
                patient.updatePatientStatus(patientArrayList.get(i).getId(), "postponed");
                patientArrayList.get(i).setStatus("postponed");
            }

        }
        loadTableData(this.status);
        JOptionPane.showMessageDialog(null, "Messages Sent & Patients Moved to postponed List !");
    }
    
    @FXML
    void completedGroupSurgeryButtonActionListner(ActionEvent event) {
        boolean flag = false;
        if(!timeComboBox2.getSelectionModel().isEmpty()){
            if(!nameInMessageLabel3.getText().equals(""))
            {
                LocalTime timeObj = LocalTime.of(Integer.parseInt(timeComboBox2.getSelectionModel().getSelectedItem()), 0);
                //String message  = "آپ کا آپریشن ناگزیر وجہ سے فی الحال ملتوی کردیا گیا ہے آئندہ تاریخ آپ کو مطلع کردی جائے گی";
                for (int i = 0; i < patientArrayList.size(); i++) {
                    if(patientArrayList.get(i).getStatus().equals(status) && patientArrayList.get(i).getSurgen().equals(doctorNameLabel2.getText())){
                        try {
                            //SMSGatewayEZEE.sendSMS("الحمد اللہ آپ کا آپریشن کامیاب ہوگیا ہے  کل معائنہ کے لیے  "+String.valueOf(timeObj)+"  تشریف لائیں اور دی گئی ہدایات کے مطابق ادویات/قطروں کا استمعال کریں اور فائل ہمراہ لیکر آئیں۔", patientArrayList.get(i).getPhone1().replace("-", ""));
                            //SMSGatewayEZEE.sendSMS("الحمد اللہ آپ کا آپریشن کامیاب ہوگیا ہے  کل معائنہ کے لیے  "+String.valueOf(timeObj)+"  تشریف لائیں اور دی گئی ہدایات کے مطابق ادویات/قطروں کا استمعال کریں اور فائل ہمراہ لیکر آئیں۔", patientArrayList.get(i).getPhone1().replace("-", ""));
                            //SMSGatewayEZEE.sendSMS("Alhumdullilah, Aap ka operation kamiyab ho gaya ha, kal dopahar " + String.valueOf(timeObj)+" bajy muanye k liye  mukarara wakt par File k hamrah lazmi tashreef layen aur hadayat k mutabiq adviyat / Qatroon ka istemal jari rakhain", patientArrayList.get(i).getPhone1().replace("-", ""));
                            /*lab*/SMSGatewayEZEE.sendSMS("Allhumdulliah, aap ka operation kamyab ho gaya hai,5 din bad moainay k liye mukarara waqat par file k humra lazmi tashreef layen aur hadayat k mutabiq adviyat/Qatroon ka istamal jari rakhein.", patientArrayList.get(i).getPhone1().replace("-", ""));
                            timeObj = timeObj.plusMinutes(10);
                            patient.updatePatientStatus(patientArrayList.get(i).getId(), "completed");
                            LocalDate localDate = LocalDate.now();
                            patient.updatePatientCompletionDate(patientArrayList.get(i).getId(), String.valueOf(localDate));
                            patientArrayList.get(i).setStatus("completed");
                            patientArrayList.get(i).setSurgeryCompletionDate(String.valueOf(localDate));
                            flag = true;
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Check Your Internet Or Contact Message Provider !");
                            Logger.getLogger(SMSGatewayEZEE.class.getName()).log(Level.SEVERE, null, ex);
                            flag = false;
                        }
                    }

                }
                try {
                    //SMSGatewayEZEE.sendSMS("الحمد اللہ آپ کا آپریشن کامیاب ہوگیا ہے  کل معائنہ کے لیے  "+String.valueOf(timeObj)+"  تشریف لائیں اور دی گئی ہدایات کے مطابق ادویات/قطروں کا استمعال کریں اور فائل ہمراہ لیکر آئیں۔" + "List message", "03334217818");
                   //SMSGatewayEZEE.sendSMS("Alhumdullilah, Aap ka operation kamiyab ho gaya ha, kal dopahar " + String.valueOf(timeObj)+" bajy muanye k liye  mukarara wakt par File k hamrah lazmi tashreef layen aur hadayat k mutabiq adviyat / Qatroon ka istemal jari rakhain" + "List message", "03334217818");
                   /*lab*/SMSGatewayEZEE.sendSMS("Allhumdulliah, aap ka operation kamyab ho gaya hai,5 din bad moainay k liye mukarara waqat par file k humra lazmi tashreef layen aur hadayat k mutabiq adviyat/Qatroon ka istamal jari rakhein.", "03334217818");
                } catch (IOException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }
                            
                

                //move data to postpone list
                /*for (int i = 0; i < patientArrayList.size(); i++) {
                    if(patientArrayList.get(i).getStatus().equals(status) && patientArrayList.get(i).getSurgen().equals(nameInMessageLabel3.getText())){
                        patient.updatePatientStatus(patientArrayList.get(i).getId(), "completed");
                        patient.updatePatientCompletionDate(patientArrayList.get(i).getId(), String.valueOf(localDate));
                        patientArrayList.get(i).setStatus("completed");
                    }

                }*/
                if(flag){
                    loadTableData(this.status);
                    JOptionPane.showMessageDialog(null, "Message Sent & Patients Moved to Completed List !");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Select Doctor from Pre Screen !");
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Select Doctor Available time!");
        }
        
    }
    @FXML
    void posponeIndvidualSurgeryButtonActionListner(ActionEvent event) {
        //String message = "آپ کا بلڈ پریشر/بلڈ شوگر کنٹرول نہ ہونے کی وجہ سے آپ کا آپریشن ملتوی کردیا گیا ہے دوبارہ تاریخ کے لیے مکمل فٹنس کے بعد رابطہ کریں۔";
        String message = "Aap ka blood pressure / blood sugar control na honay ki wajah se aap ka operation multavi kar dia gaya ha, dobara tareekh k liye mukamal sehatyabi k bad rabta karain.";
        int id;
        try {
            tempPatientTableObservavleList = patientTableView.getSelectionModel().getSelectedItems();
            for (int i = 0; i < tempPatientTableObservavleList.size(); i++) {
                
                id = tempPatientTableObservavleList.get(i).getId();
                
                patient.updatePatientStatus(id, status);
                
                for (int j = 0; j < patientArrayList.size(); j++) {
                    
                    if(patientArrayList.get(j).getId()==id){
                        //patientArrayList.get(j).setStatus(status);
                         try {
                            SMSGatewayEZEE.sendSMS(message, patientArrayList.get(j).getPhone1().replace("-", ""));
                            JOptionPane.showMessageDialog(null, "Message sent & Patient moved to Postpon/Queue List !");
                            SMSGatewayEZEE.sendSMS(message, "03334217818");
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Check Your Internet Or Contact Message Provider !");
                            Logger.getLogger(SMSGatewayEZEE.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        patient.updatePatientStatus(patientArrayList.get(j).getId(), "postponed");
                        patientArrayList.get(j).setStatus("postponed");
                        break;
                    }

                }
                
                
            }
            
                            
             
            loadTableData(this.status);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no patient is selected from table!");
        }
        
    }
    @FXML
    void cancelIndvidualSurgeryButtonActionListner(ActionEvent event) {
        
        movePatient("none");
        JOptionPane.showMessageDialog(null, "Patients Moved to Patient/Cancel List !");
    }
        
        
    
    
}
