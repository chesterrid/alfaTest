package ru.alfaBank.Pages.Yandex.Market;

import ru.alfaBank.Pages.Yandex.YandexPage;
import ru.alfaBank.Pages.Yandex.Market.Elektronika.ElektronikaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketPage extends YandexPage {
    public MarketPage(WebDriver driver) {
        super(driver);
    }

    public ElektronikaPage getElektronika (WebDriver driver){
        driver.findElement(By.cssSelector(".n-w-tab_type_navigation-menu [href*='elektronika']")).click();
        return new ElektronikaPage(driver);
    }

}
