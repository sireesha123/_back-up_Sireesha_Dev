@registration
Feature: Registration
  In order to book tickets
  As a user
  I want to be able to register

  Background:
    Given I enter the url "https://www.easyjet.com/EN/register"

  @reg1
  Scenario: 'Member Registration'
    Given I fill in email address with "siri67@gmail.com"
    And I fill in confirmation email address with "siri67@gmail.com"
    And I fill in Password with "password"
    And I fill in Password confirmation with "password"
    And I select title Mrs from the drop down
    And I fill in First Name with "Sireesha"
    And I enter "Paladugu" in Surnames field
    And I enter "2 Test Lane" in Address
    And I enter "Sutton" in Adress contunued field
    And I enter "London" in Town/City field
    And I enter "SM2 123" in Postcode field
    And I pick a United Kingdom from Country dropdown
    And I pick United Kingdom from Mobile Telephone dropdown
    And I fill in mobile number with "12345678"
    When I click on Register now button
#    Then I should see "My account details" page


  @reg2
  Scenario Outline: Member Registration

    Given I fill in email address with "<emailAddress>"
    And I fill in confirmation email address with "<confirmationEmail>"
    And I fill in Password with "<password>"
    And I fill in Password confirmation with "<passwordConfirmation>"
    And I select title "<title>" from the drop down
    And I fill in First Name with "<firstName>"
    And I enter "<surname>" in Surnames field
    And I enter "<address>" in Address
    And I enter "<town>" in Adress contunued field
    And I enter "<city>" in Town/City field
    And I enter "<postCode>" in Postcode field
    And I pick a "<country>" from Country dropdown
    And I pick "<countryCode>" from Mobile Telephone dropdown
    And I fill in mobile number with "<mobileNumber>"
    When I click on Register now button
  #    Then I should see "My account details" header text


    Examples:
      | emailAddress         | confirmationEmail | password    | passwordConfirmation | title | firstName | surname | address     | town   | city   | postCode | country        | countryCode | mobileNumber |
      | greeshu123@gmail.com | test123@gmail.com | password123 | password123          | Mrs   | Name      | King    | 2 Test Lane | Sutton | London | SM1123   | United Kingdom | India(+91)  | 12345        |

  @reg3
  Scenario Outline: Member Registration - Negative Scenarios
    Given I fill in email address with "<emailAddress>"
    And I fill in confirmation email address with "<confirmationEmail>"
    And I fill in Password with "<password>"
    And I fill in Password confirmation with "<passwordConfirmation>"
    And I select title "<title>" from the drop down
    And I fill in First Name with "<firstName>"
    And I enter "<surname>" in Surnames field
    And I enter "<address>" in Address
    And I enter "<town>" in Adress contunued field
    And I enter "<city>" in Town/City field
    And I enter "<postCode>" in Postcode field
    And I pick a "<country>" from Country dropdown
    And I pick "<countryCode>" from Mobile Telephone dropdown
    And I fill in mobile number with "<mobileNumber>"
    When I click on Register now button
    Then I should see "<errorMessage>" error message for "<flag>"



    Examples:
      | emailAddress      | confirmationEmail | password    | passwordConfirmation | title | firstName | surname  | address     | town   | city   | postCode | country        | countryCode | mobileNumber | errorMessage                                                                                                                          | flag       |
      | test              | test123@gmail.com | password123 | password123          | Mrs   | Name      | King     | 2 Test Lane | Sutton | London | SM1123   | United Kingdom | India(+91)  | 12345        | Please enter a valid email address 1                                                                                                    | errormsg1  |
