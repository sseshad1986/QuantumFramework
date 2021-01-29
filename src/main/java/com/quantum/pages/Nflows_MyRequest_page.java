package com.quantum.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.helper.BaseClass;
import com.quantum.helper.ExtentManager;
import com.quantum.utils.DeviceUtils;


@SuppressWarnings("static-access")
public class Nflows_MyRequest_page extends WebDriverBaseTestPage<WebDriverTestPage>
{			
	//locator repository for My Request page	
	@FindBy (locator = "nflows.myrequest.searchbx.txtbx")
	private QAFExtendedWebElement searchbxRequest;
	
	@FindBy (locator = "nflows.myrequest.recalculate.btn")
	private QAFExtendedWebElement recalculate;
	
	@FindBy (locator = "nflows.myrequest.newRequest.btn")
	private QAFExtendedWebElement newRequest;
	
	@FindBy (locator = "nflows.myrequest.graphnode.lnk")
	private QAFExtendedWebElement graphnode;
	
	@FindBy (locator = "nflows.myrequest.parentplusBtn.btn")
	private QAFExtendedWebElement parentplusBtn;
	
	@FindBy (locator = "nflows.myrequest.showOtherRequest.chkbx")
	private QAFExtendedWebElement showOtherRequest;
	
	@FindBy (locator = "nflows.myrequest.loader")
	private QAFExtendedWebElement loadericon;
	
	//locator repository for New Request page	
	@FindBy (locator = "nflows.myrequest.newRequest.workflowName")
	private QAFExtendedWebElement workflowName;
		
	@FindBy (locator = "nflows.myrequest.newRequest.entityName")
	private QAFExtendedWebElement entityName;
	
	@FindBy (locator = "nflows.myrequest.newRequest.searchRecord")
	private QAFExtendedWebElement searchRecord;
	
	@FindBy (locator = "nflows.myrequest.newRequest.back")
	private QAFExtendedWebElement back;
	
	@FindBy (locator = "nflows.myrequest.newRequest.entityRecordLookupNewReq")
	private QAFExtendedWebElement entityRecordLookupNewReq;
	
	@FindBy (locator = "nflows.myrequest.newRequest.start")
	private QAFExtendedWebElement startBtn;	
	
	@FindBy (locator="nflows.myrequest.newRequest.checkIniation")
	private QAFExtendedWebElement checkInitiation;
	
	//locator repository for New Request pop up
	@FindBy (locator = "nflows.myrequest.newRequest.popup")
	private QAFExtendedWebElement searchPopup;
	
	@FindBy (locator = "nflows.myrequest.newRequest.searchInitiation")
	private QAFExtendedWebElement searchInitiation;
	
	@FindBy (locator = "nflows.myrequest.newRequest.addInitiation")
	private QAFExtendedWebElement addInitiation;
	
	@FindBy (locator = "nflows.myrequest.newRequest.closeInitiation")
	private QAFExtendedWebElement closeInitiation;
	
	//locator repository for New Request grid elements (rows and column)
	@FindBy (locator = "nflows.myrequest.newRequest.datagrid")
	private List<QAFExtendedWebElement>  datagrid;
	
	@FindBy (locator = "nflows.myrequest.newRequest.gridHeader")
	private QAFExtendedWebElement gridHeader;
	
	@FindBy (locator = "nflows.myrequest.newRequest.dataRows")
	private List<QAFExtendedWebElement> dataRows;
	
	@FindBy (locator = "nflows.myrequest.newRequest.singledataRow")
	private QAFExtendedWebElement singledataRow;
	
	@FindBy (locator = "nflows.myrequest.baselineTargetDate")
	private QAFExtendedWebElement baselineTargetDate;
	
	@FindBy (locator = "nflows.myrequest.estimatedTargetDate")
	private QAFExtendedWebElement estimatedTargetDate;
	
	@FindBy (locator = "nflows.myrequest.actualStartDate")
	private QAFExtendedWebElement actualStartDate;
	
	@FindBy (locator = "nflows.myrequest.actualCompletionDate")
	private QAFExtendedWebElement actualCompletionDate;
	
	@FindBy (locator = "nflows.myrequest.cancelledTab")
	private QAFExtendedWebElement cancelledTab;
	
