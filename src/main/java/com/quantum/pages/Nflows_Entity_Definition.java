package com.quantum.pages;

import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.quantum.utils.DeviceUtils;


@SuppressWarnings("static-access")
public class Nflows_Entity_Definition extends WebDriverBaseTestPage<WebDriverTestPage>
{
		
	/**
	 * @author <Sumesh.M.S>
	 * Created On 	- <20th Sep 2019>
	 * Responsibility- <This class is used for Entity Definition>
	 * Modified by <name> on <date> for Issue <Issue number (s)> for Integration <integration number>
	 */
		
	//Nflows_RuleEngineDefinition_page CommonBean.lRule_Engine_Definition_ruleDefinition = new Nflows_RuleEngineDefinition_page();
	
	@FindBy(locator = "nflows.entity.newEntityDefinition.btn")
	private QAFExtendedWebElement newEntityDefinition;
		
	@FindBy(locator = "nflows.entity.gridView.btn")
	private QAFExtendedWebElement entityGridview;
	
	@FindBy(locator = "nflows.entity.search.txtbx")
	private QAFExtendedWebElement entitySearchbox;
	
	@FindBy(locator = "nflows.entity.edit.grid")
	private QAFExtendedWebElement entityEditicon;
	
	@FindBy(locator = "nflows.entity.edit.headerTitle")
	private QAFExtendedWebElement entityheaderTitle;
	
	@FindBy(locator = "nflows.entity.edit.entityTab")
	private QAFExtendedWebElement entityDefTab;
	
	@FindBy(locator = "nflows.entity.edit.rulesTab")
	private QAFExtendedWebElement rulesTab;
	
	@FindBy(locator = "nflows.entity.edit.groupingRulesTab")
	private QAFExtendedWebElement groupingRulesTab;
	
	@FindBy(locator = "nflows.entity.edit.createNewgroupingRule")
	private QAFExtendedWebElement createNewgroupingRuleBtn;
	
	@FindBy(locator = "nflows.entity.edit.workflowTab")
	private QAFExtendedWebElement workflowTab;
		
	@FindBy(locator = "nflows.entity.workflowTab.searchWorkflow")
	private QAFExtendedWebElement searchWorkflow;
	
	@FindBy(locator = "nflows.entity.workflowTab.workflowLoader")
	private QAFExtendedWebElement workflowLoader;	
	
	@FindBy(locator = "nflows.entity.edit.searchGroupingRule")
	private QAFExtendedWebElement searchinGrid;
	
	@FindBy(locator = "nflows.entity.edit.gridRuleName")
	private QAFExtendedWebElement getTextfromGrid;
	
	@FindBy(locator = "nflows.entity.edit.saveEntity")
	private QAFExtendedWebElement saveEntity;

// ------------------------------         Locators Ends here !          ----------------------------------------------------	
	
	// getter methods
	public QAFExtendedWebElement getnewEntity() {
		return newEntityDefinition;
	}
	
	public QAFExtendedWebElement getGridView() {
		return entityGridview;
	}
	
	public QAFExtendedWebElement getsearchEntity() {
		return entitySearchbox;
	}
	
	public QAFExtendedWebElement getEditGrid() {
		return entityEditicon;
	}
	
	public QAFExtendedWebElement getgridColumnName(String EntityName)
	{
		String loc = String.format(pageProps.getString("nflows.entity.edit.gridColumnName"), EntityName);
		return new QAFExtendedWebElement(loc);
	}
	
	public QAFExtendedWebElement getentityheaderTitle() {
		return entityheaderTitle;
	}
		
	public QAFExtendedWebElement getClickEntityTab() {
		return entityDefTab;
	}
	
	public QAFExtendedWebElement getClickRulesTab() {
		return rulesTab;
	}
	
	public QAFExtendedWebElement getClickGroupingRulesTab() {
		return groupingRulesTab;
	}
	
	public QAFExtendedWebElement getClickNewGroupingRuleBtn() 
	{
		return createNewgroupingRuleBtn;
	}
	
	public QAFExtendedWebElement getWorkflowTab() 
	{
		return workflowTab;
	}
		
	public QAFExtendedWebElement getsearchinGrid() 
	{
		return searchinGrid;
	}
	
	public QAFExtendedWebElement getgetTextfromGrid() {
		return getTextfromGrid;
	}
			
	public QAFExtendedWebElement getSearchWorkflow() 
	{
		return searchWorkflow;
	}
	
	public QAFExtendedWebElement geteditWorkflow(String astr_workflowName)
	{
		String loc = String.format(pageProps.getString("nflows.entity.workflowTab.workflowName"), astr_workflowName);
		return new QAFExtendedWebElement(loc);
	}
	
	public QAFExtendedWebElement getWorkflowLoader() 
	{
		return workflowLoader;
	}	
	
	public QAFExtendedWebElement getSaveEntity() 
	{
		return saveEntity;
	}
	
	

// ------------------------------         Locators Ends here !          ----------------------------------------------------
	
