package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankAccount {
    @JsonProperty
    private Integer bankAccountId;
    @JsonProperty
    private Double balance;
}
