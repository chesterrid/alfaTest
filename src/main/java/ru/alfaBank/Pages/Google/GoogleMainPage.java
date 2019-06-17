package ru.alfaBank.Pages.Google;

import ru.alfaBank.Base;
import org.openqa.selenium.WebDriver;

public class GoogleMainPage extends Base {
    public GoogleMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleMainPage inputToPage(WebDriver driver) {
        driver.get("https://www.google.com/");
        return new GoogleMainPage(driver);
    }
}
