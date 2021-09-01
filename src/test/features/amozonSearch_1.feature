@FireFox
  Feature: Validate search functionality

    Background: user launches webpage
      Given amazon webpage is launched in "firefox"


      @SanityFlow
      Scenario Outline: Search for a product and validate result
        When user enter a "<product>" name
        And clicks on search button
        Then search results should be displayed

        Examples:
        |product|
        |MacBook Pro |


        @RegressionFlow
        Scenario: Search for a product and validate result 2
          When user enter a product name from DT
            |row0col0|row0col1|row0col2|
            |row1col0|row1col1|row1col2|
          And clicks on search button
          Then search results should be displayed


        @RegressionFlow
        Scenario: Search for a product and validate result 2
          When user enter a product name
          And clicks on search button
          Then search results should be displayed