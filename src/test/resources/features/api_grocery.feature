Feature: Grocery API Testing

  Scenario: Get all grocery products
    Given user hits grocery products API
    Then status code should be 200
    And response should contain products

  Scenario: Get single product by id
    Given user requests product with id 1
    Then status code should be 200
    And product title should not be empty

  Scenario: Create new grocery product
    Given user creates a new product with title "Milk"
    Then status code should be 201
    And created product id should be present

  Scenario: Update grocery product
    Given user updates product 1 with title "Fresh Milk"
    Then status code should be 200

  Scenario: Delete grocery product
    Given user deletes product 1
    Then status code should be 200
