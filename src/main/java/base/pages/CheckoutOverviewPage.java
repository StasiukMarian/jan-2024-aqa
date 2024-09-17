package base.pages;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutOverviewPage {
    private final String items = "//div[@class='inventory_item_name']";
    private final String finishButton = "finish";
    private final String itemTotal = "//div[@class='summary_subtotal_label']";
    private final String tax = "//div[@class='summary_tax_label']";
    private final String totalWithTax = "//div[@class='summary_total_label']";

    /*get methods*/

    public List<String> getItemTexts() {
        return $$(byXpath(items)).texts();
    }
    /*click methods*/

    public void clickFinishButton() {
        $(byId(finishButton)).shouldBe(clickable).click();
    }

    public Price getPrice (){
        Price price = new Price();

        price.setItemTotal(Double.parseDouble($(byXpath(itemTotal)).text().replaceAll("[A-Za-z:$]", "").trim()));
        price.setTax(Double.parseDouble($(byXpath(tax)).text().replaceAll("[A-Za-z:$]", "").trim()));
        price.setTotalWithTax(Double.parseDouble($(byXpath(totalWithTax)).text().replaceAll("[A-Za-z:$]", "").trim()));

        return price;
    }
}
