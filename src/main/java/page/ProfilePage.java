package page;


import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends Page {
    @FindBy(xpath = "//div[@class='rt-noData']")
    public WebElement tableState;
    @FindBy(xpath = "//li[@id='item-3']")
    public WebElement profile;

    @FindBy(xpath = "//button[@id='gotoStore']")
    public WebElement goToBookStoreButton;

    @FindBy(xpath = "//span[@title='Delete']")
    public List<WebElement> bookRow;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("открыть страницу /profile")
    public void open() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", profile);
        profile.click();
    }
    @Step("Получение значения таблицы")
    public String tableState() {
        return tableState.getText();
    }

    public void goToBookStore() {
        goToBookStoreButton.click();
    }

    public int amountOfBooks() {
        return bookRow.size();
    }

    @Step("Удалить книги")
    public void deleteBooks(int quantity) {
        for(int i=0; i<=quantity;i++) {
            bookRow.get(i).click();
        }
    }
}



