
Feature: Find on the site the first from the list of mobilePhones, price from 40000

    Scenario: Positive case

        Given Go to Yandex
        When Go to the market, subsection electronics
        When Filter Samsung smartphones
        When Make a filter at a price of 40000 rubles
        When Take the name of the first smartphone, remember it and follow in discription of the smartphone
        Then Compare that the display name of the product in the description is the same as the one you remembered
