package com.quantum.pages;



import java.awt.Robot;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.helper.BaseClass;
import com.quantum.utils.DeviceUtils;

import io.appium.java_client.android.nativekey.KeyEvent;


public class Nflows_RuleEngineDefinition_page extends WebDriverBaseTestPage<WebDriverTestPage> {

	/**
	 * @author <Sumesh.M.S> Created On - <20th Sep 2019> Responsibility- <This class
	 *         is used for Rule Engine Definition> Modified by <name> on <date> for
	 *         Issue <Issue number (s)> for Integration <integration number>
	 */

	// Locators for Rule Engine
	@FindBy(locator = "nflows.entity.edit.newRuleBtn")
	private QAFExtendedWebElement newRuleBtn;

	@FindBy(locator = "nflows.entity.CreateRule.RuleName")
	private QAFExtendedWebElement RuleName;

	@FindBy(locator = "nflows.entity.CreateRule.RuleType")
	private QAFExtendedWebElement RuleType;

	@FindBy(locator = "nflows.entity.CreateRule.RuleTypeValidation")
	private QAFExtendedWebElement RuleTypeValidation;

	@FindBy(locator = "nflows.entity.CreateRule.RuleTypeEnrichment")
	private QAFExtendedWebElement RuleTypeEnrichment;

	@FindBy(locator = "nflows.entity.CreateRule.RuleTypeFilter")
	private QAFExtendedWebElement RuleTypeFilter;

	@FindBy(locator = "nflows.entity.CreateRule.RuleExecutionType")
	private QAFExtendedWebElement RuleExecutionType;

	@FindBy(locator = "nflows.entity.CreateRule.RuleExecutionTypeOnNew")
	private QAFExtendedWebElement RuleExecutionTypeOnNew;

	@FindBy(locator = "nflows.entity.CreateRule.RuleExecutionTypeOnUpdate")
	private QAFExtendedWebElement RuleExecutionTypeOnUpdate;
	
	@FindBy(locator = "nflows.entity.CreateRule.RuleExecutionlabel")
	private QAFExtendedWebElement RuleExecutionTypeDrp;	

	@FindBy(locator = "nflows.entity.CreateRule.RuleDesc")
	private QAFExtendedWebElement RuleDesc;

	@FindBy(locator = "nflows.entity.CreateRule.RuleDesclabel")
	private QAFExtendedWebElement RuleDesclabel;

	@FindBy(locator = "nflows.entity.CreateRule.RuleSearch")
	private QAFExtendedWebElement RuleSearch;

	// Locators for Rule Search pane
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

	// Locators for Rule data validation part
	@FindBy(locator = "nflows.entity.CreateRule.RuleValidationFieldDrpdwn")
	private QAFExtendedWebElement RuleValidationFieldDrpdwn;

	@FindBy(locator = "nflows.entity.CreateRule.RuleValidationFieldDrpdwnSearchValue")
	private QAFExtendedWebElement RuleValidationFieldDrpdwnSearchValue;

	@FindBy(locator = "nflows.entity.CreateRule.RuleValidationFieldDrpdwnSelectValue")
	private QAFExtendedWebElement RuleValidationFieldDrpdwnSelectValue;

	@FindBy(locator = "nflows.entity.CreateRule.RuleValidationMessageDrpdwn")
	private QAFExtendedWebElement RuleValidationMessageDrpdwn;

	@FindBy(locator = "nflows.entity.CreateRule.RuleValidationMessageDrpdwnSearchValue")
	private QAFExtendedWebElement RuleValidationMessageDrpdwnSearchValue;

	@FindBy(locator = "nflows.entity.CreateRule.RuleValidationMessageDrpdwnSelectValue")
	private QAFExtendedWebElement RuleValidationMessageDrpdwnSelectValue;

	// Locators for Rule Definition area
	@FindBy(locator = "nflows.entity.CreateRule.RuleDefinitionArea")
	private QAFExtendedWebElement RuleDefinitionArea;
		
	// Locators for Rule enrichment area
	@FindBy(locator = "nflows.entity.CreateRule.RuleEnrichmentArea")
	private QAFExtendedWebElement RuleEnrichmentArea;

