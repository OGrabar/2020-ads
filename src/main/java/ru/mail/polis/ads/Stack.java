package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Problem 6124.
 */
public final class Stack {

    List<Integer> stackHandler = new ArrayList<>();

    private Stack() {
    }

    /**
     * @param n add n to the end
     */
    public void push(int n) {
        stackHandler.add(n);
    }

    /**
     * @return last element. Don't remove it
     */
    public int back() {
        return stackHandler.get(stackHandler.size() - 1);
    }

    /**
     * @return last element and remove it
     */
    public int pop() {
        return  stackHandler.remove(stackHandler.size() - 1);
    }

    /**
     * @return the size of the stack
     */
    public int size() {
        return stackHandler.size();
    }

    /**
     * Make queue clear again
     */
    public void clear() {
        stackHandler.clear();
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        Stack stack = new Stack();
        String[] inputCommand;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            inputCommand = scanner.nextLine().split(" ");
            if (inputCommand.length == 2) {
                stack.push(Integer.parseInt(inputCommand[1]));
                System.out.println("ok");
                continue;
            }

            switch (inputCommand[0]) {
                case "size":
                    System.out.println(stack.size());
                    break;
                case "pop":
                    System.out.println(stack.size() == 0 ? "error" : stack.pop());
                    break;
                case "back":
                    System.out.println(stack.size() == 0 ? "error" : stack.back());
                    break;
                case "clear":
                    stack.clear();
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
