package websiteFiles.pages;

import com.google.common.collect.Iterables;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import websiteFiles.openDriver;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class easyJetRegistration_page {

    List<String> regNumber = new ArrayList<String>();
    List<String> make = new ArrayList<String>();
    List<String> color = new ArrayList<String>();


    @FindBy(id = "EmailAddress")
    private WebElement emailaddress;

    @FindBy(id = "EmailAddressCheck")
    private WebElement confirmemail;

    @FindBy(css = ".hero-headline")
    private WebElement headerText;

    @FindBy(id = "Password")
    private WebElement Password;

    @FindBy(id = "PasswordCheck")
    private WebElement confirmpassword;

    @FindBy(id = "TitleTypeCode")
    private WebElement titleDropdown;

    @FindBy(id = "FirstName")
    private WebElement firstname;

    @FindBy(id = "LastName")
    private WebElement lastname;

    @FindBy(id = "Address1")
    private WebElement Addressline1;

    @FindBy(id = "Address2")
    private WebElement Addressline2;

    @FindBy(id = "City")
    private WebElement TownCity;

    @FindBy(id = "PostalCode")
    private WebElement postcode;

    @FindBy(id = "Country")
    private WebElement countryDropdown;

    @FindBy(id = "CountryMobileCodes")
    private WebElement mobilecodeDropdown;

    @FindBy(id = "MobilePhone")
    private WebElement mobilenumber;

    @FindBy(css = "#btnRegister>span")
    private WebElement registerbutton;

    @FindBy(css = ".SubMemberPart>div>label")
    private List<WebElement> errormessages;

    @FindBy(linkText = "Hotels")
    private WebElement hotelslink;

    @FindBy(css = ".intro .button")
    private WebElement startButton;

    @FindBy(id = "Vrm")
    private WebElement registrationEntry;

    @FindBy(css = ".button")
    private WebElement continueButton;

    @FindBy(css = ".list-summary-item")
    private  List<WebElement> summaryItems;


    openDriver OD = new openDriver();

    public void fillEmailAddress(String emailAddress) {
        emailaddress.sendKeys(emailAddress);
    }

    public void fillConfirmationEmail(String confirmEmail) {
        confirmemail.sendKeys(confirmEmail);
    }

    public void fillPassword(String password) {
        Password.sendKeys(password);
    }

    public void fillConfirmationPassword(String confirmPassword) {
        confirmpassword.sendKeys(confirmPassword);
    }

    public void enterTitle() {
        Select dropdown = new Select(titleDropdown);
        dropdown.selectByValue("2");
    }

    public void enterFirstName(String firstName) {
        firstname.sendKeys(firstName);
    }

    public void enterSurname(String surname) {
        lastname.sendKeys(surname);
    }

    public void enterAddress(String address) {
        Addressline1.sendKeys(address);
    }

    public void enterContinuedAddress(String continuedAddress) {
        Addressline2.sendKeys(continuedAddress);
    }

    public void enterCity(String city) {
        TownCity.sendKeys(city);
    }

    public void enterPostCode(String postCode) {
        postcode.sendKeys(postCode);
    }

    public void selectCountry() {
        Select dropdown = new Select(countryDropdown);
        dropdown.selectByValue("UNO");
    }

    public void selectTelephoneCode() {
        Select dropdown = new Select(mobilecodeDropdown);
        //dropdown.selectByValue("UK()");
        dropdown.selectByVisibleText("United Kingdom(+44)");
    }

    public void fillMobileNo(String mobileNumber) {
        mobilenumber.sendKeys(mobileNumber);
    }

    public void clickRegisterBtn() {
        registerbutton.click();
    }

    public void verifyHeaderText(String expectedtext) {
        String actualtext = headerText.getText();
        System.out.println(expectedtext);
        System.out.println(actualtext);
        assertEquals(expectedtext.toUpperCase(), actualtext.toUpperCase());
    }


    public void selectTitle(String title) {
        Select dropdown = new Select(titleDropdown);
//        dropdown.selectByValue("2");
        dropdown.selectByVisibleText(title);
    }

    public void selectCountry(String country) {
        Select dropdown = new Select(countryDropdown);
//        dropdown.selectByValue("UNO");
//        dropdown.selectByIndex(0);
        dropdown.selectByVisibleText(country);
    }

    public void selectMobileCode(String mobileCode) {
        Select dropdown = new Select(mobilecodeDropdown);
//        dropdown.selectByValue("+44");
        dropdown.selectByVisibleText(mobileCode);
//        dropdown.selectByIndex(5);
    }

    public void verifyErrorMsg(String expectedErrorMessage, String flag) {
        String actualErrorMsg;
        int size = errormessages.size();
        boolean variable = false;

        for (int i = 0; i < size; i++) {
            if (errormessages.get(i).getText().equals(expectedErrorMessage)) {
                variable = true;
                break;
            }

        }
        assertTrue(" Expected Error Message is " + expectedErrorMessage, variable);


    }


    public void enterData(List<String> personalDetails) {
        System.out.println(personalDetails.get(0));
        firstname.sendKeys(personalDetails.get(0));
        System.out.println(personalDetails.get(1));
        lastname.sendKeys(personalDetails.get(1));
        System.out.println(personalDetails.get(2));
        Addressline1.sendKeys(personalDetails.get(2));
        System.out.println(personalDetails.get(3));
        Addressline2.sendKeys(personalDetails.get(3));
        System.out.println(personalDetails.get(4));
        TownCity.sendKeys(personalDetails.get(4));
        System.out.println(personalDetails.get(5));
        postcode.sendKeys(personalDetails.get(5));
        Select dropdown = new Select(countryDropdown);
        dropdown.selectByVisibleText(personalDetails.get(6));
        System.out.println(personalDetails.get(7));
        Select dropdown_mobileCode = new Select(mobilecodeDropdown);
        dropdown_mobileCode.selectByVisibleText(personalDetails.get(7));
        System.out.println(personalDetails.get(8));
        mobilenumber.sendKeys(personalDetails.get(8));
    }

    public void openNewWindow() {
        System.out.println("Ravi");
        System.out.println("Ravi");
        System.out.println("Ravi");
        String selectLinkOpeninNewTab = Keys.chord(Keys.COMMAND, Keys.RETURN);
        OD.driver.findElement(By.linkText("Plan a journey")).sendKeys(selectLinkOpeninNewTab);
//      hotelslink.sendKeys(Keys.COMMAND+","+Keys.ENTER);

    }

    public void enterRegistrationNumber() throws IOException, InvalidFormatException {

        HashMap<String, Long> sizesByExtension = sizesForDirectory("/Users/Ravikumar/Documents/Remortgage/Sireesha", true);
//        HashMap<String, Long> fileName_MimeType = filenameMimeType("/Users/Ravikumar/Documents/Remortgage/Sireesha", true);

        for (String ext : sizesByExtension.keySet()) {
            System.out.println(ext + " : " + sizesByExtension.get(ext) );
        }



    }



    private static HashMap<String, Long> sizesForDirectory(String directory, boolean recurseInSubDirectories) {
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();

        HashMap<String, Long> sizesByExtension = new HashMap<String, Long>();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (!file.isDirectory()) {
                    String extension = file.getName().replaceAll(".*\\.", "");
                    if (sizesByExtension.containsKey(extension)) {
                        Long size = sizesByExtension.get(extension) + Long.valueOf(file.length());
                        sizesByExtension.put(extension, size);
                    } else {
                        sizesByExtension.put(extension, file.length());
                    }
                } else if (recurseInSubDirectories) {
                    HashMap<String, Long> sizesForSubdirectory = sizesForDirectory(file.getAbsolutePath(), recurseInSubDirectories);
                    for (String ext : sizesForSubdirectory.keySet()) {
                        if (sizesByExtension.containsKey(ext)) {
                            sizesByExtension.put(ext, sizesByExtension.get(ext) + sizesForSubdirectory.get(ext));
                        } else {
                            sizesByExtension.put(ext, sizesForSubdirectory.get(ext));
                        }
                    }
                }
            }
        }

        return sizesByExtension;
    }


