package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * https://www.e-olymp.com/ru/problems/3737
 */
public final class IsHeap {
    private IsHeap() {
        // Should not be instantiated
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        n++;
        boolean isHeap = true;
        int[] a = new int[n];
        for (int i = 1; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 1; i < (n / 2) + 1; i++) {
            if (2 * i < n) {
                if (a[i] > a[2 * i]) {
                    isHeap = false;
                    break;
                }
            }
            if (2 * i + 1 < n) {
                if (a[i] > a[2 * i + 1]) {
                    isHeap = false;
                    break;
                }
            }
        }
        System.out.println(isHeap ? "YES" : "NO");
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