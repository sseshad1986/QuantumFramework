@Workflow
Feature: Workflow Feature 

@WF_00_LaunchNflows
  	Scenario Outline: Launching Nflows application

    Given I launch Nflows application using "<Url_Testing>"
    When I start recording automation execution based on "<recording_enabled>"
    
    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}

@WF_01_NflowsLogin
  	Scenario Outline: Login to Nflows 
  	Given I login to Nflows with "<username>" and "<password>" credentials   
            
    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Nflows_Login'} 
    	    
#---------------------- My Task Related Features -----------------------------------------------------------
@WF_02_FilterinMyTask 
  	Scenario Outline: Submit a Task
    	Given I navigate to "<menuName>" page
    	#When I filter by "<Filter>" type
       #Then I verify the filtered task Type 	
   		
   		Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'myTask'}   

#---------------------- UOBAM_Manual WF Related Features  ----------------------------------------
                
@WF_03_UOBAM_WF_approval
  	Scenario Outline: To submit the respective task   		
  		Given I check whether current task belongs to same user with "<username>" and "<password>" credentials	
    	#When I navigate to "My Task" page 
    	#And I wait for proper page loading for myRequest page
    	And I search for a particular task "<taskName>" of "<taskType>" in "<user/team>" section and edit based on "<gridData>" in "<myTask>"
    	#And I perform action for "<task_ID>"
    	And I completed the "<taskName>" task based on "<taskAction>"
    	
    	Examples: {'datafile' : 'src/main/resources/data/Uobam_WF.xls','sheetName':'task_Approval'} 
    	
@WF_04_UOBAM_WF_rejection
  	Scenario Outline: To submit the respective task in workflow		
  		Given I check whether current task belongs to same user with "<username>" and "<password>" credentials	
    	When I search for a particular task "<taskName>" of "<taskType>" in "<user/team>" section and edit based on "<gridData>" in "<myTask>"
    	#And I perform action for "<task_ID>"
    	And I completed the "<taskName>" task based on "<taskAction>"   	
    	
    	Examples: {'datafile' : 'src/main/resources/data/Uobam_WF.xls','sheetName':'task_Rejection'} 
    	
@WF_05_UOBAM_WF_ValidateRequest
Scenario Outline: To submit the respective task   		
  			
    	#Given I navigate to "My Request" page 
    	Given I wait for proper page loading for myRequest page
    	Given I navigate to "<entityName>" page 
    	And I edit the "<recordName>" entity record based on "<gridColumn>" coloumn
    	#When I select completed filter 
    	#Then I verify "<entityRecord>" request is completed for the "<workflow>"    	
    	
    	Examples: {'datafile' : 'src/main/resources/data/Uobam_WF.xls','sheetName':'validate_backupdate'}

#---------------------- LPC WF Related Features  ----------------------------------------
@WF_03_LPC_WF_approval
  	Scenario Outline: To submit the respective task   		
  		Given I check whether current task belongs to same user with "<username>" and "<password>" credentials	
    	#When I navigate to "My Task" page 
    	#And I wait for proper page loading for myRequest page
    	And I search for a particular task "<taskName>" of "<taskType>" in "<user/team>" section and edit based on "<gridData>" in "<myTask>"
    	#And I perform action for "<task_ID>"
    	And I completed the "<taskName>" task based on "<taskAction>"
    	
    	Examples: {'datafile' : 'src/main/resources/data/LPC_WF.xls','sheetName':'task_Approval'} 
    	
@WF_04_LPC_WF_rejection
  	Scenario Outline: To submit the respective task in workflow		
  		Given I check whether current task belongs to same user with "<username>" and "<password>" credentials	
    	When I search for a particular task "<taskName>" of "<taskType>" in "<user/team>" section and edit based on "<gridData>" in "<myTask>"
    	And I perform action for "<task_ID>"
    	And I completed the "<taskName>" task based on "<taskAction>"   	
    	
    	Examples: {'datafile' : 'src/main/resources/data/LPC_WF.xls','sheetName':'task_Rejection'} 
    	
