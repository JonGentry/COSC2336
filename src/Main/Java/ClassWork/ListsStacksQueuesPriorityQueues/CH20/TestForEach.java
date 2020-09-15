package Main.Java.ClassWork.ListsStacksQueuesPriorityQueues.CH20;

import java.util.*;

public class TestForEach {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("New York");
        collection.add("Atlanta");
        collection.add("Dallas");
        collection.add("Madison");

        collection.forEach(e -> System.out.print(e.toUpperCase() + " "));
    }
    /*
    collection.forEach(new java.util.function.Consumer<String>() {
        public void accept(String e) {
            System.out.print(e.toUpperCase() + " ");
        }
    });
     */
}