package tests1.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests1.ApplicationManager;

import java.util.List;

public class ClickerHelper extends HelperBase {

    public ClickerHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void clickSaveButton() {
        driver.findElement(By.cssSelector(".toolbar__button-wrapper > .button .button__icon")).click();
    }

    public void clickOnNewMailButton() {
        driver.findElement(By.cssSelector(".button__inner")).click();
    }

    public void openMenuByClickingOnIcon() {
        // 12 | click | css=.toolbar__button-wrapper > .button .button__icon |
        driver.findElement(By.cssSelector(".toolbar__button-wrapper > .button .button__icon")).click();
    }

    public void clickOnCreateNewNoteIcon() {
        // 14 | click | css=.toolbar__button-wrapper > .button-wrapper:nth-child(3) .button__inner |
        driver.findElement(By.cssSelector(".toolbar__button-wrapper > .button-wrapper:nth-child(3) .button__inner")).click();
    }

    public void clickOnNotes() {
        // 13 | click | css=.folder-list__item:nth-child(3) .folder |
        driver.findElement(By.cssSelector(".folder-list__item:nth-child(3) .folder")).click();
    }

    public void clickOnDrafts() {
        // 13 | click | css=.folder-list__item:nth-child(3) .folder |
        driver.findElement(By.cssSelector(".folder-list__item:nth-child(5) .folder")).click();
    }

    public void clickOnSendButton() {
        driver.findElement(By.cssSelector(".toolbar__button-wrapper_right > .button > .button__inner")).click();
    }

    public void openMenu() {
        driver.findElement(By.cssSelector(".toolbar__button-wrapper > .button > .button__inner")).click();
    }

    public void clickOnFirstRow() {
        driver.findElement(By.xpath("//*[@id='m_msglistcontainer']/tbody/tr["+ 1 +"]")).click();
    }

    public void clickOnDraftsByLinkAfterSaving() {
        driver.findElement(By.linkText("\"Черновики\"")).click();
    }

    public void deleteCurrentMessage() {
        driver.findElement(By.cssSelector(".button-wrapper:nth-child(2) .button__icon")).click();
    }
}
