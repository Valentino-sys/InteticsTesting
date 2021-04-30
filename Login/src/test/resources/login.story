Scenario: Login
Given I open login page
When I enter 'email'
And I enter 'password'
And I click the button Sign in
Then I am on main page
