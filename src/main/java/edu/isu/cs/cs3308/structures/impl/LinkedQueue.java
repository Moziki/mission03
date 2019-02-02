package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Queue;
import edu.isu.cs.cs3308.structures.Stack;

public class LinkedQueue<E> implements Queue<E> {

    DoublyLinkedList<E> data;

    public LinkedQueue() {data = new DoublyLinkedList<>();}

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void offer(E element) {
        data.addLast(element);
    }

    public E peek() {
        return data.first();
    }

    public E poll() {
        return data.removeFirst();
    }

    public void printQueue() {
        data.printList();
    }

    public void transfer(Queue<E> into) {
        if (into == null){}
        else {
            LinkedStack<E> reverse = new LinkedStack<>();
            int thisQueue = this.size();
            int paramQueue = into.size();
            if (this.size() == 0) {
            } else {
                for (int i = 0; i < thisQueue; i++) {
                    reverse.push(this.poll());
                }
                if (paramQueue != 0) {
                    for (int i = 0; i < paramQueue; i++) {
                        this.offer(into.poll());
                    }
                }
                int stac = reverse.size();
                for (int i = 0; i < stac; i++) {
                    into.offer(reverse.pop());
                }
                if (paramQueue != 0) {
                    for (int i = 0; i < thisQueue; i++) {
                        into.offer(this.poll());
                    }
                }
            }
        }
    }

    public void reverse() {
        LinkedStack<E> reverse = new LinkedStack<>();
        while (!(this.isEmpty())) {
            reverse.push(this.poll());
        }
        while (!reverse.isEmpty()) {
            this.offer(reverse.pop());
        }
    }

    public void merge(Queue<E> from) {
        if (from == null) {}
        else {
            int index = from.size();
            LinkedStack<E> temp = new LinkedStack<>();
            for (int i = 0; i < index; i++) {
                temp.push(from.poll());
                this.offer(temp.peek());
                from.offer(temp.pop());
            }
        }
    }
}
