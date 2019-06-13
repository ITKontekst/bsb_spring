package pl.itkontekst.spring;

import org.junit.Test;
import org.springframework.util.ReflectionUtils;

import static org.junit.Assert.*;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
public class OrdersServiceTest {

    @Test
    public void testDoSomething() throws Exception {
        CustomerService customerService = new CustomerService();
        OrdersService ordersService = new OrdersService(customerService);
        ordersService.doSomething();
    }

    @Test
    public void testDoSomethingElse() throws Exception {

    }
}