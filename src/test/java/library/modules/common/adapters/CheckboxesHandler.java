package library.modules.common.adapters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static drivers.Driver.driver;

public class CheckboxesHandler {
    public static void setCheckboxes(boolean state, String... values){
        for (String value : values){
            WebElement checkbox = driver.findElement(By.xpath("//label[contains(@for,'checkbox') and text()='"+value+"']"));

            if (checkbox.findElement(By.xpath(".//preceding-sibling::input"))
                    .isSelected() != state){
                WebDriverActions.scrollToElementAndClick(checkbox);
            }
        }
    }
}
