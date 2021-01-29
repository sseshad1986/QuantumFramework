@Administrator
Feature: Administrator

@AD_00_LaunchNflows
  	Scenario Outline: Launching Nflows application
    Given I launch Nflows application using "<Url_Testing_v2>"
	Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}

@AD_01_NflowsLogin
  	Scenario Outline: Login to Nflows 
  	Given I login to Nflows with "<username>" and "<password>" credentials   
	Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Nflows_Login'} 
	    
@AD_02_Roles_Scenarios
  	Scenario Outline: To Verify Roles Functionality
	Given I navigate to "Roles" page
	And Verify Landing Page Grid
	And Create New Role with "<Create_RoleName>" and "<Create_Description>"
	And Edit Role "<Edit_RoleName>" with "<Edit_NewRoleName>" and "<Edit_NewDescription>"
	And Search the Roles with "<Search_RoleName>"
	And Inactive the Roles "<Inactive_RoleName>"	
    Examples: {'datafile' : 'src/main/resources/data/Administrator/Roles.xls','sheetName':'Roles'}

@AD_03_Dropdown_Scenarios
  	Scenario Outline: To Verify Dropdown Functionality
	Given I navigate to "Dropdown" page
	And Verify Dropdown Landing Page Grid
	And Create New Dropdown with "<Create_ListName>" and "<Create_ListValue1>"
	And Edit Dropdown "<Edit_ListName>" with "<Edit_NewListName>" and "<Edit_NewListValue1>"
	And Search the Dropdown with "<Search_ListName>"
	And Inactive the Dropdown "<Inactive_ListName>"	
    Examples: {'datafile' : 'src/main/resources/data/Administrator/Dropdown.xls','sheetName':'Dropdown'}

@AD_04_Business_Calendar_Scenarios
  	Scenario Outline: To Verify Business Calendar Functionality
	Given I navigate to "Business Calendar" page
	And Verify Calendar Landing Page Grid
	And Create New Calendar with "<Create_CalendarName>" and "<Create_Description>"
	And Edit Calendar "<Edit_CalendarName>" with "<Edit_NewCalendarName>" and "<Edit_NewDescription>"
	And Search the Calendar with "<Search_CalendarName>"
	And Inactive the Calendar "<Inactive_CalendarName>"	
    Examples: {'datafile' : 'src/main/resources/data/Administrator/Business Calendar.xls','sheetName':'Calendar'}
  
@AD_05_DocumentManager_Scenarios
  	Scenario Outline: To Verify Document Manager Functionality  	
	Given I navigate to "Document Manager" page
	And Search a Entity "<SVEF_Entity Name>"
	And Search a Entity Record with "<SVEF_Entity Name>" and "<SVEF_Entity Record>"	
	And Verify Entity field and View record with "<SVEF_Entity Name>" and "<SVEF_Entity Record>" and "<SVEF_Field Name>"
	And Verify Workflow field and View record with "<SVWF_Entity Name>" and "<SVWF_Entity Record>" and "<SVWF_Field Name>"				
	And Verify Download Parent version with "<SVEF_Entity Name>" and "<SVEF_Entity Record>" and "<SVEF_Field Name>"
	And Verify Download All version with "<SVEF_Entity Name>" and "<SVEF_Entity Record>" and "<SVEF_Field Name>"
	#------Entity Creation Document Manager-------
	And I navigate to "<SVEF_Entity Name>" page
	And Verify Entity Creation Document Manager with "<SVEF_Entity Name>"
	And Verify Entity Record Search in Entity Creation Document Manager with "<SVEF_Entity Name>" and "<SVEF_Entity Record>"
	And Verify View Entity field record in Entity Creation Document Manager with "<SVEF_Entity Name>", "<SVEF_Entity Record>" and "<SVEF_Field Name>"
	And I navigate to "<SVWF_Entity Name>" page
	And Verify View Workflow field record in Entity Creation Document Manager with "<SVWF_Entity Name>", "<SVWF_Entity Record>" and "<SVWF_Field Name>"
	And I navigate to "<SVEF_Entity Name>" page				
	And Verify Download Parent version in Entity Creation Document Manager with "<SVEF_Entity Name>", "<SVEF_Entity Record>" and "<SVEF_Field Name>"
	And Verify Download All version in Entity Creation Document Manager "<SVEF_Entity Name>", "<SVEF_Entity Record>" and "<SVEF_Field Name>"		
    Examples: {'datafile' : 'src/main/resources/data/Document Manager/Document Manager.xls','sheetName':'Doc Manager'}
    
