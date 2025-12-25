package desafio.dio.api.payments.service.processor.gateway.impl;

import desafio.dio.api.payments.domain.model.Payment;
import desafio.dio.api.payments.service.processor.gateway.ReceiptSender;
import org.springframework.stereotype.Component;

@Component
public class LogReceiptSender implements ReceiptSender {
    @Override
    public void sendReceipt(Payment payment) {
        System.out.println("[receipt] payment=" + payment.getId() + " status=" + payment.getStatus());
    }
}
