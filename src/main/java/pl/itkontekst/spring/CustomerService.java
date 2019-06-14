package pl.itkontekst.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Wojciech Oczkowski on 2019-06-13.
 */
//@Component
//    @Repository
//    @Service("custService2")
//    @Lazy
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    @Controller
//    @RestController
@Qualifier("HA")
@Component
public class CustomerService {

    private NamedParameterJdbcTemplate jdbcTemplate;

    private DataSource dataSource;

    public CustomerService(NamedParameterJdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    public List<Customer> getAllCustomers(){
        return jdbcTemplate.query("SELECT * FROM customers",new CustomerRowMapper());
    }

    public Customer findByLastNameAndFirstName(String lastName, String firstName){
        QueryByFirstNameAndLastName command = new QueryByFirstNameAndLastName(dataSource);
        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("lastName",lastName);
        parameters.put("firstName",firstName);
        return command.findObjectByNamedParam(parameters);
    }

    static class CustomerRowMapper implements RowMapper<Customer>{

        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            Customer customer = new Customer();
            customer.firstName = resultSet.getString("first_name");
            customer.lastName = resultSet.getString("last_name");
            return customer;
        }
    }

    static class QueryByFirstNameAndLastName extends MappingSqlQuery<Customer>{

        private RowMapper<Customer> rowMapper = new CustomerRowMapper();

        public QueryByFirstNameAndLastName(DataSource ds) {
            super(ds,"SELECT * FROM customers where last_name=:lastName AND first_name = :firstName");
            declareParameter(new SqlParameter("firstName", Types.VARCHAR));
            declareParameter(new SqlParameter("lastName", Types.VARCHAR));
        }

        @Override
        protected Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rowMapper.mapRow(rs,rowNum);
        }
    }
}
