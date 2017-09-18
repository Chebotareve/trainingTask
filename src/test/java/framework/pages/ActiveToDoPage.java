package framework.pages;

import org.openqa.selenium.By;

public class ActiveToDoPage extends BasePage {
    private static final By BTN_Active = By.xpath("//a[text()='Active']");

    @Override
    public BasePage open() {
        browser.click(BTN_Active);
        return this;
    }
}
