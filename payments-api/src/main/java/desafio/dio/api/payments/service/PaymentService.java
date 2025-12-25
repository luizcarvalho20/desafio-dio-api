package desafio.dio.api.payments.service;

import desafio.dio.api.payments.domain.exception.NotFoundException;
import desafio.dio.api.payments.domain.model.Money;
import desafio.dio.api.payments.domain.model.Payment;
import desafio.dio.api.payments.domain.model.PaymentMethod;
import desafio.dio.api.payments.repository.PaymentRepository;
import desafio.dio.api.payments.service.factory.PaymentProcessorFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository repository;
    private final PaymentProcessorFactory factory;

    public PaymentService(PaymentRepository repository, PaymentProcessorFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    @Transactional
    public Payment createAndProcess(PaymentMethod method, BigDecimal amount) {
        Payment payment = new Payment(method, Money.brl(amount));
        repository.save(payment);

        Payment processed = factory.get(method).process(payment);
        return repository.save(processed);
    }

    @Transactional(readOnly = true)
    public Payment findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pagamento não encontrado: " + id));
    }

    @Transactional
    public Payment confirm(UUID id, String confirmationCode) {
        Payment payment = findById(id);
        Payment confirmed = factory.get(payment.getMethod()).confirm(payment, confirmationCode);
        return repository.save(confirmed);
    }
}
