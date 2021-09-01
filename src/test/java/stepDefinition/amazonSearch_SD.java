package stepDefinition;

import base.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.amazonHome_PF;

import java.io.File;
import java.io.IOException;

public class amazonSearch_SD {

    WebDriver driver = null;
    amazonHome_PF  amazonHome_pf=null;
    DriverManager driverManager= new DriverManager();

    @Before(order=1)
    public void cucumebrSetUp(){
        System.out.println("This is First before tag");
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            File screenshots = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] ssContent = FileUtils.readFileToByteArray(screenshots);
            scenario.attach(ssContent,"image/png","Screenshot");
        }
        driver.close();
        System.out.println("This is @After");
    }

    @Given("amazon webpage is launched in {string}")
    public void amazonWebPageIsLaunched(String browserName){

        driver = driverManager.getBrowserDriver(browserName);
        driver.get("https://www.amazon.ca");
        amazonHome_pf = new amazonHome_PF(driver);
    }


    @When("user enter a {string} name")
    public void userEnterAName(String arg0) {

        amazonHome_pf.enterTextInSearchBox(arg0);

    }

    @And("clicks on search button")
    public void clicksOnSearchButton() {

        amazonHome_pf.clickOnSearchButton();

    }

    @Then("search results should be displayed")
    public void searchResultsShouldBeDisplayed() {

        System.out.println("Test using Page Factory is successful");

    }


    @When("user enter a product name from DT")
    public void userEnterAProductNameFromDT(DataTable productName) {

        amazonHome_pf.enterTextInSearchBox(productName.cell(0,0));
        System.out.println(productName.cell(0,0));
        System.out.println(productName.cell(1,1));

    }

    @When("user enter a product name")
    public void userEnterAProductName() {

        amazonHome_pf.enterTextInSearchBox("Mac Book Pro");

    }
}
