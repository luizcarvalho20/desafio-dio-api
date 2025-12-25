package desafio.dio.api.corepatterns.strategy;

import java.math.BigDecimal;

/**
 * Strategy: define uma família de algoritmos (desconto) e permite variar em tempo de execução.
 */
@FunctionalInterface
public interface DiscountStrategy {
    BigDecimal apply(BigDecimal amount);
}
