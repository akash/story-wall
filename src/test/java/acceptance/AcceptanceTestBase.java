package acceptance;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class AcceptanceTestBase {

    HtmlUnitDriver driver;

    public AcceptanceTestBase() {
        this.driver = new HtmlUnitDriver();
    }
}
