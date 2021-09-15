package com.training.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.training.spring.employeep.Employee;

@ConditionalOnProperty(name = "intercept.enabled", havingValue = "true", matchIfMissing = false)
// @Profile("performance")
@Component
@Aspect
public class EmployeeAspect {

    @Before("execution(* com.training.spring.employeep.EmployeeOperation.*(..)) && args(emp)")
    public void beforeMethod(final JoinPoint jp,
                             final Employee emp) {
        System.out.println(jp + " Before method çalıştı : " + emp);
    }

    @After("execution(* com.training.spring.employeep.EmployeeOperation.*(..)) && args(emp)")
    public void afterMethod(final Employee emp) {
        System.out.println("After method çalıştı : " + emp);
    }

    @AfterReturning(value = "execution(* com.training.spring.employeep.EmployeeOperation.*(..)) && args(emp)",
                    returning = "ret")
    public void afterMethod(final Employee emp,
                            final String ret) {
        System.out.println("AfterReturning method çalıştı : " + ret);
    }

    @Around("execution(* com.training.spring.employeep.EmployeeOperation.*(..))")
    public Object afterMethod(final ProceedingJoinPoint pjp) {
        try {
            long delta = System.nanoTime();
            System.out.println("Kind : " + pjp.getKind());
            Signature signatureLoc = pjp.getSignature();
            System.out.println("Sign : " + pjp.getSignature());
            Object[] argsLoc = pjp.getArgs();
            Employee emp = (Employee) argsLoc[0];
            emp.setName("deneme");
            emp.setSurname("xyz");
            Object[] newargsLoc = new Object[1];
            newargsLoc[0] = emp;
            System.out.println("Employee Input : " + emp);
            Object proceedLoc = pjp.proceed(newargsLoc);
            System.out.println("Method Run Delta : " + (System.nanoTime() - delta));
            return proceedLoc + " intercepted.";
        } catch (Throwable eLoc) {
            eLoc.printStackTrace();
            return null;
        }
    }


    @Around("within(com.training.spring.employeep..*) && @annotation(logMe)")
    public Object logMeIntercept(final ProceedingJoinPoint pjp,
                                 final LogMe logMe) {
        try {
            System.out.println("----------------------------Log Intercept : "
                               + pjp.getSignature()
                               + " ---------------");
            ELogLevel valueLoc = logMe.value();
            switch (valueLoc) {
                case TRACE: {
                    Signature signatureLoc = pjp.getSignature();
                    System.out.println("Sign : " + signatureLoc);
                    Object[] argsLoc = pjp.getArgs();
                    System.out.println("Inputs : ");
                    for (Object objectLoc : argsLoc) {
                        System.out.println("Input : " + objectLoc);
                    }
                    Object proceedLoc = pjp.proceed();
                    return proceedLoc;
                }

                case DEBUG: {
                    long delta = System.nanoTime();
                    Object proceedLoc = pjp.proceed();
                    System.out.println("----------------------------Log Intercept : Method Run Delta : "
                                       + (System.nanoTime() - delta));
                    return proceedLoc;
                }
                case INFO: {
                    System.out.println("Kind : " + pjp.getKind());
                    Signature signatureLoc = pjp.getSignature();
                    System.out.println("Sign : " + pjp.getSignature());
                    Object proceedLoc = pjp.proceed();
                    return proceedLoc;
                }
                default:
                    return null;
            }
        } catch (Throwable eLoc) {
            eLoc.printStackTrace();
            return null;
        }
    }

}
