package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client extends User {
    @JsonProperty
    private List<BankAccount> bankAccounts;
    @JsonProperty
    private List<Integer> recipients;
    @JsonProperty
    private List<BankTransaction> bankTransactions;

    @Builder
    Client(String username, String password, String email) {
        super(username, password, email);
    }

    @Builder
    public Client(Integer id,
                  String username,
                  String password,
                  String email,
                  boolean enabled,
                  boolean accountNonExpired,
                  boolean credentialsNonExpired,
                  boolean accountNonLocked,
                  List<Role> roles,
                  List<BankAccount> bankAccounts,
                  List<Integer> recipients,
                  List<BankTransaction> bankTransactions) {
        super(id, username, password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, roles);
        this.bankAccounts = bankAccounts;
        this.recipients = recipients;
        this.bankTransactions = bankTransactions;
    }
}
