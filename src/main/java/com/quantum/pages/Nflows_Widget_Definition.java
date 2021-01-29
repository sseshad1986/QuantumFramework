package com.quantum.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import com.quantum.helper.ExtentManager;


@SuppressWarnings("static-access")
public class Nflows_Widget_Definition extends WebDriverBaseTestPage<WebDriverTestPage>
{	
	// WebDriver driver;
	public WebDriverTestBase iWebDriverTestBase_driver;
	
	@FindBy (locator = "nflows.widget.landing.searchbx")
	private QAFExtendedWebElement searchbx;
	
	@FindBy (locator = "nflows.widget.landing.newWidgetbtn")
	private QAFExtendedWebElement newWidgetbtn;
	
	@FindBy (locator = "nflows.widget.landing.EditWidgetbtn")
	private QAFExtendedWebElement EditWidgetbtn;
	
	@FindBy (locator = "nflows.widget.newWidget.Widgetname")
	private QAFExtendedWebElement Widgetname;
	
	@FindBy (locator = "nflows.widget.newWidget.Widgetfor")
	private QAFExtendedWebElement Widgetfor;
	
	@FindBy (locator = "nflows.widget.newWidget.Widgetbasedon")
	private QAFExtendedWebElement Widgetbasedon;
	
	@FindBy (locator = "nflows.widget.newWidget.Description")
	private QAFExtendedWebElement Description;
	
	@FindBy (locator = "nflows.widget.newWidget.searchBox")
	private QAFExtendedWebElement searchWidgetCol;
	
	@FindBy (locator = "nflows.widget.newWidget.newRule")
	private QAFExtendedWebElement newRule;
		
	@FindBy (locator = "nflows.widget.newWidget.showRule")
	private QAFExtendedWebElement showRule;
	
	@FindBy (locator = "nflows.widget.newWidget.searchRule")
	private QAFExtendedWebElement searchRule;
		
	@FindBy (locator = "nflows.widget.newWidget.ruleDefinition")
	private QAFExtendedWebElement ruleDefinition;
	
	@FindBy (locator = "nflows.widget.newWidget.saveRule")
	private QAFExtendedWebElement saveRule;	
	
	@FindBy (locator = "nflows.widget.newWidget.validate")
	private QAFExtendedWebElement validate;	
	
	@FindBy (locator = "nflows.widget.newWidget.cancelRule")
	private QAFExtendedWebElement cancelRule;
	
	// Locator for Rule engine for Widgets

	@FindBy(locator = "nflows.entity.CreateRule.singleline")
	private QAFExtendedWebElement searchSingleline;

	@FindBy(locator = "nflows.entity.CreateRule.multiline")
	private QAFExtendedWebElement searchMultiline;

	@FindBy(locator = "nflows.entity.CreateRule.number")
	private QAFExtendedWebElement searchNumber;

	@FindBy(locator = "nflows.entity.CreateRule.date")
	private QAFExtendedWebElement clickExternalDate;

	@FindBy(locator = "nflows.entity.CreateRule.clickDatepicker")
	private QAFExtendedWebElement clickDatepicker;

	@FindBy(locator = "nflows.entity.CreateRule.selectDatefromDatepicker")
	private QAFExtendedWebElement selectDatefromDatepicker;

	@FindBy(locator = "nflows.entity.CreateRule.selectMonthfromDatepicker")
	private QAFExtendedWebElement selectMonthfromDatepicker;

	@FindBy(locator = "nflows.entity.CreateRule.selectYearfromDatepicker")
	private QAFExtendedWebElement selectYearfromDatepicker;

	@FindBy(locator = "nflows.entity.CreateRule.dropdown")
	private QAFExtendedWebElement searchDropdown;

	@FindBy(locator = "nflows.entity.CreateRule.populatedropdown")
	private QAFExtendedWebElement searchPopulateDropdown;

	@FindBy(locator = "nflows.entity.CreateRule.valueTextbx")
	private QAFExtendedWebElement singlevalueTextbx;

	@FindBy(locator = "nflows.entity.CreateRule.multivalueTextbx")
	private QAFExtendedWebElement multivalueTextbx;

	@FindBy(locator = "nflows.entity.CreateRule.okBtnValue")
	private QAFExtendedWebElement okBtnValue;

	@FindBy(locator = "nflows.entity.CreateRule.closeBtnValue")
	private QAFExtendedWebElement closeBtnValue;

	@FindBy(locator = "nflows.entity.CreateRule.dropdown")
	private QAFExtendedWebElement clickExternalDropdown;

	@FindBy(locator = "nflows.entity.CreateRule.chooseSelectExternalDropdown")
	private QAFExtendedWebElement chooseSelectExternalDropdown;