	// Method Author : M.S.Sumesh 
	public Boolean editEntityfromgridView(String astr_entityName) throws Throwable 
	{
		try 
		{
			if (getGridView().isDisplayed()) 
			{
				CommonBean.lbase_baseClass.clickButton(getGridView());
				Thread.sleep(2000);
				CommonBean.lbase_baseClass.getScreenshot("Switched to Entity Definition Grid view successfully");
				
				CommonBean.lbase_baseClass.writeText(getsearchEntity(), astr_entityName);
				CommonBean.lbase_baseClass.getScreenshot("Do a search for Entity definition");
				getsearchEntity().waitForVisible(2000);
				
				getsearchEntity().sendKeys(Keys.ENTER);
				Thread.sleep(1700);
				QAFExtendedWebElement GridEntityName = getgridColumnName(astr_entityName);
				CommonBean.lbase_baseClass.waitBeforeClick(GridEntityName);

				if (GridEntityName.isDisplayed()) 
				{
					System.out.println("Entity defintion is present");
					CommonBean.lbase_baseClass.getScreenshot("'" + astr_entityName + "' " + "entity definition is present");
					CommonBean.lbase_baseClass.doubleClick(GridEntityName);
					Thread.sleep(2000);		
					Reporter.log("Edited Entity definition successfully !");
				} 
				else 
				{
					System.out.println("No Such entity definition is present");
					CommonBean.lbase_baseClass.getScreenshot("No Such entity definition is present");
					Reporter.log("No Such entity definition is present !");
					return false;
				}
			}
			else 
			{
				System.out.println("No Grid view exists !");
				Reporter.log("Unable to Edit Entity Definition -No Grid view exists!");
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			CommonBean.lbase_baseClass.doubleClick(getgridColumnName(astr_entityName));
			System.out.println("Method name : editEntityfromgridView - Failed");
		}
		return true;

	}
	
	// Method Author : M.S.Sumesh 
	public void createNewGroupingRule(String astr_groupingRuleName, String astr_Description, String astr_RuleDefinition,String astr_rulePurpose,String astr_FieldGroup ,String astr_ruleGroup) throws Throwable 
	{
		try 
		{
			CommonBean.lbase_baseClass.clickButton(getClickNewGroupingRuleBtn());

			String getDynamicRule = CommonBean.lRule_Engine_Definition_ruleDefinition.createGroupingRule(astr_groupingRuleName, astr_Description, astr_RuleDefinition,astr_rulePurpose, astr_FieldGroup,astr_ruleGroup);
			CommonBean.lbase_baseClass.getScreenshot("Enter data for Entity Grouping rule");
			CommonBean.lRule_Engine_Definition_ruleDefinition.saveRule();
			Thread.sleep(4500);
			
			CommonBean.lbase_baseClass.javascriptClick(CommonBean.lRule_Engine_Definition_ruleDefinition.getCancelRule());
			Thread.sleep(1000);

			// Search Rule Name in Grouping rule and click enter
			CommonBean.lbase_baseClass.writeText(getsearchinGrid(), getDynamicRule);
			Thread.sleep(500);
			
			getsearchinGrid().sendKeys(Keys.ENTER);
			Thread.sleep(500);
			CommonBean.lbase_baseClass.getScreenshot("Validated newly created grouping rule");

			String targetGroupRule = CommonBean.lbase_baseClass.getGridData(getDynamicRule);
			Assert.assertEquals(targetGroupRule, getDynamicRule);

			Thread.sleep(500);
			Reporter.log("Create new entity grouping rule");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertFalse(false, "Failed to new create Grouping rule ");		

		}

	}
	
	// Method Author : M.S.Sumesh 
	public void navigate_to_Workflow(String astr_workflowName) throws Throwable 
	{
		try 
		{
			CommonBean.lbase_baseClass.clickButton(getWorkflowTab());
			CommonBean.lbase_baseClass.writeText(getSearchWorkflow(), astr_workflowName);	
			getSearchWorkflow().sendKeys(Keys.ENTER);
			Thread.sleep(2700);
			
			QAFExtendedWebElement gridWorkflowName = geteditWorkflow(astr_workflowName);		
						
			CommonBean.lbase_baseClass.waitBeforeClick(gridWorkflowName);
			CommonBean.lbase_baseClass.doubleClick(gridWorkflowName);
			//Thread.sleep(3000);
			
			CommonBean.lbase_baseClass.waitForVisibility(getWorkflowLoader());			
			CommonBean.lbase_baseClass.waitTill_ElementInvisible(getWorkflowLoader());		
			try 
			{
				CommonBean.lbase_baseClass.waitTill_TextIsPresent(gridWorkflowName, astr_workflowName);
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				//e.printStackTrace();
				DeviceUtils.getQAFDriver().navigate().refresh();
				geteditWorkflow(astr_workflowName);
			}
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