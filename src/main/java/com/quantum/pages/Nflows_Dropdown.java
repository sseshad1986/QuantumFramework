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

public class Nflows_Dropdown  extends WebDriverBaseTestPage<WebDriverTestPage>
{
	@FindBy(locator = "nflows.dropdown.newdropdown.button")
	private QAFExtendedWebElement NewDropdown;
	
	@FindBy(locator = "nflows.dropdown.searchbx.txtbx")
	private QAFExtendedWebElement SearchBox;
	
	@FindBy(locator = "nflows.dropdown.newdropdown.listname.txtbx")
	private QAFExtendedWebElement ListName;
	
	@FindBy(locator = "nflows.dropdown.newdropdown.status.toggle")
	private QAFExtendedWebElement Status;
	
	@FindBy(locator = "nflows.dropdown.newdropdown.save.button")
	private QAFExtendedWebElement Save;
	
	@FindBy(locator = "nflows.dropdown.newdropdown.cancel.button")
	private QAFExtendedWebElement Cancel;
	
	@FindBy(locator = "nflows.dropdown.searchresult")
	private QAFExtendedWebElement SearchResult;
	
	@FindBy(locator = "nflows.dropdown.newdropdown.successmsg")
	private QAFExtendedWebElement SuccessMsg;
	
	@FindBy(locator = "nflows.dropdown.searchresult.edit")
	private QAFExtendedWebElement SearchResultEdit;
	
	@FindBy(locator = "nflows.dropdown.newdropdown.status.Active")
	private QAFExtendedWebElement ActiveStatus;
	
	@FindBy(locator = "nflows.dropdown.newdropdown.status.Inactive")
	private QAFExtendedWebElement InactiveStatus;
	
	@FindBy(locator = "nflows.dropdown.newdropdown.listvalue.add")
	private QAFExtendedWebElement ListvalueAdd;
	
	@FindBy(locator = "nflows.dropdown.newdropdown.listvalue.first")
	private QAFExtendedWebElement ListvalueFirst;
	
	@FindBy(locator = "nflows.dropdown.newdropdown.listvalue.edit")
	private QAFExtendedWebElement ListvalueEdit;
	
	// ------------------------------       Locator Ends here !          ----------------------------------------------------
	
	public QAFExtendedWebElement getListvalueEdit()
	{
		return ListvalueEdit;
	}
	
	public QAFExtendedWebElement getListvalueAdd()
	{
		return ListvalueAdd;
	}
	
	public QAFExtendedWebElement getListvalueFirst()
	{
		return ListvalueFirst;
	}
	
	public QAFExtendedWebElement getActiveStatus()
	{
		return ActiveStatus;
	}
	
	public QAFExtendedWebElement getInactiveStatus()
	{
		return InactiveStatus;
	}
	
	public QAFExtendedWebElement getSearchResultEdit()
	{
		return SearchResultEdit;
	}
	
	public QAFExtendedWebElement getSuccessMsg()
	{
		return SuccessMsg;
	}
	
	public QAFExtendedWebElement getNewDropdown()
	{
		return NewDropdown;
	}
	
	public QAFExtendedWebElement getSearchBox()
	{
		return SearchBox;
	}
	
	public QAFExtendedWebElement getListName()
	{
		return ListName;
	}
	
	public QAFExtendedWebElement getStatus()
	{
		return Status;
	}
	
	public QAFExtendedWebElement getSave()
	{
		return Save;
	}
	
	public QAFExtendedWebElement getCancel()
	{
		return Cancel;
	}
	
	public QAFExtendedWebElement getSearchResult()
	{
		return SearchResult;
	}
	// ------------------------------         Getter method Ends here !          ----------------------------------------------------

	public boolean create_new_dropdown_and_verify(String ListName, String ListValue1) throws Throwable
	{
		// Navigate to New Dropdown Page and Create a Role
		Boolean IsCreated=false;
		try
		{
			String SearchResult;
			getNewDropdown().click();
			CommonBean.lbase_baseClass.waitForVisibility(getSave());
			Thread.sleep(3000);
			CommonBean.lbase_baseClass.writeText(getListName(), ListName);
			Thread.sleep(500);
			getListvalueAdd().click();
			Thread.sleep(500);
			CommonBean.lbase_baseClass.writeText(getListvalueFirst(), ListValue1);
			Thread.sleep(500);
			BaseClass.getScreenshot("Create new dropdown with ListName : " + ListName);
			CommonBean.lbase_baseClass.clickButton(getSave());;
			CommonBean.lbase_baseClass.waitForVisibility(getSuccessMsg());
			BaseClass.getScreenshot("Dropdown saved successfully : " + ListName);
			Thread.sleep(3000);
			CommonBean.lbase_baseClass.waitForVisibility(getSave());
			
			// Go Back to Dropdown Landing Page and Verify
			getCancel().click();
			CommonBean.lbase_baseClass.waitForVisibility(getNewDropdown());
			Thread.sleep(1000);
			CommonBean.lbase_baseClass.writeText(getSearchBox(),ListName);
			getSearchBox().sendKeys(Keys.RETURN);
			Thread.sleep(500);
			SearchResult = CommonBean.lbase_baseClass.getText(getSearchResult());
			Thread.sleep(1000);		
			if(SearchResult.equals(ListName))
			{
				BaseClass.getScreenshot("Create New Dropdown Verified");
				IsCreated= true;
			}
			getSearchBox().clear();
		}
		catch(Exception e)
		{
			if(getSave().isDisplayed())
			{
			CommonBean.lbase_baseClass.clickButton(getCancel());
			CommonBean.lbase_baseClass.waitForVisibility(getNewDropdown());
			}
			e.printStackTrace();
		}
		return IsCreated;
	}
	
