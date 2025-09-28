package main.java.Queue.PriorityQueue;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements
        pq.add(30);
        pq.add(10);
        pq.add(20);
        pq.add(40);

        System.out.println("PriorityQueue (min-heap):");


        System.out.println("Peek: " + pq.peek());


        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
