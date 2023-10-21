package page;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected final WebDriver driver;
    protected final String BASE_URL = "https://demoqa.com/login";



    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void open() throws InterruptedException;
}
