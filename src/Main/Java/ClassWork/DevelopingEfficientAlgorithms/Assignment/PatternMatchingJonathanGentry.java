/*
  Jonathan Gentry
  COSC 2336-48F
  Instructor: Dr. Doerschuk
  Programming Assignment 5
  Due: 10/7/2020
  Submitted: 10/7/2020
  Programming language: Java JDK 14
  This is a program prompt the user to enter two strings and tests whether the second
  string is a substring of the first string.
 */
package Main.Java.ClassWork.DevelopingEfficientAlgorithms.Assignment;

import java.util.*;

/**
 Class name: PatternMatchingJonathanGentry
 Name: Jonathan Gentry
 External packages: java.util.*
 Package: Main.Java.ClassWork.DevelopingEfficientAlgorithms.Assignment
 Main method is used to create a scanner and ask the user for two strings, then tests if the second string
 is a substring of the first string
 */
public class PatternMatchingJonathanGentry {

    public static void main(String[] args) {

        // Create Scanner object to get input from console
        Scanner scan = new Scanner(System.in);

        // Prompt the user to enter two strings and store in s1 and s2 String variables
        System.out.print("Enter a string s1: ");
        String s1 = scan.nextLine();
        System.out.print("Enter a string s2: ");
        String s2 = scan.nextLine();

        // Create int to store the index of s2 if a substring of s1
        int index = -1;
        // Create int to count through the s2 string index matches
        int count = 0;

        // Lopp through s1 length to test whether the second string is a substring of the first string
        for (int i = 0; i < s1.length(); i++) {
            // If statement to check if s1 index matches first letter of s2
            if (s1.charAt(i) == s2.charAt(0) && count == 0) {
                // Update index and increase count
                index = i;
                count++;
            }
            // Check if the following letters of s2 matches the following s1 substring after updated index variable
            else if (s1.charAt(i) == s2.charAt(count)) {
                count++;
            }
            // Else reset int variables due to missed match
            else {
                count = 0;
                index = -1;
            }

            // If statement to check if the length of count reaches s2 length to be able to break the loop
            if (count == s2.length())
                break;
        }

        // After loop completes, check if index is greater than 1 and display the results
        if (index > 1)
            System.out.println("matched at index " + index);
        else
            System.out.println("unmatched");
    }
}
