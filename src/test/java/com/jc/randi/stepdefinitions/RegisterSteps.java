package com.jc.randi.stepdefinitions;

import com.jc.randi.Pages.LoginPage;
import com.jc.randi.Pages.RegisterPage;
import com.jc.randi.Utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class RegisterSteps {
    RegisterPage registerPage = new RegisterPage(DriverManager.getDriver());

    @Given("I am on the registration page")
    public void i_am_on_the_registration_page(){
        DriverManager.getDriver().get("https://magang.dikahadir.com/absen/register");
        Assert.assertTrue(registerPage.isRegisterPagesDisplayed());
    }

    @When("I click on the register link")
    public void i_click_on_the_register_link() throws InterruptedException {
        registerPage.clickRegister();
        Thread.sleep(1000);
    }

    @Then("I should be redirected to the registration page")
    public void i_should_be_redirected_to_the_registration_page() {
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue("Expected URL to contain '/absen/register' but was: " + currentUrl,
                currentUrl.contains("/absen/register"));
    }


    @When("I enter registration details with:")
    public void i_enter_registration_details_with_nik_name_email_password_and_upload_photo(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        registerPage.enterNIK(data.get("nik"));
        registerPage.enterName(data.get("name"));
        registerPage.enterEmail(data.get("email"));
        registerPage.enterPassword(data.get("password"));
        registerPage.uploadPhotoSelfie(data.get("photo"));
    }


    @When("I click hide and show password")
    public void i_click_hide_and_show_password() throws InterruptedException {
        registerPage.showHidePassword();
        Thread.sleep(1000);
        registerPage.showHidePassword();
   }

    @And("I click the register button")
    public void i_click_the_register_button() throws InterruptedException {
        registerPage.clickButtonRegister();
        Thread.sleep(2000);
    }

    @Then("I should be see message {string}")
    public void i_should_be_see_message(String expectedMessage) {
        String actualMessage = registerPage.getNotifMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
