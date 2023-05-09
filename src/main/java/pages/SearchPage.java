package pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class SearchPage {

    ElementHelper elementHelper;

    By searchArea = By.id("trendyol.com:id/edittext_search_view");
    By backIcon = By.id("trendyol.com:id/imageview_action_start");

    public SearchPage(WebDriver driver) {

        this.elementHelper = new ElementHelper(driver);
    }

    public void checkBackIcon() {

       elementHelper.checkElement(backIcon);
    }
    public void sendKeysSearchArea(String text) {

        elementHelper.sendKeys(searchArea,text);
        elementHelper.pressSearch();

    }
}
