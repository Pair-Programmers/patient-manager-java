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
 * @author 15009065376
 */
public class Patient {
    public static int CURRENT_ID;
    
    private int id;
    private String name;
    private String fatherHusbandName;
    private String surgrey;
    private String cnic;
    private String area;
    private String phone1;
    private String phone2;
    private String raseed1;
    private String raseed2;
    private int recieptNumber;
    private String fileNumber;
    private String rowIO2;
    private Float discount;
    private String company;
    private String co;
    private String image;
    private int age;
    private String referanceDr;
    private String lab;
    private String va;
    private String foldPCIOL;
    private String date;
    

    
    private float advane;
    private String surgen;
    
    private String status;
    
    private String newCompany;
    private String regNumber;
    private String surgeryCompletionDate;
    String user;
    
    String timestamp;
     private float actualPrice;

    public Patient() {
        
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }
    
    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    
    public int getAge() {
        return age;
    }

    public void setAdvane(float advane) {
        this.advane = advane;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getAdvane() {
        return advane;
    }

    public String getVa() {
        return va;
    }

    public String getReferanceDr() {
        return referanceDr;
    }

    public String getLab() {
        return lab;
    }

    public String getFoldPCIOL() {
        return foldPCIOL;
    }

    public void setVa(String va) {
        this.va = va;
    }

    public void setReferanceDr(String referanceDr) {
        this.referanceDr = referanceDr;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public void setFoldPCIOL(String foldPCIOL) {
        this.foldPCIOL = foldPCIOL;
    }

    public void setSurgen(String surgen) {
        this.surgen = surgen;
    }

    public String getSurgen() {
        return surgen;
    }

    
    public void setAge(int age) {
        this.age = age;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFatherHusbandName(String fatherHusbandName) {
        this.fatherHusbandName = fatherHusbandName;
    }

    public String getFatherHusbandName() {
        return fatherHusbandName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurgrey(String surgrey) {
        this.surgrey = surgrey;
    }

    public String getSurgrey() {
        return surgrey;
    }

    

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getNewCompany() {
        return newCompany;
    }

    public void setNewCompany(String newCompany) {
        this.newCompany = newCompany;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getRaseed1() {
        return raseed1;
    }

    public void setRaseed1(String raseed1) {
        this.raseed1 = raseed1;
    }

    public String getRaseed2() {
        return raseed2;
    }

    public void setRaseed2(String raseed2) {
        this.raseed2 = raseed2;
    }

    public int getRecieptNumber() {
        return recieptNumber;
    }

    public void setRecieptNumber(int recieptNumber) {
        this.recieptNumber = recieptNumber;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getRowIO2() {
        return rowIO2;
    }

    public void setRowIO2(String rowIO2) {
        this.rowIO2 = rowIO2;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setSurgeryCompletionDate(String surgeryCompletionDate) {
        this.surgeryCompletionDate = surgeryCompletionDate;
    }

    public String getSurgeryCompletionDate() {
        return surgeryCompletionDate;
    }

    public void setActualPrice(float actualPrice) {
        this.actualPrice = actualPrice;
    }

    public float getActualPrice() {
        return actualPrice;
    }
    
    
    

    public Patient(int id, String name, String fatherHusbandName, String surgrey, String cnic, String area, String phone1, String phone2, String raseed1, String raseed2, int recieptNumber, String fileNumber, String rowIO2, float discount, String company, String co, String image, int age, float advane, String surgen, String referanceDr, String lab, String va, String foldPCIOL, String date, String status, String newCompany,
            String regNumber, String surgeryCompletionDate, String user) {
        this.id = id;
        this.name = name;
        this.fatherHusbandName = fatherHusbandName;
        this.surgrey = surgrey;
        this.cnic = cnic;
        this.area = area;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.raseed1 = raseed1;
        this.raseed2 = raseed2;
        this.recieptNumber = recieptNumber;
        this.fileNumber = fileNumber;
        this.rowIO2 = rowIO2;
        this.discount = discount;
        this.company = company;
        this.co = co;
        this.image = image;
        this.age = age;
        this.advane = advane;
        this.surgen = surgen;
        this.referanceDr = referanceDr;
        this.lab = lab;
        this.va = va;
        this.foldPCIOL = foldPCIOL;
        this.date = date;
        this.status = status;
        this.newCompany  = newCompany;
        this.regNumber = regNumber;
        this.surgeryCompletionDate = surgeryCompletionDate;
        this.user = user;
        /*try {
            this.actualPrice = Injection.getInjectionName(recieptNumber).getPrice();
        } catch (Exception e) {
            
        }*/
        
    }

    
   
    public void addPatient(Patient patient){
        LocalDateTime currentTime = LocalDateTime.now();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "INSERT INTO `patients`(`name`, `fatherHusbandName`, "
                + "`surgrey`, `cnic`, `area`, `phone1`, `phone2`, `raseed1`, "
                + "`raseed2`, `recieptNumber`, `fileNumber`, `rowIO2`, `discount`, "
                + "`company`, `co`, `image`, `age`, `arival_date`, `advance`, `surgen`, "
                + "`referanceDr`, `lab`, `va`, `foldPCIOL`, `status`, `newCompany`,"
                + " `regNumber`, `surgeryCompletionDate`, `user`) "
                + "VALUES ('"+patient.getName()+"', "
                + "'"+patient.getFatherHusbandName()+"', '"+patient.getSurgrey()+"', "
                + "'"+patient.getCnic()+"', '"+patient.getArea()+"', '"+patient.getPhone1()+"', "
                + "'"+patient.getPhone2()+"', '"+patient.getRaseed1()+"', '"+patient.getRaseed2()+"', "
                + ""+patient.getRecieptNumber()+", '"+patient.getFileNumber()+"', '"+patient.getRowIO2()+"', "
                + ""+patient.getDiscount()+", '"+patient.getCompany()+"', "
                + "'"+patient.getCo()+"', '"+patient.getImage()+"', "+patient.getAge()+", '"+patient.getDate()+"',"
                + " "+patient.getAdvane()+", '"+patient.getSurgen()+"', '"+patient.getReferanceDr()+"', '"+patient.getLab()+"', '"+patient.getVa()+"', '"+patient.getFoldPCIOL()+"', '"+patient.getStatus()+"'"
                + ", '"+patient.getNewCompany()+"', '"+patient.getRegNumber()+"',"
                + " '"+patient.getSurgeryCompletionDate()+"', '"+patient.getUser()+"')";
        dataBaseConnection.runExecuteUpdate(query);
        
        //JOptionPane.showMessageDialog(null, "Added Patient !");
    }
    
    public void updatePatient(Patient patient){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "UPDATE `patients` SET `name`= '"+patient.getName()+"',`fatherHusbandName`= '"+patient.getFatherHusbandName()+"',`surgrey`= '"+patient.getSurgrey()+"',"
                + "`cnic`= '"+patient.getCnic()+"',`area`= '"+patient.getArea()+"',`phone1`= '"+patient.getPhone1()+"',`phone2`= '"+patient.getPhone2()+"',`raseed1`= '"+patient.getRaseed1()+"',"
                + "`raseed2`= '"+patient.getRaseed2()+"',`recieptNumber`= "+patient.getRecieptNumber()+",`fileNumber`= '"+patient.getFileNumber()+"',"
                + "`rowIO2`= '"+patient.getRowIO2()+"',`discount`= "+patient.getDiscount()+",`company`= '"+patient.getCompany()+"',"
                + "`co`= '"+patient.getCo()+"',`image`= '"+patient.getImage()+"',`age`= "+patient.getAge()+", `advance`= "+patient.getAdvane()+", `surgen`= '"+patient.getSurgen()+"', `referanceDr`= '"+patient.getReferanceDr()+"',"
                + "`lab`= '"+patient.getLab()+"', `va`= '"+patient.getVa()+"', `foldPCIOL`= '"+patient.getFoldPCIOL()+"', `newCompany`= '"+patient.getNewCompany()+"', `regNumber`= '"+patient.getRegNumber()+"' WHERE `id` = "+patient.getId()+"";
        dataBaseConnection.runExecuteUpdate(query);
        //JOptionPane.showMessageDialog(null, "Patient Updated!");
    }
    
    public void updatePatientStatus(int id, String status){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "UPDATE `patients` SET `status`= '"+status+"' WHERE `id` = "+id+"";
        dataBaseConnection.runExecuteUpdate(query);
        //JOptionPane.showMessageDialog(null, "Patient Updated!");
    }
    
    public void updatePatientCompletionDate(int id, String date){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "UPDATE `patients` SET `surgeryCompletionDate`= '"+date+"' WHERE `id` = "+id+"";
        dataBaseConnection.runExecuteUpdate(query);
        //JOptionPane.showMessageDialog(null, "Patient Updated!");
    }
    
    public void updatePatientSurgeryCompletionDate(int id, String date){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "UPDATE `patients` SET `surgeryCompletionDate`= '"+date+"' WHERE `id` = "+id+"";
        dataBaseConnection.runExecuteUpdate(query);
        //JOptionPane.showMessageDialog(null, "Patient Updated!");
    }
    public void updateID(int id){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "UPDATE `currentid` SET `id`= "+id+"";
        dataBaseConnection.runExecuteUpdate(query);
        
    }
    
    public static void setCurrentID(){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        //String query = "SELECT  `id` FROM `currentid`";
        String query = "SELECT id FROM patients ORDER BY ID DESC LIMIT 1";
                
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            rs.next();
            CURRENT_ID = rs.getInt("id")+1;
            
        } catch (SQLException ex) {
            CURRENT_ID = 1;
            JOptionPane.showMessageDialog(null, "Error while getting current ID static!");
        }
    }
    
    public int getCurrentID(){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        //String query = "SELECT  `id` FROM `currentid`";
        String query = "SELECT id FROM patients ORDER BY ID DESC LIMIT 1";
                
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        ArrayList<Patient> patientArrayList = new ArrayList<>();
        try {
            rs.next();
            return rs.getInt("id")+1;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while getting current ID !");
        }
        return 0;
    }
    
    public boolean isFileNumberExist(String fileNumber){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT  `id` FROM `patients` where `fileNumber` = '"+fileNumber+"' ";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            rs.next();
            rs.getInt("id");
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean isFileNumberExistForUpdate(String fileNumber, int id){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT  `id` FROM `patients` where `fileNumber` = '"+fileNumber+"' AND id != '"+id+"'";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            rs.next();
            rs.getInt("id");
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean isRaseedExist(String raseedNo){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT  `id` FROM `patients` where `raseed1` = '"+raseedNo+"' ";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            rs.next();
            rs.getInt("id");
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean isRaseedExistForUpdate(String raseedNo, int id){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT  `id` FROM `patients` where `raseed1` = '"+raseedNo+"' AND id != "+id+"";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            rs.next();
            rs.getInt("id");
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public void deletePatient(){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "DELETE FROM `patients` WHERE `id` = "+this.id+"";
        dataBaseConnection.runExecuteUpdate(query);
        //JOptionPane.showMessageDialog(null, "Patient Updated!");
    }
    
    public ArrayList<Patient> getAllPatients(){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT * FROM patients, injection WHERE patients.recieptNumber = injection.id";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        ArrayList<Patient> patientArrayList = new ArrayList<>();
        String user;
        int i = 1;
        try {
            while (rs.next()) {
                
                if(rs.getString("user").equals("1")){
                    user = "Admin";
                } else{
                    user = rs.getString("user");
                }
                Patient patient = new Patient(rs.getInt("id"), rs.getString("name"), rs.getString("fatherHusbandName"),
                                                rs.getString("surgrey"), rs.getString("cnic"), rs.getString("area"), rs.getString("phone1"),
                                                rs.getString("phone2"), rs.getString("raseed1"), rs.getString("raseed2"), rs.getInt("recieptNumber"),
                                                rs.getString("fileNumber"), rs.getString("rowIO2"), rs.getInt("discount"), rs.getString("company"), 
                                                rs.getString("co"), rs.getString("image"), rs.getInt("age"), rs.getInt("advance"), rs.getString("surgen"), rs.getString("referanceDr"),
                                                rs.getString("lab"), rs.getString("va"), rs.getString("foldPCIOL"), rs.getString("arival_date"), rs.getString("status"),
                                                rs.getString("newCompany"), rs.getString("regNumber"), rs.getString("surgeryCompletionDate"),
                                                user);
                patient.setActualPrice(rs.getFloat("price"));
                patient.setTimestamp(rs.getString("time"));
                patientArrayList.add(patient);
                System.out.println("id="+rs.getInt("id"));
                
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while getting patients data !" + ex);
        }
        /*Patient patient;
        for(int i = 0; i<patientArrayList.size(); i++){
            patient = patientArrayList.get(i);
            patient.setActualPrice(Injection.getInjectionName(patientArrayList.get(i).getRecieptNumber()).getPrice());
        }*/
        return patientArrayList;
    }
    
    public ArrayList<Patient> getPatientsForBackup(){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT * FROM patients";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        ArrayList<Patient> patientArrayList = new ArrayList<>();
        try {
            while (rs.next()) {
                
                
                Patient patient = new Patient(rs.getInt("id"), rs.getString("name"), rs.getString("fatherHusbandName"),
                                                rs.getString("surgrey"), rs.getString("cnic"), rs.getString("area"), rs.getString("phone1"),
                                                rs.getString("phone2"), rs.getString("raseed1"), rs.getString("raseed2"), rs.getInt("recieptNumber"),
                                                rs.getString("fileNumber"), rs.getString("rowIO2"), rs.getInt("discount"), rs.getString("company"), 
                                                rs.getString("co"), rs.getString("image"), rs.getInt("age"), rs.getInt("advance"), rs.getString("surgen"), rs.getString("referanceDr"),
                                                rs.getString("lab"), rs.getString("va"), rs.getString("foldPCIOL"), rs.getString("arival_date"), rs.getString("status"),
                                                rs.getString("newCompany"), rs.getString("regNumber"), rs.getString("surgeryCompletionDate"),
                                                rs.getString("user"));
                
                patientArrayList.add(patient);
                patient.setTimestamp(rs.getString("time"));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while getting patients data !");
        }
        /*Patient patient;
        for(int i = 0; i<patientArrayList.size(); i++){
            patient = patientArrayList.get(i);
            patient.setActualPrice(Injection.getInjectionName(patientArrayList.get(i).getRecieptNumber()).getPrice());
        }*/
        return patientArrayList;
    }

    @Override
    public String toString() {
        String lab="";
        switch(this.lab){
            case "None":
                lab = "None";
                break;
            case "+ve , -ve":
                lab = "\"+ve , -ve\"";
                break;
            case "-ve , +ve":
                lab = "\"-ve , +ve\"";
                break;
            case "+ve , +ve":
                lab = "\"+ve , +ve\"";
                break;
            case "-ve , -ve":
                lab = "\"-ve , -ve\"";
                break;
            default:
                
        }
        String patient = id+","+name+","+fatherHusbandName+","+surgrey+","+cnic+","
                +area+","+phone1+","+phone2+","+raseed1+","+raseed2+","+recieptNumber+","+fileNumber+","
                +rowIO2+","+discount+","+company+","+co+","+image+","+age+","+date+","+advane+","+surgen+","
                +referanceDr+","+lab+","+va+","+foldPCIOL+","+status+","+newCompany+","+regNumber+","
                +surgeryCompletionDate+","+user;
        return patient; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
