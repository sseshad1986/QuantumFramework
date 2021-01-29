package com.quantum.pages;

import org.openqa.selenium.By;

import java.io.File;
import java.time.*;
import java.util.Set;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;

import jxl.write.DateTime;
import com.quantum.helper.*;


@SuppressWarnings("static-access")
public class Nflows_Dashboard_Execution extends WebDriverBaseTestPage<WebDriverTestPage>
{
	@FindBy(locator = "nflows.dashboardexecution.loadingicon")
	private QAFExtendedWebElement loadingicon;
	
	@FindBy(locator = "nflows.dashboardexecution.gridheading")
	private QAFExtendedWebElement gridheading;
	
	@FindBy(locator = "nflows.dashboardexecution.grid1loadingicon")
	private QAFExtendedWebElement grid1loadingicon;
	
	@FindBy(locator = "nflows.dashboardexecution.ellipsislink")
	private QAFExtendedWebElement ellipsislink;
	
	@FindBy(locator = "nflows.dashboardexecution.png")
	private QAFExtendedWebElement png;
	
	@FindBy(locator = "nflows.dashboardexecution.jpeg")
	private QAFExtendedWebElement jpeg;
	
	@FindBy(locator = "nflows.dashboardexecution.excel")
	private QAFExtendedWebElement excel;
	
	@FindBy(locator = "nflows.dashboardexecution.pdf")
	private QAFExtendedWebElement pdf;
	
	@FindBy(locator = "nflows.dashboardexecution.dashboardname")
	private QAFExtendedWebElement dashboardname;
	
	@FindBy(locator = "nflows.dashboardexecution.pdfexport")
	private QAFExtendedWebElement pdfexport;
	
	@FindBy(locator = "nflows.dashboardexecution.sendmail")
	private QAFExtendedWebElement sendmail;
	
	@FindBy(locator = "nflows.dashboardexecution.subject")
	private QAFExtendedWebElement subject;	
	
	@FindBy(locator = "nflows.dashboardexecution.mailcontent")
	private QAFExtendedWebElement mailcontent;	
	
	@FindBy(locator = "nflows.dashboardexecution.mailtosearch")
	private QAFExtendedWebElement mailtosearch;	

	@FindBy(locator = "nflows.dashboardexecution.mailtousername")
	private QAFExtendedWebElement mailtousername;	
	
	@FindBy(locator = "nflows.dashboardexecution.mailto")
	private QAFExtendedWebElement mailto;
	
	@FindBy(locator = "nflows.dashboardexecution.mailtosendbutton")
	private QAFExtendedWebElement mailtosendbutton;	
	
	@FindBy(locator = "nflows.dashboardexecution.attachmentformat")
	private QAFExtendedWebElement attachmentformat;	

	@FindBy(locator = "nflows.dashboardexecution.attachmentpngformat")
	private QAFExtendedWebElement attachmentpngformat;	

	@FindBy(locator = "nflows.dashboardexecution.emailsentnotification")
	private QAFExtendedWebElement emailsentnotification;	

	@FindBy(locator = "nflows.dashboardexecution.emailsentnotificationclose")
	private QAFExtendedWebElement emailsentnotificationclose;	
	
	// ------------------------------         Locators Ends here !          ----------------------------------------------------
	
	public QAFExtendedWebElement getemailsentnotificationclose() {
		return emailsentnotificationclose;
	}
	
	public QAFExtendedWebElement getemailsentnotification() {
		return emailsentnotification;
	}
	
	public QAFExtendedWebElement getattachmentpngformat() {
		return attachmentpngformat;
	}
	
	public QAFExtendedWebElement getattachmentformat() {
		return attachmentformat;
	}
	
	public QAFExtendedWebElement getsubject() {
		return subject;
	}
	
	public QAFExtendedWebElement getmailcontent() {
		return mailcontent;
	}
	
	public QAFExtendedWebElement getmailtosearch() {
		return mailtosearch;
	}
	
	public QAFExtendedWebElement getmailtousername() {
		return mailtousername;
	}
	
	public QAFExtendedWebElement getmailto() {
		return mailto;
	}
	
	public QAFExtendedWebElement getmailtosendbutton() {
		return mailtosendbutton;
	}
	
