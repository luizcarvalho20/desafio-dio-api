package desafio.dio.api.payments.dto.request;

import desafio.dio.api.payments.domain.model.PaymentMethod;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreatePaymentRequest(
        @NotNull PaymentMethod method,
        @NotNull @DecimalMin(value = "0.01") BigDecimal amount
) {}
