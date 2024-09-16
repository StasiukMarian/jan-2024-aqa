package base.pages;


import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ShoppingCardPage {
    private final String addedItems = "//div[@class='inventory_item_name']";
    private final String checkoutButton = "checkout";

    /*get methods*/
    public List<String> getAddedItemNames() {
        return $$(byXpath(addedItems)).texts();
    }
    /* click methods*/
    public void clickCheckoutButton(){
        $(byName(checkoutButton)).shouldBe(clickable).click();
    }
}
