package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.oauth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDetails {
    @JsonProperty("access_token")
    private String accessToken;
}
