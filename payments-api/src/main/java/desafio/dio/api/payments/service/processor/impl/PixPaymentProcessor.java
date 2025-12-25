package desafio.dio.api.payments.service.processor.impl;

import desafio.dio.api.payments.domain.model.Payment;
import desafio.dio.api.payments.domain.model.PaymentMethod;
import desafio.dio.api.payments.service.processor.base.BasePaymentProcessor;
import desafio.dio.api.payments.service.processor.gateway.FraudChecker;
import desafio.dio.api.payments.service.processor.gateway.ReceiptSender;
import org.springframework.stereotype.Component;

@Component
public class PixPaymentProcessor extends BasePaymentProcessor {

    public PixPaymentProcessor(FraudChecker fraudChecker, ReceiptSender receiptSender) {
        super(fraudChecker, receiptSender);
    }

    @Override
    public PaymentMethod supports() {
        return PaymentMethod.PIX;
    }

    @Override
    protected Payment doProcess(Payment payment) {
        payment.confirm("PIX-TXID-" + payment.getId().toString().substring(0, 8));
        return payment;
    }

    @Override
    protected Payment doConfirm(Payment payment, String confirmationCode) {
        // PIX já é confirmado no processamento
        return payment;
    }
}
