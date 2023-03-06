package org.example.common;

public class LogAdvice {
    public void printLogging(){
        // AOP포인트 컷으로 검색된 기능에 추가되는 기능
        System.out.println(">>> printLogging(): 호출,,,");
    }
    public void afterLogging(){
        System.out.println(">>> afterLogging(): 호출,,,");
    }
}
