package pl.itkontekst.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
@Service
public class OrdersService {

    private CustomerService customerService;

    private List<Object> serviceNames;

    public OrdersService() {
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        System.out.println("setCustomerService");
        this.customerService = customerService;
    }

    public void setServiceNames(List<Object> serviceNames) {
        this.serviceNames = serviceNames;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void doSomething(){
        System.out.println(serviceNames.toString() + " " + customerService.toString());
    }
    public void doSomethingElse(){
        System.out.println("else");
    }

}
