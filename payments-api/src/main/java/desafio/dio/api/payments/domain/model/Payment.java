package desafio.dio.api.payments.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    private PaymentMethod method;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false, length = 3)
    private String currency;

    private String externalReference;

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    // ✅ obrigatório pro JPA
    protected Payment() {}

    public Payment(PaymentMethod method, Money money) {
        this.id = UUID.randomUUID();
        this.method = method;
        this.status = PaymentStatus.CREATED;
        this.amount = money.amount();
        this.currency = money.currency().getCurrencyCode();
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = this.createdAt;
    }

    public void markProcessing() { this.status = PaymentStatus.PROCESSING; touch(); }
    public void confirm(String externalRef) { this.status = PaymentStatus.CONFIRMED; this.externalReference = externalRef; touch(); }
    public void fail(String externalRef) { this.status = PaymentStatus.FAILED; this.externalReference = externalRef; touch(); }
    public void cancel() { this.status = PaymentStatus.CANCELED; touch(); }

    private void touch() { this.updatedAt = OffsetDateTime.now(); }

    public UUID getId() { return id; }
    public PaymentMethod getMethod() { return method; }
    public PaymentStatus getStatus() { return status; }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getExternalReference() { return externalReference; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public OffsetDateTime getUpdatedAt() { return updatedAt; }
}
