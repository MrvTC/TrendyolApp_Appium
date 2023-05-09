package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class OrderPage {

    ElementHelper elementHelper;


    By popupCloseIcon = By.id("trendyol.com:id/imageViewClose");

    By options = By.id("trendyol.com:id/radioButtonSortingTypeItem");


    public OrderPage(WebDriver driver) {

        this.elementHelper = new ElementHelper(driver);
    }

    public void checkPopupClose() {

elementHelper.checkElement(popupCloseIcon);

    }

    public void clickOption(String option) {

elementHelper.clickElementWithText(options,option);

    }
}
