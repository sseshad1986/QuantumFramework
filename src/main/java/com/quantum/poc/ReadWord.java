package com.quantum.poc;

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
			      
			document = new XWPFDocument(fis);
						
			// Get values from Tables
			int tableCount=countOfTables(document);
			System.out.println(tableCount);				
			
			printTable(document);
			
			//printParaf(document);
		} 
		catch (Exception e) {
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
	
	public static int countOfTables(XWPFDocument document)
	{
		int tableCount=0;
		tableCount=document.getTables().size();		
		return tableCount;		
	}
	
	public static int countOfPara(XWPFDocument document)
	{
		int paraCount=0;
		List<XWPFParagraph> paragraphs = document.getParagraphs();
		
		paraCount=+paragraphs.size();		
		return paraCount;			
	}
	
	public static void printParaf(XWPFDocument document)
	{		
		List<XWPFParagraph> paragraphs = document.getParagraphs();
		
		System.out.println("Total no of paragraph "+paragraphs.size());
		for (XWPFParagraph para : paragraphs) {
			System.out.println(para.getText());
		}		
	}	
	
	public static void printTable(XWPFDocument document)
	{		
		try 
		{
			List<XWPFTable> tables = document.getTables();
			int tableCount=tables.size();
			for(int i=0;i<=tableCount-1;i++)
			{
				int tableNum=i+1;
				XWPFTable table = tables.get(i);
				int rowsize=table.getNumberOfRows();
				int colsize=0;
				
				System.out.println("##### TABLE - "+ tableNum + " #####");
				for(int rowNum=0;rowNum<=rowsize-1;rowNum++)
				{
					colsize=table.getRows().get(1).getTableICells().size();
					
					for(int colNum=0;colNum<=colsize-1;colNum++)
					{
						String cellData=null;
						if(table.getRows().get(rowNum).getCell(colNum)!=null)
							cellData=table.getRows().get(rowNum).getCell(colNum).getText();
						
						if(cellData==null)
						{
							cellData="NA";							
						}						
						else if(!cellData.isEmpty())
						{							
							System.out.print(table.getRows().get(rowNum).getCell(colNum).getText().trim());
							System.out.print("\t");								
						}
						else if(cellData.isEmpty()||cellData=="")
						{
							if(colsize>1)
							{
								for(int prev=rowNum-1;prev>0;prev--)
								{
									String prevText="";
									prevText=table.getRows().get(prev).getCell(colNum).getText();
									if(table.getRows().get(prev).getCell(colNum)!=null && !prevText.isEmpty())
									{
										if(!table.getRows().get(rowNum).getCell(1).getText().equalsIgnoreCase("Sub-Total"))
										{
											System.out.print(table.getRows().get(prev).getCell(colNum).getText().trim());
											System.out.print("\t");	
											break;
										}
										else
										{
											System.out.print("\t");
											System.out.print("\t");
											break;
										}
									}
								}
							}																					
						}							
					}
					System.out.println("\n");
					if(rowNum==0)
						System.out.println("-------------------------------------------------");
					
				}			
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
}
