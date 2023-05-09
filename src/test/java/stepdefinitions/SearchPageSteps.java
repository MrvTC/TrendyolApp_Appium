package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;
import utils.DriverManager;


public class SearchPageSteps {

    SearchPage searchPage=new SearchPage(DriverManager.getDriver());

    @Then("should see the Search Page")
    public void shouldSeeTheSearchPage() {


searchPage.checkBackIcon();

    }

    @When("sendkeys Search Area {string} on Search Page")
    public void sendkeysSearchAreaOnSearchPage(String text) {



searchPage.sendKeysSearchArea(text);

    }
}
