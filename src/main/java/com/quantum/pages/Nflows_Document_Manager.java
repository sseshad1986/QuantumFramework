package com.quantum.pages;

import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.GetAllWindowHandles;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.helper.BaseClass;


@SuppressWarnings("static-access")
public class Nflows_Document_Manager extends WebDriverBaseTestPage<WebDriverTestPage>
{
	
	/**
	 * @author <Sumesh.M.S>
	 * Created On 	- <12th Feb 2020>
	 * Responsibility- <This class is used for Document manager>
	 * Modified by <name> on <date> for Issue <Issue number (s)> for Integration <integration number>
	 */
	
	// WebDriver driver;
	//public WebDriverTestBase driver;
	//BaseClass lbase_baseClass = new BaseClass();	
	
	
	@FindBy(locator = "nflows.documentmanager.treeSearchBx")
	private QAFExtendedWebElement treeSearchBx;
	
	@FindBy(locator = "nflows.documentmanager.EntityType")
	private QAFExtendedWebElement EntityType;
	
	@FindBy(locator = "nflows.documentmanager.Entitylevelfields")
	private QAFExtendedWebElement Entitylevelfields;
	
	@FindBy(locator = "nflows.documentmanager.Workflowlevelfields")
	private QAFExtendedWebElement Workflowlevelfields;
	
	@FindBy(locator = "nflows.documentmanager.searchBxGridData")
	private QAFExtendedWebElement searchBxGridData;
	
	@FindBy(locator = "nflows.documentmanager.searchVersionGrid")
	private QAFExtendedWebElement searchVersionGrid;
	
	@FindBy(locator = "nflows.documentmanager.downloadParentfile")
	private QAFExtendedWebElement downloadParentfile;
	
	@FindBy(locator = "nflows.documentmanager.downloadAllfile")
	private QAFExtendedWebElement downloadAllfile;
	
	@FindBy(locator = "nflows.documentmanager.ExpandEntityRecord")
	private QAFExtendedWebElement ExpandEntityRecord;
	
	@FindBy(locator = "nflows.documentmanager.EntityRecordLink")
	private QAFExtendedWebElement EntityRecordLink;
	
	@FindBy(locator = "nflows.documentmanager.SearchEntityResult")
	private QAFExtendedWebElement SearchEntityResult;
	
	@FindBy(locator = "nflows.documentmanager.SearchRecordResult")
	private QAFExtendedWebElement SearchRecordResult;

	@FindBy(locator = "nflows.documentmanager.ParentFileName")
	private QAFExtendedWebElement ParentFileName;
	
	@FindBy(locator = "nflows.documentmanager.loadingicon")
	private QAFExtendedWebElement loadingicon;
	
	// ------------------------------         Locators Ends here !          ----------------------------------------------------
	
	public QAFExtendedWebElement getloadingicon() {
		return loadingicon;
	}
	
	public QAFExtendedWebElement gettreeSearchBx() {
		return treeSearchBx;
	}
	
	public QAFExtendedWebElement getParentFileName() {
		return ParentFileName;
	}
	
	public QAFExtendedWebElement getSearchRecordResult() {
		return SearchRecordResult;
	}
	
	public QAFExtendedWebElement getSearchEntityResult() {
		return SearchEntityResult;
	}
	
	public QAFExtendedWebElement getEntityType() {
		return EntityType;
	}
	
	public QAFExtendedWebElement getEntitylevelfields() {
		return Entitylevelfields;
	}
	
	public QAFExtendedWebElement getWorkflowlevelfields() {
		return Workflowlevelfields;
	}
	
	public QAFExtendedWebElement getsearchBxGridData() {
		return searchBxGridData;
	}
	
	public QAFExtendedWebElement getentityRowRecord(String astr_EntityRecord)
	{
		String loc = String.format(pageProps.getString("nflows.documentmanager.entityRowRecord"), astr_EntityRecord);
		return new QAFExtendedWebElement(loc);
	}
	
