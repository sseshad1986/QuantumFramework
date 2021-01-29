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
import com.qmetry.qaf.automation.util.Reporter;
import com.quantum.helper.BaseClass;
import com.quantum.utils.DeviceUtils;

import cucumber.api.java.en.And;

//

@SuppressWarnings("static-access")
public class Nflows_MessageMaster extends WebDriverBaseTestPage<WebDriverTestPage> 
{
	@FindBy(locator = "nflows.messagemaster.newMessage.button")
	private QAFExtendedWebElement newMessage;
		
	@FindBy(locator = "nFlows.messagemaster.messageType.Select")
	private QAFExtendedWebElement messageType;
	
	@FindBy(locator = "nFlows.messagemaster.messageType.Error")
	private QAFExtendedWebElement messageTypeError;
	
	@FindBy(locator = "nFlows.messagemaster.messageType.Warning")
	private QAFExtendedWebElement messageTypeWarning;
	
	@FindBy(locator = "nFlows.messagemaster.message.edit")
	private QAFExtendedWebElement message;
		
	@FindBy(locator = "nFlows.messagemaster.resolution.edit")
	private QAFExtendedWebElement resolution;
	
	@FindBy(locator = "nFlows.messagemaster.reason.edit")
	private QAFExtendedWebElement reason;
	
	@FindBy(locator = "nFlows.messagemaster.save.button")
	private QAFExtendedWebElement messageSave;
	
	@FindBy(locator = "nFlows.messagemaster.messageSearch.edit")
	private QAFExtendedWebElement messageSearch;
	
	@FindBy(locator = "nFlows.messagemaster.Editmessage.button")
	private QAFExtendedWebElement editMessage;
		
	@FindBy(locator = "nFlows.messagemaster.Gridmessage.table")
	private QAFExtendedWebElement gridMessage;
	

	// ------------------------------ Locator Ends here !
	// ----------------------------------------------------

	public QAFExtendedWebElement getnewMessage() {
		return newMessage;
	}
	
	public QAFExtendedWebElement getmessageType() {
		return messageType;
	}
	
	public QAFExtendedWebElement getmessageTypeError() {
		return messageTypeError;
	}
	
	public QAFExtendedWebElement getmessageTypeWarning() {
		return messageTypeWarning;
	}
	
	public QAFExtendedWebElement getmessage() {
		return message;
	}
	
	public QAFExtendedWebElement getresolution() {
		return resolution;
	}
	
	public QAFExtendedWebElement getreason() {
		return reason;
	}
	
	public QAFExtendedWebElement getmessageSave() {
		return messageSave;
	}
	
	public QAFExtendedWebElement getmessageSearch() {
		return messageSearch;
	}
	
	public QAFExtendedWebElement geteditMessage() {
		return editMessage;
	}
	
	public QAFExtendedWebElement getgridMessage() {
		return gridMessage;
	}

	// }
	
	
	protected void openPage(PageLocator locator, Object... args) 
	{
		
	}	
}
	

