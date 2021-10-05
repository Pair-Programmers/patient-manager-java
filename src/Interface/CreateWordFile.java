/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.hpsf.Section;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHeightRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageOrientation;

/**
 *
 * @author mianh
 */
public class CreateWordFile {
    ArrayList<Patient> patientArrayList;
    private FileChooser fc;
    private boolean flag;
    File file;
    
    Injection injection ;

    public CreateWordFile(ArrayList<Patient> patientArrayList) {
        this.patientArrayList = new ArrayList<>();
        injection = new Injection();
        for (int i = 0; i < patientArrayList.size(); i++) {
            if(patientArrayList.get(i).getLab().equals("-ve , -ve") 
                    || patientArrayList.get(i).getLab().equals("None")){
                this.patientArrayList.add(patientArrayList.get(i));
                System.out.println("if : ");
            }
            System.out.println("i : " + i);
        }
        for (int i = 0; i < patientArrayList.size(); i++) {
            if(patientArrayList.get(i).getLab().equals("+ve , +ve") || patientArrayList.get(i).getLab().equals("-ve , +ve")
                    || patientArrayList.get(i).getLab().equals("+ve , -ve")){
                this.patientArrayList.add(patientArrayList.get(i));
                System.out.println("if : ");
            }
            System.out.println("j : " + i);
        }
        fc = new FileChooser();
        file = fc.showSaveDialog(null);
        
        if(file == null){
            flag = false;
        }else{
            flag = true;
        }
        
        if(flag) {
            writeDataonFile();
        }
        
        
        
    }
    
