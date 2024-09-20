Feature: The user the purchase the product

  Scenario Outline: The user purchase the product
    Given user open the webpage product store
    And user select the product from the category "<category>"
    When user add to cart the product
    And user go to cart shopping
    And user purchase the product
    When user complete the form purchase
    Then user validate alert register

    Examples:
      | category |
      | Phones   |
      | Laptops  |
      | Monitors |