	public boolean edit_dropdown_verify(String ListName, String NewListName,String NewListValue1) throws Throwable
	{
		//Edit the Dropdown
		Boolean result=false;
		try
		{
			String OldListValue;
			OldListValue = Edit_a_Dropdown(ListName, NewListName, NewListValue1,"Edit");
			
			//Verify the Edit
			Thread.sleep(500);
			CommonBean.lbase_baseClass.writeText(getSearchBox(),NewListName);
			getSearchBox().sendKeys(Keys.ENTER);		
			Thread.sleep(4000);
			if(driver.findElements(By.xpath("(//span[contains(text(),'" + NewListName  + "')])")).size()>0)
			{
				BaseClass.getScreenshot("Edit Dropdown is verified ");
				result = true;
			}
			else
			{
				result = false;
			}
			getSearchBox().clear();
			Thread.sleep(1000);
			
			//Revert the edit
			OldListValue = Edit_a_Dropdown(NewListName, ListName, OldListValue,"Revert");
		}
		catch(Exception e)
		{
			if(getSave().isDisplayed())
			{
			CommonBean.lbase_baseClass.clickButton(getCancel());
			CommonBean.lbase_baseClass.waitForVisibility(getNewDropdown());
			}
			e.printStackTrace();
		}
		return result;
	}
	
	public String Edit_a_Dropdown(String ListName, String NewListName,String NewListValue1, String EditType) throws Throwable
	{
		//Search the Dropdown to Edit
		String OldListValue;
		CommonBean.lbase_baseClass.writeText(getSearchBox(),ListName);
		getSearchBox().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		getSearchResultEdit().click();
		CommonBean.lbase_baseClass.waitBeforeClick(getSave());		
		Thread.sleep(3000);
		
		//Inside Dropdown Details Page and Edit the Dropdown
		getListName().clear();
		Thread.sleep(500);
		getListvalueEdit().click();
		Thread.sleep(500);
		OldListValue = getListvalueFirst().getAttribute("value");
		Thread.sleep(500);
		getListvalueFirst().clear();
		Thread.sleep(500);
		CommonBean.lbase_baseClass.writeText(getListName(), NewListName);
		Thread.sleep(500);
		CommonBean.lbase_baseClass.writeText(getListvalueFirst(), NewListValue1);
		Thread.sleep(500);
		if(EditType.equals("Edit"))
			BaseClass.getScreenshot("Edit existing role with : " + NewListName);
		CommonBean.lbase_baseClass.clickButton(getSave());;
		getSuccessMsg().waitForVisible(20000);
		Thread.sleep(6000);
		getListName().waitForVisible(10000);
		Thread.sleep(3000);
		
		// Go Back to Dropdown Landing Page
		getCancel().click();
		getNewDropdown().waitForVisible(10000);
		Thread.sleep(4000);
		return OldListValue;
	}
	
	public boolean search_dropdown_and_verify(String ListName) throws Throwable
	{
		//Search the Dropdown
		Boolean result;
		CommonBean.lbase_baseClass.writeText(getSearchBox(),ListName);
		getSearchBox().sendKeys(Keys.ENTER);
		BaseClass.getScreenshot("Dropdown landing page search is verified ");
		Thread.sleep(500);
		if(driver.findElements(By.xpath("(//span[contains(text(),'" + ListName  + "')])")).size()>0)
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
	
	public boolean inactive_dropdown_and_verify(String ListName) throws Throwable
	{
		Boolean result=false;
		try
		{
			Inactive_Toggle_a_Dropdown(ListName,"Edit");
			
			//Verify the Inactive State
			Thread.sleep(500);
			CommonBean.lbase_baseClass.writeText(getSearchBox(),ListName);
			getSearchBox().sendKeys(Keys.ENTER);
			BaseClass.getScreenshot("Inactive a Dropdown is verified : " + ListName);
			Thread.sleep(4000);
			if(driver.findElements(By.xpath("(//span[contains(text(),'Inactive')])")).size()>0)
			{
				result = true;
			}			
			getSearchBox().clear();
			
			//Revert the Inactive State
			Inactive_Toggle_a_Dropdown(ListName,"Revert");
		}
		catch(Exception e)
		{
			if(getSave().isDisplayed())
			{
			CommonBean.lbase_baseClass.clickButton(getCancel());
			CommonBean.lbase_baseClass.waitForVisibility(getNewDropdown());
			}
			e.printStackTrace();
		}
		return result;
	}
	
	public void Inactive_Toggle_a_Dropdown(String ListName, String EditType) throws InterruptedException, IOException
	{
		//Search the Dropdown to Edit
		CommonBean.lbase_baseClass.writeText(getSearchBox(),ListName);
		getSearchBox().sendKeys(Keys.ENTER);
		Thread.sleep(500);
		getSearchResultEdit().click();
		CommonBean.lbase_baseClass.waitBeforeClick(getSave());
		Thread.sleep(4000);
		
		//Inside Dropdown Details Page
		getActiveStatus().click();
		Thread.sleep(500);
		if(EditType.equals("Edit"))
		BaseClass.getScreenshot("Existing Dropdown is made inactive" + ListName);
		CommonBean.lbase_baseClass.clickButton(getSave());;
		getSuccessMsg().waitForVisible(20000);
		Thread.sleep(6000);
		getListName().waitForVisible(10000);
		Thread.sleep(3000);

		// Go Back to Dropdown Landing Page
		getCancel().click();
		CommonBean.lbase_baseClass.waitBeforeClick(getNewDropdown());
		Thread.sleep(4000);		
	}
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	

}
