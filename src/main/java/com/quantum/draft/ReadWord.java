package com.quantum.draft;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class ReadWord {

	public static void main(String[] args) throws IOException 
	{
		XWPFDocument document=null;
		InputStream fis=null;
	
		try {
			// TODO Auto-generated method stub
			String lstr_wordFilePath = System.getProperty("user.dir") 
					+ "\\src\\main\\java\\com\\quantum\\draft\\Asset Mandate - AIA Hong Kong Par Fund.docx";	

			fis = new FileInputStream(lstr_wordFilePath);
			//POIFSFileSystem fs = new POIFSFileSystem(fis);
      
			document = new XWPFDocument(fis);
			
//			XWPFWordExtractor extractor = new XWPFWordExtractor(document);
//			System.out.println("The Contents of the Word File are ::");
//			System.out.println("--------------------------------------"); 
//			System.out.println(extractor.getText());
			
			// Tables
			List<XWPFTable> tables = document.getTables();
			//System.out.println(tables.size());
			XWPFTable table = tables.get(3);
			
			System.out.println(table.getRows().get(1).getCell(1).getText());
			System.out.println(table.getRows().get(1).getCell(2).getText());
			System.out.println(table.getRows().get(1).getCell(3).getText());
			System.out.println(table.getRows().get(1).getCell(4).getText());
			
			System.out.println(table.getRows().get(2).getCell(1).getText());
			System.out.println(table.getRows().get(2).getCell(2).getText());
			System.out.println(table.getRows().get(2).getCell(3).getText());
			System.out.println(table.getRows().get(2).getCell(4).getText());
			
			//This method only captures paragraph !
//			List<XWPFParagraph> paragraphs = document.getParagraphs();
//						
//			for(int i=0;i<paragraphs.size();i++)
//			{
//			    System.out.println(paragraphs.get(i).getText());			    
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if (document != null) {
					document.close();
				}
				if (fis != null) {
					fis.close();
				}
			}
			catch (Exception ex) 
			{
			}
		}	
	}
}
