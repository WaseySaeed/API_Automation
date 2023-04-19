package util;

import java.util.HashMap;
import java.util.Map;

import static config.configProperties.apiHost;
import static config.configProperties.apiKey;

public class utilityFunction {

    public static HashMap<String,String> getAuthenticationHeaders()
    {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("X-RapidAPI-Host",apiHost);
        headers.put("X-RapidAPI-Key",apiKey);

        return headers;
    }
}
