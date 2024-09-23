package base.pages;

import base.config.PageTools;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends PageTools {
    private final String headerLogo = "//body//*[text()='Swag Labs']";
    private final String items = "//div[@class='inventory_item_name ']";
    private final String itemHeaderByName = "//div[@class='inventory_item_name ' and text()='%s']";
    private final String itemHeaderByPosition = "(//div[@class='inventory_item_name '])[%d]";
    private final String itemDescriptions = "//div[@class='inventory_item_desc']";
    private final String itemPrices = "//div[@class='inventory_item_price']";
    private final String backpackButton = "add-to-cart-sauce-labs-backpack";
    private final String shoppingCardLink = "//a[@class='shopping_cart_link']";

    /*waiter*/
    public void waitAppLogo() {
        $(byXpath(headerLogo)).shouldBe(visible, Duration.ofSeconds(30));
    }

    /*get methods*/

    public String getHeaderLogoText() {
        shouldBe("xpath", visible, headerLogo);
        return getText("xpath", headerLogo);
    }

    public ElementsCollection getItemHeaders() {
        return getElements("xpath", items);
    }

    public List<String> getItemHeadersText() {
        return getElementsText("xpath", items);
    }

    public List<Item> getItemList() {
        List<Item> itemList = new ArrayList<>();

        List<String> headersList = getElementsText("xpath", items);
        List<String> descriptionsList = getElementsText("xpath", itemDescriptions);
        List<String> pricesList = getElementsText("xpath", itemPrices);

        for (int i = 0; i < headersList.size(); i++) {
            Item item = new Item();

            item.setHeader(headersList.get(i));
            item.setDescription(descriptionsList.get(i));
            item.setPrice(pricesList.get(i));

            itemList.add(item);
        }
        return itemList;
    }
    /*click methods*/

    public void addBackPackToShoppingCard() {
        $(byId(backpackButton)).shouldBe(clickable).click();
    }

    public void clickOnShoppingCardLink() {
        $(byXpath(shoppingCardLink)).shouldBe(clickable).click();
    }

    public void clickHeaderNameByText(String name) {
        shouldBe("xpath", clickable, itemHeaderByName, name);
        click("xpath", itemHeaderByName, name);
    }

    public void clickHeaderNameByPosition(int position) {
        shouldBe("xpath", clickable, itemHeaderByPosition, position);
        click("xpath", itemHeaderByPosition, position);
    }
}
