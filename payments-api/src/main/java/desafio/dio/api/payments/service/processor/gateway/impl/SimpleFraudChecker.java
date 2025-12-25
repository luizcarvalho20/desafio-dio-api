package desafio.dio.api.payments.service.processor.gateway.impl;

import desafio.dio.api.payments.domain.model.Payment;
import desafio.dio.api.payments.service.processor.gateway.FraudChecker;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SimpleFraudChecker implements FraudChecker {
    @Override
    public boolean isFraudSuspected(Payment payment) {
        return payment.getAmount().compareTo(new BigDecimal("5000.00")) > 0;
    }
}
