package com.quantum.helper;

import java.util.ArrayList;

import com.itextpdf.text.List;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.pages.CommonBean;

public class MultiLingual extends WebDriverBaseTestPage<WebDriverTestPage>
{		
	WebDriverTestBase driver = new WebDriverTestBase();
	static ArrayList<String> list=null;
	
	@FindBy (locator = "google.translate.url")
	private String googleTranslateUrl;
	
	@FindBy (locator = "google.translate.source.textBox")
	private QAFExtendedWebElement sourceLang;
	
	@FindBy (locator = "google.translate.output.textBox")
	private QAFExtendedWebElement outputlang;
	
	@FindBy (locator = "google.translate.searchbox.textBox")
	private QAFExtendedWebElement searchbox;
	
	
	public String getGoogleTranslateUrl() 
	{
		return googleTranslateUrl;
	}
	
	public QAFExtendedWebElement getSourceLang() 
	{
		return sourceLang;
	}
	public QAFExtendedWebElement getOutputlang() 
	{
		return outputlang;
	}
	public QAFExtendedWebElement getSearchbox() 
	{
		return searchbox;
	}
	
	public static ArrayList<String> getEntityDefValues() 	
	{
		try
		{
			list=new ArrayList<String>();   
			list.add(CommonBean.lEntity_Definition_entityDef.getClickEntityTab().getText());
			list.add(CommonBean.lEntity_Definition_entityDef.getClickRulesTab().getText());
			list.add(CommonBean.lEntity_Definition_entityDef.getClickGroupingRulesTab().getText());
			list.add(CommonBean.lEntity_Definition_entityDef.getWorkflowTab().getText());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public  void translate(ArrayList<String> input) throws InterruptedException
	{
		try 
		{
			driver.getDriver().navigate().to("https://translate.google.com/#view=home&op=translate&sl=en&tl=zh-CN");
			CommonBean.lbase_baseClass.waitForPageLoad(40);		
			
			for(String data:input) 
			{
				getSourceLang().clear();
				CommonBean.lbase_baseClass.writeText(getSourceLang(), data);
				
				Thread.sleep(1500);
				String translateText=CommonBean.lbase_baseClass.getText(getOutputlang());
				System.out.println("The translated value for " + data +" : " + translateText);
			}
			driver.getDriver().close();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void performTranslation() throws InterruptedException
	{
		try 
		{
			ArrayList<String> getList=getEntityDefValues();
			translate(getList);
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
