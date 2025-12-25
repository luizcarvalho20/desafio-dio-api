package desafio.dio.api.corepatterns.strategy;

import java.math.BigDecimal;

public class StrategyDemo {
    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal("199.90");

        Checkout checkout = new Checkout(new PixDiscount());
        System.out.println("PIX:     " + checkout.finalAmount(amount));

        checkout.setDiscountStrategy(new CardDiscount());
        System.out.println("CARD:    " + checkout.finalAmount(amount));

        checkout.setDiscountStrategy(new BoletoDiscount());
        System.out.println("BOLETO:  " + checkout.finalAmount(amount));
    }
}
