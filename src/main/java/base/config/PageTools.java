package base.config;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;

import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PageTools {
    protected String locatorFormatter(String locator, Object... args) {
        return String.format(locator, args);
    }

    protected SelenideElement shouldBe(String locatorType, WebElementCondition condition, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                return $(byXpath(locatorFormatter(locator, args))).shouldBe(condition);
            case "id":
                return $(byId(locatorFormatter(locator, args))).shouldBe(condition);
            case "name":
                return $(byName(locatorFormatter(locator, args))).shouldBe(condition);
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    protected void click(String locatorType, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                $(byXpath(locatorFormatter(locator, args))).click();
                break;
            case "id":
                $(byId(locatorFormatter(locator, args))).click();
                break;
            case "name":
                $(byName(locatorFormatter(locator, args))).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    protected String getText(String locatorType, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                return $(byXpath(locatorFormatter(locator, args))).text();
            case "id":
                return $(byId(locatorFormatter(locator, args))).text();
            case "name":
                return $(byName(locatorFormatter(locator, args))).text();
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    protected ElementsCollection getElements(String locatorType, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                return $$(byXpath(locatorFormatter(locator, args)));
            case "id":
                return $$(byId(locatorFormatter(locator, args)));
            case "name":
                return $$(byName(locatorFormatter(locator, args)));
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    protected List<String> getElementsText(String locatorType, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                return $$(byXpath(locatorFormatter(locator, args))).texts();
            case "id":
                return $$(byId(locatorFormatter(locator, args))).texts();
            case "name":
                return $$(byName(locatorFormatter(locator, args))).texts();
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    protected void type(String locatorType, String text, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                $(byXpath(locatorFormatter(locator, args))).append(text);
                break;
            case "id":
                $(byId(locatorFormatter(locator, args))).append(text);
                break;
            case "name":
                $(byName(locatorFormatter(locator, args))).append(text);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    protected boolean isElementExist(String locatorType, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                return $(byXpath(locatorFormatter(locator, args))).is(Condition.visible);
            case "id":
                return $(byId(locatorFormatter(locator, args))).is(Condition.visible);
            case "name":
                return $(byName(locatorFormatter(locator, args))).is(Condition.visible);
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }


}
