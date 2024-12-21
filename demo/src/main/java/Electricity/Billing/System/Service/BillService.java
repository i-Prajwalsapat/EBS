package Electricity.Billing.System.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Electricity.Billing.System.Model.Bill;
import Electricity.Billing.System.Repository.BillRepository;

@Service
public class BillService {
    @Autowired
    private BillRepository billRepository;

    public Bill generateBill(Bill bill) {
        bill.setBillingDate(LocalDate.now());
        bill.setDueDate(LocalDate.now().plusDays(15));
        return billRepository.save(bill);
    }

    public List<Bill> getBillsByCustomer(Long customerId) {
        return billRepository.findByCustomerId(customerId);  // Assuming you have a method in BillRepository for this
    }

}

