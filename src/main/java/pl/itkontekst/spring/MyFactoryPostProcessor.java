package pl.itkontekst.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
@Component
public class MyFactoryPostProcessor implements BeanFactoryPostProcessor{
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Iterator<String> beanNamesIterator = configurableListableBeanFactory.getBeanNamesIterator();
        while( beanNamesIterator.hasNext()){
            System.out.println("bean>>>>"+ beanNamesIterator.next());
        }
    }
}
