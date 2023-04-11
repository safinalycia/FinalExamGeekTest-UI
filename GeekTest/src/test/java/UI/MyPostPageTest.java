package UI;

import io.qameta.allure.Attachment;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MyPostPageTest extends AbstractTest{



    @Test
    @DisplayName("Выдача своих постов")
    void postTest() throws IOException, InterruptedException {
        MyPostPage myPostPage = new MyPostPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        assertTrue(myPostPage.getPost1().isDisplayed());
        assertTrue(myPostPage.getPost2().isDisplayed());
        assertTrue(myPostPage.getPost3().isDisplayed());
        assertTrue(myPostPage.getPost4().isDisplayed());
    }

    @Test
    @DisplayName("Наличие title у постов")
    public void postsTitleTest() throws InterruptedException, IOException {
        MyPostPage myPostPage = new MyPostPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        assertTrue(myPostPage.getPost1_title().isDisplayed());
        assertTrue(myPostPage.getPost2_title().isDisplayed());
        assertTrue(myPostPage.getPost3_title().isDisplayed());
        assertTrue(myPostPage.getPost4_title().isDisplayed());
    }

    @Test
    @DisplayName("Наличие description у постов")
    public void postsDescriptionTest() throws InterruptedException, IOException {
        MyPostPage myPostPage = new MyPostPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        assertTrue(myPostPage.getPost1_description().isDisplayed());
        assertTrue(myPostPage.getPost2_description().isDisplayed());
        assertTrue(myPostPage.getPost3_description().isDisplayed());
        assertTrue(myPostPage.getPost4_description().isDisplayed());
    }

    @Test
    @DisplayName("Наличие картинок у постов")
    public void postsImgTest() throws InterruptedException, IOException {
        MyPostPage myPostPage = new MyPostPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        assertTrue(myPostPage.getPost1_img().isDisplayed());
        assertTrue(myPostPage.getPost2_img().isDisplayed());
        assertTrue(myPostPage.getPost3_img().isDisplayed());
        assertTrue(myPostPage.getPost4_img().isDisplayed());
    }

    @Test
    @DisplayName("Наличие заглушки при отсутствии изображения")
    void imgPlaceholderTest() throws InterruptedException, IOException {
        MyPostPage myPostPage = new MyPostPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        assertTrue(myPostPage.getPost1_img().isDisplayed());
        assertEquals("https://test-stand.gb.ru/placeholder/800x600.gif", myPostPage.getPost1_img_src());
    }

    @Test
    @DisplayName("Обрезка картинок соотношение сторон 2:3")
    public void postAspectRatioTest() throws InterruptedException, IOException {
        MyPostPage myPostPage = new MyPostPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        getDriver().get("https://test-stand.gb.ru/?page=2");
        Thread.sleep(3000);
        assertEquals("0.6666666666666667", myPostPage.getImg1AspectRatio());
        assertEquals("0.6666666666666667", myPostPage.getImg2AspectRatio());
        assertEquals("0.6666666666666667", myPostPage.getImg3AspectRatio());
        assertEquals("0.6666666666666667", myPostPage.getImg4AspectRatio());
    }

    @Test
    @DisplayName("Переход на следующую страницу")
    public void nextPageTest() throws InterruptedException, IOException {
        MyPostPage myPostPage = new MyPostPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        myPostPage.nextPage();
        Thread.sleep(2000);
        assertEquals("https://test-stand.gb.ru/?page=2", getDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Переход на предыдущую страницу 1 со страницы 2")
    public void previousPageTest() throws InterruptedException, IOException {
        MyPostPage myPostPage = new MyPostPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        getDriver().get("https://test-stand.gb.ru/?page=2");
        Thread.sleep(3000);
        myPostPage.previousPage();
        Thread.sleep(3000);
       // saveScreen("Переход на предыдущую страницу");
        assertEquals("https://test-stand.gb.ru/?page=1", getDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Переход с 1 страницы на предыдущую")
    public void firstPageTest() throws InterruptedException, IOException {
        MyPostPage myPostPage = new MyPostPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        myPostPage.previousPage();
        Thread.sleep(2000);
        assertEquals("https://test-stand.gb.ru/", getDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Переход на следующую страницу 4 со страницы 3")
    public void lastPageTest() throws InterruptedException, IOException {
        MyPostPage myPostPage = new MyPostPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        getDriver().get("https://test-stand.gb.ru/?page=3");
        Thread.sleep(3000);
        myPostPage.nextPage();
        Thread.sleep(2000);
        assertEquals("https://test-stand.gb.ru/?page=4", getDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Сортировка  в порядке убывания и возрастания")
    void orderTest() throws InterruptedException, IOException {
        MyPostPage myPostPage = new MyPostPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        myPostPage.change_order();
        Thread.sleep(3000);
        assertEquals("https://test-stand.gb.ru/?sort=createdAt&order=DESC", getDriver().getCurrentUrl());
        myPostPage.change_order();
        Thread.sleep(3000);
        assertEquals("https://test-stand.gb.ru/?sort=createdAt&order=ASC", getDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Сортировка по умолчанию(в порядке возрастания)")
    void orderDefaultTest() throws InterruptedException, IOException {
        MyPostPage myPostPage = new MyPostPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        getDriver().get("https://test-stand.gb.ru/?sort=createdAt&order=ASC");
        Thread.sleep(3000);
        String firstImgSrc = myPostPage.getPost1_img_src();
        myPostPage.clickHome();
        Thread.sleep(2000);
        assertEquals(firstImgSrc, myPostPage.getPost1_img_src());
    }

    @Test
    @DisplayName("Переход на чужие посты со своей страницы в порядке возрастания")
    public void NotMyPostsTest() throws InterruptedException, IOException {
        MyPostPage myPostPage = new MyPostPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        myPostPage.switchToNotMyPosts();
        Thread.sleep(3000);
        assertEquals("https://test-stand.gb.ru/?owner=notMe&sort=createdAt&order=ASC", getDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Переход по кнопке Home на главную страницу")
    public void homeTest() throws InterruptedException, IOException {
        MyPostPage myPostPage = new MyPostPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        getDriver().get("https://test-stand.gb.ru/?owner=notMe&sort=createdAt&order=ASC");
        Thread.sleep(3000);
        myPostPage.clickHome();
        Thread.sleep(2000);
        assertEquals("Blog", myPostPage.getTitle_Blog());
    }

    @Test
    @DisplayName("Сообщение об отсутствии постов от страницы без постов")
    void postsTest() throws InterruptedException, IOException {
        MyPostPage myPostPage = new MyPostPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginMax20();
        Thread.sleep(5000);
        assertEquals("No items for your filter", myPostPage.getMessage());
    }

}
