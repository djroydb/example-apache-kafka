package br.com.robson.paymentservice.service;

import br.com.robson.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);

}
