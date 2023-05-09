package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class ProductPage {

    ElementHelper elementHelper;

    By image = By.id("trendyol.com:id/imageview_product_detail_slider");
    By productName = By.id("trendyol.com:id/textViewBrandName");
    By addToBasket = By.id("trendyol.com:id/primaryButton");
    By sizes = By.id("trendyol.com:id/textViewValue");
    By sizeAddToBasket = By.id("trendyol.com:id/buttonAddToBasketOrChooseVariant");

    public ProductPage(WebDriver driver) {

        this.elementHelper = new ElementHelper(driver);
    }

    public void checkImage() {

        elementHelper.checkElement(image);

    }

    public String getProductName() {

        return elementHelper.getText(productName);

    }

    public String getAddToBasket() {

        return elementHelper.getText(addToBasket);

    }


    public void clickAddToBasket() {

        elementHelper.click(addToBasket);

    }


    public void clickSize(String size) {

        elementHelper.clickElementWithText(sizes, size);


    }

    public void clickSizeAddToBasket() {

        elementHelper.click(sizeAddToBasket);


    }


}
