@API_smoke
Feature: API_Web_React_E-E_Validation
Background:
  Given The base URI of API is "http://10.192.190.130:5000"

Scenario: Post_Request
  When I send a POST request to the API with endpoint "/api/trainings" and name 7
  Then I should receive the post response 
  And verify the status code is "201" and post request is successful in API
  And validate if a new training is CREATED in the Web

Scenario: Put_Request
  When I send a PUT request to the API with endpoint "/api/trainings/" and name 6
  Then I should receive the put response
  And the status code contains "200" and put request is successful in API
  And validate if the corresponding record got UPDATED in the Web

Scenario: Get_Request
  When I send a GET request to the API with endpoint "/api/trainings"
  Then I should receive the response 
  And the status code is "200"

Scenario: Delete_Request
  When I send a DELETE request to the API with endpoint "/api/trainings/"
  Then I should receive the delete response 
  And verify if the status code has "204" and delete request is successful in API
  And validate if the corresponding record got DELETED in the Web

  