	@FindBy (locator = "nflows.myrequest.delayedTab")
	private QAFExtendedWebElement delayedTab;
	
// ------------------------------         Locators Ends here !          ----------------------------------------------------	

	public QAFExtendedWebElement getCancelledTab() {
		return cancelledTab;
	}
	public QAFExtendedWebElement getDelayedTab() {
		return delayedTab;
	}
	
	public QAFExtendedWebElement getBaselineTargetDate() {
		return baselineTargetDate;
	}
	public QAFExtendedWebElement getEstimatedTargetDate() {
		return estimatedTargetDate;
	}
	public QAFExtendedWebElement getActualStartDate() {
		return actualStartDate;
	}
	public QAFExtendedWebElement getActualCompletionDate() {
		return actualCompletionDate;
	}
	public QAFExtendedWebElement getsearchbxRequest() {
		return searchbxRequest;
	}
	
	public QAFExtendedWebElement getrecalculate() {
		return recalculate;
	}
	public QAFExtendedWebElement getnewRequest() {
		return newRequest;
	}
	
	public QAFExtendedWebElement getgraphnode() {
		return graphnode;
	}
	
	public QAFExtendedWebElement getparentplusBtn() {
		return parentplusBtn;
	}
	
	public QAFExtendedWebElement getshowOtherRequest() {
		return showOtherRequest;
	}	
	
	public QAFExtendedWebElement getloadericon() {
		return loadericon;
	}
	
	public List<QAFExtendedWebElement> getdataRows() {
		return dataRows;
	}
	
	public QAFExtendedWebElement getsearchPopup() {
		return searchPopup;
	}	
	
	public QAFExtendedWebElement getClickWorkflowName(String astr_workflowName)
	{
		String loc = String.format(pageProps.getString("nflows.myrequest.newRequest.workflowName"), astr_workflowName);
		return new QAFExtendedWebElement(loc);
	}
	
	public QAFExtendedWebElement getClickEntityName(String astr_entityName)
	{
		String loc = String.format(pageProps.getString("nflows.myrequest.newRequest.entityName"), astr_entityName);
		return new QAFExtendedWebElement(loc);
	}
	
	public QAFExtendedWebElement getClickEntityName() {
		return entityName;
	}
	
	public QAFExtendedWebElement getSearchRecord() {
		return searchRecord;
	}
	public QAFExtendedWebElement getBack() {
		return back;
	}
	
	public QAFExtendedWebElement getStart() 
	{
		return 	startBtn;
	}
	
	public QAFExtendedWebElement getCheckInitiation() 
	{		
		return checkInitiation;
	}
	
	public QAFExtendedWebElement getClickentityRecordLookup() {
		return entityRecordLookupNewReq;
	}
	
	public QAFExtendedWebElement getSearchInitiation() {
		return searchInitiation;
	}
	
	public QAFExtendedWebElement getAddInitiation() {
		return addInitiation;
	}
	
	public QAFExtendedWebElement getCloseInitiation() {
		return closeInitiation;
	}
	
	public List<QAFExtendedWebElement>  getDatagrid() {
		return datagrid;
	}
	
	public QAFExtendedWebElement getGridHeader() {
		return gridHeader;
	}
	
	public List<QAFExtendedWebElement> getDataRows() {
		return dataRows;
	}
	
	public QAFExtendedWebElement getSingledataRow() {
		return singledataRow;
	}
	
		
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	// ------------------------------         Getter method Ends here !          ----------------------------------------------------
	
