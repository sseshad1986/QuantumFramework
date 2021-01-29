package com.quantum.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
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


@SuppressWarnings("static-access")
public class Nflows_Login_page extends WebDriverBaseTestPage<WebDriverTestPage>
{		
	WebDriverTestBase driver = new WebDriverTestBase();
	private final static Logger LOGGER =  
            Logger.getLogger(Nflows_Login_page.class);
	
	@FindBy (locator = "nflows.login.site.unavailable")
	private QAFExtendedWebElement siteUnavailable;
	
	@FindBy (locator = "nflows.login.site.pageNotFound")
	private QAFExtendedWebElement pageNotFound;
	
	@FindBy (locator = "nflows.login.Userid.txtbx")
	private QAFExtendedWebElement loginUserId;
	
	@FindBy (locator = "nflows.login.Password.txtbx")
	private QAFExtendedWebElement loginpassword;
	
	@FindBy (locator = "nflows.login.submit.button")
	private QAFExtendedWebElement loginbtn;
	
	@FindBy (locator = "nflows.login.forgotpassword.forgotpasswordlnk")
	private QAFExtendedWebElement forgotPassword;
	
	@FindBy (locator = "nflows.login.forgotpassword.TypeUsername")
	private QAFExtendedWebElement TypeUsername;
	
	@FindBy (locator = "nflows.login.forgotpassword.ClickForgotSubmit")
	private QAFExtendedWebElement ClickForgotSubmit;
	
	@FindBy (locator = "nflows.login.forgotpassword.CancelForgot")
	private QAFExtendedWebElement CancelForgot;
	
// ------------------------------         Locators Ends here !          ----------------------------------------------------	

	
	public QAFExtendedWebElement getsiteUnavailable() 
	{
		return siteUnavailable;
	}
	
	public QAFExtendedWebElement getpageNotFound() 
	{
		return pageNotFound;
	}
	
	public QAFExtendedWebElement getloginUserid() {
		return loginUserId;
	}
	
	public QAFExtendedWebElement getloginPassword() {
		return loginpassword;
	}
	
	public QAFExtendedWebElement getloginSubmit() {
		return loginbtn;
	}
	
	public QAFExtendedWebElement getforgotPassword() {
		return forgotPassword;
	}
	
	public QAFExtendedWebElement getTypeUsername() {
		return TypeUsername;
	}
	
	public QAFExtendedWebElement getClickForgotSubmit() {
		return ClickForgotSubmit;
	}
	
	public QAFExtendedWebElement getCancelForgot() {
		return CancelForgot;
	}
	
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	// ------------------------------         Getter method Ends here !          ----------------------------------------------------
		
	public boolean launch_application(String url ) throws InterruptedException 
	{		
		Boolean isLaunchSuccess=false;
		try {
			driver.getDriver().get(url);
			driver.getDriver().manage().window().maximize();
			CommonBean.lbase_baseClass.waitForPageLoad(20);
			String lstr_pageTitle = driver.getDriver().getTitle();
			if (lstr_pageTitle.contains("Login")) 
			{
				System.out.println("The page Title is : " + lstr_pageTitle);
				LOGGER.debug("The page Title is : " + lstr_pageTitle);				
				isLaunchSuccess=true;
			} 
			else if(lstr_pageTitle.equals("nFlows - Login"))
			{
				System.out.println("Site is not reachable");
				LOGGER.error("Site is not reachable");
				isLaunchSuccess=false;
			}
			else if(lstr_pageTitle.equals("nFlows - Page Not Found"))
			{
				System.out.println("nFlows - Page Not Found");
				LOGGER.error("nFlows - Page Not Found");
				isLaunchSuccess=false;
			}
			else
			{
				System.out.println("Invalid Url");
				isLaunchSuccess=false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isLaunchSuccess;
	}
	
	public Boolean login_with_valid_username_and_password(String astr_Username,String astr_Password ) throws InterruptedException, IOException 
	{	
		Boolean isLoginSuccess=false;
		try {
			CommonBean.lbase_baseClass.writeText(getloginUserid(), astr_Username);
			CommonBean.lbase_baseClass.writeText(getloginPassword(), astr_Password);		
			
			BaseClass.getScreenshot("Login with User name - " + astr_Username);
			
			CommonBean.lbase_baseClass.clickButton(getloginSubmit());
			CommonBean.lHome_page_home.gethomeMenu().waitForVisible(10000);	
			
			if(CommonBean.lHome_page_home.verifyPostLogin())
				isLoginSuccess=true;				
			else
				isLoginSuccess=false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isLoginSuccess;
	}
	
	public void check_ForgotPassword(String userName) throws InterruptedException 
	{		
		try {
			CommonBean.lbase_baseClass.clickButton(getforgotPassword());		
			CommonBean.lbase_baseClass.writeText(getTypeUsername(), userName);	
			CommonBean.lbase_baseClass.clickButton(getClickForgotSubmit());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void validate_Logout () throws InterruptedException 
	{
		try 
		{			
			System.out.println("Logout method is called !");			
			CommonBean.lbase_baseClass.waitForVisibility(getloginUserid());
		
			String lstr_pageTitle=CommonBean.lbase_baseClass.getpageTitle();
			if(lstr_pageTitle.trim().equalsIgnoreCase("nFlows - Login"))
			{
				System.out.println("Logout is successful !");
			}
			//Assert.assertEquals(lstr_pageTitle, "nFlows - Login");
			CommonBean.lbase_baseClass.getScreenshot("User is successfully Logout !");
			//BaseClass.getScreenshot("User is successfully Logout !");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
