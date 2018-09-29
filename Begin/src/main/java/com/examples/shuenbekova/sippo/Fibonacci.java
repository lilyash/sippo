package com.examples.shuenbekova.sippo;

public class Fibonacci {
    private int N;
    private int fibaN, fibaA, fibaB;

    public Fibonacci(int n) {
        N = n;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public Fibonacci(int n, int fibaN, int fibaA, int fibaB) {
        N = n;
        this.fibaN = fibaN;
        this.fibaA = fibaA;
        this.fibaB = fibaB;
    }

    public int fiba(int N) {
        if (N == 0 || N == 1) {
            return N;
        } else {
            fibaA = fiba(N - 1);
            fibaB = fiba(N - 2);
            return fibaN = fibaA + fibaB;
        }
    }

    public Point2D optimal(Point2D one, Point2D too, int N) {
        double a = one.getX();
        double b = too.getX();
        double x, y;
        double x1, x2;
        System.out.println("N = " + N);
        System.out.println("a = " + a + ", b = " + b);
        while (true) {
            x1 = (a + (b - a) * (fibaB / fibaN));
            x2 = (a + (b - a) * (fibaA / fibaN));

            if (N == N - 1) {
                if (Point2D.function(x1) < Point2D.function(x2)) {
                    b = x2;
                    x2 = x1;
                    x1 = a + (b - x2);
                } else {
                    a = x1;
                    x1 = x2;
                    x2 = b - (x1 - a);
                }
            }

            if (N == 1) {
                x = x1;
                x = x2;
                break;
            }
        }
        x = (a + b) / 2;
        y = Point2D.function(x);
        return new Point2D(x,y);
    }
}
