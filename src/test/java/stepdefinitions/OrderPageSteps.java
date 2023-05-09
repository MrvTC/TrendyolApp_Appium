package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OrderPage;
import utils.DriverManager;

public class OrderPageSteps {

    OrderPage orderPage=new OrderPage(DriverManager.getDriver());
    @Then("should see the Order Page")
    public void shouldSeeTheOrderPage() {

        orderPage.checkPopupClose();



    }

    @When("taps Option {string} on Order Page")
    public void tapsOptionOnOrderPage(String option) {

orderPage.clickOption(option);


    }
}
