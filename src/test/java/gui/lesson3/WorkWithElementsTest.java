package gui.lesson3;

import base.config.BaseTest;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WorkWithElementsTest extends BaseTest {

    public static String getFilePathByName(String fileName){
        return new File ("src/main/resources/files/" + fileName).getAbsolutePath();
    }
//    @Test
    public void hover(){
        $(byXpath("//nav/div[1]")).hover();

        $(byXpath("//nav/div[1]//a[text()='Fullstack']")).click();
    }

//    @Test
    public void downloadFileTest() throws IOException {
        File download = $(byXpath("(//h3/a)[1]")).scrollTo().download();

        String path = download.getPath();

        System.out.println(path);

        FileUtils.deleteDirectory(new File("build/downloads"));
    }

//    @Test
    public void uploadFile(){
        $(byXpath("//input[@type='file']")).uploadFile(new File(getFilePathByName("annual-enterprise-survey-2023-financial-year-provisional.csv")));
    }

    @Test
    public void doubleClick(){
        $(byId("container-text")).doubleClick();
    }
//    @Test
    public void workWithElements() throws InterruptedException {
//        $(byClassName("form_input")).append("standard_user");

//        $(byName("user-name")).append("standard_user");
//        $("input").append("standard_user");

        $(byAttribute("placeholder", "Username")).append("standard_user");

        $(byId("password")).append("secret_sauce");

//        $(byAttribute("placeholder", "Username")).clear();

//        String value = $(byAttribute("placeholder", "Username")).getValue();

//        for (int i = 0; i < value.length(); i++) {
//            Selenide.actions().sendKeys($(byAttribute("placeholder", "Username")), Keys.BACK_SPACE).perform();
//        }

        $(byXpath("//input[@Value='Login']")).click();

        Selenide.refresh();

//        $(byXpath("//select[@class='product_sort_container']")).click();


//        $(byXpath("//select[@class='product_sort_container']/option[3]")).click();

        String text = $(byXpath("//div[@class='app_logo']")).text();

        System.out.println(text);

        List<String> texts = $$(byXpath("//div[@class='inventory_item_name ']")).texts();

        for (String s : texts) {
            System.out.println(s);
        }

//        int i = $$(byXpath("//div[@class='inventory_item_name ']")).texts().indexOf("Sauce Labs Onesie");

//        while ($$(byXpath("//button[text()='Add to cart']")).size() > 0){
//            $(byXpath("//button[text()='Add to cart']")).click();
//        }

//        $(byText("Sauce Labs Fleece Jacket")).click();
//        $(byTagAndText("div", "Sauce Labs Fleece Jacket")).click();


//        $(byXpath("//select[@class='product_sort_container']")).pressEscape();
//        $(byValue("Login")).submit();
//        $(byValue("Login")).click();
//        $(byValue("Login")).pressEnter();
//        Selenide.actions().sendKeys(Keys.ENTER).perform();


//        $(byXpath("//a[text()='LinkedIn']")).click();
//
//
//        Selenide.switchTo().window(1);
//        Thread.sleep(5000);
//
//        $(byXpath("//button[contains(@class, 'modal__dismiss')]//icon")).click();
//        $(byXpath("//icon[@data-test-id='nav-logo']")).click();
//
//        Selenide.closeWindow();
//
//        Selenide.switchTo().window(0);
//
//        $(byTagAndText("div", "Sauce Labs Fleece Jacket")).click();
    }
}
