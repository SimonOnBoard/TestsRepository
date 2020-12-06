package tests2.helpers;

import org.openqa.selenium.WebDriver;
import tests2.ApplicationManager;

public class HelperBase {
    protected WebDriver driver;
    protected ApplicationManager applicationManager;

    public HelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }
}
