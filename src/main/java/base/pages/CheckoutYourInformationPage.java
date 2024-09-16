package base.pages;

import static base.helpers.CustomConditions.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutYourInformationPage {
    private final String firstNameInput = "first-name";
    private final String lastNameInput = "lastName";
    private final String zipInput = "Zip/Postal Code";
    private final String continueButton = "Continue";

    /*type methods*/

    public void fillYourInformation(String firstName, String lastName, String zip) {
        $(byId(firstNameInput)).shouldBe(inputCondition).append(firstName);
        $(byName(lastNameInput)).shouldBe(inputCondition).append(lastName);
        $(byAttribute("placeholder", zipInput)).shouldBe(inputCondition).append(zip);
    }

    /*click methods*/
    public void clickContinueButton() {
        $(byValue(continueButton)).shouldBe(clickable).click();
    }
}
