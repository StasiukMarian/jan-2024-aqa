package base.pages;

import base.config.PageTools;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends PageTools {
    private final String headerLogo = "//body//*[text()='Swag Labs']";
    private final String items = "//div[@class='inventory_item_name ']";
    private final String backpackButton = "add-to-cart-sauce-labs-backpack";
    private final String shoppingCardLink = "//a[@class='shopping_cart_link']";

    /*waiter*/
    public void waitAppLogo() {
        $(byXpath(headerLogo)).shouldBe(visible, Duration.ofSeconds(30));
    }

    /*get methods*/

    public String getHeaderLogoText(){
        shouldBe("xpath", visible, headerLogo);
        return getText("xpath", headerLogo);
    }
    public ElementsCollection getItemHeaders() {
       return getElements("xpath", items);
    }

    public List<String> getItemHeadersText() {
        return getElementsText("xpath", items);
    }

    /*click methods*/

    public void addBackPackToShoppingCard() {
        $(byId(backpackButton)).shouldBe(clickable).click();
    }

    public void clickOnShoppingCardLink() {
        $(byXpath(shoppingCardLink)).shouldBe(clickable).click();
    }
}
