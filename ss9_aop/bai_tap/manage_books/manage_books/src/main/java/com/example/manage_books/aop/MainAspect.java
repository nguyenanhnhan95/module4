package com.example.manage_books.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MainAspect {
    private String statusBook;
    private long numberPeopleVisit=0;

    @Pointcut("within(com.example.manage_books.controller.*)")
    public void countNumberPeopleVisitServer(){}
    @Before("countNumberPeopleVisitServer()")
    public void beforeCountNumberPeopleVisitServer(JoinPoint joinPoint){
       this.numberPeopleVisit++;
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("Count"+this.numberPeopleVisit);
    }
}
