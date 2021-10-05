///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Interface;
//
///**
// *
// * @author mianh
// */
//import java.awt.print.PageFormat;
//import java.awt.print.Paper;
//
//
//import org.apache.pdfbox.pdmodel.PDDocument;    
//
//public class Print {
//    public static void main(String[] args) {
//        Paper paper = new Paper();
//       
//        System.out.println("P h: " + paper.getHeight());
//        System.out.println("P w: " + paper.getWidth());
//        
//        //paper.setImageableArea(10, 10, 602, 782);
//        System.out.println("");
//        
//        System.out.println("P imageAbleH: " + paper.getImageableHeight());
//        System.out.println("P imageAbleW: " + paper.getImageableWidth());
//        
//        System.out.println("");
//        
//        System.out.println("P imageAbleX: " + paper.getImageableX());
//        System.out.println("P imageAbleY: " + paper.getImageableY());
//
//        System.out.println("?/////////////////////");
//        
//        PageFormat pageFormat = new PageFormat();
//        System.out.println("");
//        System.out.println("Pf h: " + pageFormat.getHeight());
//        System.out.println("Pf w: " + pageFormat.getWidth());
//        System.out.println("");
//        //paper.setImageableArea(10, 10, 602, 782);
//        
//        System.out.println("Pf imageAbleH: " + pageFormat.getImageableHeight());
//        System.out.println("Pf imageAbleW: " + pageFormat.getImageableWidth());
//        System.out.println("");
//        System.out.println("Pf imageAbleX: " + pageFormat.getImageableX());
//        System.out.println("Pf imageAbleY: " + pageFormat.getImageableY());
//        
//        Paper paper1 = pageFormat.getPaper();
//        paper1.setSize(211.50, 67.50);
//        paper1.setImageableArea(5, 5, 206.5, 62.5);
//        System.out.println("P1 h: " + paper1.getHeight());
//        System.out.println("P1 w: " + paper1.getWidth());
//        
//        //paper.setImageableArea(10, 10, 602, 782);
//        System.out.println("");
//        
//        System.out.println("P1 imageAbleH: " + paper1.getImageableHeight());
//        System.out.println("P1 imageAbleW: " + paper1.getImageableWidth());
//        
//        System.out.println("");
//        
//        System.out.println("P1 imageAbleX: " + paper1.getImageableX());
//        System.out.println("P1 imageAbleY: " + paper1.getImageableY());
//        
//        pageFormat.setPaper(paper1);
//        pageFormat.setOrientation(pageFormat.getOrientation());
//        
//        System.out.println("after setting paper to pageformat");
//        System.out.println("orientation value : " + pageFormat.PORTRAIT);
//        System.out.println("Pf h: " + pageFormat.getHeight());
//        System.out.println("Pf w: " + pageFormat.getWidth());
//        System.out.println("");
//        //paper.setImageableArea(10, 10, 602, 782);
//        
//        System.out.println("Pf imageAbleH: " + pageFormat.getImageableHeight());
//        System.out.println("Pf imageAbleW: " + pageFormat.getImageableWidth());
//        System.out.println("");
//        System.out.println("Pf imageAbleX: " + pageFormat.getImageableX());
//        System.out.println("Pf imageAbleY: " + pageFormat.getImageableY());
//    }
//}
