Feature: InMemoryNewsRepository
  Scenario: Saving a new news
    When a new News is saved
      | title        | testTitle   |
      | body         | testBody    |
      | author       | testAuthor  |
      | publishDate  | 2017-07-02  |
    Then news list should be updated with new News

  Scenario: Finding a news
    Given an existing news
      | newsId       | 1           |
      | title        | testTitle   |
      | body         | testBody    |
      | author       | testAuthor  |
      | publishDate  | 2017-07-02  |
    When finding a News with newsId 1
    Then a News is returned with expected values

  Scenario: Getting all news
    Given an existing list of news
      | newsId | title | body | author | publishDate |
      |    1   |   Aa  |  Ab  |  Ac    | 2017-07-01  |
      |    2   |   Ba  |  Bb  |  Bc    | 2017-07-02  |
      |    3   |   Ca  |  Cb  |  Cc    | 2017-07-03  |
    When getting all News
    Then proper News list is returned