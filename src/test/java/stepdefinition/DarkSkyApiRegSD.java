package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyApi;
import framework.webPages.DarkSkyApiRegister;
import framework.webPages.HomePage;
import org.testng.Assert;


public class DarkSkyApiRegSD {
    private HomePage homePage = new HomePage();
    private DarkSkyApi darkSkyApi = new DarkSkyApi();
    private DarkSkyApiRegister darkSkyApiRegister = new DarkSkyApiRegister();

    @Given("^I am on the darksky Register page$")
    public void iAmonRegisterpage () {
        homePage.clickOnDarkApiSky();

  }
    @When("^I click on Register button$")
    public void Register (){
        darkSkyApi.clickOnSignUpDarkSkyApi();
    }
    @Then("^I verify I am on Register page by asserting Register header$")
    public void VerifyHeader (){
        Assert.assertEquals(darkSkyApiRegister.getPageHeader(), "Register");

    }

}
