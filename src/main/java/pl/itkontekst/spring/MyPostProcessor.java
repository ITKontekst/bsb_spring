package pl.itkontekst.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
@Component
public class MyPostProcessor implements BeanPostProcessor {

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization");
        if(bean instanceof OrdersService){
            OrdersService service = ((OrdersService)bean);
            if(service.getServiceName() == null){
                System.out.println("ustawiam default");
                service.setServiceName(beanName);
            }
        }
        return bean;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
