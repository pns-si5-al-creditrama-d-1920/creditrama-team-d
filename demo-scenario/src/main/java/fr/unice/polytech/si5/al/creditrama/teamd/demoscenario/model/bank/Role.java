package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Role {
    @JsonProperty
    private Integer roleId;
    @JsonProperty
    private String role_name;
    @JsonProperty
    private List<Permission> permissions;
}
