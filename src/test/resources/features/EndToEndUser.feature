@User-Chaining 
Feature: User API end to end positive scenarios

@POST @Create_User
Scenario: Verify that the Admin creates a new User with valid credentials
Given Admin creates a request body for the USER API with valid test data 
When Admin sends a Post request 
Then Admin receives 201 created status code

@Get_All_Users @GET
Scenario: Check if Admin able to retrieve all user details with valid endpoint and valid authorization
Given Admin creates GET request for the user service API
When Admin sends a Get request
Then Admin receives 200 OK Status with response body

@Get_User_By_Id @GET
Scenario: Check if Admin able to retrieve user details with  valid Id
Given Admin creates GET request with valid user id
When Admin sends the Get request with Valid id
Then Admin receives Status Code 200 OK with Response Body 

@Get_User_By_Name @GET
Scenario: Verify if Admin retrieves  user details with valid user first name
Given Admin creates Http request with valid user first name
When Admin sends Get request with valid user name
Then Admin receives 200 OK Status with expected username response body

@PUT @Update_User
Scenario: Check if Admin able to update user details with valid userId and valid request body
Given Admin creates PUT Request for the user service API endpoint with Request Body 
When Admin sends HTTPS Request with valid endpoint
Then Admin receives 200 OK status with updated details in response body.

#@Delete_User_By_Firstname @DELETE
#Scenario: Admin able to delete a user with valid user first name
#Given Admin sets delete request with endpoint and valid username
#When Admin sends User delete request with endpoint
#Then Admin receives 200 ok status after deletion

@Delete_User_By_UserId @DELETE
Scenario: Admin able to delete a user with valid userId
Given Admin sets delete request with endpoint and valid userId
When Admin sends User delete request with id
Then Admin receives 200 OK status after deleting user with userId