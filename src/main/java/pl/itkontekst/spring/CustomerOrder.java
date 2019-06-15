package pl.itkontekst.spring;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Wojciech Oczkowski on 2019-06-15.
 */
@Entity
public class CustomerOrder {
    @Id
    private Long id;
    private String desc;
    @ManyToOne
    private Customer customer;

    public CustomerOrder() {
    }

    public CustomerOrder(Long id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
