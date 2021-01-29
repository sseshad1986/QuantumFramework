package com.quantum.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
 

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.helper.BaseClass;
import com.quantum.helper.Xls_Reader;
import com.quantum.poc.AIADataExtract;
import com.quantum.poc.ReadSaaTaaTable;
import com.quantum.utils.DeviceUtils;


@SuppressWarnings("static-access")
public class Nflows_Entity_Creation extends WebDriverBaseTestPage<WebDriverTestPage>
{
	
	/**
	 * @author <Sumesh.M.S>
	 * Created On 	- <20th Sep 2019>
	 * Responsibility- <This class is used for Entity Definition>
	 * Modified by <name> on <date> for Issue <Issue number (s)> for Integration <integration number>
	 */			
	
	// Locators in Entity creation page
	@FindBy(locator = "nflows.entitycreation.newEntityCreation.button")
	private QAFExtendedWebElement newEntityCreation;
		
	@FindBy(locator = "nflows.entitycreation.downloadXML.link")
	private QAFExtendedWebElement downloadXML;
	
	@FindBy(locator = "nflows.entitycreation.downloadJSON.link")
	private QAFExtendedWebElement downloadJSON;	
	
	@FindBy(locator = "nflows.entitycreation.downloadExcel.link")
	private QAFExtendedWebElement downloadExcel;
	
	@FindBy(locator = "nflows.entitycreation.search.textBox")
	private QAFExtendedWebElement search;
	
	@FindBy(locator = "nflows.entitycreation.entitydatatable.grid")
	private QAFExtendedWebElement entitydatatable;
	
	@FindBy(locator = "nflows.entitycreation.headerRow.grid")
	private QAFExtendedWebElement headerRow;
	
	@FindBy(locator = "nflows.entitycreation.dataRow.grid")
	private QAFExtendedWebElement dataRow;
	
	@FindBy(locator = "nflows.entitycreation.nextPage.grid")
	private QAFExtendedWebElement nextPage;
	
	@FindBy(locator = "nflows.entitycreation.save")
	private QAFExtendedWebElement saveEntity;
	
	@FindBy(locator = "nflows.entitycreation.cancel")
	private QAFExtendedWebElement cancelEntity;
	
	@FindBy(locator = "nflows.entitycreation.modelPopCloseBtn")
	private QAFExtendedWebElement modelPopCloseBtn;
	
	// Locators regarding field group
	@FindBy(locator = "nflows.entitycreation.grid.columns")
	private QAFExtendedWebElement gridColumns;
	
	@FindBy(locator = "nflows.entitycreation.grid.addRows")
	private QAFExtendedWebElement addFieldGrpRow;
	
	// Locators regarding field group
	@FindBy(locator = "nflows.entitycreation.cancelPopup")
	private QAFExtendedWebElement cancelPopup;
	
	@FindBy(locator = "nflows.entitycreation.cancelYes")
	private QAFExtendedWebElement cancelYes;
	
	@FindBy(locator = "nflows.entitycreation.cancelNo")
	private QAFExtendedWebElement cancelNo;
	
	@FindBy(locator = "nflows.entitycreation.tabHyperlink")
	private QAFExtendedWebElement tabHyperlink;
		
	@FindBy(locator = "nflows.entitycreation.Entitylevelfields")
	private QAFExtendedWebElement Entitylevelfields;
	
	@FindBy(locator = "nflows.entitycreation.searchBxGridData")
	private QAFExtendedWebElement searchBxGridData;
	
	@FindBy(locator = "nflows.entitycreation.SearchRecordResult")
	private QAFExtendedWebElement SearchRecordResult;
	
	@FindBy(locator = "nflows.entitycreation.entityRowRecord")
	private QAFExtendedWebElement entityRowRecord;
	
	@FindBy(locator = "nflows.entitycreation.fieldentityRowRecord")
	private QAFExtendedWebElement fieldentityRowRecord;
	
	@FindBy(locator = "nflows.entitycreation.downloadParentfile")
	private QAFExtendedWebElement downloadParentfile;
	
	@FindBy(locator = "nflows.entitycreation.expandEntityRecord")
	private QAFExtendedWebElement expandEntityRecord;
	
