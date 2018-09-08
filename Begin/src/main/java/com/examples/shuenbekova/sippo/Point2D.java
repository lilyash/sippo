package com.examples.shuenbekova.sippo;

import java.util.Objects;

public class Point2D {
    private int x,y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(){
        this.x = 0;
        this.y = 0;
        }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point2D)) return false;
        Point2D point2D = (Point2D) o;
        return x == point2D.x &&
                y == point2D.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }

    public void print(){
        System.out.print("x= "+ x);
        System.out.print("y= "+ y);
    }
}