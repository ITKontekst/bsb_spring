package pl.itkontekst.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
@Configuration

public class Config {

//    @Bean(name = "custService3")
//    public CustomerService getCustomerService3(){
//        return new CustomerService();
//    }

    @Bean(name = "ordersService2")
    public OrdersService getOrdersService() {
        return new OrdersService(
                getCustomerService());
    }

    @Bean(name = "custService")
    public CustomerService getCustomerService()
    {
        return new CustomerService();
    }

}
