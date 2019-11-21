package utilities;

import java.util.Map;

public class APIHeader {

    private static Map<String,String> headers;
    static {
        headers.put("Authorization", "Basic YmVuYXppcmJhaWFsaWV2YTpzM21pbmlndGk4MTkw");
        headers.put("Accept", "application/json");
    }

    public static Map<String,String> getHeaders(){
        return headers;
    }

}
