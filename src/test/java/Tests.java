import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import page.BooksPage;
import page.LeftMenu;
import page.LoginPage;
import page.ProfilePage;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SeleniumJupiter.class)
public class Tests {
    @Test
    @Owner("KabanovaA")
    @DisplayName("Проверка пустой таблицы")
    public void checkProfileTable(WebDriver driver) {
        Properties properties = new Properties();
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        loginPage.open();
        loginPage.auth(properties.getProperty("login"), properties.getProperty("password"));
        loginPage.goToProfilePage();
        assertEquals("No rows found", profilePage.tableState());
    }

    @Test
    @Owner("KabanovaA")
    @DisplayName("Проверка добавления книг")
    public void checkBooksAdded(WebDriver driver) {
        Properties properties = new Properties();
        LoginPage loginPage = new LoginPage(driver);
        BooksPage booksPage = new BooksPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        LeftMenu leftMenu = new LeftMenu(driver);
        loginPage.open();
        loginPage.auth(properties.getProperty("login"), properties.getProperty("password"));
        profilePage.goToBookStore();
        booksPage.addBooks(6);
        leftMenu.goToCollectionBook();
        assertEquals(6, profilePage.amountOfBooks());
    }

    @Test
    @Owner("KabanovaA")
    @DisplayName("Проверка добавления книг сценарий 3")
    public void checkBooksAdded3(WebDriver driver) {
        Properties properties = new Properties();
        LoginPage loginPage = new LoginPage(driver);
        BooksPage booksPage = new BooksPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        LeftMenu leftMenu = new LeftMenu(driver);
        loginPage.open();
        loginPage.auth(properties.getProperty("login"), properties.getProperty("password"));
        profilePage.goToBookStore();
        booksPage.addBooks(2);
        leftMenu.goToCollectionBook();
        profilePage.deleteBooks(2);
        assertEquals("No rows found", profilePage.tableState());
    }
}
