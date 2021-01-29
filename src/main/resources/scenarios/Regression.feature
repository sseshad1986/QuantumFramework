@Regression
Feature: Regression Scenarios for Nflows

@RG_00_LaunchNflows
  	Scenario Outline: Launching Nflows application

    Given I launch Nflows application using "<Url_Testing>"
    When I start recording automation execution based on "<recording_enabled>"
    
    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}

@RG_01_NflowsLogin
  	Scenario Outline: Login to Nflows 
  	Given I login to Nflows with "<username>" and "<password>" credentials   
            
    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Nflows_Login'} 

@RG_02_EditEntityDefinition
  	Scenario Outline: Edit an Entity Definition
    	Given I navigate to "<menuName>" page
    	And I Edit an Entity Definition for "<Entityname>" Entity
    	#Then I navigate to Workflow page "<workflowName>" from Entity definition page
    	And I click on Grouping Rule tab
    	And I create a grouping rule for entity with "<groupingRuleName>" and "<Description>" and "<RuleDefinition>" for "<rulePurpose>" and "<FieldGroup>" and "<ruleGroup>"
    	
   		Examples: {'datafile' : 'src/main/resources/data/Entity/entity.xls','sheetName':'Edit_Entity_Definition'} 
 
@RG_03_CreateRuleDefinition  		
   Scenario Outline: Create a new Rule Definition
   		#Given I navigate to "Entity Definition" page  	  	
    	Then I create a rule for the "<entityName>" entity with "<ruleName>" and "<ruletype>" and "<ruleExecution>" and "<description>" and "<ruleDefinition>" and "<selectfield>" and "<selectmessage>" and "<ruleEnrichment>" and "<ruleFilter>" and "<ruleGroup>" 

   		Examples: {'datafile' : 'src/main/resources/data/Entity/entity.xls','sheetName':'Rule_Definition', "key":"YES"}
   		
@RG_04_EntityCreation
	Scenario Outline: Create Entity Creation record
	    Given I navigate to "<entityName>" page
	    When Create a Entity record for "<entityName>" with field group "<fieldGroup>"
	    And I edit the "<recordName>" entity record based on "<gridColumn>" coloumn

		Examples: {'datafile' : 'src/main/resources/data/Entity/entity.xls','sheetName':'entity_Creation'}       		

@RG_05_UserCreation
	Scenario Outline: Create Entity Creation record
		Given I navigate to "Users" page
	    When Create a Entity record for "Users" with field group ""
	    And I edit the "<recordName>" entity record based on "<gridColumn>" coloumn

		Examples: {'datafile' : 'src/main/resources/data/Entity/entity.xls','sheetName':'user_Creation'}       		

#---------------------- LPC WF Related Features  ----------------------------------------
@RG_06_LPC_WF_approval
  	Scenario Outline: To submit the respective task   		
  		Given I check whether current task belongs to same user with "<username>" and "<password>" credentials	
    	#When I navigate to "My Task" page 
    	#And I wait for proper page loading for myRequest page
    	And I search for a particular task "<taskName>" of "<taskType>" in "<user/team>" section and edit based on "<gridData>" in "<myTask>"
    	#And I perform action for "<task_ID>"
    	And I completed the "<taskName>" task of "<taskType>" based on "<taskAction>"
    	
    	Examples: {'datafile' : 'src/main/resources/data/Workflow/LPC_WF.xls','sheetName':'task_Approval'} 
    	
@RG_07_LPC_WF_rejection
  	Scenario Outline: To submit the respective task in workflow		
  		Given I check whether current task belongs to same user with "<username>" and "<password>" credentials	
    	When I search for a particular task "<taskName>" of "<taskType>" in "<user/team>" section and edit based on "<gridData>" in "<myTask>"
    	#And I perform action for "<task_ID>"
    	And I completed the "<taskName>" task of "<taskType>" based on "<taskAction>"   	
    	
    	Examples: {'datafile' : 'src/main/resources/data/Workflow/LPC_WF.xls','sheetName':'task_Rejection'} 
    	
@RG_08_LPC_WF_ValidateRequest
Scenario Outline: To submit the respective task   		
  			
    	#Given I navigate to "My Request" page 
    	Given I wait for proper page loading for myRequest page
    	Given I navigate to "<entityName>" page 
    	And I edit the "<recordName>" entity record based on "<gridColumn>" coloumn
    	#When I select completed filter 
    	#Then I verify "<entityRecord>" request is completed for the "<workflow>"    	
    	
    	Examples: {'datafile' : 'src/main/resources/data/Workflow/LPC_WF.xls','sheetName':'validate_backupdate'}

