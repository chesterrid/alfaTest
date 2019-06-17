package ru.alfaBank.Pages.Yandex.Market.Elektronika.Headphones;

import org.openqa.selenium.WebDriver;
import ru.alfaBank.Pages.Yandex.Market.ProductPage;


public class HeadphonesPage extends ProductPage {

    public HeadphonesPage(WebDriver driver) {
        super(driver);
    }

    public String nameBrandBeats = "label[for='7893318_8455647']";
}
