package desafio.dio.api.corepatterns.facade;

import desafio.dio.api.facade.subsystem.FraudService;
import desafio.dio.api.facade.subsystem.PaymentGateway;
import desafio.dio.api.facade.subsystem.ReceiptService;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Facade: simplifica o uso de vários subsistemas (fraude, gateway, recibo)
 * oferecendo uma única interface de alto nível.
 */
public class PaymentFacade {

    private final FraudService fraudService;
    private final PaymentGateway gateway;
    private final ReceiptService receiptService;

    public PaymentFacade() {
        // em Java puro, instanciamos direto
        this.fraudService = new FraudService();
        this.gateway = new PaymentGateway();
        this.receiptService = new ReceiptService();
    }

    public String pay(BigDecimal amount) {
        String paymentId = UUID.randomUUID().toString();

        if (fraudService.isSuspect(amount)) {
            receiptService.send(paymentId, "Pagamento bloqueado: suspeita de fraude.");
            return "FAILED";
        }

        String authCode = gateway.authorize();
        receiptService.send(paymentId, "Pagamento aprovado com código: " + authCode);
        return "APPROVED";
    }
}
