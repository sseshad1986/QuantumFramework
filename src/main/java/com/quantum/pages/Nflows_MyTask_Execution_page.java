package com.quantum.pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.helper.Xls_Reader;
import com.quantum.utils.DeviceUtils;



@SuppressWarnings("static-access")
public class Nflows_MyTask_Execution_page extends WebDriverBaseTestPage<WebDriverTestPage>
{		
	WebDriverTestBase driver = new WebDriverTestBase();
	LinkedHashMap<String, LinkedHashMap<String, Map<String, String>>>  taskMap = null;
		
	@FindBy (locator = "nflows.EditmyTask.Submit.button")
	private QAFExtendedWebElement SubmitBtn;
	
	@FindBy (locator = "nflows.EditmyTask.saveAsDraft.button")
	private QAFExtendedWebElement saveAsDraftBtn;
	
	@FindBy (locator = "nflows.EditmyTask.taskHistory.button")
	private QAFExtendedWebElement taskHistoryBtn;
	
	@FindBy (locator = "nflows.EditmyTask.Cancel.button")
	private QAFExtendedWebElement CancelBtn;
	
// ------------------------------         Locators Ends here !          ----------------------------------------------------	
	
	public QAFExtendedWebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	public QAFExtendedWebElement getSaveAsDraftBtn() {
		return saveAsDraftBtn;
	}	
	
	public QAFExtendedWebElement getTaskHistoryBtn() {
		return taskHistoryBtn;
	}
	
	public QAFExtendedWebElement getCancelBtn() {
		return CancelBtn;
	}
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	// ------------------------------         Getter method Ends here !          ----------------------------------------------------
	
