package stepdefinitions;

import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.basketPage;
import utils.DriverManager;

public class basketPageSteps {

basketPage basketPage=new basketPage(DriverManager.getDriver());

ProductPageSteps productPageSteps=new ProductPageSteps();


    @And("should see Same Product Name on Basket Page")
    public void shouldSeeSameProductNameOnBasketPage() {

        String productName = productPageSteps.productName;
        String currentProductName= basketPage.getProductName();
        Assert.assertEquals(currentProductName,productName);


    }

    @When("taps Delete Button on Basket Page")
    public void tapsDeleteButtonOnBasketPage() {

        basketPage.clickDeleteButton();


    }

    @And("taps Delete Popup on Basket Page")
    public void tapsDeletePopupOnBasketPage() {


        basketPage.clickPopupDeleteButton();

    }

    @Then("should see Empty Message {string} on Basket Page")
    public void shouldSeeEmptyMessageOnBasketPage(String message) {


        String currentMessage= basketPage.getEmptyMessage();
        Assert.assertEquals(currentMessage,message);


    }

    @Then("should see the Basket Page")
    public void shouldSeeTheBasketPage() {

        basketPage.checkTitle();

    }


}
