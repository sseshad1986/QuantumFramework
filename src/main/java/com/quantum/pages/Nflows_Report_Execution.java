package com.quantum.pages;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
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
import com.quantum.helper.ResultSet;
import com.quantum.helper.Xls_Reader;


@SuppressWarnings("static-access")
public class Nflows_Report_Execution extends WebDriverBaseTestPage<WebDriverTestPage>
{		
	//WebDriverTestBase driver = new WebDriverTestBase();
	
	@FindBy (locator = "nflows.reports.execution.Generate")
	private QAFExtendedWebElement generateBtn;
	
	@FindBy (locator = "nflows.reports.execution.Clear")
	private QAFExtendedWebElement clearBtn;
	
	@FindBy (locator = "nflows.reports.execution.EditReport")
	private QAFExtendedWebElement EditReportBtn;	

	@FindBy (locator = "nflows.reports.execution.NewReport")
	private QAFExtendedWebElement NewReportBtn;	
	
	@FindBy (locator = "nflows.reports.execution.MoreDetails")
	private QAFExtendedWebElement MoreDetailsBtn;	
	
	@FindBy (locator = "nflows.reports.execution.Download_PNG")
	private QAFExtendedWebElement Download_PNGBtn;	
	
	@FindBy (locator = "nflows.reports.execution.Download_JPEG")
	private QAFExtendedWebElement Download_JPEGBtn;	
	
	@FindBy (locator = "nflows.reports.execution.Download_Excel")
	private QAFExtendedWebElement Download_ExcelBtn;	
	
	@FindBy (locator = "nflows.reports.execution.Download_PDF")
	private QAFExtendedWebElement Download_PDFBtn;	
	
	@FindBy (locator = "nflows.reports.execution.Download_SendMail")
	private QAFExtendedWebElement Download_SendMailBtn;	
	
	@FindBy (locator = "nflows.reportexecution.loadingicon")
	private QAFExtendedWebElement loadingicon;	

	@FindBy (locator = "nflows.reportexecution.securitystatusdrpdwn")
	private QAFExtendedWebElement securitystatusdrpdwn;	
	
	@FindBy (locator = "nflows.reportexecution.securitystatusactive")
	private QAFExtendedWebElement securitystatusactive;	
	
	@FindBy (locator = "nflows.reportexecution.securitystatusreport")
	private QAFExtendedWebElement securitystatusreport;	
	
	@FindBy (locator = "nflows.reportexecution.reportheading")
	private QAFExtendedWebElement reportheading;	

	@FindBy (locator = "nflows.reportexecution.pdfexport")
	private QAFExtendedWebElement pdfexport;
	
	@FindBy (locator = "nflows.reportexecution.subject")
	private QAFExtendedWebElement subject;
	
	@FindBy (locator = "nflows.reportexecution.mailcontent")
	private QAFExtendedWebElement mailcontent;
	
	@FindBy (locator = "nflows.reportexecution.mailtosearch")
	private QAFExtendedWebElement mailtosearch;
	
	@FindBy (locator = "nflows.reportexecution.mailtousername")
	private QAFExtendedWebElement mailtousername;
	
	@FindBy (locator = "nflows.reportexecution.mailto")
	private QAFExtendedWebElement mailto;
	
	@FindBy (locator = "nflows.reportexecution.mailtosendbutton")
	private QAFExtendedWebElement mailtosendbutton;
	
	@FindBy (locator = "nflows.reportexecution.attachmentformat")
	private QAFExtendedWebElement attachmentformat;
	
	@FindBy (locator = "nflows.reportexecution.attachmentpngformat")
	private QAFExtendedWebElement attachmentpngformat;
	
	@FindBy (locator = "nflows.reportexecution.emailsentnotification")
	private QAFExtendedWebElement emailsentnotification;
	
	@FindBy (locator = "nflows.reportexecution.emailsentnotificationclose")
	private QAFExtendedWebElement emailsentnotificationclose;

	@FindBy (locator = "nflows.reportexecution.widgetdownloadpng")
	private QAFExtendedWebElement widgetdownloadpng;		
			
	@FindBy (locator = "nflows.reportexecution.widgetdownloadjpeg")
	private QAFExtendedWebElement widgetdownloadjpeg;	

	@FindBy (locator = "nflows.reportexecution.widgetdownloadexcel")
	private QAFExtendedWebElement widgetdownloadexcel;	

	@FindBy (locator = "nflows.reportexecution.widgetdownloadpdf")
	private QAFExtendedWebElement widgetdownloadpdf;

	@FindBy (locator = "nflows.reportexecution.widgetmoredetails")
	private QAFExtendedWebElement widgetmoredetails;
	
// ------------------------------         Locators Ends here !          ----------------------------------------------------	
	
