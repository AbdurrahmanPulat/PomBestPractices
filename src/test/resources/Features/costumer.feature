Feature: Costumers

  Scenario: Add a new customer
    And User opens URL "http://admin-demo.nopcommerce.com/login"
    When User enters email as "admin@yourstore.com" and password as "admin"
    And User clicks on Login
    Then User can view Dashboard
    When Users clicks on customer menu
    When Users clicks on customer menu item
    And User clicks on Add New button
    Then User can view and add customer page
    When User enters all the customer info
    Then User can view confirmation message "The new customer has been added successfully."
    And User closes browser

