package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class User {
    @JsonProperty
    private Integer userId;
    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @JsonProperty
    private String email;
    @JsonProperty
    private boolean enabled;
    @JsonProperty
    private boolean accountNonExpired;
    @JsonProperty
    private boolean credentialsNonExpired;
    @JsonProperty
    private boolean accountNonLocked;
    @JsonProperty
    private List<Role> roles;

    User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
