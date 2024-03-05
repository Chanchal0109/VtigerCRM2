package commonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
////import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ListenerImplimentation implements ITestListener {

	ExtentReports report;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		//.String methodName = result.getMethod().getMethodName();
		Reporter.log(result.getMethod().getMethodName()+" Testscript execution is started", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" Testscript execution is passed", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" Testscript execution is failed "+message , true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" Testscript execution is skipped", true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//String methodName = result.getMethod().getMethodName();
		//Reporter.log("To start the execution", true);
		
		
		JavaUtil ju = new JavaUtil();
		int a = ju.getRandomNumber();
		// use ExtentSparkReporter class just to configure extentreport
		ExtentSparkReporter reporter=new ExtentSparkReporter("./extentReport/report"+a+".ht ml");
		reporter.config().setDocumentTitle("VtigerCRM");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Chanchal");
		
		//use extenreporter class to generate ExtentReport
		 report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS","Windows");
		report.setSystemInfo("Broswer","Chrome");
		report.setSystemInfo("Chromeversion","122.0.6261.95");
		report.setSystemInfo("Author","Chanchal");
				
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
         //String methodName = result.getMethod().getMethodName();
		//Reporter.log("To finish the exection", true);
		
		report.flush();
		
		
	}

	
}


//package commonUtils;
//
//import org.testng.ITestContext;
//
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.testng.Reporter;
//
//public class ListenerImplementation implements ITestListener {
//
//
//
//	@Override
//	public void onTestStart(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//		String methodname = result.getMethod().getMethodName();
//		Reporter.log(methodname+"Testscript Execution is started",true);
//	}
//
//	@Override
//	public void onTestSuccess(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//		String a = result.getMethod().getMethodName();
//		Reporter.log(a+"testscript is passed",true);
//	}
//
//	@Override
//	public void onTestFailure(ITestResult result) {
//		// TODO Auto-generated method stub
//		String message = result.getThrowable().toString();
//		String methodname = result.getMethod().getMethodName();
//		Reporter.log(methodname+"Execution is failed"+message,true);
//	}
//
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//		String methodname = result.getMethod().getMethodName();
//		Reporter.log(methodname+"Execution is skipped",true);
//	}
//
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onStart(ITestContext context) {
//		// TODO Auto-generated method stub
//		
//		Reporter.log("Execution is started",true);
//	}
//
//	@Override
//	public void onFinish(ITestContext context) {
//		// TODO Auto-generated method stub
//		
//		Reporter.log("Execution is finishd",true);
//	}
//	
//	
//	
//	
//	
//	
//	
//}