#---------------------- RPC WF Related Features  ----------------------------------------
@RG_09_RPC_WF_approval
  	Scenario Outline: To submit the respective task   		
  		Given I check whether current task belongs to same user with "<username>" and "<password>" credentials	
    	#When I navigate to "My Task" page 
    	#And I wait for proper page loading for myRequest page
    	And I search for a particular task "<taskName>" of "<taskType>" in "<user/team>" section and edit based on "<gridData>" in "<myTask>"
    	#And I perform action for "<task_ID>"
    	And I completed the "<taskName>" task of "<taskType>" based on "<taskAction>"
    	
    	Examples: {'datafile' : 'src/main/resources/data/Workflow/RPC_WF.xls','sheetName':'task_Approval'} 
    	
@RG_10_RPC_WF_rejection
  	Scenario Outline: To submit the respective task in workflow		
  		Given I check whether current task belongs to same user with "<username>" and "<password>" credentials	
    	When I search for a particular task "<taskName>" of "<taskType>" in "<user/team>" section and edit based on "<gridData>" in "<myTask>"
    	#And I perform action for "<task_ID>"
    	And I completed the "<taskName>" task of "<taskType>" based on "<taskAction>"   	
    	
    	Examples: {'datafile' : 'src/main/resources/data/Workflow/RPC_WF.xls','sheetName':'task_Rejection'} 
    	
@RG_11_RPC_WF_ValidateRequest
Scenario Outline: To submit the respective task   		
  			
    	#Given I navigate to "My Request" page 
    	Given I wait for proper page loading for myRequest page
    	Given I navigate to "<entityName>" page 
    	And I edit the "<recordName>" entity record based on "<gridColumn>" coloumn
    	#When I select completed filter 
    	#Then I verify "<entityRecord>" request is completed for the "<workflow>"    	
    	
    	Examples: {'datafile' : 'src/main/resources/data/Workflow/RPC_WF.xls','sheetName':'validate_backupdate'}

#---------------------- UOBAM_Manual WF Related Features  ----------------------------------------
                
@RG_14_UOBAM_WF_approval
  	Scenario Outline: To submit the respective task   		
  		Given I check whether current task belongs to same user with "<username>" and "<password>" credentials	
    	#When I navigate to "My Task" page 
    	#And I wait for proper page loading for myRequest page
    	And I search for a particular task "<taskName>" of "<taskType>" in "<user/team>" section and edit based on "<gridData>" in "<myTask>"
    	#And I perform action for "<task_ID>" 
    	And I completed the "<taskName>" task of "<taskType>" based on "<taskAction>"
    	
    	Examples: {'datafile' : 'src/main/resources/data/Workflow/Uobam_WF.xls','sheetName':'task_Approval'} 
    	
@RG_15_UOBAM_WF_rejection
  	Scenario Outline: To submit the respective task in workflow		
  		Given I check whether current task belongs to same user with "<username>" and "<password>" credentials	
    	When I search for a particular task "<taskName>" of "<taskType>" in "<user/team>" section and edit based on "<gridData>" in "<myTask>"
    	#And I perform action for "<TASK ID>" from "UOBAM_WF_Task_Details"
    	And I completed the "<taskName>" task of "<taskType>" based on "<taskAction>"   	
    	
    	Examples: {'datafile' : 'src/main/resources/data/Workflow/Uobam_WF.xls','sheetName':'task_Rejection'} 
    	
@RG_16_UOBAM_WF_ValidateRequest
Scenario Outline: To submit the respective task   		
  			
    	#Given I navigate to "My Request" page 
    	Given I wait for proper page loading for myRequest page
    	Given I navigate to "<entityName>" page 
    	And I edit the "<recordName>" entity record based on "<gridColumn>" coloumn
    	#When I select completed filter 
    	#Then I verify "<entityRecord>" request is completed for the "<workflow>"    	
    	
    	Examples: {'datafile' : 'src/main/resources/data/Workflow/Uobam_WF.xls','sheetName':'validate_backupdate'}
    	

