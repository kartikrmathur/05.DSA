package Importrant;

import java.util.Scanner;

// Income tax calculator

public class ElseIf {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int income = sc.nextInt(); 
        int tax;  
    if (income < 500000) {
        System.out.println("tax = 0");
        
    }
    else if (income >=500000 && income < 100000) {
        System.out.println(" tax = 20%");
        
    }
    else{
        System.out.println(" tax is 30%");
    }
    }
}
// simple