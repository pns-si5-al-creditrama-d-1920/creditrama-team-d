package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @JsonProperty
    private Integer bankAccountId;
    @JsonProperty
    private Double balance;
}