//        startButton.click();
//
//        readExcelData();
//        int index = 1;
//        for (String registerNo : Iterables.skip(regNumber,1)) {
//            registrationEntry.sendKeys(registerNo);
//
//            continueButton.click();
//            System.out.println("STep1"+make.get(index));
//            System.out.println("Step2"+summaryItems.get(index).getText());
//            OD.driver.navigate().back();
//
//
//
//
//
//        }
//
//    }

//    private void readExcelData() throws IOException, InvalidFormatException {
//        String FILE_NAME;
//
//        List sheetData = new ArrayList();
//        FileInputStream fis = null;
//
//        InputStream inp = null;
//        FILE_NAME = System.getProperty("user.dir") + "/src/main/resources/Vehicle_Data.xlsx";
//
//        inp = new FileInputStream(FILE_NAME);
//
//        Workbook wb = WorkbookFactory.create(inp);
//        Sheet sheet = wb.getSheetAt(0);
//        Header header = sheet.getHeader();
//
//        int rowsCount = sheet.getLastRowNum();
////        System.out.println("Total Number of Rows: " + (rowsCount + 1));
//        for (int i = 0; i <= rowsCount; i++) {
//            Row row = sheet.getRow(i);
//            int colCounts = row.getLastCellNum();
//            for (int j = 0; j < colCounts; j++) {
//                Cell cell = row.getCell(j);
////                System.out.println("[" + i + "," + j + "]=" + cell.getStringCellValue());
//                if (j == 0) {
//                    regNumber.add(cell.getStringCellValue());
//                } else if (j == 1) {
//                    make.add(cell.getStringCellValue());
//                } else {
//                    color.add(cell.getStringCellValue());
//                }
//            }
//
//            System.out.println(regNumber);
//            System.out.println(make);
//            System.out.println(color);
//
//        }


//        FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
//        Workbook workbook = null;
//        workbook = new XSSFWorkbook(excelFile);
//        Sheet datatypeSheet = workbook.getSheetAt(0);
//        Iterator<Row> iterator = datatypeSheet.iterator();
//
//        while (iterator.hasNext()) {
//
//            Row currentRow = iterator.next();
//            Iterator<Cell> cellIterator = currentRow.iterator();
//
//            while (cellIterator.hasNext()) {
//
//                Cell currentCell = cellIterator.next();
//                if (!currentCell.getStringCellValue().contains("Vehicle Registraion Number")) {
//                    System.out.println("step1==>" + currentCell.getStringCellValue());
//                }
//
//            }
//
//
//        }

    }
}

