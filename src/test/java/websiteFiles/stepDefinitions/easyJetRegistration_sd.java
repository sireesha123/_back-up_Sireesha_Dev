package websiteFiles.stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import websiteFiles.openDriver;
import websiteFiles.pages.easyJetRegistration_page;
import websiteFiles.utils.BasePage;

import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class easyJetRegistration_sd extends BasePage{
    easyJetRegistration_page EJR_page = PageFactory.initElements(openDriver.driver,easyJetRegistration_page.class);

   openDriver OD = new openDriver();

    @Given("^I enter the url \"([^\"]*)\"$")
    public void iEnterTheUrl(String url)  {
        openURL(url);
    }

    @And("^I fill in email address with \"([^\"]*)\"$")
    public void iFillInEmailAddressWith(String emailAddress) {
        EJR_page.fillEmailAddress(emailAddress);
    }

    @And("^I fill in confirmation email address with \"([^\"]*)\"$")
    public void iFillInConfirmationEmailAddressWith(String confirmEmail) {
        EJR_page.fillConfirmationEmail(confirmEmail);
        System.out.println(confirmEmail);
    }

    @And("^I fill in Password with \"([^\"]*)\"$")
    public void iFillInPasswordRequiredWith(String password)  {
         EJR_page.fillPassword(password);
    }

    @And("^I fill in Password confirmation with \"([^\"]*)\"$")
    public void iFillInPasswordConfirmationWith(String confirmPassword)  {
         EJR_page.fillConfirmationPassword(confirmPassword);
        System.out.println("github");
    }

    @And("^I select title Mrs from the drop down$")
    public void iSelectTitleMrsFromTheDropDown()  {
        EJR_page.enterTitle();
        System.out.println("siri");
    }


    @And("^I fill in First Name with \"([^\"]*)\"$")
    public void iFillInFirstNameWith(String firstName)  {
         EJR_page.enterFirstName(firstName);
    }


    @And("^I enter \"([^\"]*)\" in Surnames field$")
    public void iEnterInSurnamesField(String surname) {
         EJR_page.enterSurname(surname);
    }

    @And("^I enter \"([^\"]*)\" in Address$")
    public void iEnterInAddress(String address)  {
         EJR_page.enterAddress(address);
    }

    @And("^I enter \"([^\"]*)\" in Adress contunued field$")
    public void iEnterInAdressContunuedField(String continuedAddress)  {
        EJR_page.enterContinuedAddress(continuedAddress);
    }

    @And("^I enter \"([^\"]*)\" in Town/City field$")
    public void iEnterInTownCityField(String city)  {
        EJR_page.enterCity(city);
    }

    @And("^I enter \"([^\"]*)\" in Postcode field$")
    public void iEnterInPostcodeField(String postCode)  {
         EJR_page.enterPostCode(postCode);
    }


    @And("^I pick a United Kingdom from Country dropdown$")
    public void iPickAUnitedKingdomFromCountryDropdown()  {
        EJR_page.selectCountry();
    }


    @And("^I pick United Kingdom from Mobile Telephone dropdown$")
    public void iPickUnitedKingdomFromMobileTelephoneDropdown()  {
        EJR_page.selectTelephoneCode();
    }

    @And("^I fill in mobile number with \"([^\"]*)\"$")
    public void iFillInMobileNumberWith(String mobileNumber)  {
         EJR_page.fillMobileNo(mobileNumber);
    }

    @When("^I click on Register now button$")
    public void iClickOnRegisterNowButton()  {
         EJR_page.clickRegisterBtn();
    }


    @Then("^I should see \"([^\"]*)\" header text$")
    public void iShouldSeePage(String expectedtext)  {
        EJR_page.verifyHeaderText(expectedtext);
    }


    @And("^I select title \"([^\"]*)\" from the drop down$")
    public void iSelectTitleFromTheDropDown(String title) {
        EJR_page.selectTitle(title);
    }

    @And("^I pick a \"([^\"]*)\" from Country dropdown$")
    public void iPickAFromCountryDropdown(String country)  {
        EJR_page.selectCountry();

    }

    @And("^I pick \"([^\"]*)\" from Mobile Telephone dropdown$")
    public void iPickFromMobileTelephoneDropdown(String mobileCode)  {
        EJR_page.selectMobileCode(mobileCode);

    }


    @Then("^I should see \"([^\"]*)\" error message for \"([^\"]*)\"$")
    public void iShouldSeeErrorMessageFor(String expectedErrorMessage, String flag) {
        EJR_page.verifyErrorMsg(expectedErrorMessage,flag);
    }
    
    @And("^I enter below details:$")
    public void iEnterBelowDetails(List<String> personalDetails) {
        EJR_page.enterData(personalDetails);
    }


    @And("^I open Hotels tab in a new window$")
    public void iOpenHotelsTabInANewWindow()  {
        EJR_page.openNewWindow();
    }

    @And("^I enter vehicle registration number from excel file$")
    public void iEnterVehicleRegistrationNumberFromExcelFile()  {

    }

    @Then("^I should see registration number, make, colour$")
    public void iShouldSeeRegistrationNumberMakeColour()  {

    }
}

