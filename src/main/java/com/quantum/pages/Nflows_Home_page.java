package com.quantum.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.quantum.helper.BaseClass;



@SuppressWarnings("static-access")
public class Nflows_Home_page extends WebDriverBaseTestPage<WebDriverTestPage>
{	
	private final static Logger LOGGER =  
            Logger.getLogger(Nflows_Home_page.class);
		
	@FindBy(locator = "nflows.logo")
	private QAFExtendedWebElement logo;
	
	@FindBy(locator = "nflows.menu.button")
	private QAFExtendedWebElement menuBar;
		
	@FindBy(locator = "nflows.menuSearch.txtbx")
	private QAFExtendedWebElement menuSearch;
	
	@FindBy(locator = "nflows.home.text")
	private QAFExtendedWebElement homeText;	
	
	@FindBy(locator = "nflows.searchText.lnk")
	private QAFExtendedWebElement subMenuLnk;
	
	@FindBy(locator = "nflows.message.lnk")
	private QAFExtendedWebElement message;
	
	@FindBy(locator = "nflows.image.lnk")
	private QAFExtendedWebElement imageLnk;
	
	@FindBy(locator = "nflows.logout.lnk")
	private QAFExtendedWebElement logoutLnk;
	
	@FindBy(locator = "nflows.newButton")
	private QAFExtendedWebElement validateButton;
	
// ------------------------------         Locators Ends here !          ----------------------------------------------------
	
	public QAFExtendedWebElement getLogo()
	{
		return logo;
	}
	
	public QAFExtendedWebElement gethomeMenu() {
		return menuBar;
	}
	
	public QAFExtendedWebElement getmenuSearch() {
		return menuSearch;
	}
	
	public QAFExtendedWebElement gethomeText() {
		return homeText;
	}
	
	public QAFExtendedWebElement getmessage()
	{
		return message;
	}
	
	public QAFExtendedWebElement getsubMenuLnk()
	{
		return subMenuLnk;
	}
	
	public QAFExtendedWebElement getimageLnk()
	{
		return imageLnk;
	}
	
	public QAFExtendedWebElement getlogoutLnk() {
		return logoutLnk;
	}
	
	public QAFExtendedWebElement getvalidateButton(String buttonName) 
	{
        String loc = String.format(pageProps.getString("nflows.newButton"), buttonName);
        return new QAFExtendedWebElement(loc);
    }
		
// ------------------------------         Getter method Ends here !          ----------------------------------------------------
	
	public boolean verifyPostLogin() throws InterruptedException 
	{		
		if (logo.isDisplayed()) 
		{
			System.out.println("Login is Success");
			LOGGER.info("Login is Success !");
			return true;
		} 
		else 
		{
			System.out.println("UnSuccessful Login !");
			LOGGER.error("UnSuccessful Login !");
			return false;
		}
	}
	
	public Boolean navigateByMenu (String astr_MenuName) throws InterruptedException 
	{
		boolean isMenuPresent=false;
		try 
		{			
			try 
			{			
				CommonBean.lbase_baseClass.clickButton(gethomeMenu());
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Stale element captured and reinstantiated");
				gethomeMenu();
				CommonBean.lbase_baseClass.clickButton(gethomeMenu());
			}
			CommonBean.lbase_baseClass.waitForVisibility(getmenuSearch());
			getmenuSearch().clear();
			CommonBean.lbase_baseClass.writeText(getmenuSearch(), astr_MenuName);
			Thread.sleep(700);
			
			isMenuPresent=CommonBean.lbase_baseClass.selectFromMenu(astr_MenuName.trim());
			if(isMenuPresent)
			{
				Thread.sleep(2500);
				CommonBean.lbase_baseClass.waitForVisibility(getLogo());					
				if(CommonBean.IMyRequest_page.getloadericon().isPresent())
				{
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(CommonBean.IMyRequest_page.getloadericon());
					Thread.sleep(3000);
					Reporter.log("Navigated to " + astr_MenuName + " successfully");				
				}
				else
				{
					BaseClass.getScreenshot("Navigated to " + astr_MenuName );
					Reporter.log("Navigated to " + astr_MenuName + " successfully");
				}
			}
			else
				CommonBean.lbase_baseClass.clickButton(gethomeMenu());
		} 
		catch (Exception e)
		{
			Assert.assertFalse(false, "Failed  Navigated to " + astr_MenuName);		
			Reporter.log("Failed  Navigated to" + astr_MenuName);
		}
		return isMenuPresent;	
	}
	
//---------------------------------------------------------------------
	// This method is to click Menu bar
	public void clickMenuBar() throws InterruptedException
	{
		try 
		{
			CommonBean.lbase_baseClass.clickButton(gethomeMenu());
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Stale element captured and reinstantiated");
			gethomeMenu();
			CommonBean.lbase_baseClass.clickButton(gethomeMenu());
		}
	}
	
	// This method is to type Menu name
	public void typeMenuName(String astr_MenuName) throws InterruptedException
	{
		try {
			CommonBean.lbase_baseClass.writeText(getmenuSearch(), astr_MenuName);
			Thread.sleep(700);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// This method check menu exists or not and Click on Menu link
	public boolean checkMenuExists(String astr_MenuName) 
	{
		boolean isMenuPresent=false;
		try 
		{
			QAFExtendedWebElement menuLink=new WebDriverTestBase().getDriver()
					.findElement(By.xpath("//a[text()='" + astr_MenuName.trim() + "']"));
			System.out.println("//a[contains(text(),'" + astr_MenuName.trim() + "')]");
			CommonBean.lbase_baseClass.waitForVisibility(menuLink);
			
			// Check whether corresponding menu Exists or not
			if(menuLink.isDisplayed())
			{
				isMenuPresent=true;
				clickMenuLink(menuLink);
				// Wait for loader to disappear
				if(CommonBean.IMyRequest_page.getloadericon().isPresent())
				{
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(CommonBean.IMyRequest_page.getloadericon());
					Thread.sleep(3000);			
				}
				BaseClass.getScreenshot("Navigated to " + astr_MenuName );
			}
			else
				System.out.println(astr_MenuName + " menu is not present");
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isMenuPresent;	
	}
	
	public void clickMenuLink(QAFExtendedWebElement menuElement) 
	{
		try 
		{
			menuElement.click();
			Thread.sleep(2000);		
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//------------------------------------------------------------------
	public void perform_Logout () throws InterruptedException 
	{
		try 
		{
			System.out.println("Logout method is called !");
					
			try 
			{
				CommonBean.lbase_baseClass.waitForVisibility(getimageLnk());
			} catch (Exception e) 
			{
				getimageLnk();
			}	
			CommonBean.lbase_baseClass.javascriptClick(getimageLnk());
			
			
			BaseClass.getScreenshot("Clicked on Logout Link");
			CommonBean.lbase_baseClass.waitForVisibility(getlogoutLnk());	
			CommonBean.lbase_baseClass.clickButton(getlogoutLnk());
			Thread.sleep(1500);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	

	
	protected void openPage(PageLocator locator, Object... args) {
				
	}	
}
	

