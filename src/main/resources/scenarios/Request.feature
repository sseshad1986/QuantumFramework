@Request 
Feature: My Request and Request Admin 

@REQ_00_LaunchNflows 
Scenario Outline: Launching Nflows application 

	Given I launch Nflows application using "<Url_Testing>" 
	When I start recording automation execution based on "<recording_enabled>" 
	
	#for csv, txt, xls files specify datafile location
	Examples: {'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'Environment'} 
	
@REQ_01_NflowsLogin 
Scenario Outline: Login to Nflows 
	Given I login to Nflows with "<username>" and "<password>" credentials 
	
	#for csv, txt, xls files specify datafile location
	Examples: {'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'Nflows_Login'} 
		
@REQ_02_MyRequest 
Scenario Outline: To check my-Request page functionalities 
	Given I navigate to "<menuName>" page 
	And I navigate to new Request page 
	And I click on "<workflowName>" and click on entityRecordLookup button 
	And I check Search functionality for "<searchRequest>" 
	And I select a "<searchInitiation>" request from request pop up based on "<gridData>" initiation fields 
	Then "<validateNewRequest>" Request is successfully triggered and validated in my Request page 
	
	#for csv, txt, xls files specify datafile location
	Examples: {'datafile' : 'src/main/resources/data/Request/RequestExecution.xls','sheetName':'New_Request'} 
			
@REQ_03_verifyRequestStatus 
Scenario Outline: To check the request status completion 
	Given I navigate to "<menuName>" page 
	And Check the status of the request before task Completion "<RequestName>" 
	And validate the status of the request "<RequestStatus>" for "<RequestName>" 
	
	#for csv, txt, xls files specify datafile location
	Examples: {'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'RequestExecution'} 
				
@REQ_04_verifyRequestDates 
Scenario Outline: To check the request baseline and estimated dates 
	Given I navigate to "<menuName>" page 
	When search and Filter the request "<RequestName>" 
	And Get the baseline target date of the request "<RequestName>" 
	And Get the estimated target date of the request "<RequestName>" 
	Then Verify the Baseline target date "<BaselineDate>" for the "<RequestName>" 
	Then Verify the Estimated target date "<EstimatedDate>" for the "<RequestName>"
	
	#for csv, txt, xls files specify datafile location
	Examples: {'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'RequestExecution'} 
					
@REQ_05_validateRequestCompletion 
Scenario Outline: To check the request status completion 
	Given I navigate to "<menuName>" page 
	And Check the status of the request before task Completion "<RequestName>" 
	When I search for a particular task "<taskName>" of "<taskType>" in "<userOrteam>" section and edit based on "<gridData>" in "<myTask>" 
	And I completed the "<taskName>" task of "<taskType>" based on "<taskAction>" 
	Then  I navigate to "My Request" page 
	And Check the status of the request after task Completion "<RequestName>" 
	And validate the status of the request after completion for "<RequestName>" 
	
	#for csv, txt, xls files specify datafile location
	Examples: {'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'RequestExecution'} 
			
@REQ_06_verifyTaskStatus 
Scenario Outline: To check the request status completion 
	Given I navigate to "<menuName>" page 
	And search and Filter the request "<RequestName>" 
	When I expand the Sub workflow grid "<SubWFName>" 
	And Check the status of the task "<taskName>" 
	And validate the status of the task "<TaskStatus>" for "<taskName>"
	
	#for csv, txt, xls files specify datafile location
	Examples: {'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'RequestExecution'} 
							
@REQ_07_verifyTaskDates 
Scenario Outline: To check the task baseline and estimated dates 
	Given I navigate to "<menuName>" page 
	And search and Filter the request "<RequestName>" 
	When I expand the Sub workflow grid "<SubWFName>"
	And Get the baseline target date of the task "<taskName>"  
	And Get the estimated target date of the task "<taskName>" 
	Then Verify the Baseline target date of task"<BaselineDate>" for the "<taskName>" 
	Then Verify the Estimated target date of task"<EstimatedDate>" for the "<taskName>"
	
	#for csv, txt, xls files specify datafile location
	Examples: {'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'RequestExecution'} 
								
@REQ_08_validateTaskCompletion 
Scenario Outline: To validate the task status completion 
	Given I navigate to "<menuName>" page 
	And search and Filter the request "<RequestName>" 
	When I expand the Sub workflow grid "<SubWFName>"
	And Check the status of the task "<taskName>" 
	And I search for a particular task "<taskName>" of "<taskType>" in "<userOrteam>" section and edit based on "<gridData>" in "<myTask>" 
	And I completed the "<taskName>" task of "<taskType>" based on "<taskAction>" 
	Then  I navigate to "My Request" page 
	And I expand the Sub workflow grid "<SubWFName>" 
	And Check the status of the task after task Completion "<taskName>"  
	And validate the status of the task after completion for "<taskName>" 
	
	#for csv, txt, xls files specify datafile location
	
	Examples: {'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'RequestExecution'} 
	
@REQ_09_RecalculateFunction 
Scenario Outline: To validate the recalculate functionality 
	Given I navigate to "<menuName>" page 
	And search and Filter the request "<RequestName>" 
	
	#for csv, txt, xls files specify datafile location
	Examples: {'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'RequestExecution'} 
	
@REQ_10_ISURequestTrigger
Scenario Outline: To trigger the request for ISU workflow
	Given I navigate to "<entityName>" page 
	When Create a Entity record for "<entityName>" with field group "<fieldGroup>" 
	And I edit the "<recordName>" entity record based on "<gridColumn>" coloumn 
	Then I navigate to "My Request" page 
	And search and Filter the request "<RequestName>" 
	And Check the status of the request before task Completion "<RequestName>" 
	And validate the status of the request "On-Track" for "<RequestName>" 
	
    #for csv, txt, xls files specify datafile location
	Examples: {'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'ISURegression'} 
	
@REQ_11_ISUAllApprovalFlow
Scenario Outline: To test the all approval flow scenario in ISU Workflow
#	Given I search for a particular task "<taskName>" of "<taskType>" in "<userOrteam>" section and edit based on "<gridData>" in "<myTask>" 
#	And I completed the "<taskName>" task of "<taskType>" based on "<taskAction>" 
	And I navigate to "<menuName>" page 
	And search and Filter the request "<RequestName>" 
	When I expand the Sub workflow grid "<SubWFName>" 
	And Check the status of the task "<taskName>" 
	And validate the status of the task "Completed" for "<taskName>"
	And Navigate to task view page "<taskName>" 
	#And valiadte the task data
	
#for csv, txt, xls files specify datafile location
	Examples: {'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'ISUWFExecution'} 	
	

@REQ_17_VerifyCancelledRequest 
Scenario Outline: To validate the Request Cancellation
	Given I navigate to "<menuName>" page 
	And Check the status of the request before task Completion "<CancelledRequest>" 
	And Navigate to cancelled request tab 
	And validate the status of the request "Cancelled" for "<CancelledRequest>" 

#for csv, txt, xls files specify datafile location
	
	Examples: {'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'RequestExecution'} 
	
@REQ_18_VerifyCancelledTask
Scenario Outline: To validate the Task Cancellation
Given I navigate to "<menuName>" page 
	And search and Filter the request "<RequestName>" 
	When I expand the Sub workflow grid "<SubWFName>" 
	And Check the status of the task "<CancelledtaskName>" 
	And validate the status of the task "Cancelled" for "<CancelledtaskName>" 
	
	#for csv, txt, xls files specify datafile location
	Examples:
	{'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'RequestExecution'} 
	
@REQ_19_VerifyDelayedRequest 
Scenario Outline: To validate the Delayed Request 
	Given I navigate to "<menuName>" page 
	And search and Filter the request "<DelayedRequest>" 
	And Navigate to Delayed request tab 
	And Check the status of the request before task Completion "<DelayedRequest>" 
	And validate the status of the request "Delayed" for "<DelayedRequest>" 
	#for csv, txt, xls files specify datafile location
	
	Examples:
	{'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'RequestExecution'} 
	
@REQ_20_VerifyDelayedTask 
Scenario Outline: To validate the Task delay 
	Given I navigate to "<menuName>" page 
	And search and Filter the request "<DelayedRequest>" 
	And Navigate to Delayed request tab 
	When I expand the Sub workflow grid "<DelayedSubWFName>" 
	And Check the status of the task "<DelayedtaskName>"  
	And validate the status of the task "Delayed" for "<DelayedtaskName>" 
	#for csv, txt, xls files specify datafile location
	
	Examples:
	{'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'RequestExecution'} 
	
@REQ_21_verifySubWFStatus 
Scenario Outline: To check the Subworkflow status  
	Given I navigate to "<menuName>" page 
	And search and Filter the request "<RequestName>" 
	When I expand the Sub workflow grid "<SubWFName>" 
	And Check the status of the Subworkflow "<SubWFName>"  
	And validate the status of the Subworkflow "<SubwfStatus>" for "<SubWFName>"
	
	#for csv, txt, xls files specify datafile location
	Examples: {'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'RequestExecution'} 
	
@REQ_22_verifySubWFDates 
Scenario Outline: To check the subworkflow baseline and estimated dates 
	Given I navigate to "<menuName>" page 
	And search and Filter the request "<RequestName>" 
	When I expand the Sub workflow grid "<SubWFName>"
	And Get the baseline target date of the subworkflow "<SubWFName>"  
	And Get the estimated target date of the subworkflow "<SubWFName>"  
	Then Verify the Baseline target date of subworkflow  "<SubwfBaselineDate>" for the "<SubWFName>"
	Then Verify the Estimated target date of subworkflow "<SubwfEstimatedDate>" for the "<SubWFName>"
	
	#for csv, txt, xls files specify datafile location
	Examples: {'datafile' : 'src/main/resources/data/RequestExecution.xls','sheetName':'RequestExecution'}	
	
@REQ_31_CreateTestResult
Scenario Outline: To Create Test Result file
	When I create a Test Result file based on "<isExcelReport_enabled>"
	
  	#for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'}	

@REQ_32_CreatePDFReport 
Scenario Outline: To Start PDF Report 
	When I create a PDF report based on "<pdfReport_enabled>" 
	
	#for csv, txt, xls files specify datafile location
	Examples: {'datafile' : 'src/main/resources/data/testData.xls','sheetName':'Environment'} 
    				