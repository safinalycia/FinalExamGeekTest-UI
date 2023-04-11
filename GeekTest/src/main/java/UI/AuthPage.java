package UI;

import org.asynchttpclient.util.Assertions;
import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AuthPage extends AbstractPage{

    //элементы с локацией
    public AuthPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='text']")
    private WebElement input_username;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement input_password;
    @FindBy(xpath = "//button[@form='login']")
    private WebElement button_login;
    @FindBy(xpath = "//div[@class='error-block svelte-uwkxn9']/h2")
    private WebElement error_code;
    @FindBy(xpath = "//div[@class='error-block svelte-uwkxn9']/p[1]")
    private WebElement error_message;
    @FindBy(xpath = "//li[contains(@class, 'surface')]")
    private WebElement button_hello;
    @FindBy(xpath = "//div[@class='container svelte-195leua']/h1")
    private WebElement error_code500;
    @FindBy(xpath = "//div[@class='container svelte-195leua']/p[1]")
    private WebElement error_message500;


//для теста (возврат на страницу авторизации невалидного пользователя, задание не понятное, так как система кривая, регистрирует всех подряд):
   @FindBy(xpath = "//p[contains(text(),'Invalid credentials.')]")
   private WebElement base_url;





    public AuthPage loginValid() {
        input_username.sendKeys("SLE");
        input_password.sendKeys("0a1d07df9a");
        button_login.click();
        return this;
    }
    public AuthPage loginLessThen3() {
        input_username.sendKeys("w");
        input_password.sendKeys("f1290186a5");
        button_login.click();
       // base_url.findElement(By.xpath("//p[contains(text(),'Invalid credentials')]"));
        return this;
    }
    public AuthPage loginMax20() {
        input_username.sendKeys("maxxxsymbolformytest");
        input_password.sendKeys("56f355f664");
        button_login.click();
        return this;
    }
    public AuthPage loginRus() {
        input_username.sendKeys("латиница");
        input_password.sendKeys("e3b0d7af01");
        button_login.click();
        return this;
    }
    public AuthPage loginSpecSymb() {
        input_username.sendKeys("$**@!#");
        input_password.sendKeys("b3b622933e");
        button_login.click();
        return this;
    }


    public AuthPage loginOver20() {
        input_username.sendKeys("SherySherySherySherySher17");
        input_password.sendKeys("06f2baa818");
        button_login.click();
        return this;
    }
    public AuthPage loginUnregistered() {
        input_username.sendKeys("aidakitek");
        input_password.sendKeys("kg68398268");
        button_login.click();
        return this;
    }
    public AuthPage loginInvalidPassword() {
        input_username.sendKeys("SLE");
        input_password.sendKeys("0a1д07df9д");
        button_login.click();
        return this;
    }
    public AuthPage loginEmptyLoginAndPassword() {
        input_username.sendKeys("");
        input_password.sendKeys("");
        button_login.click();
        return this;
    }



    public String getLogin(){
        String login = button_hello.getText();
        return login;
    }

    public WebElement getError_code() {

        return error_code;
    }
    public WebElement getError_message(){
        return error_message;
    }
    public WebElement getError_code500(){return error_code500;}
    public WebElement getError_message500(){return error_message500;}

    public WebElement getBase_url(){
        return base_url;
    }

}
