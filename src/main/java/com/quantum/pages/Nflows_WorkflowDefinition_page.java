package com.quantum.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.helper.BaseClass;


@SuppressWarnings("static-access")
public class Nflows_WorkflowDefinition_page extends WebDriverBaseTestPage<WebDriverTestPage>
{	
	BaseClass baseClass=new BaseClass();
	
	@FindBy (locator = "nflows.login.Userid.txtbx")
	private QAFExtendedWebElement loginUserId;
	
	@FindBy (locator = "nflows.login.Password.txtbx")
	private QAFExtendedWebElement loginpassword;
	
	@FindBy (locator = "nflows.login.submit.button")
	private QAFExtendedWebElement loginbtn;

	public QAFExtendedWebElement getloginUserid() {
		return loginUserId;
	}
	
	public QAFExtendedWebElement getloginPassword() {
		return loginpassword;
	}
	
	public QAFExtendedWebElement getloginSubmit() {
		return loginbtn;
	}
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	public void launch_app(WebDriverTestBase driver,String url ) throws InterruptedException 
	{
		driver.getDriver().get(url);
		baseClass.waitForPageLoad(20);
		driver.getDriver().manage().window().maximize();

		String lstr_pageTitle = driver.getDriver().getTitle();
		if (lstr_pageTitle.equals("nFlows - Login")) 
		{
			System.out.println("NFlows app is successfully launched");
		} 
		else 
		{
			System.out.println("Site is not reachable");
		}
	}
	
	public void login_with_valid_username_and_password(String astr_Username,String astr_Password ) throws InterruptedException 
	{				
		baseClass.writeText(getloginUserid(), astr_Username);
		baseClass.writeText(getloginPassword(), astr_Password);			
		baseClass.clickButton(getloginSubmit());	
		
	}
	
}
