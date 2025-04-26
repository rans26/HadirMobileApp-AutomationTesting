package com.jc.randi.stepdefinitions;

import com.jc.randi.Pages.LoginPage;
import com.jc.randi.Utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    LoginPage loginPages = new LoginPage(DriverManager.getDriver());

    @Given("I am on the login page")
    public void i_am_on_the_login_page(){
        DriverManager.getDriver().get("https://magang.dikahadir.com/absen/login");
        Assert.assertTrue(loginPages.isLoginPagesDisplayed());
    }

    @When("I enter email {string} and password {string}")
    public void i_enter_email_and_password(String email, String password) throws InterruptedException {
        loginPages.enterEmail(email);
        loginPages.enterPassword(password);
        Thread.sleep(1000);
    }

    @When("I click the login button")
    public void i_click_the_login_button() throws InterruptedException {
        loginPages.clickLogin();
        Thread.sleep(1000);
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, loginPages.getErrorMessage());
    }

    @Then("I should see a validation message {string}")
    public void i_should_see_a_validation_message(String expectedValidationMessage) {
        Assert.assertTrue(loginPages.getEmailValidationMessage().contains(expectedValidationMessage));
    }

    @Then("I should be redirected to the dashboard page")
    public void i_should_be_redirected_to_the_dashboard_page() {
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl, currentUrl.contains("/apps/absent"));
    }
}
