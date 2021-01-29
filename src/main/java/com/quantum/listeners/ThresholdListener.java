package com.quantum.listeners;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.quantum.helper.BaseClass;
import com.quantum.helper.ExtentManager;
import com.quantum.utils.ConsoleUtils;
import com.qmetry.qaf.automation.step.QAFTestStepListener;
import com.qmetry.qaf.automation.step.StepExecutionTracker;
import com.qmetry.qaf.automation.step.TestStep;


public class ThresholdListener  extends WebDriverBaseTestPage<WebDriverTestPage> implements ITestListener
{
	//Extent Report Declarations
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Extent Reports Version 3 Test Suite started!");
    }
    
    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
        extent.flush();
    }	

    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest); 

    }
// 
//	public synchronized void onTestSuccess(ITestResult result) 
//    {
//		StepExecutionTracker stepExecutionTracker;
//		stepExecutionTracker=new StepExecutionTracker((TestStep) this);
//				
//		test.get().log(Status.PASS, "TEST CASE Passed IS " + result.getTestName());	
//		test.get().log(Status.PASS, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
//		//test.get().log(Status.PASS, "TEST CASE FAILED IS " + stepExecutionTracker.getStep()); 
//				
//		try 
//		{			
//			test.get().pass("details", MediaEntityBuilder.createScreenCaptureFromPath(BaseClass.getScreenshot()).build());
//		}
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}					
//      
//    }
 
    @Override
    public synchronized void onTestFailure(ITestResult result)
    {  
			if (result.getStatus() == ITestResult.FAILURE) 
			{
				   test.get().log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
				   test.get().log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
				   File scrFile = ((TakesScreenshot) driver) .getScreenshotAs(OutputType.FILE);
				try 
				{
					//FileUtils.copyFile(scrFile, new File("AssertFailure_+ ".jpg"));
					System.out.println();
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}   	              
    }
 
    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());
    }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	

	
}
