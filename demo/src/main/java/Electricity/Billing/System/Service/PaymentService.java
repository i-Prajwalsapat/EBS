package Electricity.Billing.System.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Electricity.Billing.System.Model.Payment;
import Electricity.Billing.System.Repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment payBill(Payment payment) {
        payment.setPaymentDate(LocalDate.now());
        payment.setStatus("Paid");
        return paymentRepository.save(payment);
    }
}
