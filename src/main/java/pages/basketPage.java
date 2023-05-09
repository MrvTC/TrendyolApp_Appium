package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class basketPage {

    ElementHelper elementHelper;

    By title = By.id("trendyol.com:id/textLeftUp");
    By productName = By.id("trendyol.com:id/textViewBrandName");

    By deleteButton = By.id("trendyol.com:id/imageViewDeleteProduct");
    By deletePopupButton = By.id("trendyol.com:id/textViewBasketRemoveAction");
    By emptyButton = By.id("trendyol.com:id/textViewMessage");

    public basketPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkTitle() {

        elementHelper.checkElement(title);

    }

    public String getProductName() {


        return elementHelper.getText(productName);

    }

    public void clickDeleteButton() {


elementHelper.click(deleteButton);

    }


    public void clickPopupDeleteButton() {

        elementHelper.click(deletePopupButton);



    }


    public String getEmptyMessage() {


        return elementHelper.getText(emptyButton);

    }




}
