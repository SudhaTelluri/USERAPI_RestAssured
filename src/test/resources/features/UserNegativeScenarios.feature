@NegativeScenarios
Feature: User Negative Scenarios

  Scenario Outline: Check User creation with invalid data
    Given Admin creates request body for the post request
    When Admin sends post request with invalid data from sheet "<SheetName>" and rownum <Rownum>
    Then Admin receives a status code 400 bad request

    Examples: 
      | SheetName   | Rownum |
      | InvalidData |      0 |
      | InvalidData |      1 |
      | InvalidData |      2 |
      | InvalidData |      3 |
      | InvalidData |      4 |
      | InvalidData |      5 |
      | InvalidData |      6 |
      | InvalidData |      7 |
      | InvalidData |      8 |
      | InvalidData |      9 |
      | InvalidData |     10 |
      | InvalidData |     11 |
      | InvalidData |     12 |
      | InvalidData |     13 |
      | InvalidData |     14 |
      | InvalidData |     15 |
      | InvalidData |     16 |
      | InvalidData |     17 |
      | InvalidData |     18 |
      | InvalidData |     19 |
      | InvalidData |     20 |
      | InvalidData |     21 |
      | InvalidData |     22 |
      | InvalidData |     23 |
      | InvalidData |     24 |
      | InvalidData |     25 |
      | InvalidData |     26 |
      | InvalidData |     27 |
      | InvalidData |     28 |
      | InvalidData |     29 |
      | InvalidData |     30 |
      | InvalidData |     31 |
      | InvalidData |     32 |
      | InvalidData |     33 |
      | InvalidData |     34 |
      | InvalidData |     35 |
      | InvalidData |     36 |
      | InvalidData |     37 |

  @POST @Create_User
  Scenario: Verify that the Admin creates a new User with valid credentials
    Given Admin creates a request body for the USER API with valid test data
    When Admin sends a Post request
    Then Admin receives 201 created status code

  Scenario Outline: Check User Updation with invalid data
    Given Admin creates request body for the put request
    When Admin sends put request with invalid data from sheet "<SheetName>" and rownum <Rownum>
    Then Admin receives a status code 400 bad request

    Examples: 
      | SheetName   | Rownum |
      | InvalidData |      0 |
      | InvalidData |      1 |
      | InvalidData |      2 |
      | InvalidData |      3 |
      | InvalidData |      4 |
      | InvalidData |      5 |
      | InvalidData |      6 |
      | InvalidData |      7 |
      | InvalidData |      8 |
      | InvalidData |      9 |
      | InvalidData |     10 |
      | InvalidData |     11 |
      | InvalidData |     12 |
      | InvalidData |     13 |
      | InvalidData |     14 |
      | InvalidData |     15 |
      | InvalidData |     16 |
      | InvalidData |     17 |
      | InvalidData |     18 |
      | InvalidData |     19 |
      | InvalidData |     20 |
      | InvalidData |     21 |
      | InvalidData |     22 |
      | InvalidData |     23 |
      | InvalidData |     24 |
      | InvalidData |     25 |
      | InvalidData |     26 |
      | InvalidData |     27 |
      | InvalidData |     28 |
      | InvalidData |     29 |
      | InvalidData |     30 |
      | InvalidData |     31 |
      | InvalidData |     32 |
      | InvalidData |     33 |
      | InvalidData |     34 |
      | InvalidData |     35 |
      | InvalidData |     36 |
      | InvalidData |     37 |

  @Delete_User_By_Firstname @DELETE
  Scenario: Admin able to delete a user with valid user first name
    Given Admin sets delete request with endpoint and valid username
    When Admin sends User delete request with endpoint
    Then Admin receives 200 ok status after deletion
