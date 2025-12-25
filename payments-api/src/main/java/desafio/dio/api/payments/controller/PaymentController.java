package desafio.dio.api.payments.controller;

import desafio.dio.api.payments.dto.request.ConfirmPaymentRequest;
import desafio.dio.api.payments.dto.request.CreatePaymentRequest;
import desafio.dio.api.payments.dto.response.PaymentResponse;
import desafio.dio.api.payments.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public PaymentResponse create(@RequestBody @Valid CreatePaymentRequest request) {
        return PaymentResponse.from(service.createAndProcess(request.method(), request.amount()));
    }

    @GetMapping("/{id}")
    public PaymentResponse getById(@PathVariable UUID id) {
        return PaymentResponse.from(service.findById(id));
    }

    @PostMapping("/{id}/confirm")
    public PaymentResponse confirm(@PathVariable UUID id, @RequestBody @Valid ConfirmPaymentRequest request) {
        return PaymentResponse.from(service.confirm(id, request.confirmationCode()));
    }
}
