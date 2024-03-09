package library.modules.common.adapters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static drivers.Driver.driver;

public class CheckboxesHandler {
    public static void setCheckboxes(boolean state, String... values) {
        for (String value : values) {
            WebElement checkboxLabel = driver.findElement(By.xpath("//label[contains(@for,'checkbox') and text()='" + value + "']"));
            WebElement checkbox = checkboxLabel.findElement(By.xpath(".//preceding-sibling::input"));

            if (checkbox.isSelected() != state) {
                WebDriverActions.scrollToElementAndClick(checkboxLabel);
            }
        }
    }

    public static String getSelectedCheckboxesLabelsList() {
        List<WebElement> checkboxes = driver.findElements(By.xpath("//label[contains(@for,'checkbox')]//preceding-sibling::input"));
        List<String> checkedCheckboxesLabels = checkboxes.stream()
                .filter(WebElement::isSelected)
                .map(checkbox -> checkbox.findElement(By.xpath(".//following-sibling::label")).getText())
                .collect(Collectors.toList());

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
