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
      | newsId       | 1           |
      | title        | testTitle   |
      | body         | testBody    |
      | author       | testAuthor  |
      | publishDate  | 2017-07-02  |
    When a GET request is received on /news/1.json
    Then the news is returned

    Scenario: Getting all news
      Given an existing list of news
      | newsId | title | body | author | publishDate |
      |    1   |   Aa  |  Ab  |  Ac    | 2017-07-01  |
      |    2   |   Ba  |  Bb  |  Bc    | 2017-07-02  |
      |    3   |   Ca  |  Cb  |  Cc    | 2017-07-03  |
      When a GET request is received on /news.json
      Then the news list is returned