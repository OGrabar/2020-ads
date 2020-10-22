package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * https://www.e-olymp.com/ru/problems/9016
 */
public final class BinarySearch {
    private BinarySearch() {
        // Should not be instantiated
    }

    private static boolean isInArray(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == value) {
                return true;
            }
            if (array[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int q = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        for (int i = 0; i < q; i++) {
            int k = in.nextInt();
            System.out.println(isInArray(numbers, k) ? "YES" : "NO");
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