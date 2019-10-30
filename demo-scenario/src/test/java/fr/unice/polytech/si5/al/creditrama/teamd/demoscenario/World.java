package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario;

import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.api.BankControllerApi;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.api.ClientControllerApi;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.api.LoginControllerApi;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank.Client;

public class World {

    private ApiClient apiClient;
    private BankControllerApi bankControllerApi;
    private ClientControllerApi clientControllerApi;
    private LoginControllerApi loginControllerApi;

    public World() {
        apiClient = new ApiClient();
        bankControllerApi = apiClient.setBasePath(ServiceHost.BANK_HOST.getHost()).buildClient(BankControllerApi.class);
        clientControllerApi = apiClient.setBasePath(ServiceHost.BANK_HOST.getHost()).buildClient(ClientControllerApi.class);
        loginControllerApi = apiClient.setBasePath(ServiceHost.LOGIN_HOST.getHost()).buildClient(LoginControllerApi.class);
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

    public Client createClient(String username, String password, String email) {
        return clientControllerApi.register(Client.builder().username(username).password(password).email(email).build());
    }

    enum ServiceHost {
        BANK_HOST("http://localhost:8080", System.getenv("BANK_HOST")),
        LOGIN_HOST("http://localhost:9191", System.getenv("LOGIN_HOST"));

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
