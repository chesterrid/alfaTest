package Steps;

import org.junit.Test;
import ru.alfaBank.Base;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseSteps extends Base {

    public BaseSteps(WebDriver driver) {
        super(driver);
    }

    public static void compare(Object a, Object b) {
        assertThat(a).isEqualTo(b);
    }

    public static void saveDateToNameFile(String searchSystemName, String browserName, String content) throws IOException {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        File file = new File(dateFormat.format(date) + browserName + searchSystemName + ".txt");
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write(content);
        out.close();
    }

    public static String getBrowserName(WebDriver driver) {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        return cap.getBrowserName().toLowerCase();
    }

    public static WebDriver changeTab(String oldHandler, WebDriver driver) {
        Set<String> listHandler = driver.getWindowHandles();
        listHandler.remove(oldHandler);
        return driver.switchTo().window(listHandler.iterator().next());
    }


}