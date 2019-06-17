Feature: Save to file the description of the section "about us"

  Scenario: Positive case

    Given Go to Yandex
    When Get data about the browser and search engine
    When Find the site of Alfa-Bank through search engines
    When Go to the section "Jobs
    When On the website job.alfabank.ru go to the section "about working in a bank"
    Then Save info to file
