Narrative: 
In order to break the code
As a codebreaker
I want to submit a guess and get a result

Scenario: 
Given The secret code is 1234
When I guess 3210
Then The mark is +--

Scenario:
Given The secret code is 1234
When I guess 1234
Then The mark is ++++

Scenario:
Given The secret code is 1234
When I guess 5678
Then The mark is Try again!
