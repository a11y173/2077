package com.amumu.chapter3;

import java.util.Scanner;

public class Retirement {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        System.out.println("挣够多少钱就可以退休了？");
        double goal = in.nextDouble();

        System.out.println("一年可以挣多少钱呢？");
        double payment = in.nextDouble();

        System.out.println("银行的利息一年是多少呢？");
        double interestRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        while (balance< goal){
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            // sum += i 代表 sum = sum + i
            // ++ 代表将 i 的值先使用再加 1 赋值给 i 变量本身
            years++;
        }
        System.out.println("您预计在"+ years +"年后退休！");
    }
}
