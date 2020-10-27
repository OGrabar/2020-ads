package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;;
import java.util.StringTokenizer;

/**
 * https://www.e-olymp.com/ru/problems/1618
 */
public final class LCS {

    private LCS() {
        // Should not be instantiated
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int m = in.nextInt();
        int[] x = new int[m];
        for (int i = 0; i < m; i++) {
            x[i] = in.nextInt();
        }
        int n = in.nextInt();
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            y[i] = in.nextInt();
        }

        int[][] lcs = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n+1; j++) {
                if(i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else if (x[i-1] == y[j-1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        System.out.println(lcs[m][n]);

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
