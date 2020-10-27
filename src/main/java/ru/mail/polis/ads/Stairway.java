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
public final class Stairway {

    private Stairway() {
        // Should not be instantiated
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int[] numbers = new int[n + 2];
        numbers[0] = 0;
        numbers[n + 1] = 0;
        for (int i = 1; i < n + 1; i++) {
            numbers[i] = in.nextInt();
        }
        int maxStep = in.nextInt();
        int[] maxSums = new int[n + 2];
        for (int i = 1; i < n + 2; i++) {
            int maxSum = Integer.MIN_VALUE;
            for (int j = Math.max(0, i - maxStep); j < i; j++) {
                maxSum = Math.max(maxSums[j], maxSum);
            }
            maxSums[i] += numbers[i] + maxSum;
        }
        System.out.println(maxSums[n + 1]);
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
