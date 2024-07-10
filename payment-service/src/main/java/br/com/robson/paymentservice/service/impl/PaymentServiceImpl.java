package br.com.robson.paymentservice.service.impl;

import br.com.robson.paymentservice.model.Payment;
import br.com.robson.paymentservice.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public void sendPayment(Payment payment) {
        log.info("PAYMENT_SERVICE_IMPL ::: Recebi o Pagamento {}", payment);
    }
}
