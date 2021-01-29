@DashboardExecution
Feature: Dashboard Execution 

@DE_00_LaunchNflows
  	Scenario Outline: Launching Nflows application
    Given I launch Nflows application using "<Url_Testing>"
	Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}

@DE_01_NflowsLogin
  	Scenario Outline: Login to Nflows 
  	Given I login to Nflows with "<username>" and "<password>" credentials   
	Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Nflows_Login'} 
	    
@DE_02_DashboardExecution_Scenarios
  	Scenario Outline: To Verify Dashboard Execution Functionality  	
	Given I navigate to "<Dashboard Name>" page
	#And Verify Dashboard Generation		
    Examples: {'datafile' : 'src/main/resources/data/Dashboard/Dashboard Execution.xls','sheetName':'Dashboard Execution'}

@DE_03_Logout
	Scenario Outline: To logout of nFlows Application
	Given I click on Logout Button 				
	Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
	
@DE_07_CreateTestResult
	Scenario Outline: To Create Test Result file
	When I create a Test Result file based on "<isExcelReport_enabled>"
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
	
@DE_08_CreatePDFReport
		Scenario Outline: To Start PDF Report 
  	When I create a PDF report based on "<pdfReport_enabled>"
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
	
@DE_09_PrintTestResultInConsole
	Scenario Outline: To Print Test Result in Console
	When Print Test Result in Console
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}

