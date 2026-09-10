// package com.college;

class MyMain {
    int a = 0 ;
    static int b;
    static {
        b = b + 10;
    }
    static class ChotaMain{
        static void print(){
            System.out.println(b);
            // `a` is an instance field — cannot access from static context
            // System.out.println(a);
        }
    }

    public static void main(java.lang.String[] args) {
        System.out.println("I am Main");
        System.out.println(MyMain.b);
    }
}
