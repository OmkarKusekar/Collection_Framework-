package main.java.Queue.ArrayDeque;

import java.util.ArrayDeque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // Using as a queue (FIFO)
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);

        System.out.println("Queue front: " + deque.peekFirst());

        int first = deque.removeFirst();
        System.out.println("Dequeued: " + first);


        deque.addFirst(40);
        deque.addFirst(50);

        System.out.println("Stack top: " + deque.peekFirst());

        int top = deque.removeFirst();
        System.out.println("Popped: " + top);


        System.out.println("Remaining elements: " + deque);
    }
}
