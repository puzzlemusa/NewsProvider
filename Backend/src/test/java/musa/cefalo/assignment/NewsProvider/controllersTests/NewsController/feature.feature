Feature: NewsController
  Scenario: Creating a new News
    When a POST request is received to create a news
      | title        | testTitle   |
      | body         | testBody    |
      | author       | testAuthor  |
      | publishDate  | 2017-07-02  |
    Then a new news is created with expected values

  Scenario: Getting a already created news
    Given an existing news
      | title        | testTitle   |
      | body         | testBody    |
      | author       | testAuthor  |
      | publishDate  | 2017-07-02  |
    When a GET request is received on /news/1.json
    Then the news is returned as json

  Scenario: Receiving a  GET request for a not existing news
    Given