package pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class Homepage {


    ElementHelper elementHelper;

    By searchArea = By.id("trendyol.com:id/search_view_inner_container");
    By popupCloseIcon = By.id("trendyol.com:id/imageViewTooltipClose");

    public Homepage(WebDriver driver) {

        this.elementHelper = new ElementHelper(driver);
    }

    public void clickPopupClose() {

elementHelper.click(popupCloseIcon);

    }

    public void checkSearchArea() {

elementHelper.checkElement(searchArea);

    }

    public void clickSearchArea() {

elementHelper.click(searchArea);

    }





}
