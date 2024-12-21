package Electricity.Billing.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Electricity.Billing.System.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
