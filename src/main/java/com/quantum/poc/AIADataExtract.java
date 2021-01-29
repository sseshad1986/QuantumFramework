package com.quantum.poc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class AIADataExtract {
	
	public static LinkedHashMap<Integer, Map<String, String>> GetAIAData(String File) throws FileNotFoundException, IOException
	{
		
		XWPFDocument docFile = new XWPFDocument(new FileInputStream(File));
		XWPFWordExtractor extractor = new XWPFWordExtractor(docFile);
		LinkedHashMap<Integer, Map<String, String>> AIA_data=new LinkedHashMap<Integer, Map<String, String>>();
		Map<String, String> AIA_SubData=new HashMap<String, String>();
	
		try {		
		//To fetch data from front page - single line and date field
		String[] Linelist = extractor.getText().split("[\\r?\\n]+");
		String legalEntity=Linelist[2].replace(":", "");
		String fundName=Linelist[3];
		if(Linelist[6].startsWith("Ver")) {
			String versionNo=Linelist[6];
			String astr_effectiveDate=Linelist[5];
			@SuppressWarnings("deprecation")
			Date date=new Date(astr_effectiveDate);
			SimpleDateFormat df2 = new SimpleDateFormat("dd/MMM/yyyy");
	        String effectiveDate = df2.format(date);
	        AIA_SubData.put("Version Effective Date|date", effectiveDate);
			AIA_SubData.put("Version|singleLine", versionNo);
		}else {
		String astr_effectiveDate=Linelist[6];
		@SuppressWarnings("deprecation")
		Date date=new Date(astr_effectiveDate);
		SimpleDateFormat df2 = new SimpleDateFormat("dd/MMM/yyyy");
        String effectiveDate = df2.format(date);
		String versionNo=Linelist[5];
		AIA_SubData.put("Version Effective Date|date", effectiveDate);
		AIA_SubData.put("Version|singleLine", versionNo);
		}
		
		//Adding all the values to Hashmap
		AIA_SubData.put("Legal Entity|dropdown", legalEntity);
		AIA_SubData.put("Fund Name|dropdown", fundName);
		
		
	/*	System.out.println("Legal Entity:  " + legalEntity + "\n" + "Fund Name:  " + fundName + "\n"
				+ "Effective Date:  " + effectiveDate + "\n" + "Version No:  " + versionNo);*/
		  
		List<XWPFParagraph> paragraphs = docFile.getParagraphs();
		for (int paragraphIndex = 0; paragraphIndex < paragraphs.size(); paragraphIndex++) {
			
			//To fetch data for Singleline field - Currency
			if(paragraphs.get(paragraphIndex).getText().startsWith("The Base Currency ")) {
				String[] CurrencyDataList=paragraphs.get(paragraphIndex).getText().split(" ");
				String currency=CurrencyDataList[CurrencyDataList.length-1].replace(".", "");
				System.out.println("Currency: "+currency);
				AIA_SubData.put("Base Currency|Dropdown", currency);
			}
			
			//To fetch data for multiselect dropdown - Client
			String client=null;
			List<String> clientList=new ArrayList<String>();
			if(paragraphs.get(paragraphIndex).getText().startsWith("Authorised Client Representatives")) {
				System.out.println("Clients:");
			//	int clientCount=0;
				for(int lineIndex=paragraphIndex;lineIndex<paragraphs.size(); lineIndex++) {
					if((paragraphs.get(lineIndex).getText().contains(","))&&(paragraphs.get(lineIndex).getText().contains("–"))) {
					String[] ClientlineData=paragraphs.get(lineIndex).getText().split("–");
						String[] ClientNames=ClientlineData[0].split(",");
					//	clientCount=clientCount+1;
						for(int i=0;i<ClientNames.length;i++) {
						clientList.add(ClientNames[i]);
						}
						}
					
				}
				if(clientList.size()==1){
					client=	clientList.get(0);
				}
				if(clientList.size()>1){
					client=	clientList.get(0);
					for(int i=1;i<clientList.size();i++) {
						client=client+"~"+clientList.get(i);
					}
						
				}
			System.out.println(client);
			AIA_SubData.put("Authorized Client Representatives|dropdown-multiselect", client);
			}
		}
	
		//To fetch data for multiline dropdown
		String investment =getMultiLineData(File,"Investment Objectives","Investment Strategy");
		String fundConstraints =getMultiLineData(File,"Fund Specific Constraints","Derivatives");
		String derivatives=getMultiLineData(File,"Derivatives","Application of AIA Risk Policies and Relevant Risk Tolerances");
		AIA_SubData.put("Investment Objective|RTF", investment);
		AIA_SubData.put("Fund Specific Constraints|RTF", fundConstraints);
		AIA_SubData.put("Investment Objectives for Derivatives|RTF", derivatives);
		AIA_data.put(1, AIA_SubData);

	} catch (Exception e) {
		System.out.println(e);
	}

		finally {
			try {
				if (extractor != null)
					extractor.close();
				if (docFile != null) 
					docFile.close();
			}
			catch (Exception ex) {
				System.out.println(ex);
			}
		}
	return AIA_data;
}

	public static String getMultiLineData (String File,String FieldName,String FilterText) throws FileNotFoundException, IOException {
		
		XWPFDocument docFile = new XWPFDocument(new FileInputStream(File));
		String multilineData="";
		List<String> multilineDataList=new ArrayList<String>();
			List<XWPFParagraph> paragraphs = docFile.getParagraphs();
			for (int paragraphIndex = 0; paragraphIndex < paragraphs.size(); paragraphIndex++) {
			
				//To fetch data for multi line field - Investment Objectives
							
				if (paragraphs.get(paragraphIndex).getText().startsWith(FieldName)
						&& (paragraphs.get(paragraphIndex).getStyle().equals("Heading1"))) {
				int selectIndex=paragraphIndex+1;
					for (int lineIndex = selectIndex; lineIndex < paragraphs.size(); lineIndex++) {
						if ((paragraphs.get(lineIndex).getStyle()!=null)&&(paragraphs.get(lineIndex).getStyle().equals("Heading1"))) {
									break;
								}
				/*	if (paragraphs.get(lineIndex).getText() != null) {
					if (paragraphs.get(lineIndex).getText().startsWith(FilterText)) {
							break;}
						
						}*/
						System.out.println(paragraphs.get(lineIndex).getText());
						multilineDataList.add(paragraphs.get(lineIndex).getText());
						//multilineData = paragraphs.get(lineIndex).getText();
						
					}
					
				}
				
			}
			for(int i=0;i<multilineDataList.size();i++) {
				multilineData=multilineData+multilineDataList.get(i);
			}
		docFile.close();
		return multilineData;		
		}
		public static void main(String[] args) throws FileNotFoundException, IOException {
			
			LinkedHashMap<Integer, Map<String, String>> SinglelineData =GetAIAData("D:\\Trac_Quantum\\src\\main\\java\\com\\quantum\\poc\\Asset Mandate - AIA Hong Kong Par Fund.docx");
		//	LinkedHashMap<Integer, Map<String, String>> SinglelineData =GetAIAData(System.getProperty("user.dir") + "\\src\\main\\java\\com\\quantum\\poc\\Sample_1.docx");	
			for(Map.Entry<Integer,Map<String,String>> entry : SinglelineData.entrySet())
				System.out.println(entry.toString());
			
		}
}


