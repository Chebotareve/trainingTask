package test;

import framework.pages.AllToDoPage;
import framework.pages.CompletedToDoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToDoTest extends BaseTest {
    private AllToDoPage allToDoPage = new AllToDoPage();
    private CompletedToDoPage completedToDoPage = new CompletedToDoPage();

    @Test
    public void MarkItemAsCompletedTest() {
        String newElementText = "text1";
        allToDoPage.addItem(newElementText)
                .markAsCompleted(newElementText);
        completedToDoPage.open();
        Assert.assertTrue(completedToDoPage.toDoItemPresentInTheList(newElementText));
    }


}
