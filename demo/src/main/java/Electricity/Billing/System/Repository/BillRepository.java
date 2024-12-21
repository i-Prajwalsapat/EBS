package Electricity.Billing.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Electricity.Billing.System.Model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
public List<Bill> findByCustomerId(Long customerId);
}