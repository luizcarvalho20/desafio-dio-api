package desafio.dio.api.payments.service.factory;

import desafio.dio.api.payments.domain.exception.BusinessException;
import desafio.dio.api.payments.domain.model.PaymentMethod;
import desafio.dio.api.payments.service.processor.PaymentProcessor;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class PaymentProcessorFactory {

    private final Map<PaymentMethod, PaymentProcessor> processors = new EnumMap<>(PaymentMethod.class);

    public PaymentProcessorFactory(List<PaymentProcessor> processorList) {
        for (PaymentProcessor processor : processorList) {
            PaymentMethod key = processor.supports();
            if (key == null) {
                throw new IllegalStateException("Processor " + processor.getClass().getSimpleName() + " retornou supports() = null");
            }
            processors.put(key, processor);
        }
    }

    public PaymentProcessor get(PaymentMethod method) {
        PaymentProcessor processor = processors.get(method);
        if (processor == null) {
            throw new BusinessException("Método de pagamento não suportado: " + method);
        }
        return processor;
    }

    public Object getProcessor(PaymentMethod pix) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProcessor'");
    }
}