@AD_06_DashboardDefinition_Scenarios
  	Scenario Outline: To Verify Dashboard Defintion Functionality  	
	Given I navigate to "Dashboard Definition" page
	And Verify Distribute Equally in Dashboard Definition with "<Dashboard Name>"
	And Verify Distribute Equally Widget wise in Dashboard Definition with "<Dashboard Name>"
	And Delete Widget in Dashboard Definition with "<Dashboard Name>"
    Examples: {'datafile' : 'src/main/resources/data/Dashboard/Dashboard Definition.xls','sheetName':'Dashboard Definition'}
    
@AD_07_DashboardExecution_Scenarios
  	Scenario Outline: To Verify Dashboard Execution Functionality  	
	Given I navigate to "<Dashboard Name>" page
	And Verify Dashboard Generation with "<Dashboard Name>"
	And Verify PNG, JPEG, Excel, PDF in Dashboard Execution with "<DownloadFolder>"
	And Verify Send Mail in Dashboard Execution with "<MailTo>", "<Subject>" and "<MailContent>"	
    Examples: {'datafile' : 'src/main/resources/data/Dashboard/Dashboard Execution.xls','sheetName':'Dashboard Execution'}
    
@AD_08_ReportDefinition_Scenarios
  	Scenario Outline: To Verify Report Defintion Functionality  	
	Given I navigate to "Report Definition" page
	And Verify Distribute Equally in Report Definition with "<Report Name>"
	And Verify Distribute Equally Widget wise in Report Definition with "<Report Name>"
	And Delete Widget in Report Definition with "<Report Name>"
    Examples: {'datafile' : 'src/main/resources/data/Reports/Report Definition.xls','sheetName':'Report Definition'}
    
@AD_09_ReportExecution_Scenarios
  	Scenario Outline: To Verify Report Execution Functionality  	
	Given I navigate to "<Report Name>" page
	And Verify Report Generation with "<Report Name>"	
	#And Verify PNG, JPEG, Excel, PDF in Report Execution with "<Report Name>" and "<DownloadFolder>"
	#And Verify Send Mail in Report Execution with "<MailTo>", "<Subject>" and "<MailContent>"
	#And Verify PNG, JPEG, Excel, PDF for Specific Widget in Report with "<Report Name>", "<Widget Name>" and "<DownloadFolder>"
	And Verify Global Parameters in Report Execution with "<GP_Report_Name>"
    Examples: {'datafile' : 'src/main/resources/data/Reports/Report Execution.xls','sheetName':'Report Execution'}
    
@AD_96_Logout
	Scenario Outline: To logout of nFlows Application
	Given I click on Logout Button 				
	Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
	
@AD_97_CreateTestResult
	Scenario Outline: To Create Test Result file
	When I create a Test Result file based on "<isExcelReport_enabled>"
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
    
@AD_98_CreatePDFReport
	Scenario Outline: To Start PDF Report 
  	When I create a PDF report based on "<pdfReport_enabled>"
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
    
@AD_99_PrintTestResultInConsole
	Scenario Outline: To Print Test Result in Console
	When Print Test Result in Console
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
    
	    
@AD_02.1_Roles_Scenarios
  	Scenario Outline: To Verify Roles Functionality
	Given I navigate to "Roles" page
	And Verify Landing Page Grid
	And Create New Role with "<Create_RoleName>" and "<Create_Description>"
	And Edit Role "<Edit_RoleName>" with "<Edit_NewRoleName>" and "<Edit_NewDescription>"
	And Search the Roles with "<Search_RoleName>"
	And Inactive the Roles "<Inactive_RoleName>"	
    Examples: {'datafile' : 'src/main/resources/data/Administrator/Roles.xls','sheetName':'Roles'}

@AD_02.2_Dropdown_Scenarios
  	Scenario Outline: To Verify Dropdown Functionality
	Given I navigate to "Dropdown" page
	And Verify Dropdown Landing Page Grid
	And Create New Dropdown with "<Create_ListName>" and "<Create_ListValue1>"
	And Edit Dropdown "<Edit_ListName>" with "<Edit_NewListName>" and "<Edit_NewListValue1>"
	And Search the Dropdown with "<Search_ListName>"
	And Inactive the Dropdown "<Inactive_ListName>"	
    Examples: {'datafile' : 'src/main/resources/data/Administrator/Dropdown.xls','sheetName':'Dropdown'}

