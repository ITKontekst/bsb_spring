package pl.itkontekst.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Wojciech Oczkowski on 2019-06-15.
 */
@Component
public class MyService {

    @Autowired
    MyService myService;

    @Loguj
    public void doSth(){
        int a = 1231;
        //fdsfsfs

    }

    @Loguj
    public void doSthElse(){
        System.out.println("isEqual: " + (this == myService)  );
        System.out.println("isEqual: " + (this == myService)  );
        myService.doSth();
//        doSth();
    }
}
