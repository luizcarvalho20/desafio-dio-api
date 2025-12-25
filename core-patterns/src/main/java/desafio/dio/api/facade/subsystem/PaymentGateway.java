package desafio.dio.api.facade.subsystem;

import java.util.UUID;

public class PaymentGateway {

    public String authorize() {
        // Simula uma autorização e retorna um "authCode"
        return "AUTH-" + UUID.randomUUID().toString().substring(0, 8);
    }
}
