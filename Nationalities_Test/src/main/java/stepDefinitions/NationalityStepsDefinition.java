
package stepDefinitions;

import PageObjects.NationalityPageObject;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class NationalityStepsDefinition {
    public static NationalityPageObject riseapp_page_object;
    public static WebDriver driver;
    @Given("^Login to RiseApp portal using valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void loginToRiseAppPortalUsingValidAnd(String arg0, String arg1)  {
        // launch the URL

        File file = new File(".\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        try
        {
            riseapp_page_object = PageFactory.initElements(driver, NationalityPageObject.class);
            driver.get("https://staging.riseapp.co.za/");
            Thread.sleep(10000);

            //clear the username field
            riseapp_page_object.username.clear();
            //enter username
            riseapp_page_object.username.sendKeys(arg0);
            //clear password field
            riseapp_page_object.password.clear();
            //enter password
            riseapp_page_object.password.sendKeys(arg1);
            captureScreenShot(driver);
            //click login
            riseapp_page_object.loginButton.click();
            captureScreenShot(driver);
            Thread.sleep(6000);
            Assert.assertTrue(true);

        }
        catch (Exception e) {
            System.out.print("Unable to access the Rise App URL. server might be down or not able to find the element(s)");
            Assert.assertTrue(false);
            e.printStackTrace();
        }
    }
    @Then("^User navigate to Lookups > Nationalities$")
    public void userNavigateToLookupsNationalities() {

        try
        {
            //Toggle button click
            riseapp_page_object = PageFactory.initElements(driver, NationalityPageObject.class);
            riseapp_page_object.toggleClick.click();

            captureScreenShot(driver);
            //lookup button click
            Thread.sleep(5000);
            riseapp_page_object.lookupClick.click();
            captureScreenShot(driver);

            //nationality button click
            Thread.sleep(5000);
            riseapp_page_object.nationalityClick.click();
            captureScreenShot(driver);

            Assert.assertTrue(true);
        }
        catch (Exception e) {
            System.out.print("Unable to find the toggle/lookup/nationality button element(s)");
            Assert.assertTrue(false);
            e.printStackTrace();
        }

    }

    @And("^User Add a new Nationality - \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userAddANewNationalityAnd(String arg0, String arg1){

        try
        {
            captureScreenShot(driver);
            //click nationality button
            Thread.sleep(5000);
            riseapp_page_object.addNationalityClick.click();

            Thread.sleep(2000);
            //input name
            riseapp_page_object.addName.sendKeys(arg0);

            Thread.sleep(2000);
           // input description
            riseapp_page_object.addDescription.sendKeys(arg1);
            captureScreenShot(driver);
            Thread.sleep(2000);
            // input description
            riseapp_page_object.saveButton.click();
            captureScreenShot(driver);
            String result = riseapp_page_object.addResult.getText();//checking if the nationality was added successfully
            String checkExisting = riseapp_page_object.existingNationality.getText();//checking if the nationality already exist
            Thread.sleep(3000);


            if(result.contains("Nationality successfully Created"))// checking if the nationality was added or not
            {
                Assert.assertTrue(true);
            }
            else if(checkExisting.contains("Nationality with this Name already exists."))// checking if the nationality already exist or not
            {
                Assert.assertTrue(true);
                driver.navigate().to("https://staging.riseapp.co.za/lookup/nationalities/list/");
            }
            else
            {
                Assert.assertTrue(false);
                System.out.print("Add functionality not working as expected");
            }
        }
        catch (Exception e) {
            System.out.print("Unable to find the element(s)");
            Assert.assertTrue(false);
            e.printStackTrace();
        }

    }
    @And("^User View the Nationality$")
    public void userViewTheNationality() {
        try
        {
            riseapp_page_object = PageFactory.initElements(driver, NationalityPageObject.class);
            captureScreenShot(driver);
            Thread.sleep(2000);
            captureScreenShot(driver);
           String view = riseapp_page_object.viewNationality.getText();
           if(view.contains("Tebogo Test Name fields"))
           {
               Assert.assertTrue(true);
           }
           else
           {
               Assert.assertTrue(false);
               System.out.print("Unable to find the added nationality");
           }

        }
        catch (Exception e) {
            System.out.print("Unable to find the added nationality record");
            Assert.assertTrue(false);
            e.printStackTrace();
        }

    }

    @And("^User Edit the added Nationality - \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEditTheAddedNationalityAnd(String arg0, String arg1){

        try
        {
            riseapp_page_object = PageFactory.initElements(driver, NationalityPageObject.class);
            captureScreenShot(driver);

            riseapp_page_object.navigateToUpdate.click();
            Thread.sleep(2000);
            captureScreenShot(driver);
            riseapp_page_object.clickUpdateButton.click();
            //clear the fields
            captureScreenShot(driver);
            riseapp_page_object.updateName.clear();
            riseapp_page_object.updateDescription.clear();
            //input name
            riseapp_page_object.updateName.sendKeys(arg0);
            captureScreenShot(driver);

            Thread.sleep(2000);
            // input description
            riseapp_page_object.updateDescription.sendKeys(arg1);
            captureScreenShot(driver);
            Thread.sleep(2000);
            // input description
            riseapp_page_object.saveUpdate.click();
            captureScreenShot(driver);
            String result = riseapp_page_object.addResult.getText();//checking if the nationality was added successfully
            Thread.sleep(3000);

            if(result.contains("Nationality successfully Updated"))// checking if the nationality was added or not
            {
                Assert.assertTrue(true);
            }
            else if(result.contains("Nationality with this Name already exists."))
            {
                Assert.assertTrue(true);
                driver.navigate().to("https://staging.riseapp.co.za/lookup/nationalities/list/");
                captureScreenShot(driver);
            }
            else
            {
                Assert.assertTrue(false);
                System.out.print("Update functionality not working as expected");
            }

        }
        catch (Exception e) {
            System.out.print("Unable to find the updated nationality record");
            Assert.assertTrue(false);
            e.printStackTrace();
        }

    }

    @And("^User Delete the Nationality$")
    public void userDeleteTheNationality() {
        try
        {
            riseapp_page_object = PageFactory.initElements(driver, NationalityPageObject.class);
            captureScreenShot(driver);
            Thread.sleep(2000);

            riseapp_page_object.filterRecordsButton.click();
            captureScreenShot(driver);

            riseapp_page_object.searchInput.sendKeys("Test Edit name");
            captureScreenShot(driver);

            riseapp_page_object.filter.click();
            captureScreenShot(driver);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1700)", "");
            Thread.sleep(3000);

            riseapp_page_object.navigateToDelete.click();
            Thread.sleep(3000);
            String getUrl = driver.getCurrentUrl().concat("delete");
            driver.get(getUrl);
            captureScreenShot(driver);

            Thread.sleep(3000);

            riseapp_page_object.confirmDelete.click();
            Thread.sleep(3000);
            captureScreenShot(driver);

        }
        catch (Exception e) {
            System.out.print("Unable to find the added nationality record");
            Assert.assertTrue(false);
            e.printStackTrace();
        }

    }

    public static void captureScreenShot(WebDriver ldriver){
// Take screenshot
        File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
        try {

            FileUtils.copyFile(src, new File(".\\Test Evidence\\"+System.currentTimeMillis()+".png"));                              } catch (IOException e)

        {
            System.out.println(e.getMessage());
        }
    }

}