    private void writeDataonFile(){
        XWPFDocument document = new XWPFDocument();
        CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        CTPageMar pageMar = sectPr.addNewPgMar();
        pageMar.setLeft(BigInteger.valueOf(400L));
        pageMar.setRight(BigInteger.valueOf(00L));
        pageMar.setTop(BigInteger.valueOf(200L));
        pageMar.setBottom(BigInteger.valueOf(200L));

        
        XWPFParagraph topHeadingParagraph = document.createParagraph();
        topHeadingParagraph.setAlignment(ParagraphAlignment.CENTER);
        
        XWPFRun runODate = topHeadingParagraph.createRun();
        runODate.setText("Operation Date______________________");
        runODate.addTab();
        runODate.addTab();
        
        XWPFRun runName = topHeadingParagraph.createRun();
        runName.setFontSize(14);
        runName.setBold(true);
        runName.setText("Muhammadi Medical Trust");
        runName.addTab();
        runName.addTab();
        
        XWPFRun runPODate = topHeadingParagraph.createRun();
        runPODate.setText("Post Op Date______________________");
       //runPODate. 
       
        
        XWPFTable table = document.createTable();
        //table.setc
        table.setCellMargins(10, 0, 0, 0);
        table.setWidth(16000);
        
        
        XWPFTableRow row0 = table.getRow(0);
        row0.setHeight(150);
        
        XWPFTableCell cell1 = row0.createCell();
        XWPFTableCell cell2 = row0.createCell();
        XWPFTableCell cell3 = row0.createCell();
        XWPFTableCell cell4 = row0.createCell();
        XWPFTableCell cell5 = row0.createCell();
        XWPFTableCell cell6 = row0.createCell();
        XWPFTableCell cell7 = row0.createCell();
        XWPFTableCell cell8 = row0.createCell();
        XWPFTableCell cell9 = row0.createCell();
        XWPFTableCell cell10 = row0.createCell();
        XWPFTableCell cell11 = row0.createCell();
        XWPFTableCell cell12 = row0.createCell();
        XWPFTableCell cell13 = row0.createCell();
        
        String color = "dcdee0";
        int fontSize = 11;
        boolean bold = true;
        
        XWPFTableCell cell0 = row0.getCell(0);
        cell0.setText("No-Rem");
        cell0.setColor(color);
        
//        cell0.setText(null);
//        XWPFParagraph p0 = cell0.addParagraph();
//        XWPFRun run0 = p0.createRun();
//        run0.setText("No");
//        run0.setBold(bold);
//        run0.setFontSize(fontSize);
        
        //cell0.addParagraph(p0);
        
        cell1.setText("Name S/O W/O D/O");
        cell1.setColor(color);
//        XWPFParagraph p1 = cell1.addParagraph();
//        XWPFRun run1 = p1.createRun();
//        run1.setText("Name S/O W/O D/O");
//        run1.setBold(bold);
//        run1.setFontSize(fontSize);
        
        cell2.setText("Age/G");
        cell2.setColor(color);
//        XWPFParagraph p2 = cell2.addParagraph();
//        XWPFRun run2 = p2.createRun();
//        run2.setText("Age/G");
//        run2.setBold(bold);
//        run2.setFontSize(fontSize);
        
        cell3.setText("Reg #");
        cell3.setColor(color);
//        XWPFParagraph p3 = cell3.addParagraph();
//        XWPFRun run3 = p3.createRun();
//        run3.setText("Reg #");
//        run3.setBold(bold);
//        run3.setFontSize(fontSize);
        
        cell4.setText("Fold/ PCIOL");
        cell4.setColor(color);
//        XWPFParagraph p4 = cell4.addParagraph();
//        XWPFRun run4 = p4.createRun();
//        run4.setText("Fold/ PCIOL");
//        run4.setBold(bold);
//        run4.setFontSize(fontSize);
        
        cell5.setText("L/R");
        cell5.setColor(color);
//        XWPFParagraph p5 = cell5.addParagraph();
//        XWPFRun run5 = p5.createRun();
//        run5.setText("L/R");
//        run5.setBold(bold);
//        run5.setFontSize(fontSize);
        
        cell6.setText("Power IOL");
        cell6.setColor(color);
//        XWPFParagraph p6 = cell6.addParagraph();
//        XWPFRun run6 = p6.createRun();
//        run6.setText("Power IOL");
//        run6.setBold(bold);
//        run6.setFontSize(fontSize);
        
        cell7.setText("C/ Type");
        cell7.setColor(color);
//        XWPFParagraph p7 = cell7.addParagraph();
//        XWPFRun run7 = p7.createRun();
//        run7.setText("C/ Type");
//        run7.setBold(bold);
//        run7.setFontSize(fontSize);
        
        cell8.setText("Lab +-");
        cell8.setColor(color);
//        XWPFParagraph p8 = cell8.addParagraph();
//        XWPFRun run8 = p8.createRun();
//        run8.setText("Lab +-");
//        run8.setBold(bold);
//        run8.setFontSize(fontSize);
        
        cell9.setText("V.A");
        cell9.setColor(color);
//        XWPFParagraph p9 = cell9.addParagraph();
//        XWPFRun run9 = p9.createRun();
//        run9.setText("V.A");
//        run9.setBold(bold);
//        run9.setFontSize(fontSize);
        
        cell10.setText("Ref.");
        cell10.setColor(color);
//        XWPFParagraph p10 = cell10.addParagraph();
//        XWPFRun run10 = p10.createRun();
//        run10.setText("Ref.");
//        run10.setBold(bold);
//        run10.setFontSize(fontSize);
        
        cell11.setText("Phone #");
        cell11.setColor(color);
//        XWPFParagraph p11 = cell11.addParagraph();
//        XWPFRun run11 = p11.createRun();
//        run11.setText("Phone #");
//        run11.setBold(bold);
//        run11.setFontSize(fontSize);
        
        cell12.setText("Date");
        cell12.setColor(color);
//        XWPFParagraph p12 = cell12.addParagraph();
//        XWPFRun run12 = p12.createRun();
//        run12.setText("Date");
//        run12.setBold(bold);
//        run12.setFontSize(fontSize);


        cell13.setText("Remarks-----------");
        cell13.setColor(color);
//        XWPFParagraph p13 = cell13.addParagraph();
//        XWPFRun run13 = p13.createRun();
//        run13.setText("Date");
//        run13.setBold(bold);
//        run13.setFontSize(fontSize);
        
        ArrayList<XWPFTableRow> rowArrayList = new ArrayList<>();
        XWPFTableRow row;
        XWPFTableCell cell;
        String tempLab = "";
        String tempDate = "";
        String year = "";
        String month = "";
        String day = "";
        
        
        
        for (int i = 0; i < this.patientArrayList.size(); i++) {
            row = table.createRow();
            row.setHeight(70);
            rowArrayList.add(row);
            try{
                //JOptionPane.showMessageDialog(null, patientArrayList.get(i).getRecieptNumber());
                injection = Injection.getInjectionName(patientArrayList.get(i).getRecieptNumber());
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "exc");
            }
            cell = row.getCell(0);
            if(injection != null){
                cell.setText(String.valueOf(i+1) + "-" + String.valueOf((injection.getPrice() - patientArrayList.get(i).getDiscount() - patientArrayList.get(i).getAdvane())));
            } else{    
                cell.setText(String.valueOf(i+1) + "-");
            }
            
            cell = row.getCell(1);
            if(patientArrayList.get(i).getLab().equals("+ve , +ve") || patientArrayList.get(i).getLab().equals("-ve , +ve") || patientArrayList.get(i).getLab().equals("+ve , -ve")){
                cell.setText("*"+patientArrayList.get(i).getName() +  " /"+ patientArrayList.get(i).getFatherHusbandName());
            }
            else{
                cell.setText(patientArrayList.get(i).getName() +  " /"+ patientArrayList.get(i).getFatherHusbandName());
            }
            
            
            cell = row.getCell(2);
            cell.setText(String.valueOf(patientArrayList.get(i).getAge()) + "/" +patientArrayList.get(i).getCompany());
            
            cell = row.getCell(3);
            cell.setText(patientArrayList.get(i).getRegNumber());
            
            cell = row.getCell(4);
            cell.setText(patientArrayList.get(i).getFoldPCIOL());
            
            
            cell = row.getCell(5);
            cell.setText(patientArrayList.get(i).getSurgrey());
            
            cell = row.getCell(6);
            cell.setText(patientArrayList.get(i).getRowIO2());
            
            cell = row.getCell(7);
            cell.setText(patientArrayList.get(i).getNewCompany());
            
            cell = row.getCell(8);
            switch(patientArrayList.get(i).getLab()){
                case "None":
                    cell.setText("None");
                    break;
                case "+ve , -ve":
                    cell.setText("+v-v");
                    break;
                case "-ve , +ve":
                    cell.setText("-v+v");
                    break;
                case "+ve , +ve":
                    cell.setText("+v+v");
                    break;
                case "-ve , -ve":
                    cell.setText("-v-v");
                    break;
                default:

            }
            
            
            
            
            cell = row.getCell(9);
            cell.setText(patientArrayList.get(i).getVa());
            
            cell = row.getCell(10);
            cell.setText(patientArrayList.get(i).getReferanceDr());
            
            cell = row.getCell(11);
            cell.setText(patientArrayList.get(i).getPhone1());
            
            tempDate = patientArrayList.get(i).getDate();
            year = tempDate.substring(0, 4);
            month = tempDate.substring(5, 7);
            day = tempDate.substring(8, 10);
            
            cell = row.getCell(12);            
            cell.setText(day+"/"+month+"/"+year);
            
        }
        
        
        XWPFParagraph bottompP= document.createParagraph();
        
