package com.examples.shuenbekova.sippo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fibonacci {
    public Fibonacci() {
        this.fibaN = fibaN;
        this.fibaA = fibaA;
        this.fibaB = fibaB;
    }

    private int fibaN, fibaA, fibaB;

    private int fiba(int N) {
        int fibaA, fibaB;
        if (N < 2) {
            return N;
        } else {
            fibaA = fiba(N - 1);
            fibaB = fiba(N - 2);
            return (fibaA + fibaB);
        }
    }

    public Fibonacci(int n) {
        if (n < 2) {
            fibaA = 0;
            fibaB = 0;
            fibaN = n;
        } else {
            fibaA = fiba(n - 1);
            fibaB = fiba(n - 2);
            fibaN = fibaA + fibaB;
        }
    }

    public int getFibaN() {
        return fibaN;
    }

    public int getFibaA() {
        return fibaA;
    }

    public int getFibaB() {
        return fibaB;
    }

    public static Point2D optimal(Point2D one, Point2D too, int N) {
        Point2D z;
        double a = one.getX();
        double b = too.getX();
        double x, y;
        double x1, x2, y1, y2;
        int n = N;
        System.out.println("N = " + N);
        System.out.println("a = " + a + ", b = " + b);
        Fibonacci fN = new Fibonacci(n);
        x1 = (a + ((b - a) * ((double) fN.getFibaB() / (double) fN.getFibaN())));
        x2 = (a + ((b - a) * ((double) fN.getFibaA() / (double) fN.getFibaN())));
        y1 = Point2D.function(x1);
        y2 = Point2D.function(x2);
        while (n > 0 && x1 != x2) {
            n--;
            if (n == n - 1) {
                if (y1 < y2) {
                    a = x1;
                    x1 = x2;
                    x2 = b - x1 + a;
                    y1 = y2;
                    y2 = Point2D.function(x2);
                } else {
                    b = x2;
                    x2 = x1;
                    x1 = a + b - x2;
                    y2 = y1;
                    y1 = Point2D.function(x1);
                }
            }
        }
        x = (x2);
        y = Point2D.function(x);
        System.out.println(new Point2D(x, y));
        return new Point2D(x, y);

    }

    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество итераций. По умолчанию = 1");
        int n = in.nextInt();
        System.out.println("Введите левую границу");
        double a = in.nextDouble();
        System.out.println("Введите правую границу");
        double b = in.nextDouble();
        System.out.println("Готово!");
    }

   /* public static void main() throws FileNotFoundException{
        File reader = new File("Begin.txt");
        Scanner scanner;
        try{
            scanner = new Scanner(reader);
            while (scanner.hasNextLine()){
                int i = scanner.nextInt();
                System.out.println(i);
            }
           scanner.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }*/
}
