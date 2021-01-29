@Workflow
Feature: Entity Definition 

@MS_00_LaunchNflows
  	Scenario Outline: Launching Nflows application

    Given I launch Nflows application using "<Url_Testing>"
    #When I start recording automation execution based on "<recording_enabled>"
    
    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/MessageMaster.xls','sheetName':'Environment'}

@MS_01_NflowsLogin
  	Scenario Outline: Login to Nflows 
  	Given I login to Nflows with "<username>" and "<password>" credentials   
            
    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/MessageMaster.xls','sheetName':'Nflows_Login'} 

    
@MS_02_MessageMaster
  	Scenario Outline: Message master validation
  	Given I navigate to "Message" page
  	When I validate landing page in Message master
  	Then I Create new Message Master "<MessageType>", "<Reason>", "<NewMessage>", "<Resolution>"
  	When I Search message master "<Message>"
  	And  I Edit Message Master "<NewMessage>" with "<UpdatedMessage>"
  	Then I click on Logout Button 
  	            
    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/MessageMaster.xls','sheetName':'MessageMaster'} 
    
   
@MS_02_1_MessageMaster
  	Scenario Outline: Message master validation
  	Then I Create new Message Master "<MessageType>", "<Reason>", "<NewMessage>", "<Resolution>"
  	#When I Search message master "<Message>"
  	#And  I Edit Message Master "<NewMessage>" with "<UpdatedMessage>"
  	#Then I click on Logout Button 
  	            
    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/MessageMaster.xls','sheetName':'MessageMaster1'} 
 
    
    
    
@MS_03_EntityDataDictionary
  	Scenario Outline: Entity Data Dictionary validation
  	Given I navigate to "Entity Data Dictionary" page
	When I validate landing page in Entity Data Dictionary page
	And I Search entiry Data Dictionary "<entityDDSearch>"	
  	#Then I click on Logout Button
  	            
    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/MessageMaster.xls','sheetName':'EntityDataDictionary'} 
    
    
@MS_04_WorkflowDataDictionary
  	Scenario Outline: Workflow Data Dictionary validation
  	Given I navigate to "Workflow Data Dictionary" page
  	When I validate landing page in Workflow Data Dictionary
  	And I Search Workflow Data Dictionary "<wfDDSearch>"
  	Then I Create new field in Workflow Data Dictionary "<FieldName>", "<DataLabel>", "<FieldDescription>", "<DataType>", "<Length>", "<Precision>"
  	When I edit workflow data dictionary "<search>", "<updatedFiedname>", "<updatedDataLabel>"
  	Then I click on Logout Button
  	
  	#Then I inactive wfDD
  	            
    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/MessageMaster.xls','sheetName':'WorkflowDataDictionary'} 
    
    
#---------------------- Test Report Related Features  ---------------------------------------- 
  
@MS_06_CreatePDFReport
Scenario Outline: To Start PDF Report 
  	Given I create a PDF report based on "<pdfReport_enabled>"
  	
  	#for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}

  	
@MS_07_CreateTestResult
	Scenario Outline: To Create Test Result file
	When I create a Test Result file based on "<isExcelReport_enabled>"
	
  	#for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}