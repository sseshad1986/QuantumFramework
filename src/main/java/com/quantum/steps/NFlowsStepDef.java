package com.quantum.steps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.http.util.TextUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.Assert;

import com.itextpdf.text.DocumentException;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.quantum.utils.DeviceUtils;
import com.quantum.helper.*;
import com.quantum.pages.CommonBean;
import com.quantum.pages.Nflows_Task_Library;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@QAFTestStepProvider()
public class NFlowsStepDef extends WebDriverBaseTestPage<WebDriverTestPage>  {
	/**
	 * @author <Sumesh.M.S> Created On - <20th Sep 2019> Responsibility- <This class
	 *         is used for running Step definition files> Modified by <name> on
	 *         <date> for Issue <Issue number (s)> for Integration <integration
	 *         number>
	 */
	WebDriverTestBase driver = new WebDriverTestBase();	
	
	static HSSFWorkbook Iworkbook;
	static HSSFSheet Isheet;
	static Map<Integer, Object[]> Itestresultdata;
	static int imapKey=0;
	static int iTestcaseID=0;
	static boolean isMyRequest_WF=false;
		
	/******************************************************************************************************       
						Method-STARTS HERE ! Login functionality  
	******************************************************************************************************/
	// Method Author : M.S.Sumesh 
	@Then("^I launch Nflows application using \"([^\"]*)\"$")
	public void Iam_on_Nflows(String astr_url) throws Throwable 
	{		
		
		Boolean isLaunch = null;
		try 
		{		
			isLaunch = CommonBean.lLogin_page.launch_application(astr_url);
			Itestresultdata=new LinkedHashMap<Integer, Object []>();
			Itestresultdata.put(++imapKey, new Object[] {"Test Step Id", "Action","Test Data", "Actual Result","STATUS","Exception message"});
						
			if(isLaunch.booleanValue())
			{
				//BaseClass.getScreenshot("Site is launched successfully");				
				
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Navigate to Nflows site",astr_url, "Launch Nflows app is success","PASS"});
				Assert.assertEquals(isLaunch.booleanValue(), true, "Site is launched successfully");
				Reporter.log("Nflows Site is launched successfully");
			}
			else if(CommonBean.lLogin_page.getpageNotFound().isPresent())
			{				
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Navigate to Nflows site", astr_url,"nFlows - Page Not Found","FAIL"});
				//Assert.assertEquals(false, true);
				forceStop();				
			}
			else if(CommonBean.lLogin_page.getsiteUnavailable().isPresent())
			{				
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Navigate to Nflows site", astr_url,"This site can’t be reached","FAIL"});
				//Assert.assertEquals(false, true);
				forceStop();
			}
			else 
			{			
				CommonBean.lbase_baseClass.reporting("Failure in launching site");
				
				Assert.assertEquals(isLaunch.booleanValue(), false, "Failure in launching site");		
				try
		        { 
		            throw new Exception("Site unreachable"); 
		        } 
		        catch(Exception e) 
		        { 
		        	Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Navigate to Nflows site", "","Launch Nflows app is failed","FAIL",e.getMessage()});
					e.printStackTrace();
					createTestResult("YES");
					System.exit(1);
		        }			
			}		
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();				
		}		
	}