	public QAFExtendedWebElement getsendmail() {
		return sendmail;
	}
	
	public QAFExtendedWebElement getpdfexport() {
		return pdfexport;
	}	
	
	public QAFExtendedWebElement getdashboardname() {
		return dashboardname;
	}
	
	public QAFExtendedWebElement getellipsislink() {
		return ellipsislink;
	}
	
	public QAFExtendedWebElement getpng() {
		return png;
	}
	
	public QAFExtendedWebElement getjpeg() {
		return jpeg;
	}
	
	public QAFExtendedWebElement getexcel() {
		return excel;
	}
	
	public QAFExtendedWebElement getpdf() {
		return pdf;
	}
	
	public QAFExtendedWebElement getloadingicon() {
		return loadingicon;
	}
	
	public QAFExtendedWebElement getgridheading(String DashboardName) {
		String loc = String.format(pageProps.getString("nflows.dashboardexecution.gridheading"), DashboardName);
		return new QAFExtendedWebElement(loc);		
	}
	
	public QAFExtendedWebElement getgrid1loadingicon() {
		return grid1loadingicon;
	}
	
	// ------------------------------         Getter method Ends here !          ----------------------------------------------------
	
	public boolean VerifyDasboardGeneration(String DashboardName) throws Throwable
	{
		boolean result = false;		
		try	{
			if(getloadingicon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
			Thread.sleep(1000);
			if(getgrid1loadingicon().isPresent())
				getgrid1loadingicon().waitForNotPresent(55000);
			if(getgridheading(DashboardName).isDisplayed()){			
				result = true;
				BaseClass.getScreenshot("Dashboard Generation Landing Page");
			}
		}
		catch(Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet VerifyPngJpegExcelPdfinDashboardExecution(String DownloadFolder) throws Throwable
	{
		boolean resultPng = false,resultJpeg = false,resultExcel = false,resultPdf = false, finalresult = false;
		String fileName,CurrentHandle, fileNamewithExt;
		Set<String> tabs;
		File f;
		ResultSet rs = new ResultSet();
		try	{
			if(getloadingicon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
			Thread.sleep(1000);
			if(getgrid1loadingicon().isPresent())
				getgrid1loadingicon().waitForNotPresent(55000);
			fileName = CommonBean.lbase_baseClass.getText(getdashboardname());
			CurrentHandle=driver.getWindowHandle();
			
			//------Check for PNG
			try {
				fileNamewithExt = fileName+".png";
				CommonBean.lbase_baseClass.actionClick(getellipsislink());
				CommonBean.lbase_baseClass.actionClick(getpng());
				Thread.sleep(1000);
				if(getloadingicon().isDisplayed())
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
				Thread.sleep(2000);				
				tabs=driver.getWindowHandles();
				for(String handle:tabs)		{
					if(!handle.equals(CurrentHandle))	{
						driver.switchTo().window(handle);
						if(CommonBean.lbase_baseClass.getpageTitle().contains(fileNamewithExt)) {
							BaseClass.getScreenshot("Dashboard in Png Format");
							resultPng=true;
						}
						driver.close();
						driver.switchTo().window(CurrentHandle);
					}
				}
				if(resultPng==false)
					rs.setExceptionmsg(rs.getExceptionmsg()+" PNG is not working;");
			}
			catch(Exception e) {
				resultPng=false;
				rs.setExceptionmsg("PNG is not working;");
			}
			
			//------Check for JPEG
			try {
				fileNamewithExt = fileName+".jpeg";
				CommonBean.lbase_baseClass.actionClick(getellipsislink());
				CommonBean.lbase_baseClass.actionClick(getjpeg());
				Thread.sleep(1000);
				if(getloadingicon().isDisplayed())
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
				Thread.sleep(2000);				
				tabs=driver.getWindowHandles();
				for(String handle:tabs)		{
					if(!handle.equals(CurrentHandle))	{
						driver.switchTo().window(handle);
						if(CommonBean.lbase_baseClass.getpageTitle().contains(fileNamewithExt)) {
							resultJpeg=true;
							BaseClass.getScreenshot("Dashboard in JPEG Format");
						}
						driver.close();
						driver.switchTo().window(CurrentHandle);
					}
				}
				if(resultJpeg==false)
					rs.setExceptionmsg(rs.getExceptionmsg()+" JPEG is not working;");
			}
			catch(Exception e){
				resultJpeg = false;
				rs.setExceptionmsg(rs.getExceptionmsg()+" JPEG is not working;");
			}
			//------Check for Excel
			try {
				fileNamewithExt = DownloadFolder + "\\" + fileName + ".xlsx";
				f = new File(fileNamewithExt);				
				if(f.exists())
					f.delete();
				CommonBean.lbase_baseClass.actionClick(getellipsislink());
				BaseClass.getScreenshot("Dashboard in Excel Format Downloaded");
				CommonBean.lbase_baseClass.actionClick(getexcel());
				Thread.sleep(1000);
				if(getloadingicon().isDisplayed())
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
				Thread.sleep(2000);				
				if(f.exists())
					resultExcel=true;	
				else
					rs.setExceptionmsg(rs.getExceptionmsg()+" Excel is not working;");
			}
			catch(Exception e)	{
				resultExcel = false;
				rs.setExceptionmsg(rs.getExceptionmsg()+" Excel is not working;");
			}
			
			//------Check for PDF
			try{
				//fileNamewithExt = DownloadFolder + "\\" + fileName+".pdf";
				fileNamewithExt = fileName+".pdf";
				fileNamewithExt = fileNamewithExt.replace(" ", "%20");
				f = new File(fileNamewithExt);
				if(f.exists())
					f.delete();
				CommonBean.lbase_baseClass.actionClick(getellipsislink());
				CommonBean.lbase_baseClass.actionClick(getpdf());
				CommonBean.lbase_baseClass.clickButton(getpdfexport());
				Thread.sleep(1000);
				if(getloadingicon().isDisplayed())
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
				Thread.sleep(2000);				
//				if(f.exists())
//					resultPdf=true;
//				else
//					rs.setExceptionmsg(rs.getExceptionmsg()+" Pdf is not working;");
				tabs=driver.getWindowHandles();
				for(String handle:tabs)		{
					if(!handle.equals(CurrentHandle))	{
						driver.switchTo().window(handle);
						if(driver.getCurrentUrl().contains(fileNamewithExt)){
							resultPdf=true;						
							BaseClass.getScreenshot("Dashboard in Pdf Format downloaded");
						}
						driver.close();
						driver.switchTo().window(CurrentHandle);
					}
				}
				if(resultPdf==false)
					rs.setExceptionmsg(rs.getExceptionmsg()+" PDF is not working;");
			}
			catch(Exception e){
				resultPdf=false;
				rs.setExceptionmsg(rs.getExceptionmsg()+" Pdf is not working;");
			}
			rs.SetResult(resultPng && resultJpeg && resultExcel && resultPdf);
		}
		catch(Exception e)
		{
			finalresult = false;
			e.printStackTrace();
		} 
		return rs;
	}

	public boolean VerifySendMailinDashboardExecution(String MailTo, String Subject, String MailContent) throws Throwable
	{
		boolean result = false;
		try {
			CommonBean.lbase_baseClass.actionClick(getellipsislink());
			CommonBean.lbase_baseClass.actionClick(getsendmail());
			Thread.sleep(1000);
			CommonBean.lbase_baseClass.actionClick(getmailto());
			CommonBean.lbase_baseClass.writeText(getmailtosearch(), MailTo);
			CommonBean.lbase_baseClass.actionClick(getmailtousername());
			CommonBean.lbase_baseClass.actionClick(getmailto());
			CommonBean.lbase_baseClass.actionClick(getattachmentformat());
			CommonBean.lbase_baseClass.actionClick(getattachmentpngformat());			
			CommonBean.lbase_baseClass.writeText(getsubject(), Subject);
			CommonBean.lbase_baseClass.writeText(getmailcontent(), MailContent);
			BaseClass.getScreenshot("Send Mail Result - ");
			CommonBean.lbase_baseClass.actionClick(getmailtosendbutton());
			Thread.sleep(2000);
			if(getloadingicon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
			Thread.sleep(2000);
			if(getemailsentnotification().isDisplayed())
				result = true;
			CommonBean.lbase_baseClass.actionClick(getemailsentnotificationclose());
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
