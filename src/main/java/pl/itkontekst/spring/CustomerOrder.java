package pl.itkontekst.spring;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Wojciech Oczkowski on 2019-06-14.
 */
@Entity
@Table(name = "orders")
public class CustomerOrder {
    @Id
    private Long id;
    private String description;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
