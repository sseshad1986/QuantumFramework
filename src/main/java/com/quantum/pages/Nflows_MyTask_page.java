package com.quantum.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.helper.BaseClass;
import com.quantum.utils.DeviceUtils;

//

@SuppressWarnings("static-access")
public class Nflows_MyTask_page extends WebDriverBaseTestPage<WebDriverTestPage> 
{
	@FindBy(locator = "myTask.loadingicon")
	private QAFExtendedWebElement loaderIcon;
	
	// Locators for User task	
	@FindBy(locator = "myTask.Search")
	private QAFExtendedWebElement myTaskSearch;
	
	@FindBy(locator = "myTask.GridtaskName")
	private QAFExtendedWebElement gridtaskName;

	@FindBy(locator = "Mytask.DelayedFilter")
	private QAFExtendedWebElement DelayedFilter;
	
	@FindBy(locator = "Mytask.On-TrackFilter")
	private QAFExtendedWebElement onTrackFilter;
	
	@FindBy(locator = "Mytask.Due-TodayFilter")
	private QAFExtendedWebElement DueTodayFilter;
	
	@FindBy(locator = "Mytask.AllFilter")
	private QAFExtendedWebElement AllFilter;
	
	@FindBy(locator = "myTask.gridData")
	private QAFExtendedWebElement UserTaskGriddata;
	
	@FindBy(locator = "myTask.gridHeader")
	private QAFExtendedWebElement myTaskGridHeader;
	
	@FindBy(locator = "myTask.gridAllRowData")
	private QAFExtendedWebElement allMyTaskRowData;	
	
	@FindBy(locator = "myTask.grid.nextPage")
	private QAFExtendedWebElement myTaskNextpage;	
	
	// Locators for Team task	
	@FindBy(locator = "TeamTask.Search")
	private QAFExtendedWebElement teamTaskSearch;
	
	@FindBy(locator = "TeamTask.gridHeader")
	private QAFExtendedWebElement TeamGrid;
	
	@FindBy(locator = "TeamTask.gridHeader")
	private QAFExtendedWebElement teamTaskGridHeader;
	
	@FindBy(locator = "TeamTask.gridAllRowData")
	private QAFExtendedWebElement allTeamTaskRowData;	
	
	@FindBy(locator = "TeamTask.grid.rowData")
	private QAFExtendedWebElement gridRowData;
	
	@FindBy(locator = "TeamTask.grid.nextPage")
	private QAFExtendedWebElement teamTaskNextpage;	
	
	@FindBy(locator = "TeamTask.DelayedFilter")
	private QAFExtendedWebElement teamTaskDelayedFilter;
		
// ------------------------------       Locator Ends here !          ----------------------------------------------------
	
	public QAFExtendedWebElement getteamTaskDelayedFilter()
	{
		List<WebElement> elements =driver.findElements(By.xpath("//a[contains(text(),'Delayed')]"));
		return (QAFExtendedWebElement)elements.get(1);
	}
	
	public QAFExtendedWebElement getteamTaskOnTrackFilter()
	{
		List<WebElement> elements =driver.findElements(By.xpath("//a[contains(text(),'On-Track')]"));
		return (QAFExtendedWebElement)elements.get(1);
	}
	
	public QAFExtendedWebElement getteamTaskDueTodayFilter()
	{
		List<WebElement> elements =driver.findElements(By.xpath("//a[contains(text(),'Due Today')]"));
		return (QAFExtendedWebElement)elements.get(1);
	}
	
	public QAFExtendedWebElement getteamTaskAllFilter()
	{
		List<WebElement> elements =driver.findElements(By.xpath("//a[contains(text(),'All - ')]"));
		return (QAFExtendedWebElement)elements.get(1);
	}
	
	public QAFExtendedWebElement getloaderIcon()
	{
		return loaderIcon;
	}
		
	public QAFExtendedWebElement getmyTaskSearch()
	{
		return myTaskSearch;
	}
	
	public QAFExtendedWebElement getGridtaskName() 
	{
		return gridtaskName;
	}
	
	public QAFExtendedWebElement getDelayedFilter() 
	{
		return DelayedFilter;
	}
	
	public QAFExtendedWebElement getonTrackFilter() 
	{
		return onTrackFilter;
	}
	
