package pl.itkontekst.spring;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
//@Service
public class OrdersService {

    @PersistenceContext
    private EntityManager entityManager;


    private OrdersDAO ordersDAO;

    private CustomerService customerService;

    @Value("${myservicename}")
    private String serviceName;

    @Value("${dbconfig}")
    private MyDBConfig myDBConfig;

    @Autowired
    private ApplicationEventPublisher publisher;

    public OrdersService(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }

    public List<CustomerOrder> getAllOrders(){
        Page<CustomerOrder> page = ordersDAO.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "description")));
        return page.stream().collect(Collectors.<CustomerOrder>toList());
//        return entityManager.createQuery("SELECT co FROM CustomerOrder co").getResultList();
    }
    public List<CustomerOrder> findByDescription(String description){
        return ordersDAO.findByDescription(description);
//        return entityManager.createQuery("SELECT co FROM CustomerOrder co").getResultList();
    }

    @EventListener({ContextClosedEvent.class, ContextStartedEvent.class})
    public void incommingEvent(ApplicationContextEvent event){

        System.out.println("event Listener" + event);
    }

    @EventListener()
//    @Async
    public void incommingBussinesEvent(BussinesEvent event){

        System.out.println("bussines event Listener" + event);
//        try {
//            Thread.sleep(10000l);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("bussines event Listener2" + event);

    }

    @PreDestroy
    public void destroy(){
        System.out.println("###################################destroy dbconfig: " + myDBConfig );
    }

    @Autowired
//    @Qualifier("HA")
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

        BussinesEvent bussinesEvent = new BussinesEvent(this);
        System.out.println("before publish");
        publisher.publishEvent(bussinesEvent);
        System.out.println("after publish");
    }
    public void doSomethingElse(){
        System.out.println("else");
    }


}

