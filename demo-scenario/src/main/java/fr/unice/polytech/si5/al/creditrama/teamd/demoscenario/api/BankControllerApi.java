package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.ApiClient;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank.BankAccount;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank.BankTransaction;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

public interface BankControllerApi extends ApiClient.Api {

    @RequestLine("GET /bank/clients/{id}/bank-accounts")
    @Headers({
            "Accept: */*",
    })
    List<BankAccount> getMyBankAccounts(@Param(value = "id") Integer clientId);

    @RequestLine("POST /bank/clients/{id}/bank-accounts")
    @Headers({
            "Accept: */*",
            "Content-Type: application/json",
    })
    BankAccount createBankAccount(@Param(value = "id") Integer clientId, @RequestBody BankAccount bankAccount);

    @RequestLine("GET /bank/clients/{id}/recipients")
    @Headers({
            "Accept: */*",
    })
    List<Integer> getRecipients(@Param(value = "id") Integer clientId);

    @RequestLine("POST /bank/clients/{id}/recipients")
    @Headers({
            "Accept: */*",
            "Content-Type: application/json",
    })
    Integer addRecipient(@Param(value = "id") Integer clientId, @RequestBody Integer recipientBankAccountId);

    @RequestLine("POST /bank/clients/{id}/transactions")
    @Headers({
            "Accept: */*",
            "Content-Type: application/json",
    })
    BankTransaction transfer(@Param(value = "id") Integer clientId, @RequestBody BankTransaction transaction);
}
