/**
	 * @author <Shayina>
	 * Created On 	- <26th Feb 2020>
	 * Responsibility- <This class consists of Reusable common methods specific for nFlows application >
	 * Modified by <name> on <date> for Issue <Issue number (s)> for Integration <integration number>
	 */
package com.quantum.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.pages.CommonBean;
import com.quantum.utils.DeviceUtils;

public class nFlowsLibrary extends WebDriverBaseTestPage<WebDriverTestPage> 
{
	
	// This method is get field group cell from the field group row
	public Boolean checkElementbyLabel(String fieldName) 
	{
		Boolean IselementExists =false;		
		try 
		{	
			QAFExtendedWebElement labelElement= DeviceUtils.getQAFDriver().findElement(By.xpath("//label[contains(text(),'" + fieldName + "')]"));
			CommonBean.lbase_baseClass.moveTo(labelElement);
			
			int size=DeviceUtils.getQAFDriver()
					.findElements(By.xpath("//label[contains(text(),'" + fieldName + "')]")).size();
			if(size!=0)
				IselementExists =true;				
			else
				IselementExists =false;
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return IselementExists;	
	}

	// This method is get field group cell from the field group row
	public WebElement getWebElement(int rowNum, int colNum, String dataType) 
	{
		System.out.println("((//div[@class='ui-grid-row ng-scope'])[" + 
								+ rowNum + "]//div[@role='gridcell'])[" + colNum + "]//" + dataType);
		WebElement element = DeviceUtils.getQAFDriver().findElement(By.xpath("((//div[@class='ui-grid-row ng-scope'])["
				+ rowNum + "]//div[@role='gridcell'])[" + colNum + "]//" + dataType ));
		return element;
	}
	
	// This method is get field group cell from the field group row
	public WebElement getWebElement(String astr_FieldGrpName,int rowNum, int colNum, String dataType) 
	{
		//@role='gridcell'
		// @ng-init='initGridRow(row)'
		WebElement element = null;
		String rowElement="@role='gridcell'";
		String oldElement="@ng-init='initGridRow(row)'";
		try {
			if(dataType.toLowerCase().contains("dropdown"))
				dataType="/div/div";
			else if(dataType.toLowerCase().contains("date"))
				dataType="//img";
			else if(dataType.toLowerCase().contains("multiline"))
				dataType="//a";
			else if(dataType.toLowerCase().contains("singleline"))
				dataType="//input";
			else if(dataType.toLowerCase().contains("number"))
				dataType="//input";
			else if(dataType.toLowerCase().contains("attachment"))
				dataType="/i";
			System.out.println("//div[contains(@ng-init,'" + astr_FieldGrpName + "')]/following::div[@class='ui-grid-canvas'][1]//div[@class='ui-grid-row ng-scope'][" + rowNum + "]//div[" + rowElement + "]["+ colNum + "]" + dataType);
			element = DeviceUtils.getQAFDriver().findElement(By.xpath("//div[contains(@ng-init,'" + astr_FieldGrpName + "')]/following::div[@class='ui-grid-canvas'][1]//div[@class='ui-grid-row ng-scope'][" + rowNum + "]//div[" + rowElement
					+ "]["+ colNum + "]"+ dataType));
			if(element.isDisplayed())		
				System.out.println("The Webelement exists for Task Field Group");
			else
				System.out.println("No such Webelement exists for Task Field Group");			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			element = DeviceUtils.getQAFDriver().findElement(By.xpath("//div[contains(@ng-init,'" + astr_FieldGrpName + "')]/following::div[@class='ui-grid-canvas'][1]//div[@class='ui-grid-row ng-scope'][" + rowNum + "]//div[" + oldElement + "]["+ colNum + "]"+ dataType));
		}
		return element;
	}
	
		// This method is get task related field group cell from the field group row
		public WebElement getTaskFGWebElement(String astr_FieldGrpName,int rowNum, int colNum, String dataType) 
		{
			WebElement element =null;
			try 
			{
				if(dataType.equalsIgnoreCase("dropdown"))
					dataType="/div/div";
				else if(dataType.equalsIgnoreCase("date"))
					dataType="//img";
				else if(dataType.equalsIgnoreCase("multiline"))
					dataType="//a";
				else if(dataType.equalsIgnoreCase("singleline"))
					dataType="/input";
				else if(dataType.equalsIgnoreCase("number"))
					dataType="/input";
				else if(dataType.equalsIgnoreCase("attachment"))
					dataType="/div//i";
				else if(dataType.equalsIgnoreCase("dropdown-singleSelect"))
					dataType="//button";
				
				
				System.out.println("//div//label[contains(text(),'" + astr_FieldGrpName + "')]/following::div[@class='ui-grid-canvas'][1]//div[@class='ui-grid-row ng-scope'][" + rowNum + "]//div[@ui-grid-cell]["+ colNum + "]" + dataType);
				element = DeviceUtils.getQAFDriver().findElement(By.xpath("//div//label[contains(text(),'" + astr_FieldGrpName + "')]/following::div[@class='ui-grid-canvas'][1]//div[@class='ui-grid-row ng-scope'][" + rowNum + "]//div[@ui-grid-cell]["+ colNum + "]"+ dataType));
				if(element.isDisplayed())		
					System.out.println("The Webelement exists for Task Field Group");
				else
					System.out.println("No such Webelement exists for Task Field Group");				
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return element;
		}
	
	public WebElement getWebElement(String fieldName, String dataType) 
	{
		WebElement element =null;		
		try 
		{
			element = DeviceUtils.getQAFDriver()
					.findElement(By.xpath("//label[text()='" + fieldName + "']/following-sibling::div//" + dataType + ""));
		
			if(element==null)
				element=DeviceUtils.getQAFDriver()
				.findElement(By.xpath("//label[contains(text(),'" + fieldName + "')]/following-sibling::div//" + dataType + ""));	
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block			
			if(element==null)
				element=DeviceUtils.getQAFDriver()
				.findElement(By.xpath("//label[contains(text(),'" + fieldName + "')]/following-sibling::div//" + dataType + ""));	
		
			//e.printStackTrace();
		}
		return element;
	}
	
	public WebElement getMultilineWebElement(String fieldName, String dataType) 
	{
		WebElement element =null;		
		try 
		{
			element = DeviceUtils.getQAFDriver()
					.findElement(By.xpath("//label[text()='" + fieldName + "']/following-sibling::div//span/i"));
		
			if(element==null)
				element=DeviceUtils.getQAFDriver()
				.findElement(By.xpath("//label[contains(text(),'" + fieldName + "')]/following-sibling::div//span/i"));	
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block			
			if(element==null)
				element=DeviceUtils.getQAFDriver()
				.findElement(By.xpath("//label[contains(text(),'" + fieldName + "')]/following-sibling::div//span/i"));		
		
		}
		return element;
	}
	
	// This method is only meant for Report Execution
	public WebElement getReportWebElement(String fieldName, String dataType) 
	{
		WebElement element =null;		
		try 
		{
			element = DeviceUtils.getQAFDriver()
					.findElement(By.xpath("//label[text()='" + fieldName + "']/following-sibling::" + dataType + ""));
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}
	
	public WebElement getPasswordWebElement(String fieldName, String dataType) 
	{
		WebElement element =null;
		try
		{
			element = DeviceUtils.getQAFDriver()
					.findElement(By.xpath("//label[text()='" + fieldName + "']/following-sibling::div//input[@type='password']"));
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;		
	}
		
	public WebElement getdrpdownWebElement(String fieldName) 
	{
		WebElement element =null;
		try 
		{
			element = DeviceUtils.getQAFDriver()
					.findElement(By.xpath("//label[text()='" + fieldName + "']/following-sibling::div"));
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			element = DeviceUtils.getQAFDriver()
					.findElement(By.xpath("//label[contains(text(),'" + fieldName + "')]/following-sibling::div"));
		}
		
		return element;
	}
	
	public WebElement getTextFromdrpdownElement(String fieldName) 
	{
		WebElement element =null;
		try 
		{
			element = DeviceUtils.getQAFDriver()
					.findElement(By.xpath("(//label[text()='" + fieldName + "']/following-sibling::div//button)[1]"));
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			element = DeviceUtils.getQAFDriver()
					.findElement(By.xpath("(//label[contains(text(),'" + fieldName + "')]/following-sibling::div//button)[1]"));
		}
		
		return element;
	}
	
	public WebElement getDateWebElement(String fieldName)
	{
		WebElement element =null;
		try
		{
			element = DeviceUtils.getQAFDriver()
					.findElement(By.xpath("//label[text()='" + fieldName + "']/following-sibling::div//img[@class='ui-datepicker-trigger']"));
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				element = DeviceUtils.getQAFDriver()
						.findElement(By.xpath("//label[text()='" + fieldName + "']/following-sibling::div/input"));
			} 
			catch (Exception e1) {
				// TODO Auto-generated catch block
				element = DeviceUtils.getQAFDriver()
						.findElement(By.xpath("//label[contains(text(),'" + fieldName + "')]/following-sibling::div//img[@class='ui-datepicker-trigger']"));
			
			}
		
		}
		return element;
	}

	// Method Author : M.S.Sumesh 
	public WebElement getAttachmentTextWebElement(String fieldName)
	{
		WebElement element =null;
		try {
			element = DeviceUtils.getQAFDriver()
					.findElement(By.xpath("(//label[contains(text(),'" + fieldName + "')]/following-sibling::div/input)[1]"));
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}
	
	public WebElement getReportDateWebElement(String fieldName)
	{
		WebElement element =null;
		try {
			element = DeviceUtils.getQAFDriver()
					.findElement(By.xpath("//label[text()='" + fieldName + "']/following-sibling::img[@class='ui-datepicker-trigger']"));
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}
	
	public WebElement getAttachmentWebElement(String fieldName) 
	{
		WebElement element =null;
		try {
			element = DeviceUtils.getQAFDriver()
					.findElement(By.xpath("//label[text()='" + fieldName + "']/following-sibling::div//i[@title='Attachment']"));
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			element = DeviceUtils.getQAFDriver()
					.findElement(By.xpath("//label[contains(text(),'" + fieldName + "')]/following-sibling::div//i[@title='Attachment']"));
		
		}
		return element;
	}
	
	public WebElement getWebElement(String loc) 
	{
		WebElement element = DeviceUtils.getQAFDriver().findElement(By.xpath("//span[text()='" + loc + "']"));
		return element;
	}

	public WebElement getWebElement(int rowNum) 
	{
		WebElement element = null;
		try {
			element = DeviceUtils.getQAFDriver()
					.findElement(By.xpath("((//div[@class='ui-grid-row ng-scope'])[" + rowNum + "]"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}
	
	// Elements based on Multiline field in Textarea
	public WebElement getMultilineElement() 
	{
		WebElement element = null;
		try {
			element =DeviceUtils.getQAFDriver()
					.findElement(By.xpath("//textarea[contains(@id,'multiline_popover')]"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			element =DeviceUtils.getQAFDriver()
					.findElement(By.xpath("//textarea[contains(@ng-model,'multi_line_fld_grp_ng_model')]"));
		}
		return element;
	}
	
	// Elements based on Multiline field in Textarea
	public WebElement getMultilineConfirm(String astr_confirm) 
	{
		WebElement element=null;
		try {
			element = DeviceUtils.getQAFDriver()
					.findElement(By.xpath("//div[@class='popover-content']//div//button[text()='" + astr_confirm +"']"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}
	

	/**
	 * Responsibility - <This method is to get Header column numbers of Fieldgroup>
	 * 
	 * @param -
	 *            < >
	 * @return Integer - aint_colnum - <return Header Column Numbers>
	 * @throws Exception
	 * @author Shayina
	 * @return
	 */

	public int getFieldgroupHeaderColumnNumber(String astr_fieldName, List<WebElement> aweb_header)
	{
		int colNum=0;
		try {			
			for (int k = 1; k < aweb_header.size(); k++) {
				if (aweb_header.get(k).getText().trim().equalsIgnoreCase(astr_fieldName)) {
					colNum = k +1 ;
					break;
				}				
			}
			System.out.println("*************************" + colNum);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return colNum;
	}

	public void addFieldgroupRows(QAFExtendedWebElement aweb_add, int aint_Rows) throws InterruptedException {
		CommonBean.lbase_baseClass.scrollintoView(aweb_add);
		for (int i = 1; i <= aint_Rows; i++)
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", aweb_add);			
			//CommonBean.lbase_baseClass.clickButton(aweb_add);
		}
	}

	// Code developed by Shayina
	public void insertFieldgroupData(int aint_Rows, String astr_fieldName, List<WebElement> aweb_header,
			String dataType, String data) throws InterruptedException
	{
		String[] dataArray = data.split(",");
		for (int i = 1; i <= aint_Rows; i++) 
		{
			WebElement Cell = getWebElement(i, getFieldgroupHeaderColumnNumber(astr_fieldName, aweb_header), dataType);
			if (dataType.equalsIgnoreCase("input")) 
			{
				CommonBean.lbase_baseClass.writeText((QAFExtendedWebElement) Cell, dataArray[i]);
			}
			if (dataType.equalsIgnoreCase("button")) {
				CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement) Cell);
				Thread.sleep(3000);
				WebElement aweb_dropdown = getWebElement(dataArray[i]);
				CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement) aweb_dropdown);
				Thread.sleep(3000);
			}
		}
	}

	public void modifyFieldgroupData(String astr_checkFieldName, String astr_ModifyFieldName,
			List<WebElement> aweb_header, String astr_checkData, String astr_modifyData, String dataType)
			throws InterruptedException 
	{
		// Column no for the field to satisfy the condition
		int checkColumn = getFieldgroupHeaderColumnNumber(astr_checkFieldName, aweb_header);

		// Column number for the field to be modified
		int modifyColumn = getFieldgroupHeaderColumnNumber(astr_ModifyFieldName, aweb_header);

		List<WebElement> Rows = DeviceUtils.getQAFDriver()
				.findElements(By.xpath("//div[@class='ui-grid-row ng-scope']"));

		for (int i = 1; i <= Rows.size(); i++) 
		{
			WebElement RowElement = getWebElement(i);
			List<WebElement> Cells = RowElement.findElements(By.xpath("//div[@role='gridcell']"));

			if (Cells.get(checkColumn - 1).getText().trim().equalsIgnoreCase(astr_checkData)) 
			{
				WebElement modifyCell = getWebElement(i, modifyColumn, dataType);
				if (dataType.equalsIgnoreCase("input")) {
					modifyCell.clear();
					CommonBean.lbase_baseClass.writeText((QAFExtendedWebElement) modifyCell, astr_modifyData);
				}
				if (dataType.equalsIgnoreCase("button")) {
					CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement) modifyCell);
					Thread.sleep(3000);
					WebElement aweb_dropdown = getWebElement(astr_modifyData);
					CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement) aweb_dropdown);
					Thread.sleep(3000);
				}
				break;
			}
		}
	}

	public void deleteFieldgroupRow(int rowNum) 
	{
		try {
			DeviceUtils.getQAFDriver().findElement(By.xpath("(//div[@class='remove ng-scope'])[" + rowNum + "]")).click();
			DeviceUtils.getQAFDriver().findElement(By.xpath("//button[@id='yesbtn']")).click();
			List<WebElement> Rows = DeviceUtils.getQAFDriver()
					.findElements(By.xpath("//div[@class='ui-grid-row ng-scope']"));
			System.out.println("Row Number: " + Rows.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method created by : Sumesh, Date: 05-June-2020
	public void insertDisplaygroupFieldData(String astr_fieldName, String astr_dataType, String astr_data,String module) throws InterruptedException
	{
		QAFExtendedWebElement element=null;
		Boolean isReadable=false;
		try 
		{
			if(astr_dataType.trim().toLowerCase().equals("singleline")|| astr_dataType.trim().toLowerCase().equals("number"))
			{
				astr_dataType="input";
				if(module.equalsIgnoreCase("Reports"))
				{
					element=(QAFExtendedWebElement)getReportDateWebElement(astr_fieldName);
					CommonBean.lbase_baseClass.clickButton(element);
				}
				else				
					element=(QAFExtendedWebElement)getWebElement(astr_fieldName, astr_dataType);				
			}	
			else if(astr_dataType.trim().toLowerCase().equals("multiline"))
			{
				astr_dataType="textarea";
				element=(QAFExtendedWebElement)getWebElement(astr_fieldName, astr_dataType);				
			}
			else if(astr_dataType.trim().toLowerCase().equals("rtf"))
			{				
				element=(QAFExtendedWebElement)getMultilineWebElement(astr_fieldName, astr_dataType);
				CommonBean.lbase_baseClass.clickButton(element);
			}
			else if(astr_dataType.trim().toLowerCase().equals("date") && !module.equalsIgnoreCase("Reports"))
				element=(QAFExtendedWebElement)getDateWebElement(astr_fieldName);			
			
			// singleline, number, multiline
			switch (astr_dataType.trim().toLowerCase()) 
			{
				case "input":
					if(module.equalsIgnoreCase("Reports"))
						CommonBean.lbase_baseClass.writeText(element,astr_data);
					else	
					{
						isReadable=CommonBean.lbase_baseClass.isAttribtuePresent(element, "readonly");
						if(!isReadable)
						{
							CommonBean.lbase_baseClass.clickButton(element);
							CommonBean.lbase_baseClass.writeText(element,astr_data);
						}							
						else
							System.out.println("This field is read-only !");
					}						
					break;
					
				case "password":
					CommonBean.lbase_baseClass.writeText((QAFExtendedWebElement) getPasswordWebElement(astr_fieldName, astr_dataType),
							astr_data);
					break;
					
				case "textarea":
					isReadable=CommonBean.lbase_baseClass.isAttribtuePresent(element, "readonly");
					if(!isReadable)
					{
						CommonBean.lbase_baseClass.clickButton(element);
						CommonBean.lbase_baseClass.writeText(element, astr_data);
					}						
					else
						System.out.println("This field " + astr_fieldName + " is read-only !");
					break;					
				case "rtf":
					DeviceUtils.getQAFDriver().findElement(By.xpath("//div[@class='modal-body']//div[@class='ql-toolbar ql-snow']//span[13]/button")).click();
					Thread.sleep(600);
					DeviceUtils.getQAFDriver().findElement(By.xpath("//div[@class='modal-body']//pre/div[contains(@class,'ql-editor')]")).sendKeys(astr_data);
					Thread.sleep(500);
					DeviceUtils.getQAFDriver().findElement(By.xpath("//div[@class='modal-footer']/button[contains(text(),'Save')]")).click();
					Thread.sleep(500);					
					break;

				case "dropdown-singleselect":
				case "dropdown-multiselect":
					String drp[]=astr_dataType.split("-");
					String lstr_selectType="";	
					QAFExtendedWebElement drpDownElement=null;							
					drpDownElement=(QAFExtendedWebElement) getdrpdownWebElement(astr_fieldName);
					
					if (drp[1].equalsIgnoreCase("singleSelect")) 
						lstr_selectType="singleSelect";
					else if(drp[1].equalsIgnoreCase("multiSelect")) 
						lstr_selectType="multiSelect";
					else 
						System.out.println("wrong condtion for dropdown");		
					
					isReadable=CommonBean.lbase_baseClass.isAttribtuePresent(drpDownElement, "readonly");
					if(!isReadable)					
						CommonBean.lbase_baseClass.selectFromDropdown(drpDownElement, astr_data, lstr_selectType);
					break;				
				case "dropdown":	
					element=(QAFExtendedWebElement) getdrpdownWebElement(astr_fieldName);
					isReadable=CommonBean.lbase_baseClass.isAttribtuePresent(element, "readonly");
					if(!isReadable)
					{
						CommonBean.lbase_baseClass.clickButton(element);
						CommonBean.lbase_baseClass.selectPartialText(astr_data);
					}
					else
						System.out.println("This field " + astr_fieldName + " is read-only !");									
					break;
				case "date":		
					// Method to select Date from picker - Starts
					if(module.equalsIgnoreCase("Reports"))
						CommonBean.lbase_baseClass.clickButton(element);
					else	
					{
						isReadable=CommonBean.lbase_baseClass.isAttribtuePresent(element, "readonly");
						if(!isReadable)
						{
							CommonBean.lbase_baseClass.clickButton(element);
							Thread.sleep(1000);	
							CommonBean.lbase_baseClass.selectDatefromPicker(astr_data);
						}
						else
							System.out.println("This field '" + astr_fieldName + "' is read-only !");						
					}						
					break;					
				case "attachment":
//					CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement)getAttachmentTextWebElement(astr_fieldName));
//					Thread.sleep(700);
					processAttachment(astr_fieldName, "Upload", astr_data);	
					break;
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Method created by : Sumesh, Date: 05-June-2020
	public void loadFieldgroupData(WebElement element,String astr_dataType,String astr_data,int fieldGrp_row) throws InterruptedException 
	{		
		QAFExtendedWebElement qafelement=null;
		try {
			if(astr_dataType.equalsIgnoreCase("singleline")|| astr_dataType.equalsIgnoreCase("number"))
			{
				astr_dataType="input";
				//CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement) element);
			}	
			else if(astr_dataType.equalsIgnoreCase("multiline"))
			{
				astr_dataType="textarea";
				//CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement)element);
			}
			// singleline, number, multiline
			switch (astr_dataType.trim().toLowerCase()) 
			{
			
				case "input":
					try 
					{
						qafelement=(QAFExtendedWebElement)element;
						qafelement.clear();
						CommonBean.lbase_baseClass.writeText(qafelement,astr_data);							
					} 
					catch (NoSuchElementException  e) 
					{			
						JavascriptExecutor js = (JavascriptExecutor) driver;
						Object searchTextbar = js.executeScript("return document.getElementById('lst-ib')");
						((WebElement) searchTextbar).sendKeys(astr_data);						
					}
					break;		
				case "textarea":
					try 
					{	
						qafelement=(QAFExtendedWebElement)element;					
						CommonBean.lbase_baseClass.clickButton(qafelement);
						CommonBean.lbase_baseClass.doubleClick(qafelement);	
					} 
					catch (Exception e) 
					{					
						JavascriptExecutor executor = (JavascriptExecutor)driver;
						executor.executeScript("scroll(250, 0)");
					}
					Thread.sleep(1000);
					QAFExtendedWebElement qafMultilineElement=(QAFExtendedWebElement)getMultilineElement();
					if(qafMultilineElement.isPresent())
					{
						qafMultilineElement.clear();
						CommonBean.lbase_baseClass.writeText(qafMultilineElement,astr_data);	
						CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement)getMultilineConfirm("Ok"));
					}									
					break;
					
				case "dropdown-singleselect":
				case "dropdown-multiselect":				
						String drp[]=astr_dataType.split("-");
						String lstr_selectType="";					
						
						if (drp[1].equalsIgnoreCase("singleSelect")) 
							lstr_selectType="singleSelect";
						else if(drp[1].equalsIgnoreCase("multiSelect")) 
							lstr_selectType="multiSelect";
						else 
							System.out.println("wrong condtion for dropdown");					
						CommonBean.lbase_baseClass.selectFromDropdown((QAFExtendedWebElement)element, astr_data, lstr_selectType,fieldGrp_row);
						
						break;
				case "date":					
					// Method to select Date from picker - Starts
					CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement)element);
					Thread.sleep(700);
					CommonBean.lbase_baseClass.selectDatefromPicker(astr_data);
					break;
							
				case "attachment":
					CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement)element);
					Thread.sleep(700); //1000				
						
					CommonBean.lbase_baseClass.fileUpload("",astr_data);
					Thread.sleep(1000);
					break;	
			}
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	// Method created by : Sumesh, Date: 12-apr-2020
	public int getHeaderIndex(String colName)
	{
		int colNum=0;
		try {
				
			List<WebElement> col=DeviceUtils.getQAFDriver().findElements(By.xpath("(//div[@class='ui-grid-header-cell-row'])[1]//*[contains(@id,'header-text')]"));

			for(int i=0;i<=col.size();i++)
			{			
				if(col.get(i).getText().trim().equalsIgnoreCase(colName.trim())){
					colNum=i;
					break;
				}
				else {
					System.out.println("Invalid column name !");
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return colNum;
	}
	
	// Method created by : Sumesh, Date: 12-apr-2020
	public boolean editGridData(String astr_gridData,int astr_headerIndex) throws InterruptedException, IOException
	{
		Boolean isRecordexists=false;
		try {
			// Get all rows from the Grid
			String rowPath="//div[@class='ui-grid-row ng-scope']";		
			
			
			List<WebElement> row=DeviceUtils.getQAFDriver().findElementsByXPath(rowPath);		
				
			for(int i=1;i<=row.size();i++)
			{					
				String cellPath="//div[@class='ui-grid-row ng-scope'][" + i +"]//div[contains(@class,'ui-grid-cell')]";
				// To process each row data			
				QAFExtendedWebElement rowDataElement=DeviceUtils.getQAFDriver().findElementByXPath(cellPath + "["+astr_headerIndex + "]");
				String getrowData=rowDataElement.getText().trim().toLowerCase();
						
				// If entity data matches , Edit the task			
				if(astr_gridData != null && !astr_gridData.isEmpty() && getrowData.trim().equalsIgnoreCase(astr_gridData.trim().toLowerCase())) 
				{				
					System.out.println("The Entity data : " + getrowData);	
					CommonBean.lbase_baseClass.highLightElement(rowDataElement);
					BaseClass.getScreenshot("Search for the Entity record - " + astr_gridData);
					
					CommonBean.lbase_baseClass.doubleClick(rowDataElement);
					Thread.sleep(4000);
					isRecordexists=true;
					break;		
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isRecordexists;
	}
	
	/* Method Author: M.S.SUMESH 
	 * Created date: 9th Sep 2020
	 * Purpose : This method splits data from collections and get task field name, type , data */
	public void splitMapdata(String astr_taskAction,Map<String, String> map) throws InterruptedException
	{
		try
		{
			System.out.println("Method Name: splitMapdata is called");
			ArrayList<String> validationList=new ArrayList<String>();
			
			for (Entry<String, String> entry : map.entrySet()) 
			{					
				String arr[]=entry.getKey().split("\\|");//									
				String FieldName,FieldType,Datavalue=null;
				
				// This statement splits field name and Field type based on '|' symbol					
				FieldName=arr[0].trim();
				FieldType=arr[1].trim();
				Datavalue=entry.getValue().trim();				
				System.out.println("Field Name : " + FieldName + " | "+  "Field Type : " + FieldType + " | "+"Data value : " + Datavalue);				
				
				// Check whether the display group field exists based on Label Name
				Boolean IselementExists=CommonBean.projectLibrary.checkElementbyLabel(FieldName);
				if(IselementExists)
				{	
					Thread.sleep(500);
					//This statement fills data in Display group fields
					//CommonBean.projectLibrary.insertDisplaygroupFieldData(FieldName,FieldType,Datavalue,"");
					
					switch(astr_taskAction)
					{
						case "INSERT":
							CommonBean.projectLibrary.insertDisplaygroupFieldData(FieldName,FieldType,Datavalue,"");
							break;
						case "UPDATE":
							performUpdateAction( FieldName,  FieldType, Datavalue);
							break;
						case "DELETE":
							performDeleteAction( FieldName,  FieldType, Datavalue);
							break;
						case "VALIDATE":
							validationList.add(performValidateAction( FieldName,  FieldType, Datavalue));
							break;
					}				
				}	
			}			
			System.out.println("The validation List contains : " + validationList);
		} 
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	/* Method Author: M.S.SUMESH 
	 * Created date: 22nd Sep 2020
	 * Purpose : This method splits data from collections and get field grp task field name, type , data */
	public void splitFieldGrpMapdata(String astr_taskAction,Map<String, String> map,String astr_FieldGroupName,int aint_Fieldgrprow) throws InterruptedException
	{
		try
		{		
			System.out.println("Method Name: splitFieldGrpMapdata is called");
			String fieldGrpHeader="//div/label[contains(text(),'" + astr_FieldGroupName + "')]"
					+ "/following::div[contains(@class,'ui-grid-header-cell-wrapper')][1]//span[contains(@class,'ui-grid-header-cell-label')]";
			
			List<WebElement> fieldGrpHeaderList=DeviceUtils.getQAFDriver().findElementsByXPath(fieldGrpHeader);			
			
			
			for (Entry<String, String> entry : map.entrySet()) 
			{					
				String arr[]=entry.getKey().split("\\|");//									
				String FieldName,FieldType,Datavalue=null;
				
				// This statement splits field name and Field type based on '|' symbol					
				FieldName=arr[0].trim();
				FieldType=arr[1].trim();
				Datavalue=entry.getValue().trim();				
				System.out.println("Row : " +aint_Fieldgrprow + " , Field Name : " + FieldName + " | "+  "Field Type : " + FieldType + " | "+"Data value : " + Datavalue);				
				
				int lint_fieldGrpColNum=CommonBean.projectLibrary.getFieldgroupHeaderColumnNumber(FieldName, fieldGrpHeaderList);
				// Check whether column exists in field group
				if(lint_fieldGrpColNum!=0)
				{
					WebElement Cell=null;
					try {
						Cell = CommonBean.projectLibrary.getTaskFGWebElement(astr_FieldGroupName,aint_Fieldgrprow, lint_fieldGrpColNum, FieldType);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//if(entry.getKey()>10)
					//	CommonBean.lbase_baseClass.scrollDown();					
					
					switch(astr_taskAction)
					{
						case "INSERT":
							System.out.println(aint_Fieldgrprow);
							CommonBean.projectLibrary.loadFieldgroupData(Cell, FieldType, Datavalue,aint_Fieldgrprow);
							break;
						case "UPDATE":
							System.out.println(aint_Fieldgrprow);
							performFieldgrpUpdate(aint_Fieldgrprow, Cell,FieldName,  FieldType, Datavalue);							
							break;						
						case "VALIDATE":
							System.out.println(aint_Fieldgrprow);
							CommonBean.projectLibrary.performFieldgrpValidate(aint_Fieldgrprow, Cell, FieldName, FieldType, Datavalue);
							//validationList.add(performValidateAction( FieldName,  FieldType, Datavalue));
							break;
						case "ADD":
							CommonBean.projectLibrary.loadFieldgroupData(Cell, FieldType, Datavalue,aint_Fieldgrprow);
							break;
					}						
				}
				else
					System.out.println("Field group Coloum :  " + FieldName + " Does n't exists ! ");		
			}		
		} 
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	/* Method Author: M.S.SUMESH 
	 * Created date: 16th Sep 2020
	 * Purpose : This method performs task field updation from display group level */
	@SuppressWarnings("null")
	public void performUpdateAction(String astr_fieldName, String astr_dataType,String astr_data) throws InterruptedException
	{
//		String str_validateData = null,str_attributeData="";
//		String testResult=null;
//		Boolean isSuccess=false;
		Boolean isReadable=false;
		QAFExtendedWebElement WebElement=null;
		try 
		{
			System.out.println("Method Name: performUpdateAction is called");
			if(astr_dataType.equals("singleline")|| astr_dataType.equals("number"))
				astr_dataType="input";	
			else if(astr_dataType.equals("multiline"))
				astr_dataType="textarea";
			
			switch (astr_dataType.trim().toLowerCase()) 
			{
				case "input":									
					WebElement=(QAFExtendedWebElement) getWebElement(astr_fieldName, astr_dataType);					
					isReadable=CommonBean.lbase_baseClass.isAttribtuePresent(WebElement, "readonly");
					if(!isReadable)
					{
						WebElement.clear();
						WebElement.sendKeys(astr_data);
					}
					else
						System.out.println("This field '"+ astr_fieldName +  "' is read-only !");
					break;					
				case "password":
					WebElement=(QAFExtendedWebElement) getPasswordWebElement(astr_fieldName, astr_dataType);
					isReadable=CommonBean.lbase_baseClass.isAttribtuePresent(WebElement, "readonly");
					if(!isReadable)
					{
						WebElement.clear();
						WebElement.sendKeys(astr_data);
					}
					else
						System.out.println("This field '"+ astr_fieldName +  "' is read-only !");						
					break;					
				case "textarea":
					WebElement=(QAFExtendedWebElement) getWebElement(astr_fieldName, astr_dataType);
					isReadable=CommonBean.lbase_baseClass.isAttribtuePresent(WebElement, "readonly");
					if(!isReadable)
					{
						WebElement.clear();
						WebElement.sendKeys(astr_data);
					}
					else
						System.out.println("This field '"+ astr_fieldName +  "' is read-only !");						
					break;

				case "dropdown-singleselect":
				case "dropdown-multiselect":
					String drp[]=astr_dataType.split("-");
					String lstr_selectType="";	
					QAFExtendedWebElement drpDownElement=null;							
					drpDownElement=(QAFExtendedWebElement) getdrpdownWebElement(astr_fieldName);
					
					isReadable=CommonBean.lbase_baseClass.isAttribtuePresent(WebElement, "readonly");
					if(!isReadable)
					{					
						if (drp[1].equalsIgnoreCase("singleSelect")) 
							lstr_selectType="singleSelect";
						else if(drp[1].equalsIgnoreCase("multiSelect")) 
							lstr_selectType="multiSelect";
						else 
							System.out.println("wrong condtion for dropdown");					
	
						drpDownElement=(QAFExtendedWebElement) getdrpdownWebElement(astr_fieldName);
						CommonBean.lbase_baseClass.selectFromDropdown(drpDownElement, astr_data, lstr_selectType);
					}
					else
						System.out.println("This field '"+ astr_fieldName +  "' is read-only !");					
					break;				
				case "dropdown":						
					QAFExtendedWebElement singledrpDownElement=null;
					singledrpDownElement=(QAFExtendedWebElement) getdrpdownWebElement(astr_fieldName);
					//CommonBean.lbase_baseClass.unselectFromDropdownList(drpDownElement, astr_ddValue);
					isReadable=CommonBean.lbase_baseClass.isAttribtuePresent(WebElement, "readonly");
					if(!isReadable)
					{					
						CommonBean.lbase_baseClass.clickButton(singledrpDownElement);
						CommonBean.lbase_baseClass.selectPartialText(astr_data);
					}
					else
						System.out.println("This field '"+ astr_fieldName +  "' is read-only !");
					break;
				case "date":		
//					// Method to select Date from picker - Starts	
					WebElement=(QAFExtendedWebElement) getDateWebElement(astr_fieldName);
					isReadable=CommonBean.lbase_baseClass.isAttribtuePresent(WebElement, "readonly");
					if(!isReadable)
					{
						CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement)getDateWebElement(astr_fieldName));
						Thread.sleep(1000);						
						CommonBean.lbase_baseClass.selectDatefromPicker(astr_data);
					}
					else
						System.out.println("This field '"+ astr_fieldName +  "' is read-only !");
					break;					
				case "attachment":
					processAttachment(astr_fieldName, "Upload", astr_data);				
					break;					
			}				
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	
	/* Method Author: M.S.SUMESH 
	 * Created date: 9th Sep 2020
	 * Purpose : This method performs task field deletion from display group level */
	public void performDeleteAction(String astr_fieldName, String astr_dataType,String astr_data) throws InterruptedException
	{
		QAFExtendedWebElement WebElement=null;
		Boolean isPresent=false;
		Boolean isReadable=false;
		try 
		{
			if(astr_dataType.equals("singleline")|| astr_dataType.equals("number"))
				astr_dataType="input";	
			else if(astr_dataType.equals("multiline"))
				astr_dataType="textarea";
			
			// isPresent=CommonBean.lbase_baseClass.isAttribtuePresent(element, "readonly");
			switch (astr_dataType.trim().toLowerCase()) 
			{
				case "input":
					WebElement=(QAFExtendedWebElement) getWebElement(astr_fieldName, astr_dataType);
					isReadable=CommonBean.lbase_baseClass.isAttribtuePresent(WebElement, "readonly");
					if(!isReadable)
						WebElement.clear();
					else
						System.out.println("This field '"+ astr_fieldName +  "' is read-only !");
					break;					
				case "password":
					WebElement=(QAFExtendedWebElement) getPasswordWebElement(astr_fieldName, astr_dataType);
					isReadable=CommonBean.lbase_baseClass.isAttribtuePresent(WebElement, "readonly");
					if(!isReadable)
						WebElement.clear();			
					else
						System.out.println("This field '"+ astr_fieldName +  "' is read-only !");
					break;					
				case "textarea":
					WebElement=(QAFExtendedWebElement) getWebElement(astr_fieldName, astr_dataType);
					isReadable=CommonBean.lbase_baseClass.isAttribtuePresent(WebElement, "readonly");
					if(!isReadable)
						WebElement.clear();
					else
						System.out.println("This field '"+ astr_fieldName +  "' is read-only !");
					break;

				case "dropdown-singleselect":
				case "dropdown-multiselect":
					String drp[]=astr_dataType.split("-");
					String lstr_selectType="";	
					QAFExtendedWebElement drpDownElement=null;							
					drpDownElement=(QAFExtendedWebElement) getdrpdownWebElement(astr_fieldName);
					isReadable=CommonBean.lbase_baseClass.isAttribtuePresent(drpDownElement, "readonly");
					if(!isReadable)
					{
						if (drp[1].equalsIgnoreCase("singleSelect")) 
							lstr_selectType="singleSelect";
						else if(drp[1].equalsIgnoreCase("multiSelect")) 
							lstr_selectType="multiSelect";
						else 
							System.out.println("wrong condtion for dropdown");
						
						CommonBean.lbase_baseClass.selectFromDropdown(drpDownElement, astr_data, lstr_selectType);
					}
					else
						System.out.println("This field '"+ astr_fieldName +  "' is read-only !");					
					break;				
				case "dropdown":					
					CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement) getdrpdownWebElement(astr_fieldName));
					CommonBean.lbase_baseClass.selectPartialText(astr_data);
					break;
				case "date":
					WebElement=(QAFExtendedWebElement) getDateWebElement(astr_fieldName);
					isReadable=CommonBean.lbase_baseClass.isAttribtuePresent(WebElement, "readonly");
					if(!isReadable)
					{
						// Method to select Date from picker - Starts										
						CommonBean.lbase_baseClass.clickButton(WebElement);
						Thread.sleep(1000);		// 1500			
						
						CommonBean.lbase_baseClass.selectDatefromPicker(astr_data);
					}
					else
						System.out.println("This field '"+ astr_fieldName +  "' is read-only !");
					break;
					
				case "attachment":
					Thread.sleep(500);					
					processAttachment(astr_fieldName, "Remove", "");
					break;				
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* Method Author: M.S.SUMESH 
	 * Created date: 9th Sep 2020
	 * Purpose : This method performs task field deletion from display group level */
	@SuppressWarnings("null")
	public String performValidateAction(String astr_fieldName, String astr_dataType,String astr_data) throws InterruptedException
	{
		String str_validateData = null,str_attributeData="";
		String testResult=null;
		Boolean isSuccess=false;
		try 
		{
			if(astr_dataType.equals("singleline")|| astr_dataType.equals("number"))
				astr_dataType="input";
			else if(astr_dataType.equals("multiline"))
				astr_dataType="textarea";
			
			switch (astr_dataType.trim().toLowerCase()) 
			{
				case "input":		
					str_attributeData=getWebElement(astr_fieldName, astr_dataType).getAttribute("ng-init");
					str_validateData= str_attributeData.substring(str_attributeData.indexOf("\'")+1, str_attributeData.length()-1);
					str_validateData=str_validateData.replaceAll(",", "");
					break;					
				case "password":
					str_attributeData=getPasswordWebElement(astr_fieldName, astr_dataType).getAttribute("ng-init");
					str_validateData= str_attributeData.substring(str_attributeData.indexOf("\'")+1, str_attributeData.length()-1);
					break;					
				case "textarea":
					str_attributeData=getWebElement(astr_fieldName, astr_dataType).getAttribute("ng-init");
					str_validateData= str_attributeData.substring(str_attributeData.indexOf("\'")+1, str_attributeData.length()-1);
					break;
				case "dropdown-singleselect": case "dropdown-multiselect":						
					QAFExtendedWebElement drpDownElement=null;							
					drpDownElement=(QAFExtendedWebElement) getTextFromdrpdownElement(astr_fieldName);			
					str_validateData=drpDownElement.getAttribute("title");
					break;				
				case "dropdown":					
					QAFExtendedWebElement normaldrpDown=null;							
					normaldrpDown= (QAFExtendedWebElement) getTextFromdrpdownElement(astr_fieldName);
					str_validateData=normaldrpDown.getAttribute("title");
					break;
				case "date":				
					QAFExtendedWebElement dateElement=null;
					dateElement=(QAFExtendedWebElement)getWebElement (astr_fieldName,"input");
					str_attributeData=dateElement.getAttribute("ng-init");
					str_validateData= str_attributeData.substring(str_attributeData.indexOf("\'")+1, str_attributeData.length()-1);	
					break;
				case "attachment":
					Thread.sleep(500);
					QAFExtendedWebElement attachmentElement=null;
					attachmentElement=(QAFExtendedWebElement)getAttachmentTextWebElement(astr_fieldName);
					str_attributeData=attachmentElement.getAttribute("ng-init");
					str_validateData= str_attributeData.substring(str_attributeData.indexOf("\'")+1, str_attributeData.length()-1);					
					break;				
			}
			isSuccess=astr_data.equalsIgnoreCase(str_validateData);
			if(isSuccess)
			{
				System.out.println("Task field validation is success !");
				testResult=astr_data+ "-PASS";
			}				
			else
			{
				System.out.println("Task field validation is failed");	
				testResult=astr_data+ "-FAIL";
			}	
				
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testResult;
	}
	
	//##############################   Field group related methods- Starts ! ############################
	
	/* Method Author: M.S.SUMESH 
	 * Created date: 25th Sep 2020
	 * Purpose : This method performs task field update from field group level */
	public void performFieldgrpUpdate(int aint_fieldGrp_row,WebElement element,String astr_fieldName, String astr_dataType,String astr_data) throws InterruptedException
	{
		Boolean isSuccess=false;
		try 
		{
			if(astr_dataType.equals("singleline")|| astr_dataType.equals("number"))
			{
				astr_dataType="input";
				//CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement) element);
			}	
			else if(astr_dataType.equals("multiline"))
			{
				astr_dataType="textarea";
				//CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement)element);
			}
			switch (astr_dataType.trim().toLowerCase()) 
			{
				case "input":case "number":				
				try 
				{
					element.clear();
					CommonBean.lbase_baseClass.writeText((QAFExtendedWebElement)element,astr_data);								
					break;
				} 
				catch (NoSuchElementException  e) 
				{			
					JavascriptExecutor js = (JavascriptExecutor) driver;
					Object searchTextbar = js.executeScript("return document.getElementById('lst-ib')");
					((WebElement) searchTextbar).sendKeys(astr_data);
				}
							
				case "textarea":
				try
				{	
					CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement)element);
					CommonBean.lbase_baseClass.doubleClick((QAFExtendedWebElement)element);	
				} 
				catch (Exception e) 
				{					
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("scroll(250, 0)");
				}
				Thread.sleep(1000);
				getMultilineElement().clear();
				CommonBean.lbase_baseClass.writeText((QAFExtendedWebElement)getMultilineElement(),astr_data);	
				CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement)getMultilineConfirm("Ok"));				
				break;

				case "dropdown-singleselect":
				case "dropdown-multiselect":				
					String drp[]=astr_dataType.split("-");
					String lstr_selectType="";					
					
					if (drp[1].equalsIgnoreCase("singleSelect")) 
						lstr_selectType="singleSelect";
					else if(drp[1].equalsIgnoreCase("multiSelect")) 
						lstr_selectType="multiSelect";
					else 
						System.out.println("wrong condtion for dropdown");					
					CommonBean.lbase_baseClass.selectFromDropdown((QAFExtendedWebElement)element, astr_data, lstr_selectType,aint_fieldGrp_row);
					
					break;
				case "date":					
					// Method to select Date from picker - Starts
					CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement)element);
					Thread.sleep(700);
					CommonBean.lbase_baseClass.selectDatefromPicker(astr_data);
					break;
							
				case "attachment":
					CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement)element);
					Thread.sleep(700); //1000

					CommonBean.lbase_baseClass.fileUpload("",astr_data);
					Thread.sleep(1000);
					break;	
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/* Method Author: M.S.SUMESH 
	 * Created date: 28th Sep 2020
	 * Purpose : This method performs task field update from field group level */
	public Boolean performFieldgrpDeleteOrHistory(int aint_fieldGrp_row,String astr_Action,String astr_FieldGrpName) throws InterruptedException
	{
		WebElement element=null;
		Boolean isSuccess=false;
		try 
		{
			System.out.println("Method Name: performFieldgrpDeleteOrHistory is called");
			int colNum=0;
			if(astr_Action.equalsIgnoreCase("delete"))
				colNum=1;
			else
				colNum=2;
			String columnFG="//div//label[contains(text(),'" + astr_FieldGrpName + "')]/following::div[@class='ui-grid-canvas'][1]//div[@class='ui-grid-row ng-scope'][" + aint_fieldGrp_row + "]//div[@ui-grid-cell]["+ colNum + "]";
			if(DeviceUtils.getQAFDriver().findElements(By.xpath(columnFG)).size()!=0)
				element=DeviceUtils.getQAFDriver().findElement(By.xpath(columnFG));
			else
			{
				System.out.println("No such field group row exists");
				isSuccess=false;
				astr_Action="invalid";
			}
			switch(astr_Action.toLowerCase())
			{
				case "delete":
					if(element.isDisplayed())
					{
						element.click();
						Thread.sleep(1000);
						BaseClass.getScreenshot("Check confirmation before Deleting field group record");
						DeviceUtils.getQAFDriver().findElement(By.xpath("//button[@data-ng-click='deleteFldGrpRow()']")).click();
						Thread.sleep(1000);
						BaseClass.getScreenshot("Check confirmation after Deleting field group record");
						isSuccess=true;
					}	
					break;
				case "history":
					if(element.isDisplayed())
					{
						element.click();
						Thread.sleep(1000);						
						isSuccess=true;
					}
					break;
			}			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	
	/* Method Author: M.S.SUMESH 
	 * Created date: 5th Oct 2020
	 * Purpose : This method performs task field validate from field group level */
	public void performFieldgrpValidate(int aint_fieldGrp_row,WebElement element,String astr_fieldName, String astr_dataType,String astr_data) throws InterruptedException
	{
		String str_validateData = null,str_attributeData="";
		String testResult=null;
		Boolean isSuccess=false;
		try 
		{
			if(astr_dataType.equals("singleline")|| astr_dataType.equals("number"))
			{
				astr_dataType="input";
			}	
			else if(astr_dataType.equals("multiline"))
			{
				astr_dataType="textarea";
			}
			switch (astr_dataType.trim().toLowerCase()) 
			{
				case "input":					
					str_attributeData=CommonBean.lbase_baseClass.getHiddenText(element) ;
					str_attributeData=element.getText();
					//str_attributeData=getWebElement(astr_fieldName, astr_dataType).getAttribute("ng-init");
					str_validateData= str_attributeData.substring(str_attributeData.indexOf("\'")+1, str_attributeData.length()-1);
					str_validateData=str_validateData.replaceAll(",", "");
					break;					
				case "password":
					str_attributeData=getPasswordWebElement(astr_fieldName, astr_dataType).getAttribute("ng-init");
					str_validateData= str_attributeData.substring(str_attributeData.indexOf("\'")+1, str_attributeData.length()-1);
					break;					
				case "textarea":
					str_attributeData=getWebElement(astr_fieldName, astr_dataType).getAttribute("ng-init");
					str_validateData= str_attributeData.substring(str_attributeData.indexOf("\'")+1, str_attributeData.length()-1);
					break;
				case "dropdown-singleselect": case "dropdown-multiselect":						
					QAFExtendedWebElement drpDownElement=null;							
					drpDownElement=(QAFExtendedWebElement) getTextFromdrpdownElement(astr_fieldName);			
					str_validateData=drpDownElement.getAttribute("title");
					break;				
				case "dropdown":					
					QAFExtendedWebElement normaldrpDown=null;							
					normaldrpDown= (QAFExtendedWebElement) getTextFromdrpdownElement(astr_fieldName);
					str_validateData=normaldrpDown.getAttribute("title");
					break;
				case "date":				
					QAFExtendedWebElement dateElement=null;
					dateElement=(QAFExtendedWebElement)getWebElement (astr_fieldName,"input");
					str_attributeData=dateElement.getAttribute("ng-init");
					str_validateData= str_attributeData.substring(str_attributeData.indexOf("\'")+1, str_attributeData.length()-1);	
					break;
				case "attachment":
					Thread.sleep(500);
					QAFExtendedWebElement attachmentElement=null;
					attachmentElement=(QAFExtendedWebElement)getAttachmentTextWebElement(astr_fieldName);
					str_attributeData=attachmentElement.getAttribute("ng-init");
					str_validateData= str_attributeData.substring(str_attributeData.indexOf("\'")+1, str_attributeData.length()-1);					
					break;		
			}
			
			isSuccess=astr_data.equalsIgnoreCase(str_validateData);
			if(isSuccess)
			{
				System.out.println("Task field validation is success !");
				testResult=astr_data+ "-PASS";
			}				
			else
			{
				System.out.println("Task field validation is failed");	
				testResult=astr_data+ "-FAIL";
			}	
				
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//##############################   Field group related methods-Ends !   #############################
	/* Method Author: M.S.SUMESH 
	 * Created date: 11th Sep 2020
	 * Purpose : This method performs click action on attachment button */	
	public void click_Attachment(String astr_process) throws InterruptedException
	{		
		try 
		{			
			QAFExtendedWebElement process=DeviceUtils.getQAFDriver().findElementByXPath("//a[contains(text(),'"+ astr_process + "')]");
			try 
			{
				CommonBean.lbase_baseClass.actionClick(process);
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				CommonBean.lbase_baseClass.javascriptClick(process);
				e.printStackTrace();
			}
			Thread.sleep(500);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

	/* Method Author: M.S.SUMESH 
	 * Created date: 17th Sep 2020
	 * Purpose : This method performs attachment functions*/
	public void processAttachment(String astr_fieldName, String astr_process,String astr_data) throws InterruptedException
	{
		try 
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;					
			js.executeScript("window.scrollBy(0,100)", "");
			
			CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement) getAttachmentWebElement(astr_fieldName));
			Thread.sleep(600); 			

			switch(astr_process.trim().toLowerCase())
			{
				case "download":
					if(DeviceUtils.getQAFDriver().findElement(By.xpath(" //li/a[contains(@onclick,'Download')]")).isDisplayed())		   
						click_Attachment("Download");
					break;
				case "upload":
					if(DeviceUtils.getQAFDriver().findElements(By.xpath(" //li/a[contains(@onclick,'remove')]")).size()!=0)
					{
						click_Attachment("Remove");
						CommonBean.lbase_baseClass.clickButton((QAFExtendedWebElement) getAttachmentWebElement(astr_fieldName));
					}			
					Thread.sleep(500);
					click_Attachment("Upload");
					Thread.sleep(500);
					CommonBean.lbase_baseClass.loadFile(astr_fieldName,astr_data);
					Thread.sleep(600);
					break;

				case "remove":
					if(DeviceUtils.getQAFDriver().findElement(By.xpath(" //li/a[contains(@onclick,'Remove')]")).isDisplayed())		   
						click_Attachment("Remove");
					break;
			}			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public boolean checkFieldGrpRowExists (String astr_FieldGrpName,int aint_rowID)
	{
		Boolean isFieldGrpRowExists=false;
		try
		{
			if(DeviceUtils.getQAFDriver().findElements(By.xpath("//div//label[contains(text(),'" + astr_FieldGrpName + "')]/following::div[@class='ui-grid-canvas'][1]//div[@class='ui-grid-row ng-scope'][" + aint_rowID + "]")).size()>0)
				isFieldGrpRowExists=true;
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isFieldGrpRowExists;
	}
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

}
