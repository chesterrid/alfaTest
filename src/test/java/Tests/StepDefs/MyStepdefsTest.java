package Tests.StepDefs;

import Tests.RunTest;
import Steps.BaseSteps;
import cucumber.api.java.After;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import ru.alfaBank.Pages.Yandex.YandexPage;
import ru.alfaBank.Pages.Yandex.Market.Elektronika.ElektronikaPage;
import ru.alfaBank.Pages.Yandex.Market.Elektronika.Headphones.HeadphonesPage;
import ru.alfaBank.Pages.Yandex.Market.Elektronika.MobilePhones.MobilePhonesPage;
import ru.alfaBank.Pages.Yandex.Market.MarketPage;
import ru.alfaBank.Pages.Yandex.Market.ProductPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MyStepdefsTest extends RunTest {
    private String titlePhone;
    private String mainHandler;
    private String titleSearchSystem;
    private String browserName;
    private String content;

    private YandexPage yandexPage = new YandexPage(driver);
    private MarketPage marketPage = new MarketPage(driver);
    private ProductPage productSamsung = new ProductPage(driver);
    private ElektronikaPage elektronikaPage = new ElektronikaPage(driver);
    private MobilePhonesPage mobilePhonesPage = new MobilePhonesPage(driver);
    private HeadphonesPage headPhonesPage = new HeadphonesPage(driver);
    String aa;
    @Before
    public void setDriver (){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void closeDriver (){
        driver.close();
    }

    @Given("^Go to Yandex$")
    public void goToYandex() {
        yandexPage = yandexPage.inputToPage(driver);
        titleSearchSystem = driver.getTitle();
    }

    @When("^Get data about the browser and search engine$")
    public void getDataAboutTheBrowserAndSearchEngine() {
        titleSearchSystem = driver.getTitle();
        browserName = BaseSteps.getBrowserName(driver);
    }

    @When("^Find the site of Alfa-Bank through search engines$")
    public void findTheSiteOfAlfaBankThroughSearchEngines() {
        yandexPage.inputMethod(driver, "Альфа Банк", true);
        mainHandler = driver.getWindowHandle();
        driver.findElement(By.cssSelector("a.link_theme_outer[href='https://alfabank.ru/']")).click();
    }

    @When("^Go to the market, subsection electronics$")
    public void goToTheMarketSubsectionElectronics() {
        yandexPage.goToMarket();
    }

    @When("^Filter Samsung smartphones$")
    public void filterSamsungSmartphones() throws InterruptedException {
        elektronikaPage = marketPage.getElektronika(driver);
        mobilePhonesPage = elektronikaPage.getMobylnyeTelefony(driver);
        mobilePhonesPage.selectBrand(mobilePhonesPage.samsung);
    }

    @When("^Make a filter at a price of (\\d+) rubles$")
    public void makeAFilterAtAPriceOfRubles(String defineCostFrom) throws InterruptedException{
        mobilePhonesPage.priceFrom(driver,defineCostFrom);
    }
    @When("^Take the name of the first smartphone, remember it and follow in discription of the smartphone$")
    public void takeTheNameOfTheFirstSmartphoneRememberIt() {
        titlePhone = mobilePhonesPage.getTitleFirstObjectAndGoTheDescription("");
    }
    @Then("^Compare that the display name of the product in the description is the same as the one you remembered$")
    public void compareThatTheDisplayNameOfTheProductInTheDescriptionIsTheSameAsTheOneYouRemembered() {
        BaseSteps.compare(titlePhone,productSamsung.getTitleProduct(driver));
    }

    @When("^Filter Beats headphones$")
    public void filterBeatsHeadphones() throws InterruptedException{
        elektronikaPage = marketPage.getElektronika(driver);
        headPhonesPage = elektronikaPage.getHeadphones(driver);
        headPhonesPage.selectBrand(headPhonesPage.nameBrandBeats);
    }

    @When("^Make a filter at a price from (\\d+) to (\\d+) rubles$")
    public void makeAFilterAtAPriceFromToRubles(String from, String to) throws InterruptedException{
        headPhonesPage.priceFrom(driver,from);
        headPhonesPage.priceTo(driver,to);
    }

    @When("^Take the name of the first headphones, remember it and follow in discription of the headphones$")
    public void takeTheNameOfTheFirstHeadphonesRememberIt() {
        titlePhone = headPhonesPage.getTitleFirstObjectAndGoTheDescription("");
        System.out.println(titlePhone);
    }

    @When("^Go to the section \"Jobs$")
    public void goToTheSectionJobs(){
        BaseSteps.changeTab(mainHandler,driver);
        driver.findElement(By.cssSelector(".footer-content__23RLk [href*='job.alfabank.ru']")).click();
    }

    @When("^On the website job.alfabank.ru go to the section \"about working in a bank\"$")
    public void onTheWebsiteJobAlfabankRuGoToTheSectionAboutWorkingInABank() {
        driver.findElement(By.cssSelector("a[href='/home']")).click();

    }

    @Then("^Save info to file$")
    public void saveInfoToFile() throws IOException {
        content = driver.findElement(By.cssSelector("div.container h3.font-white")).getText();
        List<WebElement>elementList = driver.findElements(By.cssSelector(".inline-top-sm-64 div.container div[class='top-32']"));
        for (WebElement element : elementList){
            content +="\n"+ element.getText();
        }
        BaseSteps.saveDateToNameFile(titleSearchSystem,browserName,content);
    }

    @Test
    public void tedt (String aaa){
        aaa = "qwrf1";
        aaa.charAt(1);
    }

    
}
