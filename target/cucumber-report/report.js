$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./src/test/resources/features/SearchByAuthor.feature");
formatter.feature({
  "name": "Test Search Repository by Author Name - Git Hub Functionality",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@search"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Search repository by author name - Positive scenario",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "ContentType and AcceptType is Json",
  "keyword": "Given "
});
formatter.step({
  "name": "user enters valid \u003cauthorName\u003e and hits api",
  "keyword": "When "
});
formatter.step({
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "name": "user verifies the \u003crepository1\u003e exists and the \u003crepository2\u003e exists",
  "keyword": "Then "
});
formatter.step({
  "name": "user verifies the \u003cauthorName\u003e of repositories",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "authorName",
        "repository1",
        "repository2"
      ]
    },
    {
      "cells": [
        "chase",
        "vim-ansible-yaml",
        "focuspoint-vim"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Search repository by author name - Positive scenario",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@search"
    }
  ]
});
formatter.step({
  "name": "ContentType and AcceptType is Json",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.contenttype_and_AcceptType_is_Json()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters valid chase and hits api",
  "keyword": "When "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.user_enters_valid_and_hits_api(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.status_code_should_be(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verifies the vim-ansible-yaml exists and the focuspoint-vim exists",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.user_verifies_the_exists_and_the_exists(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verifies the chase of repositories",
  "keyword": "And "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.user_verifies_the_of_repositories(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Search repository by author name - Negative scenario",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "ContentType and AcceptType is Json",
  "keyword": "Given "
});
formatter.step({
  "name": "user enters valid \u003cauthorName\u003e and hits api",
  "keyword": "When "
});
formatter.step({
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "name": "user verifies that invalid \u003crepository1\u003e and invalid \u003crepository2\u003e do not exist",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "authorName",
        "repository1",
        "repository2"
      ]
    },
    {
      "cells": [
        "asakg",
        "A17g",
        "bghies"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Search repository by author name - Negative scenario",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@search"
    }
  ]
});
formatter.step({
  "name": "ContentType and AcceptType is Json",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.contenttype_and_AcceptType_is_Json()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters valid asakg and hits api",
  "keyword": "When "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.user_enters_valid_and_hits_api(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.status_code_should_be(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verifies that invalid A17g and invalid bghies do not exist",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.user_verifies_that_invalid_and_invalid_do_not_exist(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Search repository by author name - Negative scenario",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "ContentType and AcceptType is Json",
  "keyword": "Given "
});
formatter.step({
  "name": "user enters invalid \u003c\"parameter\"\u003e and valid \u003c\"authorName\"\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "name": "no items should be displayed",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "parameter",
        "authorName"
      ]
    },
    {
      "cells": [
        "Ujhkbr-",
        "chase"
      ]
    },
    {
      "cells": [
        "us,beR:",
        "chicago"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Search repository by author name - Negative scenario",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@search"
    }
  ]
});
formatter.step({
  "name": "ContentType and AcceptType is Json",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.contenttype_and_AcceptType_is_Json()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters invalid \u003c\"parameter\"\u003e and valid \u003c\"authorName\"\u003e",
  "keyword": "And "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.user_enters_invalid_and_valid(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.status_code_should_be(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "no items should be displayed",
  "keyword": "And "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.no_items_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Search repository by author name - Negative scenario",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@search"
    }
  ]
});
formatter.step({
  "name": "ContentType and AcceptType is Json",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.contenttype_and_AcceptType_is_Json()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters invalid \u003c\"parameter\"\u003e and valid \u003c\"authorName\"\u003e",
  "keyword": "And "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.user_enters_invalid_and_valid(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.status_code_should_be(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "no items should be displayed",
  "keyword": "And "
});
formatter.match({
  "location": "SearchByAuthorNameSteps.no_items_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
});