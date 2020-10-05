package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Problem 1462.
 */
public final class TrickySort {

    private TrickySort() {
        // Should not be instantiated
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        Comparator<Integer> trickyComparator =
                (first, second) -> first % 10 < second % 10 ? -1 :
                        (first % 10 == second % 10 ? first.compareTo(second) : 1);

        int n = in.nextInt();
        List<Integer> numbers = new ArrayList<>();
        int number;
        for (int i = 0; i < n; i++) {
            number = in.nextInt();
            numbers.add(number);
        }
        numbers.sort(trickyComparator);
        for (Integer num : numbers) {
            System.out.print(num + " ");
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