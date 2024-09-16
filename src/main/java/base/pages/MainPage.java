package base.pages;

import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final String headerLogo = "//body//*[text()='Swag Labs']";
    private final String items = "//div[@class='inventory_item_name ']";
    private final String backpackButton = "add-to-cart-sauce-labs-backpack";
    private final String shoppingCardLink = "//a[@class='shopping_cart_link']";

    /*waiter*/
    public void waitAppLogo() {
        $(byXpath(headerLogo)).shouldBe(visible, Duration.ofSeconds(30));
    }

    /*get methods*/
    public ElementsCollection getItemHeaders() {
        return $$(byXpath(items)).shouldBe(size(6));
    }

    public List<String> getItemHeadersText() {
        return $$(byXpath(items)).shouldBe(size(6)).texts();
    }

    /*click methods*/

    public void addBackPackToShoppingCard() {
        $(byId(backpackButton)).shouldBe(clickable).click();
    }

    public void clickOnShoppingCardLink() {
        $(byXpath(shoppingCardLink)).shouldBe(clickable).click();
    }
}
