package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.FilterPage;

import utils.DriverManager;

public class FilterPageSteps {

    FilterPage filterPage = new FilterPage(DriverManager.getDriver());

    @Then("should see the Filter Page")
    public void shouldSeeTheFilterPage() {
        filterPage.checkFilterItem();
    }

    @When("taps Filter {string} on Filter Page")
    public void tapsFilterOnFilterPage(String item) {
        filterPage.clickCheckBoxFilterItem(item);
    }

    @When("taps List Products {string} on Filter Page")
    public void tapsListProductsOnFilterPage(String button) {
        String currentButton = filterPage.getListProduct();
        Assert.assertTrue(currentButton.contains(button));
        filterPage.clickListProduct();
    }
}
