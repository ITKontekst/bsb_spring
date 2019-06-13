import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import pl.itkontekst.spring.Config;
import pl.itkontekst.spring.CustomerService;
import pl.itkontekst.spring.MyFactoryPostProcessor;
import pl.itkontekst.spring.OrdersService;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("/beans.xml");


        OrdersService ordersService = applicationContext.getBean("orderServiceXML",OrdersService.class);
        System.out.println("ordersService:  " + ordersService.getCustomerService());
        ordersService.doSomething();

    }
}
