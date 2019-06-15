package pl.itkontekst.spring;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Wojciech Oczkowski on 2019-06-15.
 */
public interface OrdersRepository extends JpaRepository<CustomerOrder,Long> {
}
