Feature: Grocery Mobile App Testing - Simulated Appium Flow

  Scenario: Mobile user login
    Given mobile user opens Grocery app
    When mobile user enters username "dinesh@test.com" and password "Test@123"
    Then mobile login should be successful

  Scenario: Mobile add to cart
    Given mobile user is logged in
    When mobile user searches for "Banana"
    And mobile user adds "Banana" to cart
    Then cart should contain 1 item

  Scenario: Mobile checkout
    Given mobile cart has 2 items
    When mobile user proceeds to checkout
    Then order should be placed successfully

  Scenario: Mobile search validation
    Given mobile user opens Grocery app
    When mobile user searches for "Apple"
    Then search results should show "Apple"
