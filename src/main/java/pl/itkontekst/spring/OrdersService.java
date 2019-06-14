package pl.itkontekst.spring;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
//@Service
public class OrdersService {

    private CustomerService customerService;

    @Value("${myservicename}")
    private String serviceName;

    @Value("${dbconfig}")
    private MyDBConfig myDBConfig;


    public OrdersService( ) {
        System.out.println();
    }


    @PreDestroy
    public void destroy(){
        System.out.println("###################################destroy dbconfig: " + myDBConfig );
    }

    @Autowired
    @Qualifier("HA")
    public void setCustomerService(CustomerService customerService) {
        System.out.println("setCustomerService");
        this.customerService = customerService;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void doSomething(){
    }
    public void doSomethingElse(){
        System.out.println("else");
    }
}

