Feature:Login


  Scenario: Login with valid credentials

    Given User opens URL "http://admin-demo.nopcommerce.com/login"
    When User enters email as "admin@yourstore.com" and password as "admin"
    And User clicks on Login
    Then page title should be "Dashboard / nopCommerce administration"
    When User clicks on logout link
    Then page title should be "your store. Login"
    And User closes browser


