package gui.lesson8;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.clipboard;

public class TasksTest {

    //    @Test
    public void progressTest() {
        Selenide.open("https://demoqa.com/progress-bar");

        $(byId("startStopButton")).shouldBe(clickable).click();

        //#1
//        while (true) {
//            if ($(byXpath("//div[@role='progressbar']")).getText().equals("50%")) {
//                break;
//            }
//        }
        //#2

        $(byXpath("//div[@role='progressbar']")).shouldBe(text("50%"), Duration.ofSeconds(20));

        $(byId("startStopButton")).shouldBe(clickable).click();

        Assert.assertEquals($(byXpath("//div[@role='progressbar']")).getText(), "50%");
    }

    //    @Test
    public void alertTest() {
        Selenide.open("https://demoqa.com/alerts");

        $(byId("confirmButton")).scrollTo().click();
        Selenide.sleep(4000);
        Selenide.dismiss();

        String actualText = $(byId("confirmResult")).getText();

        Assert.assertEquals(actualText, "You selected Cancel");
    }

    @Test
    public void shadowCSS() {
        Selenide.open("http://uitestingplayground.com/shadowdom");

        $(shadowCss("#buttonGenerate", "guid-generator")).shouldBe(clickable).click();

        String valueFromInput = $(shadowCss("#editField", "guid-generator")).shouldBe(visible).getValue();

        System.out.println(valueFromInput);

        $(shadowCss("#buttonCopy", "guid-generator")).shouldBe(clickable).click();

        String textFromClipboard = clipboard().getText();

        System.out.println(textFromClipboard);

        Assert.assertEquals(valueFromInput, textFromClipboard);

        // Selenide.switchTo().frame($("[id='iframe']"));// iframe
    }
}
