package Electricity.Billing.System.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Electricity.Billing.System.Model.Bill;
import Electricity.Billing.System.Model.Customer;
import Electricity.Billing.System.Service.BillService;
import Electricity.Billing.System.Service.CustomerService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BillService billService;

    @GetMapping("/customers")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }
//
//    @PostMapping("/add-customer")
//    public String addCustomer(Customer customer) {
//        customerService.addCustomer(customer);
//        return "redirect:/admin/customers";
//    }


    @PostMapping("/generate-bill")
    public String generateBill(@RequestParam Long customerId, @RequestParam Integer unitsConsumed) {
        Customer customer = customerService.getCustomerById(customerId);  // Corrected line
        Bill bill = new Bill();
        bill.setCustomer(customer);
        bill.setUnitsConsumed(unitsConsumed);
        bill.setBillingDate(LocalDate.now());
        bill.setDueDate(LocalDate.now().plusDays(15));
        bill.setAmountDue(unitsConsumed * 5.0);
        billService.generateBill(bill);
        return "redirect:/admin/customers";
    }
    
 // PUT Mapping for updating customer
    @PutMapping("/update-customer/{id}")
    public String updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        customerService.updateCustomer(id, updatedCustomer);
        return "redirect:/admin/customers"; // Redirect after update
    }

    // DELETE Mapping for deleting customer
    @DeleteMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        return "redirect:/admin/customers"; // Redirect after delete
    } 
    
    @GetMapping("/add-customer")
    public String showAddCustomerForm() {
        return "add-customer"; // Renders add-customer.html
    }

    @PostMapping("/add-customer")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer); // Save the customer
        return "redirect:/customer-list"; // Redirect to the customer list page
    }

//    
//    @PostMapping("/generate-bill")
//    public String generateBill(@RequestParam Long customerId, @RequestParam Integer unitsConsumed, Model model) {
//        // Generate bill logic
//        return "redirect:/admin/bill-details"; // Redirect to the page showing the generated bill
//    }
//    
    @GetMapping("/customer-list")
    public String viewCustomerList(Model model) {
        List<Customer> customers = customerService.getAllCustomers(); // Fetch customers from the database
        model.addAttribute("customers", customers); // Add customers to the model
        return "customer-list"; // Return the customer list view
    }



}
