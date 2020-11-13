package com.example.vo;

public class Test {

    public static void main(String[] args){
        System.out.println(febi(2));
        System.out.println(febi(6));
    }

    public static int feb(int n){
        if (n==1||n==0){
            return 1;
        }
        return feb(n-1)+feb(n-2);
    }
    public static int febi(int n){
        int sum=0;
        int a=1,b=1;
        if (n==1||n==0){
            return 1;
        }
        while(n-->=2){
            sum=a+b;
            a=b;
            b=sum;
        }
        return sum;
    }
}
