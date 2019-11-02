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
public class BankTransaction {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private Integer sourceId;
    @JsonProperty
    private Integer destinationId;
    @JsonProperty
    private Double amount;
}
