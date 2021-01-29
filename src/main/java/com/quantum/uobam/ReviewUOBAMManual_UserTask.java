package com.quantum.uobam;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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
import com.quantum.helper.BaseClass;
import com.quantum.helper.ExtentManager;
import com.quantum.pages.CommonBean;


@SuppressWarnings("static-access")
public class ReviewUOBAMManual_UserTask extends WebDriverBaseTestPage<WebDriverTestPage>
{		
	
	@FindBy (locator = "nflows.userTask.UOBAMManualName")
	private QAFExtendedWebElement UOBAMManualName;
	
	@FindBy (locator = "nflows.userTask.Section")
	private QAFExtendedWebElement Section;	
	
	@FindBy (locator = "nflows.userTask.SectionName")
	private QAFExtendedWebElement SectionName;
	
	@FindBy (locator = "nflows.userTask.Chapter")
	private QAFExtendedWebElement Chapter;
	
	@FindBy (locator = "nflows.userTask.VersionNumber")
	private QAFExtendedWebElement VersionNumber;
	
	@FindBy (locator = "nflows.userTask.InitiationDate")
	private QAFExtendedWebElement InitiationDate;
	
	@FindBy (locator = "nflows.userTask.UOBAMManual")
	private QAFExtendedWebElement UOBAMManual;
	
	@FindBy (locator = "nflows.userTask.ManualOwners")
	private QAFExtendedWebElement ManualOwners;
	
	@FindBy (locator = "nflows.userTask.ManualUpdates")
	private QAFExtendedWebElement ManualUpdates;
	
// ------------------------------         Locators Ends here !          ----------------------------------------------------	

	public QAFExtendedWebElement getUOBAMManualName() 
	{
		return UOBAMManualName;
	}
	
	public QAFExtendedWebElement getSection() {
		return Section;
	}
	
	public QAFExtendedWebElement getSectionName() {
		return SectionName;
	}
	
	public QAFExtendedWebElement getChapter() {
		return Chapter;
	}
	
	public QAFExtendedWebElement getVersionNumber() {
		return VersionNumber;
	}
	
	public QAFExtendedWebElement getInitiationDate() {
		return InitiationDate;
	}
	public QAFExtendedWebElement getUOBAMManual() {
		return UOBAMManual;
	}
	
	public QAFExtendedWebElement getManualOwners() {
		return ManualOwners;
	}
	
	public QAFExtendedWebElement getManualUpdates() {
		return ManualUpdates;
	}	
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	// ------------------------------         Getter method Ends here !          ----------------------------------------------------
		
	/*public void validate_task(String astr_Action,QAFExtendedWebElement astr_Locator, String astr_fieldName, String astr_fieldType,String astr_Data)
	{
		//CommonBean.lbase_baseClass.fieldHandling(astr_Action, astr_Locator, astr_fieldName, astr_fieldType, astr_Data);
	}*/
	
}
