package Electricity.Billing.System.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Electricity.Billing.System.Model.Customer;
import Electricity.Billing.System.Repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;  // Remove static here

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));
    }
    
    // Update a customer's details
    public void updateCustomer(Long id, Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setPhone(updatedCustomer.getPhone());
            customerRepository.save(existingCustomer); // Save updated customer
        } else {
            throw new RuntimeException("Customer not found with ID: " + id);
        }
    }

    // Delete a customer by ID
    public void deleteCustomerById(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Customer not found with ID: " + id);
        }
    }
    
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer); // Save the customer in the database
    }

}
