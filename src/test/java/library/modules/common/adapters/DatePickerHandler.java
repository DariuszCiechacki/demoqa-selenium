package library.modules.common.adapters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static drivers.Driver.driver;

public class DatePickerHandler {
    //ToDo add validation for date format/refactor code
    public static void pickDate(WebElement element, String date){
        String[] splitDate = splitDate(date);

        element.click();

        selectYear(splitDate[2]);
        selectMonth(splitDate[1]);
        pickDay(splitDate[0]);
    }

    private static String[] splitDate(String date){
        return date.split("\\.|\\/");
    }

    private static void selectYear(String year){
        Select select = new Select(driver.findElement(By.xpath("//select[contains(@class,'year-select')]")));
        select.selectByValue(year);
    }

    private static void selectMonth(String month){
        int monthIndex = Integer.parseInt(month) - 1;

        new Select(driver.findElement(By.xpath("//select[contains(@class,'month-select')]")))
                .selectByValue(String.valueOf(monthIndex));
    }

    private static void pickDay(String day){
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day') " +
                        "and not(contains(@class,'outside')) and text()='"+day+"']"))
                .click();
    }
}
