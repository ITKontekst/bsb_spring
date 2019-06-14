package pl.itkontekst.spring;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/beans.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OrdersServiceTest {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersDAO ordersDAO;

    @Test
    @Sql(scripts = "/insertOrders.sql")
    public void testGetAllOrders() throws Exception {
        List<CustomerOrder> orders = ordersService.getAllOrders();
        assertEquals(1, orders.size());
    }

    @Test
    @Sql(scripts = "/insertOrders.sql")
    public void testFindByDescription() throws Exception {
        List<CustomerOrder> orders = ordersService.findByDescription("Książka");
        assertEquals(1, orders.size());
    }
}