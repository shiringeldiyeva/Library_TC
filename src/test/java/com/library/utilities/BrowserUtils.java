package com.library.utilities;

public class BrowserUtils {
    public static void sleep(int second) throws InterruptedException {
        second*=1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){
            System.out.println("Something happened in sleep method");
        }
    }
}
