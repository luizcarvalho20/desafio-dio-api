package desafio.dio.api.corepatterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CardDiscount implements DiscountStrategy {
    @Override
    public BigDecimal apply(BigDecimal amount) {
        // 2% de desconto no cartão
        return amount.multiply(new BigDecimal("0.98")).setScale(2, RoundingMode.HALF_UP);
    }
}