	// Locators for Rule Filter area
	@FindBy(locator = "nflows.entity.CreateRule.RuleFilterArea")
	private QAFExtendedWebElement RuleFilterArea;

	@FindBy(locator = "nflows.entity.Rule.SaveRule")
	private QAFExtendedWebElement SaveRule;

	@FindBy(locator = "nflows.entity.Rule.CancelRule")
	private QAFExtendedWebElement CancelRule;

	@FindBy(locator = "nflows.entity.Rule.CancelYesRule")
	private QAFExtendedWebElement CancelYesRule;

	@FindBy(locator = "nflows.entity.Rule.CancelNoRule")
	private QAFExtendedWebElement CancelNoRule;

	@FindBy(locator = "nflows.entity.Rule.backButton")
	private QAFExtendedWebElement backButton;

	@FindBy(locator = "nflows.entity.ruleGrid.searchBx")
	private QAFExtendedWebElement searchRuleinGrid;
	
	// Locators for Rule enrichment area
	@FindBy(locator = "nflows.entity.ruleGroup.selectDrop")
	private QAFExtendedWebElement RuleGroupdrp;
	
	@FindBy(locator = "nflows.entity.ruleGroup.ruleGroup")
	private QAFExtendedWebElement RuleGroup;
	
	@FindBy(locator = "nflows.entity.functions.popTextbx")
	private QAFExtendedWebElement popTextbx;

	@FindBy(locator = "nflows.entity.functions.popOkBtn")
	private QAFExtendedWebElement popOkBtn;

	@FindBy(locator = "nflows.entity.functions.popCancelBtn")
	private QAFExtendedWebElement popCancelBtn;
	
	// Locators for Entity grouping rule
	@FindBy(locator = "nflows.entity.GroupingRule.fieldGrpDrpdwn")
	private QAFExtendedWebElement fieldGrpDrpdwn;
	
	@FindBy(locator = "nflows.entity.GroupingRule.rulePurposeDrpdwn")
	private QAFExtendedWebElement rulePurposeDrpdwn;
	
	// Locators for error message pop up
	@FindBy(locator = "nflows.entity.ruledef.popupBox")
	private QAFExtendedWebElement messagePopupBox;
	
	@FindBy(locator = "nflows.entity.ruledef.popupCloseBtn")
	private QAFExtendedWebElement messagePopCloseBtn;
	
	// Locators for error message pop up
	@FindBy(locator = "nflows.entity.ruledef.cancelPopUp")
	private QAFExtendedWebElement cancelPopUp;
	
	@FindBy(locator = "nflows.entity.ruledef.cancelYes")
	private QAFExtendedWebElement cancelYes;
	
	// Locators for rule search in grid	
	@FindBy(locator = "nflows.entity.ruledef.searchGrid")
	private QAFExtendedWebElement searchGrid;
	
	// ------------------------------ Locators Ends here !

	// Getter methods for Rule Engine

	public QAFExtendedWebElement getCreateNewRule() {
		return newRuleBtn;
	}

	public QAFExtendedWebElement getRuleName() {
		return RuleName;
	}

	public QAFExtendedWebElement getRuleType() {
		return RuleType;
	}

	public QAFExtendedWebElement getRuleTypeValidation() {
		return RuleTypeValidation;
	}

	public QAFExtendedWebElement getRuleTypeEnrichment() {
		return RuleTypeEnrichment;
	}

	public QAFExtendedWebElement getRuleTypeFilter() {
		return RuleTypeFilter;
	}

	public QAFExtendedWebElement getRuleDesc() {
		return RuleDesc;
	}

	public QAFExtendedWebElement getRuleDesclabel() {
		return RuleDesclabel;
	}

	public QAFExtendedWebElement getRuleSearch() {
		return RuleSearch;
	}

	public QAFExtendedWebElement getRuleExecutionType() {
		return RuleExecutionType;
	}

	public QAFExtendedWebElement getRuleExecutionTypeOnNew() {
		return RuleExecutionTypeOnNew;
	}

	public QAFExtendedWebElement getRuleExecutionTypeOnUpdate() {
		return RuleExecutionTypeOnUpdate;
	}
	
