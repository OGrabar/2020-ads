package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Problem 6125.
 */
public final class Queue {

    Node head;
    Node tail;
    int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    /**
     * @param n add n to the tail of Queue
     */
    public void push(int n) {
        Node newTail = new Node(n);
        if (size == 0) {
            this.head = newTail;
            size++;
            return;
        }

        if (size == 1) {
            this.tail = newTail;
            this.head.next = tail;
            size++;
            return;
        }


        this.tail.next = newTail;
        this.tail = newTail;
        size++;
    }

    /**
     * @return first element. Don't remove it
     */
    public int front() {
        return head.data;
    }

    /**
     * @return first element and remove it
     */
    public int pop() {
        int firstElement = head.data;
        head = head.next;
        size--;
        return firstElement;
    }

    /**
     * @return the size of the Queue
     */
    public int size() {
        return size;
    }

    /**
     * Make queue clear again
     */
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        Queue queue = new Queue();
        String[] inputCommand;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            inputCommand = scanner.nextLine().split(" ");
            //System.out.println(inputCommand.length);
            if (inputCommand.length == 2) {
                queue.push(Integer.parseInt(inputCommand[1]));
                System.out.println("ok");
                continue;
            }

            switch (inputCommand[0]) {
                case "size":
                    System.out.println(queue.size());
                    break;
                case "pop":
                    System.out.println(queue.pop());
                    break;
                case "front":
                    System.out.println(queue.front());
                    break;
                case "clear":
                    queue.clear();
                    System.out.println("ok");
                    break;
                default:
                    break;
            }

            if (inputCommand[0].equals("exit")) {
                System.out.println("bye");
                break;
            }
        }

    }

    private static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(final String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}
