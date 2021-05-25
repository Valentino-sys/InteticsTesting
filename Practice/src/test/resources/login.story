
Scenario: Login
Given I open login page
When I click the button
And I enter 'email' valentinolariu2017@gmail.com
And I enter 'password' valentin555
And I click the button Sign in
Then I am on main page
Then I check if a part of the text matches

Given I go to the book page 'url' 3263607
When I click  button want to read
Then The inscription View shelf appeared


Given I go to the my books page
When I check that my book is on the list
And I delete the book
Then I check that my book is not in the list