#      | test@gmail.com    | test123@gmail.com | password123 | password123          | Mrs   | Name      | King     | 2 Test Lane | Sutton | London | SM1123   | United Kingdom | India(+91)  | 12345        | The email addresses entered do not match                                                                                              | errormsg2  |
#      | test123@gmail.com | test123@gmail.com |             | password123          | Mrs   | Name      | King     | 2 Test Lane | Sutton | London | SM1123   | United Kingdom | India(+91)  | 12345        | Your password must be a single word between 6 and 20 characters in length and must not include the special characters # & + or space. | errormsg3  |
#      | test123@gmail.com | test123@gmail.com | password123 | password123          |       | Name      | King     | 2 Test Lane | Sutton | London | SM1123   | United Kingdom | India(+91)  | 12345        | Please select the contact's title                                                                                                     | errormsg4  |
#      | test123@gmail.com | test123@gmail.com | password123 | password123          | Mr    | Name 1    | King     | 2 Test Lane | Sutton | London | SM1123   | United Kingdom | India(+91)  | 12345        | Please enter the contact's first name                                                                                                 | errormsg5  |
#      | test123@gmail.com | test123@gmail.com | password123 | password123          | Mr    | Name      |          | 2 Test Lane | Sutton | London | SM1123   | United Kingdom | India(+91)  | 12345        | Please enter the contact's last name                                                                                                  | errormsg6  |
#      | test123@gmail.com | test123@gmail.com | password123 | password123          | Mr    | Name      | Paladugu |             | Sutton | London | SM1123   | United Kingdom | India(+91)  | 12345        | Please enter the contact's address                                                                                                    | errormsg7  |
#      | test123@gmail.com | test123@gmail.com | password123 | password123          | Mr    | Name      | Paladugu | 2 Test Lane | Sutton |        | SM1123   | United Kingdom | India(+91)  | 12345        | Please enter the contact's city                                                                                                       | errormsg8  |
#      | test123@gmail.com | test123@gmail.com | password123 | password123          | Ms    | Name      | Paladugu | 2 Test Lane | Sutton | London |          | United Kingdom | India(+91)  | 12345        | Please enter the contact's zip/postcode                                                                                               | errormsg9  |
#      | test123@gmail.com | test123@gmail.com | password123 | password123          | Mr    | Name      | Paladugu | 2 Test Lane | Sutton | London | SM1123   | United Kingdom | India(+91)  |              | Please enter a valid telephone number                                                                                                 | errormsg10 |

  @reg4
  Scenario Outline: Member Registration

    Given I fill in email address with "<emailAddress>"
    And I fill in confirmation email address with "<confirmationEmail>"
    And I fill in Password with "<password>"
    And I fill in Password confirmation with "<passwordConfirmation>"
    And I select title "<title>" from the drop down
    And I enter below details:
      | Sireesha | king | 1 test lane | Sutton | London | SM5 2RL | United Kingdom | India(+91) | 345678 |
    When I click on Register now button
  #    Then I should see "My account details" header text


    Examples:
      | emailAddress      | confirmationEmail | password    | passwordConfirmation | title |
      | test123@gmail.com | test123@gmail.com | password123 | password123          | Mrs   |


  @reg5
  Scenario Outline: Member Registration

    Given I fill in email address with "<emailAddress>"
    And I fill in confirmation email address with "<confirmationEmail>"
    And I fill in Password with "<password>"
    And I fill in Password confirmation with "<passwordConfirmation>"
    And I select title "<title>" from the drop down
    And I enter below details:
      | <firstName> | <surname> | <address> | <town> | <city> | <postCode> | <country> | <countryCode> | <mobileNumber> |
    When I click on Register now button
  #    Then I should see "My account details" header text


    Examples:
      | emailAddress      | confirmationEmail | password    | passwordConfirmation | title | firstName | surname | address     | town   | city   | postCode | country        | countryCode | mobileNumber |
      | test123@gmail.com | test123@gmail.com | password123 | password123          | Mrs   | Sireesha  | King    | 2 Test Lane | Sutton | London | SM1123   | United Kingdom | India(+91)  | 12345        |


@reg6
  Scenario: EasyJet Navigation
    And I open Hotels tab in a new window
    Then I should see "Find deals in any destination" header text
    And I navigate back to previous home page
    When I click on Cars tab
    Then I should see the url of cars deals page

@dvla
  Scenario: verify vehicle information from DVLA
    Given I enter url "https://www.gov.uk/get-vehicle-information-from-dvla"
    And I enter vehicle registration number from excel file
    Then I should see registration number, make, colour