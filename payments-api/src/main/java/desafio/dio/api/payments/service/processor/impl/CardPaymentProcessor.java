package desafio.dio.api.payments.service.processor.impl;

import desafio.dio.api.payments.domain.model.Payment;
import desafio.dio.api.payments.domain.model.PaymentMethod;
import desafio.dio.api.payments.service.processor.base.BasePaymentProcessor;
import desafio.dio.api.payments.service.processor.gateway.FraudChecker;
import desafio.dio.api.payments.service.processor.gateway.ReceiptSender;
import org.springframework.stereotype.Component;

@Component
public class CardPaymentProcessor extends BasePaymentProcessor {

    public CardPaymentProcessor(FraudChecker fraudChecker, ReceiptSender receiptSender) {
        super(fraudChecker, receiptSender);
    }

    @Override
    public PaymentMethod supports() {
        return PaymentMethod.CARD;
    }

    @Override
    protected Payment doProcess(Payment payment) {
        // Cartão aguarda confirmação
        return payment;
    }

    @Override
    protected Payment doConfirm(Payment payment, String confirmationCode) {
        payment.confirm("CARD-AUTH-" + confirmationCode);
        return payment;
    }
}
