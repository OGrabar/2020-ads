package ru.mail.polis.ads;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Problem 4827.
 */
public final class KthElement {

    private KthElement() {
        // Should not be instantiated
    }

    private static int partition(BigInteger[] array, int left, int right) {
        BigInteger pivot = array[left];
        int i = left;
        int j = right;

        while (i <= j) {
            while (array[i].compareTo(pivot) < 0) {
                i++;
            }

            while (array[j].compareTo(pivot) > 0) {
                j--;
            }

            if (i >= j) {
                break;
            }
            BigInteger temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return j;
    }

    private static BigInteger findOrderStatistic(BigInteger[] array, int order) {
        int left = 0;
        int right = array.length - 1;

        while (true) {
            int mid = partition(array, left, right);
            if (mid == order) {
                return array[mid];
            } else if (order < mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
    }

    private static void solve(final FastScanner in, final PrintWriter out) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] stringHeights = br.readLine().split(" ");
        BigInteger[] heights = new BigInteger[stringHeights.length];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = new BigInteger(stringHeights[i]);
        }
        System.out.println(findOrderStatistic(heights, heights.length - k));
        br.close();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}