@AD_02.3_Business_Calendar_Scenarios
  	Scenario Outline: To Verify Business Calendar Functionality
	Given I navigate to "Business Calendar" page
	And Verify Calendar Landing Page Grid
	And Create New Calendar with "<Create_CalendarName>" and "<Create_Description>"
	And Edit Calendar "<Edit_CalendarName>" with "<Edit_NewCalendarName>" and "<Edit_NewDescription>"
	And Search the Calendar with "<Search_CalendarName>"
	And Inactive the Calendar "<Inactive_CalendarName>"	
    Examples: {'datafile' : 'src/main/resources/data/Administrator/Business Calendar.xls','sheetName':'Calendar'}
 		
@AD_03_Logout
	Scenario Outline: To logout of nFlows Application
	Given I click on Logout Button 				
	Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
	
 
    
    
 #************************************************* ROLES ****************************************************************
    
@Roles_Disabled_3_1
  	Scenario Outline: Roles - Check menu level access with Disabled access
  	
	Given I navigate to "Roles" page
	And Verify Landing Page Grid
	And Search the Roles with "<Search_RoleName>" and edit
	Then I provide "<Disabled>" access at Menu level
	Then I click on Logout Button
	Given I login to Nflows with "<username>" and "<password>" credentials
	When I validate read, write or disabled access at menulevel with "<menuName>"
	Then I click on Logout Button
	
		
	Examples: {'datafile' : 'src/main/resources/data/MessageMaster.xls','sheetName':'Roles'} 
	
@Roles_Write_3_2
  	Scenario Outline: Roles - Change access to WRITE at menu level
  	
  	#Given I login to Nflows with "<username>" and "<password>" credentials
  	Given I navigate to "Roles" page
	And Verify Landing Page Grid
	And Search the Roles with "<Search_RoleName>" and edit
	Then I provide "WRITE" access at Menu level
	Then I click on Logout Button
	Given I login to Nflows with "<username>" and "<password>" credentials
	Then I validate access at menulevel with "<menu>" and "<landingMenu>"
	Then I click on Logout Button
			
	Examples: {'datafile' : 'src/main/resources/data/MessageMaster.xls','sheetName':'Roles'} 
	
@Roles_Read_3_3
  	Scenario Outline: Roles - Change access to Read at menu level
  	
  #	Given I login to Nflows with "<username>" and "<password>" credentials
  	Given I navigate to "Roles" page
	And Verify Landing Page Grid
	And Search the Roles with "<Search_RoleName>" and edit
	Then I provide "READ" access at Menu level
	Then I click on Logout Button
	Given I login to Nflows with "<username>" and "<password>" credentials
	Then I validate access at menulevel with "<menu>" and "<landingMenu>"
	Then I click on Logout Button	
			
	Examples: {'datafile' : 'src/main/resources/data/MessageMaster.xls','sheetName':'Roles'} 
	
	
@Roles_3_6
  	Scenario Outline: Roles - No Grouping Rule is attached in Entity Data Access
  	
  	#Given I login to Nflows with "<username>" and "<password>" credentials
  	Given I navigate to "Roles" page
	And Verify Landing Page Grid
	And Search the Roles with "<Search_RoleName>" and edit
	When I update Access level for entity "<entity>" in Data access
	Then I uncheck the existing rules from dropdown "<rules>"
	Given I navigate to "<entity>" page
	#Then I click on Logout Button

		
	Examples: {'datafile' : 'src/main/resources/data/MessageMaster.xls','sheetName':'Roles'} 
	
@Roles_3_7
  	Scenario Outline: Roles - Single Grouping Rule is attached under 'Read Access'
  	
  	#Given I login to Nflows with "<username>" and "<password>" credentials
  	Given I navigate to "Roles" page
	And Verify Landing Page Grid
	And Search the Roles with "<Search_RoleName>" and edit
	When I update Access level for entity "<entity>" in Data access
	Then I uncheck the existing rules from dropdown "<rules>"
	When I update Access level for entity "<entity>" in Data access
	When I check the single read access with rule "<single_rules>" for dropdown type "singleSelect"
	Given I navigate to "<entity>" page
	Then I click on Logout Button
	
		
	Examples: {'datafile' : 'src/main/resources/data/MessageMaster.xls','sheetName':'Roles'} 
	
