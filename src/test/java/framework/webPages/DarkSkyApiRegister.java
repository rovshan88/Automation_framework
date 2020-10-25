package framework.webPages;

import org.openqa.selenium.By;

public class DarkSkyApiRegister extends BasePage{
    //Locator
    private By RegisterHeader = By.xpath("//h1[text()='Register']");

    // methods
    public String getPageHeader() {

        return getTextFromElement(RegisterHeader);
    }


}
