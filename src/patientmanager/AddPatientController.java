/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanager;


import Interface.Doctor;
import Interface.Injection;
import Interface.Patient;
import Interface.PrinterTest;
import SMSGateway.SMSGatewayEZEE;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author 15009065376
 */
public class AddPatientController implements Initializable, ActionListener {

    /**
     * Initializes the controller class.
     *
     */
    
    private PrinterTest printerTest;
    
    //private int crrentPatientID;
    
    private String patth;
    
    Patient patient;
    
    @FXML
    private Pane patientPane;

    @FXML
    private Label idLabel;
    
    @FXML
    private Label injectionPriceLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField cnicTextField;
    
    @FXML
    private TextField newCompanyTextField;

    @FXML
    private TextField regNoTextField;

    @FXML
    private TextField phone1TextField;

    @FXML
    private TextField raseed1TextField;

    @FXML
    private TextField fatherHusbandNameTextField;

    String user;

    @FXML
    private TextField phone2TextField;

    @FXML
    private TextField raseed2TextField;


    @FXML
    private TextField fileNumberTextField;

    @FXML
    private TextField rowIO2TextField;

    @FXML
    private TextField discountTextField;

    @FXML
    private TextField companyTextField;

    @FXML
    private TextField coTextField;

    @FXML
    private RadioButton rRadioButton;

    @FXML
    private ToggleGroup rightLeftTogglegroup;

    @FXML
    private RadioButton lRadioButton;

    @FXML
    private ImageView imageView;

    @FXML
    private TextField ageTextField;

    @FXML
    private Label messageLabel;

    @FXML
    private Label errorMessagelabel;

    @FXML
    private Pane printerPane;

    @FXML
    private TextField noOfPrintsTextField;

    @FXML
    private Label printMessageLabel;
    
    FileInputStream fis;
    Image image;
    
    ArrayList<Patient> patientArrayList;
    ObservableList patientTableObservavleList;
    
    @FXML
    private Button saveOnlyButton;
    @FXML
    private Button imageButton;
    @FXML
    private Button newPatientButton1;
    @FXML
    private Button saveAndNewButton1;
    @FXML
    private Button saveAndPrintButton1;
    @FXML
    private Button saveOnlyButton1;
   
    @FXML
    private ComboBox surgenComboBox;
    @FXML
    private ComboBox priceComboBox;
    
    @FXML
    private ComboBox vaComboBox;
    @FXML
    private ComboBox foldPCIOLComboBox;
    
    @FXML
    private ComboBox labComboBox;
    
    
    @FXML
    private ComboBox<?> areaComboBox;
    
    @FXML
    private TextField referanceDrTextField;

    

    
    ObservableList surgenComboBoxObservavleList;
    ObservableList priceComboBoxObservavleList;
    ObservableList labComboBoxObservavleList;
    ObservableList vaComboBoxObservavleList;
    ObservableList foldPCIOLComboBoxObservavleList;
    ObservableList areaComboBoxObservavleList;
    
    @FXML
    private TextField advanceTextField;
    Webcam webcam;
    JFrame window;
    Patient patientObjForId;
    
    Doctor doctor;
    ArrayList<Doctor> doctorArrayList;
    
    Injection injection;
    ArrayList<Injection> injectionArrayList;
    
    int clickCounter;
    ContextMenu contextMenu;
    ArrayList<String> menuItemsArrayList;
    
    ArrayList<String> araeArrayList;
    
    ArrayList<String> surgenArrayList;
    ArrayList<String> labArrayList;
    ArrayList<String> vaArrayList;
    
    ArrayList<String> procejureArrayList;
    @FXML
    private Button newPatientButton;
    @FXML
    private Button saveAndNewButton;
    @FXML
    private Button saveAndPrintButton;
    @FXML
    private Button resetButton;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        clickCounter=2;
        
        araeArrayList = new ArrayList<>();
        
        labArrayList = new ArrayList<>();
        vaArrayList = new ArrayList<>();
        surgenArrayList = new ArrayList<>();
                
        procejureArrayList = new ArrayList<>();
        areaComboBoxObservavleList = FXCollections.observableArrayList();
        
        araeArrayList.add("AMIR ROAD");
        araeArrayList.add("BADAMI BAGH");
        araeArrayList.add("BAND ROAD");
        araeArrayList.add("BHAGHAT PURA");
        araeArrayList.add("BAGHBAPURA");
        araeArrayList.add("BHAMA");
        araeArrayList.add("CHAMRA MANDI");
        araeArrayList.add("CHINA SCHEME");
        araeArrayList.add("CHAH MIRAN");
        araeArrayList.add("DHOBI GHAT");
        araeArrayList.add("DATA NAGAR");
        araeArrayList.add("FAIZ BAGH");
        araeArrayList.add("FAROOQ GANJ");
        araeArrayList.add("GARHHI SHAHU");
        araeArrayList.add("GUJJAR PURA");
        araeArrayList.add("HARBANS PURA");
        araeArrayList.add("KOT KHAWAJA SAEED");
        araeArrayList.add("KACHO PURA");
        araeArrayList.add("KHOKHAR ROAD");
        araeArrayList.add("MOHSNI ROAD");
        araeArrayList.add("MAKHANPURA");
        araeArrayList.add("MISRI SHAH");
        araeArrayList.add("RAVI ROAD");
        araeArrayList.add("SHAHDARA");
        araeArrayList.add("SIDDIQIA COLONY");
        araeArrayList.add("SINGH PURA");
        araeArrayList.add("SCHEME NO 2");
        araeArrayList.add("SHAD BAGH");
        araeArrayList.add("TAJ PURA");
        araeArrayList.add("WASSAN PURA");
        
