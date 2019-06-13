package pl.itkontekst.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
@Configuration
public class Config {

//    @Bean(name = "custService3")
//    public CustomerService getCustomerService3(){
//        return new CustomerService();
//    }

//    @Bean(name = "ordersService")
//    public OrdersService getOrdersService(CustomerService customerService) {
//        OrdersService ordersService = new OrdersService(
//        );
//        ordersService.setCustomerService(customerService);
//        return ordersService;
//    }

//    @Bean(name = "custService")
//    @Profile({"dev"})
//    public CustomerService getCustomerService()
//    {
//        return new CustomerService();
//    }
    @Bean(name = "custService1")
    public CustomerService getCustomerService()
    {
        return new CustomerService();
    }
    @Bean(name = "custService2")
    public CustomerService getCustomerService2()
    {
        return new CustomerService();
    }

}
