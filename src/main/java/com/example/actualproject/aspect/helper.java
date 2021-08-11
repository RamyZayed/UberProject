package com.example.actualproject.aspect;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;


@Aspect
@Component
@EnableAspectJAutoProxy
public class helper {

    static final  Logger LOGGER = LoggerFactory.getLogger(helper.class);

    @Around("@annotation(com.example.actualproject.aspect.Timer) ")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(joinPoint.getSignature() +"   Executed In :"+ executionTime+"ms");
        return proceed;
    }


    @Around("execution(* com.example.actualproject.service.*.*(..))")
    public Object logging(ProceedingJoinPoint pp) throws  Throwable {
        ObjectMapper objectMapper = new ObjectMapper();

        Object[] array = pp.getArgs(); //input when converted to string
        String methodName = pp.getSignature().getName();
        String className = pp.getTarget().getClass().toString();

        LOGGER.info("Method invoked :"+className +" : "+methodName+"()arguments : "+objectMapper.writeValueAsString(array));


        Object object=null;
        try {
            object = pp.proceed();

        }catch(NoSuchElementException e)
        {
            LOGGER.error("no such element is found");
        }
        finally {


            LOGGER.info("Returned value"+objectMapper.writeValueAsString(object));
            return object;
        }
    }


}
