package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class WebServiceRunner {

    private static Response resp;
    private static ObjectMapper mapper = new ObjectMapper();
    private static Response response;

    public static Response runGetRequestWithAuthorName(RequestSpecification request, String authorName, String param){
        response = request.parameters("q",param+authorName)
                .get(ConfigurationReader.getProperty("url"));
        System.out.println(response.asString());
        return response;
    }

    public static int getStatusCode() {
        return response.statusCode();
    }

    public static Response runRequestWithFilterInDescOrder(RequestSpecification request, String filter){
        response = request.parameters("sort", filter, "order", "desc").get(ConfigurationReader.getProperty("url"));
        return response;
    }

    public static Response runRequestWithFilterInAscOrder(RequestSpecification request, String filter){
        response = request.parameters("sort", filter, "order", "asc").get(ConfigurationReader.getProperty("url"));
        return response;
    }

    public static Response getResponseBody(Response response){
        try {
            resp = mapper.readValue(response.asString(), Response.class);
        } catch (Exception e) {
            System.out.println("conversion failed");
        }


        if(resp != null)
            return resp;
        System.out.println("request did not run yet");
        return null;
    }
}
