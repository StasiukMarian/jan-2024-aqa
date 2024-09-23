package gui.lesson7;

import base.Pages;
import base.config.BaseTest;
import base.pages.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static base.helpers.Constants.password;
import static base.helpers.Constants.username;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DetailItemTest extends BaseTest {

    @Test
    public void detailItemTest(){
        Pages.loginPage().typeUsername(username);
        Pages.loginPage().typePassword(password);

        Pages.loginPage().clickSubmitButton();

        List<Item> itemListFromMainPage = Pages.mainPage().getItemList();

//        Pages.mainPage().clickHeaderNameByText("Sauce Labs Bolt T-Shirt");
        Pages.mainPage().clickHeaderNameByPosition(3);

        Item detailedItem = Pages.detailItemPage().getDetailedItem();

        Assert.assertTrue(itemListFromMainPage.contains(detailedItem), "Item is not exist in the list");
    }
}