	// Method Author: M.S.SUMESH , Created date: 9th Sep 2020
	@SuppressWarnings("null")
	public void getTaskdetail(String astr_task_ID,String astr_fileName,String[] astr_FieldGroupData) throws IOException
	{		
		boolean isRowExists=false;
		
		try 
		{
			System.out.println("Method Name: getTaskdetail is called");
			//LinkedHashMap<String, LinkedHashMap<String, Map<String, String>>>  taskMap = null;
			
			if(astr_task_ID.equalsIgnoreCase("TASK_01") )
				taskMap=getAllTaskDetail("Workflow",astr_fileName, "TASK");						
			
			System.out.println("The value based on Key : "+ taskMap.get(astr_task_ID));
			if(taskMap.size()!=0)
			{
				LinkedHashMap<String, Map<String, String>> innermap=taskMap.get(astr_task_ID);			
							
				Set<String> fgkeys = innermap.keySet();
				Iterator<String> i = fgkeys.iterator();
				while (i.hasNext()) 
				{
					String astr_taskAction=i.next();
				    switch(astr_taskAction)
					{
						case "INSERT":
							System.out.println("INSERT : "+ innermap.get("INSERT"));
							CommonBean.projectLibrary.splitMapdata(astr_taskAction,innermap.get("INSERT"));
							break;
						case "UPDATE":
							System.out.println("UPDATE : "+innermap.get("UPDATE"));
							CommonBean.projectLibrary.splitMapdata(astr_taskAction,innermap.get("UPDATE"));
							break;
						case "DELETE":
							System.out.println("DELETE : "+innermap.get("DELETE"));
							CommonBean.projectLibrary.splitMapdata(astr_taskAction,innermap.get("DELETE"));
							break;
						case "VALIDATE":
							System.out.println("VALIDATE : "+ innermap.get("VALIDATE"));
							CommonBean.projectLibrary.splitMapdata(astr_taskAction,innermap.get("VALIDATE"));
							break;
					}	
				}
			}
			else
				System.out.println("There are no fields to be processed for display group fields");
			
			// Call field group function to fill data for field group related fields in task page
			if(astr_FieldGroupData!=null)
			{
				for(String fieldgrp:astr_FieldGroupData)
				{													
					System.out.println("Call field group function for "+ fieldgrp);
					LinkedHashMap<String, LinkedHashMap<String, Map<String, String>>>  taskFGMap=null;
					//if(astr_task_ID.equalsIgnoreCase("TASK_01"))
					taskFGMap=CommonBean.xls_reader.getTaskFieldGroupData("Workflow", "Library_WF_Task_Details", "FIELD_GRP");
				
					LinkedHashMap<String, Map<String, String>> fieldGrpmap=taskFGMap.get(astr_task_ID);			
					Set<String> fieldGrpkeys = fieldGrpmap.keySet();
					Iterator<String> j = fieldGrpkeys.iterator();
					while (j.hasNext()) 
					{
						String astr_FieldgrpData=j.next();
						String fldGrp[]=astr_FieldgrpData.split("~");
						String actionFldGrp=fldGrp[0];
						int rowIdFG=Integer.parseInt(fldGrp[1]);
						
					    switch(actionFldGrp)
						{
							case "INSERT":
								System.out.println("INSERT : "+ fieldGrpmap.get("INSERT"+"~"+rowIdFG));
								isRowExists=CommonBean.projectLibrary.checkFieldGrpRowExists(fieldgrp,rowIdFG);
								if(isRowExists)
									CommonBean.projectLibrary.splitFieldGrpMapdata(actionFldGrp,fieldGrpmap.get("INSERT"+"~"+rowIdFG),fieldgrp,rowIdFG);
								else
									System.out.println(rowIdFG + " : Invalid row is supplied ! ");
								break;
							case "UPDATE":
								System.out.println("UPDATE : "+fieldGrpmap.get("UPDATE"+"~"+rowIdFG));
								isRowExists=CommonBean.projectLibrary.checkFieldGrpRowExists(fieldgrp,rowIdFG);
								if(isRowExists)									
									CommonBean.projectLibrary.splitFieldGrpMapdata(actionFldGrp,fieldGrpmap.get("UPDATE"+"~"+rowIdFG),fieldgrp,rowIdFG);
								else
									System.out.println(rowIdFG + " : Invalid row is supplied ! ");
								break;
							case "DELETE":
								System.out.println("DELETE : "+fieldGrpmap.get("DELETE"+"~"+rowIdFG));
								isRowExists=CommonBean.projectLibrary.checkFieldGrpRowExists(fieldgrp,rowIdFG);
								if(isRowExists)									
									CommonBean.projectLibrary.performFieldgrpDeleteOrHistory(rowIdFG, "DELETE", fieldgrp);
								else
									System.out.println(rowIdFG + " : Invalid row is supplied ! ");
								break;
							case "VALIDATE":
								System.out.println("VALIDATE : "+ fieldGrpmap.get("VALIDATE"+"~"+rowIdFG));
								isRowExists=CommonBean.projectLibrary.checkFieldGrpRowExists(fieldgrp,rowIdFG);
								if(isRowExists)									
									CommonBean.projectLibrary.splitFieldGrpMapdata(actionFldGrp,fieldGrpmap.get("VALIDATE"+"~"+rowIdFG),fieldgrp,rowIdFG);
								else
									System.out.println(rowIdFG + " : Invalid row is supplied ! ");
								break;
							case "ADD":
								System.out.println("ADD : "+ fieldGrpmap.get("ADD"+"~"+rowIdFG));								
								QAFExtendedWebElement addFieldgrp=  DeviceUtils.getQAFDriver().findElement(By.xpath("//div/label[contains(text(),'Fieldgroup')]/span"));
								CommonBean.lbase_baseClass.javascriptClick(addFieldgrp);
								Thread.sleep(1000);
								String columnFG="//div//label[contains(text(),'" + fieldgrp + "')]/following::div[@class='ui-grid-canvas'][1]//div[@class='ui-grid-row ng-scope']//div[@ui-grid-cell][1]";
								int colSize=DeviceUtils.getQAFDriver().findElements(By.xpath(columnFG)).size();								
								CommonBean.projectLibrary.splitFieldGrpMapdata(actionFldGrp,fieldGrpmap.get("ADD"+"~"+rowIdFG),fieldgrp,colSize);
								break;
						}	
					}//performFieldgrpUpdate
				}			
			}			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public LinkedHashMap<String, LinkedHashMap<String, Map<String, String>>> getAllTaskDetail(String astr_module,String astr_fileName,String astr_sheetName) throws IOException
	{	
		LinkedHashMap<String, LinkedHashMap<String, Map<String, String>>> taskMap=null;
		try 
		{
			System.out.println("Method Name: getAllTaskDetail is called");
			taskMap=CommonBean.xls_reader.getAllTaskData(astr_module,astr_fileName,astr_sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taskMap;			
	}
	
	public LinkedHashMap<String, LinkedHashMap<String, Map<String, String>>> getAllTaskFG(String astr_module,String astr_fileName,String astr_sheetName) throws IOException
	{	
		LinkedHashMap<String, LinkedHashMap<String, Map<String, String>>> taskMap=null;
		try 
		{
			System.out.println("Method Name: getAllTaskDetail is called");
			taskMap=CommonBean.xls_reader.getAllTaskData(astr_module,astr_fileName,astr_sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taskMap;			
	}
	
	
	/* Method Author: M.S.SUMESH 
	 * Created date: 18th Sep 2020
	 * Purpose : This method performs action in field group data */
	public void loadFieldGroupData(String astr_FileName,String astr_FieldGroupName) throws InterruptedException, IOException 
	{			
		try 
		{
			String fieldGrpHeader="//div/label[contains(text(),'" + astr_FieldGroupName + "')]"
					+ "/following::div[contains(@class,'ui-grid-header-cell-wrapper')][1]//span[contains(@class,'ui-grid-header-cell-label')]";
			
			List<WebElement> fieldGrpHeaderList=DeviceUtils.getQAFDriver().findElementsByXPath(fieldGrpHeader);			
			Xls_Reader getexcelFldGrpData=new Xls_Reader();	
			
			// To get number of field group
			int addFieldGrp=getexcelFldGrpData.fetchRowCount("Entity",astr_FileName, astr_FieldGroupName);
			
			// Make sure fileName is equal to Entity Name
			LinkedHashMap<Integer, Map<String, String>> map= getexcelFldGrpData.readEntityData("Workflow",astr_FileName, astr_FieldGroupName);
			
			if(addFieldGrp>0)
				CommonBean.projectLibrary.addFieldgroupRows(CommonBean.IEntity_Creation.getAddFieldgrpRow(astr_FieldGroupName),addFieldGrp);
			
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("scroll(250, 0)");
			
			for (Map.Entry<Integer, Map<String, String>> entry : map.entrySet()) 
			{	
				String entityData=entry.getValue().toString().substring(1);
				String finalData=entityData.substring(0, entityData.length() - 1);
				
				String arr[]=finalData.split(",");		
				for(int i=0;i<arr.length;i++)
				{					
					String FieldName,FieldType,Datavalue=null;
					
					// This statement splits field name and Field type based on '|' symbol
					String dataType[]=arr[i].split("\\|");				
					String fieldType[]=dataType[1].split("=");
					FieldName=dataType[0].trim();
					FieldType=fieldType[0].trim();
					Datavalue=fieldType[1].trim();				
					System.out.println("Field Name : " + FieldName + " | "+  "Field Type : " + FieldType + " | "+"Data value : " + Datavalue);				
					
					int fieldGrpColNum=CommonBean.projectLibrary.getFieldgroupHeaderColumnNumber(FieldName, fieldGrpHeaderList);
					// Check whether column exists in field group
					if(fieldGrpColNum!=0)
					{
						WebElement Cell=null;
						try {
							Cell = CommonBean.projectLibrary.getWebElement(astr_FieldGroupName,entry.getKey(), fieldGrpColNum, FieldType);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(entry.getKey()>10)
							CommonBean.lbase_baseClass.scrollDown();
						CommonBean.projectLibrary.loadFieldgroupData(Cell, FieldType, Datavalue,entry.getKey());
						Thread.sleep(700);
					}
					else
						System.out.println("Field group Coloum :  " + FieldName + " Does n't exists ! ");										
				}
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Method Author: M.S.SUMESH , Created date: 16th Oct 2020
	public void saveAsDraft() throws IOException
	{			
		try 
		{
			CommonBean.lbase_baseClass.clickButton(getSaveAsDraftBtn());
			Thread.sleep(1500);
			CommonBean.lbase_baseClass.waitTill_ElementInvisible(CommonBean.IMyRequest_page.getloadericon());			
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
