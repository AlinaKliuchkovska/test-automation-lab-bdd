Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check that adding to cart works correct
    Given User makes search by keyword '<group>'
    And User enters brand name to brand search input '<brandName>'
    And User checks brand checkbox '<brandName>'
    And User checks ready to ship checkbox
    And User selects sorting type '<sortingType>'
    And User clicks on first product
    When User clicks on add to cart button
    Then User verifies that number of items in cart is <expectedNumberInCart>
    Then User verifies that total sum in cart less than <maxSum>

    Examples:
      | group        | sortingType          | brandName | expectedNumberInCart | maxSum |
      | Ноутбуки     | От дорогих к дешевым | Acer      | 1                    | 500000 |
      | Смартфоны    | От дешевых к дорогим | Apple     | 1                    | 500000 |
      | Холодильники | Популярные           | ATLANT    | 1                    | 500000 |
      | Телевизоры   | Новинки              | Samsung   | 1                    | 500000 |
      | Планшеты     | Акционные            | Microsoft | 1                    | 500000 |