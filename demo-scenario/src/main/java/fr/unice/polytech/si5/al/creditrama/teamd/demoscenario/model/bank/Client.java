package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class Client extends User {
    @JsonProperty
    private List<BankAccount> bankAccounts;
    @JsonProperty
    private List<Integer> recipients;
    @JsonProperty
    private List<BankTransaction> transactions;

    @Builder
    Client(String username, String password, String email) {
        super(username, password, email);
    }
}
