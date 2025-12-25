package desafio.dio.api.payments.service.processor.gateway;

import desafio.dio.api.payments.domain.model.Payment;

public interface ReceiptSender {
    void sendReceipt(Payment payment);
}
