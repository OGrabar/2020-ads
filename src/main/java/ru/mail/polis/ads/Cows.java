package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * https://www.e-olymp.com/ru/problems/5149
 */
public final class Cows {
    private Cows() {
        // Should not be instantiated
    }

    private static boolean check(int[] stables, int countOfCows, int distance) {
        int cowsInStable = 1;
        int lastStableWithCow = stables[0];
        for (Integer currentStable : stables) {
            if (currentStable - lastStableWithCow >= distance) {
                lastStableWithCow = currentStable;
                cowsInStable++;
            }
        }
        return cowsInStable >= countOfCows;
    }

        private static void solve ( final FastScanner in, final PrintWriter out){
            int countOfStables = in.nextInt();
            int countOfCows = in.nextInt();
            int[] stables = new int[countOfStables];
            for (int i = 0; i < countOfStables; i++) {
                stables[i] = in.nextInt();
            }
            int left = 0;
            int right = stables[stables.length - 1] - stables[0] + 1;
            while (right - left > 1) {
                int mid = (left + right) / 2;
                if (check(stables, countOfCows, mid)) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            System.out.println(left);
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

        public static void main ( final String[] arg){
            final FastScanner in = new FastScanner(System.in);
            try (PrintWriter out = new PrintWriter(System.out)) {
                solve(in, out);
            }
        }
    }