package pl.itkontekst.spring;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Wojciech Oczkowski on 2019-06-15.
 */
@Service
public class CustomerService {

    private RestCustomerRepo customerRepository;
    private OrdersRepository ordersRepository;

    public CustomerService(RestCustomerRepo customerRepository, OrdersRepository ordersRepository) {
        this.customerRepository = customerRepository;
        this.ordersRepository = ordersRepository;
    }

    @PostConstruct
    public void init(){
        Customer customer = new Customer(1l, "Jan", "Kowalski");
        CustomerOrder order = new CustomerOrder(1l, "cos");
        ordersRepository.save(order);
        customer.setOrders(Arrays.asList(order));
        order.setCustomer(customer);
        customerRepository.save(customer);
        ordersRepository.save(order);
    }


    public void doSthOnCustomer(){
        Customer customer = new Customer(1l, "Jan", "Kowalski");
        customerRepository.save(customer);
        Optional<Customer> customerOptional = customerRepository.findById(1l);
        Customer customer1 = customerOptional.get();
        customer1.setFirstName("Marek");
    }

    public Customer findById(Long id){
        return customerRepository.findById(id).get();
    }

    @Secured("ROLE_ADMIN")
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
