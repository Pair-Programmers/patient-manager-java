/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanager;

import Interface.Doctor;
import Interface.OTA;
import Interface.OTP;
import java.awt.Color;
import java.awt.Paint;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mianh
 */
public class DoctorOTAOTPController implements Initializable {

    @FXML
    private Pane doctorPane;

    @FXML
    private TextField nameAddDoctorTextField;

    @FXML
    private TextField phoneAddDoctorTextField;

    

    @FXML
    private TextField nameUpdateDoctorTextField;

    @FXML
    private TextField phoneUpdateDoctorTextField;

    

    @FXML
    private Pane OTAPAne;

    @FXML
    private TextField nameAddOTATextField;

    @FXML
    private TextField phoneAddOTATextField;

    

    @FXML
    private TextField nameUpdateOTATextField;

    @FXML
    private TextField phoneUpdateOTATextField;

    

    @FXML
    private Pane OTPPane;

    @FXML
    private TextField nameAddOTPTextField;

    @FXML
    private TextField phoneAddOTPTextField;

    @FXML
    private ComboBox<String> doctorsUpdateComboBox;
    
    @FXML
    private ComboBox<String> doctorsDeleteComboBox;
    
    @FXML
    private ComboBox<String> OTADeleteComboBox;
    
    @FXML
    private ComboBox<String> OTAUpdateComboBox;
    
    @FXML
    private ComboBox<String> OTPUpdateComboBox;

    @FXML
    private ComboBox<String> OTPDeleteComboBox;
  
    @FXML
    private TextField nameUpdateOTPTextField;

    @FXML
    private TextField phoneUpdateOTPTextField;

    
    
    @FXML
    private Label errorAddDoctorLabel;
    
    @FXML
    private Label errorUpdateDoctorLabel;
    
    @FXML
    private Label messageAddDoctorLabel;
    
    @FXML
    private Label messageUpdateDoctorLabel;
    
    @FXML
    private Label messageDeleteDoctorLabel;
    
    @FXML
    private Label errorAddOTALabel;

    @FXML
    private Label messageAddOTALabel;
    
    @FXML
    private Label errorUpdateOTALabel;

    @FXML
    private Label messageUpdateOTALabel;
    
    @FXML
    private Label messageDeleteOTALabel;
    
    @FXML
    private Label errorAddOTPLabel;

    @FXML
    private Label messageAddOTPLabel;
    
    @FXML
    private Label errorUpdateOTPLabel;

    @FXML
    private Label messageUpdateOTPLabel;
    
    @FXML
    private Label messageDeleteOTPLabel;
    
    ObservableList doctorsComboBoxObservavleList;
    ObservableList otaComboBoxObservavleList;
    ObservableList otpComboBoxObservavleList;
    
    Doctor doctor;
    OTA ota;
    OTP otp;
    
    ArrayList<Doctor> doctorArrayList;
    ArrayList<OTA> otaArrayList;
    ArrayList<OTP> otpArrayList;
    
    String preNameDoctor;
    String prePhoneDoctor;
    
    String preNameOTA;
    String prePhoneOTA;
    
    String preNameOTP;
    String prePhoneOTP;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        clearAllMessageLabels();
        
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
        
        for (int i = 0; i < doctorArrayList.size(); i++) {
            doctorsComboBoxObservavleList.add(doctorArrayList.get(i).getName());
        }
        for (int i = 0; i < otaArrayList.size(); i++) {
            otaComboBoxObservavleList.add(otaArrayList.get(i).getName());
        }
        for (int i = 0; i < otpArrayList.size(); i++) {
            otpComboBoxObservavleList.add(otpArrayList.get(i).getName());
        }
        
        doctorsUpdateComboBox.setItems(doctorsComboBoxObservavleList);
        doctorsDeleteComboBox.setItems(doctorsComboBoxObservavleList);
        
        OTADeleteComboBox.setItems(otaComboBoxObservavleList);
        OTAUpdateComboBox.setItems(otaComboBoxObservavleList);
        
