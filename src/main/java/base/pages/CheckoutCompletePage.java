package base.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutCompletePage {
    private final String completeHeader = "//h2[@class='complete-header']";

    /*boolean methods*/
    public boolean isCompleteMessageExists() {
        return $(byXpath(completeHeader)).is(visible);
    }
}
