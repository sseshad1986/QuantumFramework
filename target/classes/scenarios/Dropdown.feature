@Dropdown
Feature: Dropdown 

@DD_00_LaunchNflows
  	Scenario Outline: Launching Nflows application
    Given I launch Nflows application using "<Url_Testing>"
	Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}

@DD_01_NflowsLogin
  	Scenario Outline: Login to Nflows 
  	Given I login to Nflows with "<username>" and "<password>" credentials   
	Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Nflows_Login'} 
	    
@DD_02_Dropdown_Scenarios
  	Scenario Outline: To Verify Dropdown Functionality
	Given I navigate to "Dropdown" page
	And Verify Dropdown Landing Page Grid
	And Create New Dropdown with "<Create_ListName>" and "<Create_ListValue1>"
	And Edit Dropdown "<Edit_ListName>" with "<Edit_NewListName>" and "<Edit_NewListValue1>"
	And Search the Dropdown with "<Search_ListName>"
	And Inactive the Dropdown "<Inactive_ListName>"	
    Examples: {'datafile' : 'src/main/resources/data/Administrator/Dropdown.xls','sheetName':'Dropdown'}

@BC_02_Business_Calendar_Scenarios
  	Scenario Outline: To Verify Business Calendar Functionality
	Given I navigate to "Business Calendar" page
	And Verify Calendar Landing Page Grid
	And Create New Calendar with "<Create_CalendarName>" and "<Create_Description>"
	And Edit Calendar "<Edit_CalendarName>" with "<Edit_NewCalendarName>" and "<Edit_NewDescription>"
	And Search the Calendar with "<Search_CalendarName>"
	And Inactive the Calendar "<Inactive_CalendarName>"	
    Examples: {'datafile' : 'src/main/resources/data/Administrator/Business Calendar.xls','sheetName':'Calendar'}
 		
@DD_03_Logout
	Scenario Outline: To logout of nFlows Application
	Given I click on Logout Button 				
	Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
	
@RO_07_CreateTestResult
	Scenario Outline: To Create Test Result file
	When I create a Test Result file based on "<isExcelReport_enabled>"
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
	