	@FindBy(locator = "nflows.entitycreation.loadingicon")
	private QAFExtendedWebElement loadingicon;
	
	@FindBy(locator = "nflows.entitycreation.Workflowlevelfields")
	private QAFExtendedWebElement Workflowlevelfields;
	
	@FindBy(locator = "nflows.entitycreation.ParentFileName")
	private QAFExtendedWebElement ParentFileName;
	
	//  Getters
	
	public QAFExtendedWebElement getParentFileName() {
		return ParentFileName;
	}
	
	public QAFExtendedWebElement getloadingicon() {
		return loadingicon;
	}
	
	public QAFExtendedWebElement getWorkflowlevelfields() {
		return Workflowlevelfields;
	}
	
	public QAFExtendedWebElement getexpandEntityRecord() {
		return expandEntityRecord;
	}
	
	public QAFExtendedWebElement getdownloadParentfile() {
		return downloadParentfile;
	}
	
	public QAFExtendedWebElement getentityRowRecord(String EntityRecord)
	{
		String loc = String.format(pageProps.getString("nflows.entitycreation.entityRowRecord"), EntityRecord);
		return new QAFExtendedWebElement(loc);
	}
	
	public QAFExtendedWebElement getfieldentityRowRecord(String FieldName)
	{
		String loc = String.format(pageProps.getString("nflows.entitycreation.fieldentityRowRecord"), FieldName);
		return new QAFExtendedWebElement(loc);
	}
	
	public QAFExtendedWebElement getEntitylevelfields() {
		return Entitylevelfields;
	}
	
	public QAFExtendedWebElement getsearchBxGridData() {
		return searchBxGridData;
	}
	
	public QAFExtendedWebElement getSearchRecordResult() {
		return SearchRecordResult;
	}	
	
	public QAFExtendedWebElement gettabHyperlink(String tabName)
	{
		String loc = String.format(pageProps.getString("nflows.entitycreation.tabHyperlink"), tabName);
		return new QAFExtendedWebElement(loc);
	}
	
	public QAFExtendedWebElement getNewEntityCreation(String astr_entityName)
	{
		String loc = String.format(pageProps.getString("nflows.entitycreation.newEntityCreation.button"), astr_entityName);
		return new QAFExtendedWebElement(loc);
	}
	
	public QAFExtendedWebElement getDownloadXML() {
		return downloadXML;
	}
	
	public QAFExtendedWebElement getDownloadJSON() {
		return downloadJSON;
	}
	public QAFExtendedWebElement getDownloadExcel() {
		return downloadExcel;
	}
	public QAFExtendedWebElement getEntitycreationSearch() {
		return search;
	}
	public QAFExtendedWebElement getentitydatatable() {
		return entitydatatable;
	}
	
	public QAFExtendedWebElement getheaderRow() {
		return headerRow;
	}
	
	public QAFExtendedWebElement getdataRow() {
		return dataRow;
	}
	
	public QAFExtendedWebElement getnextPage() {
		return nextPage;
	}
		
	public QAFExtendedWebElement getSaveEntity() {
		return saveEntity;
	}
	
	public QAFExtendedWebElement getCancelEntity() {
		return cancelEntity;
	}
	
	public QAFExtendedWebElement getModelClose() {
		return modelPopCloseBtn;
	}	
	
	// getters regarding Field group
	
	public QAFExtendedWebElement getFieldgrpColumns(String astr_fieldGrpColumns)
	{
		String loc = String.format(pageProps.getString("nflows.entitycreation.grid.columns"), astr_fieldGrpColumns);
		return new QAFExtendedWebElement(loc);
	}	
	
	public QAFExtendedWebElement getAddFieldgrpRow(String astr_addFieldGrpRow)
	{
		String loc = String.format(pageProps.getString("nflows.entitycreation.grid.addRows"), astr_addFieldGrpRow);
		return new QAFExtendedWebElement(loc);
	}
	
	//getters regarding cancel pop up	
	public QAFExtendedWebElement getcancelPopup() {
		return cancelPopup;
	}
	
	public QAFExtendedWebElement getcancelYes() {
		return cancelYes;
	}
	
	public QAFExtendedWebElement getcancelNo() {
		return cancelNo;
	}	
	
