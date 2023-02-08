package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        PrimeNumber.calculateNPrimeNumberWithOutThreads(500000); // 100 000 000
        long endTime = System.currentTimeMillis();
        System.out.println("Le temps de d'exécution de la méthode sans threads est de : "  + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        PrimeNumber.calculateNPrimeNumberWithTwoThreads(500000);
        endTime = System.currentTimeMillis();
        System.out.println("Le temps d'exécution de la méthode avec deux threads est de : "  + (endTime - startTime) + "ms");
    }
}
