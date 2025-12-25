package desafio.dio.api.corepatterns.strategy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Context: usa uma Strategy para calcular o valor final.
 */
public class Checkout {

    private DiscountStrategy discountStrategy;

    public Checkout(DiscountStrategy discountStrategy) {
        this.discountStrategy = Objects.requireNonNull(discountStrategy);
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = Objects.requireNonNull(discountStrategy);
    }

    public BigDecimal finalAmount(BigDecimal amount) {
        Objects.requireNonNull(amount);
        return discountStrategy.apply(amount);
    }
}
