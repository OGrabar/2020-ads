package ru.mail.polis.ads;

import java.io.*;
import java.util.StringTokenizer;

;

/**
 * Problem 1462.
 */
public final class SimpleSort {

    private SimpleSort() {
        // Should not be instantiated
    }

    private static void merge(int[] numbers, int left, int mid, int right) {
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = numbers[left + i];
        }

        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = numbers[mid + i + 1];
        }

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = left; i < right + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    numbers[i] = leftArray[leftIndex++];
                } else {
                    numbers[i] = rightArray[rightIndex++];
                }
            } else if (leftIndex < leftArray.length) {
                numbers[i] = leftArray[leftIndex++];
            } else if (rightIndex < rightArray.length) {
                numbers[i] = rightArray[rightIndex++];
            }
        }
    }

    private static void mergeSort(int[] numbers, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            mergeSort(numbers, left, mid);
            mergeSort(numbers, mid + 1, right);
            merge(numbers, left, mid, right);
        }
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        mergeSort(numbers, 0, n - 1);
        for (int num : numbers) {
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