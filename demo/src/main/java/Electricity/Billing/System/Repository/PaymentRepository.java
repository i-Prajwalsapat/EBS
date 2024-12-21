package Electricity.Billing.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Electricity.Billing.System.Model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}

