package gui.lesson4;

import base.config.BaseTest;
import com.codeborne.selenide.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ConditionTest extends BaseTest {

    @Test
    public void checkboxesTest() {
//        System.out.println($(byXpath("//input[@type='checkbox']")).is(checked));
//        $(byXpath("//input[@type='checkbox']")).shouldBe(clickable).click();
//        System.out.println($(byXpath("//input[@type='checkbox']")).is(checked));

//        Assert.assertTrue($(byXpath("//input[@type='checkbox']")).is(checked), "checkbox is not checked");

        ElementsCollection checkboxes = $$(byXpath("//input[@type='checkbox']"));

        for (int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).shouldBe(visible).click();
            Assert.assertTrue(checkboxes.get(i).is(checked));
        }

        $(byXpath("//input[@type='text']")).shouldHave(value("100"));

        String valueFromInput = $(byXpath("//input[@type='text']")).getValue();

        Assert.assertEquals(valueFromInput, "100");

    }

    //    @Test
    public void conditionTest() {
        $(byXpath("//input[@placeholder='Username']")).shouldBe(visible, Duration.ofSeconds(30)).append("standard_user");  // явне очікування зникнення елементу

//        System.out.println($(byXpath("//input[@placeholder='Password']")).is(readonly));

//        $(byXpath("//input[@placeholder='Password']")).shouldBe(empty).append("asd");
//        $(byXpath("//input[@placeholder='Password']")).shouldHave(id("password")).append("asd");
//        $(byXpath("//input[@placeholder='Password']")).shouldHave(cssClass("form_input")).append("asd");
//        $(byId("password")).shouldHave(attribute("placeholder", "Password")).append("asd");

        WebElementCondition inputCondition = and("input condition", visible, Condition.empty);
        WebElementCondition conditionClickable = and("clickable", visible, enabled);

        $(byId("password")).shouldBe(inputCondition).append("secret_sauce");

//        $(byXpath("//input[@placeholder='Password']")).shouldHave(value("asd")).append("asd");
//        $(byXpath("//input[@placeholder='Password']")).shouldBe(not(empty)).append("asd");

//        System.out.println($(byXpath("//h3[@data-test='error']")).is(hidden) + " hidden before click");
//        System.out.println($(byXpath("//h3[@data-test='error']")).is(visible) + " visible before click");

        $(byXpath("//input[@type='submit']")).shouldBe(conditionClickable).submit();

//        System.out.println($(byXpath("//h3[@data-test='error']")).is(hidden) + " hidden after click");
//        System.out.println($(byXpath("//h3[@data-test='error']")).is(visible) + " visible after click");

        $(byXpath("//div[@class='app_logo']")).shouldBe(visible, Duration.ofSeconds(20));

//        $(byXpath("(//div[@class='inventory_item_name '])[1]")).shouldHave(text("Backpack")).click();
//        $(byXpath("(//div[@class='inventory_item_name '])[1]")).shouldHave(exactText("sauce labs Backpack")).click();
//        $(byXpath("(//div[@class='inventory_item_name '])[1]")).shouldHave(or("test", exactTextCaseSensitive("Sauce labs Backpack"), textCaseSensitive("backpack"))).click();


//        $$(byXpath("//div[@class='inventory_item_name ']")).shouldBe((CollectionCondition.empty)).texts();
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(size(6)).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(sizeNotEqual(0)).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(sizeGreaterThan(5)).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(sizeGreaterThanOrEqual(6)).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(sizeLessThan(7)).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(sizeLessThanOrEqual(6)).texts());

//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(texts("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)")).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(textsInAnyOrder( "Sauce Labs Bike Light","Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)")).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(exactTexts(List.of("Sauce Labs backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"))).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(exactTextsCaseSensitive(List.of("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"))).texts());

        String textFromItemOne = $$(byXpath("//div[@class='inventory_item_name ']")).get(0).text();

        Assert.assertEquals(textFromItemOne, "Sauce Labs Backpack", "Items are not equals");
        Assert.assertNotEquals(textFromItemOne, "Sauce Labs ackpack", "Items are equals");

        Assert.assertTrue($$(byXpath("//div[@class='inventory_item_name ']")).size() == 6, "");
        Assert.assertFalse($$(byXpath("//div[@class='inventory_item_name ']")).size() == 6, "");

//        Selenide.sleep(10000); неявне очікування
    }
}