	@FindBy(locator = "nflows.entity.CreateRule.typeExternalsearchDropdwn")
	private QAFExtendedWebElement typeExternalsearchDropdwn;

	@FindBy(locator = "nflows.entity.CreateRule.SelectTypeexternalDropdwn")
	private QAFExtendedWebElement SelectTypeexternalDropdwn;

	@FindBy(locator = "nflows.entity.CreateRule.popoverExternalDropdwn")
	private QAFExtendedWebElement popoverExternalDropdwn;
	
	@FindBy(locator = "nflows.entity.functions.popTextbx")
	private QAFExtendedWebElement popTextbx;

	@FindBy(locator = "nflows.entity.functions.popOkBtn")
	private QAFExtendedWebElement popOkBtn;

	@FindBy(locator = "nflows.entity.functions.popCancelBtn")
	private QAFExtendedWebElement popCancelBtn;

	
// ------------------------------         Locators Ends here !          ----------------------------------------------------	

	public QAFExtendedWebElement getsearchbx() {
		return searchbx;
	}
	
	public QAFExtendedWebElement getnewWidgetbtn() {
		return newWidgetbtn;
	}
	
	public QAFExtendedWebElement getEditWidgetbtn() {
		return EditWidgetbtn;
	}
	
	public QAFExtendedWebElement getWidgetname(String widgetName)
	{
		String loc = String.format(pageProps.getString("nflows.widget.landing.EditWidgetbtn"), widgetName);
		return new QAFExtendedWebElement(loc);
	}
		
	public QAFExtendedWebElement getWidgetfor() {
		return Widgetfor;
	}
	
	public QAFExtendedWebElement getWidgetbasedon() {
		return Widgetbasedon;
	}
	
	public QAFExtendedWebElement getDescription() {
		return Description;
	}
	
	public QAFExtendedWebElement getsearchWidgetCol() {
		return searchWidgetCol;
	}
	
	
	public QAFExtendedWebElement getnewRule() {
		return newRule;
	}
	
	public QAFExtendedWebElement getshowRule() {
		return showRule;
	}
	
	public QAFExtendedWebElement getRuleSearch() {
		return searchRule;
	}
	
	public QAFExtendedWebElement getruleDefinition() {
		return ruleDefinition;
	}
	
	public QAFExtendedWebElement getsaveRule() {
		return saveRule;
	}
	
	public QAFExtendedWebElement getvalidate() {
		return validate;
	}
	public QAFExtendedWebElement getcancelRule() {
		return cancelRule;
	}
	
	// Getters for searchRuleFields

		public QAFExtendedWebElement getSearchSingleline() {
			return searchSingleline;
		}

		public QAFExtendedWebElement getSearchMultiline() {
			return searchMultiline;
		}

		public QAFExtendedWebElement getSearchNumber() {
			return searchNumber;
		}

		public QAFExtendedWebElement clickExternalDate() {
			return clickExternalDate;
		}

		public QAFExtendedWebElement getClickDatepicker() {
			return clickDatepicker;
		}

		public QAFExtendedWebElement getselectDatefromDatepicker() {
			return selectDatefromDatepicker;
		}

		public QAFExtendedWebElement getselectMonthfromDatepicker() {
			return selectMonthfromDatepicker;
		}

		public QAFExtendedWebElement getselectYearfromDatepicker() {
			return selectYearfromDatepicker;
		}

		// clickDatepicker
		public QAFExtendedWebElement getSearchDropdown() {
			return searchDropdown;
		}

		public QAFExtendedWebElement getSearchPopulateDropdown() {
			return searchPopulateDropdown;
		}

		public QAFExtendedWebElement getvalueTextbx() {
			return singlevalueTextbx;
		}

		public QAFExtendedWebElement getmultivalueTextbx() {
			return multivalueTextbx;
		}

		public QAFExtendedWebElement getokBtnValue() {
			return okBtnValue;
		}

		public QAFExtendedWebElement getcloseBtnValue() {
			return closeBtnValue;
		}

		public QAFExtendedWebElement getclickExternalDropdown() {
			return clickExternalDropdown;
		}

		public QAFExtendedWebElement getchooseSelectExternalDropdown() {
			return chooseSelectExternalDropdown;
		}

		public QAFExtendedWebElement gettypeExternalsearchDropdwn() {
			return typeExternalsearchDropdwn;
		}

		public QAFExtendedWebElement getSelectTypeexternalDropdwn() {
			return SelectTypeexternalDropdwn;
		}

		public QAFExtendedWebElement getpopoverExternalDropdwn() {
			return popoverExternalDropdwn;
		}
		
		public QAFExtendedWebElement getpopTextbx() {
				return popTextbx;
			}

		public QAFExtendedWebElement getpopOkBtn() {
				return popOkBtn;
			}

