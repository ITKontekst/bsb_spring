package pl.itkontekst.spring;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
//@Component
//    @Repository
//    @Service("custService2")
//    @Lazy
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    @Controller
//    @RestController
public class CustomerService {
    public CustomerService() {
        System.out.println("CustomerService() constr");
    }
}
