package UI;


import io.qameta.allure.Description;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class AuthPageTest extends AbstractTest{



    public AuthPageTest() {
    }

//Description -для отчета allure//

    @Test
    @DisplayName("Валидные логин и пароль")
    @Description("Valid username and password")
    public void LoginValidTest() throws InterruptedException, IOException {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(5000);
        assertEquals("https://test-stand.gb.ru/", getDriver().getCurrentUrl());
        assertEquals("Hello, SLE", authPage.getLogin());
    }


    @Test
    @DisplayName("Логин меньше 3х букв, валидный пароль")
    @Description("Invalid username less then3 and valid password")
    public void loginLessThen3Test() throws InterruptedException {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginLessThen3();
        Thread.sleep(5000);
        Assertions.assertEquals("https://test-stand.gb.ru/login", getDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Логин 20 букв, валидный пароль")
    @Description("Valid username max20 and valid password")
    public void loginMax20Test() throws InterruptedException {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginMax20();
        Thread.sleep(1000);
        assertEquals("https://test-stand.gb.ru/", getDriver().getCurrentUrl());
        assertEquals("Hello, maxxxsymbolformytest", authPage.getLogin());
    }
    @Test
    @DisplayName("Не зарегистрированный пользователь")
    @Description("Unregistered user")
    public void loginUnregisteredTest() throws IOException {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginUnregistered();
        assertEquals("Invalid credentials.", authPage.getError_message().getText());
        assertEquals("401", authPage.getError_code().getText());
    }

    @Test
    @DisplayName("Логин русские буквы, валидный пароль")
    @Description("Invalid username russian letters and valid password")
    public void loginRusTest() throws InterruptedException {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginRus();
        Thread.sleep(5000);
//        assertEquals("500: Argument is not a ByteString", authPage.getError_message500().getText());
//        assertEquals("500", authPage.getError_code500().getText());
        Assertions.assertEquals("https://test-stand.gb.ru/login", getDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Логин спец.символы, валидный пароль")
    @Description("Invalid username (special characters) and valid password")
    public void loginSpecSymbTest() throws InterruptedException{
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginSpecSymb();
        Thread.sleep(5000);
        Assertions.assertEquals("https://test-stand.gb.ru/login", getDriver().getCurrentUrl());




    }



    @Test
    @DisplayName("Логин больше 20 букв, валидный пароль")
    @Description("Invalid username over 20 symb and valid password")
    public void loginOver20Test() throws InterruptedException{
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginOver20();
        Thread.sleep(5000);
       Assertions.assertEquals("https://test-stand.gb.ru/login", getDriver().getCurrentUrl());


    }

    @Test
    @DisplayName("Логин валидный, пароль не верный")
    @Description("Valid username and incorrect password")
    public void loginInvalidPasswordTest() throws IOException {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginInvalidPassword();
        assertEquals("Invalid credentials.", authPage.getError_message().getText());
        assertEquals("401", authPage.getError_code().getText());
    }


    @Test
    @DisplayName("Пустые поля логин и пароль")
    @Description("Empty values username and password")
    public void loginEmptyLoginAndPasswordTest() throws IOException {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginEmptyLoginAndPassword();
        assertEquals("Invalid credentials.", authPage.getError_message().getText());
        assertEquals("401", authPage.getError_code().getText());
    }


}
