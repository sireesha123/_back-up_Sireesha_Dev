package websiteFiles.stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import websiteFiles.openDriver;
import websiteFiles.pages.planningMyJourney_page;
import websiteFiles.utils.BasePage;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class planningMyJourney_sd extends BasePage{

    public planningMyJourney_page PMJ_page = PageFactory.initElements(openDriver.driver,planningMyJourney_page.class);

    openDriver OD = new openDriver();

    @Given("^I enter url \"([^\"]*)\"$")
    public void iEnterUrl(String url) {
        openURL(url);
    }


    @And("^I enter \"([^\"]*)\" in from Field$")
    public void iEnterInFromField(String source) {
        PMJ_page.enterFromField(source);
    }

    @And("^I enter \"([^\"]*)\" in to field$")
    public void iEnterInToField(String destination) {
        PMJ_page.enterToField(destination);
    }

    @When("^I click on Plan my journey button$")
    public void iClickOnPlanMyJourneyButton() {
        PMJ_page.clickJourneyBtn();
        threadWait();
    }


    @Then("^I should see \"([^\"]*)\" in from field$")
    public void iShouldSeeInFromField(String expectedFromField) {
        PMJ_page.verifyFromField(expectedFromField);
    }

    @And("^I should see \"([^\"]*)\" in to field$")
    public void iShouldSeeInToField(String expectedToField) {
        PMJ_page.verifyToField(expectedToField);

    }

    @And("^I should see \"([^\"]*)\" page header$")
    public void iShouldSeePageHeader(String expectedPageHeader) {
        PMJ_page.verifyPageHeader(expectedPageHeader);
    }


    @And("^I should see \"([^\"]*)\" link$")
    public void iShouldSeeLink(String expectedEditLink) {
        PMJ_page.verifyPageLinks(expectedEditLink);
    }


    @And("^I select Arriving check box$")
    public void iSelectArrivingCheckBox() {
         PMJ_page.selectCheckBox();
    }


    @And("^I select Tomorrow from the dropdown$")
    public void iSelectTomorrowFromTheDropdown() {
          PMJ_page.selectDayDropdown();
    }

    @And("^I select time from the dropdown$")
    public void iSelectTimeFromTheDropdown() {
        PMJ_page.selectTimeDropdown();
    }

    @And("^I click on Update journey button$")
    public void iClickOnUpdateJourneyButton() {
         PMJ_page.clickUpdateJrnyBtn();
    }

    @And("^I should see arriving as tomorrow at \"([^\"]*)\"$")
    public void iShouldSeeArrivingAsTomorrowAt(String expectedArrivingDateTime) {
        PMJ_page.verifyArrivingDate();
    }


    @When("^I pick Telugu from Select Language dropdown$")
    public void iPickTeluguFromSelectLanguageDropdown()  {
        PMJ_page.pickLanguage();
        implicitWait();


    }

    @Then("^I should see the page header \"([^\"]*)\" in Telugu$")
    public void iShouldSeeThePageHeaderInTelugu(String expectedTeluguHeader)  {
        PMJ_page.verifyTeluguHeader(expectedTeluguHeader);

    }


    @And("^I should see \"([^\"]*)\" on the page$")
    public void iShouldSeeOnThePage(String expectedSubHeader)  {
        PMJ_page.verifysubHeader(expectedSubHeader);
    }

    @And("^I should see View Details button$")
    public void iShouldSeeViewDetailsButton()  {
       boolean viewDetailsBtnExists = PMJ_page.buttonExists();
       assertTrue(viewDetailsBtnExists);

    }

    @When("^I click on Edit journey link$")
    public void iClickOnEditJourneyLink()  {
        PMJ_page.clickEditJourneyLink();
    }
}
