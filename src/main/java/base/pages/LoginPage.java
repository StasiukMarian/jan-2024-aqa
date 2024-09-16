package base.pages;

import static base.helpers.CustomConditions.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final String usernameInput = "user-name";
    private final String passwordInput = "password";
    private final String submitButton = "//input[@type='submit']";

    /*TYPE METHODS*/
    public void typeUsername(String username) {
        $(byId(usernameInput)).shouldBe(inputCondition).append(username);
    }

    public void typePassword(String password) {
        $(byName(passwordInput)).shouldBe(inputCondition).append(password);
    }

    /*CLICK METHODS*/
    public void clickSubmitButton() {
        $(byXpath(submitButton)).shouldBe(clickable).click();
    }
}
