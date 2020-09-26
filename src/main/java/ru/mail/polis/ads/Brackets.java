package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Problem 5327.
 */
public final class Brackets {

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

    private Brackets() {
        // Should not be instantiated
    }

    /**
     * output is "YES" if input bracket sequence is correct, otherwise output is "NO".
     * input bracket sequence should contain only round brackets or output will be incorrect
     */
    private static void solve(final FastScanner in, final PrintWriter out) {
        char[] bracketSequence = in.next().toCharArray();

        if (bracketSequence.length == 0) {
            out.print("YES");
            return;
        }

        int bracketWithoutPair = 0;
        for (char bracket : bracketSequence) {
            bracketWithoutPair += bracket == '(' ? 1 : -1;
            if (bracketWithoutPair < 0) { break; }
        }
        String result = bracketWithoutPair == 0 ? "YES" : "NO";
        out.print(result);
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
