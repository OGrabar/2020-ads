package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;;
import java.util.StringTokenizer;

/**
 * https://www.e-olymp.com/ru/problems/15
 */
public final class Mouse {

    private Mouse() {
        // Should not be instantiated
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int floor[][] = new int[n][m];
        int seeds[][] = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                floor[i][j] = in.nextInt();
            }
        }

        seeds[n-1][0] = floor[n-1][0];
        seeds[0][0] = floor[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0 && j > 0) {
                    seeds[i][j] = floor[i][j] + Math.max(seeds[i][j - 1], seeds[i - 1][j]);
                } else if (i == 0 && j > 0) {
                    seeds[i][j] = floor[i][j] + seeds[i][j - 1];
                } else if (j == 0 && i > 0) {
                    seeds[i][j] = floor[i][j] + seeds[i - 1][j];
                }

            }
        }

        StringBuilder answer = new StringBuilder();
        int i = n - 1;
        int j = m - 1;
        while (i != 0 || j != 0) {
            if (i == 0) {
                answer.append("R");
                j--;
                continue;
            }

            if (j == 0) {
                answer.append("F");
                i--;
                continue;
            }

            if (seeds[i - 1][j] > seeds[i][j - 1]) {
                answer.append("F");
                i--;
            } else {
                answer.append("R");
                j--;
            }
        }

        System.out.println(answer.reverse().toString());


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
