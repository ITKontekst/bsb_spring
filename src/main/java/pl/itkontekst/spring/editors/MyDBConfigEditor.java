package pl.itkontekst.spring.editors;

import org.springframework.stereotype.Component;
import pl.itkontekst.spring.MyDBConfig;

import java.beans.PropertyEditorSupport;

/**
 * Created by Wojciech Oczkowski on 2019-06-14.
 */
@Component
public class MyDBConfigEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String s) throws IllegalArgumentException {
        String[] conf = s.split("\\|");
        MyDBConfig myDBConfig = new MyDBConfig(conf[0], conf[1], conf[2], conf[3]);
        setValue(myDBConfig);
    }
}