@RG_13_MyRequest
  	Scenario Outline: To check my-Request page related functionalities
    	Given I navigate to "<menuName>" page
    	#And I wait for proper page loading for myRequest page
    	# These steps are related to creating a new Request
    	And I navigate to new Request page
    	And I click on "<workflowName>" and click on entityRecordLookup button
    	#And I check Search functionality for "<searchRequest>"
    	And I select a "<searchInitiation>" request from request pop up based on "<gridData>" initiation fields
    	Then "<validateNewRequest>" Request is successfully triggered and validated in my Request page
    	    	
    	#And I check recalculate functionality
    	#And I check show Other Request functionality    	
    	
        Examples: {'datafile' : 'src/main/resources/data/Request/MyRequest.xls','sheetName':'New_Request'}

@RG_14_AllPage
  	Scenario Outline: To check my-Request page related functionalities
  		Given I navigate to "<menu>" page
  		
	  	#for csv, txt, xls files specify datafile location
	    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Menu'}	 
	  
@RG_15_ReportExecution
  	Scenario Outline: To check report execution related functionalities
  		Given I navigate to "<Report Name>" page
  		And I generate Report for "<Report Name>"
  		
	  	#for csv, txt, xls files specify datafile location
	    Examples: {'datafile' : 'src/main/resources/data/Reports/Execution engine.xls','sheetName':'Index'}   	
 
@RG_16_MyTask_1.1
	Scenario Outline: To complete the respective task in workflow		
		Given I check whether current task belongs to same user with "<username>" and "<password>" credentials	
    	When I search for a particular task "<taskName>" of "<taskType>" in "<user/team>" section and edit based on "<gridData>" in "<myTask>"
    	And I perform action for "<TASK ID>" of "<taskType>" from "Library_WF_Task_Details" with "<FIELD_GRP>"    	
    	And I completed the "<taskName>" task of "<taskType>" based on "<taskAction>"   	
  		
  	#for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/Workflow/Library_WF.xls','sheetName':'Task'} 

@RG_16_MyTask_1.2
	Scenario Outline: Check Search Function		
		Given I perform a search for "<user/team task>" having taskData as "<searchData>" from "<myTask>"
		Then I validate data for "<user/team task>" with "<searchData>" of task type as "<columnName>"
		
  	#for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/Workflow/Workflow_Engine.xls','sheetName':'taskSearch'}
    
@RG_18_EntityCreation_POC
	Scenario Outline: Create Entity Creation record
	    Given I navigate to "<menuName>" page
	    When Create a Entity record for "<entityName>" with file name as "<fileName>" having field group "<fieldGroup>" for poc
	    #And I edit the "<recordName>" entity record based on "<gridColumn>" coloumn

		Examples: {'datafile' : 'src/main/resources/data/Entity/entity.xls','sheetName':'poc'} 	
 
@RG_19_multilingual
	Scenario Outline: Create Entity Creation record
	    Given I navigate to "<menuName>" page
	    And I Edit an Entity Definition for "Discussions" Entity
	    And I Check multi lingual functionality
	    
	    Examples: {'datafile' : 'src/main/resources/data/Multilingual/menu.xls','sheetName':'data'} 	
 
@RG_21_CheckBackupdate
	Scenario Outline: Create Entity Creation record
	    Given I navigate to "<entityName>" page
	    And I edit the "<recordName>" entity record based on "<gridColumn>" coloumn

		Examples: {'datafile' : 'src/main/resources/data/Entity/entity.xls','sheetName':'entity_Creation'}   		

@RG_22_Download_functionality_Entity_3.13
	Scenario: Check the download template functionality in entity creation page
	    Given I navigate to "Academy Details" page
	    #And Check download in entity definition page
	    And Check download in entity creation page
	    
#Examples: {'datafile' : 'src/main/resources/data/Entity/entity.xls','sheetName':'entity_Creation'}   		


@RG_60_NflowsLogout
  	Scenario Outline: Logout of Nflows
    Given I click on Logout Button
    #Then I logged out of Nflows successfully
    Then I stop recording automation execution based on "<recording_enabled>"
    
    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}   

#---------------------- Test Report Related Features  ---------------------------------------- 
        
@RG_61_CreatePDFReport
Scenario Outline: To Start PDF Report 
  	Given I create a PDF report based on "<pdfReport_enabled>"
  	
  	#for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}

  	
@RG_62_CreateTestResult
	Scenario Outline: To Create Test Result file
	When I create a Test Result file based on "<isExcelReport_enabled>"
	
  	#for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
	 	  
