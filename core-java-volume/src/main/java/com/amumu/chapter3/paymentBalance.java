package com.amumu.chapter3;

public class paymentBalance {
    public static void main(String[] args){

    }

    class balanceCompare{
        int goal;
        int balance;
        int payment;

        public balanceCompare(int goal,int balance,int payment){

            while (balance<goal){
                balance += payment;

            }
        }

    }
}
