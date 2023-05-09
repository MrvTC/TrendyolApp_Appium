package pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class GenderPage {

    ElementHelper elementHelper;

    By image = By.xpath("//android.widget.LinearLayout/android.widget.ImageView");
    By buttons = By.className("android.widget.Button");

    public GenderPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkImage() {

elementHelper.checkElement(image);
    }

    public void clickButton(String button) {


        elementHelper.clickElementWithText(buttons,button);

    }



}