        XWPFRun runbottompP = bottompP.createRun();
        runbottompP.addBreak();
        runbottompP.addBreak();
        runbottompP.setText("OTA ______________");
        runbottompP.addTab();
        runbottompP.addTab();
        runbottompP.setText("Surgen / Dr _______________");
        runbottompP.addTab();
        runbottompP.addTab();
        runbottompP.addTab();
        runbottompP.setText("Post-Operative Consultant________________");
        runbottompP.addTab();
        runbottompP.addTab();
        runbottompP.setText("Stamp___________");
        runbottompP.setFontSize(12);
        
        runbottompP.addBreak();        
        runbottompP.addBreak();
        runbottompP.setText("Before starting surgery i have observed the system and procedure of sterlization regarding theater/articles involved in surgery and found satisfactory.");
        runbottompP.addBreak();
        runbottompP.setText("Dr Ashal Paal.  Eye Surgeon.");

        
        //setting orientation to portrait
        CTSectPr section = document.getDocument().getBody().addNewSectPr();
        CTBody body = document.getDocument().getBody();
        
        if(!body.isSetSectPr()){
            body.addNewSectPr();
        }
        
        if(!section.isSetPgSz()){
            section.addNewPgSz();
        }

        CTPageSz pageSize = section.getPgSz();
        pageSize.setOrient(STPageOrientation.LANDSCAPE);
        //A4 = 595x842 / multiply 20 since BigInteger represents 1/20 Point
        pageSize.setW(BigInteger.valueOf(16840));
        pageSize.setH(BigInteger.valueOf(11900));
        //end 
        
        try{
            
            //file = new File("create_table.docx");
            FileOutputStream output = new FileOutputStream(file + ".docx");
            document.write(output);
            output.close();
        } catch (IOException e) {
            
        }
        //Desktop.getDesktop().print(new File("C:\\Users\\mianh\\Desktop\\My CV.docx"));
      
   }
}
