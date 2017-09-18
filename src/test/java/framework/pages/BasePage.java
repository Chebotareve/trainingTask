package framework.pages;

import framework.utils.Browser;
import org.openqa.selenium.By;

public abstract class BasePage {
    static final By TXT_ToDoInput = By.id("new-todo");
    static final By CB_Done = By.xpath("//input[@type='checkbox']");

    private static final String LBL_ItemByText = "//label[text()='%s']";
    static final Browser browser = new Browser();

    public abstract BasePage open();

    public boolean toDoItemPresentInTheList(String itemText) {
        return browser.isVisible(By.xpath(String.format(LBL_ItemByText, itemText)));
    }
}
