package framework.webPages;

import org.openqa.selenium.By;

public class DarkSkyApi extends BasePage {
    // locators
    private By signUp = By.xpath("//a[text()= 'Sign Up']");

    // methods

    public void clickOnSignUpDarkSkyApi(){
        clickOn(signUp);
    }

}
