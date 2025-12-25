package desafio.dio.api.facade.subsystem;

import java.math.BigDecimal;

public class FraudService {

    public boolean isSuspect(BigDecimal amount) {
        // Regra simples: acima de 5000, suspeito
        return amount.compareTo(new BigDecimal("5000.00")) > 0;
    }
}
