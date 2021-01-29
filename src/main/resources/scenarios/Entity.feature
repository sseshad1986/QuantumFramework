@Nflows
Feature: Entity Definition 

@EN_00_LaunchNflows
  	Scenario Outline: Launching Nflows application

    Given I launch Nflows application using "<Url_Testing>"
    When I start recording automation execution based on "<recording_enabled>"
    
    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}

@EN_01_NflowsLogin
  	Scenario Outline: Login to Nflows 
  	Given I login to Nflows with "<username>" and "<password>" credentials   
            
    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Nflows_Login'} 

@EN_02_CreateEntityDefinition
  	Scenario Outline: Create a Entity Definition 
    	Given I navigate to "<menuName>" page
    	When I create a new Entity Definition 
    	#Then I can see new Entity template in landing page
            
    	#for csv, txt, xls files specify datafile location
   		Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Entity_Definition'}  
	
@EN_03_EditEntityDefinition
  	Scenario Outline: Edit an Entity Definition
    	Given I navigate to "<menuName>" page
    	And I Edit an Entity Definition for "<Entityname>" Entity
    	Then I navigate to Workflow page "<workflowName>" from Entity definition page
    	And I click on Grouping Rule tab
    	And I create a grouping rule for entity with "<groupingRuleName>" and "<Description>" and "<RuleDefinition>" for "<rulePurpose>" and "<FieldGroup>" and "<ruleGroup>"
    	
   		Examples: {'datafile' : 'src/main/resources/data/Entity/entity.xls','sheetName':'Edit_Entity_Definition'} 
 
@EN_04_CreateRuleDefinition  		
   Scenario Outline: Create a new Rule Definition
   		#Given I navigate to "Entity Definition" page  	  	
    	Then I create a rule for the "<entityName>" entity with "<ruleName>" and "<ruletype>" and "<ruleExecution>" and "<description>" and "<ruleDefinition>" and "<selectfield>" and "<selectmessage>" and "<ruleEnrichment>" and "<ruleFilter>" and "<ruleGroup>" 

   		Examples: {'datafile' : 'src/main/resources/data/Entity/entity.xls','sheetName':'Rule_Definition', "key":"YES"}
   		
@EN_05_EntityCreation
	Scenario Outline: Create Entity Creation record
	    Given I navigate to "<entityName>" page
	    When Create a Entity record for "<entityName>" with field group "<fieldGroup>"
	    #Given I navigate to "<menuName>" page	    
	    And I edit the "<recordName>" entity record based on "<gridColumn>" coloumn

		Examples: {'datafile' : 'src/main/resources/data/Entity/entity.xls','sheetName':'entity_Creation'}       		

@EN_05_UserCreation
	Scenario Outline: Create Entity Creation record
		Given I navigate to "Users" page
	    When Create a Entity record for "Users" with field group ""
	    Given I navigate to "Users" page	    
	    And I edit the "<recordName>" entity record based on "<gridColumn>" coloumn

		Examples: {'datafile' : 'src/main/resources/data/Entity/Users.xls','sheetName':'entity_Creation'}       		

@WD_01_WidgetDefinition
Scenario Outline: To create a new Widget
    	Given I navigate to "<menuName>" page
    	Then I Edit an Widget Definition for "<widgetName>" widget
    	#Then I create a "<ruleDefinition>" rule for Widget Definition
    	Then add columns to the widgets "<colName>"
   		
   		Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'widget'}       		
    
@DM_01_DocumentManager
Scenario Outline: To validate documents under document manager
    	Given I navigate to "<menuName>" page 
    	And I validate "<EntityField>" entity attachment for the "<RecordName>" in "<Entityname>"
    	#And I validate "<WorkflowField>" workflow attachment for the "<RecordName>" in "<Entityname>" 	  	
    	
    	Examples: {'datafile' : 'src/main/resources/data/Entity/entity.xls','sheetName':'DocumentManager'}     

@EN_06_NflowsLogout
  	Scenario Outline: Logout of Nflows
    Given I click on Logout Button
    #Then I logged out of Nflows successfully
    Then I stop recording automation execution based on "<recording_enabled>"
    
    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
    
@LG_01_ForgotPassword
  	Scenario Outline: Check Forgot password functionality
  	
    And I click on forgot password link
    And I enter the userName "<username>"
    And I click Submit for Forgot password
    Then I got email for forgot paasword successfully
    
    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Nflows_Login'}

#---------------------- Test Report Related Features  ---------------------------------------- 
        
@EN_07_CreatePDFReport
Scenario Outline: To Start PDF Report 
  	Given I create a PDF report based on "<pdfReport_enabled>"
  	
  	#for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}

  	
@EN_08_CreateTestResult
	Scenario Outline: To Create Test Result file
	When I create a Test Result file based on "<isExcelReport_enabled>"
	
  	#for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
	 	  
