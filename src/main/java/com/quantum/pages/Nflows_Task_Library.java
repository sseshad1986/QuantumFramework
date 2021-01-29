package com.quantum.pages;


import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;


@SuppressWarnings("static-access")
public class Nflows_Task_Library extends WebDriverBaseTestPage<WebDriverTestPage>
{		
	// Locators for User task	
	@FindBy(locator = "TaskEdit.Submit.btn")
	public  static QAFExtendedWebElement submitBtn;

	@FindBy(locator = "TaskEdit.Cancel.btn")
	public  static QAFExtendedWebElement cancelBtn;
		
	@FindBy(locator = "TaskEdit.SaveDraft.btn")
	public  static QAFExtendedWebElement saveDraftBtn;
		
	@FindBy(locator = "TaskEdit.History.btn")
	public  static QAFExtendedWebElement historyBtn;

	@FindBy(locator = "TaskEdit.Approve.btn")
	public  static QAFExtendedWebElement approveBtn;
		
	@FindBy(locator = "TaskEdit.Reject.btn")
	public  static QAFExtendedWebElement rejectBtn;	
	

// ------------------------------         Locators Ends here !          ----------------------------------------------------	

	
	public static QAFExtendedWebElement getTaskSubmitBtn()	{
		return submitBtn;		
	}
	
	public static QAFExtendedWebElement getTaskCancelBtn()	{
		return cancelBtn;
	}
	
	public static QAFExtendedWebElement getTaskSaveDraftBtn()	{
		return saveDraftBtn;
	}
	
	public static QAFExtendedWebElement getTaskHistoryBtn()	{
		return historyBtn;
	}
	
	public static QAFExtendedWebElement getApproveTaskBtn()	{
		return approveBtn;
	}
	
	public static QAFExtendedWebElement getRejectTaskBtn()	{
		return rejectBtn;
	}
	
	public QAFExtendedWebElement getDynamicSingleLine(String astr_dynamicSingleLine)
	{
		String loc = String.format(pageProps.getString("nflows.userTask.dynamicSingleLine"), astr_dynamicSingleLine);
		return new QAFExtendedWebElement(loc);
	}
	
	public QAFExtendedWebElement getDynamicMultiLine(String astr_dynamicMultiLine)
	{
		String loc = String.format(pageProps.getString("nflows.userTask.dynamicMultiLine"), astr_dynamicMultiLine);
		return new QAFExtendedWebElement(loc);
	}
	
	public QAFExtendedWebElement getDynamicDate(String astr_dynamicDate)
	{
		String loc = String.format(pageProps.getString("nflows.userTask.dynamicDate"), astr_dynamicDate);
		return new QAFExtendedWebElement(loc);
	}
	
	public QAFExtendedWebElement getDynamicDropdown(String astr_dynamicDropdown)
	{
		String loc = String.format(pageProps.getString("nflows.userTask.dynamicDropdown"), astr_dynamicDropdown);
		return new QAFExtendedWebElement(loc);
	}
	
	public QAFExtendedWebElement getDynamicAttachment(String astr_dynamicAttachment)
	{
		String loc = String.format(pageProps.getString("nflows.userTask.dynamicAttachment"), astr_dynamicAttachment);
		return new QAFExtendedWebElement(loc);
	}
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	// ------------------------------         Getter method Ends here !          ----------------------------------------------------
	
}
