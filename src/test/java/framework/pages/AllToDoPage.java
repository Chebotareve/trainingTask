package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AllToDoPage extends BasePage {
    private static final By BTN_All = By.xpath("//a[text()='All']");

    public AllToDoPage addItem(String text) {
        browser.type(TXT_ToDoInput, text);
        browser.hitKey(TXT_ToDoInput, Keys.RETURN);
        return this;
    }

    public AllToDoPage markAsCompleted(String text) {
        browser.tickCheckBox(CB_Done);
        return this;
    }

    @Override
    public AllToDoPage open() {
        browser.click(BTN_All);
        return this;
    }

}
