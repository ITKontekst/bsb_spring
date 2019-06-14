package pl.itkontekst.spring;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Wojciech Oczkowski on 2019-06-14.
 */
@ContextConfiguration(locations = "/beans.xml")
//@ActiveProfiles("dev")
//@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CustomerServiceTest {
    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();
    @Rule
    public final SpringMethodRule SPRING_METHOD_RULE = new SpringMethodRule();

    @Autowired
    private CustomerService customerService;

    @Test
    @Sql(scripts = "/insert.sql")
    public void customerServiceTest() {

        List<Customer> allCustomers = customerService.getAllCustomers();
        assertEquals(1, allCustomers.size());
    }
    @Test
    @Sql(scripts = "/insert.sql")
    public void findByLastNameAndFirstName() {

        Customer customer = customerService.findByLastNameAndFirstName("Kowalski","Jan");
        assertNotNull(customer);
    }

}