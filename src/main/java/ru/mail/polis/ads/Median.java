package ru.mail.polis.ads;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * https://www.e-olymp.com/ru/problems/4074
 */
public final class Median {
    private Median() {
        // Should not be instantiated
    }

    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Integer::compareTo);
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> -a.compareTo(b));
    private static int countOfNumbers = 0;
    private static int median;
    private static BufferedWriter wirter = new BufferedWriter(new OutputStreamWriter(System.out));


    private static void solve(final FastScanner in, final PrintWriter out) throws IOException {
        median = Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                /*System.out.println("as");
                //System.out.println("Шаг " + countOfNumbers);*/
                int number = in.nextInt();
                countOfNumbers++;
                if (countOfNumbers % 2 == 0) {
                    if (number > median) {
                        minHeap.add(median);
                        maxHeap.add(number);
                    } else {
                        minHeap.add(number);
                        maxHeap.add(median);
                    }
                    median = (minHeap.peek() + maxHeap.peek()) / 2;
                } else {
                    if (number > median) {
                        maxHeap.add(number);
                        median = maxHeap.poll();
                    } else {
                        minHeap.add(number);
                        median = minHeap.poll();
                    }
                }
                out.println(median);

            }
        } catch (Exception e) {

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

    public static void main(final String[] arg) throws IOException {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
            wirter.flush();
        }
    }
}