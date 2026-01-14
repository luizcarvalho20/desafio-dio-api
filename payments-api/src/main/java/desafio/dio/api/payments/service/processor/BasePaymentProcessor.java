package desafio.dio.api.payments.service.processor;

import desafio.dio.api.payments.domain.exception.BusinessException;
import desafio.dio.api.payments.domain.model.Payment;
import desafio.dio.api.payments.service.processor.gateway.FraudChecker;
import desafio.dio.api.payments.service.processor.gateway.ReceiptSender;

public abstract class BasePaymentProcessor implements PaymentProcessor {

    private final FraudChecker fraudChecker;
    private final ReceiptSender receiptSender;

    protected BasePaymentProcessor(FraudChecker fraudChecker, ReceiptSender receiptSender) {
        this.fraudChecker = fraudChecker;
        this.receiptSender = receiptSender;
    }

    @Override
    public final Payment process(Payment payment) {
        payment.markProcessing();

        if (fraudChecker.isFraudSuspected(payment)) {
            payment.fail("FRAUD_SUSPECTED");
            throw new BusinessException("Pagamento bloqueado por suspeita de fraude.");
        }

        Payment processed = doProcess(payment);
        receiptSender.sendReceipt(processed);
        return processed;
    }

    @Override
    public final Payment confirm(Payment payment, String confirmationCode) {
        if (confirmationCode == null || confirmationCode.isBlank()) {
            throw new BusinessException("confirmationCode é obrigatório.");
        }
        Payment confirmed = doConfirm(payment, confirmationCode);
        receiptSender.sendReceipt(confirmed);
        return confirmed;
    }

    protected abstract Payment doProcess(Payment payment);
    protected abstract Payment doConfirm(Payment payment, String confirmationCode);
}