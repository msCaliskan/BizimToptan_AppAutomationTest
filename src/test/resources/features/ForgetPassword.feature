Feature: Forget Password - The user tries to send forget password email

  @mobile
  Scenario: The user tries to send an email with empty inputs
    Given The user visits homepage
    And The user clicks "Giriş" button
    And The user clicks "Şifremi Unuttum" button
    And The user enters forget password email address
    And The user clicks "Şifremi Unuttum" button
    Then The user verifies "Şifre değişiklik bilgileriniz e-posta adresinize gönderildi." message