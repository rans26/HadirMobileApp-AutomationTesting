Feature: Register functionality

  @positive
  Scenario: Navigate to registration page
    Given I am on the login page
    When I click on the register link
    Then I should be redirected to the registration page

  Scenario: Successful registration with valid data
    Given I am on the registration page
    When I enter registration details with:
      | Field   | Value                     |
      | nik     | D7232029                  |
      | name    | Randi Maulana             |
      | email   | randi.test@gmail.com    |
      | password| password123               |
      | photo   | src/test/resources/SelfieTest.png |
    And I click hide and show password
    And I click the register button
    Then I should be see message "Akun sudah terdaftar di sistem dan belum terverifikasi"