@WF_05_LPC_WF_ValidateRequest
Scenario Outline: To submit the respective task   		
  			
    	#Given I navigate to "My Request" page 
    	Given I wait for proper page loading for myRequest page
    	Given I navigate to "<entityName>" page 
    	And I edit the "<recordName>" entity record based on "<gridColumn>" coloumn
    	#When I select completed filter 
    	#Then I verify "<entityRecord>" request is completed for the "<workflow>"    	
    	
    	Examples: {'datafile' : 'src/main/resources/data/LPC_WF.xls','sheetName':'validate_backupdate'}


#---------------------- RPC WF Related Features  ----------------------------------------
@WF_03_RPC_WF_approval
  	Scenario Outline: To submit the respective task   		
  		Given I check whether current task belongs to same user with "<username>" and "<password>" credentials	
    	#When I navigate to "My Task" page 
    	#And I wait for proper page loading for myRequest page
    	And I search for a particular task "<taskName>" of "<taskType>" in "<user/team>" section and edit based on "<gridData>" in "<myTask>"
    	#And I perform action for "<task_ID>"
    	And I completed the "<taskName>" task based on "<taskAction>"
    	
    	Examples: {'datafile' : 'src/main/resources/data/RPC_WF.xls','sheetName':'task_Approval'} 
    	
@WF_04_RPC_WF_rejection
  	Scenario Outline: To submit the respective task in workflow		
  		Given I check whether current task belongs to same user with "<username>" and "<password>" credentials	
    	When I search for a particular task "<taskName>" of "<taskType>" in "<user/team>" section and edit based on "<gridData>" in "<myTask>"
    	#And I perform action for "<task_ID>"
    	And I completed the "<taskName>" task based on "<taskAction>"   	
    	
    	Examples: {'datafile' : 'src/main/resources/data/RPC_WF.xls','sheetName':'task_Rejection'} 
    	
@WF_05_RPC_WF_ValidateRequest
Scenario Outline: To submit the respective task   		
  			
    	#Given I navigate to "My Request" page 
    	Given I wait for proper page loading for myRequest page
    	Given I navigate to "<entityName>" page 
    	And I edit the "<recordName>" entity record based on "<gridColumn>" coloumn
    	#When I select completed filter 
    	#Then I verify "<entityRecord>" request is completed for the "<workflow>"    	
    	
    	Examples: {'datafile' : 'src/main/resources/data/Workflow/RPC_WF.xls','sheetName':'validate_backupdate'}
    	
 #---------------------- My Request Related Features ----------------------------------------
@WF_06_MyRequest
  	Scenario Outline: To check my-Request page related functionalities
    	Given I navigate to "<menuName>" page
    	#And I wait for proper page loading for myRequest page
    	# These steps are related to creating a new Request
    	And I navigate to new Request page
    	And I click on "<workflowName>" and click on entityRecordLookup button
    	And I check Search functionality for "<searchRequest>"
    	And I select a "<searchInitiation>" request from request pop up based on "<gridData>" initiation fields
    	Then "<validateNewRequest>" Request is successfully triggered and validated in my Request page
    	    	
    	#And I check recalculate functionality
    	#And I check show Other Request functionality    	
    	
        Examples: {'datafile' : 'src/main/resources/data/Request/MyRequest.xls','sheetName':'New_Request'}

@WF_06_NflowsLogout
  	Scenario Outline: Logout of Nflows
    Given I click on Logout Button
    #Then I logged out of Nflows successfully
    Then I stop recording automation execution based on "<recording_enabled>"
    
    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
    
@WF_07_CreateTestResult
Scenario Outline: To Create Test Result file
	When I create a Test Result file based on "<isExcelReport_enabled>"
	
	#for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
	
	
@WF_08_CreatePDFReport
Scenario Outline: To Start PDF Report 
  	When I create a PDF report based on "<pdfReport_enabled>"
  	
  	#for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}
    
@WF_09_verifyRequestStatus
Scenario Outline: To check the request status completion 
			Given I navigate to "<menuName>" page
			And Check the status of the request before task Completion "<RequestName>"  
			When I search for a particular task "<taskName>" of "<taskType>" in "<userOrteam>" section and edit based on "<gridData>" in "<myTask>" 
			And I completed the "<taskName>" task based on "<taskAction>" 
			Then  I navigate to "My Request" page 
			And Check the status of the request after task Completion "<RequestName>" 
			And validate the status of the request "<RequestStatus>"
			
			#for csv, txt, xls files specify datafile location
			Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'RequestExecution'}