	public QAFExtendedWebElement getwidgetmoredetails() {
		return widgetmoredetails;
	}
	
	public QAFExtendedWebElement getwidgetdownloadpng() {
		return widgetdownloadpng;
	}
	
	public QAFExtendedWebElement getwidgetdownloadjpeg() {
		return widgetdownloadjpeg;
	}
	
	public QAFExtendedWebElement getwidgetdownloadexcel() {
		return widgetdownloadexcel;
	}
	
	public QAFExtendedWebElement getwidgetdownloadpdf() {
		return widgetdownloadpdf;
	}
	
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
	
	public QAFExtendedWebElement getpdfexport() 	{
		return pdfexport;
	}
	
	public QAFExtendedWebElement getreportheading(String ReportName) {
		String loc = String.format(pageProps.getString("nflows.reportexecution.reportheading"), ReportName);
		return new QAFExtendedWebElement(loc);		
	}
	
	public QAFExtendedWebElement getsecuritystatusreport() 	{
		return securitystatusreport;
	}
	
	public QAFExtendedWebElement getsecuritystatusactive() 	{
		return securitystatusactive;
	}
	
	public QAFExtendedWebElement getsecuritystatusdrpdwn() 	{
		return securitystatusdrpdwn;
	}
	
	public QAFExtendedWebElement getloadingicon() 	{
		return loadingicon;
	}
	
	public QAFExtendedWebElement getGenerateBtn() 	{
		return generateBtn;
	}
	
	public QAFExtendedWebElement getClearBtn() 	{
		return clearBtn;
	}
	
	public QAFExtendedWebElement getEditReportBtn() 	{
		return EditReportBtn;
	}
	
	public QAFExtendedWebElement getNewReportBtn() 	{
		return NewReportBtn;
	}
	
	public QAFExtendedWebElement getMoreDetailsBtn() {
		return MoreDetailsBtn;
	}
	
	public QAFExtendedWebElement getDownload_PNGBtn() {
		return Download_PNGBtn;
	}
	
	public QAFExtendedWebElement getDownload_JPEGBtn() {
		return Download_JPEGBtn;
	}
	
	public QAFExtendedWebElement getDownload_ExcelBtn() {
		return Download_ExcelBtn;
	}
	
	public QAFExtendedWebElement getDownload_PDFBtn() {
		return Download_PDFBtn;
	}
	
	public QAFExtendedWebElement getDownload_SendMailBtn() {
		return Download_SendMailBtn;
	}

	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	// ------------------------------         Getter method Ends here !          ----------------------------------------------------
	
