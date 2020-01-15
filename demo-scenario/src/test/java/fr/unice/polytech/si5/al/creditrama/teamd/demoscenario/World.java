package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario;

import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.api.BankControllerApi;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.api.ClientControllerApi;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.api.LoginControllerApi;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank.Client;

import java.util.HashMap;
import java.util.Map;

public class World {

    private static BankControllerApi bankControllerApi;
    private static ClientControllerApi clientControllerApi;
    private static LoginControllerApi loginControllerApi;

    public World() {
        ApiClient apiClient = new ApiClient();
        bankControllerApi = apiClient.setBasePath(ServiceHost.CLIENT_HOST.getHost()).buildClient(BankControllerApi.class);
        clientControllerApi = apiClient.setBasePath(ServiceHost.CLIENT_HOST.getHost()).buildClient(ClientControllerApi.class);
        loginControllerApi = apiClient.setBasePath(ServiceHost.AUTHORIZATION_HOST.getHost()).buildClient(LoginControllerApi.class);
    }

    public BankControllerApi getBankControllerApi() {
        return bankControllerApi;
    }

    public ClientControllerApi getClientControllerApi() {
        return clientControllerApi;
    }

    public LoginControllerApi getLoginControllerApi() {
        return loginControllerApi;
    }

    static void deleteClient(Integer clientId) {
        clientControllerApi.deleteUserById(clientId);
    }

    public Client createClient(String username, String password, String email) {
        Client client = clientControllerApi.register(Client.builder().username(username).password(password).email(email).build());
        if (username.equals("alice")) {
            setAliceToken();
        }
        return client;
    }

    private void setAliceToken() {
        Map<String, String> details = new HashMap<>();
        details.put("grant_type", "password");
        details.put("username", "alice");
        details.put("password", "password");
        BasicAuthRequestInterceptor.token = loginControllerApi.getToken(details).getAccessToken();
    }

    enum ServiceHost {
        CLIENT_HOST("http://localhost:8080", System.getenv("CLIENT_HOST")),
        AUTHORIZATION_HOST("http://localhost:9191", System.getenv("AUTHORIZATION_HOST"));

        private String defaultHost;
        private String environmentHost;

        ServiceHost(String defaultHost, String environmentHost) {
            this.defaultHost = defaultHost;
            this.environmentHost = environmentHost;
        }

        public String getHost() {
            if (environmentHost == null) {
                return defaultHost;
            }
            return environmentHost;
        }
    }
}
