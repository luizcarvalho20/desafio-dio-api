package desafio.dio.api.payments.dto.response;

import desafio.dio.api.payments.domain.model.Payment;
import desafio.dio.api.payments.domain.model.PaymentMethod;
import desafio.dio.api.payments.domain.model.PaymentStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record PaymentResponse(
        UUID id,
        PaymentMethod method,
        PaymentStatus status,
        BigDecimal amount,
        String currency,
        String externalReference,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
    public static PaymentResponse from(Payment p) {
        return new PaymentResponse(
                p.getId(),
                p.getMethod(),
                p.getStatus(),
                p.getAmount(),
                p.getCurrency(),
                p.getExternalReference(),
                p.getCreatedAt(),
                p.getUpdatedAt()
        );
    }
}
