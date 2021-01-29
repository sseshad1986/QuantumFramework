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
public class Nflows_EntityDataDictionary extends WebDriverBaseTestPage<WebDriverTestPage> 
{
	@FindBy(locator = "nflows.EntityDataDict.newField.button")
	private QAFExtendedWebElement newField;
		
	@FindBy(locator = "nflows.EntityDataDict.Search.button")
	private QAFExtendedWebElement entityDDSearch;
	
	@FindBy(locator = "nflows.wfDataDict.SearchResult.grid")
	private QAFExtendedWebElement wfDDSearchResult;
	
	@FindBy(locator = "nflows.wfDataDict.fieldName.textbox")
	private QAFExtendedWebElement wfDDfieldName;
	
	@FindBy(locator = "nflows.wfDataDict.dataLabel.textbox")
	private QAFExtendedWebElement wfDDdataLabel;
		
	@FindBy(locator = "nflows.wfDataDict.fieldDescr.textbox")
	private QAFExtendedWebElement wfDDfieldDescr;
	
	@FindBy(locator = "nflows.wfDataDict.remarks.textbox")
	private QAFExtendedWebElement wfDDremarks;
	
	@FindBy(locator = "nflows.wfDataDict.Select")
	private QAFExtendedWebElement wfDDselect;
	
	@FindBy(locator = "nflows.wfDataDict.Save")
	private QAFExtendedWebElement wfDDsave;
	
	@FindBy(locator = "nflows.wfDataDict.length.textbox")
	private QAFExtendedWebElement wfDDlength;
	
	@FindBy(locator = "nflows.wfDataDict.precision.textbox")
	private QAFExtendedWebElement wfDDprecision;
	
	@FindBy(locator = "nflows.wfDataDict.Search.grid")
	private QAFExtendedWebElement wfDDsearchGrid;
	
	@FindBy(locator = "nflows.wfDataDict.edit")
	private QAFExtendedWebElement wfDDedit;
	
	


	// ------------------------------ Locator Ends here !
	// ----------------------------------------------------

	public QAFExtendedWebElement getnewField() {
		return newField;
	}
	
	public QAFExtendedWebElement getentityDDSearch() {
		return entityDDSearch;
	}
	
	public QAFExtendedWebElement getwfDDSearchResult() {
		return wfDDSearchResult;
	}
	
	public QAFExtendedWebElement getwfDDfieldName() {
		return wfDDfieldName;
	}
	
	public QAFExtendedWebElement getwfDDdataLabel() {
		return wfDDdataLabel;
	}
	
	public QAFExtendedWebElement getwfDDfieldDescr() {
		return wfDDfieldDescr;
	}
	
	public QAFExtendedWebElement getwfDDremarks() {
		return wfDDremarks;
	}
	
	public QAFExtendedWebElement getwfDDselect() {
		return wfDDselect;
	}
	
	public QAFExtendedWebElement getwfDDsave() {
		return wfDDsave;
	}
	
	public QAFExtendedWebElement getwfDDlength() {
		return wfDDlength;
	}
	
	public QAFExtendedWebElement getwfDDprecision() {
		return wfDDprecision;
	}
	
	public QAFExtendedWebElement getwfDDsearchGrid() {
		return wfDDsearchGrid;
	}
	
	public QAFExtendedWebElement getwfDDedit() {
		return wfDDedit;
	}

	// }
	
	
	protected void openPage(PageLocator locator, Object... args) 
	{
		
	}	
}
	

