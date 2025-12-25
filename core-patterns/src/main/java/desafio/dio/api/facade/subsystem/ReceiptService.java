package desafio.dio.api.facade.subsystem;

public class ReceiptService {

    public void send(String paymentId, String message) {
        System.out.println("[receipt] paymentId=" + paymentId + " | " + message);
    }
}
