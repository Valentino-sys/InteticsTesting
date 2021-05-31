Scenario: Selecting recommendations
Given I open login page
When I click the button
And I enter 'email' valentinolariu2017@gmail.com
And I enter 'password' valentin555
And I click the button Sign in
Then I am on main page

When I click Browse button
And I choose the fourth recommendation
Then I go to the classic books page

When I select the third book from the list provided

When I click on the arrow next to the button Want to read
And I select the Currently reading field
Then A message appeared about adding a book to the list

Given I go to the my books page
When I click on Currently Reading link
When I check that my book is on the list
And I delete the book
Then I check that my book is not in the list
And I closed browser


