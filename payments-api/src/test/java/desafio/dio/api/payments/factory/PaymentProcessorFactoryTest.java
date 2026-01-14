package desafio.dio.api.payments.factory;

import desafio.dio.api.payments.service.processor.impl.PixPaymentProcessor;
import desafio.dio.api.payments.service.processor.impl.CardPaymentProcessor;
import desafio.dio.api.payments.domain.model.PaymentMethod;
import desafio.dio.api.payments.service.factory.PaymentProcessorFactory; // Verifique se o factory está nesta pasta service.factory
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class PaymentProcessorFactoryTest {

    @Autowired
    private PaymentProcessorFactory factory;

    @Test
    void deveRetornarPixProcessor() {
        var processor = factory.getProcessor(PaymentMethod.PIX);
        assertTrue(processor instanceof PixPaymentProcessor);
    }

    private void assertTrue(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
    }

    @Test
    void deveRetornarCardProcessor() {
        var processor = factory.getProcessor(PaymentMethod.CARD);
        assertTrue(processor instanceof CardPaymentProcessor);
    }
}