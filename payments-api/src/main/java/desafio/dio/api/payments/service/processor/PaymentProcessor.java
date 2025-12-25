package desafio.dio.api.payments.service.processor;

import desafio.dio.api.payments.domain.model.Payment;
import desafio.dio.api.payments.domain.model.PaymentMethod;

public interface PaymentProcessor {

    PaymentMethod supports();

    Payment process(Payment payment);

    Payment confirm(Payment payment, String confirmationCode);
}
