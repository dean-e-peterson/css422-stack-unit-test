/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csp.csc422;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StackNGTest {
    
    public StackNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of default constructor of class Stack.
     */
    @Test
    public void testStackDefault() {
        System.out.println("Stack()");
        Stack stack = new Stack();
        fillStackToDefaultCapacity(stack);
    }

    /**
     * Test of max limit of constructor of class Stack with default capacity.
     */
    @Test(expectedExceptions = FullStackException.class)
    public void testStackOver() {
        System.out.println("Stack() max test");        
        Stack stack = new Stack();
        fillStackToDefaultCapacity(stack);        
        stack.push("oneTooMany");
    }
    
    /**
     * Test of constructor of class Stack that takes a capacity.
     */
    @Test
    public void testStackCapacity() {
        System.out.println("Stack(capacity)");        
        Stack stack = new Stack(3);
        stack.push("1");
        stack.push("2");
        stack.push("3");
    }
    
    /**
     * Test of max limit of constructor of class Stack that takes a capacity.
     */
    @Test(expectedExceptions = FullStackException.class)
    public void testStackCapacityOver() {
        System.out.println("Stack(capacity) max test");        
        Stack stack = new Stack(3);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
    }
    
    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        Stack stack = new Stack(2);
        stack.push("1");
        stack.push("2");
        assertEquals("2", stack.pop());
        stack.push("TwoAgain");
        assertEquals("TwoAgain", stack.pop());
        assertEquals("1", stack.pop());
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Stack stack = new Stack(2);
        assertEquals("1", stack.push("1"));
        assertEquals("2", stack.push("2"));
        stack.pop();
        assertEquals("TwoAgain", stack.push("TwoAgain"));
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        Stack stack = new Stack(2);
        stack.push("1");
        assertEquals("1", stack.peek());
        stack.push("2");
        assertEquals("2", stack.peek());
        stack.pop();
        assertEquals("1", stack.peek());
        stack.push("TwoAgain");
        assertEquals("TwoAgain", stack.peek());
    }

    /**
     * Test of empty method, of class Stack.
     */
    @Test
    public void testEmpty() {
        System.out.println("empty");
        Stack stack = new Stack(2);
        assertTrue(stack.empty());
        stack.push("1");
        assertFalse(stack.empty());
        stack.pop();
        assertTrue(stack.empty());
        stack.push("OneAgain");
        assertFalse(stack.empty());        
        stack.push("TwoAgain");
        assertFalse(stack.empty());
        stack.pop();
        // Ensure .empty() doesn't always return true after a pop();
        assertFalse(stack.empty());
        stack.pop();
        assertTrue(stack.empty());
    }

    /**
     * Utility method for filling stack to its default capacity
     * @param stack Stack to fill, should start out empty.
     */
    private void fillStackToDefaultCapacity(Stack stack) {
        // Default capacity is 20.
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        stack.push("10");
        stack.push("11");
        stack.push("12");
        stack.push("13");
        stack.push("14");
        stack.push("15");
        stack.push("16");
        stack.push("17");
        stack.push("18");
        stack.push("19");
        stack.push("20");
    }    
}
