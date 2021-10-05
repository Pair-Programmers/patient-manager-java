/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Interface.Patient;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author mianh
 */
public class ExcelConverter {

    private XSSFWorkbook fWorkbook;
    private FileOutputStream fos;
    private XSSFSheet spreadSheet;
    private FileChooser fc;
    private boolean flag;
    File file;
    public ExcelConverter() {
        fc = new FileChooser();
        file = fc.showSaveDialog(null);
        if(file == null){
            flag = false;
        }else{
            flag = true;
        }
        
        if(flag){
            fWorkbook = new XSSFWorkbook();
            
            try {


                fos = new FileOutputStream(file+".xlsx");
            } catch (FileNotFoundException ex) {
                System.out.println("errror creating file output stream");
            }
            spreadSheet = fWorkbook.createSheet("sample");  
        }
        
    }
    
    
    
    
    public void createExcelFile(ArrayList<Patient> p) {
        if(flag){
            
        
        try {
            createFirtsRow();
            for(int i = 0; i < p.size(); i++){
                Row row = spreadSheet.createRow(i+1);
                //for(int j = 0; j < 18; j++){
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(i+1);

                Cell cell2 = row.createCell(1);
                cell2.setCellValue(p.get(i).getId());

                Cell cell3 = row.createCell(2);
                cell3.setCellValue(p.get(i).getName());

                Cell cell4 = row.createCell(3);
                cell4.setCellValue(p.get(i).getFatherHusbandName());

                Cell cell5 = row.createCell(4);
                cell5.setCellValue(p.get(i).getCnic());

                Cell cell6 = row.createCell(5);
                cell6.setCellValue(p.get(i).getArea());

                Cell cell7 = row.createCell(6);
                cell7.setCellValue(p.get(i).getPhone1());

                Cell cell8 = row.createCell(7);
                cell8.setCellValue(p.get(i).getPhone2());

                Cell cell9 = row.createCell(8);
                cell9.setCellValue(p.get(i).getRaseed1());

                Cell cell10 = row.createCell(9);
                cell10.setCellValue(p.get(i).getRaseed2());

                Cell cell11 = row.createCell(10);
                cell11.setCellValue(p.get(i).getRowIO2());

                Cell cell12 = row.createCell(11);
                cell12.setCellValue(p.get(i).getCompany());

                Cell cell13 = row.createCell(12);
                cell13.setCellValue(p.get(i).getAge());

                Cell cell14 = row.createCell(13);
                cell14.setCellValue(p.get(i).getFileNumber());

                Cell cell15 = row.createCell(14);
                cell15.setCellValue(p.get(i).getSurgrey());

                Cell cell16 = row.createCell(15);
                cell16.setCellValue(p.get(i).getSurgen());

                Cell cell17 = row.createCell(16);
                cell17.setCellValue(p.get(i).getRecieptNumber());

                Cell cell18 = row.createCell(17);
                cell18.setCellValue(p.get(i).getAdvane());

                Cell cell19 = row.createCell(18);
                cell19.setCellValue(p.get(i).getDiscount());

            }
            fWorkbook.write(fos);
            fos.close();
            fWorkbook.close();
            JOptionPane.showMessageDialog(null, "Exported Succesfully !");
        } catch (Exception ex) {
            Logger.getLogger(ExcelConverter.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        }
    }
    
    void createFirtsRow(){
        Row row = spreadSheet.createRow(0);
        
        Cell cell1 = row.createCell(0);
        cell1.setCellValue("No");
        
        Cell cell2 = row.createCell(1);
        cell2.setCellValue("ID");
        
        Cell cell3 = row.createCell(2);
        cell3.setCellValue("Name");
        
        Cell cell4 = row.createCell(3);
        cell4.setCellValue("Fther/Husband Name");
        
        Cell cell5 = row.createCell(4);
        cell5.setCellValue("CNIC");
        
        Cell cell6 = row.createCell(5);
        cell6.setCellValue("Area");
        
        Cell cell7 = row.createCell(6);
        cell7.setCellValue("Phone 1");
        
        Cell cell8 = row.createCell(7);
        cell8.setCellValue("Phone 2");
        
        Cell cell9 = row.createCell(8);
        cell9.setCellValue("Raseed 1");
        
        Cell cell10 = row.createCell(9);
        cell10.setCellValue("Care of");
        
        Cell cell11 = row.createCell(10);
        cell11.setCellValue("IOL");
        
        Cell cell12 = row.createCell(11);
        cell12.setCellValue("Gender");
        
        Cell cell13 = row.createCell(12);
        cell13.setCellValue("Age");
        
        Cell cell14 = row.createCell(13);
        cell14.setCellValue("File #");
        
        Cell cell15 = row.createCell(14);
        cell15.setCellValue("Surgrey");
        
        Cell cell16 = row.createCell(15);
        cell16.setCellValue("Surgen");
        
        Cell cell17 = row.createCell(16);
        cell17.setCellValue("Price");
        
        Cell cell18 = row.createCell(17);
        cell18.setCellValue("Advance");
        
        Cell cell19 = row.createCell(18);
        cell19.setCellValue("Discount");
    }
    
}