	public QAFExtendedWebElement getRuleExecutionTypeDrpe() {
		return RuleExecutionTypeDrp;
	}	
	
	public QAFExtendedWebElement getRuleDefinitionArea() {
		return RuleDefinitionArea;
	}
	
	public QAFExtendedWebElement getFieldGrpDrpdwn() {
		return fieldGrpDrpdwn;
	}
	
	public QAFExtendedWebElement getRulePurposeDrpdwn() {
		return rulePurposeDrpdwn;
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

	// Data Validation - Rule Field
	public QAFExtendedWebElement getRuleValidationFieldDrpdwn() {
		return RuleValidationFieldDrpdwn;
	}

	public QAFExtendedWebElement getRuleValidationFieldDrpdwnSearchValue() {
		return RuleValidationFieldDrpdwnSearchValue;
	}

	public QAFExtendedWebElement getRuleValidationFieldDrpdwnSelectValue() {
		return RuleValidationFieldDrpdwnSelectValue;
	}

	// Data Validation - Rule Message
	public QAFExtendedWebElement getRuleValidationMessageDrpdwn() {
		return RuleValidationMessageDrpdwn;
	}

	// Locator for Rule Enrichment area
	public QAFExtendedWebElement getClickRuleEnrichmentArea() {
		return RuleEnrichmentArea;
	}

	// Locator for Rule Enrichment area
	public QAFExtendedWebElement getClickRuleFilterArea() {
		return RuleFilterArea;
	}

	public QAFExtendedWebElement getRuleValidationMessageDrpdwnSearchValue() {
		return RuleValidationMessageDrpdwnSearchValue;
	}

	public QAFExtendedWebElement getRuleValidationMessageDrpdwnSelectValue() {
		return RuleValidationMessageDrpdwnSelectValue;
	}

	public QAFExtendedWebElement getSaveRule() {
		return SaveRule;
	}

	public QAFExtendedWebElement getCancelRule() {
		return CancelRule;
	}

	public QAFExtendedWebElement getCancelYesRule() {
		return CancelYesRule;
	}

	public QAFExtendedWebElement getCancelNoRule() {
		return CancelNoRule;
	}

	public QAFExtendedWebElement getBackBtn() {
		return backButton;
	}

	public QAFExtendedWebElement getsearchRuleinGrid() {
		return searchRuleinGrid;
	}
	
	public QAFExtendedWebElement getRuleGroupdrp() {
		return RuleGroupdrp;
	}
	
	public QAFExtendedWebElement getRuleGroup() {
		return RuleGroup;
	}
	
	// Getters for error message pop up
	public QAFExtendedWebElement getmessagePopupBox() {
		return messagePopupBox;
	}
	
	public QAFExtendedWebElement getmessagePopCloseBtn() {
		return messagePopCloseBtn;
	}
	
	// Getters for error message pop up
	public QAFExtendedWebElement getcancelPopUp() {
		return cancelPopUp;
	}
		
	public QAFExtendedWebElement getcancelYes() {
		return cancelYes;
	}
	
	public QAFExtendedWebElement getsearchGrids() {
		return searchGrid;
	}

	// ------------------------------ Getter method Ends here !

	// Actions to be done in rule engine definition
	public void clickNewRule() throws InterruptedException {
		try {
			CommonBean.lbase_baseClass.clickButton(getCreateNewRule());
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method Author : M.S.Sumesh 
	public String inputBasicRuleDetails(String astr_RuleName, String astr_RuleType, String astr_Execution,
			String astr_RuleDesc) throws InterruptedException 
	{
		String dynamicRuleName= null;
		try 
		{
			dynamicRuleName= astr_RuleName + "-"+ BaseClass.getRandomTimestampData();
			CommonBean.lbase_baseClass.writeText(getRuleName(), dynamicRuleName);
			CommonBean.lbase_baseClass.writeText(getRuleDesc(), astr_RuleDesc);

			// Select Rule Type
			if (astr_RuleType.equalsIgnoreCase("validation")) {
				CommonBean.lbase_baseClass.clickButton(getRuleType());
				CommonBean.lbase_baseClass.clickButton(getRuleTypeValidation());
				selectRuleExecutionType(astr_Execution);
			} else if (astr_RuleType.equalsIgnoreCase("enrichment")) {
				CommonBean.lbase_baseClass.clickButton(getRuleType());
				CommonBean.lbase_baseClass.clickButton(getRuleTypeEnrichment());
				selectRuleExecutionType(astr_Execution);
			} else if (astr_RuleType.equalsIgnoreCase("filter")) {
				CommonBean.lbase_baseClass.clickButton(getRuleType());
				CommonBean.lbase_baseClass.clickButton(getRuleTypeFilter());
			} else {
				System.out.println("This is an invalid Rule Type");
				Assert.assertFalse(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dynamicRuleName;
	}

	// Method Author : M.S.Sumesh 
	// Method to Select Rule Execution Type
	public void selectRuleExecutionType(String astrExecutionType) throws InterruptedException {

		if (astrExecutionType.equalsIgnoreCase("On New")) {
			CommonBean.lbase_baseClass.clickButton(getRuleExecutionType());
			CommonBean.lbase_baseClass.clickButton(getRuleExecutionTypeOnNew());
			CommonBean.lbase_baseClass.clickButton(getRuleExecutionTypeDrpe());
			
		} else if ((astrExecutionType.equalsIgnoreCase("On Update"))) {
			CommonBean.lbase_baseClass.clickButton(getRuleExecutionType());
			CommonBean.lbase_baseClass.clickButton(getRuleExecutionTypeOnUpdate());
			CommonBean.lbase_baseClass.clickButton(getRuleExecutionTypeDrpe());
		} else if ((astrExecutionType.equalsIgnoreCase("On New/On Update"))) {
			CommonBean.lbase_baseClass.clickButton(getRuleExecutionType());
			CommonBean.lbase_baseClass.clickButton(getRuleExecutionTypeOnNew());
			CommonBean.lbase_baseClass.clickButton(getRuleExecutionTypeOnUpdate());
			CommonBean.lbase_baseClass.clickButton(getRuleExecutionTypeDrpe());
		} else {
			System.out.println("Invalid rule Execution type");
		}
	}

	// This method is meant for creating Grouping rule
	public String createGroupingRule(String astr_RuleName, String astr_RuleDesc, String astr_RuleDefinition,String astr_rulePurpose,String astr_FieldGroup,String astr_RuleGroup)
			throws InterruptedException 
	{
		String lstr_dynamicRule = null;
		try {
			String lstr_randomData = BaseClass.getRandomTimestampData();
			System.out.println(astr_RuleName + lstr_randomData);
			lstr_dynamicRule = astr_RuleName + lstr_randomData;
			CommonBean.lbase_baseClass.writeText(getRuleName(), lstr_dynamicRule);
			CommonBean.lbase_baseClass.writeText(getRuleDesc(), astr_RuleDesc);

			// Selecting RulePurpose value from Dropdown
			CommonBean.lbase_baseClass.clickButton(getRulePurposeDrpdwn());
			CommonBean.lbase_baseClass.selectPartialText(astr_rulePurpose);
			
			// Selecting FieldGroup value from Dropdown
			CommonBean.lbase_baseClass.clickButton(getFieldGrpDrpdwn());
			CommonBean.lbase_baseClass.selectPartialText(astr_FieldGroup);
			
			CommonBean.lbase_baseClass.clickButton(getRuleSearch());
			search_rule_parameter(astr_RuleDefinition);						
			// Check Rule Group is present or not
			if(astr_RuleGroup!=null)
			{
				input_RuleGroup(astr_RuleGroup);			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstr_dynamicRule;
	}

	// Method Author : M.S.Sumesh 
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
							CommonBean.lbase_baseClass.selectExactIgnorecase(externalFields[0].toLowerCase());
							CommonBean.lbase_baseClass.writeText(getvalueTextbx(), externalFields[1]);

							getokBtnValue().waitForVisible(2500);
							getokBtnValue().click();
							break;
						case "multiline":
							System.out.println("Rule : " + rule);
							CommonBean.lbase_baseClass.selectExactIgnorecase(externalFields[0].toLowerCase());
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
								Thread.sleep(700);
								if(getSelectTypeexternalDropdwn().isPresent())
									CommonBean.lbase_baseClass.clickButton(getSelectTypeexternalDropdwn());
								else
								{
									gettypeExternalsearchDropdwn().clear();
									Thread.sleep(700);
									CommonBean.lbase_baseClass.clickButton(getSelectTypeexternalDropdwn());
								}
								Thread.sleep(500);
								gettypeExternalsearchDropdwn().clear();
							}
							CommonBean.lbase_baseClass.clickButton(getRuleDesclabel());
							Thread.sleep(500);
							CommonBean.lbase_baseClass.clickButton(getokBtnValue());
							Thread.sleep(1000);
							break;
						case "populate dropdown":
							System.out.println("Rule : " + rule);
							CommonBean.lbase_baseClass.selectExactIgnorecase(rule);
							break;

						case "year":case "month":case "unique":case "length":
						case "is null":case "is not null":case "value changed count":case "max":
						case "min":	case "has changed by percentage":case "sum across records":case "count":
						case "percentage":case "average":case "difference in months":case "difference in years":
						case "max across records":case "min across records":case "first value":case "average across records":
						case "changed":
							System.out.println("Rule function :" + externalFields[0]);
							CommonBean.lbase_baseClass.selectExactIgnorecase(externalFields[0].toLowerCase());
							getRuleSearch().waitForVisible(2000);
							getRuleSearch().clear();

							System.out.println("Rule value :" + externalFields[1]);

							String functions[] = externalFields[1].split(",");
							System.out.println("Length: " + functions.length);

							if (functions.length == 1) {
								CommonBean.lbase_baseClass.writeText(getRuleSearch(), functions[0].toLowerCase());
								CommonBean.lbase_baseClass.selectExactIgnorecase(functions[0].toLowerCase());
								getRuleSearch().waitForVisible(2000);
								getRuleSearch().clear();

								System.out.println("Function values is : " + functions[0]);
							} else {
								for (int j = 0; j <= functions.length - 1; j++) {
									System.out.println("Function values are : " + functions[j]);

									CommonBean.lbase_baseClass.writeText(getRuleSearch(), functions[j].toLowerCase());
									CommonBean.lbase_baseClass.selectExactIgnorecase(functions[j].toLowerCase());
									getRuleSearch().waitForVisible(2000);
									getRuleSearch().clear();
								}
							}
							break;

						case "substring":case "left":case "right":case "previous value":
						case "round":case "round Down":case "roundup":	case "concatenate":
							System.out.println("Rule: " + externalFields[0]);
							CommonBean.lbase_baseClass.selectExactIgnorecase(externalFields[0].toLowerCase());
							
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
							CommonBean.lbase_baseClass.clickButton(getRuleDefinitionArea());
							
							/*Robot robot=new Robot();
							
							for(int k=0;k<=10;k++)
							{
								robot.keyPress(java.awt.event.KeyEvent.VK_RIGHT);
								robot.keyRelease(java.awt.event.KeyEvent.VK_RIGHT);
							}*/
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
						CommonBean.lbase_baseClass.selectExactIgnorecase(rule.toLowerCase());
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

	// Method Author : M.S.Sumesh 
	public void input_RuleGroup(String astr_RuleGroup) throws InterruptedException 
	{
		String ruleGroup[] = astr_RuleGroup.split(",");
		for(int i=0;i<ruleGroup.length;i++)
		{
			String splitRule[] = ruleGroup[i].split("\\|");
			if(splitRule[0].toLowerCase().contains("and"))
			{
				CommonBean.lbase_baseClass.clickButton(getRuleGroup());					
				QAFExtendedWebElement ruleDrp=new WebDriverTestBase().getDriver()
												.findElement(By.xpath("//select[@id='fld_" + i + "']"));
				CommonBean.lbase_baseClass.selectByValue(ruleDrp, "AND");		
				
				Thread.sleep(1000);
				new WebDriverTestBase().getDriver().findElement(By.xpath("(//select[@id='fld_" + i  + "']//following::ul)[1]")).click();
				
				search_rule_parameter(splitRule[1]);
			}
			else
			{
				CommonBean.lbase_baseClass.clickButton(getRuleGroup());		
				QAFExtendedWebElement ruleDrp=new WebDriverTestBase().getDriver()
						.findElement(By.xpath("//select[@id='fld_" + i + "']"));
				CommonBean.lbase_baseClass.selectByValue(ruleDrp, "OR");	
				
				Thread.sleep(1000);
				new WebDriverTestBase().getDriver().findElement(By.xpath("(//select[@id='fld_" + i  + "']//following::ul)[1]")).click();
				
				search_rule_parameter(splitRule[1]);
			}
		}
	}
	
	
	// Method Author : M.S.Sumesh 
	public void FillValidationDetails(String astr_RuleDefinition,String astr_RuleGroup,String astr_Selectfield, String astr_Selectmessage)
			throws InterruptedException 
	{
		CommonBean.lbase_baseClass.clickButton(getRuleSearch());
		search_rule_parameter(astr_RuleDefinition);
		
		if(astr_RuleGroup!=null)
		{
			input_RuleGroup(astr_RuleGroup);			
		}	
		// Data Validation part- Select Rule field
		CommonBean.lbase_baseClass.clickButton(getRuleValidationFieldDrpdwn());
		CommonBean.lbase_baseClass.writeText(getRuleValidationFieldDrpdwnSearchValue(), astr_Selectfield);
		CommonBean.lbase_baseClass.clickButton(getRuleValidationFieldDrpdwnSelectValue());

		// Data Validation part- Select Rule Message
		CommonBean.lbase_baseClass.clickButton(getRuleValidationMessageDrpdwn());
		CommonBean.lbase_baseClass.writeText(getRuleValidationMessageDrpdwnSearchValue(), astr_Selectmessage);
		CommonBean.lbase_baseClass.clickButton(getRuleValidationMessageDrpdwnSelectValue());

	}

	// Method Author : M.S.Sumesh 
	public void FillEnrichmentDetails(String astr_RuleDefinition, String astr_RuleGroup,String astr_RuleEnrichment)
			throws InterruptedException {
		search_rule_parameter(astr_RuleDefinition);
		// Check whether rule group data is present
		if(astr_RuleGroup!=null)
		{
			input_RuleGroup(astr_RuleGroup);			
		}
		CommonBean.lbase_baseClass.clickButton(getClickRuleEnrichmentArea());
		search_rule_parameter(astr_RuleEnrichment);
	}

	// Method Author : M.S.Sumesh 
	// Method to do create Filter rule
	public void FillFilterDetails(String astr_RuleDefinition,String astr_RuleGroup, String astr_RuleFilter) throws InterruptedException 
	{
		try
		{
			search_rule_parameter(astr_RuleDefinition);
			// Check whether rule group data is present
			if(astr_RuleGroup!=null)
			{
				input_RuleGroup(astr_RuleGroup);			
			}
			CommonBean.lbase_baseClass.clickButton(getClickRuleFilterArea());
			search_rule_parameter(astr_RuleFilter);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method Author : M.S.Sumesh 
	// This method calls Save Rule method
	public void saveRule() throws InterruptedException
	{
		try 
		{
			CommonBean.lbase_baseClass.clickButton(getSaveRule());
			Thread.sleep(1500);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method Author : M.S.Sumesh 
	// This method calls Cancel method
	public void cancelRule() throws InterruptedException 
	{
		try
		{
			//DeviceUtils.getQAFDriver().navigate().refresh();			
			QAFExtendedWebElement cancelBtn=DeviceUtils.getQAFDriver().findElement(By.xpath("//button[text()='Validate']"
					+ "/preceding::button[text()='Cancel']"));			
			CommonBean.lbase_baseClass.javascriptClick(cancelBtn);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method Author : M.S.Sumesh 
	// This method calls Cancel without Save method
	public void cancelWithoutSaveRule() throws InterruptedException
	{
		try 
		{
			CommonBean.lbase_baseClass.clickButton(getCancelRule());
			CommonBean.lbase_baseClass.clickButton(getCancelYesRule());
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}
}