	public QAFExtendedWebElement getFieldNameInEntityRow(String astr_FieldName)
	{
		String loc = String.format(pageProps.getString("nflows.documentmanager.fieldentityRowRecord"), astr_FieldName);
		return new QAFExtendedWebElement(loc);
	}
	
	public QAFExtendedWebElement getsearchVersionGrid() {
		return searchVersionGrid;
	}
	
	public QAFExtendedWebElement getDownloadParentfile() {
		return downloadParentfile;
	}
	
	public QAFExtendedWebElement getDownloadAllfile() {
		return downloadAllfile;
	}
	
	// ------------------------------         Getter method Ends here !          ----------------------------------------------------
	
	// Type Entity Type in search tree
	public void searchEntityType(String astr_EntityType) throws InterruptedException
	{
		CommonBean.lbase_baseClass.writeText(treeSearchBx, astr_EntityType);
	}
	
	// Click on Entity level field under search tree
	public void clickEntitylevelfields() throws InterruptedException
	{
		CommonBean.lbase_baseClass.clickButton(getEntitylevelfields());
	}
	
	// Click on Workflow level field under search tree
	public void clickWorkflowlevelfields() throws InterruptedException
	{
		CommonBean.lbase_baseClass.clickButton(getWorkflowlevelfields());
	}
	
	// Type Entity record in search tree
	public void searchEntityRecord(String astr_EntityRecord) throws InterruptedException
	{
		CommonBean.lbase_baseClass.writeText(treeSearchBx, astr_EntityRecord);
	}	
	
	// Click on Entity record under Grid
	public void clickOnEntityRecord(String astr_EntityRecord) throws InterruptedException
	{
		CommonBean.lbase_baseClass.doubleClick(getentityRowRecord(astr_EntityRecord));
	}
	// Click on field name in a particular Entity record under Grid
	public void clickOnAttachmentField(String astr_attachmentfield) throws InterruptedException
	{
		CommonBean.lbase_baseClass.clickButton(getFieldNameInEntityRow(astr_attachmentfield));
	}
	
//	// Click on field name in a particular Entity record under Grid
//	public void clickOnAttachmentField(String astr_attachmentfield) throws InterruptedException
//	{
//		CommonBean.lbase_baseClass.clickButton(getFieldNameInEntityRow(astr_attachmentfield));
//	}
	
	//Search Entity Field and View Records 
	public Boolean verifyEntityFieldAndViewRecords(String EntityName,String EntityRecord,String FieldName) throws Throwable
	{
		Boolean result = false;
		try {
			// Search Entity
			CommonBean.lbase_baseClass.writeText(gettreeSearchBx(), EntityName);
			CommonBean.lbase_baseClass.pressEnter();			
			CommonBean.lbase_baseClass.actionClick(getEntitylevelfields());
			Thread.sleep(2000);		
			// Search Entity Record
			CommonBean.lbase_baseClass.writeText(getsearchBxGridData(), EntityRecord);			
			CommonBean.lbase_baseClass.doubleClick(getentityRowRecord(EntityRecord));
			CommonBean.lbase_baseClass.actionClick(getFieldNameInEntityRow(FieldName));
			Thread.sleep(1000);	
			BaseClass.getScreenshot("Entity Field Record Result - ");
			if(getDownloadParentfile().isDisplayed())
				result =true;
		}
		catch(Exception e) {
			result=false;
			e.printStackTrace();
		}
		if(getsearchBxGridData().isDisplayed())
			getsearchBxGridData().clear();
		if(gettreeSearchBx().isDisplayed())
			gettreeSearchBx().clear();
		return result;		
	}
	