		public QAFExtendedWebElement getpopCancelBtn() {
				return popCancelBtn;
			}
	
		
	// ------------------------------         Getter method Ends here ! 
	@Override
	protected void openPage(PageLocator locator, Object... args) 
	{
		// TODO Auto-generated method stub		
	}
		
	public void editWidgetDefinition(String astr_widgetName) throws InterruptedException, IOException 
	{	
		CommonBean.lbase_baseClass.writeText(getsearchbx(), astr_widgetName);
		getsearchbx().sendKeys(Keys.ENTER);
		CommonBean.lbase_baseClass.doubleClick(getWidgetname(astr_widgetName));		
		Thread.sleep(4000);			
	}
	
	public void addFieldToWidget(String astr_addWidgetflds) throws InterruptedException, IOException 
	{	
		CommonBean.lbase_baseClass.writeText(getsearchWidgetCol(), astr_addWidgetflds);
		Thread.sleep(1500);

		//CommonBean.lbase_baseClass.selectExactChildIgnorecase(astr_addWidgetflds.toLowerCase());
		new WebDriverTestBase().getDriver().findElement(By.xpath("//span[text()='Employee Signature']")).click();
		Thread.sleep(1500);
		
		Actions action = new Actions(driver);
		
		//To get source locator
		WebElement sourceLocator = new WebDriverTestBase().getDriver().findElement(By.xpath("//span[text()='Employee Signature']"));
        //To get target locator
		WebElement targetLocator = new WebDriverTestBase().getDriver().findElement(By.xpath("//ul[@class='widget-column']"));

		//action.dragAndDrop(sourceLocator, targetLocator).build().perform();	
		
		// Click & Hold drag Webelement
		action.clickAndHold(sourceLocator).build().perform();
		 
		// Move to drop Webelement
		action.moveToElement(targetLocator).build().perform();
		 
		// Release drag webelement into drop webelement
		action.release(targetLocator).build().perform();		
		
		
	}
	
	public void createWidgetRule(String astr_RuleDefinition) throws InterruptedException, IOException 
	{	
		CommonBean.lbase_baseClass.clickButton(getnewRule());
		CommonBean.lbase_baseClass.clickButton(getRuleSearch());
		search_rule_parameter(astr_RuleDefinition);
		CommonBean.lbase_baseClass.clickButton(getsaveRule());
	}
	
