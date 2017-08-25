Feature: Book Flight Tickets


  Scenario: Planning my journey
    Given I enter url "https://tfl.gov.uk/"
    And I enter "Canary Wharf Station" in from Field
    And I enter "London Bridge" in to field
    When I click on Plan my journey button
    Then I should see "Canary Wharf Station" in from field
    And I should see "London Bridge" in to field
    And I should see "Journey Results" page header
    And I should see "Edit journey" link
    And  I should see "Edit preferences" link
    When I click on Edit journey link
    And I enter "London Waterloo Rail Station" in from Field
    And I enter "Hammersmith" in to field
    And I select Arriving check box
    And I select Tomorrow from the dropdown
    And I select time from the dropdown
    And I click on Update journey button
    Then I should see "London Waterloo Rail Station" in from field
    And I should see "Hammersmith" in to field
    And I should see arriving as tomorrow at "08:00"
    When I pick Telugu from Select Language dropdown
    Then I should see the page header "జర్నీ ఫలితాలు" in Telugu

  @smoke
  Scenario Outline:
    Given I enter url "https://tfl.gov.uk/"
    And I enter "<fromField>" in from Field
    And I enter "<to Field>" in to field
    When I click on Plan my journey button
    Then I should see "<fromField>" in from field
    And I should see "<to Field>" in to field
    And I should see "<pageHeader>" header text
    And I should see "<pageLink1>" link
    And  I should see "<pageLink2>" link
    When I click on Edit journey link
    And I enter "<editedFromField>" in from Field
    And I enter "<editedToField>" in to field
    And I select Arriving check box
    And I select Tomorrow from the dropdown
    And I select time from the dropdown
    And I click on Update journey button
    Then I should see "<editedFromField>" in from field
    And I should see "<editedToField>" in to field
    And I should see arriving as tomorrow at "<time>"
    And I should see "<subHeader1>" on the page
    And I should see "<subHeader2>" on the page
    And I should see "<subHeader3>" on the page
    And I should see View Details button


    Examples:
      | fromField            | to Field      | pageHeader      | pageLink1    | pageLink2        | editedFromField                   | editedToField                  | time  | subHeader1                  | subHeader2 | subHeader3                | button       |
      | Canary Wharf Station | London Bridge | Journey Results | Edit journey | Edit preferences | London Waterloo East Rail Station | Southwark, Southwark Park Road | 08:00 | Fastest by public transport | Bus only   | Cycling and other options | View Details |












#  Scenario: Online Shopping
#      Given I enter url "https://www.amazon.co.uk/"
#      And I enter "mobile phones" in search Field
#      When I click in search icon
#      Then I should see phone images on the screen