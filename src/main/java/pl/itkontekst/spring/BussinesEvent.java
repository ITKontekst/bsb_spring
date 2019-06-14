package pl.itkontekst.spring;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Wojciech Oczkowski on 2019-06-14.
 */
public class BussinesEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public BussinesEvent(Object source) {
        super(source);
    }
}
