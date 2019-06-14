package pl.itkontekst.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.config.TaskExecutorFactoryBean;
import pl.itkontekst.spring.editors.MyDBConfigEditor;

import java.beans.PropertyEditor;
import java.util.HashMap;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
@Configuration
@PropertySource("classpath:app.properties")
@EnableAsync
public class Config {

    @Bean(name = "custService1")
//    @Qualifier("HA")
    @Primary
    public CustomerService getCustomerService()
    {
        return new CustomerService();
    }
    @Bean(name = "custService2")
    static public CustomerService getCustomerService2()
    {
        return new CustomerService();
    }

    @Bean
    static public CustomEditorConfigurer customEditorConfigurer(){
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        HashMap<Class<?>, Class<? extends PropertyEditor>> editorsMap = new HashMap<Class<?>, Class<? extends  PropertyEditor>>();
        editorsMap.put(MyDBConfig.class, MyDBConfigEditor.class);
        customEditorConfigurer.setCustomEditors(editorsMap);
        return  customEditorConfigurer;
    }

    @Bean
    public TaskExecutorFactoryBean taskExecutor(){
        return new TaskExecutorFactoryBean();
    }


}
