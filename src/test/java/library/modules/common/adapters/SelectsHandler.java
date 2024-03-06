package library.modules.common.adapters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static drivers.Driver.driver;

public class SelectsHandler {
    public static void fillSelectAutocompleteSingle(WebElement selectElement, String optionValue){
        WebDriverActions.scrollToElementAndClick(selectElement);

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .visibilityOf(selectElement.findElement(By.xpath(".//div[contains(@class,'-menu')]"))));

        selectElement.findElement(By.xpath(".//input")).sendKeys(optionValue);

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .visibilityOf(selectElement.findElement(By.xpath(".//div[contains(@class,'-menu')]//div[contains(@id,'option-0')]"))));

        selectElement.findElement(By.xpath(".//input")).sendKeys(Keys.RETURN);
    }

    public static void fillSelectAutocompleteMulti(WebElement selectElement, String... optionValues){
        for (String optionValue : optionValues){
            selectElement.findElement(By.xpath(".//input")).sendKeys(optionValue);

            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                    .visibilityOf(selectElement.findElement(By.xpath(".//div[contains(@class,'-menu')]//div[contains(@id,'option-0')]"))));

            selectElement.findElement(By.xpath(".//input")).sendKeys(Keys.RETURN);
        }
    }

    public static String getSelectMultiValues(WebElement selectElement){
        List<WebElement> valuesElements = selectElement.findElements(By.xpath("//div[contains(@class,'multi-value__label')]"));
        List<String> values = new ArrayList<>();

        valuesElements.forEach(webElement -> {
           values.add(webElement.getText());
        });

        return String.join(", ", values);
    }
}
