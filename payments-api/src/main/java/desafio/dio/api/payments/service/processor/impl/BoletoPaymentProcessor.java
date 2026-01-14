package desafio.dio.api.payments.service.processor.impl;

import desafio.dio.api.payments.domain.model.Payment;
import desafio.dio.api.payments.domain.model.PaymentMethod;
import desafio.dio.api.payments.service.processor.BasePaymentProcessor;
import desafio.dio.api.payments.service.processor.gateway.FraudChecker;
import desafio.dio.api.payments.service.processor.gateway.ReceiptSender;
import org.springframework.stereotype.Component;

@Component
public class BoletoPaymentProcessor extends BasePaymentProcessor {

    public BoletoPaymentProcessor(FraudChecker fraudChecker, ReceiptSender receiptSender) {
        super(fraudChecker, receiptSender);
    }

    @Override
    public PaymentMethod supports() {
        return PaymentMethod.BOLETO;
    }

    @Override
    protected Payment doProcess(Payment payment) {
        // Boleto normalmente fica pendente até compensar/confirmar
        return payment;
    }

    @Override
    protected Payment doConfirm(Payment payment, String confirmationCode) {
        payment.confirm("BOLETO-" + confirmationCode);
        return payment;
    }
}
