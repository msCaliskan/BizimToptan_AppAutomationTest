@mobile
Feature: Login with valid and invalid credentials

  Background:
    Given The user visits homepage
    And The user clicks "Giriş" button

  Scenario: Login with valid credentials
    And The user enters valid credentials
    And The user clicks "Giriş Yap" button
    And The user clicks "Geç" button
    And The user clicks "Hesabım" button
    And The user verifies "Musa Caliskan" information
    And The user clicks Cikis button

  Scenario: The user must not be able to login with invalid credentials
    And The user enters invalid credentials
    And The user clicks "Giriş Yap" button
    And The user verifies "Kullanıcı adı yada şifre hatalı!" message