	public QAFExtendedWebElement getDueTodayFilter() 
	{
		return DueTodayFilter;
	}
	
	public QAFExtendedWebElement getAllFilter() 
	{
		return AllFilter;
	}
	
	public QAFExtendedWebElement getcheckUserTaskPresence()
	{
		return UserTaskGriddata;
	}
	
	public QAFExtendedWebElement getMyTaskGridHeader()
	{
		return myTaskGridHeader;
	}	
	
	public QAFExtendedWebElement getAllMyTaskRowData()
	{
		return allMyTaskRowData;
	}
	
	public QAFExtendedWebElement getmyTaskNextpage()
	{
		return myTaskNextpage;
	}
	
	// Team Task Getters ---------------------------------------------------
	
	public QAFExtendedWebElement getTeamTaskSearch()
	{
		return teamTaskSearch;
	}
	
	public QAFExtendedWebElement getcheckTeamTaskPresence(String astr_taskName)
	{	
		String loc = String.format(pageProps.getString("TeamTask.firstTaskName.data"), astr_taskName);	
		System.out.println(loc);
		return new QAFExtendedWebElement(loc);
	}
	
	public QAFExtendedWebElement getTeamTaskGridHeader()
	{
		return teamTaskGridHeader;
	}
	
	public QAFExtendedWebElement getAllTeamTaskRowData()
	{
		return allTeamTaskRowData;
	}
	
	public QAFExtendedWebElement getGridRowData(Integer rowNum,Integer colNum)
	{
		String loc = String.format(pageProps.getString("TeamTask.grid.rowData"), rowNum,colNum);
		System.out.println(loc);		
		return new QAFExtendedWebElement(loc);
	}	
	
