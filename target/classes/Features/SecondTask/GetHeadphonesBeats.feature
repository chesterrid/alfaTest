Feature: Find on the site the first from the list of headphones, price from 17,000 to 25,000

  Scenario: Positive case

    Given Go to Yandex
    When Go to the market, subsection electronics
    When Filter Beats headphones
    When Make a filter at a price from 17000 to 25000 rubles
    When Take the name of the first headphones, remember it and follow in discription of the headphones
    Then Compare that the display name of the product in the description is the same as the one you remembered
