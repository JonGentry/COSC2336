/*
  Jonathan Gentry
  COSC 2336-48F
  Instructor: Dr. Doerschuk
  Programming Assignment 6
  Due: 10/14/2020, Extension to 10/16/2020 accepted by Dr. Doerschuk
  Submitted: 10/16/2020
  Programming language: Java JDK 14
  Revise the Heap class in Listing 23.9 to implement a min-heap and test with code from assignment word doc.
  Changes to Listing 23.9: Class name refactor from Heap to MinHeap, and operator changes at lines 66, 95, 101
 */

package Main.Java.ClassWork.Sorting.Assignment;

/**
 Class name: MinHeapJonathanGentry
 Name: Jonathan Gentry
 External packages: N/A
 Package: Main.Java.ClassWork.Sorting.Assignment
 Main method is used to test the MinHeap class with code from the given assignment, Tests an Integer and String list.
 */
public class MinHeapJonathanGentry {

    public static void main(String[] args) {

        /** test with Integers */
        Integer[]myIntegers={8, 9, 2, 3, 4, 1, 5, 6, 7};
        System.out.println("Unsorted Integers in the array: ");
        for (int i = 0; i <myIntegers.length; i++)
            System.out.print(myIntegers[i] + " ");
        System.out.println();
        MinHeap<Integer> heap = new MinHeap<Integer>(myIntegers);
        System.out.println("Sorted Integers: ");
        while (heap.getSize() > 0)
            System.out.print(heap.remove() + " ");
        System.out.println();

        /** test with Strings */
        String[]myStrings = {"Computer " , "Science ", "Rocks "};
        System.out.println("Unsorted Strings in the array: ");
        for (int i = 0; i <myStrings.length; i++)
            System.out.print(myStrings[i]);
        System.out.println();
        System.out.println("Sorted Strings: ");
        MinHeap<String> stringHeap = new MinHeap<String>(myStrings);
        while (stringHeap.getSize() > 0)
            System.out.print(stringHeap.remove());
    }

}

/**
 Class name: MinHeap
 Name: Jonathan Gentry
 External packages: N/A
 Package: Main.Java.ClassWork.Sorting.Assignment
 MinHeap method is a Heap sort that uses a binary heap.
 First it adds all the elements to a heap and then removes the smallest elements successively to obtain a sorted list.
 */
class MinHeap<E extends Comparable<E>> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    /** Create a default heap */
    public MinHeap() {
    }

    /** Create a heap from an array of objects */
    public MinHeap(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    /** Add a new object into the heap */
    public void add(E newObject) {
        list.add(newObject); // Append to the heap
        int currentIndex = list.size() - 1; // The index of the last node

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            // Swap if the current object is less than its parent
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) < 0) { //CHANGED > to < from the Heap class
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            }
            else
                break; // the tree is a heap now

            currentIndex = parentIndex;
        }
    }

    /** Remove the root from the heap */
    public E remove() {
        if (list.size() == 0) return null;

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the maximum between two children
            if (leftChildIndex >= list.size()) break; // The tree is a heap
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) > 0) { //CHANGED < to > from the Heap class
                    maxIndex = rightChildIndex;
                }
            }

            // Swap if the current node is more than the maximum
            if (list.get(currentIndex).compareTo(list.get(maxIndex)) > 0) { //CHANGED < to > from the Heap class
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            }
            else
                break; // The tree is a heap
        }

        return removedObject;
    }

    /** Get the number of nodes in the tree */
    public int getSize() {
        return list.size();
    }

    /** Return true if heap is empty */
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