        for (int i = 0; i < araeArrayList.size(); i++) {
            areaComboBoxObservavleList.add(araeArrayList.get(i));
        }
        
        areaComboBox.setItems(areaComboBoxObservavleList);
        
        surgenComboBoxObservavleList = FXCollections.observableArrayList();
        image = imageView.getImage();
        patth = null;
        printerTest = new PrinterTest();
        nameTextField.setFocusTraversable(true);
        
        injection = new Injection();
        injectionArrayList = new ArrayList<>();
        injectionArrayList = injection.getAllInjection();
        
        
        doctor = new Doctor();
        doctorArrayList = new ArrayList<>();
        doctorArrayList = doctor.getAllDoctor();
        
        surgenComboBoxObservavleList = FXCollections.observableArrayList();
        for (int i = 0; i < doctorArrayList.size(); i++) {
            surgenArrayList.add(doctorArrayList.get(i).getName());
            surgenComboBoxObservavleList.add(doctorArrayList.get(i).getName());
        }
        
        surgenComboBox.setItems(surgenComboBoxObservavleList);
        
        labComboBoxObservavleList = FXCollections.observableArrayList();
        labArrayList.add("None");
        labArrayList.add("+ve , -ve");
        labArrayList.add("-ve , +ve");
        labArrayList.add("+ve , +ve");
        labArrayList.add("-ve , -ve");
        
        for (int i = 0; i < labArrayList.size(); i++) {
            labComboBoxObservavleList.add(labArrayList.get(i));
        }
        labComboBox.setItems(labComboBoxObservavleList);
        
        priceComboBoxObservavleList = FXCollections.observableArrayList();
        
//        priceComboBoxObservavleList.add("001 Bendage lens");//1
//        priceComboBoxObservavleList.add("0.5 B-SCAN");//2
//        priceComboBoxObservavleList.add("0.5 CCT");//3
//        priceComboBoxObservavleList.add("0.5 VFA");//4
//        priceComboBoxObservavleList.add("002 Syringing probing");//5
//        priceComboBoxObservavleList.add("002 Pterygium");//6
//        priceComboBoxObservavleList.add("002 Ros");//7
//        priceComboBoxObservavleList.add("002 Chalzion");//8
//        priceComboBoxObservavleList.add("002 YAG");//9
//        priceComboBoxObservavleList.add("002 Kanacort");//10
//        priceComboBoxObservavleList.add("003 PRP");//11
//        priceComboBoxObservavleList.add("003 OCT");//12
//        priceComboBoxObservavleList.add("003 avastin");//13
//        priceComboBoxObservavleList.add("008 Super kenacart");//14
//        priceComboBoxObservavleList.add("012 IRIS");//15
//        priceComboBoxObservavleList.add("022 MBI");//16
//        priceComboBoxObservavleList.add("022 SIDA");//17
//        priceComboBoxObservavleList.add("025 Squint/Cat");//18
//        priceComboBoxObservavleList.add("030 CXL");//19
//        priceComboBoxObservavleList.add("032 ZEISS");//20
//        priceComboBoxObservavleList.add("042 IQ");//21
//        priceComboBoxObservavleList.add("050 Lucentis");//22
//        priceComboBoxObservavleList.add("050 B/L Squint/Cat");//23
//        priceComboBoxObservavleList.add("060 B/L CXL");//24
        for (int i = 0; i < injectionArrayList.size(); i++) {
            priceComboBoxObservavleList.add(injectionArrayList.get(i).getName());
        }
        
        priceComboBox.setItems(priceComboBoxObservavleList);
        
        
        
        vaComboBoxObservavleList = FXCollections.observableArrayList();
        vaArrayList.add("6/6");
        vaArrayList.add("6/9");
        vaArrayList.add("6/12");
        vaArrayList.add("6/18");
        vaArrayList.add("6/24");
        vaArrayList.add("6/36");
        vaArrayList.add("6/60");
        vaArrayList.add("CF");
        vaArrayList.add("HM");
        vaArrayList.add("PL");
        vaArrayList.add("NPL");
        vaArrayList.add("None");
        for (int i = 0; i < vaArrayList.size(); i++) {
            vaComboBoxObservavleList.add(vaArrayList.get(i));
        }
        vaComboBox.setItems(vaComboBoxObservavleList);
        
