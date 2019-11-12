package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Permission {
    @JsonProperty
    private Integer permissionId;
    @JsonProperty
    private String permission_name;
}
