package tests1.helpers;

import org.openqa.selenium.WebDriver;
import tests1.ApplicationManager;

public class HelperBase {
    protected WebDriver driver;
    protected ApplicationManager applicationManager;

    public HelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }
}
