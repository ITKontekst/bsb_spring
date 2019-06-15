package pl.itkontekst.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Wojciech Oczkowski on 2019-06-15.
 */
@RepositoryRestResource(path = "customers2")
public interface RestCustomerRepo extends JpaRepository<Customer,Long> {
}
