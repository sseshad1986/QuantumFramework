package com.quantum.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Xls_Reader 
{
	public static String filename=System.getProperty("user.dir") + "\\src\\main\\resources\\data\\";	
	
	public  String path;
    public  FileInputStream fis = null;
    public  FileOutputStream fileOut =null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row   =null;
    private XSSFCell cell = null;
    
//    public Xls_Reader(String path,String sheetName) 
//    {
//
//        this.path=filename+path;
//        try 
//        {
//            fis = new FileInputStream(path);
//            workbook = new XSSFWorkbook(fis);
//            sheet = workbook.getSheet(sheetName);
//            fis.close();
//        } 
//        catch (Exception e) 
//        {
//            System.out.println("Error from Xls_Reader constructor-- " + e.getMessage());
//            e.printStackTrace();
//            
//        }
//    }
    
    // returns the row count in a sheet
    @SuppressWarnings({ "finally", "resource" })
	public int fetchRowCount(String module,String file,String sheetName ) throws IOException
    {
    	FileInputStream fis = null;
    	XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;    	
    	int number=0;
    	try
    	{
			fis = new FileInputStream(filename + module+"\\" + file+".xlsx");
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);   
			
			int index=workbook.getSheetIndex(sheetName);
			if(index==-1)
				return 0;	
			else
			{
				sheet=workbook.getSheetAt(index);
				number=sheet.getLastRowNum();
			    return number;
			}
		} 
    	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally
    	{
    		workbook.close();
    		fis.close();
    		return number;
    	}
    	
    }
    
    
    
    // returns the row count in a sheet
    public int getRowCount(String sheetName )
    {
    	int index=workbook.getSheetIndex(sheetName);
    	if(index==-1)
    		return 0;	
    	else
    	{
    		sheet=workbook.getSheetAt(index);
    		int number=sheet.getLastRowNum();
    	    return number;
    	}
    	
    }
    public int headerIndex(String sheetName,String colName)
    {
    	// To find the sheet index (position of sheet)
    	int index = workbook.getSheetIndex(sheetName);
    	
    	if(index==-1)
    		return -1; // Returns no data when sheet name is wrong
    	
        int col_Num=-1;
        sheet=workbook.getSheetAt(index); 
        row=sheet.getRow(0);
        
        // To identify the column index for "Execute"
        for(int i=0;i<=row.getLastCellNum();i++ )
        {
        	if(row.getCell(i).getStringCellValue().equalsIgnoreCase(colName.trim()))
        	{
        		col_Num=i;
        		break;
        	}
        }
        if(col_Num==-1)
            return -1;
		return col_Num; 		
    }
    
    public String readData(String sheetName,String colName,String runMode)
    {        
    	String cellValue="";
    	sheet = workbook.getSheet(sheetName);
    	
    	int numberofRows=sheet.getPhysicalNumberOfRows();
    	int executeCol=headerIndex(sheetName, runMode.toLowerCase());
    	int headerCol=headerIndex(sheetName, colName);
    	
    	for (int i=1;i<numberofRows-1;i++)
    	{
    		row=sheet.getRow(i);
    		if(row!=null)
    		{
    			if(row.getCell(executeCol).getStringCellValue().trim().equalsIgnoreCase("YES"))
    			{
    				cellValue=row.getCell(headerCol).getStringCellValue().trim();
    				break;    				
    			}
    		}
    	}
		return cellValue;

    }
    
    // find whether sheets exists
    public boolean isSheetExist(String sheetName){
        int index = workbook.getSheetIndex(sheetName);
        if(index==-1){
            index=workbook.getSheetIndex(sheetName.toUpperCase());
            if(index==-1)
                return false;
            else
                return true;
        }
        else
            return true;
    }
    
    public int getColumnCount(String sheetName)
    {
        // check if sheet exists
        if(!isSheetExist(sheetName))
            return -1;

        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(0);

        if(row==null)
            return -1;

        return row.getLastCellNum();
    }        
    
    public LinkedHashMap<String, Map<String, String>> getAllExcelData(String astr_fileName,String astr_sheetName) throws IOException
	{
		LinkedHashMap<String, Map<String, String>>  actionMap=null;
		LinkedHashMap<String, String> columnDataMap=null;
		try 
		{				
			String projectPath=filename + astr_fileName + ".xlsx";
			System.out.println(projectPath);
			fis = new FileInputStream(projectPath);		
			 
			// Finds the workbook instance for XLSX file
			workbook = new XSSFWorkbook(fis);
			
			// Return first sheet from the XLSX workbook
			sheet = workbook.getSheet(astr_sheetName);
					
			actionMap= new LinkedHashMap<String, Map<String,String>>();
			columnDataMap = new LinkedHashMap<String, String>();

			int rowNum=getRowCount(astr_sheetName);		
			int ColNum=getColumnCount(astr_sheetName);
			
			// To iterate row wise 
			for(int i=1;i<=rowNum;i++)
			{		
				if(!columnDataMap.isEmpty()) 				
					columnDataMap = new LinkedHashMap<String, String>();				
				
				String ActionKey,key,value="";					
				ActionKey=sheet.getRow(i).getCell(0).getStringCellValue().trim();
				
				// To add data from all column from a single Row
				for(int j=1;j<ColNum;j++)
				{
					key= sheet.getRow(0).getCell(j).getStringCellValue().trim();
					value=new String();
					//value= sheet.getRow(i).getCell(j).getStringCellValue().trim();				
					cell=sheet.getRow(i).getCell(j);
					if(cell==null)
						cell = sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);			
					
					value=parseExcelCellData(cell,i, j);				
					if(!value.isEmpty())
						columnDataMap.put(key, value);					
				}			
				if(columnDataMap.size()!=0)				
					actionMap.put(ActionKey, columnDataMap);				
			}			
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			workbook.close();
			fis.close();
			
		}
		return actionMap;
		
	}
  
    public LinkedHashMap<String, LinkedHashMap<String, Map<String, String>>> getAllTaskData(String astr_module,String astr_fileName,String astr_sheetName) throws IOException
	{
    	LinkedHashMap<String, LinkedHashMap<String, Map<String, String>>>  taskMap=null;
		LinkedHashMap<String, Map<String, String>>  actionMap=null;
		LinkedHashMap<String, String> columnDataMap=null;		
		try 
		{				
			String projectPath=filename + astr_module + "\\" +astr_fileName + ".xlsx";
			System.out.println(projectPath);
			fis = new FileInputStream(projectPath);		
			 
			// Finds the workbook instance for XLSX file
			workbook = new XSSFWorkbook(fis);
			
			// Return first sheet from the XLSX workbook
			sheet = workbook.getSheet(astr_sheetName);
					
			taskMap= new LinkedHashMap<String, LinkedHashMap<String, Map<String, String>>>();
			actionMap= new LinkedHashMap<String, Map<String,String>>();
			columnDataMap = new LinkedHashMap<String, String>();

			int rowNum=getRowCount(astr_sheetName);		
			int ColNum=getColumnCount(astr_sheetName);
			String TaskKey = null;
			
			// To iterate row wise 
			for(int i=1;i<=rowNum;i++)
			{	
				if(!sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("end"))
				{
					String ActionKey,key,value="";
					if(!(sheet.getRow(i).getCell(0).getStringCellValue().isEmpty() && sheet.getRow(i).getCell(1).getStringCellValue().isEmpty()))
					{					
						if(!columnDataMap.isEmpty()) 
						{
							columnDataMap = new LinkedHashMap<String, String>();
						}					
						if(!sheet.getRow(i).getCell(0).getStringCellValue().isEmpty())
						{
							TaskKey=sheet.getRow(i).getCell(0).getStringCellValue().trim();
							if(!actionMap.isEmpty()) 
								actionMap = new LinkedHashMap<String, Map<String,String>>();
						}						
						
						ActionKey=sheet.getRow(i).getCell(1).getStringCellValue().trim();
						
						// To add data from all column from a single Row
						for(int j=2;j<ColNum;j++)
						{
							key= sheet.getRow(0).getCell(j).getStringCellValue().trim();						
							value=new String();
											
							cell=sheet.getRow(i).getCell(j);
							if(cell==null)
								cell = sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
							
							if(cell.getCellType() != CellType.BLANK)
								value=parseExcelCellData(cell,i, j);
							
							if(!value.isEmpty())
								columnDataMap.put(key, value);												
						}			
						if(columnDataMap.size()!=0)
							actionMap.put(ActionKey, columnDataMap);
						
						if(sheet.getRow(i+1).getCell(0).getStringCellValue() != "")
						{		
							if(!TaskKey.equalsIgnoreCase("end"))
							{
								if(actionMap.size()!=0)
									taskMap.put(TaskKey, actionMap);
								TaskKey="";
							}
						}
					}
				}
			}
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			workbook.close();
			fis.close();			
		}
		return taskMap;		
	}
    
    /* Method Author: M.S.SUMESH 
	 * Created date: 21th Sep 2020
	 * Purpose : This method get data for Field group fields for task execution */
	    
    public LinkedHashMap<String, LinkedHashMap<String, Map<String, String>>> getTaskFieldGroupData(String astr_module,String astr_fileName,String astr_sheetName) throws IOException
	{
    	LinkedHashMap<String, LinkedHashMap<String, Map<String, String>>>  taskMap=null;
		LinkedHashMap<String, Map<String, String>>  actionMap=null;		
		LinkedHashMap<String, String> columnDataMap=null;		
		try 
		{				
			String projectPath=filename + astr_module + "\\" +astr_fileName + ".xlsx";
			System.out.println(projectPath);
			fis = new FileInputStream(projectPath);		
			 
			// Finds the workbook instance for XLSX file
			workbook = new XSSFWorkbook(fis);
			
			// Return first sheet from the XLSX workbook
			sheet = workbook.getSheet(astr_sheetName);
			
			DataFormatter DATA_FORMATTER = new DataFormatter();
					
			taskMap= new LinkedHashMap<String, LinkedHashMap<String, Map<String, String>>>();
			actionMap= new LinkedHashMap<String, Map<String,String>>();			
			columnDataMap = new LinkedHashMap<String, String>();

			int rowNum=getRowCount(astr_sheetName);		
			int ColNum=getColumnCount(astr_sheetName);
			String TaskKey = null;
			
			// To iterate row wise 
			for(int i=1;i<=rowNum;i++)
			{	
				if(!sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("end"))
				{
					String ActionKey = null,key,value="";
					if(!(sheet.getRow(i).getCell(0).getStringCellValue().isEmpty() && sheet.getRow(i).getCell(1).getStringCellValue().isEmpty()))
					{					
						if(!columnDataMap.isEmpty()) 
						{
							columnDataMap = new LinkedHashMap<String, String>();
						}					
						if(!sheet.getRow(i).getCell(0).getStringCellValue().isEmpty())
						{
							TaskKey=sheet.getRow(i).getCell(0).getStringCellValue().trim();						
							if(!actionMap.isEmpty()) 
								actionMap = new LinkedHashMap<String, Map<String,String>>();
						}	
						
						Cell rowID=null;
						rowID=sheet.getRow(i).getCell(2);
						if(sheet.getRow(i).getCell(1).getStringCellValue() != "")
							ActionKey=sheet.getRow(i).getCell(1).getStringCellValue().trim()+"~"+
								DATA_FORMATTER.formatCellValue(rowID).toString();					
						
						// To add data from all column from a single Row
						for(int j=3;j<ColNum;j++)
						{
							key= sheet.getRow(0).getCell(j).getStringCellValue().trim();						
							value=new String();
											
							cell=sheet.getRow(i).getCell(j);
							if(cell==null)
								cell = sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
							
							if(cell.getCellType() != CellType.BLANK)
								value=parseExcelCellData(cell,i, j);
							
							if(!value.isEmpty())
								columnDataMap.put(key, value);												
						}			
						if(columnDataMap.size()!=0)						
							actionMap.put(ActionKey, columnDataMap);						
						if(sheet.getRow(i+1).getCell(0).getStringCellValue() != "")
						{		
							if(!TaskKey.equalsIgnoreCase("end"))
							{
								if(actionMap.size()!=0)
									taskMap.put(TaskKey, actionMap);
								TaskKey="";
							}
						}													
					}
				}
			}
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			workbook.close();
			fis.close();			
		}
		return taskMap;		
	}
    
    @SuppressWarnings("null")
	public LinkedHashMap<Integer, Map<String, String>> readEntityData(String astr_Module,String astr_fileName,String astr_sheetName) throws IOException
   	{   	
   		LinkedHashMap<String, String> columnDataMap=null;
   		LinkedHashMap<Integer, Map<String, String>>  dataMap=null;
   		String projectPath=null;
		
   		try 
		{	
   			projectPath=filename + "\\" + astr_Module + "\\" + astr_fileName + ".xlsx";
			System.out.println(projectPath);
			
			columnDataMap = new LinkedHashMap<String, String>();
			dataMap= new LinkedHashMap<Integer, Map<String,String>>();			
			
			fis = new FileInputStream(projectPath);		
			 
			// Finds the workbook instance for XLSX file
			workbook = new XSSFWorkbook(fis);		
			
			// Return first sheet from the XLSX workbook
			sheet = workbook.getSheet(astr_sheetName);
			//Cell cell;
			
			int rowNum=getRowCount(astr_sheetName);		
			int ColNum=getColumnCount(astr_sheetName);	
			int x = 0;

			// To iterate row wise 
			for(int i=1;i<=rowNum;i++)
			{		
				if(!columnDataMap.isEmpty()) 
					columnDataMap = new LinkedHashMap<String, String>();
					
				String key,value="";
				int headerRow=0;			
				
				for(int j=1;j<ColNum;j++) 
				{
					// To add data from all column from a single Row
					key= sheet.getRow(headerRow).getCell(j).getStringCellValue().trim();				
					value=new String();					
					cell=sheet.getRow(i).getCell(j);					
					if(cell==null)
						cell = sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					
					if(cell.getCellType() != CellType.BLANK)
						value=parseExcelCellData(cell,i, j);					
					
					if(!value.isEmpty())
						columnDataMap.put(key, value);	
				}	
				if(columnDataMap.size()!=0)				
					dataMap.put(++x, columnDataMap);					
			}					
						
		}   		
   		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			workbook.close();
			fis.close();
			
		}
		return dataMap;   		
   	}
    
    public String readColumnData(String astr_Module,String astr_fileName,String astr_sheetName,String colName) throws IOException
    {   
    	String projectPath=null;
    	String value=null;
    	
    	try {
			projectPath=filename + "\\" + astr_Module + "\\" + astr_fileName + ".xlsx";
			System.out.println(projectPath);					
			
			fis = new FileInputStream(projectPath);		
			 
			// Finds the workbook instance for XLSX file
			workbook = new XSSFWorkbook(fis);		
			// Return first sheet from the XLSX workbook
			Sheet sheet = workbook.getSheet(astr_sheetName);   	
			   	
			int headerCol=headerIndex(astr_sheetName, colName);    	
			Cell cell=sheet.getRow(1).getCell(headerCol);
			
			switch (cell.getCellType()) 
            {
                case STRING:		                    
                	value = cell.getStringCellValue().trim();
                    break;
                case NUMERIC:		                    	                    
                    if (DateUtil.isCellDateFormatted(cell)) 
                    {
                    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");		                        
                    	value = String.valueOf(dateFormat.format(cell.getDateCellValue()));
                    } else 
                    {
                        System.out.println(cell.getNumericCellValue());
                        value = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:		                    
                	value = cell.getStringCellValue().trim();
                    break;
                default :  
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
		return value;
    }
    
    public String parseExcelCellData(XSSFCell cell,int i, int j)
    {
    	String value=null;
    	try 
    	{
			switch (cell.getCellType()) 
			{
			    case STRING:		                    
			        value = sheet.getRow(i).getCell(j).getStringCellValue().trim();
			        break;
			    case NUMERIC:		                    	                    
			        if (DateUtil.isCellDateFormatted(cell)) 
			        {
			        	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");		                        
			            value = String.valueOf(dateFormat.format(sheet.getRow(i).getCell(j).getDateCellValue()));
			        } else 
			        {
			            System.out.println(cell.getNumericCellValue());
			            value = NumberToTextConverter.toText(sheet.getRow(i).getCell(j).getNumericCellValue());
			        }
			        break;
			    case BOOLEAN:		                    
			        value = sheet.getRow(i).getCell(j).getStringCellValue().trim();
			        break;
			    case BLANK:
			    	break;	
			    default :  
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
    }
    
}
