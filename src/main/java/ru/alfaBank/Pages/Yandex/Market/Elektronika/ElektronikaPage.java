package ru.alfaBank.Pages.Yandex.Market.Elektronika;

import ru.alfaBank.Pages.Yandex.Market.Elektronika.Headphones.HeadphonesPage;
import ru.alfaBank.Pages.Yandex.Market.Elektronika.MobilePhones.MobilePhonesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.alfaBank.Pages.Yandex.Market.MarketPage;

public class ElektronikaPage extends MarketPage {

    public ElektronikaPage(WebDriver driver) {
        super(driver);
    }

    public MobilePhonesPage getMobylnyeTelefony (WebDriver driver){
        driver.findElement(By.cssSelector("a[href*='mobilnye-telefony']")).click();
        return new MobilePhonesPage(driver);
    }

    public HeadphonesPage getHeadphones (WebDriver driver){
        driver.findElement(By.cssSelector("._9qbcyI_fyS[href*='naushniki']")).click();
        return new HeadphonesPage(driver);
    }
}
