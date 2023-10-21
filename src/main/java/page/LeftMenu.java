package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenu extends Page {
    @FindBy(xpath = "//li[@id='item-2']")
    public WebElement bookStore;

    @FindBy(xpath = "//li[@id='item-3']")
    public WebElement profile;

    public LeftMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Перейти в профиль")
    public void goToCollectionBook() {
        profile.click();
    }

    @Step("открыть страницу /books")
    public void open() {
        bookStore.click();
    }
}
