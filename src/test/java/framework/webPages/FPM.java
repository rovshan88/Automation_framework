package framework.webPages;

import org.openqa.selenium.By;

public class FPM {


    public class portfolioPage extends BasePage {
        // locators
        private By loadMorningPosition = By.xpath("//a[contains(text(),'Load Morning Positions')]']");

        // methods

        public void clickOnSignUpDarkSkyApi(){
            clickOn(loadMorningPosition);
        }

    }

}