        foldPCIOLComboBoxObservavleList = FXCollections.observableArrayList();
        procejureArrayList.add("V+EL+OIL");
        procejureArrayList.add("v+REMOVDROPUNC+OIL");
        procejureArrayList.add("V+SEG");
        procejureArrayList.add("V+OIL+PHACO");
        procejureArrayList.add("V+ERMPEAL+OIL");
        procejureArrayList.add("BUNKLING");
        procejureArrayList.add("P.R.P LASER");
        procejureArrayList.add("INJ. AVESTIN");
        procejureArrayList.add("INJ. CANACORD");
        procejureArrayList.add("INJ. SUPRACREDEL");
        procejureArrayList.add("FOLDABLE");
        procejureArrayList.add("ECCE");
        procejureArrayList.add("PCIOL");
        procejureArrayList.add("PTRIGYM");
        procejureArrayList.add("CHALIZEN");
        procejureArrayList.add("ROS");
        procejureArrayList.add("CXL");
        procejureArrayList.add("PKP");
        procejureArrayList.add("Diagnostic");
        procejureArrayList.add("None");
        for (int i = 0; i < procejureArrayList.size(); i++) {
            foldPCIOLComboBoxObservavleList.add(procejureArrayList.get(i));
        }
        foldPCIOLComboBox.setItems(foldPCIOLComboBoxObservavleList);
        
        patientObjForId = new Patient();
        //crrentPatientID = patientObjForId.getCurrentID();
        idLabel.setText(String.valueOf(Patient.CURRENT_ID));
        
