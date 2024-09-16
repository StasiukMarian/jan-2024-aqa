package base;

import base.pages.*;

public class Pages {
    private static LoginPage loginPage;
    private static MainPage mainPage;
    private static ShoppingCardPage shoppingCardPage;
    private static CheckoutOverviewPage checkoutOverviewPage;
    private static CheckoutYourInformationPage checkoutYourInformationPage;
    private static CheckoutCompletePage checkoutCompletePage;

    public static LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public static MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public static ShoppingCardPage shoppingCardPage() {
        if (shoppingCardPage == null) {
            shoppingCardPage = new ShoppingCardPage();
        }
        return shoppingCardPage;
    }

    public static CheckoutOverviewPage checkoutOverviewPage() {
        if (checkoutOverviewPage == null) {
            checkoutOverviewPage = new CheckoutOverviewPage();
        }
        return checkoutOverviewPage;
    }

    public static CheckoutYourInformationPage checkoutYourInformationPage() {
        if (checkoutYourInformationPage == null) {
            checkoutYourInformationPage = new CheckoutYourInformationPage();
        }
        return checkoutYourInformationPage;
    }

    public static CheckoutCompletePage checkoutCompletePage() {
        if (checkoutCompletePage == null) {
            checkoutCompletePage = new CheckoutCompletePage();
        }
        return checkoutCompletePage;
    }

}
