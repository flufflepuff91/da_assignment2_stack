/*
 * Project: Assignment 2 Datastructures and Algorithms Stack
 * Author:  Anonym
 * Last Change:01.01.2022
 */

package com.da.datastructures;

/**
 * <code>MyStack</code> implements the data structure stack for elements of type <code>Double</code>.
 */
public class MyStack {
    JList jList = new JList();

    /**
     * Adds an element to the stack by making it the new top element.
     *
     * @param value new top value
     */
    public void push(Double value) {
        jList.addJElement(value);
    }

    /**
     * Removes the top element of the stack and return it's value.
     *
     * @return top value or <code>null</code> if the stack is empty
     */
    public Double pop() {
        return jList.removeJElement();
    }

    /**
     * Returns a string representation of this stack. The string representation consists of a list of the stack's
     * elements from top element down to the bottom separated by whitespaces and ending with <code>\n</code>.
     *
     * @return a string representation of this stack.
     */
    public String toString() {
        return jList.printJList();
    }
}

class JList {
    private JListElement lastElem;

    public JList() {
        this.lastElem = null;
    }

    public void addJElement(Double value) {
        if (lastElem == null) {
            lastElem = new JListElement(value, null);
        } else {
            JListElement oldLastElem = lastElem;
            lastElem = new JListElement(value, oldLastElem);
        }
    }

    public Double removeJElement() {
        if (lastElem == null) {
            return null;
        } else {
            JListElement remElem = lastElem;
            lastElem = remElem.prevElem;
            return remElem.value;
        }
    }

    public String printJList() {
        String s = "";
        JListElement currElem = lastElem;
        while (true) {
            if (currElem == null) {
                return s + "\n";
            } else {
                s = s + currElem.value + " ";
                currElem = currElem.prevElem;
            }
        }
    }
}

class JListElement {
    Double value;
    JListElement prevElem;

    public JListElement(Double value, JListElement prevElem) {
        this.value = value;
        this.prevElem = prevElem;
    }
}
