package pl.itkontekst.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.config.TaskExecutorFactoryBean;
import pl.itkontekst.spring.editors.MyDBConfigEditor;

import javax.sql.DataSource;
import java.beans.PropertyEditor;
import java.util.HashMap;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
@Configuration
@PropertySource("classpath:app.properties")
//@EnableAsync
public class Config {

    @Bean(name = "custService1")
//    @Qualifier("HA")
    @Primary
    public CustomerService getCustomerService(DataSource ds)
    {
        return new CustomerService(jdbcTemplate(ds),ds);
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
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource){

        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        return entityManagerFactoryBean;
    }


    @Bean
    public TaskExecutorFactoryBean taskExecutor(){
        return new TaskExecutorFactoryBean();
    }


}
