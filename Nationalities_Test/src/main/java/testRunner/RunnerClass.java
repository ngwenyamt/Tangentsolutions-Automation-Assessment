package testRunner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.File;

@CucumberOptions(features = "src/main", glue = "stepDefinitions",
        plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}
)

@Test
public class RunnerClass extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void setup()
    {
        Reporter.loadXMLConfig(new File("src/main/resources/extent-config.xml"));
        Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
        Reporter.setSystemInfo("User Name", "Tebogo Ngwenya");
        Reporter.setSystemInfo("Application Name", "Rise App -Practice Management System");
        Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
        Reporter.setTestRunnerOutput("Rise App Nationality Test Report");
    }

}