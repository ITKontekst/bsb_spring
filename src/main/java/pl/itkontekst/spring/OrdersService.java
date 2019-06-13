package pl.itkontekst.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
@Service
public class OrdersService {

    private CustomerService[] customerService;

    public OrdersService() {
    }

    public OrdersService(CustomerService customerService) {
        this.customerService = new CustomerService[]{customerService};
    }
    @Autowired
    public OrdersService(CustomerService[] customerService) {
        this.customerService = customerService;
    }

    public void doSomething(){
        customerService.toString();
    }
    public void doSomethingElse(){
        System.out.println("else");
    }

}
