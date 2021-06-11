Scenario: POST,GET,PUT,DELETE Requests

When I send a request to create a user without one required field /createuser
Then I get the negative status
When I'm sending a invalid email
Then I get the negative status
When I'm sending a empty name
Then I get the negative status
When I enter several values in the tasks field
Then I get the negative status
When I'm sending a invalid tasks
Then I get the negative status
When I enter several values in the companies field
Then I get the negative status
When I'm sending a invalid companies
Then I get the negative status
When I send a request to create a user only with required fields /createuser
Then I get the positive status
When I'm sending a valid email
Then I get the positive status
When I'm sending a valid name
Then I get the positive status

When I am sending delete request with invalid email
Then I get the negative status
When I am sending delete request with valid email
Then I get the positive status

When I send a request to create a user with all fields /createuser
Then I get the positive status


When I send a request to get data about user /getuser
Then I get the positive status
When I'm entering a non-existent user /getuser
Then I get the negative status

When I'm sending a put request with an existing email
Then I get the positive status

When I am sending a put request with a non-existent e-mail
Then I get the negative status
When I am sending a body without one required field
Then I get the negative status










