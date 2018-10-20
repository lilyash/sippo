package com.examples.shuenbekova.sippo;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class FibonacciTest {
    private static final double d = 0.01;

    @Test
    public void getFib() {
        Fibonacci f = new Fibonacci(0);
        Assert.assertEquals(0, f.getFibaN());
        f = new Fibonacci(1);
        Assert.assertEquals(1, f.getFibaN());
        f = new Fibonacci(3);
        Assert.assertEquals(2, f.getFibaN());
        f = new Fibonacci(6);
        Assert.assertEquals(8, f.getFibaN());
        f = new Fibonacci(10);
        Assert.assertEquals(55, f.getFibaN());

    }

    @Test
    public void testOptimal() {
        Point2D p1 = new Point2D(0.3595, 0);
        Point2D p2 = new Point2D(0.3707, 0);
        Point2D res = Fibonacci.optimal(p1, p2, 1);
        Point2D res1 = new Point2D(0.357, Point2D.function(0.357));
        Assert.assertEquals(res.getX(), res1.getX(), d);
        Assert.assertEquals(res.getY(), res1.getY(), d);
    }

    @Test
    public void testRead() {
        Fibonacci fib = new Fibonacci();
        File reader = new File("Begin.txt");
        double arr[] = new double[3];
        int i = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(reader));
            String s;
            while ((s = in.readLine()) != null) {
                arr[i] = Double.parseDouble(s);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Point2D res = Fibonacci.optimal(new Point2D(arr[0], arr[1]), new Point2D(arr[2], arr[3]), 1);
        Point2D res1 = new Point2D(0.357, Point2D.function(0.357));
        Assert.assertEquals(res, res1);
    }
}