Feature: Grocery End to End - Cucumber + API + Mobile

  Scenario: End to end grocery order
    Given user hits grocery products API
    Then status code should be 200
    And mobile user opens Grocery app
    And mobile user adds "Milk" to cart
    Then cart should contain 1 item
    And order should be placed successfully

  Scenario Outline: Validate grocery products
    Given user requests product with id <id>
    Then status code should be 200

    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
