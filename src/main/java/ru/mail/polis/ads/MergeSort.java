package ru.mail.polis.ads;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;;
import java.util.*;

/**
 * Problem 4037.
 */
public final class MergeSort {

    private MergeSort() {
        // Should not be instantiated
    }

    static class Robot implements Comparable {
        int firstNumber;
        int secondNumber;

        public Robot(int firstNumber, int secondNumber) {
            this.firstNumber = firstNumber;
            this.secondNumber = secondNumber;
        }

        @Override
        public int compareTo(@NotNull Object o) {
            if (!(o instanceof Robot)) {
                throw new ClassCastException();
            }

            Robot otherRobot = (Robot) o;
            return firstNumber > otherRobot.firstNumber  ? 1 : -1;
        }

        @Override
        public String toString() {
            return firstNumber + " " + secondNumber;
        }
    }

    private static void merge(Robot[] robots, int left, int mid, int right) {
        Robot[] rightArray = new Robot[right - mid];
        Robot[] leftArray = new Robot[mid - left + 1];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = robots[left + i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = robots[mid + i + 1];
        }

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = left; i < right + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) <= 0) {
                    robots[i] = leftArray[leftIndex++];
                } else {
                    robots[i] = rightArray[rightIndex++];
                }
            } else if (leftIndex < leftArray.length) {
                robots[i] = leftArray[leftIndex++];
            } else if (rightIndex < rightArray.length) {
                robots[i] = rightArray[rightIndex++];
            }
        }
    }

    private static void robotsMergeSort(Robot[] robots, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            robotsMergeSort(robots, left, mid);
            robotsMergeSort(robots, mid + 1, right);
            merge(robots, left, mid, right);
        }
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        Robot[] robots = new Robot[n];

        int firstNumber;
        int secondNumber;
        for (int i = 0; i < n; i++) {
            firstNumber = in.nextInt();
            secondNumber = in.nextInt();
            robots[i] = new Robot(firstNumber, secondNumber);
        }

        robotsMergeSort(robots, 0, n - 1);
        for (Robot robot : robots) {
            System.out.println(robot);
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