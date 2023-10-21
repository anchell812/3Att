package page;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BooksPage extends Page {
    @FindBy(xpath = "//div[@class='action-buttons']")
    public List<WebElement> linkToBook;
    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    public WebElement addToCollectionButton;

    public BooksPage(WebDriver driver) {
        super(driver);
    }

//    @Step("Добавить книгу в коллекцию")
//    public void addBook() {
//        linkToBook.click();
//        addToCollectionButton.click();
//    }

    @Step("Добавить n книг")
    public void addBooks(int quantity) {
        for(int i=1;i<=quantity;i++) {
            linkToBook.get(i).click();
            addToCollectionButton.click();
            Alert alert = new WebDriverWait(driver, ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
            alert.accept();
        }
    }

    @Step("открыть /login")
    public void open() {
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }
}
