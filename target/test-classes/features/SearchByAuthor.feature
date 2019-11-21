    @search

	Feature: Test Search Repository by Author Name - Git Hub Functionality

	Scenario Outline: Search repository by author name - Positive scenario
	Given ContentType and AcceptType is Json
	When user enters valid <authorName> and hits api
	Then status code should be 200
	Then user verifies the <repository1> exists and the <repository2> exists
	And user verifies the <authorName> of repositories
	Examples:
	| 	authorName	      |  repository1    |  repository2     |
	|   chase             |   vim-ansible-yaml         |  focuspoint-vim       |


	Scenario Outline: Search repository by author name - Negative scenario
	Given ContentType and AcceptType is Json
	When user enters valid <authorName> and hits api
	Then status code should be 200
	Then user verifies that invalid <repository1> and invalid <repository2> do not exist
	Examples:
	| 	authorName	   |  repository1    |  repository2     |
	|   asakg          |   A17g          |  bghies          |



	Scenario Outline: Search repository by author name - Negative scenario
	Given ContentType and AcceptType is Json
	And user enters invalid <"parameter"> and valid <"authorName">
	Then status code should be 200
	And no items should be displayed
	Examples:
	|   parameter     |  authorName    |
	| 	Ujhkbr-         |  chase         |
	|   us,beR:         |  chicago        |