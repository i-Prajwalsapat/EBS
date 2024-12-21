package Electricity.Billing.System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Electricity.Billing.System.Model.Payment;
import Electricity.Billing.System.Service.BillService;
import Electricity.Billing.System.Service.PaymentService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private BillService billService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/bills/{id}")
    public String getBills(@PathVariable Long id, Model model) {
        model.addAttribute("bills", billService.getBillsByCustomer(id));
        return "customer-bills";
    }

    @PostMapping("/pay-bill")
    public String payBill(Payment payment) {
        paymentService.payBill(payment);
        return "redirect:/customer/bills/" + payment.getBill().getCustomer().getId();
    }
}
