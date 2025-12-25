package desafio.dio.api.payments.service.processor.gateway;

import desafio.dio.api.payments.domain.model.Payment;

public interface FraudChecker {
    boolean isFraudSuspected(Payment payment);
}
