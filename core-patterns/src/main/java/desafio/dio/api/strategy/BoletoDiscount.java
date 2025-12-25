package desafio.dio.api.corepatterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BoletoDiscount implements DiscountStrategy {
    @Override
    public BigDecimal apply(BigDecimal amount) {
        // 3% de desconto no boleto
        return amount.multiply(new BigDecimal("0.97")).setScale(2, RoundingMode.HALF_UP);
    }
}
