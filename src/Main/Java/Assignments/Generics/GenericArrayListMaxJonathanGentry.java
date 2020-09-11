/*
  Jonathan Gentry
  COSC 2336-48F
  Instructor: Dr. Doerschuk
  Programming Assignment 2
  Due: 9/9/2020
  Submitted: 9/9/2020
  Programming language: Java JDK 14
  This is a program to test the max() generic method for an Integer and String ArrayList and
  return the largest element.
 */

package Main.Java.Assignments.Generics;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericArrayListMaxJonathanGentry {

    /**
     Class name: main
     Jonathan Gentry
     External packages: java.util.Scanner
     Package: Main.Java.Assignments.Recursion
     Main method is used to create create and add user input to ArrayLists
     and to test the max() method
     */
    public static void main(String[] args) {

        // Create an Integer and String ArrayList to later use in max method
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<String> stringList = new ArrayList<>();

        // Create Scanner object to get input from console to enter into ArrayLists
        Scanner scan = new Scanner(System.in);

        // int variable used to start while loop and later hold user input for intList
        int intInput = 1;

        // While loop to get user integer input and check for stop condition
        while (intInput != 0) {
            System.out.println("Enter an integer to add to a list of integers, 0 to stop: ");
            intInput = scan.nextInt();
            intList.add(intInput);
        }

        System.out.println("The largest integer in the array is " + max(intList));

        // Had to google why the string statement was doubling in console,
        // adding scan.nextLine() was the only fix I found
        scan.nextLine();

        // String variable used to start while loop and later hold user input for stringList
        String stringInput = "";

        // While loop to get user string input and check for stop condition
        while (!stringInput.equalsIgnoreCase("done")) {
            System.out.println("Enter a string to add to a list of strings, \"done\" to stop: ");
            stringInput = scan.nextLine();
            stringList.add(stringInput);
        }

        System.out.println("The largest string in the array is " + max(stringList));
    }

    /**
     * Method name: max
     * Purpose: Find largest element of ArrayList
     * Pre Condition: ArrayList
     * Post Condition: ArrayList element
     * Return Condition: Largest element
     * Parameters: ArrayList
     * Use a generic method that can take any type of arraylist and return the
     * largest value.
     */
    public static <E extends Comparable<E>> E max(ArrayList<E> list) {

        // Set current max to the first element of array
        E currentMax = list.get(0);

        // Loop through all elements and update max variable if array element is greater than current
        for(int i = 1; i < list.size(); i++)
            if(list.get(i).compareTo(currentMax) > 0)
                currentMax = list.get(i);
        return currentMax;
    }
}