	public boolean VerifyReportGeneration(String ReportName) throws Throwable
	{
		boolean result = false;		
		try {
			if(getloadingicon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
			Thread.sleep(1000);
			CommonBean.lbase_baseClass.actionClick(getsecuritystatusdrpdwn());
			CommonBean.lbase_baseClass.actionClick(getsecuritystatusactive());
			CommonBean.lbase_baseClass.actionClick(getsecuritystatusdrpdwn());
			BaseClass.getScreenshot("Click Generate for Report");
			CommonBean.lbase_baseClass.actionClick(getGenerateBtn());
			CommonBean.lbase_baseClass.sleep(3);		
			if(getEditReportBtn().isDisplayed() && getreportheading(ReportName).isDisplayed()){			
				result = true;
				BaseClass.getScreenshot("Report Generation Result - ");
			}
		}
		catch(Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet VerifyPngJpegExcelPdfinReportExecution(String ReportName,String DownloadFolder) throws Throwable
	{
		boolean resultPng = false,resultJpeg = false,resultExcel = false,resultPdf = false;
		String CurrentHandle, fileNamewithExt;
		Set<String> tabs;
		File f;
		ResultSet rs = new ResultSet();
		try	{
			if(getloadingicon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
			Thread.sleep(1000);
			CurrentHandle=driver.getWindowHandle();				
			//------Check for PNG
			try {
				fileNamewithExt = ReportName+".png";
				CommonBean.lbase_baseClass.actionClick(getMoreDetailsBtn());
				BaseClass.getScreenshot("Download Report in Png Format");
				CommonBean.lbase_baseClass.actionClick(getDownload_PNGBtn());
				Thread.sleep(1000);
				if(getloadingicon().isDisplayed())
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
				Thread.sleep(2000);				
				tabs=driver.getWindowHandles();
				for(String handle:tabs)		{
					if(!handle.equals(CurrentHandle))	{
						driver.switchTo().window(handle);
						if(CommonBean.lbase_baseClass.getpageTitle().contains(fileNamewithExt)) {
							BaseClass.getScreenshot("Download Report in Png Format Result - ");
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
				fileNamewithExt = ReportName+".jpeg";
				CommonBean.lbase_baseClass.actionClick(getMoreDetailsBtn());
				BaseClass.getScreenshot("Download Report in JPEG Format");
				CommonBean.lbase_baseClass.actionClick(getDownload_JPEGBtn());
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
							BaseClass.getScreenshot("Download Report in JPEG Format Result - ");
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
				fileNamewithExt = DownloadFolder + "\\" + ReportName + ".xlsx";
				f = new File(fileNamewithExt);				
				if(f.exists())
					f.delete();
				CommonBean.lbase_baseClass.actionClick(getMoreDetailsBtn());
				BaseClass.getScreenshot("Report in Excel Format Downloaded");
				CommonBean.lbase_baseClass.actionClick(getDownload_ExcelBtn());
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
				fileNamewithExt = ReportName+".pdf";
				fileNamewithExt = fileNamewithExt.replace(" ", "%20");
				f = new File(fileNamewithExt);
				if(f.exists())
					f.delete();
				CommonBean.lbase_baseClass.actionClick(getMoreDetailsBtn());
				CommonBean.lbase_baseClass.actionClick(getDownload_PDFBtn());
				BaseClass.getScreenshot("Export Report in Pdf Format");
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
							BaseClass.getScreenshot("Export Report in Pdf Format Result - ");
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
			rs.SetResult(false);
			e.printStackTrace();
		} 
		return rs;
	}

	public boolean VerifySendMailinReportExecution(String MailTo, String Subject, String MailContent) throws Throwable
	{
		boolean result = false;
		try {
			CommonBean.lbase_baseClass.actionClick(getMoreDetailsBtn());
			CommonBean.lbase_baseClass.actionClick(getDownload_SendMailBtn());
			Thread.sleep(1000);
			CommonBean.lbase_baseClass.actionClick(getmailto());
			CommonBean.lbase_baseClass.writeText(getmailtosearch(), MailTo);
			CommonBean.lbase_baseClass.actionClick(getmailtousername());
			CommonBean.lbase_baseClass.actionClick(getmailto());
			CommonBean.lbase_baseClass.actionClick(getattachmentformat());
			CommonBean.lbase_baseClass.actionClick(getattachmentpngformat());			
			CommonBean.lbase_baseClass.writeText(getsubject(), Subject);
			CommonBean.lbase_baseClass.writeText(getmailcontent(), MailContent);
			BaseClass.getScreenshot("Send Report in Mail");
			CommonBean.lbase_baseClass.actionClick(getmailtosendbutton());
			Thread.sleep(2000);
			if(getloadingicon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
			Thread.sleep(2000);
			if(getemailsentnotification().isDisplayed())
				result = true;
			BaseClass.getScreenshot("Send Report in Mail Result - ");
			CommonBean.lbase_baseClass.actionClick(getemailsentnotificationclose());
		}
		catch(Exception e) {			
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet VerifyPngJpegExcelPdfSpecificWidget(String ReportName, String WidgetName,String DownloadFolder) throws Throwable
	{
		boolean resultPng = false,resultJpeg = false,resultExcel = false,resultPdf = false;
		String CurrentHandle, fileNamewithExt;
		Set<String> tabs;
		File f;
		ResultSet rs = new ResultSet();
		try	{
			if(getloadingicon().isDisplayed())
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
			Thread.sleep(1000);
			CurrentHandle=driver.getWindowHandle();				
			//------Check for PNG
			try {
				fileNamewithExt = WidgetName + ".png";
				CommonBean.lbase_baseClass.actionClick(getwidgetmoredetails());
				BaseClass.getScreenshot("Download Specific Widget in Png Format");
				CommonBean.lbase_baseClass.actionClick(getwidgetdownloadpng());
				Thread.sleep(1000);
				if(getloadingicon().isDisplayed())
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
				Thread.sleep(2000);				
				tabs=driver.getWindowHandles();
				for(String handle:tabs)		{
					if(!handle.equals(CurrentHandle))	{
						driver.switchTo().window(handle);
						if(CommonBean.lbase_baseClass.getpageTitle().contains(fileNamewithExt)) {
							BaseClass.getScreenshot("Download Specific Widget in Png Format Result - ");
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
				fileNamewithExt = WidgetName + ".jpeg";
				CommonBean.lbase_baseClass.actionClick(getwidgetmoredetails());
				BaseClass.getScreenshot("Export specific widget in JPEG Format");
				CommonBean.lbase_baseClass.actionClick(getwidgetdownloadjpeg());
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
							BaseClass.getScreenshot("Export specific widget in JPEG Format Result - ");
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
				fileNamewithExt = DownloadFolder + "\\" + WidgetName + ".xlsx";
				f = new File(fileNamewithExt);				
				if(f.exists())
					f.delete();
				CommonBean.lbase_baseClass.actionClick(getwidgetmoredetails());
				BaseClass.getScreenshot("Export specific widget in Excel Format");
				CommonBean.lbase_baseClass.actionClick(getwidgetdownloadexcel());
				Thread.sleep(1000);
				if(getloadingicon().isDisplayed())
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
				Thread.sleep(4000);				
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
				fileNamewithExt = WidgetName + ".pdf";
				fileNamewithExt = fileNamewithExt.replace(" ", "%20");
				f = new File(fileNamewithExt);
				if(f.exists())
					f.delete();
				CommonBean.lbase_baseClass.actionClick(getwidgetmoredetails());
				CommonBean.lbase_baseClass.actionClick(getwidgetdownloadpdf());
				BaseClass.getScreenshot("Export specific widget in Pdf Format");
				CommonBean.lbase_baseClass.clickButton(getpdfexport());
				Thread.sleep(1000);
				if(getloadingicon().isDisplayed())
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(getloadingicon());
				Thread.sleep(4000);				
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
							BaseClass.getScreenshot("Export specific widget in Pdf Format Result - ");
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
			rs.SetResult(false);
			e.printStackTrace();
		} 
		return rs;
	}
	
	public boolean VerifyGlobalParametersReportExecution(String ReportName) throws Throwable
	{
		boolean result = false;
		try
		{
			CommonBean.lHome_page_home.navigateByMenu(ReportName);
			List<WebElement> elements = driver.findElements(By.xpath("//button[@class='dropdown-toggle ng-binding ng-scope']"));
			elements.get(0).click();
			driver.findElement(By.xpath("//span[contains(@class,'ng-scope ng-binding')][contains(text(),'Global')]")).click();
			elements.get(0).click();
			if(elements.get(2).getAttribute("Title").contains("Global") && elements.get(9).getAttribute("Title").contains("Global"))
				result = true;			
			elements.get(1).click();
			driver.findElement(By.xpath("//span[contains(text(),'Financial Services')]")).click();
			elements.get(1).click();
			BaseClass.getScreenshot("Selected Global Parameter ");
			getGenerateBtn().click();
			CommonBean.lbase_baseClass.sleep(3);
			BaseClass.getScreenshot("Report Generated on Selected Global Parameter Result - ");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return result;
	}
	
	
	public boolean generateReport(String astr_reportName) throws InterruptedException, IOException 
	{
		Boolean isSuccess=false;
		String initialReport[]=null;
		String reportValue=null;
		Xls_Reader getexcelFldGrpData=new Xls_Reader();			
		try 
		{			
			reportValue= getexcelFldGrpData.readColumnData("Reports","Reports", "Report Execution",astr_reportName);			
			initialReport=reportValue.split(",");

			for(int i=0;i<initialReport.length;i++)
			{					
				String FieldName,FieldType,Datavalue=null;
				
				// This statement splits field name and Field type based on '|' symbol
				String original[]=initialReport[i].split("=");			
				String actual[]=original[0].split("\\|");
				
				FieldName=actual[0].trim();			
				FieldType=actual[1].trim();				
				Datavalue=original[1].trim();				
				System.out.println("Field Name : " + FieldName + " | " + "Field Type : " + FieldType + " | " +"Data value : " + Datavalue);				
					
				CommonBean.projectLibrary.insertDisplaygroupFieldData(FieldName,FieldType,Datavalue,"Reports");			
			}
			
			// Select values from field
			// Check the value is valid
			// click generate button
			BaseClass.getScreenshot("Enter all data for report generation" );
			Thread.sleep(2500);
			CommonBean.lbase_baseClass.clickButton(getGenerateBtn());
			Thread.sleep(3500);
			CommonBean.lbase_baseClass.scrollHome();
			BaseClass.getScreenshot("Report generated for : " + astr_reportName);
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return isSuccess;		
	}	
	
	public Boolean editReport(String astr_parameters) throws InterruptedException, IOException 
	{	
		return null;	
	}
	
	public Boolean newReport(String astr_parameters) throws InterruptedException, IOException 
	{	
		return null;	
	}
	public Boolean downloadReport(String astr_type) throws InterruptedException, IOException 
	{			
		return null;	
	}
	public Boolean sendMail(String astr_Mailto,String astr_MailCC,String astr_attachmentFormat,String astr_Subject,String  astr_Mailcontent)
	{			
		return null;	
	}
}
