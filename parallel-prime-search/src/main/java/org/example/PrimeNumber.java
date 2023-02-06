package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

    private static final List<Integer> listOfPrimeNumber = new ArrayList<>();

    private PrimeNumber() {}
    private static boolean isPrime(int premierNumber) {

        // Cas illégaux
        if (premierNumber < 2) {
            return false;
        }

        // Cas pair
        if (premierNumber % 2 == 0 && premierNumber != 2) {
            return false;
        }

        // Cas impair
        for (int diviseur = 3; diviseur <= Math.sqrt(premierNumber); diviseur+=2) {
            if (premierNumber % diviseur == 0 && premierNumber != diviseur) {
                return false;
            }
        }

        return true;
    }

    private static void calculatePrimeWithRange(int start, int end) {
        for (int i = start; i < end; i++) {
            if (isPrime(i)) {
                synchronized (listOfPrimeNumber) {
                    listOfPrimeNumber.add(i);
                }
            }
        }
    }

    public static List<Integer> calculateNPrimeNumberWithOutThreads(int n) {
        List<Integer> listOfPrimeNumber = new ArrayList<>();

        for (int i = 2; i<n ; i++) {
            if(isPrime(i)) {
                listOfPrimeNumber.add(i);
            }
        }

        return listOfPrimeNumber;
    }

    public static List<Integer> calculateNPrimeNumberWithTwoThreads(int n) throws InterruptedException {
        listOfPrimeNumber.clear();
        Thread t1 = new Thread(() -> calculatePrimeWithRange(2, n / 2));
        Thread t2 = new Thread(() -> calculatePrimeWithRange(n / 2, n));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return listOfPrimeNumber;
    }
}
