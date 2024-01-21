package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg
{
static ExtentReports extent;

	public static ExtentReports getReportObject()
	{
		String path= System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new  ExtentSparkReporter(path);
		reporter.config().setReportName("Cloud Automation Result");
		reporter.config().setDocumentTitle("Cyfuture Cloud Test Result");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Varsha kale");
		return extent;
	}
}