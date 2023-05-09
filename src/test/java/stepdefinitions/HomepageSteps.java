package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Homepage;
import utils.DriverManager;

public class HomepageSteps {

    Homepage homepage=new Homepage(DriverManager.getDriver());

    @When("taps Popup Close Button on Home Page")
    public void tapsPopupCloseButtonOnHomePage() {

        homepage.clickPopupClose();


    }

    @Then("should see the Home Page")
    public void shouldSeeTheHomePage() {

homepage.checkSearchArea();


    }

    @When("taps Search Area on Home Page")
    public void tapsSearchAreaOnHomePage() {

homepage.clickSearchArea();


    }
}
