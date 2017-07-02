Feature: NewsService
  Scenario: Receiving a  GET request for a not existing news
    Given news with id 11 doesn't exist
    When a GET request is received for news with newsId 11
    Then null is returned