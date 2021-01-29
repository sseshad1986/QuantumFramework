package com.quantum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.helper.BaseClass;

public class Nflows_Report_Definition  extends WebDriverBaseTestPage<WebDriverTestPage>
{
	@FindBy(locator = "nflows.reportdefinition.gridviewbutton")
	private QAFExtendedWebElement gridviewbutton;
	
	@FindBy(locator = "nflows.reportdefinition.searchbox")
	private QAFExtendedWebElement searchbox;
	
	@FindBy(locator = "nflows.reportdefinition.searchresultedit")
	private QAFExtendedWebElement searchresultedit;
	
	@FindBy(locator = "nflows.reportdefinition.ellipsisbutton")
	private QAFExtendedWebElement ellipsisbutton;
	
	@FindBy(locator = "nflows.reportdefinition.distributeequally")
	private QAFExtendedWebElement distributeequally;

	@FindBy(locator = "nflows.reportdefinition.loadingicon")
	private QAFExtendedWebElement loadingicon;

	@FindBy(locator = "nflows.reportdefinition.cancelbutton")
	private QAFExtendedWebElement cancelbutton;

	@FindBy(locator = "nflows.reportdefinition.ellipsisrowbutton")
	private QAFExtendedWebElement ellipsisrowbutton;

	@FindBy(locator = "nflows.reportdefinition.distributeequallyrowbutton")
	private QAFExtendedWebElement distributeequallyrowbutton;
	
	@FindBy(locator = "nflows.reportdefinition.deletewidget")
	private QAFExtendedWebElement deletewidget;
	
	// ------------------------------         Locators Ends here !          ----------------------------------------------------
	
	public QAFExtendedWebElement getdeletewidget() {
		return deletewidget;
	}
	
	public QAFExtendedWebElement getellipsisrowbutton() {
		return ellipsisrowbutton;
	}
	
	public QAFExtendedWebElement getdistributeequallyrowbutton() {
		return distributeequallyrowbutton;
	}
	
	public QAFExtendedWebElement getcancelbutton() {
		return cancelbutton;
	}

	public QAFExtendedWebElement getloadingicon() {
		return loadingicon;
	}
	
	public QAFExtendedWebElement getdistributeequally() {
		return distributeequally;
	}
	
	public QAFExtendedWebElement getellipsisbutton() {
		return ellipsisbutton;
	}
	
	public QAFExtendedWebElement getsearchresultedit() {
		return searchresultedit;
	}

	public QAFExtendedWebElement getsearchbox() {
		return searchbox;
	}

	public QAFExtendedWebElement getgridviewbutton() {
		return gridviewbutton;
	}
	
	// ------------------------------         Getter method Ends here !          ----------------------------------------------------
	
	public boolean VerifyDistributeEquallyinReportDefinition(String ReportName) throws Throwable
	{
		boolean result = false;
		try {
			CommonBean.lbase_baseClass.clickButton(getgridviewbutton());
			CommonBean.lbase_baseClass.sleep(2);
			if(getloadingicon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
			CommonBean.lbase_baseClass.writeText(getsearchbox(), ReportName);
			BaseClass.pressEnter();		
			CommonBean.lbase_baseClass.actionClick(getsearchresultedit());
			CommonBean.lbase_baseClass.sleep(3);
			CommonBean.lbase_baseClass.actionClick(getellipsisbutton());
			BaseClass.getScreenshot("Click on Distribute Equally");
			CommonBean.lbase_baseClass.actionClick(getdistributeequally());
			CommonBean.lbase_baseClass.sleep(1);
			BaseClass.getScreenshot("Distribute Equally Result - ");
			CommonBean.lbase_baseClass.actionClick(getcancelbutton());		
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();			
		}
		return result;
	}
	
	public boolean VerifyDistributeEquallyWidgetwiseReportDefinition(String ReportName) throws Throwable
	{
		boolean result = false;
	//	int i =0, attempts = 3;
		try {		
			CommonBean.lbase_baseClass.sleep(2);
			if(getloadingicon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
			CommonBean.lbase_baseClass.writeText(getsearchbox(), ReportName);
			BaseClass.pressEnter();	
			CommonBean.lbase_baseClass.sleep(1);		
			getsearchresultedit().click();
			CommonBean.lbase_baseClass.sleep(3);
			CommonBean.lbase_baseClass.actionClick(getellipsisrowbutton());
			BaseClass.getScreenshot("Click on Distribute Equally on a Row");
			CommonBean.lbase_baseClass.actionClick(getdistributeequallyrowbutton());
			CommonBean.lbase_baseClass.sleep(1);
			BaseClass.getScreenshot("Distribute Equally on a Row Result - ");			
			getcancelbutton().click();
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();			
		}
		return result;
	}
	
	public boolean DeleteWidgetinReportDefinition(String ReportName) throws Throwable
	{
		boolean result = false;
		try {		
			CommonBean.lbase_baseClass.sleep(2);
			if(getloadingicon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
			CommonBean.lbase_baseClass.writeText(getsearchbox(), ReportName);
			BaseClass.pressEnter();	
			CommonBean.lbase_baseClass.sleep(1);		
			getsearchresultedit().click();
			CommonBean.lbase_baseClass.sleep(3);
			getellipsisrowbutton().click();
			BaseClass.getScreenshot("Click on Delete Widget");
			CommonBean.lbase_baseClass.actionClick(getdeletewidget());
			CommonBean.lbase_baseClass.sleep(1);
			BaseClass.getScreenshot("Delete Widget Result - ");
			getcancelbutton().click();	
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();			
		}
		return result;
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
