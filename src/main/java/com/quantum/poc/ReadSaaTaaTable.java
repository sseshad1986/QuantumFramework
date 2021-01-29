package com.quantum.poc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class ReadSaaTaaTable {

	public static void main(String[] args) throws IOException 
	{
		LinkedHashMap<Integer, Map<String, String>> map =GetSaaTaaTable(System.getProperty("user.dir") + "\\src\\main\\java\\com\\quantum\\poc\\Asset Mandate - AIA Hong Kong Par Fund.docx");
		//Print LinkedHashMap
		for(Map.Entry<Integer,Map<String,String>> entry : map.entrySet())
			System.out.println(entry.toString());
	}
	public static LinkedHashMap<Integer, Map<String, String>> GetSaaTaaTable(String FileName)
	{
		XWPFDocument document=null;
		List<XWPFTable> tables;
		XWPFTable table;
		InputStream fis=null;
		//String lstr_wordFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\quantum\\poc\\Asset Mandate - AIA Hong Kong Par Fund.docx";
		String lvl1 = "",lvl2 = "";
		String key,value;
		int headerrow = 0;
		LinkedHashMap<Integer, Map<String, String>> map =new LinkedHashMap<Integer,Map<String, String>>();
		Map<String, String> submap;
		
		try {
			fis = new FileInputStream(FileName);      
			document = new XWPFDocument(fis);
			tables = document.getTables();			
			table = tables.get(3);
			//Remove Last Two Rows and First Row
			table.removeRow(table.getNumberOfRows()-1);
			table.removeRow(table.getNumberOfRows()-1);
			//Set Column Header Names
			setText(table.getRow(0).getCell(0),table.getRow(0).getCell(0).getText()+"| singleline");
			setText(table.getRow(0).getCell(1),table.getRow(0).getCell(1).getText()+"| multiline");
			setText(table.getRow(0).getCell(2),table.getRow(0).getCell(2).getText()+"| multiline");
			setText(table.getRow(0).getCell(3),table.getRow(0).getCell(3).getText()+" %| singleline");
			setText(table.getRow(0).getCell(4),table.getRow(0).getCell(4).getText()+" %| singleline");
			
			for(int i = 1;i<table.getNumberOfRows();i++)
			{
				//Replacing Level 1
				if(table.getRow(i).getCell(0).getText().equals(""))
					setText(table.getRow(i).getCell(0),lvl1);			
				else
					lvl1 = table.getRow(i).getCell(0).getText();
				
				//Replacing Level 2
				if(table.getRow(i).getCell(1).getText().equals(""))
					setText(table.getRow(i).getCell(1),lvl2);			
				else
					lvl2 = table.getRow(i).getCell(1).getText();
				
				//Add ~ to Multi Select				
				//setText(table.getRow(i).getCell(2),table.getRow(i).getCell(2).getText().replace(",","~"));
				
				//Add to LinkedHashtable
				submap = new LinkedHashMap<String, String>();				
				for (int j = 0; j< table.getRow(i).getTableCells().size();j++) 
				{
					key = table.getRow(headerrow).getCell(j).getText();
					value = table.getRow(i).getCell(j).getText().trim();						
					submap.put(key, value);
				}
				map.put(i, submap);						
			}				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (document != null)
					document.close();
				if (fis != null) 
					fis.close();
			}
			catch (Exception ex) {
			}
		}
		return map;
	}
	private static void setText(XWPFTableCell cell,String str)
	{
		XWPFParagraph paragraph;
		XWPFRun run;
		int paracount = cell.getParagraphs().size();
		for(int i= 0; i<paracount;i++)
			cell.removeParagraph(0);
		paragraph = cell.addParagraph();
		run = paragraph.createRun();
		run.setText(str);
	}
}
