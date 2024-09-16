package base.pages;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutOverviewPage {
    private final String items = "//div[@class='inventory_item_name']";
    private final String finishButton = "finish";

    /*get methods*/

    public List<String> getItemTexts() {
        return $$(byXpath(items)).texts();
    }
    /*click methods*/

    public void clickFinishButton() {
        $(byId(finishButton)).shouldBe(clickable).click();
    }
}
