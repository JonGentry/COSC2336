package Main.Java.ClassWork.Recursion.CH18;

import java.io.File;
import java.util.Scanner;

//Recursion
public class CH18 {
    public static void main(String[] args){
    }

    public void copy(Scanner in) {
        if (in.hasNext()) {
            System.out.println(in.next());
            copy(in);
        }
    }

    int add(Scanner input) {
        int sum = input.nextInt();
        if (input.hasNextInt()) {
            sum = sum + add(input);
        }
        return sum;
    }


    void printTriangle(int n){
        if(n==0)
            return;
        System.out.println(makeStars(n));
        printTriangle(n-1);
    }

    String printTriangle1(int n) {
        if(n <= 0)
            return "";
        else {
            String p = printTriangle1(n - 1);
            p = p + "*";
            System.out.println(p);
            return p;
        }
    }


    String makeStars(int numberOfStars){
        if (numberOfStars == 0)
            return "";
        else
            return "*" + makeStars(numberOfStars - 1);
    }

    String makeLine(int numberOfColons, char character){
        if (numberOfColons == 0)
            return "";
        else
            return character + makeLine(numberOfColons - 1, character);
    }
/* Main recursion without helper
    boolean isPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1)
            return true;
        if(s.charAt(0) == s.charAt(s.length()-1))
            return isPalindrome(s.substring(1, s.length()-1));

        return false;
    }
*/
    public static boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    private static boolean isPalindrome(String s, int low, int high) {
        if (high <= low) // Base case
            return true;
        else if (s.charAt(low) != s.charAt(high)) // Base case
            return false;
        else
            return isPalindrome(s, low + 1, high - 1);
    }

    void clear(int[] array, int length) {
        if (length == 0)
            return;

        array[length-1] = 0;

        clear(array, length-1);
    }

    int sum(int[] array, int length){
        if(length == 0)
            return 0;
        else
            return array[length - 1] + sum(array, length -1);
    }

    public static void sort(double[] list) {
        sort(list, 0, list.length - 1); // Sort the entire list
    }

    private static void sort(double[] list, int low, int high) {
        if (low < high) {
            // Find the smallest number and its index in list(low .. high)
            int indexOfMin = low;
            double min = list[low];
            for (int i = low + 1; i <= high; i++) {
                if (list[i] < min) {
                    min = list[i];
                    indexOfMin = i;
                }
            }

            // Swap the smallest in list(low .. high) with list(low)
            list[indexOfMin] = list[low];
            list[low] = min;

            // Sort the remaining list(low+1 .. high)
            sort(list, low + 1, high);
        }
    }

    public static long getSize(File file) {
        long size = 0; // Store the total size of all files

        if (file.isDirectory()) {
            File[] files = file.listFiles(); // All files and subdirectories
            for (int i = 0; files != null && i < files.length; i++) {
                size += getSize(files[i]); // Recursive call
            }
        }
        else { // Base case
            size += file.length();
        }

        return size;
    }

    /** The method for finding the solution to move n disks
     from fromTower to toTower with auxTower */
    public static void moveDisks(int n, char fromTower,
                                 char toTower, char auxTower) {
        if (n == 1) // Stopping condition
            System.out.println("Move disk " + n + " from " +
                    fromTower + " to " + toTower);
        else {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            System.out.println("Move disk " + n + " from " +
                    fromTower + " to " + toTower);
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }

    // Tail recursion
    /** Return the factorial for a specified number */
    public static long factorial(int n) {
        return factorial(n, 1); // Call auxiliary method
    }

    /** Auxiliary tail-recursive method for factorial */
    private static long factorial(int n, int result) {
        if (n == 0)
            return result;
        else
            return factorial(n - 1, n * result); // Recursive call
    }
}
