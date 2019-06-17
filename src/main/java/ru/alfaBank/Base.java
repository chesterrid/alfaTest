package ru.alfaBank;

import org.openqa.selenium.WebDriver;

public abstract class Base {
   protected WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public  Object inputToPage (WebDriver driver){
        return new Object();
    }

}