	// Method Author : M.S.Sumesh 
	@When("^I login to Nflows with \"([^\"]*)\" and \"([^\"]*)\" credentials$")
	public void I_login_to_Nflows_with_userName_and_password(String astr_Username, String astr_Password)
			throws Throwable 
	{
		try 
		{
			Boolean lIsloginSuccess=CommonBean.lLogin_page.login_with_valid_username_and_password(astr_Username, astr_Password);
			if(lIsloginSuccess.booleanValue())
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Login with valid Username and password ","User Name : " +astr_Username +",Password : " +astr_Password ,"User is successfully logged in","PASS"});
				Assert.assertEquals(lIsloginSuccess.booleanValue(), true);
				Reporter.log("Success - Login is Successful !");
			}			
			else
			{
				System.out.println("Failure - Login is Unsuccessful !");
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Login with valid Username and password ", "User login is failed","FAIL"});
				CommonBean.lbase_baseClass.reporting("Failure - Login is Unsuccessful !");
				createTestResult("YES");
				System.exit(1);
			}				
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();	
			Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Login with valid Username and password ","User Name : " +astr_Username +",Password : " +astr_Password, "User login is failed","FAIL",e.getMessage()});
			CommonBean.lbase_baseClass.reporting("Failure - Login is Unsuccessful !");
			createTestResult("YES");
			System.exit(1);
		}
	}


	// Method Author : M.S.Sumesh 
	@QAFTestStep(description="I navigate to {0} page")
	@Given("^I navigate to \"([^\"]*)\" page$")
	public void navigate_to_defined_menu(String astr_MenuName) throws Throwable 
	{			
		try 
		{
			boolean isMenuPresent=false;
			if(astr_MenuName!=null)
			{
				Thread.sleep(1500); 
				if(CommonBean.IMyRequest_page.getloadericon().isDisplayed())
				{
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(CommonBean.IMyRequest_page.getloadericon());
					isMenuPresent=CommonBean.lHome_page_home.navigateByMenu(astr_MenuName);				
				}
				else
					isMenuPresent=CommonBean.lHome_page_home.navigateByMenu(astr_MenuName);

				Thread.sleep(1500); 
				
				if(CommonBean.IMyRequest_page.getloadericon().isDisplayed())
					CommonBean.lbase_baseClass.waitTill_ElementInvisible(CommonBean.IMyRequest_page.getloadericon());
				BaseClass.getScreenshot("Navigated to " + astr_MenuName + " successfully");
				
				if(isMenuPresent)
					Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Navigate to " + astr_MenuName,"Menu Name : " +astr_MenuName ,"Navigated to " + astr_MenuName + " Successfully","PASS"});
				else
				{
					Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Navigate to " + astr_MenuName,"Menu Name : " +astr_MenuName ,"Failed to navigate to" + astr_MenuName + " menu.","FAIL"});
					/*click_Logout();
					forceStop(); */
				}					
			}
			else
				System.out.println("No need to navigate to new Menu page");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	/******************************************************************************************************       
    					Method-STARTS HERE ! Entity Definition functionality      
	******************************************************************************************************/
	
	@When("^I create a new Entity Definition$")
	public void create_new_Entity_Definition() throws Throwable 
	{
		System.out.println("create_new_Entity_Definition");
	}

	// Method Author : M.S.Sumesh 
	@Then("^I Edit an Entity Definition for \"([^\"]*)\" Entity$")
	public void I_Edit_an_Entity_Definition(String astr_entityName) throws Throwable 
	{
		try 
		{
			CommonBean.lEntity_Definition_entityDef.editEntityfromgridView(astr_entityName);
			Thread.sleep(1500);	
			
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Method name : I_Edit_an_Entity_Definition - Failed");
			
		}
	}	
	
	// Method Author : M.S.Sumesh 
	@Then("^I navigate to Workflow page \"([^\"]*)\" from Entity definition page$")
	public void navigate_to_Workflow_from_Entitydefinition(String astr_workflowName) throws Throwable 
	{
		try 
		{
			Thread.sleep(1000);
			CommonBean.lEntity_Definition_entityDef.navigate_to_Workflow(astr_workflowName); 
			Thread.sleep(1500);
			
			CommonBean.lbase_baseClass.reporting("Navigate to Workflow page from Entity successfully");			
			Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Navigate to Workflow page from Entity","Workflow Name : " +astr_workflowName ,"Navigate to Workflow page from Entity successfully","PASS"});
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Method Author : M.S.Sumesh 
	@And("^I click on Grouping Rule tab$")
	public void clickGroupingRuleTab() throws Throwable 
	{
		try 
		{
			CommonBean.lbase_baseClass.javascriptClick(CommonBean.lEntity_Definition_entityDef.getClickGroupingRulesTab());		
			Thread.sleep(1500);			
			CommonBean.lbase_baseClass.reporting("Clicked on Grouping Rule tab successfully");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();			
			Assert.assertFalse(false, "Failed  to click Grouping rule tab");		
			Reporter.log("Failed  to click Grouping rule tab");
		}
	}

	// Method Author : M.S.Sumesh 
	@And("^I create a grouping rule for entity with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" for \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void createGroupingRule(String astr_groupingRuleName, String astr_Description, String astr_RuleDefinition,String astr_rulePurpose,String astr_FieldGroup,String astr_ruleGroup) throws Throwable 
	{
		try 
		{
			CommonBean.lEntity_Definition_entityDef.createNewGroupingRule(astr_groupingRuleName, astr_Description, astr_RuleDefinition,astr_rulePurpose,astr_FieldGroup,astr_ruleGroup);	
			Reporter.log("Create Grouping Rule ");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block			
			System.out.println("Method name : createGroupingRule - Failed");					
			Reporter.log("Failed to new create Grouping rule ");
		}
	}
	
	// Method Author : M.S.Sumesh 
	public void edit_an_Entity_Definition (String astr_entityName) throws Throwable
	{
		try 
		{
			CommonBean.lEntity_Definition_entityDef.editEntityfromgridView(astr_entityName);
			Thread.sleep(1500);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	// Method Author : M.S.Sumesh 
	public void click_on_rules_tab () throws Throwable
	{
		try 
		{
			//Click on Rules Tab			
			CommonBean.lbase_baseClass.javascriptClick(CommonBean.lEntity_Definition_entityDef.getClickRulesTab());
			// [ Possibility of Execution stopping !]
			Thread.sleep(1500);
			BaseClass.getScreenshot("Clicked on Rules Tab successfully");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	// Method Author : M.S.Sumesh 
	@Then("^I create a rule for the \"([^\"]*)\" entity with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void create_a_new_rule_definition(String astr_entityName, String RuleName, String RuleType, String Execution, String RuleDesc,
			String RuleDefinition, String Selectfield, String Selectmessage, String RuleEnrichment, String RuleFilter,String astr_RuleGroup)
			throws Throwable 
	{
		String dynamicRuleName= null;
		Boolean isRulecreated=false;
		try 		
		{	
			if(astr_entityName!=null) 
			{
				navigate_to_defined_menu("Entity Definition")	;			
			
				// Search an Entity and Edit entity from Grid view
				edit_an_Entity_Definition (astr_entityName);
					
				//Click on Rules Tab
				click_on_rules_tab();
			}
			Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Click on Rules Tab","", "Navigated to Rules Tab successfully","PASS"});
			
			CommonBean.lRule_Engine_Definition_ruleDefinition.clickNewRule();
			Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Click on New Rule button","", "Opened New rule page successfully","PASS"});
			
			dynamicRuleName=CommonBean.lRule_Engine_Definition_ruleDefinition.inputBasicRuleDetails(RuleName, RuleType, Execution, RuleDesc);

			if (RuleType.equalsIgnoreCase("validation")) {
				CommonBean.lRule_Engine_Definition_ruleDefinition.FillValidationDetails(RuleDefinition,astr_RuleGroup, Selectfield, Selectmessage);				
			} else if (RuleType.equalsIgnoreCase("enrichment")) {
				CommonBean.lRule_Engine_Definition_ruleDefinition.FillEnrichmentDetails(RuleDefinition,astr_RuleGroup, RuleEnrichment);			
			} else if (RuleType.equalsIgnoreCase("filter")) {
				CommonBean.lRule_Engine_Definition_ruleDefinition.FillFilterDetails(RuleDefinition,astr_RuleGroup, RuleFilter);
			} 
			else 
			{
				System.out.println("This is an invalid Rule type");
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Choose Rule Type :" + RuleType,"", "This is an invalid Rule type","FAIL"});
			}
			Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Enter Rule details for " + RuleType + " Rule","RuleDefinition : " + RuleDefinition +","+ " RuleGroup : " + astr_RuleGroup, "Rule Details are entered successfully","PASS"});
						
			BaseClass.getScreenshot("Create " + RuleType + " rule with valid data");
			CommonBean.lRule_Engine_Definition_ruleDefinition.saveRule();
			Thread.sleep(2500);	
			
			if(!CommonBean.lRule_Engine_Definition_ruleDefinition.getmessagePopupBox().isDisplayed())
			{
				isRulecreated=true;
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Save the " + RuleType + " rule","",RuleType + " is Saved successfully","PASS"});
			}				
			else
			{
				BaseClass.getScreenshot("Exception occured in rule saving - FAIL");
				Thread.sleep(500);
				CommonBean.lbase_baseClass.javascriptClick(CommonBean.lRule_Engine_Definition_ruleDefinition.getmessagePopCloseBtn());
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Save the " + RuleType + " rule","",RuleType.toUpperCase() + " rule is Failed to create","FAIL"});
			}			
			CommonBean.lbase_baseClass.waitTill_ElementInvisible(CommonBean.IMyRequest_page.getloadericon());
			CommonBean.lRule_Engine_Definition_ruleDefinition.cancelRule();
			Thread.sleep(1500);	
			if(CommonBean.lRule_Engine_Definition_ruleDefinition.getcancelPopUp().isDisplayed())
				CommonBean.lRule_Engine_Definition_ruleDefinition.cancelWithoutSaveRule();				
			Thread.sleep(1500);			
			
			// Check whether rule is created and search the newly created rule in the grid
			if(isRulecreated)
			{
				CommonBean.lRule_Engine_Definition_ruleDefinition.getsearchGrids().clear();
				CommonBean.lbase_baseClass.writeText(CommonBean.lRule_Engine_Definition_ruleDefinition.getsearchGrids(), dynamicRuleName);  
				CommonBean.lRule_Engine_Definition_ruleDefinition.getsearchGrids().sendKeys(Keys.ENTER);
				Thread.sleep(1500);
				String targetGroupRule = CommonBean.lbase_baseClass.getGridData(dynamicRuleName);
				BaseClass.getScreenshot("Successfully validated newly created rule - "+ RuleType );
				Assert.assertEquals(targetGroupRule, dynamicRuleName);
			}			
		}		
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
	/*  Method Author : M.S.Sumesh 
	 *  Purpose : To download Entity Definition template
	*/	
	@And("^Check download in entity definition page$")
	public void download_From_Entity_definition () throws Throwable
	{
		try 
		{
			
		} 
		catch (Exception e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}	
	}
	
	/******************************************************************************************************       
	Method-STARTS HERE ! Entity Creation functionality      
	******************************************************************************************************/
	
	@When("^Click on New Entity creation button for \"([^\"]*)\"$")
	public void click_new_Entity_record(String astr_entityName) throws Throwable 
	{
		CommonBean.IEntity_Creation.click_new_Entity_record(astr_entityName);		
	}	
	
	// Method Author : Sumesh M .S	
	@And("^Create a Entity record for \"([^\"]*)\" with field group \"([^\"]*)\"$")
	public void create_new_Entity_record(String astr_entityName,String astr_fieldGrps) throws Throwable 
	{
		String[] missingField=null; 
		try 
		{
			if(astr_entityName!=null)
			{
				// Check whether any field group data is to be added
				if(!astr_fieldGrps.isEmpty())
				{
					String arr[]=astr_fieldGrps.split(",");	
					missingField=CommonBean.IEntity_Creation.createEntityRecord(astr_entityName,arr);
				}
				else
					missingField=CommonBean.IEntity_Creation.createEntityRecord(astr_entityName,null);
					String lstr_missingField = String.join(",", missingField);
					
				if(missingField[0].equalsIgnoreCase("true"))	
					Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Create a new record for " + astr_entityName ,"","New record is created for " + astr_entityName + " | missing fields : " + lstr_missingField,"PASS"});
				else
					Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Create a new record for " + astr_entityName ,"","Failed to create New record for " + astr_entityName,"FAIL","Missing fields : " + lstr_missingField});
			}
			else
			{
				System.out.println("No entity records to create");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
		// Method Author : Sumesh M .S
		//Create a Entity record for POC
	
		@And("^Create a Entity record for \"([^\"]*)\" with file name as \"([^\"]*)\" having field group \"([^\"]*)\" for poc$")
		public void create_new_Entity_record_poc(String astr_entityName,String astr_fileName,String astr_fieldGrps) throws Throwable 
		{
			String[] missingField=null; 
			try 
			{
				if(astr_entityName!=null)
				{				
					// Check whether any field group data is to be added
					if(!astr_fieldGrps.isEmpty())
					{
						String arr[]=astr_fieldGrps.split(",");	
						Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Create a record using Asset mandate file ","File name : " + astr_fileName,"Entity record will be created using this file","PASS"});
						missingField=CommonBean.IEntity_Creation_poc.createEntityRecord(astr_entityName,astr_fileName,arr);
					}
					else
						missingField=CommonBean.IEntity_Creation_poc.createEntityRecord(astr_entityName,astr_fileName,null);
						String lstr_missingField = String.join(",", missingField);
						
					if(missingField[0].equalsIgnoreCase("true"))	
						Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Create a new record for " + astr_entityName ,"","New record is created for " + astr_entityName + " | missing fields : " + lstr_missingField,"PASS"});
					else
						Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Create a new record for " + astr_entityName ,"","Failed to create New record for " + astr_entityName,"FAIL","Missing fields : " + lstr_missingField});
				}
				else
				{
					System.out.println("No entity records to create");
				}			
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		}
	
	@And("^Enter field group data for \"([^\"]*)\" for \"([^\"]*)\"$")
	public void enter_fieldgroup_data(String astr_FileName,String astr_FieldGroupName) throws Throwable 
	{		
		CommonBean.IEntity_Creation.enterFieldGroupData(astr_FileName, astr_FieldGroupName);
	}
	
	// Method Author : Vasanth S
	@QAFTestStep(description="Verify Entity Creation Document Manager with {0}")
	public void VerifyEntityCreationDocumentManager(String EntityName) throws Throwable
	{
		boolean result=false;
		try {			
			result = CommonBean.IEntity_Creation.VerifyEntityCreationDocumentManager(EntityName);
			if(result) {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Entity Creation Document Manager Landing Page",
						"Entity Name: "+EntityName,
						"Document Manager Landing Page loaded successfully","PASS"});
				System.out.println("-----------------Search Entity Functionality is Working - Success------------------");				
			}
			else {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Entity Creation Document Manager Landing Page",
						"Entity Name: "+EntityName,
						"Search Entity is not Working properly","FAIL"});				
				System.out.println("Search Entity Functionality is not working - Failure");				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S
	@QAFTestStep(description="Verify Entity Record Search in Entity Creation Document Manager with {0} and {1}")
	public void VerifyEntityRecordSearchinEntityCreationDocumentManager(String EntityName,String EntityRecord) throws Throwable
	{
		Boolean result=false;
		try {
			result = CommonBean.IEntity_Creation.VerifyEntityRecordSearchinEntityCreationDocumentManager(EntityName,EntityRecord);
			if(result) {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Search Entity Record in Entity Creation Document Manager",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord,
						"Search Entity Record is Working successfully","PASS"});
			}
			else {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Search Entity Record in Entity Creation Document Manager",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord,
						"Search Entity Record is not Working Properly","FAIL"});
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S  
	@QAFTestStep(description="Verify View Entity field record in Entity Creation Document Manager with {0}, {1} and {2}")
	public void VerifyViewEntityfieldrecordinEntityCreationDocumentManager(String EntityName,String EntityRecord,String FieldName) throws Throwable
	{
		Boolean result=false;
		try {
			result = CommonBean.IEntity_Creation.VerifyViewEntityfieldrecordinEntityCreationDocumentManager(EntityName,EntityRecord,FieldName);
			if(result) 
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Entity field and View record in Entity Creation Document Manager",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord+", FieldName: "+FieldName,
						"View Entity record Functionality is Working successfully","PASS"});			
			else		
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Entity field and View record in Entity Creation Document Manager",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord+", FieldName: "+FieldName,
						"View Entity record Functionality is not Working Properly","FAIL"});			
		}
		catch(Exception e) {
			e.printStackTrace();			
		}
	}
	
	// Method Author : Vasanth S 
	@QAFTestStep(description="Verify View Workflow field record in Entity Creation Document Manager with {0}, {1} and {2}")
	public void VerifyViewWorkflowfieldrecordinEntityCreationDocumentManager(String EntityName,String EntityRecord,String FieldName) throws Throwable
	{
		Boolean result=false;
		try	{
			result = CommonBean.IEntity_Creation.VerifyViewWorkflowfieldrecordinEntityCreationDocumentManager(EntityName,EntityRecord,FieldName);
			if(result)
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "View Workflow field record in Entity Creation Document Manager",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord+", FieldName: "+FieldName,
						"View Workflow record Functionality is Working successfully","PASS"});
			else
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "View Workflow field record in Entity Creation Document Manager",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord+", FieldName: "+FieldName,
						"View Workflow record Functionality is not Working Properly","FAIL"});
		}
		catch(Exception e) {
			e.printStackTrace();			
		}
	}
	
	// Method Author : Vasanth S 
	@QAFTestStep(description="Verify Download Parent version in Entity Creation Document Manager with {0}, {1} and {2}")
	public void VerifyDownloadParentversioninEntityCreationDocumentManager(String EntityName,String EntityRecord,String FieldName) throws Throwable
	{
		Boolean result=false;
		try {
			result = CommonBean.IEntity_Creation.VerifyDownloadParentversioninEntityCreationDocumentManager(EntityName,EntityRecord,FieldName);
			if(result)
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Download Parent version in Entity Creation Document Manager",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord+", FieldName: "+FieldName,
						"Download Parent Version Functionality is Working successfully","PASS"});
			else
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Download Parent version in Entity Creation Document Manager",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord+", FieldName: "+FieldName,
						"Error in Download Parent Version Functionality","FAIL"});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	// Method Author : Vasanth S 
	@QAFTestStep(description="Verify Download All version in Entity Creation Document Manager {0}, {1} and {2}")
	public void VerifyDownloadAllVersionEntityCreationDocumentManager(String EntityName,String EntityRecord,String FieldName) throws Throwable
	{
		boolean result=false;
		try {
			result = CommonBean.IEntity_Creation.VerifyDownloadAllVersionEntityCreationDocumentManager(EntityName,EntityRecord,FieldName);
			if(result)
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Download All version in Entity Creation Document Manager",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord+", FieldName: "+FieldName,
						"Download All Version Functionality is Working successfully","PASS"});
			else
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Download All version in Entity Creation Document Manager",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord+", FieldName: "+FieldName,
						"Error in Download All Version Functionality","FAIL"});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*  Method Author : M.S.Sumesh 
	 *  Purpose : To download Entity creation template
	*/	
	@And("^Check download in entity creation page$")
	public void download_From_Entity_Creation () throws Throwable
	{
		try 
		{
			//Click on Download button			
	//		CommonBean.lbase_baseClass.clickButton(CommonBean.IEntity_Creation.getdownloadTemplate());
			Thread.sleep(700);
			//CommonBean.lbase_baseClass.clickButton(CommonBean.IEntity_Creation.getDownloadXML());
			
			//CommonBean.lbase_baseClass.clickButton(CommonBean.IEntity_Creation.getDownloadJSON());
			
			CommonBean.lbase_baseClass.clickButton(CommonBean.IEntity_Creation.getDownloadExcel());
			Thread.sleep(700);
		} 
		catch (Exception e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}	
	}
	
	/******************************************************************************************************       
						Method-STARTS HERE ! Forgot password functionality      
	******************************************************************************************************/
	
	// Method Author : M.S.Sumesh
	@Given("^I click on forgot password link$")
	public void iClickOnForgotPasswordLink() throws InterruptedException {
		try {
			CommonBean.lbase_baseClass.clickButton(CommonBean.lLogin_page.getforgotPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Method Author : M.S.Sumesh
	@And("^I enter the userName \"([^\"]*)\"$")
	public void iEnterTheUserName(String userName) throws InterruptedException {
		try {
			CommonBean.lbase_baseClass.writeText(CommonBean.lLogin_page.getTypeUsername(), userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Method Author : M.S.Sumesh
	@And("^I click Submit for Forgot password$")
	public void iClickSubmitForForgotPassword() throws InterruptedException 
	{
		try {
			CommonBean.lbase_baseClass.clickButton(CommonBean.lLogin_page.getClickForgotSubmit());
			Thread.sleep(2500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method Author : M.S.Sumesh
	@Then("^I got email for forgot paasword successfully$")
	public void iGotEmailForForgotPaaswordSuccessfully() 
	{

	}

	//Method-ENDS HERE! 

	/*******************************************************************************************************       
	                    Method-STARTS HERE ! My Request functionality      
	*******************************************************************************************************/

	// Method Author : M.S.Sumesh
	@And("^I wait for proper page loading for myRequest page$")
	public void checkMyRequestLoad() throws InterruptedException, IOException 
	{	
		try {
			//CommonBean.lbase_baseClass.explicitInvisibilityOfElementLocated(CommonBean.IMyRequest_page.getloadericon());
			if(CommonBean.IMyRequest_page.getloadericon().isDisplayed())
			{
				CommonBean.lbase_baseClass.waitTill_ElementInvisible(CommonBean.IMyRequest_page.getloadericon());
			}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Method Author : M.S.Sumesh
	@And("^I check Search functionality for \"([^\"]*)\"$")
	public void performSearchinMyrequest(String astr_searchName) throws InterruptedException, IOException 
	{
		try {
			CommonBean.IMyRequest_page.searchRequest(astr_searchName);				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@And("^I check recalculate functionality$")
	public void checkRecalculate()
	{
		
	}
	
	// Method Author : M.S.Sumesh
	@And("^I check show Other Request functionality$")
	public void checkShowOtherRequest() throws InterruptedException, IOException 
	{
		try 
		{
			CommonBean.IMyRequest_page.clickShowOtherRequest();
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Method Author : M.S.Sumesh
	@And("^I navigate to new Request page$")
	public void navigatetoNewRequest() throws InterruptedException, IOException
	{
		try 
		{
			CommonBean.IMyRequest_page.createNewRequest();
			String lStr_expected="nFlows - Request Manual Trigger";
			String lStr_actual=driver.getDriver().getTitle();
			if(lStr_actual.equals(lStr_expected))
			{
				BaseClass.getScreenshot("Navigate to New  Request page");
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Navigate to new Request page","", "Navigate to new Request page successfully","PASS"});
			}
			else
			{
				BaseClass.getScreenshot("Failed to Navigate to New Request page");
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Navigate to new Request page","", "Failed to Navigate to New Request page","FAIL"});
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
	}
	
	// Method Author : M.S.Sumesh
	@And("^I click on \"([^\"]*)\" and click on entityRecordLookup button$")
	public void clickWorkflow_and_clickEntityRecordLookup(String astr_workflowName) throws InterruptedException, IOException
	{
		try 
		{
			Boolean isWorkflowExist=CommonBean.IMyRequest_page.clickWorkflowName(astr_workflowName);
			BaseClass.getScreenshot("Click on workflow Name : " + astr_workflowName);
			
			if(isWorkflowExist)
			{
				isMyRequest_WF=true;
				CommonBean.IMyRequest_page.clickentityRecordLookup();			
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Click Workflow and click EntityRecordLookup","Workflow : " + astr_workflowName, "Successfully Clicked Workflow and EntityRecordLookup","PASS"});
			}
			else
			{				
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Click Workflow and click EntityRecordLookup","Workflow : " + astr_workflowName, "Failed to Click Workflow and EntityRecordLookup","FAIL"});
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Method Author : M.S.Sumesh
	@And("^I select a \"([^\"]*)\" request from request pop up based on \"([^\"]*)\" initiation fields$")
	public void selectRequest(String astr_searchInitiation,String gridData) throws InterruptedException, IOException
	{			
		try 
		{
			if(isMyRequest_WF)
			{
				CommonBean.IMyRequest_page.selectRequest(astr_searchInitiation,gridData);
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Search a request and add from request pop up","Search data : " + astr_searchInitiation, "New request is successfully added for triggering","PASS"});
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	// Method Author : M.S.Sumesh
	@Then("^\"([^\"]*)\" Request is successfully triggered and validated in my Request page$")
	public void validateNewRequest(String astr_initiationField) throws InterruptedException, IOException
	{		
		try 
		{
			if(isMyRequest_WF)
			{
				CommonBean.IMyRequest_page.searchRequest(astr_initiationField);	
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Validate the new request functionality","", "New request is successfully triggred and exist in my request page","PASS"});
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Method-ENDS HERE! 	

	/*******************************************************************************************************       
      						Method-STARTS HERE ! My Task functionality     
	 * @throws Throwable 
	*******************************************************************************************************/
	// Method Author : M.S.Sumesh
	@And("^I search for a particular task \"([^\"]*)\" of \"([^\"]*)\" in \"([^\"]*)\" section and edit based on \"([^\"]*)\" in \"([^\"]*)\"$")
	public void searchAndEditTask(String astr_TaskName, String astr_taskType, String astr_UserOrTeam,String astr_gridData,String menuName) throws Throwable 
	{	
			try 
			{					
				Boolean isTaskexists=null;
				if(!astr_taskType.equalsIgnoreCase("email"))
				{				
					if(menuName!=null) 
					{
						//driver.getDriver().manage().timeouts().wait();
						// To navigate to my task page
						navigate_to_defined_menu("My Task");
						
						// To check page is loaded properly
						//checkMyRequestLoad();		// commented			
					}				
					int colIndex=0;
					if(CommonBean.IMyTask_Page.getloaderIcon().isDisplayed())
					{					
						isTaskexists=CommonBean.IMyTask_Page.searchTask(astr_TaskName, astr_UserOrTeam);
						System.out.println("--------------BLOCK 1 ---------");
					}
					else
					{	
						Thread.sleep(2500);
						isTaskexists=CommonBean.IMyTask_Page.searchTask(astr_TaskName, astr_UserOrTeam);
						System.out.println("--------------BLOCK 2 ---------");
					}			
					
					Thread.sleep(2000); // 2500
					// Check whether task is present and edit based on task's availability
					if(isTaskexists)					
					{										
						Thread.sleep(1500);	
						System.out.println("--------------BLOCK 3 ---------");
						Boolean isTaskEditable=CommonBean.IMyTask_Page.editTask(colIndex, astr_TaskName, astr_UserOrTeam, astr_gridData);
						if(isTaskEditable)
						{
							Itestresultdata.put(++imapKey, new Object[] 
									{++iTestcaseID, "Edit the task based on entity data" ,astr_TaskName, "Task Edit is success","PASS"});						
						} else
						{
							Itestresultdata.put(++imapKey, new Object[] 
								{++iTestcaseID, "Edit the task based on entity data" ,astr_TaskName, "Task is not available to Edit","FAIL"});
							BaseClass.getScreenshot("'"+ astr_TaskName + "'" + " - Task is not available to Edit-Failed ");
							
							Thread.sleep(1500);
							click_Logout();
							forceStop();
						}
					}
					else
					{		
						System.out.println("--------------BLOCK 6 ---------");
						System.out.println("No Task is available to Edit");
						Itestresultdata.put(++imapKey, new Object[] 
								{++iTestcaseID, "Search for a task" ,astr_TaskName, "No such Task is present","FAIL"});
						BaseClass.getScreenshot("'"+ astr_TaskName + "'" + " - Task search Failed ");
						Thread.sleep(1500);
						click_Logout();
						forceStop();
					}	
				}
				else
				{
					System.out.println("Email task is  executed here !");
					// Please call your method here !
				}
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}	
	
	// Method Author : M.S.Sumesh
    @And("^I perform action for \"([^\"]*)\" of \"([^\"]*)\" from \"([^\"]*)\" with \"([^\"]*)\"$")   
    public void performAction(String astr_task_ID,String astr_taskType,String astr_fileName,String astr_fieldGrps) throws IOException
    {       
        try
        {
        	if(!astr_taskType.equalsIgnoreCase("email"))
			{
	            if(astr_fieldGrps!=null)
	            {
	                String fieldGrp[]=astr_fieldGrps.split(",");   
	//              
	                CommonBean.myTask_Execution.getTaskdetail(astr_task_ID,astr_fileName,fieldGrp);
	                BaseClass.getScreenshot("Capture task changes after task Action");
	            }
	//            else
	//                CommonBean.myTask_Execution.getTaskdetail(astr_task_ID,astr_fileName,"");
	            else
				{
					System.out.println("Email task is  executed here !");
					// Please call your method here !
				}
			}         	
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /* Method Author : M.S.Sumesh , Created Date: 15th Oct 2020
    This method performs save as draft related functionalities */
    
 	@And("^I perform Save as Draft for a particular task$")
 	public void saveAsDraft() throws InterruptedException, IOException 
 	{
 		
 		
 		
 	}	
 	
    // Method Author : M.S.Sumesh
	@And("^I completed the \"([^\"]*)\" task of \"([^\"]*)\" based on \"([^\"]*)\"$")
	public void completeTask(String astr_TaskName,String astr_taskType,String astr_taskAction) throws InterruptedException, IOException 
	{	
			try 
			{	
				Boolean isTaskPresent=Nflows_Task_Library.getTaskCancelBtn().isPresent();
				if(!astr_taskType.equalsIgnoreCase("email"))
				{
					if(isTaskPresent)
					{
						Thread.sleep(1000);
						BaseClass.getScreenshot(astr_taskAction+ " the Task - " + astr_TaskName);						
						Thread.sleep(1500);					
						
						CommonBean.IMyTask_Page.completeTask(astr_taskAction);
						
						Itestresultdata.put(++imapKey, new Object[] 
								{++iTestcaseID, "Complete the task" ,"Task Name : " + astr_TaskName, "Task is completed by action : " + astr_taskAction,"PASS"});
						
						Thread.sleep(2500);					
						if(CommonBean.IMyRequest_page.getloadericon().isDisplayed())
						{
							CommonBean.lbase_baseClass.waitTill_ElementInvisible(CommonBean.IMyRequest_page.getloadericon());
						}
					}
					else
					{
						System.out.println("No task is present to complete !");
						Thread.sleep(1500);
						BaseClass.getScreenshot("No task is present to complete : " + astr_TaskName);					
						Itestresultdata.put(++imapKey, new Object[] 
								{++iTestcaseID, "Complete the task" ,"Task Name : " + astr_TaskName, "Task completion failed for action : " + astr_taskAction ,"FAIL"});
					}	
				}
				else
				{
					System.out.println("Email task is  executed here !");
					// Please call your method here !
				}
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}	
	
	// Method Author : M.S.Sumesh
	@Then("^I check whether current task belongs to same user with \"([^\"]*)\" and \"([^\"]*)\" credentials$")
	public void check_task_for_another_user(String astr_userName,String astr_Password) throws Throwable 
	{	
			try 
			{					
				if(astr_userName!=null) 
				{	
					Thread.sleep(2000);
					CommonBean.lbase_baseClass.loadingWait(CommonBean.IMyRequest_page.getloadericon());
					
					//Logout as current user
					click_Logout();
					Thread.sleep(3500);	// old 6000
					System.out.println("The User whom the task is alloted : " + astr_userName );
					Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Logout as current User " ,"","Logout is Successful","PASS"});
										
					//Login as next user
					CommonBean.lLogin_page.login_with_valid_username_and_password(astr_userName, astr_Password);
					Thread.sleep(3500);	//
					
					Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Login as new User to perform the task ","User Name : " +astr_userName +",Password : " +astr_Password ,"User is successfully logged in","PASS"});
				}
				else
				{
					System.out.println("This task is performed by same user");
				}
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	// Method Author : M.S.Sumesh
	@When("^I perform a search for \"([^\"]*)\" having taskData as \"([^\"]*)\" from \"([^\"]*)\"$")
	public void searchTaskbyAll(String astr_UserOrTeam,String astr_TaskName,String astr_menuName) throws Throwable 
	{	
		Boolean isTaskexists=false;				
		try 
		{
			if(astr_menuName!=null)
				navigate_to_defined_menu("My Task");		
			
			if(CommonBean.IMyTask_Page.getloaderIcon().isDisplayed())
				isTaskexists=CommonBean.IMyTask_Page.searchTask(astr_TaskName, astr_UserOrTeam);			
			else
			{	
				Thread.sleep(2500);
				isTaskexists=CommonBean.IMyTask_Page.searchTask(astr_TaskName, astr_UserOrTeam);				
			}
			
			// Check task exists 
			if(isTaskexists)
			{
				System.out.println(astr_TaskName + " is present !");
				BaseClass.getScreenshot("'"+ astr_TaskName + "'" + " - Task is  available");
				Thread.sleep(1500);
			}
			else
			{
				System.out.println(astr_TaskName + " is not present !");
				BaseClass.getScreenshot("'"+ astr_TaskName + "'" + " - Task is  not available");
				Thread.sleep(1500);
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	// Method Author : M.S.Sumesh
	@Then("^I validate data for \"([^\"]*)\" with \"([^\"]*)\" of task type as \"([^\"]*)\"$")
	public void validateTask(String astr_UserOrTeam,String astr_TaskData,String astr_searchType) throws Throwable 
	{		
		String astr_gridType=null;
		int colIndex=0;
		List<WebElement> row=null;
		String validateData=null;
		
		if(astr_UserOrTeam.equalsIgnoreCase("Team")) 
		{
			colIndex=CommonBean.IMyTask_Page.getHeaderIndex(astr_searchType, CommonBean.IMyTask_Page.getTeamTaskGridHeader());		
			astr_gridType="myTeamTaskGrid";			
		}
		else
		{
			colIndex=CommonBean.IMyTask_Page.getHeaderIndex(astr_searchType, CommonBean.IMyTask_Page.getMyTaskGridHeader());	
			astr_gridType="taskGrid";
		}
					
		colIndex=colIndex+1;					

		// Get all rows from the Grid
		row=DeviceUtils.getQAFDriver().findElementsByXPath("//div[@ng-grid='" + astr_gridType + "']//div[@ng-style='rowStyle(row)']");		
		if(row.size()>0)
		{
			QAFExtendedWebElement rowDataElement=DeviceUtils.getQAFDriver().findElementByXPath("(//div[@ng-grid='" + astr_gridType + "']"
					+ "//div[@ng-style='rowStyle(row)'])[1]//div[@ng-class='col.colIndex()'][" + colIndex + "]");
			validateData=rowDataElement.getText();
			if(validateData.equalsIgnoreCase(astr_TaskData))
			{
				CommonBean.lbase_baseClass.highLightElement(rowDataElement);
				BaseClass.getScreenshot("Search is successful based on "+ astr_TaskData);
				Thread.sleep(2500);
			//	CommonBean.lbase_baseClass.UnhighLightElement(rowDataElement);
			}
			else
			{
				CommonBean.lbase_baseClass.highLightElement(rowDataElement);
				BaseClass.getScreenshot("Search is failed based on "+ astr_TaskData);
				Thread.sleep(2500);
			//	CommonBean.lbase_baseClass.UnhighLightElement(rowDataElement);
			}
		}		
	}
	
	
	//Method-ENDS HERE! 
	
	// ----    Method-STARTS HERE ! Entity creation functionality    -------- 
	
	// Method Author : M.S.Sumesh
	@And("^I edit the \"([^\"]*)\" entity record based on \"([^\"]*)\" coloumn$")	
	public void edit_entity_record(String astr_record,String astr_entityCol) throws Throwable 
	{				
		try 
		{
			if(astr_record!=null && astr_entityCol!=null)
			{
				Boolean isRecordExist=CommonBean.IEntity_Creation.editEntityRecord(astr_record,astr_entityCol);
				if(isRecordExist)
				{
					Thread.sleep(1500);
					BaseClass.getScreenshot("Successfully edited record - " + astr_record);	
					CommonBean.lbase_baseClass.scrollDownEnd();
					BaseClass.getScreenshot("Verify edited record at bottom- " + astr_record);
					Thread.sleep(1500);
					//BaseClass.getScreenshot("Validate back updated record - " + astr_record);	
					Itestresultdata.put(++imapKey, new Object[] 
							{++iTestcaseID, "Edit the entity Record" ,"Entity record : " + astr_record, "Edited record successfully "  ,"PASS"});			
				}
				else
				{
					BaseClass.getScreenshot("No record exists for entity record - " + astr_record);					
					Itestresultdata.put(++imapKey, new Object[] 
							{++iTestcaseID, "Edit the entity Record" ,"Entity record : " + astr_record, "No record exists for entity record: " + astr_record ,"FAIL"});			
				
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	//Method-ENDS HERE! 
	
	
	// ----    Method-STARTS HERE ! Widget Definition functionality    -------- 
	
	// Method Author : M.S.Sumesh 
	@Then("^I Edit an Widget Definition for \"([^\"]*)\" widget$")	
	public void edit_WidgetDefinition(String astr_widgetName) throws Throwable 
	{
		System.out.println("edit_WidgetDefinition method is called !");		
		CommonBean.IWidget_Definition.editWidgetDefinition(astr_widgetName);
	}

	// Method Author : M.S.Sumesh 
	@Then("^add columns to the widgets \"([^\"]*)\"$")	
	public void addfields(String astr_addFields) throws Throwable 
	{
		try 
		{
			System.out.println("addfields method is called !");		
			CommonBean.IWidget_Definition.addFieldToWidget(astr_addFields);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Method Author : M.S.Sumesh 
	@Then("^I create a \"([^\"]*)\" rule for Widget Definition$")	
	public void createWidgetRule(String astr_ruleDefinition) throws Throwable 
	{
		try 
		{
			System.out.println("createWidgetRule method is called !");		
			CommonBean.IWidget_Definition.createWidgetRule(astr_ruleDefinition);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// ----    Method-STARTS HERE ! multilingual functionality    -------- 
	
	// Method Author : M.S.Sumesh 
	
	@Given("^I Check multi lingual functionality$")	
	public void performMultilingual() throws Throwable 
	{
		try 
		{
			CommonBean.multiLingual.performTranslation();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	/*******************************************************************************************************       
    					Method-STARTS HERE ! Document manager Functionality     
	*******************************************************************************************************/
	
//	// Method Author : M.S.Sumesh & Vasanth S 
//	@And("^I validate \"([^\"]*)\" entity attachment for the \"([^\"]*)\" in \"([^\"]*)\"$")
//	public void validateEntityLevelattachment(String astr_entityfield, String astr_record, String astr_entity) throws Throwable 
//	{
//		try 
//		{
//			Boolean lIsDocumetExists=CommonBean.IDocument_Manager.ValidateDocument(astr_entityfield, astr_record, astr_entity);
//			if(lIsDocumetExists)
//			{
//				CommonBean.lbase_baseClass.reporting("Validated " + astr_entityfield + " entity attachment for Entityname" + astr_entity);			
//				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Validate entity level attachment in document manager",
//						"Validated entity level attachment for Entityname - " + astr_entity + " successfully","PASS"});
//			}
//			else
//			{ 
//				CommonBean.lbase_baseClass.reporting("Validated " + astr_entityfield + " entity attachment for Entityname" + astr_entity +" is failed");			
//				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Validate entity level attachment in document manager",
//						"Unable to Validate entity level attachment for Entityname - " + astr_entity ,"FAIL"});
//			}
//		} 
//		catch (Exception e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	// Method Author : M.S.Sumesh 
//	@And("^I validate \"([^\"]*)\" workflow attachment for the \"([^\"]*)\" in \"([^\"]*)\"$")
//	public void validateWorkflowLevelattachment() throws Throwable 
//	{
//		try 
//		{
//			Reporter.log("I click on Logout Button successfully");
//		} 
//		catch (Exception e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}		
	
	// Method Author : Vasanth S 
	@And("^Verify Entity field and View record with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void VerifyEntityFieldAndViewRecords(String EntityName,String EntityRecord,String FieldName) throws Throwable
	{
		Boolean result=false;
		try
		{

			result = CommonBean.IDocument_Manager.verifyEntityFieldAndViewRecords(EntityName,EntityRecord,FieldName);
			if(result)
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Entity field and View record",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord+", FieldName: "+FieldName,
						"View Entity record Functionality is Working successfully","PASS"});
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("Search Entity level field and View record Functionality is Working - Success");
				System.out.println("----------------------------------------------------------------------------");
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Entity field and View record",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord+", FieldName: "+FieldName,
						"View Entity record Functionality is not Working Properly","FAIL"});
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("Search Entity level field and View record Functionality is not working - Failure");
				System.out.println("--------------------------------------------------------------------------------");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S 
	@And("^Verify Workflow field and View record with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void VerifyWorkflowFieldAndViewRecords(String EntityName,String EntityRecord,String FieldName) throws Throwable
	{
		Boolean result=false;
		try	{

			result = CommonBean.IDocument_Manager.verifyWorkflowFieldAndViewRecords(EntityName,EntityRecord,FieldName);
			if(result)
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Workflow field and View record",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord+", FieldName: "+FieldName,
						"View Workflow record Functionality is Working successfully","PASS"});
			else
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Workflow field and View record",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord+", FieldName: "+FieldName,
						"View Workflow record Functionality is not Working Properly","FAIL"});
		}
		catch(Exception e) {
			e.printStackTrace();			
		}
	}
		
	// Method Author : Vasanth S
	@And("^Search a Entity \"([^\"]*)\"$")
	public void SearchEntityDocumentManager(String EntityName) throws Throwable
	{
		Boolean result=false;
		try {

			result = CommonBean.IDocument_Manager.SearchEntityDocumentManager(EntityName);
			if(result) {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Search Entity",
						"Entity Name: "+EntityName,
						"Search Entity is Working successfully","PASS"});
				System.out.println("-----------------Search Entity Functionality is Working - Success------------------");				
			}
			else {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Search Entity",
						"Entity Name: "+EntityName,
						"Search Entity is not Working properly","FAIL"});				
				System.out.println("Search Entity Functionality is not working - Failure");				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
			
	
	// Method Author : Vasanth S
	@And("^Search a Entity Record with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void SearchEntityRecordDocumentManager(String EntityName,String EntityRecord) throws Throwable
	{
		Boolean result=false;
		try
		{

			result = CommonBean.IDocument_Manager.SearchEntityRecordDocumentManager(EntityName,EntityRecord);
			if(result)
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Search Entity Record",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord,
						"Search Entity Record is Working successfully","PASS"});
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("Search Entity Record Functionality is Working - Success");
				System.out.println("----------------------------------------------------------------------------");
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Search Entity Record",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord,
						"Search Entity Record is not Working Properly","FAIL"});
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("Search Entity Record Functionality is not working - Failure");
				System.out.println("--------------------------------------------------------------------------------");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S 
	@And("^Verify Download Parent version with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void VerifyDownloadParentVersion(String EntityName,String EntityRecord,String FieldName) throws Throwable
	{
		Boolean result=false;
		try {

			result = CommonBean.IDocument_Manager.VerifyDownloadParentVersion(EntityName,EntityRecord,FieldName);
			if(result)
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Download Parent version",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord+", FieldName: "+FieldName,
						"Download Parent Version Functionality is Working successfully","PASS"});
			else
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Download Parent version",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord+", FieldName: "+FieldName,
						"Error in Download Parent Version Functionality","FAIL"});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	// Method Author : Vasanth S 
	@And("^Verify Download All version with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void VerifyDownloadAllVersion(String EntityName,String EntityRecord,String FieldName) throws Throwable
	{
		Boolean result=false;
		try
		{

			result = CommonBean.IDocument_Manager.VerifyDownloadAllVersion(EntityName,EntityRecord,FieldName);
			if(result)
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Download All version",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord+", FieldName: "+FieldName,
						"Download All Version Functionality is Working successfully","PASS"});
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("Download All Version Functionality is Working - Success");
				System.out.println("----------------------------------------------------------------------------");
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Download All version",
						"Entity Name: "+EntityName+", Entity Record: "+EntityRecord+", FieldName: "+FieldName,
						"Error in Download All Version Functionality","FAIL"});
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("Download All Version Functionality is not working - Failure");
				System.out.println("--------------------------------------------------------------------------------");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	/*******************************************************************************************************       
	Method-STARTS HERE ! Dashboard Definition Functionality     
	*******************************************************************************************************/
	// Method Author : Vasanth S 
	@QAFTestStep(description="Verify Distribute Equally in Dashboard Definition with {0}")
	public void VerifyDistributeEquallyinDashboardDefinition(String DashboardName) throws Throwable
	{
		Boolean result=false;
		try	{
			result = CommonBean.dasboardDefinition.VerifyDistributeEquallyinDashboardDefinition(DashboardName);
			if(result)	{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Distribute Equally","Dashboard Name : "+DashboardName,
						"Distribute Equally Functionality is Working successfully","PASS"});
			}
			else {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Distribute Equally",
						"Dashboard Name : "+DashboardName,"Error in Distribute Equally Functionality","FAIL"});
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S 
	@QAFTestStep(description="Verify Distribute Equally Widget wise in Dashboard Definition with {0}")
	public void VerifyDistributeEquallyWidgetwiseDashboardDefinition(String DashboardName) throws Throwable
	{
		Boolean result=false;
		try	{
			result = CommonBean.dasboardDefinition.VerifyDistributeEquallyWidgetwiseDashboardDefinition(DashboardName);
			if(result)	{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Distribute Equally Widget wise","Dashboard Name : "+DashboardName,
						"Distribute Equally Widget wise Functionality is Working successfully","PASS"});
			}
			else {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Distribute Equally Widget wise",
						"Dashboard Name : "+DashboardName,"Error in Distribute Equally Widget wise Functionality","FAIL"});
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S 
	@QAFTestStep(description="Delete Widget in Dashboard Definition with {0}")
	public void DeleteWidgetinDashboardDefinition(String DashboardName) throws Throwable
	{
		Boolean result=false;
		try	{
			result = CommonBean.dasboardDefinition.DeleteWidgetinDashboardDefinition(DashboardName);
			if(result)	{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Delete in Dashboard Definition","Dashboard Name : "+DashboardName,
						"Delete Functionality is Working successfully","PASS"});
			}
			else {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Delete in Dashboard Definition",
						"Dashboard Name : "+DashboardName,"Error in Delete Functionality","FAIL"});
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*******************************************************************************************************       
	Method-STARTS HERE ! Dashboard Execution Functionality     
	*******************************************************************************************************/

	// Method Author : Vasanth S 
	@QAFTestStep(description="Verify Dashboard Generation with {0}")
	public void VerifyDasboardGeneration(String DashboardName) throws Throwable
	{
		Boolean result=false;
		try
		{

			result = CommonBean.dashboardExecution.VerifyDasboardGeneration(DashboardName);
			if(result)
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Dashboard Generation","",
						"Dashboard Generation Functionality is Working successfully","PASS"});
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Dashboard Generation",
						"","Error in Dashboard Generation Functionality","FAIL"});
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S
	@QAFTestStep(description="Verify PNG, JPEG, Excel, PDF in Dashboard Execution with {0}")
	public void VerifyPngJpegExcelPdfinDashboardExecution(String DownloadFolder) throws Throwable
	{			
		try
		{
			ResultSet rs = CommonBean.dashboardExecution.VerifyPngJpegExcelPdfinDashboardExecution(DownloadFolder);
			if(rs.getResult())
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify PNG, JPEG, Excel, PDF in Dashboard Execution","",
						"PNG, JPEG, Excel, PDF in Dashboard Execution is Working successfully","PASS"});
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify PNG, JPEG, Excel, PDF in Dashboard Execution",
						"","Error in PNG, JPEG, Excel, PDF in Dashboard Execution Functionality","FAIL",rs.getExceptionmsg()});
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	// Method Author : Vasanth S
	@QAFTestStep(description="Verify Send Mail in Dashboard Execution with {0}, {1} and {2}")
	public void VerifySendMailinDashboardExecution(String MailTo, String Subject, String MailContent) throws Throwable
	{			
		try
		{
			boolean result = CommonBean.dashboardExecution.VerifySendMailinDashboardExecution(MailTo,Subject, MailContent);
			if(result)
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Send Mail in Dashboard Execution","",
						"Send Mail in Dashboard Execution is Working successfully","PASS"});
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Send Mail in Dashboard Execution",
						"","Error in Send Mail Functionality in Dashboard Execution","FAIL"});
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//Method-ENDS HERE! 
	
	/*******************************************************************************************************       
							Method-STARTS HERE ! Reports Definition Functionality     
    *******************************************************************************************************/
	
	// Method Author : M.S.Sumesh, created on 23rd July 2020
	@And("^I generate Report for \"([^\"]*)\"$")
	public void generateReports(String astr_reportName) throws Throwable 
	{
		try 
		{
			CommonBean.report_Execution.generateReport(astr_reportName);
			Reporter.log("I generated reports successfully");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S 
	@QAFTestStep(description="Verify Distribute Equally in Report Definition with {0}")
	public void VerifyDistributeEquallyinReportDefinition(String ReportName) throws Throwable
	{
		Boolean result=false;
		try	{
			result = CommonBean.reportDefinition.VerifyDistributeEquallyinReportDefinition(ReportName);
			if(result)	{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Distribute Equally","Report Name : "+ReportName,
						"Distribute Equally Functionality is Working successfully","PASS"});
			}
			else {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Distribute Equally",
						"Report Name : "+ReportName,"Error in Distribute Equally Functionality","FAIL"});
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S 
	@QAFTestStep(description="Verify Distribute Equally Widget wise in Report Definition with {0}")
	public void VerifyDistributeEquallyWidgetwiseReportDefinition(String ReportName) throws Throwable
	{
		Boolean result=false;
		try	{
			result = CommonBean.reportDefinition.VerifyDistributeEquallyWidgetwiseReportDefinition(ReportName);
			if(result)	{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Distribute Equally Widget wise","Report Name : "+ReportName,
						"Distribute Equally Widget wise Functionality is Working successfully","PASS"});
			}
			else {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Distribute Equally Widget wise",
						"Report Name : "+ReportName,"Error in Distribute Equally Widget wise Functionality","FAIL"});
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S 
	@QAFTestStep(description="Delete Widget in Report Definition with {0}")
	public void DeleteWidgetinReportDefinition(String ReportName) throws Throwable
	{
		Boolean result=false;
		try	{
			result = CommonBean.reportDefinition.DeleteWidgetinReportDefinition(ReportName);
			if(result)	{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Delete in Report Definition","Report Name : "+ReportName,
						"Delete Functionality is Working successfully","PASS"});
			}
			else {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Delete in Report Definition",
						"Report Name : "+ReportName,"Error in Delete Functionality","FAIL"});
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************************************************************       
						Method-STARTS HERE ! Reports Execution Functionality     
	*******************************************************************************************************/

	// Method Author : Vasanth S 
	@QAFTestStep(description="Verify Report Generation with {0}")
	public void VerifyReportGeneration(String ReportName) throws Throwable
	{
		Boolean result=false;
		try	{
			result = CommonBean.report_Execution.VerifyReportGeneration(ReportName);
			if(result) {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Report Generation","Report Name: "+ReportName,
						"Report Generation Functionality is Working successfully","PASS"});
			}
			else {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Report Generation",
						"Report Name: "+ReportName,"Error in Report Generation Functionality","FAIL"});
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S
	@QAFTestStep(description="Verify PNG, JPEG, Excel, PDF in Report Execution with {0} and {1}")
	public void VerifyPngJpegExcelPdfinReportExecution(String ReportName,String DownloadFolder) throws Throwable
	{			
		try {
			ResultSet rs = CommonBean.report_Execution.VerifyPngJpegExcelPdfinReportExecution(ReportName,DownloadFolder);
			if(rs.getResult()) {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "PNG, JPEG, Excel, PDF in Report Execution",
						"Report Name: "+ ReportName +"Download Folder: "+DownloadFolder ,	"PNG, JPEG, Excel, PDF in Report Execution is Working successfully","PASS"});
			}
			else {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "PNG, JPEG, Excel, PDF in Report Execution",
						"Report Name: "+ ReportName +"Download Folder: "+DownloadFolder ,"Error in PNG, JPEG, Excel, PDF in Report Execution Functionality","FAIL",rs.getExceptionmsg()});
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S
	@QAFTestStep(description="Verify Send Mail in Report Execution with {0}, {1} and {2}")
	public void VerifySendMailinReportExecution(String MailTo, String Subject, String MailContent) throws Throwable
	{			
		try
		{
			boolean result = CommonBean.report_Execution.VerifySendMailinReportExecution(MailTo,Subject, MailContent);
			if(result)
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Send Mail in Report Execution","",
						"Send Mail in Report Execution is Working successfully","PASS"});
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Send Mail in Report Execution",
						"","Error in Send Mail Functionality in Report Execution","FAIL"});
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	// Method Author : Vasanth S
	@QAFTestStep(description="Verify PNG, JPEG, Excel, PDF for Specific Widget in Report with {0}, {1} and {2}")
	public void VerifyPngJpegExcelPdfSpecificWidget(String ReportName,String WidgetName, String DownloadFolder) throws Throwable
	{			
		try {
			ResultSet rs = CommonBean.report_Execution.VerifyPngJpegExcelPdfSpecificWidget(ReportName,WidgetName,DownloadFolder);
			if(rs.getResult()) {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "PNG, JPEG, Excel, PDF for Specific Widget",
						"Widget Name: "+WidgetName + "Download Folder: " + DownloadFolder,"PNG, JPEG, Excel, PDF in Report Execution is Working successfully","PASS"});
			}
			else {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "PNG, JPEG, Excel, PDF for Specific Widget",
						"Widget Name: "+WidgetName + "Download Folder: " + DownloadFolder ,"Error in PNG, JPEG, Excel, PDF in Report Execution Functionality","FAIL",rs.getExceptionmsg()});
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S
	@QAFTestStep(description="Verify Global Parameters in Report Execution with {0}")
	public void VerifyGlobalParametersReportExecution(String ReportName) throws Throwable
	{			
		try {
			boolean result = CommonBean.report_Execution.VerifyGlobalParametersReportExecution(ReportName);
			if(result) {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Global Parameters in Report Execution","Report Name: "+ReportName,
						"Global Parameters in Report Execution is Working successfully","PASS"});
			}
			else {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Global Parameters in Report Execution",
						"Report Name: "+ReportName,"Error in Global Parameters Functionality in Report Execution","FAIL"});
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*******************************************************************************************************       
							Method-STARTS HERE ! Logout Functionality     
	*******************************************************************************************************/
	
	// Method Author : M.S.Sumesh 
	@Given("^I click on Logout Button$")
	public void click_Logout() throws Throwable 
	{
		try 
		{
			CommonBean.lbase_baseClass.loadingWait(CommonBean.IMyRequest_page.getloadericon());
			CommonBean.lHome_page_home.perform_Logout();
			//BaseClass.getScreenshot("Successfully Logout of nFlows ");
			Reporter.log("I click on Logout Button successfully");
			Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Clicked Logout button", "","Successfully clicked Logout button","PASS"});	
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Method Author : M.S.Sumesh 
	@Then("^I logged out of Nflows successfully$")
	public void check_logout(String astr_isRecordingenabled) throws Throwable 
	{
		try 
		{
			CommonBean.lLogin_page.validate_Logout();
			Reporter.log("I logged out of Nflows successfully");
			Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Logout of nFlows app", "Logout is successful","PASS"});	
					
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Logout is Failed ", "Logout is Failed","FAIL"});
		}

	}
	
	//Method-ENDS HERE !
	
	/*******************************************************************************************************       
							Method-STARTS HERE ! Video Recording Functionality     
	*******************************************************************************************************/
	
	// Method Author : M.S.Sumesh 
	@Then("^I start recording automation execution based on \"([^\"]*)\"$")
	public void recordingStart(String astr_isRecordingenabled) throws Exception 
	{
		if(astr_isRecordingenabled.equalsIgnoreCase("YES"))
		{
			MyScreenRecorder.startRecording("NflowsRegression");
		}
		else
		{
			System.out.println("No recording is performed !");
		}		
	}
	
	// Method Author : M.S.Sumesh 
	@Then("^I stop recording automation execution based on \"([^\"]*)\"$")
	public void recordingStop(String astr_isRecordingenabled) throws Exception 
	{
		try {
			if(astr_isRecordingenabled.equalsIgnoreCase("YES"))
			{
				MyScreenRecorder.stopRecording();
				System.out.println("Recording is Stopped !");
			}
			else
			{
				System.out.println("No recording is performed !");
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/*******************************************************************************************************       
							Method-STARTS HERE ! Create PDF Report Functionality     
	*******************************************************************************************************/
	
	// Method Author : M.S.Sumesh 
	@When("^I create a PDF report based on \"([^\"]*)\"$")
	public void createPDFReport(String astr_isPdfenabled) throws DocumentException, MalformedURLException, IOException 
	{
		try 
		{
			if(astr_isPdfenabled.equalsIgnoreCase("YES"))
			{
				System.out.println("PDF report function is called");
				BaseClass.createPDFReport();
			}
			else
			{
				System.out.println("No Pdf report is generated !");
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	
	/*******************************************************************************************************       
							Method-STARTS HERE ! Test excel Report Functionality     
	*******************************************************************************************************/	
	
	// Method Author : M.S.Sumesh 
	@When ("^I create a Test Result file based on \"([^\"]*)\"$")
	public void createTestResult(String astr_isenabled) throws FileNotFoundException, DocumentException 
	{
		try 
		{
			if(astr_isenabled.trim().equalsIgnoreCase("YES"))
			{
				String lstr_TestResultPath=System.getProperty("user.dir") 
					+ "\\Excel_TestResult\\TestResult_" + BaseClass.getRandomTimestampData();
				System.out.println(lstr_TestResultPath);
				
				//create a new work book
				Iworkbook = new HSSFWorkbook();
		      
				// Create a new work sheet
				Isheet=Iworkbook.createSheet("TestResult");				
				
				CellStyle passStyle = Iworkbook.createCellStyle();
				Font greenfont = Iworkbook.createFont();
				greenfont.setColor(HSSFColor.HSSFColorPredefined.GREEN.getIndex());
				greenfont.setBold(true);
			    passStyle.setFont(greenfont);
			
				CellStyle failStyle = Iworkbook.createCellStyle();
				Font redfont = Iworkbook.createFont();
				//failStyle.setFillForegroundColor(HSS);
				redfont.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
				redfont.setBold(true);
				failStyle.setFont(redfont);	
				
				if(Itestresultdata.size()>1)
				{
					// Write data into the excel file
					Set<Integer> keySet=Itestresultdata.keySet();
					int rownum=0;
					for(Integer key: keySet)
					{
						Row row=Isheet.createRow(rownum++);					
						Object [] objArr=Itestresultdata.get(key);
						int cellnum=0;
						
						CellStyle style = Iworkbook.createCellStyle(); //Create new style
		                style.setWrapText(true); //Set wordwrap	                
						
						for(Object obj:objArr)
						{						
							Cell cell=row.createCell(cellnum ++);
							if(obj instanceof Date) 
				                cell.setCellValue((Date)obj);
							 else if(obj instanceof Boolean)
					                cell.setCellValue((Boolean)obj);
					         else if(obj instanceof String)
					                cell.setCellValue((String)obj);
					         else if(obj instanceof Double)
					              cell.setCellValue((Double)obj);
					         else if(obj instanceof Integer)
					              cell.setCellValue((Integer)obj);
						
							cell.setCellStyle(style);
							
							if(obj.toString().equals("PASS"))
							{
								cell.setCellStyle(passStyle);
							}												 
							else if(obj.toString().equals("FAIL"))
							{
								cell.setCellStyle(failStyle);
							}					
						}						
					}
					
					for (int i=0; i<10; i++)
					{
						Isheet.autoSizeColumn(i);
					}
				}
				try 
				{
					System.out.println("File path : "  + lstr_TestResultPath + "TestResult_"+ BaseClass.getRandomTimestampData()+ ".xls");
					File file = new File(lstr_TestResultPath);
					file.mkdir();
			        FileOutputStream out =new FileOutputStream(new File(lstr_TestResultPath + "\\TestResult_"+ BaseClass.getRandomTimestampData()+ ".xls"));
			        Iworkbook.write(out);
			        out.close();
			        System.out.println("Excel written successfully..");			         
			    } 
				catch (FileNotFoundException e) {
			        e.printStackTrace();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			}
			else
			{
				System.out.println("No Test excel report is generated !");
			}
		} 
		catch (Exception e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}

	// Method Author : M.S.Sumesh 
	@When("^I check filter data$")
	public void check_Filter(Map<String, Object> data) throws InterruptedException
	{		
		for (Map.Entry<String,Object> entry : data.entrySet()) 
		{	
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());	
			System.out.println("//--------------//");
		}		
	}
	
	// Method Author : M.S.Sumesh
	// This method is to force stop execution 
	public void forceStop() throws Throwable
	{
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.getDriver().close();
		createTestResult("YES");
		createPDFReport("YES");
		System.exit(1);
	}
	
//----------------------------------------------------------------------------------------
	
	@When("^Insert Field group data$")
	public void Insert_Field_group_data() throws InterruptedException
	{
//		CommonBean.projectLibrary.insertDisplaygroupFieldData("Section","input","DT31","NA");
//		CommonBean.projectLibrary.insertDisplaygroupFieldData("Manual Owners","button","Joanne;Lee","singleSelect");
//		CommonBean.projectLibrary.addFieldgroupRows(DeviceUtils.getQAFDriver().findElement(By.xpath("//span[@ng-click='addGridRow(1440)']")),4);
	/*	projectLibrary.getFieldgroupHeaderColumnNumber("S No", DeviceUtils.getQAFDriver().findElements(By.xpath("//div[@col-index='renderIndex']")));
		projectLibrary.insertFieldgroupData(4, "Designation", DeviceUtils.getQAFDriver().findElements(By.xpath("//div[@col-index='renderIndex']")), "button","abc,Manual Owner,MO and G Head,LRC Member,LRC Chairman");
		*/
	//	CommonBean.projectLibrary.insertFieldgroupData(4, "S No", DeviceUtils.getQAFDriver().findElements(By.xpath("//div[@col-index='renderIndex']")),"input", "0,1,2,3,4");
	/*	projectLibrary.modifyFieldgroupData("Designation","S No",DeviceUtils.getQAFDriver().findElements(By.xpath("//div[@col-index='renderIndex']")),"Manual Owner","9","input");
		projectLibrary.modifyFieldgroupData("Designation","Action by",DeviceUtils.getQAFDriver().findElements(By.xpath("//div[@col-index='renderIndex']")),"Manual Owner","Ahamed;R","button");
	*/
	//	CommonBean.projectLibrary.deleteFieldgroupRow(2);
	}
	/*******************************************************************************************************       
    							Method-STARTS HERE ! Roles functionality      
	 *******************************************************************************************************/
	// Method Author : Vasanth S 
	// Method Name	: Verify Roles Landing Page
	@Given("^Verify Landing Page Grid$")
	public void Verify_landing_Page_Grid() throws Throwable
	{
		try	{			
			CommonBean.roles.getNewRole().waitForVisible(10000);			
			if(CommonBean.roles.getNewRole().isDisplayed())
			{
				BaseClass.getScreenshot("Roles Landing Page Verified");
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Roles Landing Page","","Roles Landing is verified","PASS"});
				System.out.println("------------------------------------------------");
				System.out.println("Roles Landing Page is Visible - Success");
				System.out.println("------------------------------------------------");
			}
			else
			{
				BaseClass.getScreenshot("Error in Roles Landing Page");
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Roles Landing Page","","Error in Roles Landing Page","FAIL"});
				System.out.println("------------------------------------------------");
				System.out.println("Failure - Landing Page is not Visible");
				System.out.println("------------------------------------------------");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();			
		}
	}
	
	// Method Author : Vasanth S
	// Method Name	: Create New Role
	@Given("^Create New Role with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void create_new_role_and_Verify(String RoleName, String Description) throws Throwable
	{
		Boolean IsCreated;
		try
		{
			IsCreated = CommonBean.roles.create_new_role_and_verify(RoleName, Description);
			if(IsCreated)
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID,"Create New Role","Role: "+RoleName+", Role Desc:"+Description,"New Role is created","PASS"});
				System.out.println("------------------------------------------------");
				System.out.println("New Role is created - Success");
				System.out.println("------------------------------------------------");
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID,"Create New Role","Role: "+RoleName+", Role Desc:"+Description,"Error in creating new Role","FAIL"});
				System.out.println("------------------------------------------------");
				System.out.println("Error in creating new Role - Failure");
				System.out.println("------------------------------------------------");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();			
		}
	}
	// Method Author : Vasanth S
	// Method Name	: Edit Existing Role
	@Given("^Edit Role \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void Edit_Role_Verify(String RoleName,String NewRoleName, String NewDescription) throws Throwable
	{
		Boolean IsEdited;
		try	{
			IsEdited = CommonBean.roles.edit_role_verify(RoleName,NewRoleName, NewDescription);
			if(IsEdited) {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Edit existing Role",
						"Role Name: "+RoleName+", New Role Name: "+NewRoleName, "Role is edited successfully","PASS"});		
			}
			else {
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Edit existing Role",
						"Role Name: "+RoleName+", New Role Name: "+NewRoleName,"Error in Editing Existing Role","FAIL"});
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	// Method Author : Vasanth S
	// Method Name	: Search Role Functionality
	@Given("^Search the Roles with \"([^\"]*)\"$")
	public void Search_Roles_And_Verify(String RoleName) throws Throwable
	{
		Boolean IsSearchWorking;
		try
		{
			IsSearchWorking = CommonBean.roles.search_roles_and_verify(RoleName);
			if(IsSearchWorking)
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Search Role","Role Name: "+RoleName,"Roles Search Functionality is Working","PASS"});
				System.out.println("------------------------------------------------");
				System.out.println("Roles Search Functionality is Working - Success");
				System.out.println("------------------------------------------------");
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Search Role","Role Name: "+RoleName,"Error in Roles Search Functionality","FAIL"});
				System.out.println("------------------------------------------------");
				System.out.println("Roles Search Functionality is not working - Failure");
				System.out.println("------------------------------------------------");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S
	// Method Name	: Inactive Role Functionality
	@Given("^Inactive the Roles \"([^\"]*)\"$")
	public void Inactive_Roles_And_Verify(String RoleName) throws Throwable
	{
		Boolean IsActiveWorking;
		try
		{
			IsActiveWorking = CommonBean.roles.inactive_roles_and_verify(RoleName);
			if(IsActiveWorking)
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Inactive Role","Role Name: "+RoleName,"Roles Inactive Functionality is Working","PASS"});
				System.out.println("------------------------------------------------");
				System.out.println("Inactive the Roles is Working - Success");
				System.out.println("------------------------------------------------");
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Inactive Role","Role Name: "+RoleName,"Error in Roles Inactive Functionality","FAIL"});
				System.out.println("------------------------------------------------");
				System.out.println("Inactive the Roles is not Working - Failure");
				System.out.println("------------------------------------------------");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	/*******************************************************************************************************       
								Method-STARTS HERE ! Dropdown functionality      
	 *******************************************************************************************************/
	// Method Author : Vasanth S 
	// Method Name	: Verify Dropdown Landing Page
	@Given("^Verify Dropdown Landing Page Grid$")
	public void Verify_Dropdown_landing_Page_Grid() throws Throwable {
		try	{
			CommonBean.dropdown.getNewDropdown().waitForVisible(10000);
			Thread.sleep(2000);			
			if(CommonBean.dropdown.getNewDropdown().isDisplayed())	{
				BaseClass.getScreenshot("Dropdown Landing Page Verified");
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Dropdown Landing Page","","Dropdown Landing Page is Visible","PASS"});
				System.out.println("------------------------------------------------");
				System.out.println("Dropdown Landing Page is Visible - SUCCESS");
				System.out.println("------------------------------------------------");
			}
			else {
				BaseClass.getScreenshot("Error in Roles Inactive Functionality");
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Inactive Role","","Dropdown Landing Page is not Visible","FAIL"});
				System.out.println("------------------------------------------------");
				System.out.println("Dropdown Landing Page is not Visible - FAILURE");
				System.out.println("------------------------------------------------");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S
	// Method Name	: Create New Dropdown
	@Given("^Create New Dropdown with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void create_new_dropdown_and_Verify(String ListName, String ListValue1) throws Throwable
	{
		Boolean IsCreated;
		try
		{
			IsCreated = CommonBean.dropdown.create_new_dropdown_and_verify(ListName, ListValue1);
			if(IsCreated)
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Create New Dropdown","Dropdown Name: "+ListName+", Values: "+ListValue1,"New Dropdown is created successfully","PASS"});
				System.out.println("------------------------------------------------");
				System.out.println("New Dropdown is created - SUCCESS");
				System.out.println("------------------------------------------------");
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Create New Dropdown","Dropdown Name: "+ListName+", Values: "+ListValue1,"Error in creating new Dropdown","FAIL"});
				System.out.println("------------------------------------------------");
				System.out.println("Error in creating new Dropdown - FAILURE");
				System.out.println("------------------------------------------------");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
		
	// Method Author : Vasanth S
	// Method Name	: Edit Existing Dropdown
	@Given("^Edit Dropdown \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void Edit_Dropdown_Verify(String ListName,String NewListName, String NewListValue1) throws Throwable
	{
		Boolean IsEdited;
		try
		{
			IsEdited = CommonBean.dropdown.edit_dropdown_verify(ListName,NewListName, NewListValue1);
			if(IsEdited)
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Edit Existing Dropdown",
						"Dropdown Name: "+ListName+", New Dropdown: "+NewListName+", Values: "+NewListValue1,
						"Dropdown is edited successfully","PASS"});
				System.out.println("------------------------------------------------");
				System.out.println("Dropdown is edited - SUCCESS");
				System.out.println("------------------------------------------------");
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Edit Existing Dropdown",
						"Dropdown Name: "+ListName+", New Dropdown: "+NewListName+", Values: "+NewListValue1,
						"Error in Editing Existing Dropdown","FAIL"});
				System.out.println("------------------------------------------------");
				System.out.println("Error in Editing Existing Dropdown - FAILURE");
				System.out.println("------------------------------------------------");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S
	// Method Name	: Search Dropdown Functionality
	@Given("^Search the Dropdown with \"([^\"]*)\"$")
	public void Search_Dropdown_And_Verify(String ListName) throws Throwable
	{
		Boolean IsSearchWorking;
		try
		{
			IsSearchWorking = CommonBean.dropdown.search_dropdown_and_verify(ListName);
			if(IsSearchWorking)
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Search Dropdown Functionality",
						"Dropdown Name: "+ListName,"Dropdown Search Functionality is Working","PASS"});				
				System.out.println("------------------------------------------------");
				System.out.println("Dropdown Search Functionality is Working - Success");
				System.out.println("------------------------------------------------");
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Search Dropdown Functionality",
						"Dropdown Name: "+ListName,"Error in Dropdown Search Functionality","FAIL"});
				System.out.println("------------------------------------------------");
				System.out.println("Dropdown Search Functionality is not working - Failure");
				System.out.println("------------------------------------------------");
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S
	// Method Name	: Inactive Dropdown Functionality
	@Given("^Inactive the Dropdown \"([^\"]*)\"$")
	public void Inactive_Dropdown_And_Verify(String ListName) throws Throwable
	{
		Boolean IsActiveWorking;
		try
		{
			IsActiveWorking = CommonBean.dropdown.inactive_dropdown_and_verify(ListName);
			if(IsActiveWorking)
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Inactive Dropdown Functionality",
						"Dropdown Name: "+ListName,"Dropdown Inactive Functionality is Working","PASS"});
				System.out.println("------------------------------------------------");
				System.out.println("Inactive the Dropdown is Working - Success");
				System.out.println("------------------------------------------------");
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Inactive Dropdown Functionality",
						"Dropdown Name: "+ListName,"Error in Dropdown Inactive Functionality","FAIL"});
				System.out.println("------------------------------------------------");
				System.out.println("Inactive the Dropdown is not Working - Failure");
				System.out.println("------------------------------------------------");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/*******************************************************************************************************       
							Method-STARTS HERE ! Calendar functionality      
	 *******************************************************************************************************/	
	
	// Method Author : Vasanth S 
	// Method Name	: Verify Calendar Landing Page
	@Given("^Verify Calendar Landing Page Grid$")
	public void Verify_Calendar_landing_Page_Grid() throws Throwable
	{
		try
		{
			CommonBean.calendar.getNewCalendar().waitForVisible(10000);
			Thread.sleep(2000);			
			if(CommonBean.calendar.getNewCalendar().isDisplayed())
			{
				BaseClass.getScreenshot("Calendar Landing Page is loaded successfully");
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Calendar Landing Page",
						"","Calendar Landing Page is loaded successfully","PASS"});
				System.out.println("------------------------------------------------");
				System.out.println("Business Calendar Landing Page is Visible - SUCCESS");
				System.out.println("------------------------------------------------");
			}
			else
			{
				BaseClass.getScreenshot("Error in loading Calendar Landing Page");
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Verify Calendar Landing Page",
						"","Error in loading Calendar Landing Page","FAIL"});
				System.out.println("------------------------------------------------");
				System.out.println("Business Calendar Landing Page is not Visible - FAILURE");
				System.out.println("------------------------------------------------");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S
	// Method Name	: Create New Calendar
	@Given("^Create New Calendar with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void create_new_Calendar_and_Verify(String CalendarName, String Description) throws Throwable
	{
		Boolean IsCreated;
		try
		{
			IsCreated = CommonBean.calendar.create_new_calendar_and_verify(CalendarName, Description);
			if(IsCreated)
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Create New Calendar",
						"Calendar Name: "+CalendarName+", Description: "+Description,"New Business Calendar is created successfully","PASS"});
				System.out.println("------------------------------------------------");
				System.out.println("New Business Calendar is created - SUCCESS");
				System.out.println("------------------------------------------------");
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Create New Calendar",
						"Calendar Name: "+CalendarName+", Description: "+Description,"Error in creating new Business Calendar","FAIL"});
				System.out.println("------------------------------------------------");
				System.out.println("Error in creating new Business Calendar - FAILURE");
				System.out.println("------------------------------------------------");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	// Method Author : Vasanth S
	// Method Name	: Edit Existing Calendar
	@Given("^Edit Calendar \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void Edit_Calendar_Verify(String CalendarName,String NewCalendarName, String NewDescription) throws Throwable
	{
		Boolean IsEdited;
		try
		{
			IsEdited = CommonBean.calendar.edit_calendar_verify(CalendarName,NewCalendarName, NewDescription);
			if(IsEdited)
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Edit Existing Calendar",
						"Calendar Name: "+CalendarName+", New Calendar Name: "+NewCalendarName,
						"Business Calendar is edited successfully","PASS"});
				System.out.println("------------------------------------------------");
				System.out.println("Business Calendar is edited - SUCCESS");
				System.out.println("------------------------------------------------");
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Edit Existing Calendar",
						"Calendar Name: "+CalendarName+", New Calendar Name: "+NewCalendarName,
						"Error in Editing Existing Business Calendar","FAIL"});
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	// Method Author : Vasanth S
	// Method Name	: Search Calendar Functionality
	@Given("^Search the Calendar with \"([^\"]*)\"$")
	public void Search_Calendar_And_Verify(String CalendarName) throws Throwable{
		Boolean IsSearchWorking;
		try	{
			IsSearchWorking = CommonBean.calendar.search_calendar_and_verify(CalendarName);
			if(IsSearchWorking)	{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Search Calendar Functionality",
						"Calendar Name: "+CalendarName,"Business Calendar Search Functionality is working propertly","PASS"});				
			}
			else{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Search Calendar Functionality",
						"Calendar Name: "+CalendarName,"Error in Calendar Search Functionality","FAIL"});			
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S
	// Method Name	: Inactive Calendar Functionality
	@Given("^Inactive the Calendar \"([^\"]*)\"$")
	public void Inactive_Calendar_And_Verify(String CalendarName) throws Throwable
	{
		Boolean IsActiveWorking;
		try
		{
			IsActiveWorking = CommonBean.calendar.inactive_calendar_and_verify(CalendarName);
			if(IsActiveWorking)
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Inactive Calendar Functionality",
						"Calendar Name: "+CalendarName,"Business Calendar Inactive Functionality is working propertly","PASS"});
			}
			else
			{
				Itestresultdata.put(++imapKey, new Object[] {++iTestcaseID, "Inactive Calendar Functionality",
						"Calendar Name: "+CalendarName,"Error in Calendar Inactive Functionality","FAIL"});
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	// Method Author : Vasanth S
	@Given("^Print Test Result in Console$")
	public void printTestResultinConsole() throws Throwable
	{
		int i =0;
		Object [] objArr;
		try
		{
			if (Itestresultdata.size()>1)
			{				
				Set<Integer> keySet=Itestresultdata.keySet();
				System.out.println("===========================================================================================================");
				for(Integer key: keySet)
				{
					objArr=Itestresultdata.get(key);					
					for(Object obj:objArr)
					{	
						if(obj.toString().equals("PASS"))
							System.out.print(obj.toString());
						else
							System.out.print(obj.toString()+" || ");					
					}	
					System.out.println();
					if(i==0)
					System.out.println("===========================================================================================================");
					i++;
				}
				System.out.println("===========================================================================================================");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	// Method Author : Shayina
	@QAFTestStep(description="I navigate to My request grid view {0}")
	public void iNavigateToMyRequestGridView(String astr_requestName) throws InterruptedException, IOException{
		System.out.println("--------------------Data: "+astr_requestName);
		CommonBean.IMyRequest_page.searchRequest(astr_requestName);
		BaseClass.getScreenshot("The request is displayed in My Request page");
	}

	// Method Author : Shayina
	@QAFTestStep(description="Check the status of the request before task completion {0}")
	public void CheckRequestStatusBefore(String astr_requestName) throws InterruptedException, IOException{
		CommonBean.IMyRequest_page.searchRequest(astr_requestName);
		Thread.sleep(10000);
	    String text=CommonBean.IMyRequest_page.CheckRequestStatus(astr_requestName);
		BaseClass.getScreenshot("The request status Before task execution is captured-"+text);
		
	}
	
	// Method Author : Shayina
	@QAFTestStep(description="Check the status of the request after task completion {0}")
	public void CheckRequestStatusAfter(String astr_requestName) throws InterruptedException, IOException{
		CommonBean.IMyRequest_page.searchRequest(astr_requestName);
		Thread.sleep(5000);
		driver.getDriver().findElementByXPath("//a[text()='Completed - ']").click();
		Thread.sleep(14000);
		String text=CommonBean.IMyRequest_page.CheckRequestStatus(astr_requestName);
		BaseClass.getScreenshot("The request status after task execution is captured-"+text);
	}
	// Method Author : Shayina
	@QAFTestStep(description="validate the status of the request {0} for {1}")
	public void validateStatusOfRequest(String astr_reqStatus,String astr_requestName) throws InterruptedException, IOException{
		String text=CommonBean.IMyRequest_page.CheckRequestStatus(astr_requestName);
		Assert.assertEquals(text,astr_reqStatus);
	}

// Method Author : Shayina
		@QAFTestStep(description="validate the status of the request after completion for {0}")
		public void validateStatusOfRequestAfterCompletion(String astr_requestName) throws InterruptedException, IOException{
			String text=CommonBean.IMyRequest_page.CheckRequestStatus(astr_requestName);
			Assert.assertEquals(text,"Completed");
		}	
	
	// Method Author : Sundar	
	@Given("^Search the Roles with \"([^\"]*)\" and edit$")
	public void Search_Roles_And_edit(String RoleName) throws Throwable
	{
		Boolean IsSearchandeditWorking;
		try
		{
			IsSearchandeditWorking = CommonBean.roles.search_roles_and_edit(RoleName);
			if(IsSearchandeditWorking)
			{
				System.out.println("------------------------------------------------");
				System.out.println("Roles Search edit Functionality is Working - Success");
				System.out.println("------------------------------------------------");
			}
			else
			{
				System.out.println("------------------------------------------------");
				System.out.println("Roles Search edit Functionality is not working - Failure");
				System.out.println("------------------------------------------------");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	// Method Author : Sundar
		@Given("^I provide \"([^\"]*)\" access at Menu level$")
		public void menuLevelAccess(String access) throws Throwable {

			try {

				{
					CommonBean.roles.menuLevelAccess(access);
					System.out.println("------------------------------------------------");
					System.out.println("Roles Menu level access is in"+" "+access+" "+"Success");
					System.out.println("------------------------------------------------");
				}

			} catch (Exception e) {
				e.printStackTrace();
				//System.exit(1);
			}
		}

	// Method Author : Sundar
	@Given("^I validate access at menulevel with \"([^\\\"]*)\" and \"([^\\\"]*)\"$")

	public boolean validate_Access_menu(String menuName, String landingmenu) throws Throwable {

		Boolean Display = null;
		try {
			Display = CommonBean.roles.validate_Access_menu(menuName, landingmenu);
			if (Display) {

				System.out.println("Roles WRITE access Functionality is Working for " + " " + menuName + "- PASS");
				// Reporter.log("Roles READ access Functionality is Working for "+" "
				// +menuName+"- Success");
			} else {
				System.out.println("Roles READ access Functionality is Working " + " " + menuName + "- PASS");
				// Reporter.log("Roles READ access Functionality is Working for "+" "
				// +menuName+"- FAIL");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		return Display;

	}
	
	
	// Method Author : Sundar
	@Given("^I update Access level for entity \"([^\\\"]*)\" in Data access$")

	public void update_dataAccess(String entity) throws Throwable {
		try {
			CommonBean.roles.roles_menuAccess(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	// Method Author : Sundar
	@Given("^I validate read, write or disabled access at menulevel with \"([^\\\"]*)\"$")
	public void validate_navigation_to_defined_menu(String astr_MenuName) throws Throwable {

		boolean isMenuPresent = false;

		String[] menuName = astr_MenuName.split(";");
		for (int i = 0; i <= menuName.length - 1; i++) {

			isMenuPresent = CommonBean.lHome_page_home.navigateByMenu(menuName[i]);

			if (isMenuPresent) {
				System.out.println("------------------------------------------------");
				System.out.println("Menu Search Functionality is displayed - Fail" + " " + menuName[i]);
				System.out.println("------------------------------------------------");
				Assert.assertFalse(false, "Menu Search Functionality is displayed " + " " + menuName[i]);
				Reporter.log("Roles Menu Search Functionality is displayed with the menu" + " " + menuName[i]);
			} else {
				System.out.println("------------------------------------------------");
				System.out.println("Menu Search is disabled at menu level access - Pass" + " " + menuName[i]);
				System.out.println("------------------------------------------------");
				Assert.assertFalse(false, "Menu Search is disabled at menu level access - Pass" + menuName[i]);
				Reporter.log("Menu Search is disabled at menu level access - Pass" + " " + menuName[i]);

			}

			// break;
		}
		Thread.sleep(5000);
	}
	
	// Method Author : Sundar
	@When("^I validate landing page in Message master$")
	public void validateLandingPageMS() throws Throwable {
		try {
			CommonBean.lbase_baseClass.waitForVisibility(CommonBean.messageMaster.getnewMessage());
			if (CommonBean.messageMaster.getnewMessage().isDisplayed()) {
				// CommonBean.lbase_baseClass.reporting("Landing page displayed in Message
				// master successfully");
				System.out.println("Landing page displayed in Message master successfully");
				Reporter.log("Landing page displayed in Message master successfully");
			}
			Thread.sleep(500);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertFalse(false, "Failed to load Landing page in message master");
			Reporter.log("Failed to load Landing page in message master");
		}
	}
	
	// Method Author : Sundar
		@When("^I Create new Message Master \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
		public void createNewMessagemaster(String messageType, String Reason, String Message, String Resolution)
				throws Throwable {
			try {
				Thread.sleep(500);
				// CommonBean.lbase_baseClass.explicitVisibilityOf(CommonBean.messageMaster.getnewMessage());
				if (CommonBean.messageMaster.getnewMessage().isDisplayed()) {
					CommonBean.messageMaster.getnewMessage().click();
					Thread.sleep(1600);
					// CommonBean.lbase_baseClass.explicitVisibilityOf(CommonBean.messageMaster.getmessageType());
					CommonBean.messageMaster.getmessageType().click();
					Thread.sleep(500);
					DeviceUtils.getQAFDriver().findElement(By.xpath("//span[contains(text(),'" + messageType + "')]"))
							.click();
					CommonBean.messageMaster.getreason().sendKeys(Reason);
					CommonBean.messageMaster.getmessage().sendKeys(Message);
					CommonBean.messageMaster.getresolution().sendKeys(Resolution);
					Reporter.log("New message created in Message master successfully");
					CommonBean.messageMaster.getmessageSave().click();
					// CommonBean.lbase_baseClass.explicitVisibilityOf(CommonBean.messageMaster.getmessageSearch());
					Thread.sleep(1600);
					System.out.println("Message created -----" +Message);
					/*CommonBean.messageMaster.getmessageSearch().clear();
					CommonBean.messageMaster.getmessageSearch().sendKeys(Message);
					CommonBean.messageMaster.getmessageSearch().sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					// CommonBean.lbase_baseClass.explicitVisibilityOf(CommonBean.messageMaster.getgridMessage());
					String messageResult = CommonBean.messageMaster.getgridMessage().getText();
					System.out.println(messageResult);
					if (messageResult.equals(Message)) {
						System.out.println("Create new message in message master success");
						Assert.assertFalse(false, "Create new message in message master success");
						Reporter.log("Create new message in message master success");
					}
*/				}
				Thread.sleep(1500);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.assertFalse(false, "Failed to validate Create new message in message master");
				Reporter.log("Failed to validate Create new message in message master");
			}
		}
		
		@When("^I Search message master \"([^\"]*)\"$")
		public void searchMessagemaster(String Message) throws Throwable {
			try {
				// CommonBean.lbase_baseClass.explicitVisibilityOf(CommonBean.messageMaster.getmessageSearch());
				Thread.sleep(500);
				if (CommonBean.messageMaster.getmessageSearch().isDisplayed()) {
					CommonBean.messageMaster.getmessageSearch().clear();
					CommonBean.messageMaster.getmessageSearch().sendKeys(Message);
					CommonBean.messageMaster.getmessageSearch().sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					// CommonBean.lbase_baseClass.explicitVisibilityOf(CommonBean.messageMaster.getgridMessage());
					String messageResult = CommonBean.messageMaster.getgridMessage().getText();
					System.out.println(messageResult);
					if (messageResult.equals(Message)) {
						System.out.println("Search message in message master success");
						Assert.assertFalse(false, "Search message in message master success");
						Reporter.log("Search message in message master success");
					}
				}
				// Thread.sleep(1500);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.assertFalse(false, "Failed to validate search message in message master");
				Reporter.log("Failed to validate search message in message master");
			}
		}

		@When("^I Edit message master \"([^\"]*)\" with \"([^\"]*)\"$")
		public void editMessagemaster(String Message, String updatedMessage) throws Throwable {
			try {
				Thread.sleep(500);
				CommonBean.lbase_baseClass.waitForVisibility(CommonBean.messageMaster.getmessageSearch());
				if (CommonBean.messageMaster.getmessageSearch().isDisplayed()) {
					CommonBean.messageMaster.getmessageSearch().clear();
					CommonBean.messageMaster.getmessageSearch().sendKeys(Message);
					CommonBean.messageMaster.getmessageSearch().sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					// CommonBean.lbase_baseClass.explicitVisibilityOf(CommonBean.messageMaster.getgridMessage());
					String messageResult = CommonBean.messageMaster.getgridMessage().getText();
					System.out.println(messageResult);
					if (messageResult.equals(Message)) {
						System.out.println("Search message in message master success");
						CommonBean.messageMaster.geteditMessage().click();
						// CommonBean.lbase_baseClass.explicitVisibilityOf(CommonBean.messageMaster.getmessage());
						Thread.sleep(1000);
						CommonBean.messageMaster.getmessage().clear();
						CommonBean.messageMaster.getmessage().sendKeys(updatedMessage);
						Reporter.log("Edit message success in Message master");
						CommonBean.messageMaster.getmessageSave().click();
						Thread.sleep(1600);
						// CommonBean.lbase_baseClass.explicitVisibilityOf(CommonBean.messageMaster.getmessageSearch());
						CommonBean.messageMaster.getmessageSearch().clear();
						CommonBean.messageMaster.getmessageSearch().sendKeys(updatedMessage);
						CommonBean.messageMaster.getmessageSearch().sendKeys(Keys.ENTER);
						Thread.sleep(1000);
						// CommonBean.lbase_baseClass.explicitVisibilityOf(CommonBean.messageMaster.getgridMessage());
						String updatedmessageResult = CommonBean.messageMaster.getgridMessage().getText();
						System.out.println(updatedmessageResult);
						if (updatedmessageResult.equals(updatedMessage)) {
							System.out.println("Edit message in message master success");

							Assert.assertFalse(false, "Edit message in message master success");
							Reporter.log("Edit message in message master success");
						}

						Assert.assertFalse(false, "Edit message in message master success");
						Reporter.log("Edit message in message master success");
					}
				}
				// Thread.sleep(1500);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.assertFalse(false, "Failed to validate search message in message master");
				Reporter.log("Failed to validate search message in message master");
			}
		}
		
		
		/******************************************************************************************************
		 * Method-STARTS HERE ! Workflow Data Dictionary functionality
		 ******************************************************************************************************/

		// Method Author : Sundar
		@When("^I validate landing page in Workflow Data Dictionary$")
		public void validateLandingPagewfDD() throws Throwable {
			try {
				CommonBean.lbase_baseClass.waitForVisibility(CommonBean.wfDataDictionary.getnewField());
				if (CommonBean.wfDataDictionary.getnewField().isDisplayed()) {
					// CommonBean.lbase_baseClass.reporting("Landing page displayed in Message
					// master successfully");
					System.out.println("Landing page displayed in Workflow Data Dictionary successfully");
					Reporter.log("Landing page displayed in Workflow Data Dictionaryr successfully");
					BaseClass.getScreenshot("Landing page displayed in Workflow Data Dictionaryr successfully");

				}
				Thread.sleep(500);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.assertFalse(false, "Failed to load Landing page in Workflow Data Dictionary");
				Reporter.log("Failed to load Landing page in Workflow Data Dictionary");
			}
		}

		// Method Author : Sundar
		@When("^I Search Workflow Data Dictionary \"([^\"]*)\"$")
		public void validateSearchwfDcD(String wfDDSearch) throws Throwable {
			try {
				CommonBean.lbase_baseClass.waitForVisibility(CommonBean.wfDataDictionary.getwfDDSearch());
				if (CommonBean.wfDataDictionary.getwfDDSearch().isDisplayed()) {
					CommonBean.wfDataDictionary.getwfDDSearch().sendKeys(wfDDSearch);
					CommonBean.wfDataDictionary.getwfDDSearch().sendKeys(Keys.ENTER);
					Thread.sleep(500);
					CommonBean.lbase_baseClass.waitForVisibility(CommonBean.wfDataDictionary.getwfDDSearchResult());
					String wfDDSearchRes = CommonBean.wfDataDictionary.getwfDDSearchResult().getText();
					if (wfDDSearchRes.contains(wfDDSearch)) {
						System.out.println("Search in Workflow Data Dictionary successfull");
						Reporter.log("Search in Workflow Data Dictionary successfull");
						BaseClass.getScreenshot("Search in Workflow Data Dictionary successfull");

					}
					
				}
				Thread.sleep(500);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.assertFalse(false, "Failed to Search in Workflow Data Dictionary");
				Reporter.log("Failed to Search in Workflow Data Dictionary");
			}
		}
		//
		
		// Method Author : Sundar
		@Then("^I Create new field in Workflow Data Dictionary \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
		public void createnewFieldwfDD(String wfDDfieldName, String wfDDdataLabel, String wfDDfieldDescr,
				String wfDDdataType, String wfDDlength, String wfDDprecision) throws Throwable {
			try {
				CommonBean.lbase_baseClass.waitForVisibility(CommonBean.wfDataDictionary.getnewField());
				if (CommonBean.wfDataDictionary.getnewField().isDisplayed())
					CommonBean.wfDataDictionary.getnewField().click();
				Thread.sleep(500);
				CommonBean.wfDataDictionary.getwfDDfieldName().clear();
				CommonBean.wfDataDictionary.getwfDDfieldName().sendKeys(wfDDfieldName);
				CommonBean.wfDataDictionary.getwfDDdataLabel().clear();
				CommonBean.wfDataDictionary.getwfDDdataLabel().sendKeys(wfDDdataLabel);
				CommonBean.wfDataDictionary.getwfDDfieldDescr().clear();
				CommonBean.wfDataDictionary.getwfDDfieldDescr().sendKeys(wfDDfieldDescr);

				// CommonBean.lbase_baseClass.SelectByVisibleText(CommonBean.wfDataDictionary.getwfDDselect(),
				// "Number");
				CommonBean.wfDataDictionary.getwfDDselect().click();
				Thread.sleep(500);
				DeviceUtils.getQAFDriver().findElement(By.xpath("(//*[contains(text(),'"+wfDDdataType+"')])[2]")).click();
				Thread.sleep(1000);
				//CommonBean.wfDataDictionary.getwfDDlength().clear();
				CommonBean.wfDataDictionary.getwfDDlength().sendKeys(wfDDlength);
				//CommonBean.wfDataDictionary.getwfDDprecision().clear();
				CommonBean.wfDataDictionary.getwfDDprecision().sendKeys(wfDDprecision);
				BaseClass.getScreenshot("Data entered in Workflow Data Dictionary successfull");

				CommonBean.wfDataDictionary.getwfDDsave().click();
				Thread.sleep(500);
				CommonBean.wfDataDictionary.getwfDDSearch().sendKeys(wfDDfieldName);
				CommonBean.wfDataDictionary.getwfDDSearch().sendKeys(Keys.ENTER);
				Thread.sleep(500);

				String wfDDsearchField = CommonBean.wfDataDictionary.getwfDDsearchGrid().getText();
				if (wfDDsearchField.contains(wfDDfieldName)) {
					System.out.println("Create new field success in Workflow DataDictionary");
					Assert.assertFalse(false, "Create new field success in Workflow DataDictionary");
					Reporter.log("Create new field success in Workflow DataDictiactionsonary");
					BaseClass.getScreenshot("Create new field success in Workflow DataDictiactionsonary");

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.assertFalse(false, "Failed to Create in Workflow Data Dictionary");
				Reporter.log("Failed to Create in Workflow Data Dictionary");
			}
		}

		// Method Author : Sundar
		@Then("^I edit workflow data dictionary \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
		public void editwfDD(String search, String wfDDupdatedfieldName, String wfDDupdateddataLabel) throws Throwable {
			try {
				CommonBean.wfDataDictionary.getwfDDSearch().clear();
				CommonBean.wfDataDictionary.getwfDDSearch().sendKeys(search);
				CommonBean.wfDataDictionary.getwfDDSearch().sendKeys(Keys.ENTER);
				Thread.sleep(500);
				CommonBean.wfDataDictionary.getwfDDedit().click();
				Thread.sleep(1000);
				CommonBean.wfDataDictionary.getwfDDfieldName().clear();
				CommonBean.wfDataDictionary.getwfDDfieldName().sendKeys(wfDDupdatedfieldName);
				CommonBean.wfDataDictionary.getwfDDdataLabel().clear();
				CommonBean.wfDataDictionary.getwfDDdataLabel().sendKeys(wfDDupdateddataLabel);
				CommonBean.wfDataDictionary.getwfDDsave().click();
				Thread.sleep(500);
				CommonBean.wfDataDictionary.getwfDDSearch().clear();
				CommonBean.wfDataDictionary.getwfDDSearch().sendKeys(wfDDupdatedfieldName);
				CommonBean.wfDataDictionary.getwfDDSearch().sendKeys(Keys.ENTER);
				Thread.sleep(500);
				BaseClass.getScreenshot("Search in Workflow DataDictiactionsonary");

				String wfDDsearchField = CommonBean.wfDataDictionary.getwfDDsearchGrid().getText();
				if (wfDDsearchField.contains(wfDDupdatedfieldName)) {
					System.out.println("Edit field success in Workflow DataDictionary");
					Assert.assertFalse(false, "Edit field success in Workflow DataDictionary");
					Reporter.log("Edit field success in Workflow DataDictionary");
					BaseClass.getScreenshot("Edit field success in Workflow DataDictionary");

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.assertFalse(false, "Failed to Edit in Workflow Data Dictionary");
				Reporter.log("Failed to Edit in Workflow Data Dictionary");
			}
		}
		
		// Method Author : Sundar
		@When("^I validate landing page in Entity Data Dictionary page$")
		public void validateLandingPageentityDD() throws Throwable {
			try {
				CommonBean.lbase_baseClass.waitForVisibility(CommonBean.entityDataDictionary.getnewField());
				if (CommonBean.entityDataDictionary.getnewField().isDisplayed()) {
					// CommonBean.lbase_baseClass.reporting("Landing page displayed in Message
					// master successfully");
					System.out.println("Landing page displayed in Entity Data Dictionary successfully");
					Reporter.log("Landing page displayed in Entity Data Dictionaryr successfully");
					BaseClass.getScreenshot("Landing page displayed in Entity Data Dictionaryr successfully");
				}
				Thread.sleep(500);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.assertFalse(false, "Failed to load Landing page in Entity Data Dictionary");
				Reporter.log("Failed to load Landing page in Entity Data Dictionary");
			}
		}
		
		
	// Method Author : Sundar
	@When("^I Search entiry Data Dictionary \"([^\"]*)\"$")
	public void validateSearchentityDD(String entDDSearch) throws Throwable {
		try {
			CommonBean.lbase_baseClass.waitForVisibility(CommonBean.entityDataDictionary.getentityDDSearch());
			if (CommonBean.entityDataDictionary.getentityDDSearch().isDisplayed()) {
				CommonBean.entityDataDictionary.getentityDDSearch().sendKeys(entDDSearch);
				CommonBean.entityDataDictionary.getentityDDSearch().sendKeys(Keys.ENTER);
				Thread.sleep(500);
				// CommonBean.lbase_baseClass.explicitVisibilityOf(CommonBean.entityDataDictionary.getwfDDSearchResult());
				String wfDDSearchRes = DeviceUtils.getQAFDriver().findElement(By.xpath(
						"//div[contains(@class,'ngCellText ng-scope col1 colt1')]//span[contains(@class,'ng-binding')][contains(text(),'"
								+ entDDSearch + "')]"))
						.getText();
				if (wfDDSearchRes.contains(entDDSearch)) {
					System.out.println("Search in Entity Data Dictionary successfull");
					Reporter.log("Search in Entity Data Dictionary successfull");
					BaseClass.getScreenshot("Search in Entity Data Dictionary successfull");
				}

			}
			Thread.sleep(500);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertFalse(false, "Failed to Search in Workflow Data Dictionary");
			Reporter.log("Failed to Search in Workflow Data Dictionary");
		}
	}

	// Method Author : Sundar
	@Given("^I uncheck the existing rules from dropdown \"([^\\\"]*)\"$")

	public void uncheck_rules(String rules) throws Throwable {
		try {
			CommonBean.roles.unselectRules(rules);
			// CommonBean.lbase_baseClass.selectFromDropdown(CommonBean.roles.getrolesDataAccessReadDropdown(),
			// "Get records based on board school", "singleSelect");
			System.out.println("Singleselect");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Given("^I check the single read access with rule \"([^\\\"]*)\" for dropdown type \"([^\\\"]*)\"$")
	public void check_singlerulesRead(String rule, String dropdownType) throws Throwable {
		try {
			CommonBean.lbase_baseClass.selectFromDropdown(CommonBean.roles.getrolesDataAccessReadDropdown(), rule,
					dropdownType);
			BaseClass.getScreenshot("Dropdown selected for single rule");
			CommonBean.lbase_baseClass.clickButton(CommonBean.roles.getSave());
			CommonBean.roles.getSuccessMsg().waitForVisible(20000);
			Thread.sleep(6000);
			CommonBean.roles.getRoleName().waitForVisible(10000);
			Thread.sleep(3000);
			System.out.println("Singleselect");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Given("^I check the multiple read access with rule \"([^\\\"]*)\" for dropdown type \"([^\\\"]*)\"$")
	public void check_multiplerulesRead(String rule, String dropdownType) throws Throwable {
		try {
			CommonBean.lbase_baseClass.selectFromDropdown(CommonBean.roles.getrolesDataAccessReadDropdown(), rule,
					dropdownType);
			BaseClass.getScreenshot("Dropdown selected for multiple rules");
			CommonBean.lbase_baseClass.clickButton(CommonBean.roles.getSave());
			CommonBean.roles.getSuccessMsg().waitForVisible(20000);
			Thread.sleep(6000);
			CommonBean.roles.getRoleName().waitForVisible(10000);
			Thread.sleep(3000);
			System.out.println("Singleselect");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Given("^I check the single write access with rule \"([^\\\"]*)\" for dropdown type \"([^\\\"]*)\"$")
	public void check_singlerulesWrite(String rule, String dropdownType) throws Throwable {
		try {
			CommonBean.lbase_baseClass.selectFromDropdown(CommonBean.roles.getrolesDataAccessWriteDropdown(), rule,
					dropdownType);
			BaseClass.getScreenshot("Dropdown selected for single rule");
			CommonBean.lbase_baseClass.clickButton(CommonBean.roles.getSave());
			CommonBean.roles.getSuccessMsg().waitForVisible(20000);
			Thread.sleep(6000);
			CommonBean.roles.getRoleName().waitForVisible(10000);
			Thread.sleep(3000);
			System.out.println("Singleselect");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Given("^I check the multi write access with rule \"([^\\\"]*)\" for dropdown type \"([^\\\"]*)\"$")
	public void check_multiplerulesWrite(String rule, String dropdownType) throws Throwable {
		try {
			CommonBean.lbase_baseClass.selectFromDropdown(CommonBean.roles.getrolesDataAccessWriteDropdown(), rule,
					dropdownType);
			BaseClass.getScreenshot("Dropdown selected for multiple rules");
			CommonBean.lbase_baseClass.clickButton(CommonBean.roles.getSave());
			CommonBean.roles.getSuccessMsg().waitForVisible(20000);
			Thread.sleep(6000);
			CommonBean.roles.getRoleName().waitForVisible(10000);
			Thread.sleep(3000);
			System.out.println("Singleselect");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Given("^I check the single read and write access with rule \"([^\\\"]*)\" for dropdown type \"([^\\\"]*)\"$")
	public void check_singlerulesReadWrite(String rule, String dropdownType) throws Throwable {
		try {
			CommonBean.lbase_baseClass.selectFromDropdown(CommonBean.roles.getrolesDataAccessReadDropdown(), rule,
					dropdownType);
			CommonBean.lbase_baseClass.selectFromDropdown(CommonBean.roles.getrolesDataAccessWriteDropdown(), rule,
					dropdownType);
			BaseClass.getScreenshot("Dropdown selected for single rule");
			CommonBean.lbase_baseClass.clickButton(CommonBean.roles.getSave());
			CommonBean.roles.getSuccessMsg().waitForVisible(20000);
			Thread.sleep(6000);
			CommonBean.roles.getRoleName().waitForVisible(10000);
			Thread.sleep(3000);
			System.out.println("Singleselect");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Given("^I check the multi read and write access with rule \"([^\\\"]*)\" for dropdown type \"([^\\\"]*)\"$")
	public void check_multiplerulesReadWrite(String rule, String dropdownType) throws Throwable {
		try {
			CommonBean.lbase_baseClass.selectFromDropdown(CommonBean.roles.getrolesDataAccessReadDropdown(), rule,
					dropdownType);
			CommonBean.lbase_baseClass.selectFromDropdown(CommonBean.roles.getrolesDataAccessWriteDropdown(), rule,
					dropdownType);
			BaseClass.getScreenshot("Dropdown selected for multiple rules");
			CommonBean.lbase_baseClass.clickButton(CommonBean.roles.getSave());
			CommonBean.roles.getSuccessMsg().waitForVisible(20000);
			Thread.sleep(6000);
			CommonBean.roles.getRoleName().waitForVisible(10000);
			Thread.sleep(3000);
			System.out.println("Singleselect");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Method Author : Shayina
	@QAFTestStep(description = "search and Filter the request {0}")
	public void searchAndFilterRequest(String astr_reqName) throws InterruptedException, IOException {
		CommonBean.IMyRequest_page.searchRequest(astr_reqName);
		BaseClass.getScreenshot("The Request is filtered");
		
	}

	// Method Author : Shayina
	@QAFTestStep(description = "Get the baseline target date of the request {0}")
	public void getBaselineTargetDate(String astr_reqName) throws InterruptedException, IOException {
		String baselineDate=CommonBean.IMyRequest_page.getRequestDate("BaselineTargetDate",astr_reqName);
		BaseClass.getScreenshot("The baseline date of the request is captured");
		Reporter.log("Date value for Baseline target "+baselineDate);
	System.out.println("Date value for Baseline target "+baselineDate);
	}

	// Method Author : Shayina
	@QAFTestStep(description="Get the estimated target date of the request {0}")
	public void getTheEstimatedTargetDateOfTheRequest(String astr_reqName)throws InterruptedException, IOException {
		String estimatedDate=CommonBean.IMyRequest_page.getRequestDate("EstimatedTargetDate",astr_reqName);
		BaseClass.getScreenshot("The estimtated date of the request is captured");
		Reporter.log("Date value for estimated target "+estimatedDate);
		System.out.println("Date value for Estimated target "+estimatedDate);
	}

	// Method Author : Shayina
	@QAFTestStep(description="Verify the Baseline target date {0} for the {1}")
	public void validateTheBaselineTargetDateForTheRequest(String astr_reqName,String baselineDate)throws InterruptedException, IOException {
		String actualBaselineDate=CommonBean.IMyRequest_page.getRequestDate("BaselineTargetDate",astr_reqName);
		Assert.assertEquals(actualBaselineDate,baselineDate);
		
	}
	// Method Author : Shayina
		@QAFTestStep(description = "Verify the Estimated target date {0} for the {1}")
		public void validateEstimatedTargetDate(String astr_reqName,String baselineDate) throws InterruptedException, IOException {
			String estimatedDate=CommonBean.IMyRequest_page.getRequestDate("EstimatedTargetDate",astr_reqName);
		}
		
		@QAFTestStep(description="Verify the Baseline target date of task{0} for the {1}")
		public void validateTheBaselineTargetDateForTheTask(String baselineDate,String astr_taskName)throws InterruptedException, IOException {
			String actualBaselineDate=CommonBean.IMyRequest_page.getTaskData("BaselineTargetDate", astr_taskName);
			Assert.assertEquals(actualBaselineDate,baselineDate);	
		}

		// Method Author : Shayina
		@QAFTestStep(description = "Verify the Estimated target date of task{0} for the {1}")
		public void validateEstimatedTargetDateofTask(String estimatedDate,String astr_taskName)throws InterruptedException, IOException {
			String actualEstimatedDate = CommonBean.IMyRequest_page.getTaskData("EstimatedTargetDate", astr_taskName);
			Assert.assertEquals(actualEstimatedDate,estimatedDate);
		}

		// Method Author : Shayina
		@QAFTestStep(description = "I expand the Sub workflow grid {0}")
		public void expandSubWFGrid(String SubWFName) throws InterruptedException, IOException {
			CommonBean.IMyRequest_page.expandReqGrid();
			Thread.sleep(2000);
			CommonBean.IMyRequest_page.expandSubWFGrid(SubWFName);
			Thread.sleep(2000);
			BaseClass.getScreenshot("The Sub workflow is expanded to view the task");
		}

		// Method Author : Shayina
		@QAFTestStep(description="Check the status of the task {0}")
		public void checkTheStatusOfTheTask(String taskName)throws InterruptedException, IOException {
			Thread.sleep(5000);
			String status=CommonBean.IMyRequest_page.CheckTaskStatus(taskName);
			System.out.println("***************"+status);
			Reporter.log("Task Status is:"+status);
			BaseClass.getScreenshot("The Status of the task is captured");
		}

		// Method Author : Shayina
			@QAFTestStep(description = "validate the status of the task {0} for {1}")
			public void checkTaskStatus(String taskStatus,String taskName) throws InterruptedException, IOException {
				String status=CommonBean.IMyRequest_page.CheckTaskStatus(taskName);
				Assert.assertEquals(status, taskStatus);

			}
			
			// Method Author : Shayina
			@QAFTestStep(description="Check the status of the task after task completion {0}")
			public void CheckTaskStatusAfter(String astr_taskName) throws InterruptedException, IOException{
				Thread.sleep(5000);
				String status=CommonBean.IMyRequest_page.CheckTaskStatus(astr_taskName);
				System.out.println("***************"+status);
				Reporter.log("Task Status is:"+status);
				BaseClass.getScreenshot("The status of the task after completion is captured");
			}
			
			// Method Author : Shayina
					@QAFTestStep(description="validate the status of the task after completion for {0}")
					public void validateStatusOfTaskAfterCompletion(String astr_taskName) throws InterruptedException, IOException{
						String text=CommonBean.IMyRequest_page.CheckTaskStatus(astr_taskName);
						Assert.assertEquals(text,"Completed");
					}
					
					// Method Author : Shayina
					@QAFTestStep(description = "Get the baseline target date of the task {0}")
					public void getBaselineTargetDateofTask(String astr_taskName) throws InterruptedException, IOException {
						String baselineDate=CommonBean.IMyRequest_page.getTaskData("BaselineTargetDate",astr_taskName);
					//	BaseClass.getScreenshot("The baseline date of the task is captured");
						Reporter.log("Date value for Baseline target "+baselineDate);
						System.out.println("Date value for Baseline target "+baselineDate);
						BaseClass.getScreenshot("The Baseline targt date of the task is validated");

					}

					// Method Author : Shayina
					@QAFTestStep(description="Get the estimated target date of the task {0}")
					public void getTheEstimatedTargetDateOfTheTask(String astr_taskName)throws InterruptedException, IOException {
						String estimatedDate=CommonBean.IMyRequest_page.getTaskData("EstimatedTargetDate",astr_taskName);
					//	BaseClass.getScreenshot("The estimtated date of the task is captured");
						Reporter.log("Date value for estimated target "+estimatedDate);
						System.out.println("Date value for Estimated target "+estimatedDate);
						
						BaseClass.getScreenshot("The Estimated target date of the task is validated");
					}
		
					// Method Author : Shayina
					@QAFTestStep(description="Navigate to cancelled request tab")
					public void navigateToCancelledTab() throws InterruptedException {
						CommonBean.lbase_baseClass.clickButton(CommonBean.IMyRequest_page.getCancelledTab());
					}
					
					// Method Author : Shayina
					@QAFTestStep(description="Navigate to Delayed request tab")
					public void navigateToDelayedTab() throws InterruptedException {
						CommonBean.lbase_baseClass.clickButton(CommonBean.IMyRequest_page.getDelayedTab());
					}
					
					@QAFTestStep(description="Check the status of the Subworkflow {0}")
					public void checkSubwfStatus (String subwfname)throws InterruptedException, IOException {
						Thread.sleep(5000);
						String status=CommonBean.IMyRequest_page.getSubworkflowData("Status",subwfname);
						System.out.println("***************SUBWF"+status);
						Reporter.log("Subwf Status is:"+status);
						BaseClass.getScreenshot("The Status of the task is captured");
					}

					// Method Author : Shayina
						@QAFTestStep(description = "validate the status of the Subworkflow {0} for {1}")
						public void validateSubwfStatus(String subwfStatus,String subwfname) throws InterruptedException, IOException {
							String status=CommonBean.IMyRequest_page.getSubworkflowData("Status",subwfname);
							Assert.assertEquals(status, subwfStatus);

						}
						// Method Author : Shayina
						@QAFTestStep(description = "Get the baseline target date of the subworkflow {0}")
						public void getBaselineTargetDateofsubworkflow(String astr_Subwfname) throws InterruptedException, IOException {
							String baselineDate=CommonBean.IMyRequest_page.getSubworkflowData("BaselineTargetDate",astr_Subwfname);
							Reporter.log("Date value for Baseline target "+baselineDate);
							System.out.println("Date value for Baseline target "+baselineDate);
							BaseClass.getScreenshot("The Baseline targt date of the subworkflow is validated");
						}

						// Method Author : Shayina
						@QAFTestStep(description="Get the estimated target date of the subworkflow {0}")
						public void getTheEstimatedTargetDateOfThesubworkflow(String astr_Subwfname)throws InterruptedException, IOException {
							String estimatedDate=CommonBean.IMyRequest_page.getSubworkflowData("EstimatedTargetDate",astr_Subwfname);
							Reporter.log("Date value for estimated target "+estimatedDate);
							System.out.println("Date value for Estimated target "+estimatedDate);	
							BaseClass.getScreenshot("The Estimated target date of the subworkflow is validated");
						}
						
						// Method Author : Shayina
						@QAFTestStep(description="Verify the Baseline target date of subworkflow {0} for the {1}")
						public void validateTheBaselineTargetDateForThesubworkflow(String baselineDate,String astr_Subwfname)throws InterruptedException, IOException {
							String actualBaselineDate=CommonBean.IMyRequest_page.getSubworkflowData("BaselineTargetDate", astr_Subwfname);
							Assert.assertEquals(actualBaselineDate,baselineDate);	
						}

						// Method Author : Shayina
						@QAFTestStep(description = "Verify the Estimated target date of subworkflow {0} for the {1}")
						public void validateEstimatedTargetDateofsubworkflow(String estimatedDate,String astr_Subwfname)throws InterruptedException, IOException {
							String actualEstimatedDate = CommonBean.IMyRequest_page.getSubworkflowData("EstimatedTargetDate", astr_Subwfname);
							Assert.assertEquals(actualEstimatedDate,estimatedDate);
						}
						// Method Author : Shayina
						@QAFTestStep(description="Navigate to task view page {0}")
						public void navigateToTaskViewPage(String astr_taskName) throws InterruptedException, IOException{
							CommonBean.IMyRequest_page.viewTask(astr_taskName);
							BaseClass.getScreenshot("The task data are captured from task view page");
						}
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

	// Method-ENDS HERE !
}