	public QAFExtendedWebElement getTeamTaskNextpage()
	{
		return teamTaskNextpage;
	}
// ------------------------------         Getter method Ends here !          ----------------------------------------------------
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		Nflows_MyTask_page mytask = new Nflows_MyTask_page();
		CommonBean.lLogin_page.launch_application("http://192.168.1.107:8080/nFlowsEnhancementsRelease/login/login.jsp");
		CommonBean.lLogin_page.login_with_valid_username_and_password("Sumesh", "123");		
		CommonBean.lbase_baseClass.waitTill_ElementInvisible(mytask.getloaderIcon());
		CommonBean.lHome_page_home.navigateByMenu("My Task");		
		mytask.verifyTeamTaskAllFilter();
	}
	//Method owner : Vasanth
	public boolean verifyDelayTaskFilter() throws InterruptedException, IOException 
	{
		//CommonBean.lbase_baseClass.clickButton(getDelayedFilter());	
		Boolean result = null;		
		int rc;
		List<WebElement> rows;
		String str;
		try
		{
			CommonBean.lbase_baseClass.actionClick(getDelayedFilter());
			CommonBean.lbase_baseClass.sleep(1);
			if(getloaderIcon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
			CommonBean.lbase_baseClass.sleep(1);
			do
			{
				rows = driver.findElements(By.xpath("//div[contains(@ng-grid,'taskGrid')]//div[contains(@ng-style,'rowStyle(row)')]"));			
				rc = rows.size();
				for(int i =0;i<rc;i++)
				{
					str = driver.findElement(By.xpath("//div[contains(@ng-grid,'taskGrid')]//div[contains(@ng-style,'rowStyle(row)')]["+(i+1)+"]//div[@class='ngCell  col17 colt17']")).getText();				
					if(!str.equals("Delayed"))
						result = false;
				}
				getmyTaskNextpage().click();
				CommonBean.lbase_baseClass.sleep(1);
				if(getloaderIcon().isDisplayed())
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
				CommonBean.lbase_baseClass.sleep(2);
				str = getmyTaskNextpage().getAttribute("disabled");				
			}while(str == null);
			if(result == null)
				result = true;
		}
		catch(Exception ex)
		{
			result = false;
			System.out.println(ex);
		}
		return result;
	}
	//Method owner : Vasanth
	public boolean verifyonTrackFilter() throws InterruptedException 
	{
		//CommonBean.lbase_baseClass.clickButton(getonTrackFilter());
		Boolean result = null;		
		int rc;
		List<WebElement> rows;
		String str;
		try
		{
			CommonBean.lbase_baseClass.actionClick(getonTrackFilter());
			CommonBean.lbase_baseClass.sleep(1);
			if(getloaderIcon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
			CommonBean.lbase_baseClass.sleep(1);
			do
			{
				rows = driver.findElements(By.xpath("//div[contains(@ng-grid,'taskGrid')]//div[contains(@ng-style,'rowStyle(row)')]"));			
				rc = rows.size();
				for(int i =0;i<rc;i++)
				{
					str = driver.findElement(By.xpath("//div[contains(@ng-grid,'taskGrid')]//div[contains(@ng-style,'rowStyle(row)')]["+(i+1)+"]//div[@class='ngCell  col17 colt17']")).getText();				
					if(!str.equals("On-Track"))
						result = false;
				}
				getmyTaskNextpage().click();
				CommonBean.lbase_baseClass.sleep(1);
				if(getloaderIcon().isDisplayed())
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
				CommonBean.lbase_baseClass.sleep(2);
				str = getmyTaskNextpage().getAttribute("disabled");				
			}while(str == null);
			if(result == null)
				result = true;
		}
		catch(Exception ex)
		{
			result = false;
			System.out.println(ex);
		}
		System.out.println(result);
		return result;
	}
	//Method owner : Vasanth
	public boolean verifyDueTodayFilter() throws InterruptedException 
	{
		//CommonBean.lbase_baseClass.clickButton(getDueTodayFilter());
		Boolean result = null;		
		int rc;
		List<WebElement> rows;
		String str;
		try
		{
			CommonBean.lbase_baseClass.actionClick(getDueTodayFilter());
			CommonBean.lbase_baseClass.sleep(1);
			if(getloaderIcon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
			CommonBean.lbase_baseClass.sleep(1);
			do
			{
				rows = driver.findElements(By.xpath("//div[contains(@ng-grid,'taskGrid')]//div[contains(@ng-style,'rowStyle(row)')]"));			
				rc = rows.size();
				for(int i =0;i<rc;i++)
				{
					str = driver.findElement(By.xpath("//div[contains(@ng-grid,'taskGrid')]//div[contains(@ng-style,'rowStyle(row)')]["+(i+1)+"]//div[@class='ngCell  col17 colt17']")).getText();				
					if(!str.equals("Due Today"))
						result = false;
				}
				getmyTaskNextpage().click();
				CommonBean.lbase_baseClass.sleep(1);
				if(getloaderIcon().isDisplayed())
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
				CommonBean.lbase_baseClass.sleep(2);
				str = getmyTaskNextpage().getAttribute("disabled");				
			}while(str == null);
			if(result == null)
				result = true;
		}
		catch(Exception ex)
		{
			result = false;
			System.out.println(ex);
		}
		System.out.println(result);
		return result;
	}
	
	//Method owner : Vasanth
	public boolean verifyAllFilter() throws InterruptedException 
	{
		//CommonBean.lbase_baseClass.clickButton(getAllFilter());	
		Boolean result = null;		
		int rc,totalrc =0,totalrcfilter =0;
		List<WebElement> rows;
		String str;
		try
		{
			int j = 1;
			//Get Total Rows count before filter
			do
			{
				rows = driver.findElements(By.xpath("//div[contains(@ng-grid,'taskGrid')]//div[contains(@ng-style,'rowStyle(row)')]"));			
				rc = rows.size();
				totalrc = totalrc + rc;					
				str = getmyTaskNextpage().getAttribute("disabled");
				if(str == null)
				{
					//Next Page exists
					getmyTaskNextpage().click();
					CommonBean.lbase_baseClass.sleep(1);
					if(getloaderIcon().isDisplayed())
						CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
					CommonBean.lbase_baseClass.sleep(2);
				}
				else		
					break;	//Next Page Not exists
				j++;
			}while(true);
			CommonBean.lbase_baseClass.actionClick(getAllFilter());
			CommonBean.lbase_baseClass.sleep(1);
			if(getloaderIcon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
			CommonBean.lbase_baseClass.sleep(1);
			//Get Total Rows count After filter
			do
			{
				rows = driver.findElements(By.xpath("//div[contains(@ng-grid,'taskGrid')]//div[contains(@ng-style,'rowStyle(row)')]"));			
				rc = rows.size();
				totalrcfilter = totalrcfilter + rc;					
				str = getmyTaskNextpage().getAttribute("disabled");
				if(str == null)
				{
					//Next Page exists
					getmyTaskNextpage().click();
					CommonBean.lbase_baseClass.sleep(1);
					if(getloaderIcon().isDisplayed())
						CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
					CommonBean.lbase_baseClass.sleep(2);
				}
				else		
					break;	//Next Page Not exists
				j++;
			}while(true);
			if(totalrcfilter == totalrc)
				result = true;
			else
				result = false;
		}
		catch(Exception ex)
		{
			result = false;
			System.out.println(ex);
		}
		System.out.println(result);
		return result;
	}
	
	//Method owner : Vasanth
	public boolean verifyDelayTeamTaskFilter() throws InterruptedException, IOException 
	{
		//CommonBean.lbase_baseClass.clickButton(getDelayedFilter());	
		Boolean result = null;		
		int rc;
		List<WebElement> rows;
		String str;
		try
		{
			CommonBean.lbase_baseClass.actionClick(getteamTaskDelayedFilter());
			CommonBean.lbase_baseClass.sleep(1);
			if(getloaderIcon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
			CommonBean.lbase_baseClass.sleep(1);
			do
			{
				rows = driver.findElements(By.xpath("//div[contains(@ng-grid,'myTeamTaskGrid')]//div[contains(@ng-style,'rowStyle(row)')]"));			
				rc = rows.size();
				for(int i =0;i<rc;i++)
				{
					str = driver.findElement(By.xpath("//div[contains(@ng-grid,'myTeamTaskGrid')]//div[contains(@ng-style,'rowStyle(row)')]["+(i+1)+"]//div[@class='ngCell  col15 colt15']")).getText();				
					if(!str.equals("Delayed"))
						result = false;
				}
				getTeamTaskNextpage().click();
				CommonBean.lbase_baseClass.sleep(1);
				if(getloaderIcon().isDisplayed())
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
				CommonBean.lbase_baseClass.sleep(2);
				str = getTeamTaskNextpage().getAttribute("disabled");				
			}while(str == null);
			if(result == null)
				result = true;
		}
		catch(Exception ex)
		{
			result = false;
			System.out.println(ex);
		}
		System.out.print(result);
		return result;
	}
	
	//Method Author : Vasanth
	public boolean verifyTeamTaskonTrackFilter() throws InterruptedException 
	{
		//CommonBean.lbase_baseClass.clickButton(getonTrackFilter());
		Boolean result = null;		
		int rc;
		List<WebElement> rows;
		String str;
		try
		{
			str = getteamTaskOnTrackFilter().getText();
			str = str.split("-")[2].trim();
			if(str.equals("0"))
				return true;
			CommonBean.lbase_baseClass.actionClick(getteamTaskOnTrackFilter());
			CommonBean.lbase_baseClass.sleep(1);
			if(getloaderIcon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
			CommonBean.lbase_baseClass.sleep(1);
			do
			{
				rows = driver.findElements(By.xpath("//div[contains(@ng-grid,'myTeamTaskGrid')]//div[contains(@ng-style,'rowStyle(row)')]"));			
				rc = rows.size();				
				for(int i =0;i<rc;i++)
				{
					str = driver.findElement(By.xpath("//div[contains(@ng-grid,'myTeamTaskGrid')]//div[contains(@ng-style,'rowStyle(row)')]["+(i+1)+"]//div[@class='ngCell  col15 colt15']")).getText();				
					if(!str.equals("On-Track"))
						result = false;
				}
					getTeamTaskNextpage().click();
					CommonBean.lbase_baseClass.sleep(1);
					if(getloaderIcon().isDisplayed())
						CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
					CommonBean.lbase_baseClass.sleep(2);
					str = getTeamTaskNextpage().getAttribute("disabled");
			}while(str == null);
			if(result == null)
				result = true;
		}
		catch(Exception ex)
		{
			result = false;
			System.out.println(ex);
		}
		System.out.println(result);
		return result;
	}
	//Method Author : Vasanth
	public boolean verifyTeamTaskDueTodayFilter() throws InterruptedException 
	{
		//CommonBean.lbase_baseClass.clickButton(getonTrackFilter());
		Boolean result = null;		
		int rc;
		List<WebElement> rows;
		String str;
		try
		{
			str = getteamTaskDueTodayFilter().getText();
			str = str.split("-")[1].trim();
			if(str.equals("0"))
				return true;
			CommonBean.lbase_baseClass.actionClick(getteamTaskDueTodayFilter());
			CommonBean.lbase_baseClass.sleep(1);
			if(getloaderIcon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
			CommonBean.lbase_baseClass.sleep(1);
			do
			{
				rows = driver.findElements(By.xpath("//div[contains(@ng-grid,'myTeamTaskGrid')]//div[contains(@ng-style,'rowStyle(row)')]"));			
				rc = rows.size();				
				for(int i =0;i<rc;i++)
				{
					str = driver.findElement(By.xpath("//div[contains(@ng-grid,'myTeamTaskGrid')]//div[contains(@ng-style,'rowStyle(row)')]["+(i+1)+"]//div[@class='ngCell  col15 colt15']")).getText();				
					if(!str.equals("Due Today"))
						result = false;
				}
					getTeamTaskNextpage().click();
					CommonBean.lbase_baseClass.sleep(1);
					if(getloaderIcon().isDisplayed())
						CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
					CommonBean.lbase_baseClass.sleep(2);
					str = getTeamTaskNextpage().getAttribute("disabled");
			}while(str == null);
			if(result == null)
				result = true;
		}
		catch(Exception ex)
		{
			result = false;
			System.out.println(ex);
		}
		System.out.println(result);
		return result;
	}
	//Method Author : Vasanth
	public boolean verifyTeamTaskAllFilter() throws InterruptedException 
	{
		//CommonBean.lbase_baseClass.clickButton(getAllFilter());	
		Boolean result = null;		
		int rc,totalrc =0,totalrcfilter =0;
		List<WebElement> rows;
		String str;
		try
		{
			int j = 1;
			//Get Total Rows count before filter
			do
			{
				rows = driver.findElements(By.xpath("//div[contains(@ng-grid,'myTeamTaskGrid')]//div[contains(@ng-style,'rowStyle(row)')]"));			
				rc = rows.size();
				totalrc = totalrc + rc;					
				str = getTeamTaskNextpage().getAttribute("disabled");
				if(str == null)
				{
					//Next Page exists
					getTeamTaskNextpage().click();
					CommonBean.lbase_baseClass.sleep(1);
					if(getloaderIcon().isDisplayed())
						CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
					CommonBean.lbase_baseClass.sleep(2);
				}
				else		
					break;	//Next Page Not exists
				j++;
			}while(true);
			CommonBean.lbase_baseClass.actionClick(getteamTaskAllFilter());
			CommonBean.lbase_baseClass.sleep(1);
			if(getloaderIcon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
			CommonBean.lbase_baseClass.sleep(1);
			//Get Total Rows count After filter
			driver.findElement(By.xpath("(//i[@class='fa fa-angle-double-left'])[2]")).click();
			CommonBean.lbase_baseClass.sleep(1);
			if(getloaderIcon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
			CommonBean.lbase_baseClass.sleep(1);
			do
			{
				rows = driver.findElements(By.xpath("//div[contains(@ng-grid,'myTeamTaskGrid')]//div[contains(@ng-style,'rowStyle(row)')]"));			
				rc = rows.size();
				totalrcfilter = totalrcfilter + rc;					
				str = getTeamTaskNextpage().getAttribute("disabled");
				if(str == null)
				{
					//Next Page exists
					getTeamTaskNextpage().click();
					CommonBean.lbase_baseClass.sleep(1);
					if(getloaderIcon().isDisplayed())
						CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloaderIcon());
					CommonBean.lbase_baseClass.sleep(2);
				}
				else		
					break;	//Next Page Not exists
				j++;
			}while(true);
			if(totalrcfilter == totalrc)
				result = true;
			else
				result = false;
		}
		catch(Exception ex)
		{
			result = false;
			System.out.println(ex);
		}
		System.out.println(result);
		return result;
	}
	
	public Boolean searchTask(String astr_TaskName, String astr_userOrteam) throws InterruptedException 
	{
		Boolean isTaskpresent = false;
		try 
		{
			System.out.println("Method Name: searchTask is called");
			CommonBean.lbase_baseClass.waitForVisibility(CommonBean.IMyTask_Page.getTeamTaskSearch());
			if(astr_userOrteam.equalsIgnoreCase("Team")) 
			{	
				Thread.sleep(1000);	// 2500
				getTeamTaskSearch().clear();	
				if(CommonBean.IMyRequest_page.getloadericon().isDisplayed())
				{
					CommonBean.lbase_baseClass.loadingWait(CommonBean.IMyRequest_page.getloadericon());
					CommonBean.lbase_baseClass.writeText(getTeamTaskSearch(), astr_TaskName);	
					Thread.sleep(1000);
				}
				else
				{
					Thread.sleep(1500);
					CommonBean.lbase_baseClass.loadingWait(CommonBean.IMyRequest_page.getloadericon());
					CommonBean.lbase_baseClass.writeText(getTeamTaskSearch(), astr_TaskName);	
					Thread.sleep(1000);
				}	
				CommonBean.lbase_baseClass.loadingWait(CommonBean.IMyRequest_page.getloadericon());
				getTeamTaskSearch().sendKeys(Keys.ENTER);	
				//Thread.sleep(1500);
			}
			else if(astr_userOrteam.equalsIgnoreCase("User"))
			{		
				Thread.sleep(1000);	//2500
				getmyTaskSearch().clear();	
				if(CommonBean.IMyRequest_page.getloadericon().isDisplayed())
				{
					CommonBean.lbase_baseClass.loadingWait(CommonBean.IMyRequest_page.getloadericon());
					CommonBean.lbase_baseClass.writeText(getmyTaskSearch(), astr_TaskName);
					Thread.sleep(1000);
				}
				else
				{
					Thread.sleep(1500);
					CommonBean.lbase_baseClass.loadingWait(CommonBean.IMyRequest_page.getloadericon());
					CommonBean.lbase_baseClass.writeText(getmyTaskSearch(), astr_TaskName);	
					Thread.sleep(1000);
				}
				
				CommonBean.lbase_baseClass.loadingWait(CommonBean.IMyRequest_page.getloadericon());
				getmyTaskSearch().sendKeys(Keys.ENTER);	
				//Thread.sleep(1500);
			}
			Thread.sleep(1000);
			CommonBean.lbase_baseClass.loadingWait(CommonBean.IMyRequest_page.getloadericon());
			//Thread.sleep(3500);
			
			isTaskpresent = verifyTaskSearch(astr_TaskName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isTaskpresent;
				
	}
	
	public Boolean verifyTaskSearch(String astr_TaskName)
	{
		Boolean isTaskpresent=false;
		try {	
			if(driver.findElements(By.xpath("(//span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + astr_TaskName.toLowerCase()   + "')])[1]")).size()>0)
			{
				isTaskpresent =true;
				System.out.println(astr_TaskName + " - Task is present ");				
			}
			else if(driver.findElements(By.xpath("//div[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')= '" + astr_TaskName.toLowerCase()  + "']")).size()>0)
			{
				isTaskpresent =true;
				System.out.println(astr_TaskName + " - Task is present ");					
			}
			else if(driver.findElements(By.xpath("(//div[contains(text(),'" + astr_TaskName  + "')])[1]")).size()>0)
			{
				isTaskpresent =true;
				System.out.println(astr_TaskName + " - Task is present ");				
			}
			else
			{
				System.out.println("--------------BLOCK 8C -----" + isTaskpresent);
				System.out.println(astr_TaskName+ " : No such task is present ");				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isTaskpresent;
	}
	
	public boolean editTask(int colIndex ,String astr_TaskName, String astr_userOrteam,String astr_gridData) throws InterruptedException, IOException 
	{	
		System.out.println("Method Name: editTaskBasedOnRow is called");
		String astr_gridType="";
		Boolean istaskPresent = false,isPageexists=false;
		List<WebElement> row=null;
		
		try
		{
			if(astr_userOrteam.equalsIgnoreCase("Team")) 
			{
				colIndex=CommonBean.IMyTask_Page.getHeaderIndex("Entity", CommonBean.IMyTask_Page.getTeamTaskGridHeader());		
				astr_gridType="myTeamTaskGrid";			
			}
			else
			{
				colIndex=CommonBean.IMyTask_Page.getHeaderIndex("Entity", CommonBean.IMyTask_Page.getMyTaskGridHeader());	
				astr_gridType="taskGrid";
				//colIndex=colIndex-1;
			}
			
			colIndex=colIndex+1;
			
			if(CommonBean.IMyRequest_page.getloadericon().isDisplayed())
			{
				CommonBean.lbase_baseClass.loadingWait(CommonBean.IMyRequest_page.getloadericon());
				// Get all rows from the Grid
				row=DeviceUtils.getQAFDriver().findElementsByXPath("//div[@ng-grid='" + astr_gridType + "']//div[@ng-style='rowStyle(row)']");		
			}	
			else
			{
				Thread.sleep(1000);
				row=DeviceUtils.getQAFDriver().findElementsByXPath("//div[@ng-grid='" + astr_gridType + "']//div[@ng-style='rowStyle(row)']");		
			}		
			
			for(int i=1;i<=row.size();i++)
			{					
				// To process each row data			
				QAFExtendedWebElement rowDataElement=DeviceUtils.getQAFDriver().findElementByXPath("(//div[@ng-grid='" + astr_gridType + "']"
						+ "//div[@ng-style='rowStyle(row)'])["+ i + "]//div[@ng-class='col.colIndex()'][" + colIndex + "]");
				
				
				String getrowData=rowDataElement.getText().trim().toLowerCase();
				System.out.println("Entity data : " + getrowData);
				
				if(i==4)
				{
					System.out.println("--------------BLOCK 3 A ---------");
					CommonBean.lbase_baseClass.ScrollByVisibleElement(rowDataElement);
					Thread.sleep(1500);
				}
								
				// If entity data matches , Edit the task			
				if(astr_gridData != null && !astr_gridData.isEmpty() && getrowData.trim().equalsIgnoreCase(astr_gridData.trim().toLowerCase())) 
				{
					istaskPresent=true;
					System.out.println("--------------BLOCK 3 B HIGHLIGHT ---------");
					System.out.println("The Entity data : " + getrowData);	
					Thread.sleep(500);
					CommonBean.lbase_baseClass.highLightElement(rowDataElement);
					BaseClass.getScreenshot("Search Task based on -" + astr_TaskName);
					//Thread.sleep(2000);					
					CommonBean.lbase_baseClass.waitBeforeClick(rowDataElement);
					CommonBean.lbase_baseClass.doubleClick(rowDataElement);
					Thread.sleep(2000);
					break;				
				}			
				if(i==6)
				{
					int pageno=2;
					System.out.println(" Click next page when no matches are found in current page ");
					if(astr_userOrteam.equalsIgnoreCase("Team")) 
					{
						Thread.sleep(1500);
						QAFExtendedWebElement teamTaskNextpage=DeviceUtils.getQAFDriver().findElement(By.xpath("//button[@ng-click='my_team_task_goto_next()'][2]"));
						System.out.println("------Row no : 6 , Page enable : " +  teamTaskNextpage.isEnabled());
						Thread.sleep(1500);
						// Click next page under team task grid when no matches are found
						if(teamTaskNextpage.isEnabled())
						{
							CommonBean.lbase_baseClass.waitBeforeClick(teamTaskNextpage);
							CommonBean.lbase_baseClass.javascriptClick(teamTaskNextpage);
							//getTeamTaskNextpage().click();
							System.out.println("---- The Teams next page is : " +  pageno++ + "-----");
							isPageexists=true;
						}	
						else
						{
							System.out.println("--------------Teams section - No pages to Click ---------");
							isPageexists=false;
							break;
						}
					}
					else
					{
						Thread.sleep(1500);
						QAFExtendedWebElement myTaskNextpage=DeviceUtils.getQAFDriver().findElement(By.xpath("//button[@ng-click='my_task_goto_next()'][2]"));
						System.out.println("------Row no : 6 , Page enable : " +  myTaskNextpage.isEnabled());
						
						Thread.sleep(1500);
						// Click next page under My task grid when no matches are found
						if(myTaskNextpage.isEnabled())
						{
							System.out.println("--------------USERS BLOCK 3 C Click next page ---------");
							CommonBean.lbase_baseClass.waitBeforeClick(myTaskNextpage);
							CommonBean.lbase_baseClass.javascriptClick(myTaskNextpage);
							System.out.println("---- The Users next page is : " +  pageno++ + "-----");
							isPageexists=true;
						}	
						else
						{
							System.out.println("--------------Users section - No pages to Click ---------");
							isPageexists=false;
							//break;
						}
					}
					if(true)
					{
						CommonBean.lbase_baseClass.waitTill_ElementInvisible(CommonBean.IMyRequest_page.getloadericon());
						try 
						{
							row=DeviceUtils.getQAFDriver().findElementsByXPath("//div[@ng-grid='" + astr_gridType + "']//div[@ng-style='rowStyle(row)']");
							System.out.println(row.size());
						} 
						catch (Exception e) 
						{
							// TODO Auto-generated catch block
							System.out.println("Unable to find the row element in  " + astr_gridType );
							e.printStackTrace();
						}	
						i=0;
					}				
				}				
			}
			if(istaskPresent)
			{
				//Thread.sleep(2000);		
				
				CommonBean.lbase_baseClass.waitForVisibility(CommonBean.ITask_Library.getTaskCancelBtn());
				
				BaseClass.getScreenshot("Edit the Task - "+ astr_TaskName );
				Thread.sleep(1500);
				//CommonBean.lbase_baseClass.scrollDown();
				/*CommonBean.lbase_baseClass.scrollDownEnd();
				BaseClass.getScreenshot("Verify task fields at bottom - "+ astr_TaskName );*/
			}	
			else 
			{
				System.out.println("Task present is matching entity record !");			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return istaskPresent;	
	}
	
	public void completeTask(String astr_taskAction) throws InterruptedException
	{
		try 
		{				
			switch (astr_taskAction.toLowerCase())
			{
				case "submit":
					System.out.println("Submit the Task");
					try {						
						CommonBean.lbase_baseClass.clickButton(CommonBean.ITask_Library.getTaskSubmitBtn());
						Thread.sleep(2000);						
					} 
					catch (Exception e1) 
					{
						CommonBean.lbase_baseClass.clickButton(CommonBean.ITask_Library.getTaskCancelBtn());	
					}
					break;
				case "approve": case "approved":
					System.out.println("Approve the approval Task");					
					CommonBean.lbase_baseClass.clickButton(CommonBean.ITask_Library.getApproveTaskBtn());
					Thread.sleep(2000);					
					break;
				case "reject": case "rejected":
					System.out.println("Reject the approval Task");					
					CommonBean.lbase_baseClass.clickButton(CommonBean.ITask_Library.getRejectTaskBtn());
					Thread.sleep(2000);
					break;
				case "save as draft":
					System.out.println("Do save as Draft");					
					CommonBean.myTask_Execution.saveAsDraft();
					Thread.sleep(2000);
					//CommonBean.lbase_baseClass.clickButton(CommonBean.ITask_Library.getTaskCancelBtn());
					break;
				case "cancel":
					System.out.println("Cancel the Task");					
					try 
					{						
						CommonBean.lbase_baseClass.clickButton(CommonBean.ITask_Library.getTaskCancelBtn());
						Thread.sleep(2000);
					} 
					catch (Exception e)
					{		
						DeviceUtils.getQAFDriver().navigate().refresh();
						CommonBean.ITask_Library.getTaskCancelBtn().click();						
					}
						break;
				default : 
					System.out.println("Invalid Option");
					break;					
			}
			
			Thread.sleep(3000);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getHeaderIndex(String colName, QAFWebElement  gridHeader)
	{
		int colNum=0;
		//int noOfEmptyCol=6;

		List<WebElement> col=gridHeader.findElements(By.xpath("//div[@ng-class='col.colIndex()']"));
		
		for(int i=0;i<=col.size();i++)
		{
			//System.out.println("Col: " + i + " :" + col.get(i).getText());
			if(col.get(i).getText().trim().equalsIgnoreCase(colName.trim())){
				colNum=i;
				break;
			}
			else {
				System.out.println("Invalid column name !");
			}
		}
		return colNum ;		
	}

	
	protected void openPage(PageLocator locator, Object... args) 
	{
		
	}	
}
	

