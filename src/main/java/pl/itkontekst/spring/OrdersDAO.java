package pl.itkontekst.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Wojciech Oczkowski on 2019-06-14.
 */
public interface OrdersDAO extends JpaRepository<CustomerOrder,Long> {

    public List<CustomerOrder>findByDescription(String description);
    public List<CustomerOrder>findByDescriptionAndId(String description,Long id);


}
