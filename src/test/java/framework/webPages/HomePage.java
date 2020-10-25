package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage extends BasePage {

	private By emailTextField = By.id("email");
	private By passwordTextField = By.id("pass");
	private By loginButton = By.id("loginbutton");
	private By firstNameTextField = By.id("firstName");
	private By lastNameTextField = By.id("lastName");
	private By mobileNumberTextField = By.id("mobileNumber");
	private By newPasswordTextField = By.id("newPwd");
	private By errorMessage = By.id("errorMessage");
	private By femaleGender = By.id("u_0_9");
	private By maleGender = By.id("u_0_a");
	private By messengerLink = By.id("");

	// final project
	private By darkSkyApi = By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]");
	private By todayTime = By.xpath("//body[@class='forecast']/div[@id='week']/a[1]");
	private By lowTem = By.xpath("");
	private By higtem = By.xpath("");
	private By tempValueTimeLine = By.xpath("");
	//locators scen1
	private By currentTemp = By.xpath("");
	private By todatTempValue = By.xpath ("");
	//scen 2
	private By timeLine = By.xpath("");


	public void clickOnLoginButton() {
		clickOn(loginButton);
	}

	public void enterEmail(String enterEmail) {
		setValue(emailTextField, enterEmail);
	}

	public void enterPassword(String enterPassword) {
		setValue(passwordTextField, enterPassword);
	}

	public void enterFirstName(String firstName) {
		setValue(firstNameTextField, firstName);
	}

	public void enterLastName(String lastName) {
		setValue(lastNameTextField, lastName);
	}

	public void enterMobileNumber(String mobileNum) {
		setValue(mobileNumberTextField, mobileNum);
	}

	public void enterNewPassword(String password) {
		setValue(newPasswordTextField, password);
	}

	public String getErrorMessage() {
		return getTextFromElement(errorMessage);
	}

	public boolean isGenderFemaleSelected() {
		return isElementSelected(femaleGender);
	}

	public void clickOnFemaleGender() {
		clickOn(femaleGender);
	}

	public boolean isGenderMaleSelected() {
		return isElementSelected(maleGender);
	}

	public void clickOnMaleGender() {
		clickOn(maleGender);
	}

	public void clickOnMessengerLink() {
		clickOn(messengerLink);
	}

	//methodsFinal

	public void clickOnDarkApiSky() {
		clickOn(darkSkyApi);
	}

	public void clickOnExpandTimeLine() {
		clickOn(todayTime);
	}

	public String getValueOfLowTemp() {
		return getTextFromElement(lowTem);
	}

	public String getValueOfHighTEmp() {
		return getTextFromElement(higtem);
	}

	public String getValueOfTodayTempLine() {
		return getTextFromElement(tempValueTimeLine);
	}

	public List<String> tempLineText() {
		List<String> tempTimeLine = new ArrayList<>();

		List<WebElement> temTemp = SharedSD.getDriver().findElements(tempValueTimeLine);

		for (WebElement temp : temTemp ){
			tempTimeLine.add(temp.getText());
		}
		return tempTimeLine;
	}
	public List <Integer> tempLineNumbers (){
		List<Integer> tempNumbers = new ArrayList<>();
		for (String tempTemp : tempLineText()){
			tempNumbers.add(Integer.valueOf(tempTemp.substring(0, tempTemp.length()-1)));
		}
		return tempNumbers;
	}
	public int LowTempFromTimeline (){
		int LowTemp = Collections.min(tempLineNumbers());
		return LowTemp;
	}
	public int HighTempFromTimeline (){
		int HighTemp = Collections.max(tempLineNumbers());
		return HighTemp;
	}

	//finals method scenario 1
	public List<String> dailyTempLineText() {
		List<String> dailyTempLine = new ArrayList<>();

		List<WebElement> dailyTemp = SharedSD.getDriver().findElements(tempValueTimeLine);

		for (WebElement dailyTemp2 : dailyTemp) {
			dailyTempLine.add(dailyTemp2.getText());
		}
		return dailyTempLine;
	}
	public List <Integer> dailyTempLineNumbers (){
		List<Integer> dailyTempNumbers = new ArrayList<>();
		for (String dailyTempTemp : dailyTempLineText()){
			dailyTempNumbers.add(Integer.valueOf(dailyTempTemp.substring(0, dailyTempTemp.length()-1)));
		}
		return dailyTempNumbers;
	}
	public int minDailyTemp (){
		int minTempDaily = Collections.min(dailyTempLineNumbers());
		return minTempDaily;
	}
	public int maxDailyTemp (){
		int maxDailyTemp = Collections.max(dailyTempLineNumbers());
		return maxDailyTemp;

	}
	public String getValueOfCurrentTempText (){

		return getTextFromElement(currentTemp); }
	public int currentTempNumb (){
		String valueOfCurrentTemp = getValueOfCurrentTempText();
		int lastIndexCurrentTemp = valueOfCurrentTemp.length()-1;
		valueOfCurrentTemp = valueOfCurrentTemp.substring(0, lastIndexCurrentTemp);
		int currentTemp = Integer.valueOf(valueOfCurrentTemp);
		return currentTemp;
	}
	//scen2
	public String getTimeLineValue (){return getTextFromElement(timeLine);}

	public List<String> timeLine() {
		List<String> dailyTimeLine = new ArrayList<>();

		List<WebElement> dailyTime = SharedSD.getDriver().findElements(timeLine);

		for (WebElement dailyTime2 : dailyTime) {
			dailyTimeLine.add(dailyTime2.getText());
		}
		return dailyTimeLine; //["Now", "9pm", "11pm", ...]
	}
	public List<Integer> dailyTimeLineNumbers (){
		List<Integer> dailyTimeNumbers = new ArrayList<>();
		for (String dailyTimeTemp : timeLine()) { // 7am -- 7
			String numbersOnly = dailyTimeTemp.replaceAll("[^0-9]", "");
			if (numbersOnly.length() <= 0) {
				break;
			}
			dailyTimeNumbers.add(Integer.valueOf(numbersOnly));
		}
		return dailyTimeNumbers;


		}


	}






