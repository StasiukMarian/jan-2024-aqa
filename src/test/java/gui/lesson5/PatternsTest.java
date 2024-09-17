package gui.lesson5;

import base.Pages;
import base.config.BaseTest;

import base.pages.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static base.helpers.Constants.*;

public class PatternsTest extends BaseTest {

//    LoginPage loginPage = new LoginPage();
//    MainPage mainPage = new MainPage();
//    ShoppingCardPage shoppingCardPage = new ShoppingCardPage();
//    CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage();
//    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
//    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @BeforeMethod
    public void login() {
        Pages.loginPage().typeUsername(username);
        Pages.loginPage().typePassword(password);
        Pages.loginPage().clickSubmitButton();
    }

    @Test
    public void test() {
        Pages.mainPage().waitAppLogo();

        String itemNameFromMainPage = Pages.mainPage().getItemHeadersText().get(0);

        Pages.mainPage().addBackPackToShoppingCard();
        Pages.mainPage().clickOnShoppingCardLink();

        String itemNameFromShoppingCard = Pages.shoppingCardPage().getAddedItemNames().get(0);

        Assert.assertEquals(itemNameFromMainPage, itemNameFromShoppingCard, "items are not equal");

        Pages.shoppingCardPage().clickCheckoutButton();

        Pages.checkoutYourInformationPage().fillYourInformation(firstName, lastName, zip);
        Pages.checkoutYourInformationPage().clickContinueButton();

        String itemNameFromOverviewPage = Pages.checkoutOverviewPage().getItemTexts().get(0);

        Assert.assertEquals(itemNameFromMainPage, itemNameFromOverviewPage, "items are not equal");

        Price price = Pages.checkoutOverviewPage().getPrice();

        Assert.assertEquals(price.getTotalWithTax(), price.getItemTotal() + price.getTax());

        Pages.checkoutOverviewPage().clickFinishButton();

        Assert.assertTrue(Pages.checkoutCompletePage().isCompleteMessageExists(), "order failed");
    }

}
