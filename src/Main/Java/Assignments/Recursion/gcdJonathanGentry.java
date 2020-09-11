/*
  Jonathan Gentry
  COSC 2336-48F
  Instructor: Dr. Doerschuk
  Programming Assignment 1
  Due: 9/9/2020
  Submitted: 9/8/2020
  Programming language: Java JDK 14
  This is a program to test and compute the greatest common divisor while using
  a recursive method.
 */
package Main.Java.Assignments.Recursion;

import java.util.Scanner;

public class gcdJonathanGentry {

    /**
     Class name: main
     Jonathan Gentry
     External packages: java.util.Scanner
     Package: Main.Java.Assignments.Recursion
     Main method is used to create a scanner object to test the gcd() method
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Variable to get input from console

        System.out.println("Enter first number: ");
        int firstNumber = input.nextInt(); // Variable to store the first int

        System.out.println("Enter second number: ");
        int secondNumber = input.nextInt(); // Variable to store the second int

        System.out.println("The GDC of " + firstNumber + " and " + secondNumber + " is " + gcd(firstNumber, secondNumber));

        input.close();
    }

    /**
     Method name: gdc
     Purpose: Compute greatest common divisor
     Pre Conditions: Two ints
     Post Condition: One int
     Return condition: Greatest remainder not equal to 0
     Parameters: First input number and Second input number
     If there is a remainder then recall the method,
     flipping the second number to first and setting the new second number to be the remainder.
     */
    static int gcd(int first, int second){
        if(first % second == 0)
            return second;
        else
            return gcd(second, first % second);
    }
}


