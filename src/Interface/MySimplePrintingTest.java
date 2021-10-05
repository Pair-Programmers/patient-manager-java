/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.*;
/**
 *
 * @author mianh
 */
public class MySimplePrintingTest implements Printable {
    
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int page)throws PrinterException{
        
        if(page > 0){
            
            System.out.println("imageable X ewtes: " + page +"//"+ pageFormat.getImageableWidth());
            return NO_SUCH_PAGE;
            
        }
        
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.translate(5, 5);
        System.out.println("imageable X : " + pageFormat.getImageableWidth());
        System.out.println("imageable Y : " + pageFormat.getImageableHeight());
        graphics2D.drawString("heeeeeloo printer my printer is the best printer in the world!", 5, 5);
        
        
        
        return PAGE_EXISTS;
    }
    
    public static void main(String[] args) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(new MySimplePrintingTest());
        
        //boolean doPrint = printerJob.printDialog();
        Paper paper = new Paper();
        double width = 211.50;
        double height = 67.50; 
        paper.setSize(width, height);
        paper.setImageableArea(5, 5, width-5, height-5);
        
        PageFormat pageFormat = new PageFormat();
        pageFormat.setPaper(paper);
        pageFormat.setOrientation(pageFormat.PORTRAIT);
           
        
        System.out.println("after setting paper to pageformat");
        System.out.println("orientation value : " + pageFormat.PORTRAIT);
        System.out.println("Pf h: " + pageFormat.getHeight());
        System.out.println("Pf w: " + pageFormat.getWidth());
        System.out.println("");
        //paper.setImageableArea(10, 10, 602, 782);
        
        System.out.println("Pf imageAbleH: " + pageFormat.getImageableHeight());
        System.out.println("Pf imageAbleW: " + pageFormat.getImageableWidth());
        System.out.println("");
        System.out.println("Pf imageAbleX: " + pageFormat.getImageableX());
        System.out.println("Pf imageAbleY: " + pageFormat.getImageableY());
        
        
        if(true) {
            try {
                printerJob.print();
            } catch (PrinterException e) {
                //
            }
        }
    }
    
    
}