	// Method Author : M.S.Sumesh 
	public void searchRequest(String astr_searchCriteria ) throws InterruptedException, IOException 
	{
		try 
		{
			CommonBean.lbase_baseClass.waitBeforeClick(getsearchbxRequest());
			if(getsearchbxRequest().isDisplayed())
			{
				CommonBean.lbase_baseClass.writeText(getsearchbxRequest(),astr_searchCriteria);		
				Thread.sleep(500);
				getsearchbxRequest().sendKeys(Keys.ENTER);
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadericon());			
				//CommonBean.lbase_baseClass.explicitElementToBeClickable(getnewRequest());
				CommonBean.lbase_baseClass.getScreenshot("Search for My request is done successfully");			
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	// Method Author : M.S.Sumesh 
	public void clickRecalculate() throws InterruptedException, IOException 
	{				
		try {
			CommonBean.lbase_baseClass.clickButton(getrecalculate());		
			Thread.sleep(1500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	// Method Author : M.S.Sumesh 
	public void createNewRequest() throws InterruptedException 
	{		
		try {
			CommonBean.lbase_baseClass.clickButton(getnewRequest());		
			Thread.sleep(1500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	// Method Author : M.S.Sumesh 
	public Boolean clickWorkflowName(String astr_workflowName) throws InterruptedException 
	{		
		Boolean isWorkflowExist=false;
		try 
		{
			if(getClickWorkflowName(astr_workflowName).isDisplayed())
			{
				CommonBean.lbase_baseClass.clickButton(getClickWorkflowName(astr_workflowName));
				isWorkflowExist=true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isWorkflowExist;
	}
	
	// Method Author : M.S.Sumesh 
	public void clickentityRecordLookup() throws InterruptedException 
	{	
		try {
			CommonBean.lbase_baseClass.clickButton(getClickentityRecordLookup());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Method Author : M.S.Sumesh 
	public void selectRequest(String astr_searchInitiation,String gridData) throws InterruptedException, IOException
	{
		try {
			Thread.sleep(2000);		
			if(astr_searchInitiation!=null)
			{
				CommonBean.lbase_baseClass.waitBeforeClick(getsearchPopup());   
				CommonBean.lbase_baseClass.writeText(getSearchInitiation(), astr_searchInitiation);	
				Thread.sleep(1500);
			}
			
			if(getDataRows().size()>0)
			{			
				gridHandle(gridData);				
			}
			else
			{
				System.out.println(" - -  There are no records for request  --");
				BaseClass.getScreenshot("There are no records for request");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	
	// Method Author : M.S.Sumesh 
	public void clickShowOtherRequest() throws InterruptedException, IOException 
	{				
		try {
			CommonBean.lbase_baseClass.clickButton(getshowOtherRequest());		
			
			//CommonBean.lbase_baseClass.explicitVisibilityOf(getloadericon());		
			CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadericon());
			if(getshowOtherRequest().isEnabled())
			{
				CommonBean.lbase_baseClass.getScreenshot("Click on Other request is successful");	
			}
			else
			{
				CommonBean.lbase_baseClass.getScreenshot("Failure on - Other request");	
				System.out.println("Show Other request is not selected ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	public void clickGraphNode() throws InterruptedException 
	{		 
			
	}
	public void expandParentGrid() throws InterruptedException 
	{		
			
	}
	
	// Method Author : M.S.Sumesh 
	public void gridHandle(String astr_gridData) throws InterruptedException, IOException
	{	
		try 
		{
			List<String> larl_gridData = new ArrayList<String>();
			larl_gridData=Arrays.asList(astr_gridData.split(";"));
			
			int int_size=larl_gridData.size();        
				
			WebElement datagrid=DeviceUtils.getQAFDriver().findElement(By.xpath("//div[@id='grid_scrn']"));
			List<WebElement> dataRows=datagrid.findElements(By.xpath("//div[@ng-style='rowStyle(row)']"));
						
			for(int j=1;j<dataRows.size();j++)	
			{			
				List<WebElement> singleRow =dataRows.get(j).findElements(By.xpath("(//div[@id='grid_scrn']//div[@ng-style='rowStyle(row)'][" + j +"]//div[contains(@class,'ngCellText')])"));				
				switch(int_size)
				{					
					case 2:
						if(singleRow.get(1).getText().trim().toLowerCase().equalsIgnoreCase(larl_gridData.get(0).trim().toLowerCase()) && singleRow.get(2).getText().trim().toLowerCase().equalsIgnoreCase(larl_gridData.get(1).trim().toLowerCase()))
						{
							System.out.println("Request record is matching !");	
							QAFExtendedWebElement aQAF_Element=new WebDriverTestBase().getDriver().findElement(By.xpath("(//div[@id='grid_scrn']//div[@ng-style='rowStyle(row)'])[" + j +"]"));
							
							CommonBean.lbase_baseClass.highLightElement(aQAF_Element);
							Thread.sleep(2500);
							BaseClass.getScreenshot("New Request will be triggered for highlighted data");
							
							System.out.println("((//div[@id='grid_scrn']//div[@ng-style='rowStyle(row)'])[" + j +"]//div[contains(@class,'ngCellText')])[1]");
							singleRow.get(1).findElement(By.xpath("((//div[@id='grid_scrn']//div[@ng-style='rowStyle(row)'])[" + j +"]//div[contains(@class,'ngCellText')])[2]")).click();
							j=dataRows.size()+1;					
						}
						break;
					case 4:
						if(singleRow.get(1).getText().trim().toLowerCase().equalsIgnoreCase(larl_gridData.get(0).trim().toLowerCase()) && singleRow.get(2).getText().trim().toLowerCase().equalsIgnoreCase(larl_gridData.get(1).trim().toLowerCase()) && 
							singleRow.get(3).getText().trim().toLowerCase().equalsIgnoreCase(larl_gridData.get(2).trim().toLowerCase()) && singleRow.get(4).getText().trim().toLowerCase().equalsIgnoreCase(larl_gridData.get(3).trim().toLowerCase()))
						{
							System.out.println("Request record is matching !");	
							QAFExtendedWebElement aQAF_Element=new WebDriverTestBase().getDriver().findElement(By.xpath("(//div[@id='grid_scrn']//div[@ng-style='rowStyle(row)'])[" + j +"]"));
							
							CommonBean.lbase_baseClass.highLightElement(aQAF_Element);
							Thread.sleep(2500);
							BaseClass.getScreenshot("New Request will be triggered for highlighted data");
							
							singleRow.get(0).findElement(By.xpath("((//div[@id='grid_scrn']//div[@ng-style='rowStyle(row)'])[" + j +"]//div[contains(@class,'ngCellText')])[2]")).click();
							j=dataRows.size()+1;				
						}
						break;	
				}
			}
				
			CommonBean.lbase_baseClass.getScreenshot("Click on request record");		
			CommonBean.lbase_baseClass.clickButton(getAddInitiation());	
			Thread.sleep(1500);	
			
			CommonBean.lbase_baseClass.getScreenshot("Check data before starting request");
			
			CommonBean.lbase_baseClass.clickButton(getStart());
			Thread.sleep(2500);				
			
			CommonBean.lbase_baseClass.clickButton(getBack());			
			CommonBean.lbase_baseClass.waitForVisibility(getloadericon());		
			CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadericon());
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

// Method Author : Shayina
public String CheckRequestStatus(String astr_requestName) throws InterruptedException, IOException
{	
	String status=null;
	try 
	{
	
		String text=getRequestGrid(astr_requestName).get(13).getText();
		CommonBean.lbase_baseClass.moveTo((QAFExtendedWebElement) getRequestGrid(astr_requestName).get(13));
		CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getRequestGrid(astr_requestName).get(13));
		status=text;
	} 
	catch (Exception e) {
		
		e.printStackTrace();
	}
	return status;
}

//Method Author : Shayina
public List<WebElement> getRequestGrid( String filterData) throws InterruptedException, IOException
{	
	Thread.sleep(10000);
	List<WebElement> gridCellElementsList=new ArrayList<WebElement>();
	List<WebElement> gridRowElementsList=new WebDriverTestBase().getDriver().findElements(By.xpath("//div[@ng-repeat='(rowRenderIndex, row) in rowContainer.renderedRows track by $index']"));
	//System.out.println("Row size: "+gridRowElementsList.size());
	for(int i=0;i<gridRowElementsList.size();i++) {
		if(gridRowElementsList.get(i).getText().contains(filterData	)){
		gridCellElementsList=gridRowElementsList.get(i).findElements(By.xpath("//div[@ng-dblclick='grid.appScope.edit(row)']"));
		System.out.println("Cell size: "+gridCellElementsList.size());
	/*	for(int j=0;j<gridCellElementsList.size();j++) {
		System.out.println("elements text of: " + j+" ------   "+gridCellElementsList.get(j).getText());
		//CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) gridCellElementsList.get(j));
		}*/
	}
	}
	return gridCellElementsList;
}
//Method Author : Shayina
public String getRequestDate( String dateParameter, String filterData) throws InterruptedException, IOException
{	

	String date=null;
		switch (dateParameter) {
		case "BaselineTargetDate":
			String baselineDate = getRequestGrid(filterData).get(8).getText();
			CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getRequestGrid(filterData).get(8));
			date=baselineDate;
			String[] requestDate=baselineDate.split(" ");
			@SuppressWarnings("deprecation")
			Date date1=new Date(requestDate[0]);
			SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
			date = df2.format(date1);
			break;
			
		case "EstimatedTargetDate":
			String estimatedDate = getRequestGrid(filterData).get(9).getText();
			CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getRequestGrid(filterData).get(9));
			date=estimatedDate;
			requestDate=estimatedDate.split(" ");
			@SuppressWarnings("deprecation")
			Date date2=new Date(requestDate[0]);
			df2 = new SimpleDateFormat("dd/MM/yyyy");
			date = df2.format(date2);
			break;
			
		case "ActualStartDate":
			String startDate = getRequestGrid(filterData).get(10).getText();
			CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getRequestGrid(filterData).get(10));
			requestDate=startDate.split(" ");
			@SuppressWarnings("deprecation")
			Date date3=new Date(requestDate[0]);
			df2 = new SimpleDateFormat("dd/MM/yyyy");
			date = df2.format(date3);
			break;
			
		case "ActualCompletionDate":
			String completionDate = getRequestGrid(filterData).get(11).getText();
			CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getRequestGrid(filterData).get(11));
			requestDate=completionDate.split(" ");
			@SuppressWarnings("deprecation")
			Date date4=new Date(requestDate[0]);
			df2 = new SimpleDateFormat("dd/MM/yyyy");
			date = df2.format(date4);
			break;
			
		}
		return date;
}
public void expandReqGrid() throws InterruptedException, IOException {
	QAFExtendedWebElement gridExpandElement=DeviceUtils.getQAFDriver().findElement(By.xpath("//i[@ng-click='grid.api.expandable.toggleRowExpansion(row.entity, $event)']"));
	CommonBean.lbase_baseClass.clickButton(gridExpandElement);
	Thread.sleep(3000);
}
public void expandSubWFGrid(String SubWFName) throws InterruptedException, IOException {
	String[] SubWFdata=SubWFName.split("-");
	int SubWFIndex=(Integer.parseInt(SubWFdata[0]))+1;
	QAFExtendedWebElement gridExpandElement=DeviceUtils.getQAFDriver().findElement(By.xpath("(//i[@ng-click='grid.api.expandable.toggleRowExpansion(row.entity, $event)'])["+SubWFIndex+"]"));
	CommonBean.lbase_baseClass.clickButton(gridExpandElement);
}

//Method Author : Shayina
public List<WebElement> getTaskGrid( String filterData) throws InterruptedException, IOException
{	
	Thread.sleep(3000);
	List<WebElement> gridCellElementsList=new ArrayList<WebElement>();
	List<WebElement> taskCellElementsList=new ArrayList<WebElement>();
	List<WebElement> gridRowElementsList=new WebDriverTestBase().getDriver().findElements(By.xpath("(//div[@class='ui-grid-canvas'])[6]//div[@ng-repeat='(rowRenderIndex, row) in rowContainer.renderedRows track by $index']"));
	for(int rowIndex=1;rowIndex<=gridRowElementsList.size();rowIndex++) {
		gridCellElementsList=new WebDriverTestBase().getDriver().findElements(By.xpath("((//div[@class='ui-grid-canvas'])[6]//div[@ng-repeat='(rowRenderIndex, row) in rowContainer.renderedRows track by $index'])["+rowIndex+"]//div[@class='ui-grid-cell-contents ng-scope']"));
	for(int cellIndex=0;cellIndex<gridCellElementsList.size();cellIndex++) {
		//gridCellElementsList=new WebDriverTestBase().getDriver().findElements(By.xpath("((//div[@ng-repeat='(rowRenderIndex, row) in rowContainer.renderedRows track by $index'])["+rowIndex+"]//div[@ng-dblclick='grid.appScope.onGridDblClick(row)'])["+cellIndex+"]"));
		if(gridCellElementsList.get(cellIndex).getText().equalsIgnoreCase(filterData)) {
		taskCellElementsList=new WebDriverTestBase().getDriver().findElements(By.xpath("((//div[@class='ui-grid-canvas'])[6]//div[@ng-repeat='(rowRenderIndex, row) in rowContainer.renderedRows track by $index'])["+rowIndex+"]//div[@class='ui-grid-cell-contents ng-scope']"));
		break;
		}
		}
	}return taskCellElementsList;
}
//Method Author : Shayina
public String CheckTaskStatus(String astr_taskName) throws InterruptedException, IOException
{	
	String status=null;
	try 
	{
	
		String text=getTaskGrid(astr_taskName).get(8).getText();
		CommonBean.lbase_baseClass.moveTo((QAFExtendedWebElement) getTaskGrid(astr_taskName).get(8));
		CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getTaskGrid(astr_taskName).get(8));
		status=text;
	} 
	catch (Exception e) {
		
		e.printStackTrace();
	}
	return status;
}

//Method Author: Shayina
public void viewTask(String astr_taskName)throws InterruptedException, IOException
	 {
	CommonBean.lbase_baseClass.moveTo((QAFExtendedWebElement) getTaskGrid(astr_taskName).get(1));
	CommonBean.lbase_baseClass.doubleClick((QAFExtendedWebElement) getTaskGrid(astr_taskName).get(1));
}

//Method Author : Shayina
public String getTaskData( String taskParameter, String filterData) throws InterruptedException, IOException
{	

	String taskData=null;
		switch (taskParameter) {
		case "BaselineTargetDate":
			String baselineDate = getTaskGrid(filterData).get(2).getText();
			CommonBean.lbase_baseClass.moveTo((QAFExtendedWebElement) getTaskGrid(filterData).get(2));
			CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getTaskGrid(filterData).get(2));
			String[] taskDate=baselineDate.split(" ");
			@SuppressWarnings("deprecation")
			Date date=new Date(taskDate[0]);
			SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
	        taskData = df2.format(date);
	        
			break;
			
		case "EstimatedTargetDate":
			String estimatedDate = getTaskGrid(filterData).get(4).getText();
			CommonBean.lbase_baseClass.moveTo((QAFExtendedWebElement) getTaskGrid(filterData).get(4));
			CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getTaskGrid(filterData).get(4));
			taskDate=estimatedDate.split(" ");
			@SuppressWarnings("deprecation")
			Date date2=new Date(taskDate[0]);
			df2 = new SimpleDateFormat("dd/MM/yyyy");
			taskData = df2.format(date2);
			break;
			
		case "ActualStartDate":
			String startDate = getTaskGrid(filterData).get(3).getText();
			CommonBean.lbase_baseClass.moveTo((QAFExtendedWebElement) getTaskGrid(filterData).get(3));
			CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getTaskGrid(filterData).get(3));
			taskDate=startDate.split(" ");
			@SuppressWarnings("deprecation")
			Date date3=new Date(taskDate[0]);
			df2 = new SimpleDateFormat("dd/MM/yyyy");
			taskData = df2.format(date3);
			break;
			
		case "ActualCompletionDate":
			String completionDate = getTaskGrid(filterData).get(5).getText();
			CommonBean.lbase_baseClass.moveTo((QAFExtendedWebElement) getTaskGrid(filterData).get(5));
			CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getTaskGrid(filterData).get(5));
			taskData=completionDate;
			taskDate=completionDate.split(" ");
			@SuppressWarnings("deprecation")
			Date date4=new Date(taskDate[0]);
			df2 = new SimpleDateFormat("dd/MM/yyyy");
			taskData = df2.format(date4);
			break;
			
		case "Progress":
			String Progress = getTaskGrid(filterData).get(11).getText();
			CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getTaskGrid(filterData).get(11));
			taskData=Progress;
			break;
		
		case "AssignedTo":
			String AssignedTo = getTaskGrid(filterData).get(6).getText();
			CommonBean.lbase_baseClass.moveTo((QAFExtendedWebElement) getTaskGrid(filterData).get(6));
			CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getTaskGrid(filterData).get(6));
			taskData=AssignedTo;
			break;
			
		case "PerformedBy":
			String PerformedBy = getTaskGrid(filterData).get(7).getText();
			CommonBean.lbase_baseClass.moveTo((QAFExtendedWebElement) getTaskGrid(filterData).get(7));
			CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getTaskGrid(filterData).get(7));
			taskData=PerformedBy;
			break;
			
		}
		return taskData;
}

//Method Author : Shayina
public List<WebElement> getSubWFGrid( String filterData) throws InterruptedException, IOException
{	
	String[] SubWF=filterData.split("-");
	int SubWFIndex=(Integer.parseInt(SubWF[0]));
	String subWFName=SubWF[1];
	Thread.sleep(3000);
//	List<WebElement> gridCellElementsList=new ArrayList<WebElement>();
	List<WebElement> subwfCellElementsList=new WebDriverTestBase().getDriver().findElements(By.xpath("((//div[@class='ui-grid-canvas'])[4]//div[@ng-repeat='(rowRenderIndex, row) in rowContainer.renderedRows track by $index'])["+SubWFIndex+"]//div[@class='ui-grid-cell-contents ng-scope']"));

	return subwfCellElementsList;
}

//Method Author : Shayina
public String getSubworkflowData( String subwfParameter, String filterData) throws InterruptedException, IOException
{
	String subWFData =null;
	switch (subwfParameter) {
	case "BaselineTargetDate":
		String baselineDate = getSubWFGrid(filterData).get(1).getText();
		CommonBean.lbase_baseClass.moveTo((QAFExtendedWebElement) getSubWFGrid(filterData).get(1));
		CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getSubWFGrid(filterData).get(1));
		String[] subwfDate=baselineDate.split(" ");
		@SuppressWarnings("deprecation")
		Date date1=new Date(subwfDate[0]);
		SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
		subWFData = df2.format(date1);
		break;
		
	case "EstimatedTargetDate":
		String estimatedDate = getSubWFGrid(filterData).get(3).getText();
		CommonBean.lbase_baseClass.moveTo((QAFExtendedWebElement) getSubWFGrid(filterData).get(3));
		CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getSubWFGrid(filterData).get(3));
		subwfDate=estimatedDate.split(" ");
		@SuppressWarnings("deprecation")
		Date date2=new Date(subwfDate[0]);
		df2 = new SimpleDateFormat("dd/MM/yyyy");
		subWFData = df2.format(date2);
		break;
		
	case "ActualStartDate":
		String startDate = getSubWFGrid(filterData).get(2).getText();
		CommonBean.lbase_baseClass.moveTo((QAFExtendedWebElement) getSubWFGrid(filterData).get(2));
		CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getSubWFGrid(filterData).get(2));
		subwfDate=startDate.split(" ");
		@SuppressWarnings("deprecation")
		Date date3=new Date(subwfDate[0]);
		df2 = new SimpleDateFormat("dd/MM/yyyy");
		subWFData = df2.format(date3);
		break;
		
	case "ActualCompletionDate":
		String completionDate = getSubWFGrid(filterData).get(4).getText();
		CommonBean.lbase_baseClass.moveTo((QAFExtendedWebElement) getSubWFGrid(filterData).get(4));
		CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getSubWFGrid(filterData).get(4));
		subwfDate=completionDate.split(" ");
		@SuppressWarnings("deprecation")
		Date date4=new Date(subwfDate[0]);
		df2 = new SimpleDateFormat("dd/MM/yyyy");
		subWFData = df2.format(date4);
		break;
		
	case "Progress":
		String Progress = getSubWFGrid(filterData).get(6).getText();
		CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getSubWFGrid(filterData).get(6));
		subWFData=Progress;
		break;
	
			
	case "Status":
		String Status = getSubWFGrid(filterData).get(5).getText();
		CommonBean.lbase_baseClass.moveTo((QAFExtendedWebElement) getSubWFGrid(filterData).get(5));
		CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getSubWFGrid(filterData).get(5));
		subWFData=Status;
		break;
		
	}
	return subWFData;
}



//Method Author : Shayina
public String CheckRequestProgress(String astr_requestName) throws InterruptedException, IOException
{	
	String requestProgress=null;
	try 
	{
		String text=getRequestGrid(astr_requestName).get(12).getText();
		CommonBean.lbase_baseClass.moveTo((QAFExtendedWebElement) getRequestGrid(astr_requestName).get(12));
		CommonBean.lbase_baseClass.highLightElement((QAFExtendedWebElement) getRequestGrid(astr_requestName).get(12));
		requestProgress=text;
	} 
	catch (Exception e) {
		
		e.printStackTrace();
	}
	return requestProgress;
}

}
