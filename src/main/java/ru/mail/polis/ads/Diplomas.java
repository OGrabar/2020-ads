package ru.mail.polis.ads;

import java.util.Scanner;

public class Dimplomas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int n = scanner.nextInt();

        long l = Math.max(w, h);
        long r = l * n;

        while (l < r) {
            long m = (l + r) / 2;
            long count = (m / w) * (m / h);
            if (n <= count) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        System.out.println(count);

    }

}
