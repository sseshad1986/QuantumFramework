package com.quantum.pages;

import java.io.FileNotFoundException;
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

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Nflows_Business_Calendar extends WebDriverBaseTestPage<WebDriverTestPage>
{

	@FindBy(locator = "nflows.Calendar.newcalendar.button")
	private QAFExtendedWebElement NewCalendar;
	
	@FindBy(locator = "nflows.Calendar.searchbx.txtbx")
	private QAFExtendedWebElement SearchBox;
	
	@FindBy(locator = "nflows.Calendar.searchresult")
	private QAFExtendedWebElement SearchResult;
	
	@FindBy(locator = "nflows.Calendar.searchresult.edit")
	private QAFExtendedWebElement SearchResultEdit;
	
	@FindBy(locator = "nflows.Calendar.newcalendar.calendarname.txtbx")
	private QAFExtendedWebElement CalendarName;
	
	@FindBy(locator = "nflows.Calendar.newcalendar.description.txtbx")
	private QAFExtendedWebElement Description;
	
	@FindBy(locator = "nflows.Calendar.newcalendar.weekenddays.drpdwn")
	private QAFExtendedWebElement WeekEndDays;
	
	@FindBy(locator = "nflows.Calendar.newcalendar.weekenddays.sunday")
	private QAFExtendedWebElement Sunday;
	
	@FindBy(locator = "nflows.dropdown.newdropdown.status.Active")
	private QAFExtendedWebElement ActiveStatus;
	
	@FindBy(locator = "nflows.dropdown.newdropdown.status.Inactive")
	private QAFExtendedWebElement InactiveStatus;
	
	@FindBy(locator = "nflows.Calendar.newcalendar.save.button")
	private QAFExtendedWebElement Save;
	
	@FindBy(locator = "nflows.Calendar.newcalendar.cancel.button")
	private QAFExtendedWebElement Cancel;
	
	@FindBy(locator = "nflows.Calendar.newcalendar.successmsg")
	private QAFExtendedWebElement SuccessMsg;
	
	
	// ------------------------------       Locator Ends here !          ----------------------------------------------------
	
	public QAFExtendedWebElement getNewCalendar()
	{
		return NewCalendar;
	}
	
	public QAFExtendedWebElement getSearchBox()
	{
		return SearchBox;
	}
	
	public QAFExtendedWebElement getSearchResult()
	{
		return SearchResult;
	}
	
	public QAFExtendedWebElement getSearchResultEdit()
	{
		return SearchResultEdit;
	}
	
	public QAFExtendedWebElement getCalendarName()
	{
		return CalendarName;
	}	

	public QAFExtendedWebElement getDescription()
	{
		return Description;
	}
	
	public QAFExtendedWebElement getWeekEndDays()
	{
		return WeekEndDays;
	}
	
	public QAFExtendedWebElement getSunday()
	{
		return Sunday;
	}
		
	public QAFExtendedWebElement getActiveStatus()
	{
		return ActiveStatus;
	}
		
	public QAFExtendedWebElement getSave()
	{
		return Save;
	}
	
	public QAFExtendedWebElement getCancel()
	{
		return Cancel;
	}
	
	public QAFExtendedWebElement getSuccessMsg()
	{
		return SuccessMsg;
	}	
	
	public boolean create_new_calendar_and_verify(String CalendarName, String Description) throws Throwable
	{
		try {
			// Navigate to New Calendar Page and Create a Role
			Boolean IsCreated;
			String SearchResult;
			getNewCalendar().click();
			getSave().waitForVisible(10000);
			Thread.sleep(3000);
			CommonBean.lbase_baseClass.writeText(getCalendarName(), CalendarName);
			Thread.sleep(500);
			CommonBean.lbase_baseClass.writeText(getDescription(), Description);
			Thread.sleep(500);
			getWeekEndDays().click();
			Thread.sleep(500);
			getSunday().click();
			Thread.sleep(500);
			getWeekEndDays().click();
			Thread.sleep(500);
			BaseClass.getScreenshot("Create new Calendar with Name : " + CalendarName);
			CommonBean.lbase_baseClass.clickButton(getSave());;
			getSuccessMsg().waitForVisible(10000);
			BaseClass.getScreenshot("Calendar saved successfully : " + CalendarName);
			Thread.sleep(3000);
			getSave().waitForVisible(10000);
			
			// Go Back to Calendar Landing Page and Verify
			getCancel().click();
			getNewCalendar().waitForVisible(10000);
			Thread.sleep(1000);
			CommonBean.lbase_baseClass.writeText(getSearchBox(),CalendarName);
			getSearchBox().sendKeys(Keys.RETURN);
			Thread.sleep(500);
			SearchResult = CommonBean.lbase_baseClass.getText(getSearchResult());
			Thread.sleep(1000);		
			if(SearchResult.equals(CalendarName))
			{
				BaseClass.getScreenshot("Create New Calendar Verified");
				IsCreated= true;
			}
			else
			{
				IsCreated= false;
			}		
			getSearchBox().clear();
			getSearchBox().sendKeys(Keys.RETURN);
			Thread.sleep(1000);
			return IsCreated;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean edit_calendar_verify(String CalendarName, String NewCalendarName, String NewDescription) throws Throwable
	{
		//Edit the Calendar
		Boolean result;
		String OldDescription;
		OldDescription = Edit_a_Calendar(CalendarName, NewCalendarName, NewDescription,"Edit");
		
		//Verify the Edit
		Thread.sleep(500);
		CommonBean.lbase_baseClass.writeText(getSearchBox(),NewCalendarName);
		getSearchBox().sendKeys(Keys.ENTER);		
		Thread.sleep(4000);
		if(driver.findElements(By.xpath("(//span[contains(text(),'" + NewCalendarName  + "')])")).size()>0)
		{
			BaseClass.getScreenshot("Edit Calendar is verified ");
			result = true;
		}
		else
		{
			result = false;
		}
		getSearchBox().clear();
		Thread.sleep(1000);
		
		//Revert the edit
		OldDescription = Edit_a_Calendar(NewCalendarName, CalendarName, OldDescription,"Revert");	
		return result;		
	}
	
	public String Edit_a_Calendar(String CalendarName, String NewCalendarName,String NewDescription, String EditType) throws Throwable
	{
		//Search the Calendar to Edit
		String OldListValue;
		CommonBean.lbase_baseClass.writeText(getSearchBox(),CalendarName);
		getSearchBox().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		getSearchResultEdit().click();
		CommonBean.lbase_baseClass.waitBeforeClick(getSave());		
		Thread.sleep(3000);
		
		//Inside Calendar Details Page and Edit the Calendar
		getCalendarName().clear();
		Thread.sleep(500);
		OldListValue = getDescription().getAttribute("value");
		Thread.sleep(500);
		getDescription().clear();
		Thread.sleep(500);
		CommonBean.lbase_baseClass.writeText(getCalendarName(), NewCalendarName);
		Thread.sleep(500);
		CommonBean.lbase_baseClass.writeText(getDescription(), NewDescription);
		Thread.sleep(500);
		if(EditType.equals("Edit"))
			BaseClass.getScreenshot("Edit existing Calendar with : " + NewCalendarName);
		CommonBean.lbase_baseClass.clickButton(getSave());;
		getSuccessMsg().waitForVisible(20000);
		Thread.sleep(6000);
		getCalendarName().waitForVisible(10000);
		Thread.sleep(3000);
		
		// Go Back to Calendar Landing Page
		getCancel().click();
		getNewCalendar().waitForVisible(10000);
		Thread.sleep(4000);
		return OldListValue;
	}
	
	public boolean search_calendar_and_verify(String CalendarName) throws Throwable
	{
		//Search the Calendar
		Boolean result;
		CommonBean.lbase_baseClass.writeText(getSearchBox(),CalendarName);
		getSearchBox().sendKeys(Keys.ENTER);
		BaseClass.getScreenshot("Calendar landing page search is verified ");
		Thread.sleep(500);
		if(driver.findElements(By.xpath("(//span[contains(text(),'" + CalendarName  + "')])")).size()>0)
		{
			result= true;
		}
		else
		{
			result= false;
		}
		getSearchBox().clear();
		getSearchBox().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		return result;	
	}
	
	public boolean inactive_calendar_and_verify(String CalendarName) throws Throwable
	{
		Boolean result;
		Inactive_Toggle_a_Calendar(CalendarName,"Edit");
		
		//Verify the Inactive State
		Thread.sleep(500);
		CommonBean.lbase_baseClass.writeText(getSearchBox(),CalendarName);
		getSearchBox().sendKeys(Keys.ENTER);
		BaseClass.getScreenshot("Inactive a Dropdown is verified :" + CalendarName);
		Thread.sleep(4000);
		if(driver.findElements(By.xpath("(//span[contains(text(),'Inactive')])")).size()>0)
		{
			result = true;
		}
		else
		{
			result= false;
		}
		getSearchBox().clear();
		
		//Revert the Inactive State
		Inactive_Toggle_a_Calendar(CalendarName,"Revert");
		return result;		
	}
	
	public void Inactive_Toggle_a_Calendar(String CalendarName,String EditType) throws InterruptedException, IOException
	{
		//Search the Calendar to Edit
		CommonBean.lbase_baseClass.writeText(getSearchBox(),CalendarName);
		getSearchBox().sendKeys(Keys.ENTER);
		Thread.sleep(500);
		getSearchResultEdit().click();
		CommonBean.lbase_baseClass.waitBeforeClick(getSave());
		Thread.sleep(4000);
		
		//Inside Calendar Details Page
		getActiveStatus().click();
		Thread.sleep(500);
		if(EditType.equals("Edit"))
			BaseClass.getScreenshot("Existing Calendar made inactive " + CalendarName);
		CommonBean.lbase_baseClass.clickButton(getSave());;
		getSuccessMsg().waitForVisible(20000);
		Thread.sleep(6000);
		getCalendarName().waitForVisible(10000);
		Thread.sleep(3000);

		// Go Back to Calendar Landing Page
		getCancel().click();
		CommonBean.lbase_baseClass.waitBeforeClick(getNewCalendar());
		Thread.sleep(4000);		
	}
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
