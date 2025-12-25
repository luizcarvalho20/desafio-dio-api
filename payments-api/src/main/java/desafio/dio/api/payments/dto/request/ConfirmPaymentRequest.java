package desafio.dio.api.payments.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ConfirmPaymentRequest(
        @NotBlank String confirmationCode
) {}
