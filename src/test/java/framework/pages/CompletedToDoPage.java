package framework.pages;

import org.openqa.selenium.By;

public class CompletedToDoPage extends BasePage {
    private static final By BTN_Completed = By.xpath("//a[text()='Completed']");

    @Override
    public BasePage open() {
        browser.click(BTN_Completed);
        return this;
    }
}
