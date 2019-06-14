package pl.itkontekst.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.config.TaskExecutorFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.itkontekst.spring.editors.MyDBConfigEditor;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyEditor;
import java.util.HashMap;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
@Configuration
@PropertySource("classpath:app.properties")
//@EnableAsync
@EnableJpaRepositories
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

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){

        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public TaskExecutorFactoryBean taskExecutor(){
        return new TaskExecutorFactoryBean();
    }

}
