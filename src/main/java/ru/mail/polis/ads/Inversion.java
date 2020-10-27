package ru.mail.polis.ads;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Inversion {

    static long inversion = 0;

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
                if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                    numbers[i] = leftArray[leftIndex++];
                } else {
                    numbers[i] = rightArray[rightIndex++];
                    inversion += leftArray.length - leftIndex;
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        mergeSort(numbers, 0, n - 1);
        System.out.println(inversion);
    }
}
