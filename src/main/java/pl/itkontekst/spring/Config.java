package pl.itkontekst.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
@Configuration
@PropertySource("classpath:app.properties")
public class Config {



    @Bean(name = "custService1")
//    @Qualifier("HA")
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
