package gui.lesson6;

import base.Pages;
import base.config.BaseTest;
import org.testng.annotations.Test;

import static base.helpers.Constants.*;

public class FrameWorkTest extends BaseTest {

    @Test
    public void frameworkTest(){
        Pages.loginPage().typeUsername(username);
        Pages.loginPage().typePassword(password);

        Pages.loginPage().clickSubmitButton();

        System.out.println(Pages.mainPage().getHeaderLogoText());

        System.out.println(Pages.mainPage().getItemHeadersText());

        Pages.mainPage().getItemHeaders().get(1).click();
    }
}
