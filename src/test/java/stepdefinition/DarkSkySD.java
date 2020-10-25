package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class DarkSkySD {

    private HomePage homePage = new HomePage();

    @Given("^I am on DarkSky Home Page$")
    public void iAmOnHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "https://darksky.net/forecast/40.665,-73.958/us12/en",
                "Invalid Home Page");
    }

    @When("^I expand todays timeline$")
    public void iClickOnExpandButton() {
        homePage.clickOnExpandTimeLine();
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void LowTemp() {
        String lowTemp = homePage.getValueOfLowTemp();
        int lastIndex1 = lowTemp.length() - 1;
        lowTemp = lowTemp.substring(0, lastIndex1);
        int lowTemp2 = Integer.valueOf(lowTemp);
        Assert.assertEquals(homePage.LowTempFromTimeline(), lowTemp2);
    }

    public void HighTemp() {
        String highTempString = homePage.getValueOfHighTEmp();
        int lastIndex2 = highTempString.length() - 1;
        highTempString = highTempString.substring(0, lastIndex2);
        int highTemp = Integer.valueOf(highTempString);
        Assert.assertEquals(homePage.HighTempFromTimeline(), highTemp);


    }

    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void IverfyCurrentTemp() {
        Collections.sort(homePage.dailyTempLineNumbers());
        boolean currentisDiaplayedCoreect = true;

        for (int i = 0; i < homePage.dailyTempLineNumbers().size(); i++) {

            if (homePage.currentTempNumb() > i || homePage.currentTempNumb() < i) {

                System.out.println("current temp doen't match temp values from daily tempt line");
            }
            if (homePage.currentTempNumb() >= i && homePage.currentTempNumb() <= i) {
                System.out.println(currentisDiaplayedCoreect);

            }
        }
    }


    @Then("^I verify timeline is displayed with two hours incremented$")
    public void gettime (){
        List<Integer> dailyArray = homePage.dailyTimeLineNumbers();

        final LocalDateTime[] dateTime = {LocalDateTime.now()};
        // 14:32

        dailyArray.forEach(el -> {
            dateTime[0] = dateTime[0].plusHours(2);
            if (dateTime[0].getHour() != el) {
                System.out.println("error" + el);
            }
        });

        LocalDateTime time = LocalDateTime.now();
        for (Integer el : dailyArray) {
            time = time.plusHours(2);
            if (time.getHour() != el) {
                System.out.println("error" + el);
            }
        }




        /**
        for (int i = 0; i < homePage.dailyTempLineNumbers().size()-2; i++ ){
				for (int k =0; k <homePage.dailyTempLineNumbers().size() -2; k++) {
					if ((homePage.dailyTempLineNumbers().get(i) != homePage.dailyTempLineNumbers().get(k + 1))) {
						break;
                    }
         */


    }

        /**
         * From Web: -> ["Now", "9pm", "11pm", "1am"...]
         * List<String> javaTime = new ArrayList<>();
         * javaTime.add("Now"); //["Now"}
         *  1. get Current time [ Mar 23 2020, Monday 07 03 pm]
         *  --for---
         *  2. Store in a variable newTime = Add two hours in current time [ Mar 23 2020, Monday 09 03 pm]
         *  3. Format to get hour and am/pm (ha) -> 9pm
         *  4. Store in javaTime // ["Now", "9pm", "11pm", "1am"]
         *  -------
         *  Compare javaTime and WebArrayList
         */

    }



