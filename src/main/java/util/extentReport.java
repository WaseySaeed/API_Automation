package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReport {

    public static ExtentReports extentReport;

    public static ExtentReports createInstance(String reportName)
    {
        extentReport = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("ApiAutomation.html");
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("utf-8");
        extentReport.attachReporter(extentSparkReporter);
        return extentReport;
    }

    public static void logPassDetails(String log) {
        listener.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }
    public static void logFailureDetails(String log) {
        listener.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }

    public static void logInfo(String log)
    {
        listener.extentTest.get().info(MarkupHelper.createCodeBlock(log, CodeLanguage.JSON));
    }

}
