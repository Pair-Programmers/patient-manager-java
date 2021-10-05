/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author mianh
 */
import java.awt.*;  
import java.awt.print.*;  
import java.io.*; 
 
public class PrintListing  
{    
  public static void main(String[] args)  
  {      
    // Get a PrinterJob 
    PrinterJob job = PrinterJob.getPrinterJob(); 
    // Ask user for page format (e.g., portrait/landscape) 
    PageFormat pf = job.pageDialog(job.defaultPage()); 
    // Specify the Printable is an instance of 
    // PrintListingPainter; also provide given PageFormat 
    job.setPrintable(new PrintListingPainter("C:\\Users\\mianh\\Desktop\\My CV.pdf"), pf); 
    // Print 1 copy    
    job.setCopies(1);      
    // Put up the dialog box      
    if (job.printDialog())  
    { 
      // Print the job if the user didn't cancel printing 
      try { job.print(); } 
      catch (Exception e) { /* handle exception */ }      
    }      
    System.exit(0);    
  }  
} 
 
class PrintListingPainter implements Printable  
{ 
  private RandomAccessFile raf;    
  private String fileName;    
  private Font fnt = new Font("Helvetica", Font.PLAIN, 10); 
  private int rememberedPageIndex = -1;    
  private long rememberedFilePointer = -1;    
  private boolean rememberedEOF = false; 
   
  public PrintListingPainter(String file)  
  {  
    fileName = file;      
    try 
    {  
      // Open file       
      raf = new RandomAccessFile(file, "r");      
    }  
    catch (Exception e) { rememberedEOF = true; }    
  } 
 
  public int print(Graphics g, PageFormat pf, int pageIndex) 
  throws PrinterException  
  { 
  try  
  {  
    // For catching IOException      
    if (pageIndex != rememberedPageIndex)  
    {  
      // First time we've visited this page 
      rememberedPageIndex = pageIndex;   
      // If encountered EOF on previous page, done  
      if (rememberedEOF) return Printable.NO_SUCH_PAGE; 
      // Save current position in input file 
      rememberedFilePointer = raf.getFilePointer(); 
    }  
    else raf.seek(rememberedFilePointer); 
    g.setColor(Color.black);      
    g.setFont(fnt);  
        int x = (int) pf.getImageableX() + 10; 
        int y = (int) pf.getImageableY() + 12;     
    // Title line      
    g.drawString("File: " + fileName + ", page: " +                                          (pageIndex+1),  x, y); 
    // Generate as many lines as will fit in imageable area 
    y += 36; 
    while (y + 12 < pf.getImageableY()+pf.getImageableHeight()) 
    { 
      String line = raf.readLine(); 
      if (line == null) 
      {  
        rememberedEOF = true; 
        break;  
                } 
        g.drawString(line, x, y);  
        y += 12;      
      } 
      return Printable.PAGE_EXISTS;     
    }  
    catch (Exception e) { return Printable.NO_SUCH_PAGE;} 
  }  
} 