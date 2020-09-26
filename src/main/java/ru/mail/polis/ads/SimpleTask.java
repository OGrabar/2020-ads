package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;;
import java.util.StringTokenizer;

/**
 * Problem 1.
 */
public final class SimpleTask {

    static class Node {
        char data;
        Node leftChild;
        Node rightChild;

        public Node(char data, Node leftChild, Node rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    private SimpleTask() {
        // Should not be instantiated
    }

    /**
        output digits of two digit input number separated by space
     */
    private static void solve(final FastScanner in, final PrintWriter out) {
        int twoDigitNumber = in.nextInt();
        int firstDigit = twoDigitNumber / 10;
        int secondDigit = twoDigitNumber % 10;
        out.print(firstDigit + " " + secondDigit);
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
