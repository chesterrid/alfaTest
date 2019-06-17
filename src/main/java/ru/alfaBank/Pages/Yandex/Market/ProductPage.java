package ru.alfaBank.Pages.Yandex.Market;

import org.openqa.selenium.WebElement;
import ru.alfaBank.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductPage extends Base {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleProduct (WebDriver driver){
        return driver.findElement(By.cssSelector(".n-title__text")).getText();
    }

    public void priceFrom(WebDriver driver, String cost)throws InterruptedException{
        driver.findElement(By.cssSelector("input[id='glpricefrom']")).sendKeys(cost);
        TimeUnit.SECONDS.sleep(3);
    }

    public void priceTo(WebDriver driver, String cost)throws InterruptedException{
        driver.findElement(By.cssSelector("input[id='glpriceto']")).sendKeys(cost);
        TimeUnit.SECONDS.sleep(3);
    }

    public void selectBrand (String brand)throws InterruptedException {
        driver.findElement(By.cssSelector(brand)).click();
        TimeUnit.SECONDS.sleep(3);
    }

    public String getTitleFirstObjectAndGoTheDescription(String collection){
        List<WebElement> elements = driver.findElements(By.cssSelector(".n-link_theme_blue"));
        String title = elements.get(0).getAttribute("title");
        elements.get(0).click();
        return title;
    }
}
