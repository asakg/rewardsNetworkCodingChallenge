package stepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import utilities.WebServiceRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

public class SearchByAuthorNameSteps {

    public static RequestSpecification request;
    public static Response response;
    private static Response resp;
    private static ObjectMapper mapper = new ObjectMapper();

    @Given("^ContentType and AcceptType is Json$")
    public RequestSpecification contenttype_and_AcceptType_is_Json() {
        request = RestAssured.given().accept(ContentType.JSON).and().contentType(ContentType.JSON);
        return request;
    }

    @When("^user enters valid (.*) and hits api$")
    public void user_enters_valid_and_hits_api(String authorName) {
        String validParam = "user:";
        response = WebServiceRunner.runGetRequestWithAuthorName(contenttype_and_AcceptType_is_Json(), authorName, validParam);
    }

    @Then("^status code should be (\\d+)$")
    public void status_code_should_be(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
        System.out.println("Service status: " + response.getStatusCode());
    }

    @Then("^user verifies the (.*) exists and the (.*) exists$")
    public void user_verifies_the_exists_and_the_exists(String repo1, String repo2) {
        response.then().assertThat().body("items.name", hasItem(repo1));
        response.then().assertThat().body("items.name", hasItem(repo2));
    }

    @Then("^user verifies the (.*) of repositories$")
    public void user_verifies_the_of_repositories(String authorName) {
        response.then().assertThat().body("items.owner.login", hasItem(authorName));
    }

    @Then("^user verifies that invalid (.*) and invalid (.*) do not exist$")
    public void user_verifies_that_invalid_and_invalid_do_not_exist(String repo1, String repo2) {

        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        Assert.assertEquals(bodyAsString.contains(repo1), false, "Response body doesn't contain: "+repo1);
        Assert.assertEquals(bodyAsString.contains(repo2), false, "Response body doesn't contain: "+repo2);

    }

    @Given("^user enters invalid (.*) and valid (.*)$")
    public void user_enters_invalid_and_valid(String invalidParameter, String authorName) {
        response = WebServiceRunner.runGetRequestWithAuthorName(request, authorName, invalidParameter);
        System.out.println(response.asString());
    }

    @Then("^no items should be displayed$")
    public void no_items_should_be_displayed() {
        response.then().assertThat().body("items", hasSize(0));
        response.then().assertThat().body("items", hasSize(0));
    }

    ///////  sort ///////

    private static String authorName = "chase";
    @When("^user enters valid authorName$")
    public void user_enters_valid_authorName() {
        String validParam = "user:";
        response = WebServiceRunner.runGetRequestWithAuthorName(new SearchByAuthorNameSteps().contenttype_and_AcceptType_is_Json(), authorName, validParam);
    }

    @When("^user selects sort by (.*) in desc order$")
    public void user_selects_sort_by_in_desc_order(String filter) {
        response = WebServiceRunner.runRequestWithFilterInDescOrder(request, filter);
    }

    @Then("^user verifies repository with most (.*)  comes first$")
    public void user_verifies_repository_with_most_comes_first(String filter) {
        JsonPath json = response.jsonPath();
        if(filter.equals("forks")) {
            List<Integer> list = json.getList("items.forks_count");
            boolean f = false;
            for (int i = 1; i < list.size(); i++) {
                if(list.get(0) >= list.get(i)) {
                    f = true;
                }else {
                    f=false;
                }
            }
            Assert.assertTrue(f);

        }else if(filter.equals("stars")) {
            List<Integer> list = json.getList("items.stargazers_count");
            boolean f = false;
            for (int i = 1; i < list.size(); i++) {
                if(list.get(0) >= list.get(i)) {
                    f = true;
                }else {
                    f=false;
                }
            }
            Assert.assertTrue(f);

        }else {
            System.out.println("FAIL: exception in while reading filters desc:   "+ filter);
            System.out.println(5/0);
        }

    }

    @When("^user selects sort by (.*) in asc order$")
    public void user_selects_sort_by_in_asc_order(String filter) {
        response = WebServiceRunner.runRequestWithFilterInAscOrder(request, filter);

    }

    @Then("^user verifies repository with least (.*)  comes first$")
    public void user_verifies_repository_with_least_comes_first(String filter) {
        JsonPath json = response.jsonPath();
        if(filter.equals("forks")) {
            List<Integer> list = json.getList("items.forks_count");
            boolean f = false;
            for (int i = 1; i < list.size(); i++) {
                if(list.get(0) <= list.get(i)) {
                    f = true;
                }
            }
            Assert.assertTrue(f);

        }else if(filter.equals("stars")) {
            List<Integer> list = json.getList("items.stargazers_count");
            boolean f = false;
            for (int i = 1; i < list.size(); i++) {
                if(list.get(0) <= list.get(i)) {
                    f = true;
                }
            }
            Assert.assertTrue(f);

        }else {
            System.out.println("FAIL: exception in while reading filters asc:   "+ filter);
            System.out.println(5/0);

        }

    }

    @When("^user selects sort by recently \"([^\"]*)\"$")
    public void user_selects_sort_by_recently(String filter) {
        response = WebServiceRunner.runRequestWithFilterInDescOrder(request, filter);
    }

    @Then("^user verifies recently \"([^\"]*)\" repository comes first$")
    public void user_verifies_recently_repository_comes_first(String filter) {
        JsonPath json = response.jsonPath();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            if(filter.equals("updated")) {
                List<String> dates = json.getList("items.updated_at");
                Date date1 = sdf.parse(dates.get(0));
                boolean b = false;
                for (int i = 1; i < dates.size(); i++) {
                    if(date1.after(sdf.parse(dates.get(i)))){
                        b=true;
                    }else {
                        b = false;
                    }
                }
                Assert.assertTrue(b);
            }
        }catch(ParseException e) {
            System.out.println("Exception while comparing asc dates");
        }	}


    @When("^user selects sort by least recently \"([^\"]*)\"$")
    public void user_selects_sort_by_least_recently(String filter) {
        response = WebServiceRunner.runRequestWithFilterInAscOrder(request, filter);
    }

    @Then("^user verifies least recently \"([^\"]*)\" repository comes first$")
    public void user_verifies_least_recently_repository_comes_first(String filter){
        JsonPath json = response.jsonPath();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            if(filter.equals("updated")) {
                List<String> dates = json.getList("items.updated_at");
                Date date1 = sdf.parse(dates.get(0));
                boolean b = false;
                for (int i = 1; i < dates.size(); i++) {
                    if(date1.before(sdf.parse(dates.get(i)))){
                        b=true;
                    }else {
                        b = false;
                    }
                }
                Assert.assertTrue(b);
            }
        }catch(ParseException e) {
            System.out.println("Exception while comparing asc dates");
        }
    }


}