	//Search Workflow Field and View Records 
	public Boolean verifyWorkflowFieldAndViewRecords(String EntityName,String EntityRecord,String FieldName) throws Throwable
	{
		Boolean result = false;
		try
		{
			// Search Entity
			CommonBean.lbase_baseClass.writeText(gettreeSearchBx(), EntityName);
			CommonBean.lbase_baseClass.pressEnter();			
			CommonBean.lbase_baseClass.actionClick(getWorkflowlevelfields());
			Thread.sleep(2000);
			if(getloadingicon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
			Thread.sleep(2000);
			// Search Entity Record
			CommonBean.lbase_baseClass.writeText(getsearchBxGridData(), EntityRecord);			
			CommonBean.lbase_baseClass.doubleClick(getentityRowRecord(EntityRecord));
			CommonBean.lbase_baseClass.actionClick(getFieldNameInEntityRow(FieldName));
			Thread.sleep(1000);
			BaseClass.getScreenshot("Workflow Field Record Result - ");
			if(getDownloadParentfile().isDisplayed())
				result =true;
		}
		catch(Exception e)
		{
			result=false;
			e.printStackTrace();
		}
		if(getsearchBxGridData().isDisplayed())
			getsearchBxGridData().clear();
		if(gettreeSearchBx().isDisplayed())
			gettreeSearchBx().clear();
		return result;		
	}
	
	//Search a Entity
	public Boolean SearchEntityDocumentManager(String EntityName) throws Throwable
	{
		Boolean result = false;
		try {
			// Search Entity
			CommonBean.lbase_baseClass.writeText(gettreeSearchBx(), EntityName);

			CommonBean.lbase_baseClass.pressEnter();		
			Thread.sleep(1000);		
			if(CommonBean.lbase_baseClass.getText(getSearchEntityResult()).equals(EntityName))
				result =true;
			BaseClass.getScreenshot("Search Entity Result - ");
		}
		catch(Exception e)
		{
			result=false;
			e.printStackTrace();
		}
		if(gettreeSearchBx().isDisplayed())
			gettreeSearchBx().clear();		
		return result;		
	}
	
	//Search a Entity Record
	public Boolean SearchEntityRecordDocumentManager(String EntityName,String EntityRecord) throws Throwable
	{
		Boolean result = false;
		try
		{
			// Search Entity
			CommonBean.lbase_baseClass.writeText(gettreeSearchBx(), EntityName);

			CommonBean.lbase_baseClass.pressEnter();
			CommonBean.lbase_baseClass.actionClick(getEntitylevelfields());
			Thread.sleep(2000);		
			CommonBean.lbase_baseClass.writeText(getsearchBxGridData(), EntityRecord);		
			if(CommonBean.lbase_baseClass.getText(getSearchRecordResult()).equals(EntityRecord))
				result =true;
			BaseClass.getScreenshot("Search Entity Record Result - ");
			}
		catch(Exception e)
		{
			result =false;
			e.printStackTrace();
		}
		if(getsearchBxGridData().isDisplayed())
			getsearchBxGridData().clear();
		if(gettreeSearchBx().isDisplayed())
			gettreeSearchBx().clear();	
		return result;		
	}
	
	//Download Parent Version
	public Boolean VerifyDownloadParentVersion(String EntityName,String EntityRecord,String FieldName) throws Throwable
	{
		Boolean result = false;
		String fileName,CurrentHandle;
		try
		{
			// Search Entity
			CommonBean.lbase_baseClass.writeText(gettreeSearchBx(), EntityName);
			CommonBean.lbase_baseClass.pressEnter();
			CommonBean.lbase_baseClass.actionClick(getEntitylevelfields());
			Thread.sleep(2000);		
			CommonBean.lbase_baseClass.writeText(getsearchBxGridData(), EntityRecord);	
			CommonBean.lbase_baseClass.doubleClick(getentityRowRecord(EntityRecord));
			CommonBean.lbase_baseClass.actionClick(getFieldNameInEntityRow(FieldName));
			Thread.sleep(1000);
			fileName=CommonBean.lbase_baseClass.getText(getParentFileName());
			CurrentHandle=driver.getWindowHandle();
			CommonBean.lbase_baseClass.actionClick(getDownloadParentfile());
			Thread.sleep(1000);
			Set<String> tabs=driver.getWindowHandles();
			for(String handle:tabs)
			{
				if(!handle.equals(CurrentHandle))
				{
					driver.switchTo().window(handle);
					BaseClass.getScreenshot("Download Parent Version Result -");
					if(CommonBean.lbase_baseClass.getpageTitle().contains(fileName))
						result=true;
					driver.close();
					driver.switchTo().window(CurrentHandle);
				}
			}
		}
		catch(Exception e)
		{
			result=false;
			e.printStackTrace();
		}
		if(getsearchBxGridData().isDisplayed())
			getsearchBxGridData().clear();
		if(gettreeSearchBx().isDisplayed())
			gettreeSearchBx().clear();	
		return result;		
	}
	
	//Download All Version
	public Boolean VerifyDownloadAllVersion(String EntityName,String EntityRecord,String FieldName) throws Throwable
	{
		Boolean result = false;
		String fileName,CurrentHandle;
		int ElementCount,i;
		try
		{
			// Search Entity
			CommonBean.lbase_baseClass.writeText(gettreeSearchBx(), EntityName);
			CommonBean.lbase_baseClass.pressEnter();
			CommonBean.lbase_baseClass.actionClick(getEntitylevelfields());
			Thread.sleep(2000);		
			CommonBean.lbase_baseClass.writeText(getsearchBxGridData(), EntityRecord);	
			CommonBean.lbase_baseClass.doubleClick(getentityRowRecord(EntityRecord));
			CommonBean.lbase_baseClass.actionClick(getFieldNameInEntityRow(FieldName));
			Thread.sleep(1000);
			CurrentHandle=driver.getWindowHandle();
			ElementCount = driver.findElements(By.xpath("//div[@class='col-sm-12 padding-zero document-versionhistory-grid-height']//div[@class='col-sm-12 padding-zero grid-document-row-bg ng-scope']")).size();			
			for(i=1;i<=ElementCount;i++)
			{
				fileName = driver.findElement(By.xpath("//div[@class='col-sm-12 padding-zero document-versionhistory-grid-height']//div[@class='col-sm-12 padding-zero grid-document-row-bg ng-scope']["+i+"]//div[2]")).getText();
				driver.findElement(By.xpath("//div[@class='col-sm-12 padding-zero document-versionhistory-grid-height']//div[@class='col-sm-12 padding-zero grid-document-row-bg ng-scope']["+i+"]//div[5]")).click();
				Thread.sleep(1000);
				Set<String> tabs=driver.getWindowHandles();
				for(String handle:tabs)
				{
					if(!handle.equals(CurrentHandle))
					{
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
		catch(Exception e)
		{
			result=false;
			e.printStackTrace();
		}
		if(getsearchBxGridData().isDisplayed())
			getsearchBxGridData().clear();
		if(gettreeSearchBx().isDisplayed())
			gettreeSearchBx().clear();	
		return result;		
	}
		
		
//	public Boolean ValidateDocument(String astr_entityfield, String astr_record, String astr_entity) throws InterruptedException
//	{
//		searchEntityType(astr_entity);
//		Thread.sleep(2000);
//		
//		if(getEntityType().isPresent()) {
//			clickEntitylevelfields();
//			Thread.sleep(2000);
//			if(getentityRowRecord(astr_record).isPresent())	{
//				clickOnEntityRecord(astr_record);
//				Thread.sleep(1500);
//				
//				clickOnAttachmentField(astr_entityfield);
//				Thread.sleep(1500);
//			}
//			else {
//				System.out.println("No such entity record exists");
//			}		
//			
//			Thread.sleep(1500);
//			return true;
//		}
//		else
//		{
//			System.out.println("No such entity exists");
//			return false;
//		}		
//	}
	
	
	
	protected void openPage(PageLocator locator, Object... args) {
				
	}
	
	
}
	