	// Method Author : M.S.Sumesh 
	// Functionalities related to Entity Creation	
	public void click_new_Entity_record(String astr_entityName) throws InterruptedException 
	{		
		CommonBean.lbase_baseClass.clickButton(getNewEntityCreation(astr_entityName));		
		Thread.sleep(4000);		
	}
	
	// Method Author : M.S.Sumesh 
	// This method enters data in display group fields and field group fields
	public String[] createEntityRecord(String astr_entityName,String[] astr_FieldGroupData) throws InterruptedException, IOException 
	{	
		String missingField[]=null;
		ArrayList<String> missingFieldList=null;
		try
		{
			Xls_Reader excelData=new Xls_Reader();			
			LinkedHashMap<Integer, Map<String, String>> map= excelData.readEntityData("Entity",astr_entityName, "Display_Group");
			
			// AIA POC
			//LinkedHashMap<Integer, Map<String, String>> map=AIADataExtract.GetAIAData(System.getProperty("user.dir") + "\\src\\main\\java\\com\\quantum\\poc\\Asset Mandate - AIA Hong Kong Par Fund.docx");
						
			missingFieldList = new ArrayList<String>();			
			
			for (Entry<Integer, Map<String, String>> entry : map.entrySet()) 
			{			
				// Check create entity record is present due to role access				
				CommonBean.lbase_baseClass.waitBeforeClick(getNewEntityCreation(astr_entityName),5);
				if(getNewEntityCreation(astr_entityName).isPresent())
				{
					// Click on new Entity button and navigate to Entity creation page
					CommonBean.lbase_baseClass.clickButton(getNewEntityCreation(astr_entityName));		
					DeviceUtils.getQAFDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					Thread.sleep(2000);	
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(CommonBean.IMyRequest_page.getloadericon());
										
					Map<String, String> innermap=entry.getValue();					
					
					for (Map.Entry<String, String> innerentry : innermap.entrySet()) 
					{
						String FieldName,FieldType,Datavalue=null;
						
						String key=innerentry.getKey().trim();						
						String arr[]=key.split("\\|");
						FieldName=arr[0].trim();
						FieldType=arr[1].trim();
						Datavalue=innerentry.getValue().trim();
									
						System.out.println("Field Name : " + FieldName + " | "+  "Field Type : " + FieldType + " | "+"Data value : " + Datavalue);				
						
						// Check whether the display group field exists based on Label Name
						Boolean IselementExists=CommonBean.projectLibrary.checkElementbyLabel(FieldName);
						if(IselementExists)
						{	
							Thread.sleep(500);							
							
							//This statement fills data in Display group fields
							CommonBean.projectLibrary.insertDisplaygroupFieldData(FieldName,FieldType,Datavalue,"");
							Thread.sleep(300);
						}	
						else
							missingFieldList.add(FieldName);			
					}
					if(astr_FieldGroupData!=null)
					{
						for(String fieldgrp:astr_FieldGroupData)
						{
							//This statement fills data in field group fields
							enterFieldGroupData(astr_entityName,fieldgrp) ;
						}
					}
					else
						System.out.println("No Field group data exists");				
					
					// Take screenshots before saving entity record
					BaseClass.getScreenshot("Enter data in entity creation page for "+ astr_entityName );
					CommonBean.lbase_baseClass.clickButton(getSaveEntity());		
					Thread.sleep(3000);
					
					CommonBean.lbase_baseClass.waitForPageLoad(15);
					
					CommonBean.lbase_baseClass.waitForVisibility(getSaveEntity());	
					Thread.sleep(1500);
						
					// To check model pop up is present
					if(getModelClose().isDisplayed())
					{
						BaseClass.getScreenshot("Error in saving entity record for  "+ astr_entityName );
						CommonBean.lbase_baseClass.clickButton(getModelClose());
						System.out.println("#### Entity record is not Saved ! ####");
						missingFieldList.add(0, "false");
						
						CommonBean.lbase_baseClass.clickButton(getCancelEntity());		
						Thread.sleep(700);
					}
					else
					{
						System.out.println("#### Entity record is Saved ! ####");	
						missingFieldList.add(0, "true");
						// Take screenshots after saving entity record
						BaseClass.getScreenshot("Entity creation record for "+ astr_entityName  + " is saved");
					}
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(CommonBean.IMyRequest_page.getloadericon());
										
					// Click on Cancel button				
					QAFExtendedWebElement cancelBtn=DeviceUtils.getQAFDriver().findElement(By.xpath("//div[contains(@class,'entity-header-fixed-top')]//button[text()='Cancel']"));
					CommonBean.lbase_baseClass.waitForVisibility(cancelBtn);
					CommonBean.lbase_baseClass.clickButton(cancelBtn);		
					System.out.println("----Cancel Entity method is called !-----");					 
					Thread.sleep(700);
					
					// Check Cancel YES button is present and click on 'YES' button
					if(getcancelPopup().isPresent())
					{
						System.out.println("---- Click on Cancel YES button!-----");
						BaseClass.getScreenshot("Failed-Entity record for "+ astr_entityName  + " is not saved");
						CommonBean.lbase_baseClass.clickButton(getcancelYes());
						Thread.sleep(1500);
					}
				}
				else
				{
					System.out.println("Unable to create record for " + astr_entityName + " due to read access in roles");
				}				
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		missingField= GetStringArray(missingFieldList);
		return missingField;
	}
	
	// Method Author : M.S.Sumesh 
	// This method enters data in field group fields
	public void enterFieldGroupData(String astr_FileName,String astr_FieldGroupName) throws InterruptedException, IOException 
	{			
		try 
		{
			String fieldGrpHeader="//div[contains(@ng-init,'" + astr_FieldGroupName + "')]"
					+ "/following::div[contains(@class,'ui-grid-header-cell-wrapper')][1]//span[contains(@class,'ui-grid-header-cell-label')]";
			
			List<WebElement> fieldGrpHeaderList=DeviceUtils.getQAFDriver().findElementsByXPath(fieldGrpHeader);			
			Xls_Reader getexcelFldGrpData=new Xls_Reader();				
			
			// Make sure fileName is equal to Entity Name
			LinkedHashMap<Integer, Map<String, String>> map= getexcelFldGrpData.readEntityData("Entity",astr_FileName, astr_FieldGroupName);
						
			// AIA POC
			//LinkedHashMap<Integer, Map<String, String>> map=ReadSaaTaaTable.GetSaaTaaTable(System.getProperty("user.dir") + "\\src\\main\\java\\com\\quantum\\poc\\Asset Mandate - AIA Hong Kong Par Fund.docx");
			
			// To get number of field group
			int addFieldGrp=map.size();
			
			if(addFieldGrp>0)
				CommonBean.projectLibrary.addFieldgroupRows(getAddFieldgrpRow(astr_FieldGroupName),addFieldGrp);
			
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("scroll(300, 0)");
			
			for (Entry<Integer, Map<String, String>> entry : map.entrySet()) 
			{	
				Map<String, String> innermap=entry.getValue();				
				for (Map.Entry<String, String> innerentry : innermap.entrySet()) 
				{									
					String FieldName,FieldType,Datavalue=null;
					String key=innerentry.getKey().trim();
					// This statement splits field name and Field type based on '|' symbol
															
					String arr[]=key.split("\\|");
					FieldName=arr[0].trim();
					FieldType=arr[1].trim();
					Datavalue=innerentry.getValue().trim();			
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
	
	// Method Author : M.S.Sumesh 
	public Boolean editEntityRecord(String astr_record,String astr_entityCol) throws InterruptedException, IOException 
	{	
		Boolean isPresent=false;		
		try 
		{
			getEntitycreationSearch().clear();
			CommonBean.lbase_baseClass.writeText(getEntitycreationSearch(), astr_record);
			getEntitycreationSearch().sendKeys(Keys.ENTER);
			Thread.sleep(1000);		
			int lint_headerIndex= CommonBean.projectLibrary.getHeaderIndex(astr_entityCol);
			lint_headerIndex=lint_headerIndex+1;
			isPresent=CommonBean.projectLibrary.editGridData(astr_record, lint_headerIndex);
			if(isPresent)
			{
				System.out.println(astr_record + " : record exists !");
			}
			else
			{
				System.out.println("No record exists !");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isPresent;			
	}
	
	public String[] GetStringArray(ArrayList<String> arr) 
    { 
  
        // declaration and initialise String Array 
        String str[] = new String[arr.size()]; 
  
        // Convert ArrayList to object array 
        Object[] objArr = arr.toArray(); 
  
        // Iterating and converting to String 
        int i = 0; 
        for (Object obj : objArr) { 
            str[i++] = (String)obj; 
        }   
        return str; 
    } 
	
	//Author: Vasanth S
	public void NavigatetoaTab(String tabName) throws Throwable
	{
		CommonBean.lbase_baseClass.actionClick(gettabHyperlink(tabName));
		BaseClass.getScreenshot("Navigated to tab " + tabName);
	}
	
	//Author: Vasanth S
	public boolean VerifyEntityCreationDocumentManager(String EntityName) throws Throwable
	{
		boolean result = false;
		try {
			CommonBean.IEntity_Creation.NavigatetoaTab("Document Manager");
			if(getNewEntityCreation(EntityName).isDisplayed())
				result = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;		
	}
	
	//Author: Vasanth S
	//Search a Entity Record
	public Boolean VerifyEntityRecordSearchinEntityCreationDocumentManager(String EntityName,String EntityRecord) throws Throwable
	{
		Boolean result = false;
		try	{
			CommonBean.lbase_baseClass.pressEnter();
			CommonBean.lbase_baseClass.actionClick(getEntitylevelfields());
			Thread.sleep(2000);		
			CommonBean.lbase_baseClass.writeText(getsearchBxGridData(), EntityRecord);		
			if(CommonBean.lbase_baseClass.getText(getSearchRecordResult()).equals(EntityRecord))
				result =true;
			BaseClass.getScreenshot("Search Entity Record Result - ");
			}
		catch(Exception e) {
			result =false;
			e.printStackTrace();
		}
		if(getsearchBxGridData().isDisplayed())
			getsearchBxGridData().clear();	
		return result;		
	}
	
	//Author : Vasanth S
	//Search Entity Field and View Records 
	public Boolean VerifyViewEntityfieldrecordinEntityCreationDocumentManager(String EntityName,String EntityRecord,String FieldName) throws Throwable
	{
		Boolean result = false;
		try {					
			CommonBean.lbase_baseClass.actionClick(getEntitylevelfields());
			Thread.sleep(2000);		
			// Search Entity Record
			CommonBean.lbase_baseClass.writeText(getsearchBxGridData(), EntityRecord);
			CommonBean.lbase_baseClass.actionClick(getexpandEntityRecord());
			CommonBean.lbase_baseClass.actionClick(getfieldentityRowRecord(FieldName));
			Thread.sleep(1000);	
			BaseClass.getScreenshot("Entity Field Record Result - ");
			if(getdownloadParentfile().isDisplayed())
				result =true;
		}
		catch(Exception e) {
			result=false;
			e.printStackTrace();
		}
		if(getsearchBxGridData().isDisplayed())
			getsearchBxGridData().clear();
		return result;		
	}		
	
	//Author: Vasanth S
	//Search Workflow Field and View Records 
	public Boolean VerifyViewWorkflowfieldrecordinEntityCreationDocumentManager(String EntityName,String EntityRecord,String FieldName) throws Throwable
	{
		Boolean result = false;
		try {
			// Search Entity
			CommonBean.IEntity_Creation.NavigatetoaTab("Document Manager");
			CommonBean.lbase_baseClass.actionClick(getWorkflowlevelfields());
			Thread.sleep(2000);
			if(getloadingicon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
			Thread.sleep(2000);
			// Search Entity Record
			CommonBean.lbase_baseClass.writeText(getsearchBxGridData(), EntityRecord);
			getexpandEntityRecord().click();
			CommonBean.lbase_baseClass.actionClick(getfieldentityRowRecord(FieldName));
			Thread.sleep(1000);
			BaseClass.getScreenshot("Workflow Field Record Result - ");
			if(getdownloadParentfile().isDisplayed())
				result =true;
		}
		catch(Exception e) {
			result=false;
			e.printStackTrace();
		}
		if(getsearchBxGridData().isDisplayed())
			getsearchBxGridData().clear();
		return result;		
	}
	
	//Download Parent Version
	public Boolean VerifyDownloadParentversioninEntityCreationDocumentManager(String EntityName,String EntityRecord,String FieldName) throws Throwable
	{
		Boolean result = false;
		String fileName,CurrentHandle;
		try	{
			// Search Entity
			CommonBean.IEntity_Creation.NavigatetoaTab("Document Manager");
			getEntitylevelfields().click();
			Thread.sleep(2000);		
			CommonBean.lbase_baseClass.writeText(getsearchBxGridData(), EntityRecord);	
			CommonBean.lbase_baseClass.actionClick(getexpandEntityRecord());
			CommonBean.lbase_baseClass.actionClick(getfieldentityRowRecord(FieldName));
			Thread.sleep(1000);
			fileName=CommonBean.lbase_baseClass.getText(getParentFileName());
			CurrentHandle=driver.getWindowHandle();
			BaseClass.getScreenshot("Download Parent Version");
			CommonBean.lbase_baseClass.actionClick(getdownloadParentfile());
			Thread.sleep(1000);
			Set<String> tabs=driver.getWindowHandles();
			for(String handle:tabs)	{
				if(!handle.equals(CurrentHandle)) {
					driver.switchTo().window(handle);
					BaseClass.getScreenshot("Download Parent Version Result -");
					if(CommonBean.lbase_baseClass.getpageTitle().contains(fileName))
						result=true;
					driver.close();
					driver.switchTo().window(CurrentHandle);
				}
			}
		}
		catch(Exception e) {
			result=false;
			e.printStackTrace();
		}
		finally {
			if(getsearchBxGridData().isDisplayed())
				getsearchBxGridData().clear();
		}
		return result;		
	}
	
	//Author: Vasanth S
	public boolean VerifyDownloadAllVersionEntityCreationDocumentManager(String EntityName,String EntityRecord,String FieldName) throws Throwable
	{
		boolean result = false;
		String fileName,CurrentHandle;
		int ElementCount,i;
		try {
			// Search Entity
			//CommonBean.lbase_baseClass.actionClick(getEntitylevelfields());
			//Thread.sleep(2000);		
			CommonBean.lbase_baseClass.writeText(getsearchBxGridData(), EntityRecord);	
			CommonBean.lbase_baseClass.actionClick(getexpandEntityRecord());
			CommonBean.lbase_baseClass.actionClick(getfieldentityRowRecord(FieldName));
			Thread.sleep(1000);
			CurrentHandle=driver.getWindowHandle();
			ElementCount = driver.findElements(By.xpath("//div[@class='request-trigger-left margin-left-10 animated fadeIn']//div[@class='col-sm-12 padding-zero grid-document-row-bg ng-scope']")).size();			
			for(i=1;i<=ElementCount;i++) {
				fileName = driver.findElement(By.xpath("//div[@class='request-trigger-left margin-left-10 animated fadeIn']//div[@class='col-sm-12 padding-zero grid-document-row-bg ng-scope']["+i+"]//div[2]")).getText();
				driver.findElement(By.xpath("//div[@class='request-trigger-left margin-left-10 animated fadeIn']//div[@class='col-sm-12 padding-zero grid-document-row-bg ng-scope']["+i+"]//div[5]")).click();
				BaseClass.getScreenshot("Download version, File - " + i);
				Thread.sleep(1000);
				Set<String> tabs=driver.getWindowHandles();
				for(String handle:tabs)	{
					if(!handle.equals(CurrentHandle)) {
						driver.switchTo().window(handle);
						BaseClass.getScreenshot("Download All version Result, File - " + i);
						if(CommonBean.lbase_baseClass.getpageTitle().contains(fileName))
							result=true;
						driver.close();
						driver.switchTo().window(CurrentHandle);
					}
				}
			}		
		}
		catch(Exception e) {
			result=false;
			e.printStackTrace();
		}
		finally {
			if(getsearchBxGridData().isDisplayed())
				getsearchBxGridData().clear();
		}
		return result;		
	}
	
	protected void openPage(PageLocator locator, Object... args) {
				
	}
	
	
	
	
}
	

