package library.modules.common.adapters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static drivers.Driver.driver;

public class CheckboxesHandler {
    public static void setCheckboxes(boolean state, String... values) {
        for (String value : values) {
            WebElement checkbox = driver.findElement(By.xpath("//label[contains(@for,'checkbox') and text()='" + value + "']"));

            if (checkbox.findElement(By.xpath(".//preceding-sibling::input"))
                    .isSelected() != state) {
                WebDriverActions.scrollToElementAndClick(checkbox);
            }
        }
    }

    public static String getSelectedCheckboxesLabelsList() {
        List<WebElement> checkboxes = driver.findElements(By.xpath("//label[contains(@for,'checkbox')]//preceding-sibling::input"));
        List<String> checkedCheckboxesLabels = new ArrayList<>();

        checkboxes.forEach(checkbox -> {
            if (checkbox.isSelected()) {
                checkedCheckboxesLabels.add(checkbox.findElement(By.xpath(".//following-sibling::label")).getText());
            }
        });

        return String.join(", ", checkedCheckboxesLabels);
    }

    public static String getSelectedRadiobuttonLabel() {
        List<WebElement> radios = driver.findElements(By.xpath("//label[contains(@for,'radio')]//preceding-sibling::input"));

        for (WebElement radio : radios){
            boolean radioState = radio.isSelected();
            if (radioState){
                return radio.findElement(By.xpath(".//following-sibling::label")).getText();
            }
        }

        return null;
    }
}
