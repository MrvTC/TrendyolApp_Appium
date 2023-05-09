package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class FilterPage {

    ElementHelper elementHelper;

    By filterItem = By.id("trendyol.com:id/textViewFilterTitle");
    By listProductButton = By.id("trendyol.com:id/btnApplyFilter");
    By checkBoxfilterItem;

    public FilterPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkFilterItem() {
        elementHelper.checkElement(filterItem);
    }

    public void clickFilterItem(String item) {
        elementHelper.clickElementWithText(filterItem, item);
    }

    public void clickCheckBoxFilterItem(String item) {

        String locator = "//android.widget.TextView[@text=\"" + item + "\"]/../android.widget.CheckBox";
        elementHelper.click(By.xpath(locator));
    }

    public String getListProduct() {
        return elementHelper.getText(listProductButton);
    }

    public void clickListProduct() {
        elementHelper.click(listProductButton);
    }


}
