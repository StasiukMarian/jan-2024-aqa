package base.pages;

import base.config.PageTools;

import static base.helpers.CustomConditions.*;
import static com.codeborne.selenide.Condition.*;


public class LoginPage extends PageTools {
    private final String usernameInput = "user-name";
    private final String passwordInput = "password";
    private final String submitButton = "//input[@type='submit']";

    /*TYPE METHODS*/
    public void typeUsername(String username) {
        shouldBe("id", inputCondition, usernameInput);
        type("id", username, usernameInput);
    }

    public void typePassword(String password) {
        shouldBe("id", inputCondition, passwordInput);
        type("id", password, passwordInput);
    }

    /*CLICK METHODS*/
    public void clickSubmitButton() {
        shouldBe("xpath", clickable, submitButton);
        click("xpath", submitButton);
    }
}
