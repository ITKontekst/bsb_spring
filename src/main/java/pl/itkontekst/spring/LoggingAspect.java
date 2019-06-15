package pl.itkontekst.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Wojciech Oczkowski on 2019-06-15.
 */
@Aspect
@Component
public class LoggingAspect {

//    @Before()
//    @After()
//    @Around("bean(*)")
//    @Around("execution(* pl.itkontekst..*.*(..))")

    @Pointcut("@annotation(pl.itkontekst.spring.Loguj)")
    public void logujAnnotation(){}

    @Around("logujAnnotation()")
    public Object loguj(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("start metody:" +jp.getSignature());
        Object result;
        try {
            result = jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }
        System.out.println("stop metody:" +jp.getSignature());
        return result;
    }

}