        Platform.runLater(()->nameTextField.requestFocus());
    }    
    
    
    @FXML
    void areaComboBoxActionListner(ActionEvent event) {
        
    }
    
    @FXML
    void areaComboBoxOnKeyReleased(KeyEvent event) {
        areaComboBox.getSelectionModel().clearSelection();
        areaComboBox.show();
        if(event.getText().matches("[a-zA-Z]") || event.getCode()==KeyCode.BACK_SPACE){
            areaComboBoxObservavleList.clear();
            if(!areaComboBox.getEditor().getText().toUpperCase().isEmpty()){
                for (int i = 0; i < araeArrayList.size(); i++) {
                    if(araeArrayList.get(i).startsWith(areaComboBox.getEditor().getText().toUpperCase())){
                        areaComboBoxObservavleList.add(araeArrayList.get(i));
                    }
                }
            }else{
                for (int i = 0; i < araeArrayList.size(); i++) {
                    areaComboBoxObservavleList.add(araeArrayList.get(i));
                }
            }
        }
        else if(areaComboBox.getEditor().getText().isEmpty()){
            for (int i = 0; i < araeArrayList.size(); i++) {
                areaComboBoxObservavleList.add(araeArrayList.get(i));
            }
        }
    }
    
    @FXML
    void procedureComboBoxOnKeyReleased(KeyEvent event) {
        foldPCIOLComboBox.getSelectionModel().clearSelection();
        foldPCIOLComboBox.show();
        if(event.getText().matches("[a-zA-Z]") || event.getCode()==KeyCode.BACK_SPACE){
            foldPCIOLComboBoxObservavleList.clear();
            if(!foldPCIOLComboBox.getEditor().getText().toUpperCase().isEmpty()){
                for (int i = 0; i < procejureArrayList.size(); i++) {
                    if(procejureArrayList.get(i).startsWith(foldPCIOLComboBox.getEditor().getText().toUpperCase())){
                        foldPCIOLComboBoxObservavleList.add(procejureArrayList.get(i));
                    }
                }
            }else{
                for (int i = 0; i < procejureArrayList.size(); i++) {
                    foldPCIOLComboBoxObservavleList.add(procejureArrayList.get(i));
                }
            }
        }
        else if(foldPCIOLComboBox.getEditor().getText().isEmpty()){
            for (int i = 0; i < procejureArrayList.size(); i++) {
                foldPCIOLComboBoxObservavleList.add(procejureArrayList.get(i));
            }
        }
    }
    
    @FXML
    void surgenComboBoxOnKeyReleased(KeyEvent event) {
        surgenComboBox.getSelectionModel().clearSelection();
        surgenComboBox.show();
        if(event.getText().matches("[a-zA-Z]") || event.getCode()==KeyCode.BACK_SPACE){
            surgenComboBoxObservavleList.clear();
            if(!surgenComboBox.getEditor().getText().toUpperCase().isEmpty()){
                for (int i = 0; i < surgenArrayList.size(); i++) {
                    if(surgenArrayList.get(i).startsWith(surgenComboBox.getEditor().getText().toUpperCase())){
                        surgenComboBoxObservavleList.add(surgenArrayList.get(i));
                    }
                }
            }else{
                for (int i = 0; i < surgenArrayList.size(); i++) {
                    surgenComboBoxObservavleList.add(surgenArrayList.get(i));
                }
            }
        }
        else if(surgenComboBox.getEditor().getText().isEmpty()){
            for (int i = 0; i < surgenArrayList.size(); i++) {
                surgenComboBoxObservavleList.add(surgenArrayList.get(i));
            }
        }
    }
    
    @FXML
    void injectionComboBoxOnKeyReleased(KeyEvent event) {
        priceComboBox.getSelectionModel().clearSelection();
        priceComboBox.show();
        if(event.getText().matches("[a-zA-Z]") || event.getCode()==KeyCode.BACK_SPACE){
            priceComboBoxObservavleList.clear();
            if(!priceComboBox.getEditor().getText().toUpperCase().isEmpty()){
                for (int i = 0; i < injectionArrayList.size(); i++) {
                    if(injectionArrayList.get(i).getName().startsWith(priceComboBox.getEditor().getText().toUpperCase())){
                        priceComboBoxObservavleList.add(injectionArrayList.get(i).getName());
                    }
                }
            }else{
                for (int i = 0; i < injectionArrayList.size(); i++) {
                    priceComboBoxObservavleList.add(injectionArrayList.get(i).getName());
                }
            }
        }
        else if(priceComboBox.getEditor().getText().isEmpty()){
            for (int i = 0; i < injectionArrayList.size(); i++) {
                priceComboBoxObservavleList.add(injectionArrayList.get(i).getName());
            }
        }
    }
    
    @FXML
    void labComboBoxOnKeyReleased(KeyEvent event) {
        labComboBox.getSelectionModel().clearSelection();
        labComboBox.show();
        if(event.getText().matches("[a-zA-Z+-]") || event.getCode()==KeyCode.BACK_SPACE){
            labComboBoxObservavleList.clear();
            if(!labComboBox.getEditor().getText().toUpperCase().isEmpty()){
                for (int i = 0; i < labArrayList.size(); i++) {
                    if(labArrayList.get(i).startsWith(labComboBox.getEditor().getText().toUpperCase())){
                        labComboBoxObservavleList.add(labArrayList.get(i));
                    }
                }
            }else{
                for (int i = 0; i < labArrayList.size(); i++) {
                    labComboBoxObservavleList.add(labArrayList.get(i));
                }
            }
        }
        else if(labComboBox.getEditor().getText().isEmpty()){
            for (int i = 0; i < labArrayList.size(); i++) {
                labComboBoxObservavleList.add(labArrayList.get(i));
            }
        }
    }
    
    @FXML
    void vaComboBoxOnKeyReleased(KeyEvent event) {
        vaComboBox.getSelectionModel().clearSelection();
        vaComboBox.show();
        if(event.getText().matches("[a-zA-Z0-9]") || event.getCode()==KeyCode.BACK_SPACE){
            vaComboBoxObservavleList.clear();
            if(!vaComboBox.getEditor().getText().toUpperCase().isEmpty()){
                for (int i = 0; i < vaArrayList.size(); i++) {
                    if(vaArrayList.get(i).startsWith(vaComboBox.getEditor().getText().toUpperCase())){
                        vaComboBoxObservavleList.add(vaArrayList.get(i));
                    }
                }
            }else{
                for (int i = 0; i < vaArrayList.size(); i++) {
                    vaComboBoxObservavleList.add(vaArrayList.get(i));
                }
            }
        }
        else if(vaComboBox.getEditor().getText().isEmpty()){
            for (int i = 0; i < vaArrayList.size(); i++) {
                vaComboBoxObservavleList.add(vaArrayList.get(i));
            }
        }
    }
    
    @FXML
    void genderOnActionListner(ActionEvent event) {
        changeGender();
    }
    
    
    
    
    @FXML
    void genderOnMouseClicked(MouseEvent event) {
        changeGender();
    }
    
    private void changeGender(){
        if(clickCounter%2==0){
            companyTextField.setText("F");
        }
        else{
            companyTextField.setText("M");
        }
        clickCounter++;
    }
    
    void infoReciever(ArrayList<Patient> patientArrayList, ObservableList patientTableObservavleList, String user) {
        this.patientArrayList = patientArrayList;
        //crrentPatientID = patientArrayList.get(this.patientArrayList.size()-1).getId()+1;
        //idLabel.setText(String.valueOf(crrentPatientID));
        this.patientTableObservavleList = patientTableObservavleList;
        this.user = user;
        if(user.equals("1")){
            noOfPrintsTextField.setEditable(true);
        }
    }

    void printOnlyButtonActionListner(ActionEvent event) {
        ///nothing
    }
    
    @FXML
    void injectionPriceComboBoxActionListner(ActionEvent event) {
        
        String injectionName = priceComboBox.getSelectionModel().getSelectedItem().toString();
        //System.out.println(injectionName);
        for (int i = 0; i < injectionArrayList.size(); i++) {
            System.out.println(i);
            if(injectionArrayList.get(i).getName().equals(injectionName)){
                injectionPriceLabel.setText(String.valueOf(injectionArrayList.get(i).getPrice()));
                //System.out.println("price : " + injectionArrayList.get(i).getPrice());
                break;
            }
        }
        
    }

    @FXML
    void imageButtonActionlistner(ActionEvent event) {
        
        try {
            webcam = Webcam.getDefault();
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            
            /*File selectedFile = new FileChooser().showOpenDialog(null);
            path = selectedFile.toURI().toString();
            Image image2 = new Image(selectedFile.toURI().toString());
            imageView.setImage(image2);*/
            WebcamPanel p = new WebcamPanel(webcam);
            
            p.setFPSDisplayed(true);
            p.setDisplayDebugInfo(true);
            p.setImageSizeDisplayed(true);
            p.setMirrored(true);
            
            window = new JFrame("Camera");
            window.setUndecorated(true);
            JButton b = new JButton("Capture & Close");
            b.addActionListener((ActionListener) this);
            //b.addActionListener(new Ation(webcam, window, patth, idLabel.getText(), imageView));
            window.setLayout(new FlowLayout());
            window.add(p);
            window.add(b);
            //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);
            
            
            
            
            
            
            
        } catch (Exception e) {
            errorMessagelabel.setText("Camera not found");
        }
        
        
    }
    

    @FXML
    void newPatientButtonActionListner(ActionEvent event) {
        resetTextFields();
        resetLabels();
    }

    @FXML
    void saveAndNewButtonActionListner(ActionEvent event) {
        if(isInputsConfirmed()){
           savePatient();
           
           String message = "Aap k checkup / operation ki file mukamal ho gai hai, operation ki tareekh / SMS aur phone ka intezaar farmayen.";
            try {
                //SMSGatewayEZEE.sendSMS(" کا انتظار کریآپ کی بکنگ/آپریشن فائل مکمل ہوگئی ہے آپریشن کی تاریخ کا ایس ایم ایس اور فون کالں", phone1TextField.getText().replace("-", ""));
                SMSGatewayEZEE.sendSMS(message, phone1TextField.getText().replace("-", ""));
                SMSGatewayEZEE.sendSMS(message, "03334217818");

            } catch (Exception ex) {
                errorMessagelabel.setText("Message not Sent !");
            }
            resetTextFields();
        }
        
    }

    @FXML
    void saveAndPrintButtonActionlistner(ActionEvent event) {
        if(isInputsConfirmed()){
            savePatient();
            patientPane.setVisible(false);
            printerPane.setVisible(true);
            printMessageLabel.setText("Patient Saved !");
            
            String message = "Aap k checkup / operation ki file mukamal ho gai hai, operation ki tareekh / SMS aur phone ka intezaar farmayen.";
        try {
            //SMSGatewayEZEE.sendSMS(" کا انتظار کریآپ کی بکنگ/آپریشن فائل مکمل ہوگئی ہے آپریشن کی تاریخ کا ایس ایم ایس اور فون کالں", phone1TextField.getText().replace("-", ""));
            SMSGatewayEZEE.sendSMS(message, phone1TextField.getText().replace("-", ""));
            SMSGatewayEZEE.sendSMS(message, "03334217818");
        
        } catch (Exception ex) {
            errorMessagelabel.setText("Message not Sent !");
        }
        }
    }
    
    @FXML
    void closePrintButtonActionListner(ActionEvent event) {
        patientPane.setVisible(true);
        printerPane.setVisible(false);
        printMessageLabel.setText("");
        //resetTextFields();
        //resetLabels();
    }
    
    @FXML
    void resetPictureButtonActionListner(ActionEvent event) {
       imageView.setImage(image);
    }
    
    @FXML
    void noOfPrintsButtonActionListner(ActionEvent event) {
        
        try {
            int noOfPrints = Integer.parseInt(noOfPrintsTextField.getText());
            if(noOfPrints > 0 && noOfPrints < 25){
                printerTest.generatePaperWithData(patient, noOfPrints,
                        priceComboBox.getSelectionModel().getSelectedItem().toString(), injectionPriceLabel.getText());
                printMessageLabel.setText("Print Sent to Printer !");
            } else {
                printMessageLabel.setText("(max : 25, min : 1)");
            }
        } catch (NumberFormatException e) {
            printMessageLabel.setText("invalid input !");
        }
    }

    @FXML
    void saveOnlyButtonActionlistner(ActionEvent event) {
        if(isInputsConfirmed()){
            savePatient();
        }
    }
    
    int injectionID(String injectionName){
        for (int i = 0; i < injectionArrayList.size(); i++) {
            if(injectionArrayList.get(i).getName().equals(injectionName)){
                return injectionArrayList.get(i).getId();
            }
        }
        return -1;
    }
    
    void savePatient(){
        //System.out.println("1");
        //JOptionPane.showMessageDialog(null, injectionID(priceComboBox.getSelectionModel().getSelectedItem().toString()));
        RadioButton rightLeftRadioBtton = (RadioButton) rightLeftTogglegroup.getSelectedToggle();
        LocalDateTime currentTime = LocalDateTime.now();
        //System.out.println("2");
        patient = new Patient(Integer.parseInt(idLabel.getText()), nameTextField.getText(),
                fatherHusbandNameTextField.getText(), String.valueOf(rightLeftRadioBtton.getText()), 
                cnicTextField.getText(), areaComboBox.getEditor().getText(), phone1TextField.getText(), phone2TextField.getText(), 
                raseed1TextField.getText(), raseed2TextField.getText(), injectionID(priceComboBox.getSelectionModel().getSelectedItem().toString()), 
                fileNumberTextField.getText(), rowIO2TextField.getText(), Float.parseFloat(discountTextField.getText()),
                companyTextField.getText(), coTextField.getText(), patth, Integer.parseInt(ageTextField.getText()), Float.parseFloat(advanceTextField.getText()), surgenComboBox.getSelectionModel().getSelectedItem().toString(),
                referanceDrTextField.getText(), labComboBox.getEditor().getText(), vaComboBox.getEditor().getText(),
                foldPCIOLComboBox.getEditor().getText(), currentTime.toLocalDate().toString(), "none",
                newCompanyTextField.getText(), regNoTextField.getText(), "", this.user);
        //System.out.println("3");
        
        
        patient.addPatient(patient);
        if(this.user.equals("1")){
            patient.setUser("Admin");
        }
        
        patientArrayList.add(patient);
        Patient.CURRENT_ID++;
        //patientObjForId.updateID(crrentPatientID);
        patientTableObservavleList.add(patient);
        idLabel.setText(String.valueOf(Patient.CURRENT_ID));
        resetLabels();
        
        messageLabel.setText("Patient Saved!");
        
        
    }
    
    
    @FXML
    public void cnicAddDashesOnKeyReleased() {
        if(cnicTextField.getText().length() == 5 || cnicTextField.getText().length() == 13){
            cnicTextField.setText(cnicTextField.getText() + "-");
            cnicTextField.positionCaret(cnicTextField.getText().length());
        }
        if(cnicTextField.getText().length()>15){
           String s = cnicTextField.getText().substring(0, 15);
                cnicTextField.setText(s);
                cnicTextField.positionCaret(cnicTextField.getText().length());
        }
    }
    
    @FXML
    void phone1OnKeyReleased() {
        if(phone1TextField.getText().length()>1){
            if(phone1TextField.getText().substring(0, 2).equals("04")){
                if(phone1TextField.getText().length() == 3){
                    phone1TextField.setText(phone1TextField.getText() + "-");
                    phone1TextField.positionCaret(phone1TextField.getText().length());
                }
            } else if(phone1TextField.getText().substring(0, 2).equals("03")){
               if(phone1TextField.getText().length() == 4){
                    phone1TextField.setText(phone1TextField.getText() + "-");
                    phone1TextField.positionCaret(phone1TextField.getText().length());
                }
            } else {

            }
            if(phone1TextField.getText().length()>12){
               String s = phone1TextField.getText().substring(0, 12);
                    phone1TextField.setText(s);
                    phone1TextField.positionCaret(phone1TextField.getText().length());
            }
        }
    }

    @FXML
    void phone2OnKeyReleased() {
        if(phone2TextField.getText().length()>1){
            if(phone2TextField.getText().substring(0, 2).equals("04")){
                if(phone2TextField.getText().length() == 3){
                    phone2TextField.setText(phone2TextField.getText() + "-");
                    phone2TextField.positionCaret(phone2TextField.getText().length());
                }
            } else if(phone2TextField.getText().substring(0, 2).equals("03")){
               if(phone2TextField.getText().length() == 4){
                    phone2TextField.setText(phone2TextField.getText() + "-");
                    phone2TextField.positionCaret(phone2TextField.getText().length());
                }
            } else {

            }
            if(phone2TextField.getText().length()>12){
               String s = phone2TextField.getText().substring(0, 12);
                    phone2TextField.setText(s);
                    phone2TextField.positionCaret(phone2TextField.getText().length());
            }
        }
    }
    
    
    boolean isInputsConfirmed(){
        messageLabel.setText("");
        if(!nameTextField.getText().equals("") && !Pattern.compile("[0-9!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]").matcher(nameTextField.getText()).find()){
            if(nameTextField.getText().length()>28){
                errorMessagelabel.setText("Name max: 28 char");
                return false;
            }
            if(!fatherHusbandNameTextField.getText().equals("") && !Pattern.compile("[0-9!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]").matcher(fatherHusbandNameTextField.getText()).find()){
                if(fatherHusbandNameTextField.getText().length()>28){
                    errorMessagelabel.setText("Father Name max: 28 char");
                    return false;
                }
                if(!ageTextField.getText().equals("")){
                    try {
                        Integer.parseInt(ageTextField.getText());
                    } catch (NumberFormatException e) {
                        errorMessagelabel.setText("* Not valid age!");
                        return false;
                    }
                    if(!cnicTextField.getText().equals("") && !Pattern.compile("[a-zA-Z!@#$%&*()_+=|<>?{}\\\\[\\\\]~]").matcher(cnicTextField.getText()).find()){
                        if(cnicTextField.getText().length()==13){
                            if(!(cnicTextField.getText().matches("[0-9]+"))) {
                                errorMessagelabel.setText("Invalid CNIC !");
                                return false;   
                            }
                        } else if(cnicTextField.getText().length()==15){
                            
                        } else {
                            errorMessagelabel.setText("Invalid CNIC!");
                            return false;
                        }
                        if(!areaComboBox.getEditor().getText().equals("")){
                            if(!phone1TextField.getText().equals("")){
                                if(phone1TextField.getText().length() == 12 && !Pattern.compile("[a-zA-Z!@#$%&*()_+=|<>?{}\\\\[\\\\]~]").matcher(phone1TextField.getText()).find()) {
                                    
                                } else {
                                    errorMessagelabel.setText("Invalid Phone1 !");
                                    return false;
                                }
                                if(!raseed1TextField.getText().equals("")){
                                    if(raseed1TextField.getText().length()>6){
                                        errorMessagelabel.setText("raseed 1 max 6 char");
                                        return false;
                                    }
                                    if(!priceComboBox.getSelectionModel().isEmpty()){
                                        
                                        
                                        if(!fileNumberTextField.getText().equals("")){
                                            /*try {
                                                Integer.parseInt(fileNumberTextField.getText());
                                            } catch (NumberFormatException e) {
                                                errorMessagelabel.setText("* NotValid file Nmber!");
                                                return false;
                                            }*/
                                            if(!rowIO2TextField.getText().equals("") ){
                                                Pattern pattern3 = Pattern.compile("[^a-zA-Z ]");
                                                Matcher matcher3 = pattern3.matcher(rowIO2TextField.getText());
                                                boolean isStringContainsSpecialCharacter3 = matcher3.find();
                                                if(isStringContainsSpecialCharacter3){
                                                    errorMessagelabel.setText("Invalid IOL");
                                                    return false;
                                                }
                                                if(!discountTextField.getText().equals("")){
                                                    try {
                                                        Float.parseFloat(discountTextField.getText());
                                                        
                                                        if(discountTextField.getText().length()>6){
                                                            errorMessagelabel.setText("discount max 6 char");
                                                            return false;
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        errorMessagelabel.setText("* Invalid discount!");
                                                        return false;
                                                    }
                                                    if(!companyTextField.getText().equals("")){
                                                        if(!(companyTextField.getText().equals("M") || companyTextField.getText().equals("m") || companyTextField.getText().equals("F") || companyTextField.getText().equals("f"))){
                                                            errorMessagelabel.setText("Gender Should be M/F");
                                                            return false;
                                                        }
                                                        if(!coTextField.getText().equals("")){
                                                            
                                                            if(!advanceTextField.getText().equals("")){
                                                                //JOptionPane.showMessageDialog(null, "ll");
                                                                try {
                                                                    Float.parseFloat(advanceTextField.getText());
                                                                    if(surgenComboBox.getSelectionModel().isEmpty()){
                                                                        errorMessagelabel.setText("Select Surgen !");
                                                                        return false;
                                                                    }
                                                                    else{
                                                                        if(labComboBox.getSelectionModel().isEmpty()){
                                                                            errorMessagelabel.setText("Select Lab !");
                                                                            return false;
                                                                        }
                                                                        else{
                                                                            if(!newCompanyTextField.getText().equals("")){
                                                                                if(!regNoTextField.getText().equals("")){
                                                                                    if(vaComboBox.getSelectionModel().isEmpty()){
                                                                                        errorMessagelabel.setText("Select V.A !");
                                                                                        return false;
                                                                                    } else{
                                                                                        if(vaComboBox.getSelectionModel().isEmpty()){
                                                                                            errorMessagelabel.setText("Select FOLD PC IOL !");
                                                                                            return false;
                                                                                        } else{
                                                                                            if(patientObjForId.isFileNumberExist(fileNumberTextField.getText())){
                                                                                                errorMessagelabel.setText("File # Already Exist");
                                                                                                return false;
                                                                                            }
                                                                                            else{
                                                                                                Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
                                                                                                Matcher matcher = pattern.matcher(fileNumberTextField.getText());
                                                                                                boolean isStringContainsSpecialCharacter = matcher.find();
                                                                                                if(isStringContainsSpecialCharacter){
                                                                                                    errorMessagelabel.setText("Invalid File#");
                                                                                                    return false;
                                                                                                }else{
                                                                                                                if(patientObjForId.isRaseedExist(raseed1TextField.getText())){
                                                                                                                    errorMessagelabel.setText("Raseed1 # Already Exist");
                                                                                                                    return false;
                                                                                                                }
                                                                                                                else{
                                                                                                                    Pattern pattern1 = Pattern.compile("[^0-9]");
                                                                                                                    Matcher matcher1 = pattern1.matcher(raseed1TextField.getText());
                                                                                                                    boolean isStringContainsSpecialCharacter1 = matcher1.find();
                                                                                                                    if(isStringContainsSpecialCharacter1){
                                                                                                                        errorMessagelabel.setText("Invalid Raseed1 ");
                                                                                                                        return false;
                                                                                                                    }else{
                                                                                                                        if(foldPCIOLComboBox.getSelectionModel().isEmpty()){
                                                                                                                            errorMessagelabel.setText("Select Procejur !");
                                                                                                                            return false;
                                                                                                                        }
                                                                                                                        else{
                                                                                                                            Pattern pattern4 = Pattern.compile("[^a-zA-Z ]");
                                                                                                                            Matcher matcher4 = pattern4.matcher(coTextField.getText());
                                                                                                                            boolean isStringContainsSpecialCharacter4 = matcher4.find();
                                                                                                                            if(isStringContainsSpecialCharacter4){
                                                                                                                                errorMessagelabel.setText("Invalid Careof");
                                                                                                                                return false;
                                                                                                                            }
                                                                                                                            
                                                                                                                            Pattern pattern5 = Pattern.compile("[^a-zA-Z ]");
                                                                                                                            Matcher matcher5 = pattern5.matcher(referanceDrTextField.getText());
                                                                                                                            boolean isStringContainsSpecialCharacter5 = matcher5.find();
                                                                                                                            if(isStringContainsSpecialCharacter5){
                                                                                                                                errorMessagelabel.setText("Invalid Ref Dr");
                                                                                                                                return false;
                                                                                                                            }
                                                                                                                            
                                                                                                                            Pattern pattern7 = Pattern.compile("[^0-9/]");
                                                                                                                            Matcher matcher7 = pattern7.matcher(regNoTextField.getText());
                                                                                                                            boolean isStringContainsSpecialCharacter7 = matcher7.find();
                                                                                                                            if(isStringContainsSpecialCharacter7){
                                                                                                                                errorMessagelabel.setText("Invalid Reg #");
                                                                                                                                return false;
                                                                                                                            }
                                                                                                                            
                                                                                                                            Pattern pattern6 = Pattern.compile("[^a-zA-Z ]");
                                                                                                                            Matcher matcher6 = pattern6.matcher(newCompanyTextField.getText());
                                                                                                                            boolean isStringContainsSpecialCharacter6 = matcher6.find();
                                                                                                                            if(isStringContainsSpecialCharacter6){
                                                                                                                                errorMessagelabel.setText("Invalid Company");
                                                                                                                                return false;
                                                                                                                            }
                                                                                                                            
                                                                                                                            
                                                                                                                            return true;
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    
                                                                                    
                                                                                } else {
                                                                                    errorMessagelabel.setText("Reg # is missing");
                                                                                    return false;
                                                                                }
                                                                            } else {
                                                                                errorMessagelabel.setText("Compabny is missing");
                                                                                return false;
                                                                            }
                                                                            
                                                                            
                                                                        }
                                                                    }

                                                                } catch (NumberFormatException e) {
                                                                    errorMessagelabel.setText("Invalid Advance !");
                                                                    return false;
                                                                }

                                                            }else{
                                                                errorMessagelabel.setText("enter Advance !");
                                                                return false;
                                                            }
                                                                
                                                            
                                                        } else {
                                                            errorMessagelabel.setText("* CO is Missing !");
                                                            return false;
                                                        }
                                                    } else {
                                                        errorMessagelabel.setText("* Gender is Missing !");
                                                        return false;
                                                    }
                                                } else {
                                                    errorMessagelabel.setText("* Discount is Missing !");
                                                    return false;
                                                }
                                            } else {
                                                errorMessagelabel.setText("* IOL is Missing !");
                                                return false;
                                            }
                                        } else {
                                            errorMessagelabel.setText("* File # is Missing !");
                                            return false;
                                        }
                                    } else {
                                        errorMessagelabel.setText("* Select Price !");
                                        return false;
                                    }
                                } else {
                                    errorMessagelabel.setText("* Raseed 1 is Missing !");
                                    return false;
                                }
                            } else {
                                errorMessagelabel.setText("* Phone 1 is Missing !");
                                return false;
                            }
                        } else {
                            errorMessagelabel.setText("* Area is Missing !");
                            return false;
                        }
                    } else {
                        errorMessagelabel.setText("* Invalid CNIC !");
                        return false;
                    }
                } else {
                    errorMessagelabel.setText("* Invalid Age!");
                    return false;
                }
            } else {
                errorMessagelabel.setText("* Father/Husband Name is Missing !");
                return false;
            }
        } else {
            errorMessagelabel.setText("* Invalid Name!");
            return false;
        }
    }
    
    void resetTextFields(){
        nameTextField.setText("");
        fatherHusbandNameTextField.setText("");
        ageTextField.setText("");
        cnicTextField.setText("");
        
        phone1TextField.setText("");
        phone2TextField.setText("");
        raseed1TextField.setText("");
        raseed2TextField.setText("");
        
        priceComboBox.getSelectionModel().clearSelection();
        surgenComboBox.getSelectionModel().clearSelection();
        labComboBox.getSelectionModel().clearSelection();
        foldPCIOLComboBox.getSelectionModel().clearSelection();
        vaComboBox.getSelectionModel().clearSelection();
        
        regNoTextField.setText("");
        fileNumberTextField.setText("");
        rowIO2TextField.setText("");
        discountTextField.setText("0");
        companyTextField.setText("M");
        coTextField.setText("");
        imageView.setImage(image);
        referanceDrTextField.setText("");
        newCompanyTextField.setText("");
        patth = null;
        patient = null;
    }
    
    void resetLabels(){
        errorMessagelabel.setText("");
        messageLabel.setText("");
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent ae) {
        File file = new File("E:/Patient Images/image"+idLabel.getText()+".jpg");
            try {
                ImageIO.write(webcam.getImage(), "JPG", file);
            } catch (IOException ex) {
                System.out.println("image not created");
            }
                patth = file.toURI().toString();
                Image image2 = new Image(patth);
                imageView.setImage(image2);
                webcam.close();
                window.dispose();
    }

    @FXML
    private void abc2(KeyEvent event) {
        if(event.getCode().equals(KeyCode.TAB)){
            //JOptionPane.showMessageDialog(null, "3");
            areaComboBox.requestFocus();
        }
    }

    @FXML
    private void abc(KeyEvent event) {
        
    }

    
    
    
}
