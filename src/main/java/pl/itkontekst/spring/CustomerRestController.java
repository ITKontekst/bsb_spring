package pl.itkontekst.spring;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Wojciech Oczkowski on 2019-06-15.
 */
@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.findAll();
    }
    @GetMapping("/search")
    public List<Customer> searchCustomers( @RequestParam CustomerFilter customerFilter){
        return customerService.findAll();
    }


    @GetMapping(value = "/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.findById(id);
    }

    @PutMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        if(customer.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(customerService.save(customer));
    }

}