        OTPDeleteComboBox.setItems(otpComboBoxObservavleList);
        OTPUpdateComboBox.setItems(otpComboBoxObservavleList);
    }    
    
    @FXML
    void OTAActionListner(ActionEvent event) {
        OTAPAne.setVisible(true);
        OTPPane.setVisible(false);
        doctorPane.setVisible(false);
        clearAllMessageLabels();
    }

    @FXML
    void OTPActionListner(ActionEvent event) {
        OTAPAne.setVisible(false);
        OTPPane.setVisible(true);
        doctorPane.setVisible(false);
        clearAllMessageLabels();
    }

    @FXML
    void addDoctorActionListner(ActionEvent event) {
        doctorsUpdateComboBox.getSelectionModel().clearSelection();
        doctorsDeleteComboBox.getSelectionModel().clearSelection();
        nameUpdateDoctorTextField.setText("");
        phoneUpdateDoctorTextField.setText("");
        
        if(!nameAddDoctorTextField.getText().isEmpty()){
            if(!phoneAddDoctorTextField.getText().isEmpty()){
                if(phoneAddDoctorTextField.getText().length()==12){
                    if(!doctor.isNameExist(nameAddDoctorTextField.getText())){
                        if(!doctor.isPhoneNumberExist(phoneAddDoctorTextField.getText())){
                            doctor.addDoctor(new Doctor(0, nameAddDoctorTextField.getText(), phoneAddDoctorTextField.getText()));
                            messageAddDoctorLabel.setText("Doctor Saved !");
                            errorAddDoctorLabel.setText("");

                            doctorsComboBoxObservavleList.add(nameAddDoctorTextField.getText());
                            doctorsUpdateComboBox.setItems(doctorsComboBoxObservavleList);
                            doctorArrayList.add(new Doctor(0, nameAddDoctorTextField.getText(), phoneAddDoctorTextField.getText()));
                            
                            nameAddDoctorTextField.setText("");
                            phoneAddDoctorTextField.setText("");
                        } 
                        else{
                            errorAddDoctorLabel.setText("Phone already exist !");
                            messageAddDoctorLabel.setText("");
                        }
                    }else{
                        errorAddDoctorLabel.setText("Name already exist !");
                        messageAddDoctorLabel.setText("");
                    }
                    
                    
                }
                else{
                    errorAddDoctorLabel.setText("Phone digits are incorect !");
                    messageAddDoctorLabel.setText("");
                }
            }
            else{
                    errorAddDoctorLabel.setText("Phone phone is empty !");
                    messageAddDoctorLabel.setText("");
                }
        }
        else{
                    errorAddDoctorLabel.setText("Name is empty !");
                    messageAddDoctorLabel.setText("");
        }
        
    }

    @FXML
    void addOTAActionListner(ActionEvent event) {
        if(!nameAddOTATextField.getText().isEmpty()){
            if(!phoneAddOTATextField.getText().isEmpty()){
                if(phoneAddOTATextField.getText().length()==12){
                    if(!ota.isNameExist(nameAddOTATextField.getText())){
                        if(!ota.isPhoneNumberExist(phoneAddOTATextField.getText())){
                            ota.addOTA(new OTA(0, nameAddOTATextField.getText(), phoneAddOTATextField.getText()));
                            messageAddOTALabel.setText("OTA Saved !");
                            errorAddOTALabel.setText("");

                            otaComboBoxObservavleList.add(nameAddOTATextField.getText());
                            OTAUpdateComboBox.setItems(otaComboBoxObservavleList);
                            otaArrayList.add(new OTA(0, nameAddOTATextField.getText(), phoneAddOTATextField.getText()));
                            
                            nameAddOTATextField.setText("");
                            phoneAddOTATextField.setText("");
                        } 
                        else{
                            errorAddOTALabel.setText("Phone already exist !");
                            messageAddOTALabel.setText("");
                        }
                    }
                    else{
                        errorAddOTALabel.setText("Name already exist !");
                        messageAddOTALabel.setText("");
                    }
                    
                    
                }
                else{
                    errorAddOTALabel.setText("Phone digits are incorect !");
                    messageAddOTALabel.setText("");
                }
            }
            else{
                    errorAddOTALabel.setText("Phone phone is empty !");
                    messageAddOTALabel.setText("");
                }
        }
        else{
                    errorAddOTALabel.setText("Name is empty !");
                    messageAddOTALabel.setText("");
        }
    }

    @FXML
    void addOTPActionListner(ActionEvent event) {
        if(!nameAddOTPTextField.getText().isEmpty()){
            if(!phoneAddOTPTextField.getText().isEmpty()){
                if(phoneAddOTPTextField.getText().length()==12){
                    if(!otp.isNameExist(nameAddOTPTextField.getText())){
                        if(!otp.isPhoneNumberExist(phoneAddOTPTextField.getText())){
                            otp.addOTP(new OTP(0, nameAddOTPTextField.getText(), phoneAddOTPTextField.getText()));
                            messageAddOTPLabel.setText("OTP Saved !");
                            errorAddOTPLabel.setText("");

                            otpComboBoxObservavleList.add(nameAddOTPTextField.getText());
                            OTPUpdateComboBox.setItems(otpComboBoxObservavleList);
                            otpArrayList.add(new OTP(0, nameAddOTPTextField.getText(), phoneAddOTPTextField.getText()));
                            
                            nameAddOTPTextField.setText("");
                            phoneAddOTPTextField.setText("");
                        } 
                        else{
                            errorAddOTPLabel.setText("Phone already exist !");
                            messageAddOTPLabel.setText("");
                        }
                    }
                    else {
                        errorAddOTPLabel.setText("Name already exist !");
                        messageAddOTPLabel.setText("");
                    }
                    
                    
                    
                }
                else{
                    errorAddOTPLabel.setText("Phone digits are incorect !");
                    messageAddOTPLabel.setText("");
                }
            }
            else{
                    errorAddOTPLabel.setText("Phone phone is empty !");
                    messageAddOTPLabel.setText("");
                }
        }
        else{
                errorAddOTPLabel.setText("Name is empty !");
                messageAddOTPLabel.setText("");
        }
    }

    @FXML
    void deleteDoctorActionListner(ActionEvent event) {
        if(!doctorsDeleteComboBox.getSelectionModel().isEmpty())
        {
            String name = doctorsDeleteComboBox.getSelectionModel().getSelectedItem();
            for (int i = 0; i < doctorArrayList.size(); i++) {
                if(doctorArrayList.get(i).getName().equals(name)){
                    //doctor.setId(doctorArrayList.get(i).getId());
                    doctor.deleteDoctor(new Doctor(doctorArrayList.get(i).getId(), doctorArrayList.get(i).getName(), doctorArrayList.get(i).getPhone()));
                    
                    messageDeleteDoctorLabel.setText("Doctor Delete !");
                    doctorArrayList.remove(i);
                    refereshDoctorComboBoxes();
                    
                }
            }
        }
    }
    
    void refereshDoctorComboBoxes(){
        doctorsComboBoxObservavleList.clear();
        for (int i = 0; i < doctorArrayList.size(); i++) {
            doctorsComboBoxObservavleList.add(doctorArrayList.get(i).getName());
        }
        
        doctorsUpdateComboBox.setItems(doctorsComboBoxObservavleList);
        doctorsDeleteComboBox.setItems(doctorsComboBoxObservavleList);
    }

    @FXML
    void deleteOTAActionListner(ActionEvent event) {
        if(!OTADeleteComboBox.getSelectionModel().isEmpty())
        {
            String name = OTADeleteComboBox.getSelectionModel().getSelectedItem();
            for (int i = 0; i < otaArrayList.size(); i++) {
                if(otaArrayList.get(i).getName().equals(name)){
                    //doctor.setId(doctorArrayList.get(i).getId());
                    ota.deleteOTA(new OTA(otaArrayList.get(i).getId(), otaArrayList.get(i).getName(), otaArrayList.get(i).getPhone()));
                    messageDeleteOTALabel.setText("OTA Delete !");
                    otaArrayList.remove(i);
                    refereshOTAComboBoxes();
                    
                }
            }
        }
    }

    void refereshOTAComboBoxes(){
        otaComboBoxObservavleList.clear();
        for (int i = 0; i < otaArrayList.size(); i++) {
            otaComboBoxObservavleList.add(otaArrayList.get(i).getName());
        }
        
        OTAUpdateComboBox.setItems(otaComboBoxObservavleList);
        OTADeleteComboBox.setItems(otaComboBoxObservavleList);
    }
    
    @FXML
    void deleteOTPActionListner(ActionEvent event) {
        if(!OTPDeleteComboBox.getSelectionModel().isEmpty())
        {
            String name = OTPDeleteComboBox.getSelectionModel().getSelectedItem();
            for (int i = 0; i < otpArrayList.size(); i++) {
                if(otpArrayList.get(i).getName().equals(name)){
                    otp.setId(otpArrayList.get(i).getId());
                    ota.deleteOTA(new OTA(otpArrayList.get(i).getId(), otpArrayList.get(i).getName(), otpArrayList.get(i).getPhone()));
                    messageDeleteOTPLabel.setText("OTP Delete !");
                    otpArrayList.remove(i);
                    refereshOTPComboBoxes();
                }
            }
        }
    }
    
    void refereshOTPComboBoxes(){
        otpComboBoxObservavleList.clear();
        for (int i = 0; i < otpArrayList.size(); i++) {
            otpComboBoxObservavleList.add(otpArrayList.get(i).getName());
        }
        
        OTPUpdateComboBox.setItems(otpComboBoxObservavleList);
        OTPDeleteComboBox.setItems(otpComboBoxObservavleList);
    }

    @FXML
    void doctorActionListner(ActionEvent event) {
        OTAPAne.setVisible(false);
        OTPPane.setVisible(false);
        doctorPane.setVisible(true);
        clearAllMessageLabels();
    }

    @FXML
    void updateDoctorActionListner(ActionEvent event) {
        if(!doctorsUpdateComboBox.getSelectionModel().isEmpty())
        {
            if(!nameUpdateDoctorTextField.getText().equals("")){
                if(!phoneUpdateDoctorTextField.getText().isEmpty()){
                    if(phoneUpdateDoctorTextField.getText().length()==12){
                        //if(!phoneUpdateDoctorTextField.getText().equals(prePhoneDoctor))
                        //{
                            //if(!doctor.isPhoneNumberExist(phoneUpdateDoctorTextField.getText())){
                                doctor.updateDoctor(new Doctor(doctor.getId(), nameUpdateDoctorTextField.getText(), phoneUpdateDoctorTextField.getText()));
                                messageUpdateDoctorLabel.setText("Doctor Updated !");
                                errorUpdateDoctorLabel.setText("");
                                //System.out.println("yyyy");
                                nameUpdateDoctorTextField.setText("");
                                phoneUpdateDoctorTextField.setText("");
                                doctorsUpdateComboBox.getSelectionModel().clearSelection();
                                
                                /*for (int i = 0; i < doctorArrayList.size(); i++) {
                                    if(doctorArrayList.get(i).getId()== doctor.getId()){
                                        
                                    }
                                }
                                
                                doctorsComboBoxObservavleList.clear();
                                for (int i = 0; i < doctorArrayList.size(); i++) {
                                    doctorsComboBoxObservavleList.add(doctorArrayList.get(i).getName());
                                }
                            } 
                            else{
                                errorUpdateDoctorLabel.setText("Phone already exist !");
                                messageUpdateDoctorLabel.setText("");
                            }
                        }
                        else{
                            errorUpdateDoctorLabel.setText("");
                            messageUpdateDoctorLabel.setText("Doctor Updated !");
                        }*/

                    }
                    else{
                        errorUpdateDoctorLabel.setText("Phone digits are incorect !");
                        messageUpdateDoctorLabel.setText("");
                    }
                }
                else{
                        errorUpdateDoctorLabel.setText("Phone phone is empty !");
                        messageUpdateDoctorLabel.setText("");
                        }
                }
            else{
                        errorUpdateDoctorLabel.setText("Name is empty !");
                        messageUpdateDoctorLabel.setText("");
            }
        }
        else{
            errorUpdateDoctorLabel.setText("select doctor to update !!");
            messageUpdateDoctorLabel.setText("");
        }
        
    }

    @FXML
    void updateOTAActionListner(ActionEvent event) {
        if(!OTAUpdateComboBox.getSelectionModel().isEmpty())
        {
            if(!nameUpdateOTATextField.getText().equals("")){
                if(!phoneUpdateOTATextField.getText().isEmpty()){
                    if(phoneUpdateOTATextField.getText().length()==12){
                        //if(!phoneUpdateDoctorTextField.getText().equals(prePhoneOTA)){
                            //if(ota.isPhoneNumberExist(phoneAddOTATextField.getText())){
                                ota.updateOTA(new OTA(ota.getId(), nameUpdateOTATextField.getText(), phoneUpdateOTATextField.getText()));
                                messageUpdateOTALabel.setText("OTA Updated !");
                                errorUpdateOTALabel.setText("");
                                
                                nameUpdateOTATextField.setText("");
                                phoneUpdateOTATextField.setText("");
                                OTAUpdateComboBox.getSelectionModel().clearSelection();
                            /*} 
                            else{
                                errorUpdateOTALabel.setText("Phone already exist !");
                                messageUpdateOTALabel.setText("");
                            }
                        }
                        else{
                            errorUpdateDoctorLabel.setText("");
                            messageUpdateDoctorLabel.setText("OTA Updated !");
                        }*/
                        

                    }
                    else{
                        errorUpdateOTALabel.setText("Phone digits are incorect !");
                        messageUpdateOTALabel.setText("");
                    }
                }
                else{
                    errorUpdateOTALabel.setText("Phone phone is empty !");
                    messageUpdateOTALabel.setText("");
                }
            }
            else{
                        errorUpdateOTALabel.setText("Name is empty !");
                        messageUpdateOTALabel.setText("");
            }
        }
        else{
            errorUpdateOTALabel.setText("select ota to update !!");
            messageUpdateOTALabel.setText("");
        }
    }

    @FXML
    void updateOTPActionListner(ActionEvent event) {
         if(!OTPUpdateComboBox.getSelectionModel().isEmpty())
        {
            if(!nameUpdateOTPTextField.getText().isEmpty()){
            if(!phoneUpdateOTPTextField.getText().isEmpty()){
                if(phoneUpdateOTPTextField.getText().length()==12){
                    //if(!phoneUpdateDoctorTextField.getText().equals(prePhoneOTP)){
                        //if(otp.isPhoneNumberExist(phoneUpdateOTPTextField.getText())){
                            otp.updateOTP(new OTP(ota.getId(), nameUpdateOTPTextField.getText(), phoneUpdateOTPTextField.getText()));
                            messageUpdateOTPLabel.setText("OTP Updated !");
                            errorUpdateOTPLabel.setText("");
                            
                            nameUpdateOTATextField.setText("");
                            phoneUpdateOTATextField.setText("");
                            OTAUpdateComboBox.getSelectionModel().clearSelection();
                       /* } 
                        else{
                            errorUpdateOTPLabel.setText("Phone already exist !");
                            messageUpdateOTPLabel.setText("");
                        }
                    }
                    else{
                        errorUpdateDoctorLabel.setText("");
                            messageUpdateDoctorLabel.setText("OTP Updated !");
                    }*/
                    
                    
                }
                else{
                    errorUpdateOTPLabel.setText("Phone digits are incorect !");
                    messageUpdateOTPLabel.setText("");
                }
            }
            else{
                    errorUpdateOTPLabel.setText("Phone phone is empty !");
                    messageUpdateOTPLabel.setText("");
                    }
            }
            else{
                        errorUpdateOTPLabel.setText("Name is empty !");
                        messageUpdateOTPLabel.setText("");
            }
        }
        else{
            errorUpdateOTPLabel.setText("select otp to update !!");
            messageUpdateOTPLabel.setText("");
        }
    }
    
    @FXML
    void doctorsDeleteDoctorComboBoxActionListner(ActionEvent event) {
        //messageDeleteDoctorLabel.setText("");
    }

    @FXML
    void doctorsUpdateDoctorComboBoxActionListner(ActionEvent event) {
        messageUpdateDoctorLabel.setText("");
        errorUpdateDoctorLabel.setText("");
        String name = doctorsUpdateComboBox.getSelectionModel().getSelectedItem();
        for (int i = 0; i < doctorArrayList.size(); i++) {
            if(doctorArrayList.get(i).getName().equals(name)){
                nameUpdateDoctorTextField.setText(name);
                phoneUpdateDoctorTextField.setText(doctorArrayList.get(i).getPhone());
                doctor.setId(doctorArrayList.get(i).getId());
                preNameDoctor = name;
                prePhoneDoctor = doctorArrayList.get(i).getPhone();
            }
        }
    }
    
    @FXML
    void OTADeleteComboBoxActionListner(ActionEvent event) {
        
    }
    
    

    @FXML
    void OTAUpdateComboBoxActionListner(ActionEvent event) {
        messageUpdateOTALabel.setText("");
        errorUpdateOTALabel.setText("");
        String name = OTAUpdateComboBox.getSelectionModel().getSelectedItem();
        //System.out.println("a");
        for (int i = 0; i < otaArrayList.size(); i++) {
            if(otaArrayList.get(i).getName().equals(name)){
                //System.out.println("2");
                nameUpdateOTATextField.setText(name);
                phoneUpdateOTATextField.setText(otaArrayList.get(i).getPhone());
                ota.setId(otaArrayList.get(i).getId());
                
                preNameOTA = name;
                //System.out.println("3");
                prePhoneOTA = otaArrayList.get(i).getPhone();
                //System.out.println("4");
            }
        }
    }
    
    @FXML
    void OTPUpdateComboBoxActionListner(ActionEvent event) {
        messageUpdateOTPLabel.setText("");
        errorUpdateOTPLabel.setText("");
        String name = OTPUpdateComboBox.getSelectionModel().getSelectedItem();
        for (int i = 0; i < otpArrayList.size(); i++) {
            if(otpArrayList.get(i).getName().equals(name)){
                nameUpdateOTPTextField.setText(name);
                phoneUpdateOTPTextField.setText(otpArrayList.get(i).getPhone());
                ota.setId(otpArrayList.get(i).getId());
                
                preNameOTP = name;
                prePhoneOTP = doctorArrayList.get(i).getPhone();
            }
        }
    }
    
    void clearAllMessageLabels(){
        errorAddDoctorLabel.setText("");
        errorUpdateDoctorLabel.setText("");
        messageAddDoctorLabel.setText("");
        messageUpdateDoctorLabel.setText("");
        messageDeleteDoctorLabel.setText("");
        errorAddOTALabel.setText("");
        messageAddOTALabel.setText("");
        errorUpdateOTALabel.setText("");
        messageUpdateOTALabel.setText("");
        messageDeleteOTALabel.setText("");
        errorAddOTPLabel.setText("");
        messageAddOTPLabel.setText("");
        errorUpdateOTPLabel.setText("");
        messageUpdateOTPLabel.setText("");
        messageDeleteOTPLabel.setText("");
        
        if(!doctorsUpdateComboBox.getSelectionModel().isEmpty()){
            doctorsUpdateComboBox.getSelectionModel().clearSelection();
        }
        if(!doctorsDeleteComboBox.getSelectionModel().isEmpty()){
            doctorsDeleteComboBox.getSelectionModel().clearSelection();
        }
        if(!OTAUpdateComboBox.getSelectionModel().isEmpty()){
            OTAUpdateComboBox.getSelectionModel().clearSelection();
        }
        if(!OTADeleteComboBox.getSelectionModel().isEmpty()){
            OTADeleteComboBox.getSelectionModel().clearSelection();
        }
        if(!OTPUpdateComboBox.getSelectionModel().isEmpty()){
            OTPUpdateComboBox.getSelectionModel().clearSelection();
        }
        if(!doctorsUpdateComboBox.getSelectionModel().isEmpty()){
            doctorsUpdateComboBox.getSelectionModel().clearSelection();
        }
        
        
        
        
        
        
        nameAddDoctorTextField.setText("");
        nameAddOTATextField.setText("");
        nameAddOTPTextField.setText("");
        nameUpdateDoctorTextField.setText("");
        nameUpdateOTATextField.setText("");
        nameUpdateOTPTextField.setText("");
        
        phoneAddDoctorTextField.setText("");
        phoneAddOTATextField.setText("");
        phoneAddOTPTextField.setText("");
        phoneUpdateDoctorTextField.setText("");
        phoneUpdateOTATextField.setText("");
        phoneUpdateOTPTextField.setText("");
                
        
    }
    @FXML
    void phoneAddDoctorOnKeyReleased(){
        if(phoneAddDoctorTextField.getText().length()>1){
            if(phoneAddDoctorTextField.getText().substring(0, 2).equals("04")){
                if(phoneAddDoctorTextField.getText().length() == 3){
                    phoneAddDoctorTextField.setText(phoneAddDoctorTextField.getText() + "-");
                    phoneAddDoctorTextField.positionCaret(phoneAddDoctorTextField.getText().length());
                }
            } else if(phoneAddDoctorTextField.getText().substring(0, 2).equals("03")){
               if(phoneAddDoctorTextField.getText().length() == 4){
                    phoneAddDoctorTextField.setText(phoneAddDoctorTextField.getText() + "-");
                    phoneAddDoctorTextField.positionCaret(phoneAddDoctorTextField.getText().length());
                }
            } else {

            }
            if(phoneAddDoctorTextField.getText().length()>12){
               String s = phoneAddDoctorTextField.getText().substring(0, 12);
                    phoneAddDoctorTextField.setText(s);
                    phoneAddDoctorTextField.positionCaret(phoneAddDoctorTextField.getText().length());
            }
        }
    }
    
    @FXML
    void phoneAddOTAOnKeyReleased(){
        if(phoneAddOTATextField.getText().length()>1){
            if(phoneAddOTATextField.getText().substring(0, 2).equals("04")){
                if(phoneAddOTATextField.getText().length() == 3){
                    phoneAddOTATextField.setText(phoneAddOTATextField.getText() + "-");
                    phoneAddOTATextField.positionCaret(phoneAddOTATextField.getText().length());
                }
            } else if(phoneAddOTATextField.getText().substring(0, 2).equals("03")){
               if(phoneAddOTATextField.getText().length() == 4){
                    phoneAddOTATextField.setText(phoneAddOTATextField.getText() + "-");
                    phoneAddOTATextField.positionCaret(phoneAddOTATextField.getText().length());
                }
            } else {

            }
            if(phoneAddOTATextField.getText().length()>12){
               String s = phoneAddOTATextField.getText().substring(0, 12);
                    phoneAddOTATextField.setText(s);
                    phoneAddOTATextField.positionCaret(phoneAddOTATextField.getText().length());
            }
        }
    }
    
    @FXML
    void phoneAddOTPOnKeyReleased(){
        if(phoneAddOTPTextField.getText().length()>1){
            if(phoneAddOTPTextField.getText().substring(0, 2).equals("04")){
                if(phoneAddOTPTextField.getText().length() == 3){
                    phoneAddOTPTextField.setText(phoneAddOTPTextField.getText() + "-");
                    phoneAddOTPTextField.positionCaret(phoneAddOTPTextField.getText().length());
                }
            } else if(phoneAddOTPTextField.getText().substring(0, 2).equals("03")){
               if(phoneAddOTPTextField.getText().length() == 4){
                    phoneAddOTPTextField.setText(phoneAddOTPTextField.getText() + "-");
                    phoneAddOTPTextField.positionCaret(phoneAddOTPTextField.getText().length());
                }
            } else {

            }
            if(phoneAddOTPTextField.getText().length()>12){
               String s = phoneAddOTPTextField.getText().substring(0, 12);
                    phoneAddOTPTextField.setText(s);
                    phoneAddOTPTextField.positionCaret(phoneAddOTPTextField.getText().length());
            }
        }
    }
    
    @FXML
    void phoneUpdateDoctorOnKeyReleased(){
        if(phoneUpdateDoctorTextField.getText().length()>1){
            if(phoneUpdateDoctorTextField.getText().substring(0, 2).equals("04")){
                if(phoneUpdateDoctorTextField.getText().length() == 3){
                    phoneUpdateDoctorTextField.setText(phoneUpdateDoctorTextField.getText() + "-");
                    phoneUpdateDoctorTextField.positionCaret(phoneUpdateDoctorTextField.getText().length());
                }
            } else if(phoneUpdateDoctorTextField.getText().substring(0, 2).equals("03")){
               if(phoneUpdateDoctorTextField.getText().length() == 4){
                    phoneUpdateDoctorTextField.setText(phoneUpdateDoctorTextField.getText() + "-");
                    phoneUpdateDoctorTextField.positionCaret(phoneUpdateDoctorTextField.getText().length());
                }
            } else {

            }
            if(phoneUpdateDoctorTextField.getText().length()>12){
               String s = phoneUpdateDoctorTextField.getText().substring(0, 12);
                    phoneUpdateDoctorTextField.setText(s);
                    phoneUpdateDoctorTextField.positionCaret(phoneUpdateDoctorTextField.getText().length());
            }
        }
    }
    
    @FXML
    void phoneUpdateOTAOnKeyReleased(){
        if(phoneUpdateOTATextField.getText().length()>1){
            if(phoneUpdateOTATextField.getText().substring(0, 2).equals("04")){
                if(phoneUpdateOTATextField.getText().length() == 3){
                    phoneUpdateOTATextField.setText(phoneUpdateOTATextField.getText() + "-");
                    phoneUpdateOTATextField.positionCaret(phoneUpdateOTATextField.getText().length());
                }
            } else if(phoneUpdateOTATextField.getText().substring(0, 2).equals("03")){
               if(phoneUpdateOTATextField.getText().length() == 4){
                    phoneUpdateOTATextField.setText(phoneUpdateOTATextField.getText() + "-");
                    phoneUpdateOTATextField.positionCaret(phoneUpdateOTATextField.getText().length());
                }
            } else {

            }
            if(phoneUpdateOTATextField.getText().length()>12){
               String s = phoneUpdateOTATextField.getText().substring(0, 12);
                    phoneUpdateOTATextField.setText(s);
                    phoneUpdateOTATextField.positionCaret(phoneUpdateOTATextField.getText().length());
            }
        }
    }
    
    @FXML
    void phoneUpdateOTPOnKeyReleased(){
        if(phoneUpdateOTPTextField.getText().length()>1){
            if(phoneUpdateOTPTextField.getText().substring(0, 2).equals("04")){
                if(phoneUpdateOTPTextField.getText().length() == 3){
                    phoneUpdateOTPTextField.setText(phoneUpdateOTPTextField.getText() + "-");
                    phoneUpdateOTPTextField.positionCaret(phoneUpdateOTPTextField.getText().length());
                }
            } else if(phoneUpdateOTPTextField.getText().substring(0, 2).equals("03")){
               if(phoneUpdateOTPTextField.getText().length() == 4){
                    phoneUpdateOTPTextField.setText(phoneUpdateOTPTextField.getText() + "-");
                    phoneUpdateOTPTextField.positionCaret(phoneUpdateOTPTextField.getText().length());
                }
            } else {

            }
            if(phoneUpdateOTPTextField.getText().length()>12){
               String s = phoneUpdateOTPTextField.getText().substring(0, 12);
                    phoneUpdateOTPTextField.setText(s);
                    phoneUpdateOTPTextField.positionCaret(phoneUpdateOTPTextField.getText().length());
            }
        }
    }
    
}