	public void search_rule_parameter(String astr_RuleDefinition) throws InterruptedException {
		try {
			System.out.println(astr_RuleDefinition);
			String rulearray[] = astr_RuleDefinition.split(";");

			for (String rule : rulearray)
			{
				if (rule.contains("~")) 
				{
					String externalFields[] = rule.split("~");
					CommonBean.lbase_baseClass.writeText(getRuleSearch(), externalFields[0].toLowerCase());
					Thread.sleep(1000);
					
					if(!CommonBean.lbase_baseClass.findExactIgnorecase(externalFields[0]))
					{
						System.out.println("element not exists !");
					}
					else
					{
						switch (externalFields[0].toLowerCase()) 
						{
						case "singleline":
						case "number":
							System.out.println("Rule : " + rule);
							CommonBean.lbase_baseClass.selectExactChildIgnorecase(externalFields[0].toLowerCase());
							CommonBean.lbase_baseClass.writeText(getvalueTextbx(), externalFields[1]);

							getokBtnValue().waitForVisible(2500);
							getokBtnValue().click();
							break;
						case "multiline":
							System.out.println("Rule : " + rule);
							CommonBean.lbase_baseClass.selectExactChildIgnorecase(externalFields[0].toLowerCase());
							CommonBean.lbase_baseClass.writeText(getmultivalueTextbx(), externalFields[1]);
							CommonBean.lbase_baseClass.clickButton(getokBtnValue());
							break;
						case "date":
							System.out.println("Rule : " + rule);
							String date[] = externalFields[1].split("/");
							CommonBean.lbase_baseClass.selectDatePicker();
							Thread.sleep(700);
							CommonBean.lbase_baseClass.clickButton(getClickDatepicker());
							Thread.sleep(500);
							CommonBean.lbase_baseClass.clickButton(getselectMonthfromDatepicker());
							Thread.sleep(500);
							CommonBean.lbase_baseClass.selectByValue(getselectMonthfromDatepicker(), date[1]);
							Thread.sleep(500);
							CommonBean.lbase_baseClass.clickButton(getselectYearfromDatepicker());
							Thread.sleep(500);
							CommonBean.lbase_baseClass.selectByValue(getselectYearfromDatepicker(), date[2]);
							Thread.sleep(1000);

							while (date[0].length() > 1 && date[0].indexOf("0") == 0)
								date[0] = date[0].substring(1);
							CommonBean.lbase_baseClass.selectDate(date[0]);
							Thread.sleep(1000);
							CommonBean.lbase_baseClass.clickButton(getokBtnValue());
							break;

						case "dropdown":
							System.out.println("Rule : " + rule);
							CommonBean.lbase_baseClass.clickButton(getclickExternalDropdown());
							Thread.sleep(1000);

							CommonBean.lbase_baseClass.clickButton(getchooseSelectExternalDropdown());
										
							String dropdownvalues[] = externalFields[1].split(",");
							System.out.println("Length: " + dropdownvalues.length);
												
							for (int j = 0; j <= dropdownvalues.length - 1; j++) 
							{	
								CommonBean.lbase_baseClass.writeText(gettypeExternalsearchDropdwn(), dropdownvalues[j]);
								CommonBean.lbase_baseClass.clickButton(getSelectTypeexternalDropdwn());
								Thread.sleep(500);
								gettypeExternalsearchDropdwn().clear();
							}
							CommonBean.lbase_baseClass.clickButton(getruleDefinition());
							Thread.sleep(500);
							CommonBean.lbase_baseClass.clickButton(getokBtnValue());
							Thread.sleep(1000);
							break;
						case "populate dropdown":
							System.out.println("Rule : " + rule);
							CommonBean.lbase_baseClass.selectExactChildIgnorecase(rule);
							break;

						case "year":case "month":case "unique":case "length":
						case "is null":case "is not null":case "value changed count":case "max":
						case "min":	case "has changed by percentage":case "sum across records":case "count":
						case "percentage":case "average":case "difference in months":case "difference in years":
						case "max across records":case "min across records":case "first value":case "average across records":
						case "changed":
							System.out.println("Rule function :" + externalFields[0]);
							CommonBean.lbase_baseClass.selectExactChildIgnorecase(externalFields[0].toLowerCase());
							getRuleSearch().waitForVisible(2000);
							getRuleSearch().clear();

							System.out.println("Rule value :" + externalFields[1]);

							String functions[] = externalFields[1].split(",");
							System.out.println("Length: " + functions.length);

							if (functions.length == 1) {
								CommonBean.lbase_baseClass.writeText(getRuleSearch(), functions[0].toLowerCase());
								CommonBean.lbase_baseClass.selectExactChildIgnorecase(functions[0].toLowerCase());
								getRuleSearch().waitForVisible(2000);
								getRuleSearch().clear();

								System.out.println("Function values is : " + functions[0]);
							} else {
								for (int j = 0; j <= functions.length - 1; j++) {
									System.out.println("Function values are : " + functions[j]);

									CommonBean.lbase_baseClass.writeText(getRuleSearch(), functions[j].toLowerCase());
									CommonBean.lbase_baseClass.selectExactChildIgnorecase(functions[j].toLowerCase());
									getRuleSearch().waitForVisible(2000);
									getRuleSearch().clear();
								}
							}
							break;

						case "substring":case "left":case "right":case "previous value":
						case "round":case "round Down":case "roundup":	case "concatenate":
							System.out.println("Rule: " + externalFields[0]);
							CommonBean.lbase_baseClass.selectExactChildIgnorecase(externalFields[0].toLowerCase());
							
							String subfunctions[] = externalFields[1].split(",");
							System.out.println("Length: " + subfunctions.length);
							
							CommonBean.lbase_baseClass.writeText(getpopTextbx(), subfunctions[0]);

							getpopOkBtn().waitForVisible(1500);
							getpopOkBtn().click();
							
							for (int j = 1; j <= subfunctions.length - 1; j++) 
							{	
								getRuleSearch().waitForVisible(2000);
								getRuleSearch().clear();
								search_rule_parameter(subfunctions[j]);
							}						

							CommonBean.lbase_baseClass.clickButton(getruleDefinition());		
						}
					}					
				} 
				else if (rule.contains(".")) 
				{
					String externalFields[] = rule.split("\\.");
					System.out.println("Field group Name : " + externalFields[0] + "Field Name : " + externalFields[1]);
					CommonBean.lbase_baseClass.writeText(getRuleSearch(), externalFields[1].toLowerCase());

					CommonBean.lbase_baseClass.selectFieldGroupdata(externalFields[0].trim(), externalFields[1].trim());
				} 
				else 
				{
					if(CommonBean.lbase_baseClass.findExactIgnorecase(rule))
					{
						CommonBean.lbase_baseClass.writeText(getRuleSearch(), rule.toLowerCase());
						CommonBean.lbase_baseClass.selectExactChildIgnorecase(rule.toLowerCase());
					}
					else
					{						
						System.out.println("element not exists !");
					}
										
				}
				getRuleSearch().waitForVisible(2000);
				getRuleSearch().clear();

			}
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
