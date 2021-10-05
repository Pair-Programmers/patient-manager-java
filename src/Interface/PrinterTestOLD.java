/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mianh
 */
public class PrinterTestOLD implements Printable{

    private String[] array1, array2;
    
    private int noOfCopies;
    
    public PrinterTestOLD() {
        array1 = new String[24];
        
    }
    
    
    
    public void generatePaperWithData(Patient patient, int noOfCopies) {
        
        this.noOfCopies = noOfCopies;
        
        array1[0] = String.valueOf(patient.getId());
        array1[1] = patient.getFileNumber();
        array1[2] = patient.getRaseed1();
        array1[3] = patient.getRaseed2();
        array1[4] = patient.getRowIO2();
        array1[5] = String.valueOf(patient.getAge());
        array1[6] = patient.getCompany();//now gender/sex
        array1[7] = patient.getSurgrey();
        
        array1[8] = patient.getName();
        array1[9] = patient.getFatherHusbandName();
        array1[10] = patient.getArea();
        array1[11] = patient.getPhone1();
        array1[12] = patient.getPhone2();
        array1[13] = patient.getCnic();
        array1[14] = patient.getCo();
        
        array1[15] = String.valueOf(patient.getRecieptNumber());//now price
        array1[16] = String.valueOf(patient.getDiscount());
        array1[17] = String.valueOf(patient.getRecieptNumber() - patient.getDiscount() - patient.getAdvane());// T 1
        array1[18] = String.valueOf(patient.getAdvane());
        array1[19] = patient.getSurgen();
        array1[20] = patient.getReferanceDr();
        array1[21] = patient.getLab();
        array1[22] = patient.getVa();
        array1[23] = patient.getFoldPCIOL();
        
        PrinterJob pj = PrinterJob.getPrinterJob();
        
        if (true) {
            //System.out.println("start of dilog if");
            PageFormat pf = new PageFormat();
            Paper paper = new Paper();
            double width = 500;
            double height = 100;    
            paper.setSize(width, height);
            paper.setImageableArea(5,5, width-5, height-5);                
               
            //pf.setOrientation(PageFormat.PORTRAIT);
            pf.setPaper(paper);  
            
            //PageFormat validatePage = pj.validatePage(pf);
            //System.out.println("Valid- " + dump(validatePage));                
            //Book book = new Book();
            //book.append(new MyPrintable(), pf);
            //pj.setPageable(book);    
            
            pj.setPrintable(this, pf);
            try {
                
                pj.print();
                
            } catch (PrinterException ex) {
                
                Logger.getLogger(PrinterTestOLD.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        }
    }
    
    

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        
        
                        
        int result = NO_SUCH_PAGE;    
        if (pageIndex < noOfCopies) {
            
            Graphics2D g2d = (Graphics2D) graphics;                    
                                
            double width = pageFormat.getImageableWidth();
            double height = pageFormat.getImageableHeight();

            //useless i think .. 
            //g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());                    
            
            //for drawing border
            //g2d.draw(new Rectangle2D.Double(1, 1, width - 1, height - 1));                    
            FontMetrics fm = g2d.getFontMetrics();
            
            Font font = new Font("Verdana", Font.BOLD, 7);
            g2d.setFont(font);
            
            
            

            int x = 50, y = fm.getAscent()-2;//, inc = 10, inc2 = 18;
            //int inc3 = inc2 + 40;
                          //1234567*90123456789012345678901234567
                          
        
            int col1 = 0, inc1 = 7;              
            g2d.drawString("ID", x, y + col1);col1+=inc1;
            g2d.drawString("File", x, y + col1);col1+=inc1;
            g2d.drawString("RS1", x, y + col1);col1+=inc1;
            g2d.drawString("RS2", x, y + col1);col1+=inc1;
            g2d.drawString("IOL", x, y + col1);col1+=inc1;
            //g2d.drawString("AGE", x, y + col1);col1+=inc1;
            //g2d.drawString("SEX", x, y + col1);col1+=inc1;
            g2d.drawString("SRG", x, y + col1);col1+=inc1;
            g2d.drawString("Care of : ", x, y + col1);col1+=inc1;
            g2d.drawString("FPCIOL : ", x, y + col1);col1+=inc1;
            g2d.drawString("Lab : ", x, y + col1);
            
            
            col1 = 0;
            int inc2 = 20;
            g2d.drawString(": ", x + inc2, y + col1);col1+=inc1;
            g2d.drawString(": ", x + inc2, y + col1);col1+=inc1;
            g2d.drawString(": ", x + inc2, y + col1);col1+=inc1;
            g2d.drawString(": ", x + inc2, y + col1);col1+=inc1;
            g2d.drawString(": ", x + inc2, y + col1);col1+=inc1;
            //g2d.drawString(": ", x + inc2, y + col1);col1+=inc1;
            //g2d.drawString(": ", x + inc2, y + col1);col1+=inc1;
            g2d.drawString(": ", x + inc2, y + col1);
            
            col1 = 0;
            inc2 = 28;
            g2d.drawString(array1[0], x + inc2, y + col1);col1+=inc1;//id
            g2d.drawString(array1[1], x + inc2, y + col1);col1+=inc1;//file
            g2d.drawString(array1[2], x + inc2, y + col1);col1+=inc1;//rs1
            g2d.drawString(array1[3], x + inc2, y + col1);col1+=inc1;//rs22
            g2d.drawString(array1[4], x + inc2, y + col1);col1+=inc1;//IOL
            //g2d.drawString(array1[5], x + inc2, y + col1);col1+=inc1;//age
            //g2d.drawString(array1[6], x + inc2, y + col1);col1+=inc1;//sex
            g2d.drawString(array1[7]+"-"+array1[19], x + inc2, y + col1);col1+=inc1;//srgy
            col1+=inc1;
            g2d.drawString(array1[23], x + inc2 + 20, y + col1);col1+=inc1;//fold pc iol
            if(!array1[21].equals("None")){
                g2d.drawString(array1[21], x + inc2, y + col1);col1+=inc1;//lab
            }
            
            col1 = 0;
            inc2 = 60;
            g2d.drawString(array1[8] + "   " + array1[5] + "/" + array1[6], x + inc2, y + col1);col1+=inc1;//name
            g2d.drawString(array1[9], x + inc2, y + col1);col1+=inc1;//father name
            g2d.drawString(array1[10], x + inc2, y + col1);col1+=inc1;//area
            g2d.drawString(array1[11], x + inc2, y + col1);col1+=inc1;//phone 1
            g2d.drawString(array1[12], x + inc2, y + col1);col1+=inc1;//phone 2
            g2d.drawString(array1[13], x + inc2, y + col1);col1+=inc1;//cnic
            g2d.drawString(array1[14], x + inc2 - 20, y + col1);col1+=inc1;//co
            g2d.drawString("V.A : ", x + inc2+35, y + col1);
            g2d.drawString(array1[22], x + inc2 + 60, y + col1);col1+=inc1;//va
            g2d.drawString("Ref Dr : ", x + inc2+25, y + col1);
            g2d.drawString(array1[20], x + inc2 + 60, y + col1);col1+=inc1;// ref DR
            
            col1 = 0;
            inc2 = 160;
            g2d.drawString("", x + inc2-18, y + col1);col1+=inc1;
            g2d.drawString("D 1", x + inc2, y + col1);col1+=inc1;
            g2d.drawString("Adv", x + inc2, y + col1);col1+=inc1;
            g2d.drawString("B 1", x + inc2, y + col1);col1+=inc1;
            g2d.drawString("D 2", x + inc2, y + col1);col1+=inc1;
            g2d.drawString("D 3", x + inc2, y + col1);col1+=inc1;
            g2d.drawString("B 2", x + inc2, y + col1);col1+=inc1;
            
            
            col1 = 0;
            inc2 = 175;
            g2d.drawString("  ", x + inc2, y + col1);col1+=inc1;
            g2d.drawString(": ", x + inc2, y + col1);col1+=inc1;
            g2d.drawString(": ", x + inc2, y + col1);col1+=inc1;
            g2d.drawString(": ", x + inc2, y + col1);col1+=inc1;
            g2d.drawString(": ", x + inc2, y + col1);col1+=inc1;
            g2d.drawString(": ", x + inc2, y + col1);col1+=inc1;
            g2d.drawString(": ", x + inc2, y + col1);col1+=inc1;
            
            
            col1 = 0;
            inc2 = 180;
            g2d.drawString(array1[15], x + inc2, y + col1);col1+=inc1;//price
            g2d.drawString(array1[16], x + inc2, y + col1);col1+=inc1;//discount
            g2d.drawString(array1[18], x + inc2, y + col1);col1+=inc1;//advance
            g2d.drawString(array1[17], x + inc2, y + col1);col1+=inc1;//balance
            g2d.drawString("", x + inc2, y + col1);col1+=inc1;
            g2d.drawString("", x + inc2, y + col1);col1+=inc1;
            g2d.drawString("   +", x + inc2, y + col1);col1+=inc1;
            //g2d.drawString("", x + inc2, y + col1);col1+=inc1;
            
            //JOptionPane.showMessageDialog(null, g2d);
            result = PAGE_EXISTS;
            
        } 
        
        return result;    
    }
    
}