@Roles_3_8
  	Scenario Outline: Roles - Multiple Grouping Rule is attached under 'Read Access'
  	
  	#Given I login to Nflows with "<username>" and "<password>" credentials
  	Given I navigate to "Roles" page
	And Verify Landing Page Grid
	And Search the Roles with "<Search_RoleName>" and edit
	When I update Access level for entity "<entity>" in Data access
	Then I uncheck the existing rules from dropdown "<rules>"
	When I update Access level for entity "<entity>" in Data access
	When I check the multiple read access with rule "<multi_rules>" for dropdown type "multiSelect"
	Given I navigate to "<entity>" page
	#Then I click on Logout Button
	
		
	Examples: {'datafile' : 'src/main/resources/data/MessageMaster.xls','sheetName':'Roles'} 
	
	
@Roles_3_9
  	Scenario Outline: Roles - Single Grouping Rule is attached under 'Write Access'
  	
  	#Given I login to Nflows with "<username>" and "<password>" credentials
  	Given I navigate to "Roles" page
	And Verify Landing Page Grid
	And Search the Roles with "<Search_RoleName>" and edit
	When I update Access level for entity "<entity>" in Data access
	Then I uncheck the existing rules from dropdown "<rules>"
	When I update Access level for entity "<entity>" in Data access
	When I check the single write access with rule "<single_rules>" for dropdown type "singleSelect"
	Given I navigate to "<entity>" page
	#Then I click on Logout Button
	
		
	Examples: {'datafile' : 'src/main/resources/data/MessageMaster.xls','sheetName':'Roles'} 	
	

@Roles_3_10
  	Scenario Outline: Roles - Multiple Grouping Rule is attached under 'Write Access'
  	
  	Given I login to Nflows with "<username>" and "<password>" credentials
  	Given I navigate to "Roles" page
	And Verify Landing Page Grid
	And Search the Roles with "<Search_RoleName>" and edit
	When I update Access level for entity "<entity>" in Data access
	Then I uncheck the existing rules from dropdown "<rules>"
	When I update Access level for entity "<entity>" in Data access
	When I check the multi write access with rule "<multi_rules>" for dropdown type "multiSelect"
	Given I navigate to "<entity>" page
	Then I click on Logout Button
		
		
	Examples: {'datafile' : 'src/main/resources/data/MessageMaster.xls','sheetName':'Roles'} 
 
 
@Roles_3_11
  	Scenario Outline: Roles - Single Grouping Rule is attached under 'Read Access' and 'Write Access'
  	
  	Given I login to Nflows with "<username>" and "<password>" credentials
  	Given I navigate to "Roles" page
	And Verify Landing Page Grid
	And Search the Roles with "<Search_RoleName>" and edit
	When I update Access level for entity "<entity>" in Data access
	Then I uncheck the existing rules from dropdown "<rules>"
	When I update Access level for entity "<entity>" in Data access
	When I check the single read and write access with rule "<single_rules>" for dropdown type "singleSelect"
	Given I navigate to "<entity>" page
	Then I click on Logout Button
	
		
	Examples: {'datafile' : 'src/main/resources/data/MessageMaster.xls','sheetName':'Roles'} 	
	

@Roles_3_12
  	Scenario Outline: Roles - Multiple Grouping Rule is attached under 'Write Access'
  	
  	Given I login to Nflows with "<username>" and "<password>" credentials
  	Given I navigate to "Roles" page
	And Verify Landing Page Grid
	And Search the Roles with "<Search_RoleName>" and edit
	When I update Access level for entity "<entity>" in Data access
	Then I uncheck the existing rules from dropdown "<rules>"
	When I update Access level for entity "<entity>" in Data access
	When I check the multi read and write access with rule "<multi_rules>" for dropdown type "multiSelect"
	Given I navigate to "<entity>" page
	Then I click on Logout Button
		
		
	Examples: {'datafile' : 'src/main/resources/data/MessageMaster.xls','sheetName':'Roles'}    
 	
@AD_07_CreateTestResult
	Scenario Outline: To Create Test Result file
	When I create a Test Result file based on "<isExcelReport_enabled>"
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
    
    
@Roles_CreatePDFReport
	Scenario Outline: To Start PDF Report 
  	When I create a PDF report based on "<pdfReport_enabled>"
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
	