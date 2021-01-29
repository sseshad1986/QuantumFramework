package com.quantum.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class PDFManager extends PdfPageEventHelper
{
	static Document document;
	static PdfWriter writer;
	
	static SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HHmmss");
	static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	static String randomData="Pdf_Report-" + sdf.format(timestamp);
	
	
	public static String createFolder()
	{		
		String lstr_pdfPath=System.getProperty("user.dir" + "\\PDF_AutomationReport-\\" + randomData);
		System.out.println("user.dir" + "\\PDF_AutomationReport\\" + randomData);

		File dir = new File(lstr_pdfPath);
		
		if (!dir.exists())
		{			
			dir.mkdirs();
			System.out.println("Folder is created succesfully : " + dir);
		}
		else
		{
			dir.mkdirs();
			System.out.println("Folder is added succesfully : " + dir);
		}
		return lstr_pdfPath;
		
	}
	
	public static void createPDF(String pdfPath) throws FileNotFoundException, DocumentException
	{	
		 // create document
		document=new Document();
		System.out.println("The PDF file name is  :" + pdfPath + BaseClass.getRandomTimestampData()  + ".pdf");
		
		writer = PdfWriter.getInstance(document, new FileOutputStream(new File(pdfPath + BaseClass.getRandomTimestampData() + ".pdf")));		
		
		document.open();		
	}	
	
	public static void setFileAttribute() 
	{
		document.addAuthor("Automated by BOT");
	    document.addCreationDate();
	    document.addCreator("nFlows Automation Testing");
	    document.addTitle("Report - nFlows Automation Testing");
	    document.addSubject("This report is generated for nFlows regression !");
	}
	
	public static void setBorder() throws DocumentException 
	{
		 Rectangle rect= new Rectangle(577,825,18,15); // you can resize rectangle 
	     rect.enableBorderSide(1);
	     rect.enableBorderSide(2);
	     rect.enableBorderSide(4);
	     rect.enableBorderSide(8);
	     rect.setBorderColor(BaseColor.BLACK);
	     rect.setBorderWidth(1);
	     document.add(rect);
	}
	
	public static void creatCoverPage() throws DocumentException, MalformedURLException, IOException 
	{	 
		
		 String lstr_imagepath =System.getProperty("user.dir") + "/src/main/java/com/quantum/image";
		 document.open();
 
		 Font font= new Font(FontFamily.COURIER, 24, Font.BOLD, BaseColor.BLUE);	 
		 
		 Paragraph p = new Paragraph(100);        
         Image image0 = Image.getInstance(lstr_imagepath + "\\nFlows-logo.png");
         image0.scalePercent(70);     
         
         p.add(new Chunk(image0, 6, -6));
         p.add(new Chunk(" Automation Report",font));
         
         document.add(p); 
         document.add(new Paragraph("\n\n"));
		 LineSeparator objectName = new LineSeparator();              
		 document.add(objectName);		 
		 
		 Image image = Image.getInstance(lstr_imagepath + "\\login_illustration.png");
		 
		 image.setBorder(Rectangle.BOX);     
		 image.setBorderWidth(3);
	 
		 image.scaleToFit(PageSize.A4.getWidth()-120, PageSize.A4.getHeight()+550);
		 float x = (PageSize.A4.getWidth() - image.getScaledWidth()) / 2;
		 float y = (PageSize.A4.getHeight() - image.getScaledHeight()) / 2;
		 image.setAbsolutePosition(x, y);		    

		 document.add(image);
		 document.newPage();
	}
	
	public static void setTables() throws DocumentException 
	{
		    document.open();		           
	        PdfPTable table = new PdfPTable(3); // 3 columns.
	        table.setWidthPercentage(100); //Width 100%
	        table.setSpacingBefore(10f); //Space before table
	        table.setSpacingAfter(10f); //Space after table
	 
	        //Set Column widths
	        float[] columnWidths = {1f, 1f, 1f};
	        table.setWidths(columnWidths);
	 
	        PdfPCell cell1 = new PdfPCell(new Paragraph("nFlows"));
	        cell1.setBorderColor(BaseColor.BLUE);
	        cell1.setPaddingLeft(10);
	        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell2 = new PdfPCell(new Paragraph("AUTOMATION"));
	        cell2.setBorderColor(BaseColor.GREEN);
	        cell2.setPaddingLeft(10);
	        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell3 = new PdfPCell(new Paragraph("REPORT"));
	        cell3.setBorderColor(BaseColor.RED);
	        cell3.setPaddingLeft(10);
	        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        table.addCell(cell1);
	        table.addCell(cell2);
	        table.addCell(cell3);
	 
	        document.add(table);
	        document.add(new Paragraph("\n\n"));
	}
	
	public static void addImage(ArrayList<String> larl_list) throws DocumentException, MalformedURLException, IOException
	{
		document.open();
		
		for(String file : larl_list)
		{
			String lstr_latestScreenPath= file.replace("\\", "~");
			String lstr_screenPath[]=lstr_latestScreenPath.split("~");
			String lstr_content[]=lstr_screenPath[lstr_screenPath.length-1].split("\\.");
					
			Font darkGrayFont=null;
			if(lstr_content[0].contains("Fail"))
			{
				darkGrayFont= new Font(FontFamily.COURIER, 12, Font.BOLD, BaseColor.RED);
			}
			else
			{
				darkGrayFont= new Font(FontFamily.COURIER, 12, Font.BOLD, BaseColor.BLUE);
			}
		    
		    // Create a Simple table
		 	PdfPTable table = new PdfPTable(1);
		  
		 	// Set First row as header
		 	table.setHeaderRows(1);
		 	// Add header details
		 	
		 	Phrase phrase = new Phrase();
		 	
		 	String lstr_testStep = lstr_content[0].substring(0, lstr_content[0].length() - 20);
		 	
		 	Chunk underline = new Chunk("Test Step : " + lstr_testStep,darkGrayFont);
			underline.setUnderline(0.1f, -2f); 
			
			phrase.add(underline);
		 	table.addCell( phrase);	 	 	
		  
		 	Image image = Image.getInstance(file);
		 	
		 	image.setAlignment(Image.MIDDLE);
		 	
		 	float docW = PageSize.A4.getWidth() - 10 * PageSize.A4.getBorder();
			float docH = PageSize.A4.getHeight() - 10 * PageSize.A4.getBorder();
			// fit the image to the page -old 40
			image.scaleToFit(docW-35, docH);	
			image.setAbsolutePosition(500f, 650f);
			
		 	table.addCell(image);
		 	
		 	document.add(new Paragraph("\n\n"));
		 	
		 	document.add(table); 		
		}	    
	}	 
	
	public static void closePDF()
	{
		 try 
		 {			 
			 
			document.close();
			writer.close();
		 } 
		 catch (Exception e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	}	
	
	
	
}
