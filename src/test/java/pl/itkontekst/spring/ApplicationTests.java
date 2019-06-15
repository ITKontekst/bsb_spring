package pl.itkontekst.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	MyService myService;
	@Autowired
	CustomerService customerService;

	@Test
	public void contextLoads() {
		myService.doSthElse();
	}

	@Test
	public void customerService() {
		customerService.doSthOnCustomer();
	}

}
