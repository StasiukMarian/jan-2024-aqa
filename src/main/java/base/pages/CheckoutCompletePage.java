package base.pages;

import base.config.PageTools;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutCompletePage extends PageTools {
    private final String completeHeader = "//h2[@class='complete-header']";

    /*boolean methods*/
    public boolean isCompleteMessageExists() {
        return isElementExist("xpath", completeHeader);
    }
}
