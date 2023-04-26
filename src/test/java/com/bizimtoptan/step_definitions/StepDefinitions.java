package com.bizimtoptan.step_definitions;

import com.bizimtoptan.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class StepDefinitions {
    
    AccountPage accountPage = new AccountPage();
    CategoryAndProductPage categoryAndProductPage = new CategoryAndProductPage();
    FavoritesPage favoritesPage = new FavoritesPage();
    ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    SearchPage searchPage = new SearchPage();

    @Given("The user visits homepage")
    public void the_user_visits_homepage() {
        homePage.gotoHomePage();
    }


    @And("The user clicks {string} button")
    public void theUserClicksButton(String button) {
        BasePage.clickButton(button);
    }

    @And("The user enters valid credentials")
    public void theUserEntersValidCredentials() {
        loginPage.login();
    }

    @And("The user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {
        loginPage.invalidLogin();
    }

    @And("The user verifies {string} information")
    public void theUserVerifiesInformation(String name) {
        accountPage.getInformation(name);
    }


    @And("The user clicks Cikis button")
    public void theUserClicksCikisButton() {
        accountPage.clicksCikisButton();
    }

    @And("The user verifies {string} message")
    public void theUserVerifiesMessage(String message) {
        Assert.assertEquals(message, BasePage.verifyMessage(message));
    }

    @And("The user enters forget password email address")
    public void theUserEntersForgetPasswordEmailAddress() {
        forgetPasswordPage.sendEmail();
    }

    @And("The user clicks hearth button")
    public void theUserClicksHearthButton() {
        categoryAndProductPage.clickHearthButton();
    }

    @And("The user clicks hearth buttonn")
    public void theUserClicksHearthButtonn() {
        favoritesPage.clickHearthButton();
    }

    @And("The user fills {string} in the searchbox and click")
    public void theUserFillsInTheSearchboxAndClick(String product) {
        searchPage.searchBox(product);
    }
}
