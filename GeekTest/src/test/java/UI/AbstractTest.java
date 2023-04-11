package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public abstract class AbstractTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;


// перед запуском всех тестов, настройка среды тестрирования
    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();}

//перед каждым тестом инициализация driver Chrome:
        @BeforeEach
        void initDriver() {
            driver = new ChromeDriver();
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            actions = new Actions(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

            initMainPage();
        }




//бросить исключение
    void initMainPage() {
        Assertions.assertDoesNotThrow( ()-> getDriver().navigate().to("https://test-stand.gb.ru/login/"),"Страница не доступна");
    }

    //после каждого теста выход:
    @AfterEach
    void close() {
        checkBrowser();
        if(driver !=null) driver.quit();
    }

    public void checkBrowser() {
        List<LogEntry> allLogRows = getDriver().manage().logs().get(LogType.BROWSER).getAll();
        if(!allLogRows.isEmpty()){

            if (allLogRows.size() > 0 ) {
                allLogRows.forEach(logEntry -> {
                    System.out.println(logEntry.getMessage());
                });
            }
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }


}
