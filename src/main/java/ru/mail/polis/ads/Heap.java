package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * https://www.e-olymp.com/ru/problems/4039
 */
public final class Heap {

    private static int[] heap = new int[1_000_000];
    private static int n = 0;

    private Heap() {
        // Should not be instantiated
    }


    private static void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private static void siftUp(int k) {
        while (k > 1 && heap[k] > heap[k / 2]) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private static void siftDown(int k) {
        while (2 * k <= n) {
            int j = 2*k;
            if (j < n && heap[j] < heap[j+1]) {
                j++;
            }
            if (heap[k] >= heap[j]) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private static void insert(int v) {
        heap[++n] = v;
        siftUp(n);
    }

    private static int delMax() {
        int max = heap[1];
        swap(1, n--);
        siftDown(1);
        return max;
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        heap[0] = Integer.MAX_VALUE;
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int command = in.nextInt();
            if (command == 1) {
                out.println(delMax());
            } else if (command == 0) {
                int value = in.nextInt();
                insert(value);
            }
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