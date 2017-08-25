package websiteFiles.stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import websiteFiles.openDriver;

public class OnlineShopping_sd {

    openDriver PMJ = new openDriver();


    @And("^I enter \"([^\"]*)\" in search Field$")
    public void iEnterInSearchField(String search)  {
        PMJ.driver.findElement(By.id("twotabsearchtextbox")).sendKeys(search);
    }

    @When("^I click in search icon$")
    public void iClickInSearchIcon()  {
        PMJ.driver.findElement(By.xpath("html/body/div[1]/header/div/div[1]/div[3]/div/form/div[2]/div/input")).click();
    }

    @Then("^I should see phone images on the screen$")
    public void iShouldSeePhoneImagesOnTheScreen()  {

        String src = PMJ.driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/div[1]/div/ul/li[1]/div/div[2]/div/div/a/img")).getAttribute("src");
        System.out.println("Sireesha"+src);
    }
}
