package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductPage;
import utils.DriverManager;

public class ProductPageSteps {

    ProductPage productPage = new ProductPage(DriverManager.getDriver());

    static String productName;

    @Then("should see the Product Page")
    public void shouldSeeTheProductPage() {

        productPage.checkImage();


    }

    @When("save Product Name on Product Page")
    public void saveProductNameOnProductPage() {


        productName=productPage.getProductName();

    }

    @And("taps Add To Basket {string} on Product Page")
    public void tapsAddToBasketOnProductPage(String button) {

        String currentButton = productPage.getAddToBasket();
        Assert.assertEquals(currentButton, button);
        productPage.clickAddToBasket();


    }

    @And("taps Size {string} on Product Page")
    public void tapsSizeOnProductPage(String size) {

        productPage.clickSize(size);


    }

    @And("taps Size Add to Basket on Product Page")
    public void tapsSizeAddToBasketOnProductPage() {

        productPage.clickSizeAddToBasket();


    }

}
