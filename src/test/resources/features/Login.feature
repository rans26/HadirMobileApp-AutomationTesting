Feature: Login functionality

  @positive
  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter email "team3sqa@gmail.com" and password "SQA@Hadir12345"
    And I click the login button
    Then I should be redirected to the dashboard page

  @negative
  Scenario: Login with unregistered email
    Given I am on the login page
    When I enter email "team3sqatest@gmail.com" and password ""
    And I click the login button
    Then I should see an error message "Akun tidak ditemukan"

  @negative
  Scenario: Login with email without @ symbol
    Given I am on the login page
    When I enter email "team3sqatgmail.com" and password ""
    And I click the login button
    Then I should see a validation message "Please include an '@' in the email address."

  @negative
  Scenario: Login with wrong password
    Given I am on the login page
    When I enter email "team3sqa@gmail.com" and password "SQA@Hadir"
    And I click the login button
    Then I should see an error message "Email atau password salah"

  @negative
  Scenario: Login with blank password
    Given I am on the login page
    When I enter email "team3sqa@gmail.com" and password ""
    And I click the login button
    Then I should see an error message "Email atau password salah"

  @negative
  Scenario: Login with blank email
    Given I am on the login page
    When I enter email "" and password "SQA@Hadir"
    And I click the login button
    Then I should see an error message "Akun tidak ditemukan"

  @negative
  Scenario: Login with email and blank password
    Given I am on the login page
    When I enter email "" and password ""
    And I click the login button
    Then I should see an error message "Akun tidak ditemukan"
