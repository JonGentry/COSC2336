/*
  Jonathan Gentry
  COSC 2336-48F
  Instructor: Dr. Doerschuk
  Programming Assignment 7
  Due: 10/21/2020
  Submitted: 10/21/2020
  Programming language: Java JDK 14
  Implement methods contains(E e) , get(int index) , indexOf(E e) , lastIndexOf(E e) , and set(int index, E e).
  Test the implementations with MyLinkedListAugmented.java stored under Resources.
 */
package Main.Java.ClassWork.ImplementingListsStacksQueuesPriorityQueues.Assignment;

import java.util.*;

public class MyLinkedListAugmentedJonathanGentry {
    public static void main(String[] args) {
        String[] names = {"Mike", "Jim", "Alice", "George", "Stevie",
                "Cheryl", "George", "Jane", "Ella", "Jenny", "Kathy", "Jane"};
        MyList<String> list = new MyLinkedList<>(names);

        System.out.println("Original list: ");
        System.out.println(list);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name = input.next();

        System.out.print("Enter an index at which to store this name: ");
        int index = input.nextInt();

        list.add(index, name);

        System.out.println("revised list: ");
        System.out.println(list);
        System.out.print("List contains "+name + ": ");
        System.out.println(list.contains(name)); //Method implemented at line 216
        System.out.print("Item at index 3: ");
        System.out.println(list.get(3)); //Method implemented at line 228
        System.out.print("Index of George: ");
        System.out.println(list.indexOf("George")); //Method implemented at line 240
        System.out.print("Last index of George: ");
        System.out.println(list.lastIndexOf("George")); //Method implemented at line 253

    }
}

class MyLinkedList<E> implements MyList<E> {
    protected Node<E> head, tail;
    protected int size = 0; // Number of elements in the list

    /** Create an empty list */
    public MyLinkedList() {
    }

    /** Create a list from an array of objects */
    public MyLinkedList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    /** Return the head element in the list */
    public E getFirst() {
        if (size == 0) {
            return null;
        }
        else {
            return head.element;
        }
    }

    /** Return the last element in the list */
    public E getLast() {
        if (size == 0) {
            return null;
        }
        else {
            return tail.element;
        }
    }

    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size

        if (tail == null) // the new node is the only node in list
            tail = head;
    }

    /** Add an element to the end of the list */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e); // Create a new for element e

        if (tail == null) {
            head = tail = newNode; // The new node is the only node in list
        }
        else {
            tail.next = newNode; // Link the new with the last node
            tail = newNode; // tail now points to the last node
        }

        size++; // Increase size
    }

    @Override /** Add a new element at the specified index
     * in this list. The index of the head element is 0 */
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        }
        else if (index >= size) {
            addLast(e);
        }
        else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }

    /** Remove the head node and
     *  return the object that is contained in the removed node. */
    public E removeFirst() {
        if (size == 0) {
            return null;
        }
        else {
            E temp = head.element;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp;
        }
    }

    /** Remove the last node and
     * return the object that is contained in the removed node. */
    public E removeLast() {
        if (size == 0) {
            return null;
        }
        else if (size == 1) {
            E temp = head.element;
            head = tail = null;
            size = 0;
            return temp;
        }
        else {
            Node<E> current = head;

            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }

            E temp = tail.element;
            tail = current;
            tail.next = null;
            size--;
            return temp;
        }
    }

    @Override /** Remove the element at the specified position in this
     *  list. Return the element that was removed from the list. */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        else if (index == 0) {
            return removeFirst();
        }
        else if (index == size - 1) {
            return removeLast();
        }
        else {
            Node<E> previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    @Override /** Override toString() to return elements in the list */
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            }
            else {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }

    @Override /** Clear the list */
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override /** Return true if this list contains the element e */
    public boolean contains(Object o) {

        Node current = head;
        for (int i = 0; i < size; i++)        {
            if (current.element.equals(o))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override /** Return the element at the specified index */
    public E get(int index) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (i == index)
                return (E) current.element;
            current = current.next;
        }
        return null;
    }

    @Override /** Return the index of the first matching element in
     *  this list. Return -1 if no match. */
    public int indexOf(Object o) {

        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(o))
                return i;
            current = current.next;
        }
        return -1;
    }

    @Override /** Return the index of the last matching element in
     *  this list. Return -1 if no match. */
    public int lastIndexOf(Object o) {
        int index = -1;

        Node current = head;
        for (int i = 0; i < size; i++) {
            // overwrite the index by elements which come later in the list
            if (current.element.equals(o))
                index = i;

            current = current.next;
        }
        return index;
    }

    @Override /** Replace the element at the specified position
     *  in this list with the specified element. */
    public E set(int index, E e) {
        E elementToReturn = null;
        Node current = head;

        for (int i = 0; i < size; i++) {
            if (i == index) {
                elementToReturn = (E) current.element;
                current.element = e;
                return elementToReturn;
            }
            current = current.next;
        }
        return null;
    }

    @Override /** Override iterator() defined in Iterable */
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator
            implements java.util.Iterator<E> {
        private Node<E> current = head; // Current index

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        @Override
        public void remove() {
            // Left as an exercise
        }
    }

    protected static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    @Override /** Return the number of elements in this list */
    public int size() {
        return size;
    }
}

interface MyList<E> extends java.util.Collection<E> {
    /** Add a new element at the specified index in this list */
    public void add(int index, E e);

    /** Return the element from this list at the specified index */
    public E get(int index);

    /** Return the index of the first matching element in this list.
     *  Return -1 if no match. */
    public int indexOf(Object e);

    /** Return the index of the last matching element in this list
     *  Return -1 if no match. */
    public int lastIndexOf(E e);

    /** Remove the element at the specified position in this list
     *  Shift any subsequent elements to the left.
     *  Return the element that was removed from the list. */
    public E remove(int index);

    /** Replace the element at the specified position in this list
     *  with the specified element and returns the new set. */
    public E set(int index, E e);

    @Override /** Add a new element at the end of this list */
    public default boolean add(E e) {
        add(size(), e);
        return true;
    }

    @Override /** Return true if this list contains no elements */
    public default boolean isEmpty() {
        return size() == 0;
    }

    @Override /** Remove the first occurrence of the element e
     *  from this list. Shift any subsequent elements to the left.
     *  Return true if the element is removed. */
    public default boolean remove(Object e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        }
        else
            return false;
    }

    @Override
    public default boolean containsAll(Collection<?> c) {
        // Left as an exercise
        return true;
    }

    @Override
    public default boolean addAll(Collection<? extends E> c) {
        // Left as an exercise
        return true;
    }

    @Override
    public default boolean removeAll(Collection<?> c) {
        // Left as an exercise
        return true;
    }

    @Override
    public default boolean retainAll(Collection<?> c) {
        // Left as an exercise
        return true;
    }

    @Override
    public default Object[] toArray() {
        // Left as an exercise
        return null;
    }

    @Override
    public default <T> T[] toArray(T[] array) {
        // Left as an exercise
        return null;
    }
}
