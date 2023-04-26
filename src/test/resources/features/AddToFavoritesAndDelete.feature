Feature: Add to favorites and delete

  @mobile
  Scenario: The user can add to favorites and delete

    Given The user visits homepage
    And The user clicks "Giriş" button
    When The user enters valid credentials
    And The user clicks "Giriş Yap" button
    And The user clicks "Geç" button
    And The user clicks "Bitir" button
    And The user clicks "Kategoriler" button
    And The user clicks "İçecek" button
    And The user clicks "Tümü" button
    And The user clicks hearth button
    And The user clicks "Favoriler" button
    And The user clicks "Kaydet" button
    And The user clicks "Hesabım" button
    Then The user clicks "Favorilerim" button
    And The user clicks hearth buttonn
    And The user clicks "Favoriler" button
    And The user clicks "Kaydet" button
    And The user clicks "Hesabım" button
    And The user clicks Cikis button