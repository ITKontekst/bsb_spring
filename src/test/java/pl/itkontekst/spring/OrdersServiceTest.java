package pl.itkontekst.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ReflectionUtils;

import static org.junit.Assert.*;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/beans.xml")
public class OrdersServiceTest {

    @Autowired
    private OrdersService ordersService;

    @Test
    public void contextLoads() throws Exception {
    }

    @Test
    public void doSomethingTest() throws Exception {
        ordersService.doSomething();
    }

}