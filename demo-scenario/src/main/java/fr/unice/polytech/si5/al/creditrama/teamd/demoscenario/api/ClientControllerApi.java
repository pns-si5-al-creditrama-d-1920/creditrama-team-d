package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.ApiClient;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank.Client;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

public interface ClientControllerApi extends ApiClient.Api {
    @RequestLine("GET /clients")
    @Headers({
            "Accept: */*",
    })
    List<Client> getUsers();

    @RequestLine("GET /clients/{id}")
    @Headers({
            "Accept: */*",
    })
    Client getUserById(@Param(value = "id") int clientId);

    @RequestLine("POST /register")
    @Headers({
            "Accept: */*",
            "Content-Type: application/json",
    })
    Client addUser(@RequestBody Client customer);

}
