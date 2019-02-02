package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Stack;

public class LinkedStack<E> implements Stack<E> {

    //The underlying data structure
    DoublyLinkedList<E> data;

    //CONSTRUCTOR
    //creates a new DoublyLinkedList as the data variable
    public LinkedStack() { data = new DoublyLinkedList<>(); }

    @Override
    public void push(E element) { this.data.addFirst(element); }

    @Override
    public E peek() {
        return this.data.get(0);
    }

    @Override
    public E pop() { return this.data.removeFirst(); }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void transfer(Stack<E> to){
        if (this.isEmpty()) {}
        else if (to == null){}
        else {
            int loopControl = this.size();
            for (int i = 0; i < loopControl; i++) {
                to.push(this.pop());
            }
        }
    }

    //Reverses order of nodes in stack
    // First: pops all nodes to a temp stack (order reversed)
    // Second: pops all nodes to a second temp stack (original order)
    // Finally: pops all nodes to the original stack (order reversed)
    @Override
    public void reverse() {
        LinkedStack<E> temp = new LinkedStack();
        LinkedStack<E> temp2 = new LinkedStack();
        int loopControl = this.size();
        for (int i = 0; i < loopControl; i++) {
            temp.push(this.pop());
        }
        for (int i = 0; i < loopControl; i++) {
            temp2.push(temp.pop());
        }
        for (int i = 0; i < loopControl; i++) {
            this.push(temp2.pop());
        }

    }
    //Adds the provided stack to the bottom of the stack the method is called on
    //@param other - the stack that will be added to the bottom of the called on stack
    @Override
    public void merge(Stack<E> other) {
        if (this.isEmpty() || other == null) {}
        else {
            LinkedStack<E> temp = new LinkedStack();
            LinkedStack<E> temp2 = new LinkedStack();

            //paramSize & thisSize -to make sure method still works if stacks are
            //different sizes
            int paramSize = other.size();
            int thisSize = this.size();
            //moves nodes of called on stack to temp stack
            for (int i = 0; i < thisSize; i++){
                temp.push(this.pop());
            }
            //moves nodes of param stack to temp2 stack (to ensure original order is kept when added)
            for (int i = 0; i < paramSize; i++) {
                temp2.push(other.pop());
            }
            //First: Called on stack pushes node from temp2 without removing
            //Second: param stack pushes node from temp 2 (Pop: removes the element from temp2)
            for (int i = 0; i < paramSize; i++) {
                this.push(temp2.peek());
                other.push(temp2.pop());
            }
            //puts the original elements from called on stack back on top
            for (int i = 0; i < thisSize; i++) {
                this.push(temp.pop());
            }
        }




    }

    @Override
    public void printStack() {
        data.printList();
    }


}

