package desafio.dio.api.corepatterns.facade;

import java.math.BigDecimal;

public class FacadeDemo {
    public static void main(String[] args) {
        PaymentFacade facade = new PaymentFacade();

        System.out.println("Pagamento 1: " + facade.pay(new BigDecimal("199.90")));
        System.out.println("Pagamento 2: " + facade.pay(new BigDecimal("8000.00")));
    }
}
