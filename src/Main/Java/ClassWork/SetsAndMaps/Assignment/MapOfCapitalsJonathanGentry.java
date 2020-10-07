/*
  Jonathan Gentry
  COSC 2336-48F
  Instructor: Dr. Doerschuk
  Programming Assignment 4
  Due: 9/30/2020
  Submitted: 9/29/2020
  Programming language: Java JDK 14
  This is a program prompt the user to enter a state and it returns the capital.
 */
package Main.Java.ClassWork.SetsAndMaps.Assignment;

import java.util.*;

/**
 Class name: MapOfCapitalsJonathanGentry
 Name: Jonathan Gentry
 External packages: java.util.Scanner
 Package: Main.Java.ClassWork.SetsAndMaps.Assignment
 Main method is used to create a scanner and ask the user for a State, then to get the Capital from the map statesAndCapitals.
 */
public class MapOfCapitalsJonathanGentry {
    /** Main Method */
    public static void main(String[] args) {
        // Create a scanner object to hold console input
        Scanner scan = new Scanner(System.in);

        // Create a map and store 50 states and their capitals through method getStatesAndCapitals()
        Map<String, String> statesAndCapitals = getStatesAndCapitals();

        // Prompt the user to enter a state
        System.out.print("Enter a state, or \"done\" when finished: ");
        String state = scan.nextLine();

        // Loop until the user is done with the program
        while (!state.equalsIgnoreCase("done")) {
            // Display the capital for the state
            if (statesAndCapitals.get(state) != null) {
                System.out.println("The capital is " + statesAndCapitals.get(state));
            } else // If wrong input, then print error to console
                System.out.println("No such state.");

            // Prompt the user to enter a state and loop back to get the answer
            System.out.print("Enter a state, or \"done\" when finished: ");
            state = scan.nextLine();
        }
    }

    /**
     Method name: getStatesAndCapitals()
     Purpose: Stores the 50 states and their capitals in a map
     Pre Conditions: Map<String, String>
     Post Condition: Map with States and Capitals stored
     Return condition: map
     Parameters: none
     The method creates a HashMap and String array, then stores the States and Capitals in the String array and then
     puts the string array in the HashMap and returns the map.
     */
    public static Map<String, String> getStatesAndCapitals() {

        // Create a HashMap to store States and Capitals
        Map<String, String> map = new HashMap<>();

        // String array to store and tie the States and Capitals
        String[][] statesAndCapitalArray = {
                {"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"},
                {"Connecticut", "Hartford"},
                {"Delaware", "Dover"},
                {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"},
                {"Hawaii", "Honolulu"},
                {"Idaho", "Boise"},
                {"Illinois", "Springfield"},
                {"Indiana", "Indianapolis"},
                {"Iowa Des", "Moines"},
                {"Kansas", "Topeka"},
                {"Kentucky","Frankfort"},
                {"Louisiana", "Baton Rouge"},
                {"Maine", "Augusta"},
                {"Maryland", "Annapolis"},
                {"Massachusetts", "Boston"},
                {"Michigan", "Lansing"},
                {"Minnesota", "Saint Paul"},
                {"Mississippi", "Jackson"},
                {"Missouri", "Jefferson City"},
                {"Montana", "Helena"},
                {"Nebraska", "Lincoln"},
                {"Nevada	", "Carson City"},
                {"New Hampshire", "Concord"},
                {"New Jersey", "Trenton"},
                {"New Mexico", "Santa Fe"},
                {"New York", "Albany"},
                {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismarck"},
                {"Ohio", "Columbus"},
                {"Oklahoma", "Oklahoma City"},
                {"Oregon", "Salem"},
                {"Pennsylvania", "Harrisburg"},
                {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"},
                {"Texas", "Austin"},
                {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"},
                {"Washington", "Olympia"},
                {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}};

        // Loop through the array to store States and Capitals in the map
        for (int i = 0; i < statesAndCapitalArray.length; i++) {
            map.put(statesAndCapitalArray[i][0], statesAndCapitalArray[i][1]);
        }

        return map;
    }
}
