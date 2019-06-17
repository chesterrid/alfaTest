package ru.alfaBank.Pages.Yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.alfaBank.Base;
import ru.alfaBank.Pages.Yandex.Market.MarketPage;

public class YandexPage extends Base {
    public YandexPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public YandexPage inputToPage(WebDriver driver){
        driver.get("https://yandex.ru/");
        return new YandexPage(driver);
    }

    public MarketPage goToMarket (){
        driver.findElement(By.cssSelector("a[data-id='market']")).click();
            return new MarketPage(driver);
    }

    public void inputMethod (WebDriver driver, String dataForSearch, boolean click){
        driver.findElement(By.cssSelector(".input__control"))
                .sendKeys(dataForSearch);
        if (click){
            driver.findElement(By.cssSelector(".button_theme_websearch")).click();
        }
    }
}
