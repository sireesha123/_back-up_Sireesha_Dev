package websiteFiles.pages;

import com.google.common.base.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
import websiteFiles.openDriver;

import javax.swing.text.html.CSS;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class planningMyJourney_page {

    @FindBy(css = ".basic-journey-options .plan-journey-button")
    private WebElement planMyJourneybtn;

    @FindBy(css = ".hero-headline")
    private WebElement headerText;

   @FindBy(css = ".publictransport-box .travel-info-box .secondary-button.show-detailed-results")
   private List<WebElement> allElementsInList;

   @FindBy(css = ".basic-journey-options .update-buttons .plan-journey-button")
   private WebElement updateJourneyBtn;

   @FindBy(css = ".summary-row .edit-journey>span")
   private WebElement journeyLink;

   @FindBy(id ="InputFrom")
   private WebElement fromField;

   @FindBy(id ="InputTo" )
   private WebElement toField;

   @FindBy(id ="arriving")
   private WebElement selectcheckbox;

   @FindBy(id = "Date")
   private WebElement selectday;

   @FindBy(id = "Time")
   private WebElement selecttime;

   @FindBy(className = "goog-te-combo")
   private WebElement language;

   @FindBy(css = ".from-to-wrapper .summary-row.clearfix>strong")
   private List<WebElement> verifyFromfield;

   @FindBy(css = ".jp-result-transport.fastest.by.public.transport.clearfix")
   private WebElement subheader1;

   @FindBy(css = ".jp-result-transport.inner-heading.clearfix")
   private WebElement subheader2;

   @FindBy(css = ".extra-journey-options.multi-modals.clearfix>h2")
   private WebElement subheader3;

   @FindBy(css = ".edit-journey>span")
   private WebElement journeyHeader;

   @FindBy(css = ".toggle-options.more-options")
   private WebElement preferencesHeader;

   @FindBy(css = ".hero-headline>font>font")
   private WebElement teluguheader;


    openDriver OD = new openDriver();

    public void enterFromField(String source) {
        fromField.clear();
       fromField.sendKeys(source + Keys.ESCAPE);
    }

    public void enterToField(String destination) {
        toField.clear();
       toField.sendKeys(destination + Keys.ESCAPE);
    }

    public void clickJourneyBtn() {
     planMyJourneybtn.click();

    }

    public void verifyFromField(String expectedFromField) {
        String actualFromField;
            actualFromField = verifyFromfield.get(0).getText();
        System.out.println(expectedFromField);
        System.out.println(actualFromField);
        assertEquals(expectedFromField, actualFromField);
    }

    public void verifyToField(String expectedToField) {
        String actualToField = verifyFromfield.get(1).getText();
        System.out.println(expectedToField);
        System.out.println(actualToField);
        assertEquals(expectedToField, actualToField);
    }

    public void verifyPageHeader(String expectedPageHeader) {
        String actualPageHeader = headerText.getText();
        System.out.println(expectedPageHeader);
        System.out.println(actualPageHeader);
        assertEquals(expectedPageHeader.toLowerCase(), actualPageHeader.toLowerCase());
    }


    public void verifyPageLinks(String expectedEditLink) {

        String actualEditLink;

//         actualEditLink =  OD.driver.findElement(By.linkText(expectedEditLink)).getText();
        if (expectedEditLink.contains("journey")) {
             actualEditLink =  journeyHeader.getText();
        } else {
             actualEditLink =  preferencesHeader.getText();

        }
        System.out.println("expectedEditLink;" + expectedEditLink);
        System.out.println("actualEditLink;" + actualEditLink);
        assertEquals(expectedEditLink, actualEditLink);
    }

    public void clickEditJourneyLink() {
        journeyLink.click();
    }

    public void selectCheckBox() {
        selectcheckbox.click();
    }

    public void selectDayDropdown() {
        Select dropdown = new Select(selectday);
        dropdown.selectByVisibleText("Tomorrow");
    }

    public void selectTimeDropdown() {
        Select dropdown = new Select(selecttime);
        dropdown.selectByValue("0800");

    }

    public void clickUpdateJrnyBtn() {
        updateJourneyBtn.click();
    }

    public void verifyArrivingDate() {
//        Calendar cal = getInstance();
//        String x = cal.add(DATE, 1);
//        System.out.println(cal.add(DATE, 1));
//        cal.add(DAY_OF_WEEK, 1);
//        System.out.println(cal.add(DAY_OF_WEEK, 1));

        int no_of_day_to_add = 1;
        Date today = new Date();
        Date tomorrow = new Date(today.getYear(), today.getMonth(), today.getDate() + no_of_day_to_add);
        System.out.println(tomorrow.getMonth());
    }

    public void pickLanguage() {
        Select dropdown = new Select(language);
        dropdown.selectByValue("te");
    }

    public void verifyTeluguHeader(String expectedTeluguHeader) {
        String actualTeluguHeader = teluguheader.getText();
        System.out.println(expectedTeluguHeader);
        System.out.println(actualTeluguHeader);
        assertEquals(expectedTeluguHeader, actualTeluguHeader);
    }

    public void verifysubHeader(String expectedSubHeader) {
        String actualSubHeader;
        if (expectedSubHeader.toUpperCase().contains("PUBLIC")) {
            actualSubHeader = subheader1.getText();
        } else if (expectedSubHeader.toUpperCase().contains("BUS")) {
            actualSubHeader = subheader2.getText();
        } else  {
            actualSubHeader = subheader3.getText();
       }
        System.out.println(expectedSubHeader);
        System.out.println(actualSubHeader);
        assertEquals(expectedSubHeader,actualSubHeader);

    }
    public boolean buttonExists(){
        boolean buttonexists = allElementsInList.get(0).isDisplayed();
        return buttonexists;
    }


    }

