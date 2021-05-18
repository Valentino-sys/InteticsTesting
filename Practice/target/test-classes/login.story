
Scenario: Login
Given I open login page
When I click the button
And I enter 'email' valentinolariu2017@gmail.com
And I enter 'password' valentin555
And I click the button Sign in
Then I am on main page
Then I check if a part of the text matches