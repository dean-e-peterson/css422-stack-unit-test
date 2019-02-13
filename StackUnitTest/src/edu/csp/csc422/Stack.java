/*
 * Concordia CSC422, week 5, Stack class unit testing assignment
 * by Dean Peterson (petersod8@csp.edu)
 * 2019-02-13
 */
package edu.csp.csc422;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {
    private static final int DEFAULT_CAPACITY = 20;
    private int capacity;
    private List<E> list;
    
    public Stack() {
        this(DEFAULT_CAPACITY);
    }
    
    public Stack(int capacity) {
        // Note, using ArrayList even for fixed-size stack to allow generics.
        list = new ArrayList<E>(capacity);
        // Remember intended capacity, so we can check against it.
        this.capacity = capacity;
    }
    
    public E pop() {
        if (list.size() == 0) {
            throw new EmptyStackException("Attempting to pop from empty stack.");
        }
        return list.remove(list.size() - 1);
    }
    
    public E push(E item) {
        if (list.size() >= capacity) {
            throw new FullStackException("Attempting to exceed stack capacity of " + capacity + ".");
        }
        list.add(item);
        // Not sure why we are returning item in push, but it was specified.
        return item;
    }
    
    public E peek() {
        if (list.size() == 0) {
            throw new EmptyStackException("Attempting to peek in empty stack.");
        }
        return list.get(list.size() - 1);
    }
    
    public boolean empty() {
        return list.size() == 0;
    }
    
}

class EmptyStackException extends RuntimeException {
    public EmptyStackException(String message) {
        super(message);
    }
}

class FullStackException extends RuntimeException {
    public FullStackException(String message) {
        super(message);
    }    
}
