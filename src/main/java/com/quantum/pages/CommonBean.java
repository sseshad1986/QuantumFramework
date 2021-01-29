package com.quantum.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.quantum.helper.BaseClass;
import com.quantum.helper.MultiLingual;
import com.quantum.helper.Xls_Reader;
import com.quantum.helper.nFlowsLibrary;
import com.quantum.poc.Nflows_Entity_Creation_POC;
import com.quantum.uobam.ReviewUOBAMManual_UserTask;


public class CommonBean extends WebDriverBaseTestPage<WebDriverTestPage>

{	
	public static  BaseClass lbase_baseClass = new BaseClass();
	public static Nflows_Login_page lLogin_page = new Nflows_Login_page();
	public static Nflows_Home_page lHome_page_home = new Nflows_Home_page();
	public static Nflows_Entity_Definition lEntity_Definition_entityDef = new Nflows_Entity_Definition();
	public static Nflows_RuleEngineDefinition_page lRule_Engine_Definition_ruleDefinition = new Nflows_RuleEngineDefinition_page();
	public static Nflows_MyRequest_page IMyRequest_page=new Nflows_MyRequest_page();
	public static Nflows_Widget_Definition IWidget_Definition=new Nflows_Widget_Definition();
	public static Nflows_MyTask_page IMyTask_Page=new Nflows_MyTask_page();
	public static Nflows_Document_Manager IDocument_Manager=new Nflows_Document_Manager();
	public static Nflows_Entity_Creation IEntity_Creation=new Nflows_Entity_Creation();
	public static  nFlowsLibrary projectLibrary = new nFlowsLibrary();
	public static Xls_Reader xls_reader=new Xls_Reader();
	public static ReviewUOBAMManual_UserTask reviewUOBAMManualTsk=new ReviewUOBAMManual_UserTask();
	public static Nflows_Admin_Roles roles = new Nflows_Admin_Roles();
	public static Nflows_Dropdown dropdown = new Nflows_Dropdown();
	public static Nflows_Business_Calendar calendar = new Nflows_Business_Calendar();
	public static Nflows_Report_Execution report_Execution = new Nflows_Report_Execution();
	public static Nflows_MyTask_Execution_page myTask_Execution = new Nflows_MyTask_Execution_page();
	public static Nflows_Task_Library ITask_Library=new Nflows_Task_Library();
	public static Nflows_MessageMaster messageMaster = new Nflows_MessageMaster();
	public static Nflows_WorkflowDataDictionary wfDataDictionary = new Nflows_WorkflowDataDictionary();
	public static Nflows_EntityDataDictionary entityDataDictionary = new Nflows_EntityDataDictionary();
	public static Nflows_Dashboard_Execution dashboardExecution = new Nflows_Dashboard_Execution();
	public static Nflows_Dashboard_Definition dasboardDefinition = new Nflows_Dashboard_Definition();
	public static Nflows_Report_Definition reportDefinition = new Nflows_Report_Definition();
	public static MultiLingual multiLingual=new MultiLingual();
	//public static WebDriverTestBase driver = new WebDriverTestBase();
	
	
	
	public static Nflows_Entity_Creation_POC IEntity_Creation_poc = new Nflows_Entity_Creation_POC();
	

	
	@Override
	protected void openPage(PageLocator locator, Object... args) 
	{
		// TODO Auto-generated method stub
		
	}
	

}
