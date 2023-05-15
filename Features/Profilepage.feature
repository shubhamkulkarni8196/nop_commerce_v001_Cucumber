
Feature: profile

@sanity
Scenario: Add profile photo

Given user launch Chrome browser
When user opens url "https://www.facebook.com/login" 
And user enters email as "shubhamcoolkarni8196@gmail.com" and Password as "Shubham@8196"
And user click on Login
Then page title should be "(2) Facebook"
When user click on profile menu
Then page title should be "(2) Shubh Kulkarni | Facebook"
When user click on profile image 
And click on Add photo 
Then user can view upload photo
When user click on 

@regression
Scenario: search friends

When user click on profile menu
Then page title should be "(2) Shubh Kulkarni | Facebook"
When user click on frinds 
Then title should be "(2) Friends | Facebook"
When click on friend request
And click on sent request
Then user can view message "When you send someone a friend request, it will appear here."
When user click on suggestion
And click on search field
Then user can search by filling characters



















profile - //span[text()='Shubh Kulkarni']
add photo - //div[@class="xb57i2i x1q594ok x5lxg6s x6ikm8r x1ja2u2z x1pq812k x1rohswg xfk6m8 x1yqm8si xjx87ck xx8ngbg xwo3gff x1n2onr6 x1oyok0e x1odjw0f x1e4zzel x1qjc9v5 x9f619 x78zum5 xdt5ytf xkhd6sd x4uap5 x1ten1a2 xz7cn9q x168biu4"]/div/div[1]/div[1]