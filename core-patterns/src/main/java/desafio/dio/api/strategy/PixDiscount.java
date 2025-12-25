package desafio.dio.api.corepatterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PixDiscount implements DiscountStrategy {
    @Override
    public BigDecimal apply(BigDecimal amount) {
        // 5% de desconto no PIX
        return amount.multiply(new BigDecimal("0.95")).setScale(2, RoundingMode.HALF_UP);
    }
}
