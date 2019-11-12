package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.api;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.ApiClient;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.oauth.TokenDetails;

import java.util.Map;

public interface LoginControllerApi extends ApiClient.Api {

    @RequestLine("POST /oauth/token")
    @Headers({
            "Accept: */*",
            "Content-Type: application/x-www-form-urlencoded",
    })
    TokenDetails getToken(@QueryMap Map<String, String> details);
}
